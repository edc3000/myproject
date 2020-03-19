package com.scauly.SpringCloud.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.scauly.SpringCloud.jsonForm.JsonForm;
import java.io.File;
import java.io.IOException;

@RestController
public class uploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonForm handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) {
        JsonForm jsonForm = new JsonForm();
        File fileToSave = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                fileToSave = new File("C:\\Users\\LEON\\IdeaProjects\\myproject\\myproject-front-8578\\src\\main\\resources\\static\\image\\"+file.getOriginalFilename());
                //fileToSave = new File("D:\\测绘管理系统\\文件系统\\文件存储" + file.getOriginalFilename()); 自定义存储路径
                FileCopyUtils.copy(bytes, fileToSave);
            } catch (IOException e) {
                e.printStackTrace();
                jsonForm.setCode("1");
                jsonForm.setMsg("");
                jsonForm.setData("上传失败," + e.getMessage());
                return jsonForm;
            }
            jsonForm.setCode("0");
            jsonForm.setMsg("");
            jsonForm.setData("上传成功" + fileToSave.getAbsolutePath());
            return jsonForm;
        } else {
            jsonForm.setCode("1");
            jsonForm.setMsg("");
            jsonForm.setData("上传失败，因为文件是空的.");
            return jsonForm;
        }
    }


}
