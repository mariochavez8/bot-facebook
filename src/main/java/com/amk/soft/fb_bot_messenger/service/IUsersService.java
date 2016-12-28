/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amk.soft.fb_bot_messenger.service;

/**
 *
 * @author amk-003
 */

import com.amk.soft.fb_bot_messenger.model.UsersDTO;

public interface IUsersService {
    
    public UsersDTO getUser(Long id);
    
}
