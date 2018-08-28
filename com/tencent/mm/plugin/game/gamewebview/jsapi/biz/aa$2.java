package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class aa$2 implements a {
    final /* synthetic */ int fvO;
    final /* synthetic */ a$a jGK;
    final /* synthetic */ aa jHh;

    aa$2(aa aaVar, a$a a_a, int i) {
        this.jHh = aaVar;
        this.jGK = a_a;
        this.fvO = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
        } else if (this.fvO == 2) {
            x.d("MicroMsg.GameJsApiLogin", "press reject button");
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
        } else {
            aow aow = (aow) bVar.dIE.dIL;
            if (aow == null || aow.rRd == null) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
                return;
            }
            int i3 = aow.rRd.bMH;
            String str2 = aow.rRd.bMI;
            x.i("MicroMsg.GameJsApiLogin", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                new HashMap().put("code", aow.rRg);
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginok", null));
                x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", new Object[]{r0});
                return;
            }
            this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
            x.e("MicroMsg.GameJsApiLogin", "errMsg = %s", new Object[]{str2});
        }
    }
}
