package edu.exaple.Omni_Channel.Service;
import edu.exaple.Omni_Channel.Entities.Channel;
import edu.exaple.Omni_Channel.Repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    public Channel save(Channel channel) {
        return channelRepository.save(channel);
    }

    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    public Channel update(Long id, Channel updatedChannel) {
        Channel channel = channelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Channel not found"));
        channel.setName(updatedChannel.getName());
        channel.setDescription(updatedChannel.getDescription());
        return channelRepository.save(channel);
    }

    public void delete(Long id) {
        channelRepository.deleteById(id);
    }

}
