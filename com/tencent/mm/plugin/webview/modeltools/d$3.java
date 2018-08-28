package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.on;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class d$3 extends c<on> {
    final /* synthetic */ d pTQ;

    d$3(d dVar) {
        this.pTQ = dVar;
        this.sFo = on.class.getName().hashCode();
    }

    private boolean a(on onVar) {
        if ((onVar instanceof on) && this.pTQ.pTL.equalsIgnoreCase(onVar.bZr.cardType)) {
            if (onVar.bZr.bZs == 0) {
                d.b(this.pTQ, this.pTQ.pTL);
            } else if (onVar.bZr.bZs == 2) {
                d.a(this.pTQ, this.pTQ.pTL);
            } else {
                try {
                    if (bi.oW(onVar.bZr.bZt)) {
                        d.a(this.pTQ, this.pTQ.pTL, null, onVar.bZr.bZu);
                    } else {
                        d.a(this.pTQ, this.pTQ.pTL, new JSONObject(onVar.bZr.bZt), onVar.bZr.bZu);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[]{e.getMessage()});
                    d.b(this.pTQ, this.pTQ.pTL);
                }
            }
            d.a(this.pTQ);
        }
        return false;
    }
}
