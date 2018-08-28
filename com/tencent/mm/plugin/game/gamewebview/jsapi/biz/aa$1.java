package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;

class aa$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ a$a jGK;
    final /* synthetic */ aa jHh;
    final /* synthetic */ Context val$context;

    aa$1(aa aaVar, a$a a_a, Context context, String str) {
        this.jHh = aaVar;
        this.jGK = a_a;
        this.val$context = context;
        this.bAj = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            aoy aoy = (aoy) bVar.dIE.dIL;
            if (aoy == null || aoy.rRd == null) {
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
                return;
            }
            int i3 = aoy.rRd.bMH;
            String str2 = aoy.rRd.bMI;
            String str3 = aoy.rRf;
            x.i("MicroMsg.GameJsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                LinkedList linkedList = aoy.rEI;
                x.d("MicroMsg.GameJsApiLogin", "appName %s, appIconUrl %s", new Object[]{aoy.jSv, aoy.rbh});
                ah.A(new 1(this, str3, linkedList, r4, r5));
                return;
            } else if (i3 == 0) {
                new HashMap().put("code", aoy.rRg);
                x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", new Object[]{r0});
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginok", null));
                return;
            } else {
                x.e("MicroMsg.GameJsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
                return;
            }
        }
        this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail", null));
    }
}
