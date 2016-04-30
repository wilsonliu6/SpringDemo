package com.mdt.open.springdemo.controller;

import com.mdt.open.springdemo.domain.jpa.RedPackJpa;
import com.mdt.open.springdemo.service.RedPackService;
import com.mdt.open.springdemo.domain.jpa.RedPackInfoJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dt")
public class RedPackController{
    Logger logger = LoggerFactory.getLogger(RedPackController.class);

    @Autowired
    RedPackService redPackService;

    @RequestMapping(value = "/rdinfo/{redPackInfoId}", method = RequestMethod.GET)
    @ResponseBody
    public RedPackInfoJpa getRedPackInfo(@PathVariable("redPackInfoId") Long redPackInfoId){
        try {
            logger.debug("Get RedPackInfo by id:" + redPackInfoId.toString());
            //TODO: here, should define an operation result class to return
            return redPackService.getRedPackInfo(redPackInfoId);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/rd/{qrCode}", method = RequestMethod.GET)
    @ResponseBody
    public RedPackJpa getRedPack(@PathVariable("qrCode") String qrCode){
        try {
            logger.debug("Get RedPack by qrcode:" + qrCode);

            //TODO: here, should define an operation result class to return
            return redPackService.getRedPack(qrCode);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
