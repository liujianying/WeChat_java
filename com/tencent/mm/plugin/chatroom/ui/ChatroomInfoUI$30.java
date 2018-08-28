package com.tencent.mm.plugin.chatroom.ui;

class ChatroomInfoUI$30 implements Runnable {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$30(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void run() {
        ChatroomInfoUI.b(this.hLX, "room_notify_new_msg");
        ChatroomInfoUI.D(this.hLX);
    }
}
