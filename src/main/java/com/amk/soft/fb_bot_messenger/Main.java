package com.amk.soft.fb_bot_messenger;

import com.google.gson.Gson;
import com.amk.soft.fb_bot_messenger.models.common.Action;
import com.amk.soft.fb_bot_messenger.models.send.Button;
import com.amk.soft.fb_bot_messenger.models.send.Element;
import com.amk.soft.fb_bot_messenger.models.send.Message;
import com.amk.soft.fb_bot_messenger.models.webhook.Messaging;
import com.amk.soft.fb_bot_messenger.models.webhook.ReceivedMessage;
import java.util.ArrayList;
import okhttp3.*;

import java.util.List;
import java.util.Random;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

public class Main {

    public static String sAccessToken;
    private static String sValidationToken;
    public static final String END_POINT;
    public static final MediaType JSON;
    private static final Random sRandom;
    private static final Gson GSON;

    static {
        JSON = MediaType.parse("application/json; charset=utf-8");
        END_POINT = "https://graph.facebook.com/v2.6/me/messages";
        GSON = new Gson();
        sRandom = new Random();
        sAccessToken = System.getenv("ACCESS_TOKEN");
        sValidationToken = "test1";
    }

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));

        get("/webhook", (request, response) -> {
            if (request.queryMap("hub.verify_token").value().equals(sValidationToken)) {
                return request.queryMap("hub.challenge").value();
            }
            return "Error, wrong validation token";
        });

        post("/webhook", (request, response) -> {
            ReceivedMessage receivedMessage = GSON.fromJson(request.body(), ReceivedMessage.class);
            List<Messaging> messagings = receivedMessage.entry.get(0).messaging;
            for (Messaging messaging : messagings) {
                String senderId = messaging.sender.id;
                if (messaging.message != null) {
                    sendMenuMessage(senderId,
                            "Menu...", generateMenuMessage());
                } else if (messaging.postback.payload != null) {
                    switch (messaging.postback.payload) {
                        case USER_DEFINED_PAYLOAD:
                            sendMenuMessage(senderId,
                                    "Hola!! Listo para comenzar la aventura? De "
                                    + "favor escoge que quieres hacer.",
                                    generateMenuMessage());
                            break;
                        case ACTION_PREGUNTAS:
                            sendMenuMessage(senderId,
                                    "Tenemos para ti las mejores trivias y encuestas.",
                                    generateMenuPreguntas());
                            break;
                        case ACTION_ENTRETENIMIENTO:
                            Message.Text("Entretenimiento").sendTo(senderId);
                            break;
                        case ACTION_COMPRAS:
                            Message.Text("Compras").sendTo(senderId);
                            break;
                        case ACTION_TRIVIAS:
                            Message.Text("Trivias").sendTo(senderId);
                            break;
                        case ACTION_ENCUESTAS:
                            Message.Text("Encuentas").sendTo(senderId);
                            break;
                    }
                } else if (messaging.delivery != null) {
                    Message.Text("3").sendTo(senderId);
                    // when the message is delivered, this webhook will be triggered.
                } else {
                    Message.Text("4").sendTo(senderId);
                    // sticker may not be supported for now.
                    System.out.println(request.body());
                }
            }
            return "";
        });
    }

    static private void sendMenuMessage(String senderId, String msj, List<Button> lst) throws Exception {
        Message message = Message.Button(msj);
        lst.stream().forEach((btn) -> {
            message.addButton(btn);
        });
        message.sendTo(senderId);
    }
    
    static private List<Button> generateMenuMessage() {
        List<Button> lst = new ArrayList<>();
        lst.add(Button.Postback("Preguntas", Action.ACTION_PREGUNTAS));
        lst.add(Button.Postback("Entretenimiento", Action.ACTION_ENTRETENIMIENTO));
        lst.add(Button.Postback("Compras", Action.ACTION_COMPRAS));
        return lst;
    }
    
    static private List<Button> generateMenuPreguntas() {
        List<Button> lst = new ArrayList<>();
        lst.add(Button.Postback("Trivias", Action.ACTION_TRIVIAS));
        lst.add(Button.Postback("Encuestas", Action.ACTION_ENCUESTAS));
        return lst;
    }

    static private void sendSamplePostBackMessage(String senderId) throws Exception {
        Message message = Message.Button("This is a postback message; please choose the action below");
        message.addButton(Button.Postback("action A", Action.ACTION_PREGUNTAS));
        message.addButton(Button.Postback("action B", Action.ACTION_ENTRETENIMIENTO));
        message.addButton(Button.Url("open Google", "https://google.com"));
        message.sendTo(senderId);
    }

    static private void sendSampleGenericMessage(String senderId) throws Exception {
        Message message = Message.Generic();
        Element element = new Element("Generic Message Sample", "https://unsplash.it/764/400?image=400", "subtitle");
        message.addElement(element);
        element = new Element("Yay Yay", "https://unsplash.it/764/400?image=500", "subtitle");
        element.addButton(Button.Postback("action A", Action.ACTION_PREGUNTAS));
        element.addButton(Button.Url("jump to FB", "https://facebook.com/"));
        message.addElement(element);
        message.sendTo(senderId);
    }
}
