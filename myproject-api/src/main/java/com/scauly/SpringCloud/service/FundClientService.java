package com.scauly.SpringCloud.service;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.scauly.SpringCloud.entities.Fund;
import java.util.List;

@FeignClient(value = "myspringcloud-fund")
public interface FundClientService {
    @RequestMapping(value = "fund/selectName",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Fund> selectName(@RequestBody Fund fund);

    //根据status查基金
    @RequestMapping(value = "fund/selectStatus", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Fund> selectStatus(@RequestBody Fund fund);

    //基金上架（未审核）
    @RequestMapping(value = "fund/add", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Fund fund);

    //基金下架
    @RequestMapping(value = "fund/delete", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int delete(@RequestBody Fund fund);

    //修改基金
    @RequestMapping(value = "fund/update",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int update(@RequestBody Fund fund);

    @RequestMapping(value = "fund/get{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Fund get(@PathVariable("id") Long id);

    @RequestMapping(value = "fund/buy",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int buy(@RequestBody Fund fund);
}
