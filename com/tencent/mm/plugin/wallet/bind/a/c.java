package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    public boolean cdV = false;
    public ArrayList<Bankcard> oZG = null;
    public boolean pcu = true;
    public String pcv;
    public String pcw;
    private String pcx;
    public String token;

    public c(String str, PayInfo payInfo) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        g.Ek();
        o oVar = new o(bi.a((Integer) g.Ei().DT().get(9, null), 0));
        this.pcx = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", oVar.toString());
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.oZG = new ArrayList();
            try {
                this.cdV = "1".equals(jSONObject.optString("is_reg", "0"));
                this.token = jSONObject.optString("token", "");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Bankcard ae = d.bOx().ae(jSONObject2);
                    if (ae != null) {
                        if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                            ae.field_cardType |= Bankcard.plJ;
                        }
                        ae.field_bankcardTail = jSONObject2.optString("bank_tail");
                        ae.plR = "************" + ae.field_bankcardTail;
                        ae.field_trueName = jSONObject2.optString("true_name");
                        ae.plQ = jSONObject2.optString("cre_id");
                        ae.pll = jSONObject2.optInt("cre_type", -1);
                        ae.pmb = this.pcx;
                        ae.btA = 1 == jSONObject2.optInt("samecardexist", 0);
                        if (ae.bOs()) {
                            ae.field_desc = ae.field_bankName;
                        } else if (ae.bOu()) {
                            ae.field_desc = ad.getContext().getString(a.i.wallet_credit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        } else if (ae.bOr()) {
                            ae.field_desc = ad.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        } else {
                            ae.field_desc = ad.getContext().getString(a.i.wallet_deposit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                        if (optJSONObject != null) {
                            this.pcv = optJSONObject.optString("username");
                            this.pcw = optJSONObject.optString("app_recommend_desc");
                        }
                        this.oZG.add(ae);
                    }
                }
                x.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.cdV + ",bankcard.size:" + this.oZG.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            }
        }
    }
}
