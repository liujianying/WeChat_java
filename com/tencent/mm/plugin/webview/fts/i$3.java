package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements a {
    final /* synthetic */ String fuW;
    final /* synthetic */ i pPx;
    final /* synthetic */ int pPy;
    final /* synthetic */ String pPz;

    public i$3(i iVar, int i, String str, String str2) {
        this.pPx = iVar;
        this.pPy = i;
        this.fuW = str;
        this.pPz = str2;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (lVar.getType() == 2608) {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.FTS.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
            } else if (bVar != null) {
                bjx bjx = (bjx) bVar.dIE.dIL;
                g Bh = h.Bh(this.pPy);
                String str2 = this.fuW;
                String str3 = this.pPz;
                String str4 = bjx.rjK;
                Bundle bundle = new Bundle();
                bundle.putString("searchId", str2);
                bundle.putString("poiId", str3);
                bundle.putString("json", str4);
                try {
                    if (Bh.pRY != null) {
                        Bh.pRY.c(c.CTRL_INDEX, bundle);
                    }
                } catch (RemoteException e) {
                    x.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + e.getMessage());
                }
            }
        }
        return 0;
    }
}
