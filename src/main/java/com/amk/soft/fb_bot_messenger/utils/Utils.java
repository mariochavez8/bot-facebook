/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.utils;

/**
 *
 * @author amk-003
 */
public class Utils {
    
    public static String HOST = "ds145178.mlab.com";
    
    public static int PORT = 45178;
    
    public static String DB = "heroku_th8kzj8g";
    
    public static String USER = "mac";
    
    public static String PASS = "mongo1234";
    
    public static String colUsers = "Users";
    
    public static Integer getInt(String s){
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return -1;
        }
    }
    
    public static Long getLong(String s){
        try {
            return Long.valueOf(s);
        } catch (Exception e) {
            return -1L;
        }
    }
}
