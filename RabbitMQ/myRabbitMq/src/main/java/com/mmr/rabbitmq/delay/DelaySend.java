package com.mmr.rabbitmq.delay;

import com.mmr.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author sergei
 * @create 2020-05-05
 */
public class DelaySend {

    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = "myDelayTopic";
        Connection conn = ConnectionUtils.getConnection();
        Channel channel = conn.createChannel();
        Map<String,Object> argsMap = new HashMap<>();
        argsMap.put("x-dead-letter-exchange","");
        argsMap.put("x-dead-letter-routing-key","deadLetterQueue");

        argsMap.put("x-message-ttl",10000);

        channel.queueDeclare(queueName,true,false,false,argsMap);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = "延迟消息 发送时间："+sdf.format(new Date());
        AMQP.BasicProperties properties = new AMQP.BasicProperties();
        properties.builder().expiration("10000");
        channel.basicPublish("",queueName,properties,msg.getBytes());
        channel.close();
        conn.close();
    }
}
