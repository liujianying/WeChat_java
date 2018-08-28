package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    private Map<String, String> lKr = new HashMap();
    private Map<String, String> peZ = new HashMap();
    public String pfn = null;
    public String token = null;

    public a(Authen authen) {
        a(authen.mpb, this.lKr, this.peZ);
        this.lKr.put("flag", authen.bWA);
        this.lKr.put("bank_type", authen.lMV);
        this.lKr.put("mobile_area", authen.plz);
        if (!bi.oW(authen.pli)) {
            this.lKr.put("passwd", authen.pli);
        }
        if (!bi.oW(authen.token)) {
            this.lKr.put("token", authen.token);
        }
        if (!bi.oW(authen.pcx)) {
            g.Ek();
            o oVar = new o(bi.a((Integer) g.Ei().DT().get(9, null), 0));
            this.lKr.put("import_code", authen.pcx);
            this.lKr.put("qqid", oVar.toString());
            if (authen.pll > 0) {
                this.lKr.put("cre_type", authen.pll);
            }
            this.lKr.put("bind_serailno", authen.lMW);
        }
        if (!bi.oW(authen.plr)) {
            this.lKr.put("first_name", authen.plr);
            this.lKr.put("last_name", authen.pls);
            this.lKr.put("country", authen.country);
            this.lKr.put("area", authen.csK);
            this.lKr.put("city", authen.csL);
            this.lKr.put("address", authen.dRH);
            this.lKr.put("phone_number", authen.knG);
            this.lKr.put("zip_code", authen.eXM);
            this.lKr.put("email", authen.csD);
            this.lKr.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.chP());
        }
        if (!bi.oW(authen.plj)) {
            this.lKr.put("true_name", authen.plj);
        }
        if (!bi.oW(authen.plk)) {
            this.lKr.put("identify_card", authen.plk);
        }
        if (authen.pll > 0) {
            this.lKr.put("cre_type", authen.pll);
        }
        if (!bi.oW(authen.pjw)) {
            this.lKr.put("mobile_no", authen.pjw);
        }
        this.lKr.put("bank_card_id", authen.plm);
        if (!bi.oW(authen.pln)) {
            this.lKr.put("cvv2", authen.pln);
        }
        if (!bi.oW(authen.plo)) {
            this.lKr.put("valid_thru", authen.plo);
        }
        if (p.cDb()) {
            this.peZ.put("uuid_for_bindcard", p.cDd());
            this.peZ.put("bindcard_scene", p.cDc());
        }
        F(this.lKr);
        aC(this.peZ);
    }

    public final boolean bkT() {
        super.bkT();
        this.lKr.put("is_repeat_send", "1");
        F(this.lKr);
        return true;
    }

    public final int aBO() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pfn = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
    }

    public final String blM() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int If() {
        return 471;
    }
}
