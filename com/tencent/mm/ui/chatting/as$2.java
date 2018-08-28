package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g;

class as$2 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ WXMediaMessage jLE;
    final /* synthetic */ String jmv;
    final /* synthetic */ String sg;
    final /* synthetic */ as tNC;

    as$2(as asVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        this.tNC = asVar;
        this.jLE = wXMediaMessage;
        this.jmv = str;
        this.sg = str2;
        this.bAj = str3;
    }

    public final void run() {
        Req c = g.c(as.a(this.tNC), this.jLE, this.jmv);
        g.a(as.a(this.tNC), this.sg, this.bAj, c, 0, new 1(this, c), null);
    }
}
