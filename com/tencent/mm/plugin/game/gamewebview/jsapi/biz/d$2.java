package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a.a;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements b$a {
    final /* synthetic */ int fvO;
    final /* synthetic */ a jGK;
    final /* synthetic */ d jGL;

    d$2(d dVar, a aVar, int i) {
        this.jGL = dVar;
        this.jGK = aVar;
        this.fvO = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorizefail", null));
        } else if (this.fvO == 2) {
            x.d("MicroMsg.GameJsApiAuthorize", "press reject button");
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorizefail", null));
        } else {
            aos aos = (aos) bVar.dIE.dIL;
            if (aos == null || aos.rRd == null) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorizefail", null));
                return;
            }
            int i3 = aos.rRd.bMH;
            String str2 = aos.rRd.bMI;
            x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorizeok", null));
                return;
            }
            x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorizefail", null));
        }
    }
}
