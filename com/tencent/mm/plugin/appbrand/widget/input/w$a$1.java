package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.w.a;
import com.tencent.mm.sdk.platformtools.x;

class w$a$1 implements Runnable {
    final /* synthetic */ boolean gIM;
    final /* synthetic */ String gIN;
    final /* synthetic */ int gIO;
    final /* synthetic */ int gIP;
    final /* synthetic */ a gIQ;

    w$a$1(a aVar, boolean z, String str, int i, int i2) {
        this.gIQ = aVar;
        this.gIM = z;
        this.gIN = str;
        this.gIO = i;
        this.gIP = i2;
    }

    public final void run() {
        if (this.gIM) {
            this.gIQ.gIK.q(this.gIN);
        } else {
            this.gIQ.gIK.setText(this.gIN);
        }
        try {
            this.gIQ.gIK.setSelection(Math.min(this.gIO + this.gIP, this.gIN.length()));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[]{e});
        }
    }
}
