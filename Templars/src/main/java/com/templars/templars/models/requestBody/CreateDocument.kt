package com.templars.templars.models.requestBody

import com.templars.templars.models.Field
import java.util.*

/**
 * Create Document Model
 *
 * @property name
 * @property draft
 * @property fields
 * @property customerReference
 * @property categoryId
 */
public class CreateDocument (
    val name: String,
    val draft: Boolean,
    val fields: List<Field>,
    val customerReference: String,
    val categoryId: String
)

internal class CreateDocument2(
    val name: String,
    val draft: Boolean,
    val fieldList: List<Field>,
    val customerReference: String,
    val categoryId: String
){
    val fields: String
    init {
       fields = Field.getJsonString(fieldList)
    }
}