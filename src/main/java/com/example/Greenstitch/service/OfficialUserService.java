package com.example.Greenstitch.service;

import com.example.Greenstitch.entity.OfficialUser;

public interface OfficialUserService {
    public OfficialUser getUserByUsername(String userName);
    public String addUser(OfficialUser role);

}
