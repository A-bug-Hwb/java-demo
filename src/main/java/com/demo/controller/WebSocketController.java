package com.demo.controller;

import com.demo.common.Result.AjaxResult;
import com.demo.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "webSocket消息")
@RestController("/webSocket")
public class WebSocketController {

    @ApiOperation(value = "发送webSocket消息")
    @PostMapping("/sendWebSocketMessage")
    public AjaxResult sendWebSocketMessage(String message) throws Exception {
        // 发送webSocket消息
        WebSocketServer.sendString(message);
        return AjaxResult.success();
    }
}
