package com.example.nytimesmostpopulararticles.utils

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import java.lang.reflect.Type

class GsonBooleanTypeAdapter : JsonDeserializer<Boolean> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Boolean? {
        if ((json as JsonPrimitive).isBoolean) {
            return json.getAsBoolean()
        }
        return deSerializeBoolean(json)
    }

    private fun deSerializeBoolean(json: JsonPrimitive): Boolean? {
        if (json.isString) {
            val jsonValue = json.asString
            return when {
                jsonValue.equals("true", ignoreCase = true) -> {
                    true
                }
                jsonValue.equals("false", ignoreCase = true) -> {
                    false
                }
                else -> {
                    null
                }
            }
        }
        return when (json.asInt) {
            0 -> false
            1 -> true
            else -> null
        }
    }
}
