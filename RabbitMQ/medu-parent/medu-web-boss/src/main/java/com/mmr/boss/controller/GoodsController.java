package com.mmr.boss.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/add")
    @ResponseBody
    public Object add() {
        rabbitTemplate.convertAndSend("goods.add", "{id=1,name='g'}");
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object update() {
        rabbitTemplate.convertAndSend("goods.delete", "{id=1,name='g'}");
        return "sucess";
    }
}
