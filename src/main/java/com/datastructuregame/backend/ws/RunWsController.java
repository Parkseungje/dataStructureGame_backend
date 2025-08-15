package com.datastructuregame.backend.ws;

import com.datastructuregame.backend.dto.RunEventMessage;
import com.datastructuregame.backend.dto.CommandMessage;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RunWsController {
    private final SimpMessagingTemplate template;

    // 클라 → /app/runs/{runId}/cmd 로 publish
    @MessageMapping("/runs/{runId}/cmd")
    public void onCommand(@DestinationVariable String runId, CommandMessage cmd) {
        // TODO: 실제로는 Executor에 전달하고, 스트림 이벤트를 forwarding
        // 여기서는 데모로 즉시 렌더 이벤트 하나 push
        var event = new RunEventMessage(
                runId, "render", null, 42,
                Map.of(
                        "structure","stack",
                        "nodes", java.util.List.of(Map.of("id","n1","label","7","pos", java.util.List.of(0,1,0))),
                        "pointers", Map.of("top","n1"),
                        "meta", Map.of("size",1)
                ),
                null, null
        );
        template.convertAndSend("/topic/runs/" + runId, event);
    }
}