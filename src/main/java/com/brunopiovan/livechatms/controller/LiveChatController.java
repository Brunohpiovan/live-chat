package com.brunopiovan.livechatms.controller;


import com.brunopiovan.livechatms.domain.ChatInput;
import com.brunopiovan.livechatms.domain.ChatOutPut;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutPut newMessage(ChatInput input){
        return new ChatOutPut(HtmlUtils.htmlEscape(input.user() + ":" + input.message()));
    }
}
