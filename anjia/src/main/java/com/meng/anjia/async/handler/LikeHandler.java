package com.meng.anjia.async.handler;

import com.meng.anjia.async.EventHandler;
import com.meng.anjia.async.EventModel;
import com.meng.anjia.async.EventType;
import com.meng.anjia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yue
 * @date  2019/3/18
 */
@Component
public class LikeHandler implements EventHandler {
    @Autowired
    LikeService likeService;

    private final String  LIKE = "LIKE";
    @Override
    public void doHandle(EventModel model) {
        if(LIKE == model.getEventType().toString()) {
            likeService.like(model.getUserId(), model.getEntityType(), model.getEntityId());
        }else {
            likeService.disLike(model.getUserId(), model.getEntityType(), model.getEntityId());
        }
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        List<EventType> le = new LinkedList<>();
        le.add(EventType.LIKE);
        le.add(EventType.DISLIKE);
        return le;
    }
}
