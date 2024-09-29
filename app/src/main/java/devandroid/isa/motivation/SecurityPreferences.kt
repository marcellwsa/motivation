package devandroid.isa.motivation

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val secutiry: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        secutiry.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        //ELVIS: se a primeira expressao for nulo, passa o que estiver depois.
        return secutiry.getString(key, "") ?: ""
    }

}