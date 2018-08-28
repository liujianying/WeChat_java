package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a pso = null;

    public static a bPP() {
        if (pso == null) {
            pso = new a();
        }
        return pso;
    }

    public final Bankcard ae(JSONObject jSONObject) {
        Bankcard ae = super.ae(jSONObject);
        ae.field_ext_msg = b.al(jSONObject);
        ae.field_bankcardClientType = 1;
        ae.field_desc = jSONObject.optString("description");
        ae.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            ae.field_cardType |= Bankcard.plJ;
        } else {
            ae.field_cardType |= Bankcard.plL;
        }
        return ae;
    }
}
