package com.tencent.mm.ui.chatting;

class s$6 implements Runnable {
    final /* synthetic */ s tKx;

    s$6(s sVar) {
        this.tKx = sVar;
    }

    public final void run() {
        this.tKx.notifyDataSetChanged();
    }
}
