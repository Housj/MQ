package com.mmr.search.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;

import com.alibaba.fastjson.JSON;
import com.mmr.common.util.StringUtil;
import com.mmr.search.document.GoodsDocument;

public class GoodsIndexMq implements MessageListener {
//	@Autowired
//	private SolrBaseService	solrBaseService;

    @Override
    public void onMessage(Message message) {
        try {
            String json = new String(message.getBody(), "utf-8");
            System.out.println("recv:" + json);
            if (!StringUtil.isNullString(json)) {
                MessageProperties messageProperties = message.getMessageProperties();
//				GoodsDocument document = JSON.parseObject(json, GoodsDocument.class);
                if ("goods.delete".equals(messageProperties.getReceivedRoutingKey())) {
//					solrBaseService.deleteIndexById(document.getId());
                    System.out.println("-----delete 删除索引库中数据-----");
                }
                if ("goods.add".equals(messageProperties.getReceivedRoutingKey())) {
//					solrBaseService.addBeanIndex(document);\
                    System.out.println("-----add  索引库中数据-----");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
