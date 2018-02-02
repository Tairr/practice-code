package com.kf.practice.sse;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@Controller
@RequestMapping("/sse")
public class SseEmitterController {


    private Set<SseEmitter> sseEmitters = new HashSet<>();
    private Map<SseEmitter,HttpServletRequest> refers = new HashMap<>();

    private Set<Integer> integers = new HashSet<>();

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public SseEmitter getEvents(HttpServletRequest request) throws Exception {

        SseEmitter sseEmitter = new SseEmitter();

        sseEmitter.onCompletion(() -> {
            System.out.println(sseEmitter.hashCode()+"...Complete");
            synchronized (this.sseEmitters) {
                this.sseEmitters.remove(sseEmitter);
                this.refers.put(sseEmitter,request);
            }
        });

        sseEmitter.onTimeout(() -> {
            System.out.println(sseEmitter.hashCode()+"...Timeout");
            sseEmitter.complete();
        });

        sseEmitters.add(sseEmitter);
        refers.put(sseEmitter,request);

        return sseEmitter;
    }


    @Scheduled(fixedDelay = 2*1000)
    public void scheduledMsgEmitter() throws IOException
    {

        sseEmitters.forEach(emitter -> {
            if (null != emitter) {
                try {
                    HttpServletRequest request = refers.get(emitter);
                    System.out.println("emitter hashCode : " + emitter.hashCode());
                    emitter.send("emitter hashCode : " + emitter.hashCode());
                } catch (Exception e) {
                    // 刷新页面会造成异常
                    sseEmitters.remove(emitter);
                    refers.remove(emitter);
                    emitter.completeWithError(e.getCause());
                    e.printStackTrace();
                }
            }
        });

    }



}
