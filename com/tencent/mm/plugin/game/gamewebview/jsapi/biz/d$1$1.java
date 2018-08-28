package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.plugin.webview.ui.tools.widget.l$a;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class d$1$1 implements Runnable {
    final /* synthetic */ LinkedList fyu;
    final /* synthetic */ String jGM;
    final /* synthetic */ String jGN;
    final /* synthetic */ 1 jGO;

    d$1$1(1 1, LinkedList linkedList, String str, String str2) {
        this.jGO = 1;
        this.fyu = linkedList;
        this.jGM = str;
        this.jGN = str2;
    }

    public final void run() {
        l lVar = new l(this.jGO.val$context);
        l$a anonymousClass1 = new l$a() {
            public final void f(int i, Bundle bundle) {
                x.i("MicroMsg.GameJsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                switch (i) {
                    case 1:
                    case 2:
                        d dVar = d$1$1.this.jGO.jGL;
                        String str = d$1$1.this.jGO.bAj;
                        a aVar = d$1$1.this.jGO.jGK;
                        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        LinkedList linkedList = new LinkedList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            linkedList.add((String) it.next());
                        }
                        b.a aVar2 = new b.a();
                        aor aor = new aor();
                        aVar2.dIG = aor;
                        aVar2.dIH = new aos();
                        aVar2.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                        aVar2.dIF = 1158;
                        aVar2.dII = 0;
                        aVar2.dIJ = 0;
                        aor.jQb = str;
                        aor.rQZ = linkedList;
                        aor.rRb = 0;
                        aor.rRa = i;
                        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.KT(), new d$2(dVar, aVar, i));
                        if (i == 2) {
                            d$1$1.this.jGO.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail_auth_deny", null));
                            return;
                        }
                        return;
                    default:
                        x.d("MicroMsg.GameJsApiAuthorize", "press back button!");
                        d$1$1.this.jGO.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail_auth_cancel", null));
                        return;
                }
            }
        };
        if (this.fyu == null || this.fyu.size() <= 0) {
            x.e("MicroMsg.GameJsApiAuthorize", "scopeInfoList is empty!");
            this.jGO.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail", null));
        } else if (!lVar.a(this.fyu, this.jGM, this.jGN, anonymousClass1)) {
            this.jGO.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("authorize:fail", null));
        }
    }
}
