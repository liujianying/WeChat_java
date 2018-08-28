package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.chatting.gallery.j.4;

class j$4$2 implements Runnable {
    final /* synthetic */ int gcp;
    final /* synthetic */ int ner;
    final /* synthetic */ 4 tXt;

    j$4$2(4 4, int i, int i2) {
        this.tXt = 4;
        this.ner = i;
        this.gcp = i2;
    }

    public final void run() {
        h hVar = h.mEJ;
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(this.tXt.tXq.tXo);
        objArr[1] = Integer.valueOf(this.ner <= 0 ? this.tXt.tXq.nFC * 1000 : this.ner);
        objArr[2] = Integer.valueOf(this.gcp);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = this.tXt.tXq.bSS;
        objArr[5] = Integer.valueOf(this.tXt.tXq.tXp);
        objArr[6] = this.tXt.tXq.fileId;
        objArr[7] = Long.valueOf(this.tXt.tXq.createTime);
        hVar.h(12084, objArr);
    }
}
