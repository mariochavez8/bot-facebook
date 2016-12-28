/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.serviceImpl;

import com.amk.soft.fb_bot_messenger.service.IMongoCl;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
/**
 *
 * @author amk-003
 */
public class MongoCl implements IMongoCl{
    
    private static final String HOST = "ds145178.mlab.com";
    private static final int PORT = 45178;
    
    @Override
    public MongoClient getMongoClient() {
        MongoClient client = null;
        try {
            client = new MongoClient(new ServerAddress(
                            HOST, PORT));
        } catch (Exception e) {
            System.err.println("Error encontrado para obtener la coneccion a mongo: "+e);
        }
        return client;
    }
}