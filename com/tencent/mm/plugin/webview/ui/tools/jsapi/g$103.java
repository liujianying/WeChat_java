package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$103 implements Runnable {
    final /* synthetic */ String dUT;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjU;
    final /* synthetic */ String qjV;

    g$103(g gVar, String str, i iVar, String str2, String str3) {
        this.qiK = gVar;
        this.qjU = str;
        this.qiH = iVar;
        this.dUT = str2;
        this.qjV = str3;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
        int indexOf = this.qjU.indexOf(";base64,");
        String str = "";
        if (indexOf != -1) {
            str = this.qjU.substring(indexOf + 8, this.qjU.length());
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (bi.bC(decode)) {
                g.a(this.qiK, this.qiH, "addToEmoticon:fail", null);
                return;
            }
            String u = g.u(decode);
            au.HU();
            String L = EmojiLogic.L(c.Gg(), "", u);
            if (!(e.cn(L) && g.cu(L).equalsIgnoreCase(u))) {
                e.b(L, decode, decode.length);
            }
            g.a(this.qiK, u, this.dUT, this.qjV);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + e.getMessage());
            g.a(this.qiK, this.qiH, "addToEmoticon:fail_" + e.getMessage(), null);
        }
    }
}
