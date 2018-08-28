package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.g.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.List;

class af$32 extends c<js> {
    final /* synthetic */ af nqT;

    af$32(af afVar) {
        this.nqT = afVar;
        this.sFo = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        if (jsVar instanceof js) {
            switch (jsVar.bTw.action) {
                case WebViewClient.ERROR_CONNECT /*-6*/:
                    List<n> aW = af.byo().aW(jsVar.bTw.bTy.rYz, q.GF().equals(jsVar.bTw.bTy.rYz));
                    jsVar.bTx.bPa = new ArrayList();
                    for (n bAJ : aW) {
                        jsVar.bTx.bPa.add(((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(af.Gq(), bAJ.bAJ(), 8));
                    }
                    break;
                case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    o byo = af.byo();
                    Cursor b = byo.diF.b("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + o.nJs, null, 2);
                    List<n> arrayList = new ArrayList();
                    while (b.moveToNext()) {
                        n nVar = new n();
                        nVar.d(b);
                        arrayList.add(nVar);
                    }
                    b.close();
                    jsVar.bTx.bPa = new ArrayList();
                    for (n bAJ2 : arrayList) {
                        jsVar.bTx.bPa.add(((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(af.Gq(), bAJ2.bAJ(), 1));
                    }
                    break;
            }
        }
        return false;
    }
}
