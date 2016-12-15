package com.amk.soft.fb_bot_messenger.models.send;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AMK003 on 4/23/16.
 */
public class Response {
    @SerializedName("recipient_id")
    String recipientId;
    @SerializedName("message_id")
    String messageId;
}
