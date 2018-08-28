package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.ds;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$37 extends c<ds> {
    final /* synthetic */ g qiK;

    g$37(g gVar) {
        this.qiK = gVar;
        this.sFo = ds.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ds dsVar = (ds) bVar;
        if (dsVar != null && (dsVar instanceof ds)) {
            x.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(dsVar.bLC.bLD)});
            if (dsVar.bLC.bLD != 10 && dsVar.bLC.bLD == 12 && g.u(this.qiK)) {
                g.a(this.qiK, g.v(this.qiK), new int[]{1});
            }
        }
        return false;
    }
}
