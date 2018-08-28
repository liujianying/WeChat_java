package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class d$2 implements Runnable {
    final /* synthetic */ d pOF;
    final /* synthetic */ String pOJ;
    final /* synthetic */ ArrayList pOK;

    d$2(d dVar, String str, ArrayList arrayList) {
        this.pOF = dVar;
        this.pOJ = str;
        this.pOK = arrayList;
    }

    public final void run() {
        g Bh = h.Bh(this.pOF.pOy.dFC.bWo);
        String str = this.pOF.pOy.dFC.bHt;
        String str2 = this.pOJ;
        x.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", new Object[]{this.pOK.toString()});
        Bundle bundle = new Bundle();
        bundle.putString("query", str);
        bundle.putString("suggestionId", str2);
        bundle.putStringArrayList("result", r3);
        try {
            if (Bh.pRY != null) {
                Bh.pRY.c(127, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
        }
    }
}
