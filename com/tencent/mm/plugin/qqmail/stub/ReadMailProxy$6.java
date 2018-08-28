package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bd;

class ReadMailProxy$6 implements Runnable {
    final /* synthetic */ long bAw;
    final /* synthetic */ String fYD;
    final /* synthetic */ ReadMailProxy mej;

    ReadMailProxy$6(ReadMailProxy readMailProxy, long j, String str) {
        this.mej = readMailProxy;
        this.bAw = j;
        this.fYD = str;
    }

    public final void run() {
        au.HU();
        bd dW = c.FT().dW(this.bAw);
        dW.setContent(dW.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.fYD + "</digest>"));
        au.HU();
        c.FT().a(this.bAw, dW);
    }
}
