package com.mmr.rabbitmq.delay;

import com.mmr.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @author sergei
 * @create 2020-05-05
 */
public class DelayConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = "deadLetterQueue";
        Connection conn = ConnectionUtils.getConnection();
        final Channel channel = conn.createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("消费者" + new String(body, "utf-8") + "接受时间" + sdf.format(new Date()));
                //应答
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //开始监听
        channel.basicConsume(queueName,false,consumer);
    }
}