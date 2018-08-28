package com.tencent.mm.pluginsdk.ui.chat;

class m$6 implements Runnable {
    final /* synthetic */ String efo;
    final /* synthetic */ m qNl;

    public m$6(m mVar, String str) {
        this.qNl = mVar;
        this.efo = str;
    }

    public final void run() {
        if (this.qNl.cE(this.efo)) {
            this.qNl.mHandler.sendEmptyMessage(20003);
            return;
        }
        this.qNl.mHandler.removeMessages(20003);
        this.qNl.mHandler.sendEmptyMessage(20001);
    }
}
