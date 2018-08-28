package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import org.json.JSONObject;

public final class e extends i {
    public String pkH;
    public String pkI;
    public String pkJ;
    public String pkK;
    public int pkL;
    public long pkM;
    public String title;

    public final int aBO() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.pkH = jSONObject.optString("agreed_flag", "0");
            this.title = jSONObject.optString("title", "");
            this.pkI = jSONObject.optString("service_protocol_wording", "");
            this.pkJ = jSONObject.optString("service_protocol_url", "");
            this.pkK = jSONObject.optString("button_wording", "");
            this.pkM = jSONObject.optLong("delay_expired_time", 0);
            if (this.pkM > 0) {
                g.Ek();
                g.Ei().DT().a(a.sTd, Long.valueOf(System.currentTimeMillis() + (this.pkM * 1000)));
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int If() {
        return 1614;
    }
}
