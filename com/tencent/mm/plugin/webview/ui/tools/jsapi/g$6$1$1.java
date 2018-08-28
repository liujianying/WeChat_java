package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.6.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class g$6$1$1 implements a {
    final /* synthetic */ 1 qiR;

    g$6$1$1(1 1) {
        this.qiR = 1;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
                g gVar = this.qiR.qiQ.qiK;
                String str = this.qiR.qiQ.bAj;
                i iVar = this.qiR.qiQ.qiH;
                g.a aVar = this.qiR.qiQ.qiL;
                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                LinkedList linkedList = new LinkedList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedList.add((String) it.next());
                }
                au.DF().a(new b(str, linkedList, i, new g$5(gVar, iVar, aVar, i)), 0);
                if (i == 2) {
                    g.a(this.qiR.qiQ.qiK, this.qiR.qiQ.qiH, "authorize:fail auth deny", null);
                    this.qiR.qiQ.qiL.aia();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.MsgHandler", "press back button!");
                g.a(this.qiR.qiQ.qiK, this.qiR.qiQ.qiH, "authorize:fail auth cancel", null);
                this.qiR.qiQ.qiL.aia();
                return;
        }
    }
}
