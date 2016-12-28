/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.serviceImpl;

import com.amk.soft.fb_bot_messenger.service.IMongoCl;
import com.amk.soft.fb_bot_messenger.service.ITestService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
/**
 *
 * @author amk-003
 */
public class TestServiceImpl implements ITestService{
    
    private static final String nameCol = "test";

    @Override
    public String getTest() {
        DBCollection coleccion;
        IMongoCl mongoClient = new MongoCl();
        MongoClient client = mongoClient.getMongoClient();
        String rtn = "";
        DBCursor cur;
        try {
            DB database = client.getDB("heroku_th8kzj8g");
            coleccion = database.getCollection(nameCol);
            cur = coleccion.find(new BasicDBObject("_id", 1));
            DBObject confObj = null;
            while (cur.hasNext()) {
                confObj = cur.next();
                rtn = confObj.get("name").toString();
            }
            client.close();
        } catch (Exception e) {
            client.close();
            System.err.println("Error: " + e);
            rtn = e.getMessage();
        }
        return rtn;
    }
    
}
