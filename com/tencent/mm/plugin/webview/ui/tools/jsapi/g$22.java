package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class g$22 implements a {
    final /* synthetic */ g qiK;

    g$22(g gVar) {
        this.qiK = gVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(i == 0 && i2 == 0)) {
            h.mEJ.a(457, 1, 1, false);
        }
        return 0;
    }
}
