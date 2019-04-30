package com.dawei.boot.boothelloword.redisclient;

import java.nio.charset.StandardCharsets;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author by Dawei on 2019/4/30.
 * Redis 消息监听
 */
public class RedisChannelListener implements MessageListener {

    /**
     * 监听消息内容
     * @param message 传送的消息 包含消息渠道和消息体
     * @param pattern 订阅模式
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        String patternType = new String(pattern, StandardCharsets.UTF_8);


        byte[] channel = message.getChannel();

        byte[] body = message.getBody();

        String channelName = new String(channel, StandardCharsets.UTF_8);



    }
}
