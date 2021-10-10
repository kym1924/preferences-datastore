<div>
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat&logo=Android&logoColor=white" />
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=Kotlin&logoColor=white" />
<img src="https://img.shields.io/badge/writer-kym1924-yellow?&style=flat&logo=Android"/>
</div>

# Preferences DataStore
<br>
<img width=360 height=760 src="https://user-images.githubusercontent.com/63637706/136686692-0fb689e7-d858-443c-8ca0-448397f313e2.gif"/>

### DataStore
- Uses Kotlin coroutines and Flow to store data asynchronously. 
<img width=70% height=70% src="https://user-images.githubusercontent.com/63637706/136683613-12f90725-5b89-41a7-ab8b-4b65ef6ea180.png"/>

### Preferences DataStore
- Stores and accesses data using keys.
- Implementation uses the DataStore and Preferences classes to persist simple key-value pairs.

### Preferences.Key
- Type T is the type of the value associated with the Key. 
- T must be one of the following : *Boolean, Int, Long, Float, String, Set.*
<br>

#### 1. Initialize
```groovy
// build.gradle in Module
implementation "androidx.datastore:datastore-preferences:1.0.0"
```
<br>

#### 2. Declaration
```kotlin
// Declare at the top of any Kotlin file to manage DataStore to singleton
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Your DataStore's Name")
```
<br>

#### 3. Read from DataStore
```kotlin
val MEMO_KEY = stringPreferencesKey("memo")
private fun getMemoFlow() = dataStore.data
	.map { preferences ->
          preferences[MEMO_KEY] ?: ""
}
```
<br>

#### 4. Write to DataStore
```kotlin
suspend fun setMemo(memo: String) {
	dataStore.edit { settings ->
		settings[MEMO_KEY] = memo
	}
}
```
<br>

##### Reference
- https://developer.android.com/topic/libraries/architecture/datastore
- https://android-developers.googleblog.com/2020/09/prefer-storing-data-with-jetpack.html
