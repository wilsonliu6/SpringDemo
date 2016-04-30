package com.mdt.open.springdemo.service;

import com.mdt.open.springdemo.domain.jpa.RedPackInfoJpa;
import com.mdt.open.springdemo.domain.jpa.RedPackJpa;
import com.mdt.open.springdemo.persistence.jpa.RedPackInfoRepositoryJpa;
import com.mdt.open.springdemo.persistence.jpa.RedPackRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class RedPackService {
    Logger logger = LoggerFactory.getLogger(RedPackService.class);

    @Resource
    RedPackRepositoryJpa redPackRepositoryJpa;

    @Resource
    RedPackInfoRepositoryJpa redPackInfoRepositoryJpa;

    @Transactional
    public RedPackInfoJpa saveRedPackInfo(RedPackInfoJpa redPackInfoJpa){
        return redPackInfoRepositoryJpa.save(redPackInfoJpa);
    }

    @Transactional
    public Iterable<RedPackInfoJpa> getAllRedPackInfo(){
        return redPackInfoRepositoryJpa.findAll();
    }

    @Transactional
    public RedPackInfoJpa getRedPackInfo(Long redPackInfoId){
        return redPackInfoRepositoryJpa.findOne(redPackInfoId);
    }

    @Transactional
    public Iterable<RedPackJpa> getAllRedPack(){
        return redPackRepositoryJpa.findAll();
    }

    @Transactional
    public RedPackJpa getRedPack(String qrCode){
        return redPackRepositoryJpa.findOne(qrCode);
    }


    @Transactional
    public void saveRedPack(RedPackJpa redPackJpa){
        redPackRepositoryJpa.save(redPackJpa);
    }
}
