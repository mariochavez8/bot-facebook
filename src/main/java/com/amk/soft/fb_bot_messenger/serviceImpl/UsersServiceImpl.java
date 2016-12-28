/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.serviceImpl;

import com.amk.soft.fb_bot_messenger.service.IMongoCl;
import com.amk.soft.fb_bot_messenger.utils.Utils;
import com.amk.soft.fb_bot_messenger.service.IUsersService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.amk.soft.fb_bot_messenger.model.UsersDTO;
/**
 *
 * @author amk-003
 */
public class UsersServiceImpl implements IUsersService{
    
    @Override
    public UsersDTO getUser(Long id) {
        DBCollection coleccion;
        IMongoCl mongoClient = new MongoCl();
        MongoClient client = mongoClient.getMongoClient();
        String rtn = "";
        DBCursor cur;
        try {
            DB database = client.getDB(Utils.DB);
            database.authenticate(Utils.USER, Utils.PASS.toCharArray());
            coleccion = database.getCollection(Utils.colUsers);
            cur = coleccion.find(new BasicDBObject("_id", id));
            DBObject confObj = null;
            while (cur.hasNext()) {
                confObj = cur.next();
            }
            client.close();
            return new UsersDTO((BasicDBObject) confObj);
        } catch (Exception e) {
            client.close();
            System.err.println("Error: " + e);
            rtn = e.getMessage();
        }
        return null;
    }
    
}
