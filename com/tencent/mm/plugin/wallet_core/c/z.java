package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z extends i {
    public Orders pjG;

    public z(String str) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        F(hashMap);
    }

    public z(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        F(hashMap);
    }

    public final int aBO() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.pjG = new Orders();
                Commodity commodity = new Commodity();
                commodity.lNH = jSONObject.getString("buy_uin");
                commodity.lNI = jSONObject.getString("buy_name");
                commodity.lNJ = jSONObject.optString("sale_uin");
                commodity.lNK = jSONObject.optString("sale_name");
                commodity.bOe = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.hUL = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.lNO = jSONObject.getString("trade_state");
                commodity.lNP = jSONObject.getString("trade_state_name");
                commodity.lNT = jSONObject.getString("buy_bank_name");
                commodity.lOa = jSONObject.optString("discount", "");
                commodity.lNR = jSONObject.optInt("modify_timestamp");
                commodity.lNV = jSONObject.optString("fee_type");
                commodity.lNW = jSONObject.optString("appusername");
                commodity.lNy = jSONObject.optString("app_telephone");
                commodity.ppw = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.lNV = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    Promotions promotions = new Promotions();
                    promotions.type = Orders.ppu;
                    promotions.name = optJSONObject.optString("nickname");
                    promotions.lNW = optJSONObject.optString("username");
                    commodity.ppx = promotions.lNW;
                    promotions.lRX = optJSONObject.optString("logo_round_url");
                    promotions.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.poW = i2;
                    if (!bi.oW(promotions.name)) {
                        commodity.ppF.add(promotions);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.ppv;
                    promotions2.lRX = jSONObject2.optString("icon");
                    promotions2.name = jSONObject2.optString("wording");
                    promotions2.url = jSONObject2.optString("url");
                    promotions2.poG = jSONObject2.optString("btn_text");
                    promotions2.ppS = jSONObject2.optInt("type");
                    promotions2.title = jSONObject2.optString("title");
                    promotions2.pji = jSONObject2.optLong("activity_id");
                    promotions2.ppT = jSONObject2.optInt("activity_type", 0);
                    promotions2.ppU = jSONObject2.optInt("award_id");
                    promotions2.poD = jSONObject2.optInt("send_record_id");
                    promotions2.poE = jSONObject2.optInt("user_record_id");
                    promotions2.ppW = jSONObject2.optString("activity_tinyapp_username");
                    promotions2.ppX = jSONObject2.optString("activity_tinyapp_path");
                    promotions2.poF = jSONObject2.optLong("activity_mch_id");
                    promotions2.ppY = jSONObject2.optInt("activity_tinyapp_version");
                    promotions2.ppZ = jSONObject2.optString("get_award_params");
                    promotions2.pqa = jSONObject2.optString("query_award_status_params");
                    Orders.a(promotions2, jSONObject2.optJSONObject("exposure_info"));
                    commodity.ppF.add(promotions2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.ppz = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        DiscountInfo discountInfo = new DiscountInfo();
                        discountInfo.ppR = jSONObject2.optDouble("payment_amount");
                        discountInfo.mwP = jSONObject2.optString("favor_desc");
                        commodity.ppz.add(discountInfo);
                    }
                }
                commodity.ppA = jSONObject.optString("rateinfo");
                commodity.ppB = jSONObject.optString("discount_rateinfo");
                commodity.ppC = jSONObject.optString("original_feeinfo");
                this.pjG.ppf = new ArrayList();
                this.pjG.ppf.add(commodity);
                this.pjG.poY = jSONObject.optString("trade_state_name");
                this.pjG.poW = i3;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
    }
}
