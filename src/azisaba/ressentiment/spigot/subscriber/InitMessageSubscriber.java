package azisaba.ressentiment.spigot.subscriber;

import amata1219.redis.plugin.messages.common.RedisPublisher;
import amata1219.redis.plugin.messages.common.RedisSubscriber;
import amata1219.redis.plugin.messages.common.io.ByteIOStreams;
import azisaba.ressentiment.Channels;
import azisaba.ressentiment.Output;
import com.google.common.io.ByteArrayDataInput;

public class InitMessageSubscriber implements RedisSubscriber {

    private final RedisPublisher publisher;

    public InitMessageSubscriber(RedisPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void onRedisMessageReceived(String sourceServerName, ByteArrayDataInput in) {
        publisher.sendRedisMessage(Channels.REGISTER, ByteIOStreams.newDataOutput());
        Output.printf("onInit: request for registering this server");
    }

}
