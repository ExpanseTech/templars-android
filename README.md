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
val templars = templars = Templars("<API-KEY>")

templars.getDocuments {
    it.onSuccess { resp ->
        Log.d(TAG, "Documents: ${resp.data.size}")
     }

     it.onFailure { err ->
         Log.d(TAG, "Documents Error: ${err.localizedMessage}")
     }
}

templars.getLawyerCategories {
    it.onSuccess { resp ->
        Log.d(TAG, "Lawyer Categories: ${resp.data?.size}")
    }

    it.onFailure { err ->
        Log.d(TAG, "Lawyer Categories Error: ${err.localizedMessage}")
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
```


## License
[MIT](https://choosealicense.com/licenses/mit/)
