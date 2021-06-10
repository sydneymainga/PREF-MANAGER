package com.example.sydneyuser.utils

import android.content.Context
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*

import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//https://www.youtube.com/watch?v=0J5GXuGD61E&t=616s

class PrefManager(private val context: Context) {
    companion object {

        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "UserDetails")
        private val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
        private val USER_EMAIL_KEY = stringPreferencesKey("USER_GENDER")
        // private val USER_AGE_KEY = intPreferencesKey("USER_AGE")

    }


    //Store user data
    // suspend fun storeUser(email: String, name: String/*, isMale: Boolean*/) {
    suspend fun storeUser(email: String, name: String) {
        context.dataStore.edit { it[USER_NAME_KEY] = name }
        context.dataStore.edit { it[USER_EMAIL_KEY] = email }
        //context.dataStore.edit { it[USER_GENDER_KEY] = isMale }
    }



    /**Get username**/
    val getUsername: Flow<String>
        get() = context.dataStore.data.map {
            it[USER_NAME_KEY] ?: ""
        }

    /*val userAgeFlow: Flow<Int>
    get() = context.dataStore.data.map {
        val age = it[USER_AGE_KEY] ?: 0

        if (age < 18) {
            Toast.makeText(context, "The user is under 18", Toast.LENGTH_SHORT).show()
        }
        age
    }*/
    /**get userEmail**/
    val getUseremail: Flow<String>
        get() = context.dataStore.data.map {
            it[USER_EMAIL_KEY] ?: ""
        }


    /*//Create the dataStore
    private val dataStore = context.createDataStore(name = "user_prefs")

    //Create some keys
    companion object {
        //val USER_AGE_KEY = preferencesKey<Int>("USER_AGE")
        val USER_AGE_KEY = "USER_AGE"
        val USER_NAME_KEY = "USER_NAME"
        val USER_GENDER_KEY = "USER_GENDER"
    }

    //Store user data
    suspend fun storeUser(age: Int, name: String, isMale: Boolean) {
        dataStore.edit {
            it[USER_AGE_KEY] = age
            it[USER_NAME_KEY] = name
            it[USER_GENDER_KEY] = isMale
        }
    }

    //Create an age flow
    val userAgeFlow: Flow<Int> = dataStore.data.map {
        val age = it[USER_AGE_KEY] ?: 0

        if (age < 18) {
            Toast.makeText(context, "The user is under 18", Toast.LENGTH_SHORT).show()
        }
        age
    }

    //Create a name flow
    val userNameFlow: Flow<String> = dataStore.data.map {
        it[USER_NAME_KEY] ?: ""
    }

    //Create a gender flow
    val userGenderFlow: Flow<Boolean> = dataStore.data.map {
        it[USER_GENDER_KEY] ?: false
    }

*/
}
