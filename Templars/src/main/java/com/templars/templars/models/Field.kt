package com.templars.templars.models

import com.google.gson.Gson
import com.templars.templars.utils.DateValidator

data class Template(
    val title: String,
    val createdAt: String,
    val nodes: List<Field>?,
    val orphans: List<Field>?
)

fun Field(id: String, text: String, dataType: Field.DataType, dateTimeFormat: String? = null) =
    Field(
        text,
        null,
        dataType,
        null,
        null,
        null,
        null,
        id,
        null,
        null,
        dateTimeFormat,
        null
    )

data class Field(
    val text: String?,
    val type: String?,
    val dataType: DataType?,
    val defaultValue: String?,
    val label: String?,
    val children: List<Field>?,
    val editable: Boolean?,
    val id: String?,
    val options: List<Option>?,
    val isOrphan: Boolean?,
    val dateTimeFormat: String?,
    val valueRef: String?
) {

    data class Option(
        val id: String,
        val label: String
    )

    enum class DataType {
        text, options, radio, time, date, image
    }

    fun isValid(): Boolean {
        if (!dateTimeFormat.isNullOrEmpty() && !text.isNullOrEmpty() && dataType != null) {
            if (dataType == DataType.date) {
                val dateValidator = DateValidator(dateTimeFormat)
                return dateValidator.isValid(text)
            }
        }
        return true
    }

    companion object {

        fun getEditableFields(fields: List<Field>): List<Field> {
            val form: ArrayList<Field> = ArrayList()
            for (field in fields) {
                if (field.children != null) {
                    if (field.children.isNotEmpty()) {

                        if (field.editable != null) {
                            if (field.editable == true) {
                                form.add(field)
                            }
                        }
                        form.addAll(getEditableFields(field.children))
                    }
                } else {
                    if (field.editable != null) {
                        if (field.editable == true) {
                            form.add(field)
                        }
                    }
                }

            }
            return form
        }

        private fun getDictionary(fields: List<Field>): HashMap<String, String> {
            val map = HashMap<String, String>()
            for (field in fields) {
                if (field.id != null && field.text != null) {
                    map[field.id] = field.text
                }
            }
            return map
        }

        fun getJsonString(fields: List<Field>): String {
            val dict = getDictionary(fields)
            return Gson().toJson(dict).toString()
        }

        fun isListValid(fields: List<Field>): Pair<Boolean, String?> {
            fields.forEach { field ->
                if (!field.isValid()) {
                    return Pair(false, "${field.id}: format is not valid")
                }
            }
            return Pair(true, null)
        }
    }
}