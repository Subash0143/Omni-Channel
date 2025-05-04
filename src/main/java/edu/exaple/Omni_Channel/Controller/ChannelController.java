package edu.exaple.Omni_Channel.Controller;
import edu.exaple.Omni_Channel.Entities.Channel;
import edu.exaple.Omni_Channel.Service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping
    public Channel create(@RequestBody Channel channel) {
        return channelService.save(channel);
    }

    @GetMapping
    public List<Channel> getAll() {
        return channelService.findAll();
    }

    @PutMapping("/{id}")
    public Channel update(@PathVariable Long id, @RequestBody Channel channel) {
        return channelService.update(id, channel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        channelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
