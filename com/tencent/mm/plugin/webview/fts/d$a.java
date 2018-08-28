package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.an.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;

class d$a implements Runnable {
    public String data;
    final /* synthetic */ d pOF;
    public boolean pON;

    private d$a(d dVar) {
        this.pOF = dVar;
    }

    public /* synthetic */ d$a(d dVar, byte b) {
        this(dVar);
    }

    public final void run() {
        Object arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.data);
            for (int i = 0; i < jSONArray.length(); i++) {
                bsu ng = ((m) g.l(m.class)).ng(jSONArray.getString(i));
                b bVar = (b) g.l(b.class);
                au.HU();
                avq a = bVar.a(c.Gq(), ng, 9);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            if (!this.pON || this.pOF.pOC == null) {
                this.pOF.pOC = arrayList;
            } else {
                this.pOF.pOC.addAll(arrayList);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
    }
}
