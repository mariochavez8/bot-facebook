/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.model;

import com.amk.soft.fb_bot_messenger.utils.Utils;
import com.mongodb.BasicDBObject;

/**
 *
 * @author amk-003
 */
public class UsersDTO {
    
    private Long id;
    
    private Long entryTimeLong;
    
    private int ranking;

    public UsersDTO(BasicDBObject confObj) {
        this.id = Utils.getLong(confObj.get("_id").toString());
        this.entryTimeLong = Utils.getLong(confObj.get("entry_time_long").toString());
        this.ranking = Utils.getInt(confObj.get("ranking").toString());;
    }

    public UsersDTO() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntryTimeLong() {
        return entryTimeLong;
    }

    public void setEntryTimeLong(Long entryTimeLong) {
        this.entryTimeLong = entryTimeLong;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "UsersDTO{" + "id=" + id + 
                ", entryTimeLong=" + entryTimeLong + 
                ", ranking=" + ranking + '}';
    }
}
