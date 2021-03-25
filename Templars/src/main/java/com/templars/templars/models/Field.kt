package com.templars.templars.models

import com.google.gson.Gson
import com.templars.templars.utils.DateValidator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

public class Template(val title: String,
                      val createdAt: String,
                      val nodes: List<Field>?,
                      val orphans: List<Field>?,)

//fun Field(id: String, text: String?) = Field(text: "")

//fun Field(id: String, text: String?) = Field(text, null, null, null,
//    null, null, null, id, null, null, null,
//    null)

fun Field(id: String, text: String, dataType: Field.DataType, dateTimeFormat: String? = null) = Field(text,
    null, dataType, null, null, null, null, id,
    null, null, dateTimeFormat, null)

class Field(var text: String?,
            var type: String?,
            var dataType: DataType?,
            var defaultValue: String?,
            var label: String?,
            var children: List<Field>?,
            var editable: Boolean?,
            var id: String?,
            var options: List<Option>?,
            var isOrphan: Boolean?,
            var dateTimeFormat: String?,
            var valueRef: String?)
{
    class Option(val id: String,
                 val label: String)

    enum class DataType {
        text, options, radio, time, date, image
    }

    fun isValid(): Boolean {
        if (!dateTimeFormat.isNullOrEmpty() && !text.isNullOrEmpty() && dataType != null){
            if (dataType == DataType.date){
                val dateValidator = DateValidator(dateTimeFormat!!)
                return  dateValidator.isValid(text!!)
            }
        }
        return true
    }

    companion object{
        fun getEditableFields(fields: List<Field>): List<Field>{
            var form: ArrayList<Field> = ArrayList()
            for (field in fields){
                if (field.children != null) {
                    if (field.children!!.isNotEmpty()){

                        if (field.editable != null){
                            if (field.editable == true){
                               form.add(field)
                            }
                        }
                        form.addAll(getEditableFields(field.children!!))
                    }
                }else{
                    if (field.editable != null){
                        if (field.editable == true){
                            form.add(field)
                        }
                    }
                }

            }
            return form
        }

        private fun getDictionary(fields: List<Field>): HashMap<String, String>{
            var map = HashMap<String, String>()
            for (field in fields){
                if (field.id != null && field.text != null){
                    map[field.id!!] = field.text!!
                }
            }
            return map
        }

        fun getJsonString(fields: List<Field>): String{
            val dict = getDictionary(fields)
            return Gson().toJson(dict).toString();
        }

        fun isListValid(fields: List<Field>): Pair<Boolean, String?>{
            fields.forEach{ field ->
                if (!field.isValid()){
                    return  Pair(false, "${field.id}: format is not valid")
                }
            }
            return  Pair(true, null)
        }
    }
}
