package com.amk.soft.fb_bot_messenger.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AMK003 on 4/18/16.
 */
public enum Action {
    @SerializedName("USER_DEFINED_PAYLOAD")
    USER_DEFINED_PAYLOAD,
    @SerializedName("Preguntas")
    ACTION_PREGUNTAS,
    @SerializedName("Entretenimiento")
    ACTION_ENTRETENIMIENTO,
    @SerializedName("Compras")
    ACTION_COMPRAS,
    //Preguntas
    @SerializedName("Trivias")
    ACTION_TRIVIAS,
    @SerializedName("Encuentas")
    ACTION_ENCUESTAS
    //Entretenimiento
}

