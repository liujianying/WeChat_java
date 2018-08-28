package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.a;

class e$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ String kDY;
    final /* synthetic */ String kDZ;
    final /* synthetic */ a owk;
    final /* synthetic */ e owl;

    e$1(e eVar, a aVar, String str, String str2, String str3) {
        this.owl = eVar;
        this.owk = aVar;
        this.dhF = str;
        this.kDY = str2;
        this.kDZ = str3;
    }

    public final void run() {
        this.owk.p(this.dhF, this.kDY, this.kDZ);
    }
}
