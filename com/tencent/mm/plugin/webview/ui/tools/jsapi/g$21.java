package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class g$21 implements a {
    final /* synthetic */ d jHm;
    final /* synthetic */ g qiK;

    g$21(g gVar, d dVar) {
        this.qiK = gVar;
        this.jHm = dVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(i == 0 && i2 == 0)) {
            x.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
            h.mEJ.h(13927, new Object[]{this.jHm});
            h.mEJ.a(457, 0, 1, false);
        }
        return 0;
    }
}
