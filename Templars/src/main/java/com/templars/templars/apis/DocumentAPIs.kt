package com.templars.templars.apis

import com.templars.templars.apis.`interface`.DocumentService
import com.templars.templars.models.*
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.UpdateDocument
import com.templars.templars.utils.enqueue

class DocumentAPIs(private val apiKey: String) {

    private val documentService = DocumentService.instance

    fun getDocument(id: String, callback: (Result<ResponseBody<Document>>) -> Unit){
        val doc = documentService.getDocument(apiKey, id)
        doc.enqueue(callback)
    }

    fun getDocuments(draft: Boolean, page: Int, pageSize: Int, sortBy: SortBy, callback: (Result<ResponseBody<List<Document>>>) -> Unit){
        val docsCall = documentService.getDocuments(apiKey, draft, page, pageSize, sortBy.toString())
        docsCall.enqueue(callback)
    }

    fun getDocumentCategories(callback: (Result<ResponseBody<List<DocumentCategory>>?>) -> Unit){
        val docCategoryCall = documentService.getDocumentCategories(apiKey)
        docCategoryCall.enqueue(callback)
    }

    fun getDocumentCategory(id: String, callback: (Result<ResponseBody<DocumentCategory>>) -> Unit){
        val docCategoryCall = documentService.getDocumentCategory(apiKey, id);
        docCategoryCall.enqueue(callback)
    }

    fun createDocument(document: CreateDocument, callback: (Result<ResponseBody<Document>>) -> Unit){

        //check validity of fields
        val (isValid, message) = Field.isListValid(document.fields)
        if (!isValid){
            val result =  Result.failure<ResponseBody<Document>>(Throwable(message, null))
            callback(result)
        }

        val docCall = documentService.createDocument(apiKey, document)
        docCall.enqueue(callback)
    }

    fun updateDocument(id: String, fields: List<Field>, callback: (Result<ResponseBody<Document>>) -> Unit){

        //check validity of fields
        val (isValid, message) = Field.isListValid(fields)
        if (!isValid){
            val result =  Result.failure<ResponseBody<Document>>(Throwable(message, null))
            callback(result)
        }

        val fieldsString: String = Field.getJsonString(fields)
        val document = UpdateDocument(fieldsString)
        val docCall = documentService.updateDocument(apiKey, id, document)
        docCall.enqueue(callback)
    }
}





