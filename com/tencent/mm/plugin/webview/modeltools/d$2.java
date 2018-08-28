package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.om;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class d$2 extends c<om> {
    final /* synthetic */ d pTQ;

    d$2(d dVar) {
        this.pTQ = dVar;
        this.sFo = om.class.getName().hashCode();
    }

    private boolean a(om omVar) {
        if ((omVar instanceof om) && "bank".equals(this.pTQ.pTL)) {
            if (omVar.bZq.action == 0) {
                d.a(this.pTQ, this.pTQ.pTL);
            } else if (omVar.bZq.action == 1) {
                if (bi.oW(omVar.bZq.cardNum)) {
                    d.b(this.pTQ, this.pTQ.pTL);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bankcard_number", omVar.bZq.cardNum);
                        d.a(this.pTQ, this.pTQ.pTL, jSONObject, null);
                    } catch (JSONException e) {
                        x.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[]{e});
                        d.b(this.pTQ, this.pTQ.pTL);
                    }
                }
            }
            d.a(this.pTQ);
        }
        return false;
    }
}
