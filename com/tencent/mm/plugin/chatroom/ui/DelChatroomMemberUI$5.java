package com.tencent.mm.plugin.chatroom.ui;

class DelChatroomMemberUI$5 implements Runnable {
    final /* synthetic */ DelChatroomMemberUI hMA;

    DelChatroomMemberUI$5(DelChatroomMemberUI delChatroomMemberUI) {
        this.hMA = delChatroomMemberUI;
    }

    public final void run() {
        if (DelChatroomMemberUI.a(this.hMA).getCount() == 0) {
            this.hMA.finish();
        }
    }
}
