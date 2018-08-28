package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class g$4$1$1 implements a {
    final /* synthetic */ 1 qiO;

    g$4$1$1(1 1) {
        this.qiO = 1;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
                g gVar = this.qiO.qiN.qiK;
                String str = this.qiO.qiN.bAj;
                String str2 = this.qiO.jHi;
                i iVar = this.qiO.qiN.qiH;
                g$a g_a = this.qiO.qiN.qiL;
                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                LinkedList linkedList = new LinkedList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedList.add((String) it.next());
                }
                au.DF().a(new d(str, linkedList, str2, i, new g$3(gVar, iVar, g_a, i)), 0);
                if (i == 2) {
                    x.e("MicroMsg.MsgHandler", "fail auth deny!");
                    g.a(this.qiO.qiN.qiK, this.qiO.qiN.qiH, "login:fail auth deny", null);
                    this.qiO.qiN.qiL.aia();
                    return;
                }
                return;
            default:
                x.i("MicroMsg.MsgHandler", "press back button!");
                g.a(this.qiO.qiN.qiK, this.qiO.qiN.qiH, "login:fail auth cancel", null);
                this.qiO.qiN.qiL.aia();
                return;
        }
    }
}
