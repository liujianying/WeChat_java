package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends i {
    public String desc;
    public String lNV;
    public double mxP;

    public b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        F(hashMap);
    }

    public final int aBO() {
        return 123;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.lNV = jSONObject.optString("fee_type");
            this.mxP = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            ad bOX = o.bOX();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            bOX.prv.clear();
            if (optJSONObject == null) {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                return;
            }
            JSONObject jSONObject2;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= optJSONArray2.length()) {
                        break;
                    }
                    d bOx = d.bOx();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i3);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard ae = bOx.ae(jSONObject2);
                        if (ae.bOs()) {
                            ae.field_desc = ae.field_bankName;
                        } else if (ae.bOu()) {
                            ae.field_desc = com.tencent.mm.sdk.platformtools.ad.getContext().getString(a.i.wallet_credit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        } else if (ae.bOr()) {
                            ae.field_desc = com.tencent.mm.sdk.platformtools.ad.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        } else {
                            ae.field_desc = com.tencent.mm.sdk.platformtools.ad.getContext().getString(a.i.wallet_deposit_card_desc, new Object[]{ae.field_bankName, ae.field_bankcardTail});
                        }
                        bOX.prv.add(ae);
                    }
                    i2 = i3 + 1;
                }
            } else {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                bOX.prw = jSONObject2.optString("last_card_bind_serialno");
            } else {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
            }
        }
    }

    public final int If() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
