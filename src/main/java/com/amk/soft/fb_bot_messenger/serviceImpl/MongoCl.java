/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.serviceImpl;

import com.amk.soft.fb_bot_messenger.service.IMongoCl;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.amk.soft.fb_bot_messenger.utils.Utils;
/**
 *
 * @author amk-003
 */
public class MongoCl implements IMongoCl{
    
    @Override
    public MongoClient getMongoClient() {
        MongoClient client = null;
        try {
            client = new MongoClient(new ServerAddress(Utils.HOST, Utils.PORT));
        } catch (Exception e) {
            System.err.println("Error encontrado para obtener la coneccion a mongo: "+e);
        }
        return client;
    }
}
