package com.tjl.cloud.service;

import com.tjl.cloud.entities.Pay;

import java.util.List;

public interface PayService {

     int add (Pay pay);
     int delete (Integer id);
     int update (Pay pay);
     Pay getById(Integer id);

     List<Pay> getList();
}
