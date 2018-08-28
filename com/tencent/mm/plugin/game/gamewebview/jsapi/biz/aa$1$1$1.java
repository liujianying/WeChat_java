package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.1.1;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.2;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.a;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class aa$1$1$1 implements a {
    final /* synthetic */ 1 jHk;

    aa$1$1$1(1 1) {
        this.jHk = 1;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsApiLogin", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
                aa aaVar = this.jHk.jHj.jHh;
                String str = this.jHk.jHj.bAj;
                String str2 = this.jHk.jHi;
                com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar = this.jHk.jHj.jGK;
                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                LinkedList linkedList = new LinkedList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedList.add((String) it.next());
                }
                b.a aVar2 = new b.a();
                aov aov = new aov();
                aVar2.dIG = aov;
                aVar2.dIH = new aow();
                aVar2.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
                aVar2.dIF = 1117;
                aVar2.dII = 0;
                aVar2.dIJ = 0;
                aov.jQb = str;
                aov.rQZ = linkedList;
                aov.rRe = 0;
                aov.rRf = str2;
                aov.rRb = 0;
                aov.rRa = i;
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.KT(), new 2(aaVar, aVar, i));
                if (i == 2) {
                    x.e("MicroMsg.GameJsApiLogin", "fail auth deny!");
                    this.jHk.jHj.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail_auth_deny", null));
                    return;
                }
                return;
            default:
                x.i("MicroMsg.GameJsApiLogin", "press back button!");
                this.jHk.jHj.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("loginfail_auth_cancel", null));
                return;
        }
    }
}
