package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.sdk.platformtools.x;

class c$1 implements Runnable {
    final /* synthetic */ c owh;

    c$1(c cVar) {
        this.owh = cVar;
    }

    public final void run() {
        b.bGS();
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.bGS();
        c.bGZ();
    }
}
