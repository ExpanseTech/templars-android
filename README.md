# Templars

This library is a simple integration of [Templars](https://templars.netlify.app/) for android applications.

## Installation

Use [jitpack](https://jitpack.io/) to add [Templars](https://templars.netlify.app/) as shown follows.

Add the line below in your project's ```build.gradle```
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```


Add the line below in your app's ```build.gradle```
```gradle
dependencies {
    implementation 'com.github.ExpanseTech:templars-android:v1.1.4'
}
```

## Usage

```kotlin
val templars = Templars("<API-KEY>")

templars.getLawyerCategories {
    it.onSuccess { resp ->
        Log.d(TAG, "Lawyer Categories: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Lawyer Categories Error: ${err.localizedMessage}")
    }
}

templars.getRegistrationCategories {
    it.onSuccess { resp ->
        Log.d(TAG, "Registration Categories: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Registration Categories Error: ${err.localizedMessage}")
    }
}

templars.getRegistration("REGISTRATION ID") {
    it.onSuccess { resp ->
        Log.d(TAG, "Registration: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Registration Error: ${err.localizedMessage}")
    }
}

templars.getRegistrations {
    it.onSuccess { resp ->
        Log.d(TAG, "Registrations: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Registrations Error: ${err.localizedMessage}")
    }
}

templars.getSession("SESSION ID") {
    it.onSuccess { resp ->
        Log.d(TAG, "Session: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Session Error: ${err.localizedMessage}")
    }
}

templars.getSessions {
    it.onSuccess { resp ->
        Log.d(TAG, "Sessions: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Sessions Error: ${err.localizedMessage}")
    }
}

templars.rescheduleSession("SESSION ID", date, count) {
    it.onSuccess { resp ->
        Log.d(TAG, "Update Session: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Update Session Error: ${err.localizedMessage}")
    }
}

templars.getDocumentCategories {
    it.onSuccess { resp ->
        Log.d(TAG, "Document Categories: ${resp?.data?.size}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Document Categories Error: ${err.localizedMessage}")
    }
}

templars.getDocument("DOCUMENT ID") {
    it.onSuccess { resp ->
        Log.d(TAG, "Document: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Document Error: ${err.localizedMessage}")
    }
}

templars.getDocuments {
    it.onSuccess { resp ->
        Log.d(TAG, "Documents: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Documents Error: ${err.localizedMessage}")
    }
}

templars.getDocumentCategory("DOCUMENT CATEGORY ID") {
    it.onSuccess { resp ->
        Log.d(TAG, "Documents Category: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Documents Category: ${err.localizedMessage}")
    }
}

templars.updateDocument("DOCUMENT ID", fields) {
    it.onSuccess { resp ->
        Log.d(TAG, "Update Document: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Update Document: ${err.localizedMessage}")
    }
}


/**
 * Create Session Model
 *
 * @property title
 * @property description
 * @property startDate
 * @property count
 * @property type
 * @property customerReference
 * @property lawyerCategoryId
 */
class CreateSession(
    val title: String,
    val description: String,
    val startDate: Date,
    var count: Int,
    var type: SessionType,
    val customerReference: String,
    val lawyerCategoryId: String,
){
    
    enum class SessionType{
        AUDIO, VIDEO, CHAT
    }
}

val session = CreateSession(
    "SESSION TITLE",
    "DESCRIPTION",
    date,
    count, 
    sessionType,
    "EMAIL ADDRESS",
    "LAWYER CATEGORY ID"
)

templars.createSession(session) {
    it.onSuccess { resp ->
        Log.d(TAG, "Session: ${resp.data}")
    }
    it.onFailure { err ->
        Log.d(TAG, "Session Error: ${err.localizedMessage}")
    }
}


/**
 * Create Registration Model
 *
 * @property fields
 * @property draft
 * @property customerReference
 * @property categoryId
 */
class CreateRegistration (
    val fields: String,
    val draft: Boolean = true,
    val customerReference: String,
    val categoryId: String
)

val registration = CreateRegistration(
    "FIELDS", 
    draft,
    "EMAIL ADDRESS",
    "REGISTRATION CATEGORY ID"
)

templars.createRegistration(registration) {
    it.onSuccess { resp ->
        Log.d(TAG, "Registration: ${resp.data}")
    }
    it.onFailure { err ->
        Log.d(TAG, "Registration Error: ${err.localizedMessage}")
    }
}


/**
 * Create Document Model
 *
 * @property name
 * @property draft
 * @property fields
 * @property customerReference
 * @property categoryId
 */
class CreateDocument (
    val name: String,
    val draft: Boolean,
    val fields: List<Field>,
    val customerReference: String,
    val categoryId: String
)

val document = CreateDocument(
    "DOCUMENT NAME",
    draft,
    fields,
    "EMAIL ADDRESS",
    "DOCUMENT CATEGORY ID"
)

templars.createDocument(document) {
    it.onSuccess { resp ->
        Log.d(TAG, "Document: ${resp.data}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Document Error: ${err.localizedMessage}")
    }
}
```


## License
[MIT](https://choosealicense.com/licenses/mit/)
