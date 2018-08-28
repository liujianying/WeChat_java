package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.rb;
import com.tencent.mm.plugin.sns.model.af.15;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.x;

class af$15$1 implements Runnable {
    final /* synthetic */ rb nqV;
    final /* synthetic */ 15 nqW;

    af$15$1(15 15, rb rbVar) {
        this.nqW = 15;
        this.nqV = rbVar;
    }

    public final void run() {
        int i = (int) this.nqV.cbQ.cbS;
        k byt = af.byt();
        String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= " + i;
        x.i("MicroMsg.SnsCommentStorage", "updateToread " + str);
        x.i("MicroMsg.SnsCore", "update msg read " + byt.dCZ.fV("SnsComment", str));
        u.bxK();
    }
}
