package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.fts.d.1;
import com.tencent.mm.plugin.webview.fts.d.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class d$1$1 implements Runnable {
    final /* synthetic */ j joJ;
    final /* synthetic */ f pOG;
    final /* synthetic */ ArrayList pOH;
    final /* synthetic */ 1 pOI;

    d$1$1(1 1, f fVar, j jVar, ArrayList arrayList) {
        this.pOI = 1;
        this.pOG = fVar;
        this.joJ = jVar;
        this.pOH = arrayList;
    }

    public final void run() {
        if (this.pOG.pOW != 0) {
            x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[]{Integer.valueOf(this.pOG.pOW)});
            g Bh = h.Bh(this.pOG.pOW);
            String str = this.joJ.joH.bWm;
            try {
                x.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", new Object[]{this.pOH.toString()});
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", 0);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator it = r0.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("word", str);
                    jSONObject2.put("id", System.currentTimeMillis());
                    jSONObject2.put("timeStamp", System.currentTimeMillis());
                    jSONArray2.put(jSONObject2);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("items", jSONArray2);
                jSONArray.put(jSONObject3);
                jSONObject.put("data", jSONArray);
                Bundle bundle = new Bundle();
                bundle.putString("data", jSONObject.toString());
                try {
                    if (Bh.pRY != null) {
                        Bh.pRY.c(143, bundle);
                    } else {
                        x.i("MicroMsg.MsgHandler", "callbacker is null");
                    }
                } catch (RemoteException e) {
                    x.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e.getMessage());
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
        }
    }
}
