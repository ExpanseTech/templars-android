package com.templars.templars.apis

import com.templars.templars.apis.`interface`.DocumentService
import com.templars.templars.models.Document
import com.templars.templars.models.DocumentCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.SortBy
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

    fun createDocument(document: CreateDocument, callback: (Result<ResponseBody<Document>>) -> Unit){
        val docCall = documentService.createDocument(apiKey, document)
        docCall.enqueue(callback)
    }

    fun updateDocument(id: String, fields: String, callback: (Result<ResponseBody<Document>>) -> Unit){
        val document = UpdateDocument(fields)
        val docCall = documentService.updateDocument(apiKey, id, document)
        docCall.enqueue(callback)
    }
}





