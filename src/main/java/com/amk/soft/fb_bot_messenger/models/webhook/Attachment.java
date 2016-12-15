package com.amk.soft.fb_bot_messenger.models.webhook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AMK003 on 4/23/16.
 */
public class Attachment {
    public enum Type {
        @SerializedName("audio")
        AUDIO,
        @SerializedName("image")
        IMAGE,
        @SerializedName("video")
        VIDEO
    }

    public Type type;
    public Payload payload;
}
