package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class ah$1 implements a {
    final /* synthetic */ d jHm;
    final /* synthetic */ ah jHn;

    ah$1(ah ahVar, d dVar) {
        this.jHn = ahVar;
        this.jHm = dVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.GameJsApiOpenWeAppPage", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(i == 0 && i2 == 0)) {
            x.i("MicroMsg.GameJsApiOpenWeAppPage", "report oreh logbuffer(13927)");
            h.mEJ.h(13927, this.jHm);
            h.mEJ.a(457, 0, 1, false);
        }
        return 0;
    }
}
