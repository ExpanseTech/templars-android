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
	        implementation 'com.github.ExpanseTech:templars-android:v1.1'
	}
```

## Usage
Add the line below in your app's ```build.gradle```
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
```


## License
[MIT](https://choosealicense.com/licenses/mit/)
