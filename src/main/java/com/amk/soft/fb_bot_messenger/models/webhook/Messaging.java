package com.amk.soft.fb_bot_messenger.models.webhook;

import com.amk.soft.fb_bot_messenger.models.common.Recipient;

/**
 * Created by AMK003 on 4/14/16.
 */
public class Messaging {
    public Sender sender;
    public Recipient recipient;
    public String timeStamp;
    public Message message;
    public Postback postback;
    public Delivery delivery;
}
