package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ com.tencent.mm.plugin.game.gamewebview.jsapi.a.a jGK;
    final /* synthetic */ d jGL;
    final /* synthetic */ Context val$context;

    d$1(d dVar, com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar, Context context, String str) {
        this.jGL = dVar;
        this.jGK = aVar;
        this.val$context = context;
        this.bAj = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            aou aou = (aou) bVar.dIE.dIL;
            if (aou == null || aou.rRd == null) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail", null));
                return;
            }
            int i3 = aou.rRd.bMH;
            String str2 = aou.rRd.bMI;
            x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ah.A(new 1(this, aou.rEI, aou.jSv, aou.rbh));
                return;
            } else if (i3 == 0) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:ok", null));
                return;
            } else {
                x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail", null));
                return;
            }
        }
        this.jGK.tp(d.Da("authorize:fail"));
    }
}
