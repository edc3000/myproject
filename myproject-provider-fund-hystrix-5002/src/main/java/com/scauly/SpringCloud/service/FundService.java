package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Fund;
import com.scauly.SpringCloud.jsonForm.JsonForm;

import java.util.List;


public interface FundService {

    public int add(Fund fund) ;

    public int update(Fund fund) ;

    public int delete(Fund fund);

    public List<Fund> findName(String name);

    public Fund  get(Long id);

    public  List<Fund> selectid(Fund fund);

    public  List<Fund> selectStatus(String status);

    public  int buy(Fund fund);

    public JsonForm selectall(Long id, String page, String limit);
}
