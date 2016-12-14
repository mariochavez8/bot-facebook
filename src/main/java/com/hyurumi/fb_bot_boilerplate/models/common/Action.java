package com.hyurumi.fb_bot_boilerplate.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by genki.furumi on 4/18/16.
 */
public enum Action {
    @SerializedName("Preguntas")
    ACTION_A,
    @SerializedName("Entretenimiento")
    ACTION_B,
    @SerializedName("Compras")
    ACTION_C
}

