package com.hyurumi.fb_bot_boilerplate.models.webhook;

import com.hyurumi.fb_bot_boilerplate.models.common.Recipient;

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
