package com.ai.frame;

import com.ai.common.utils.OurRuleUtils;

/**
 * @author: Administrator
 * @date: 2022/2/5 13:14
 * @description:
 */
public class TestChat {

    public static void main(String[] args) {
        Chat chat = new Chat();

        OurRuleUtils ourRuleUtils = new OurRuleUtils();

        chat.initTextArea();
        // 接收消息的方法
        chat.receive();
    }
}
