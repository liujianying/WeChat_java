package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.fts.d.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class d$4$1 implements Runnable {
    final /* synthetic */ j joJ;
    final /* synthetic */ ArrayList pOH;
    final /* synthetic */ 4 pOL;

    d$4$1(4 4, j jVar, ArrayList arrayList) {
        this.pOL = 4;
        this.joJ = jVar;
        this.pOH = arrayList;
    }

    public final void run() {
        if (this.pOL.pOF.jsw != null && this.pOL.pOF.jsw.jrq != null) {
            g Bh = h.Bh(((Integer) this.pOL.pOF.jsw.jrq).intValue());
            String str = this.joJ.joH.bWm;
            x.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", new Object[]{this.pOH.toString()});
            Bundle bundle = new Bundle();
            bundle.putString("query", str);
            bundle.putStringArrayList("result", r2);
            try {
                if (Bh.pRY != null) {
                    Bh.pRY.c(126, bundle);
                }
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
            }
        }
    }
}
