package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.net.URLDecoder;
import org.json.JSONObject;

public class d {
    private static d pmm = null;

    public static d bOx() {
        if (pmm == null) {
            pmm = new d();
        }
        return pmm;
    }

    public Bankcard ae(JSONObject jSONObject) {
        String str;
        int i = 1;
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object str4 = jSONObject;
        }
        objArr[0] = str4;
        x.i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[]{bankcard.field_bindSerial});
            bankcard.plT = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 0)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.plJ;
            }
            if ("NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.plK;
            }
            if ("QMF".equals(bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.plP;
                JSONObject optJSONObject = jSONObject.optJSONObject("qmfCardInfo");
                if (optJSONObject != null) {
                    bankcard.pmd = optJSONObject.optLong("total_credit_line", 0);
                    bankcard.pme = optJSONObject.optLong("use_credit_line", 0);
                    bankcard.pmf = optJSONObject.optLong("unuse_credit_line", 0);
                    bankcard.pmg = optJSONObject.optString("payer_username", "");
                    bankcard.pmh = optJSONObject.optInt("hide_credit_line", 0);
                    bankcard.pmi = optJSONObject.optInt("card_type", 0);
                    bankcard.pmj = optJSONObject.optString("card_type_name", "");
                    bankcard.pmk = optJSONObject.optString("icon_url", "");
                }
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll("x", "%"), "utf-8");
            if (bi.oW(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (bi.oW(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.plR = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!bi.oW(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag != 2) {
                i = 0;
            }
            if (i != 0) {
                bankcard.field_cardType |= Bankcard.plI;
            }
            CharSequence optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if ("0".equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            bankcard.field_support_lqt_turn_in = jSONObject.optInt("support_lqt_turn_in", 0);
            bankcard.field_support_lqt_turn_out = jSONObject.optInt("support_lqt_turn_out", 0);
            bankcard.field_is_hightlight_pre_arrive_time_wording = jSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
            bankcard.pml = jSONObject.optInt("support_foreign_mobile", 0);
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            return null;
        } catch (Throwable e22) {
            x.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e22, "", new Object[0]);
            return null;
        }
    }

    public static Bankcard a(ll llVar) {
        boolean z = true;
        x.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", new Object[]{llVar});
        Bankcard bankcard = new Bankcard();
        try {
            boolean z2;
            bankcard.field_bankName = llVar.knE;
            bankcard.field_bankcardTypeName = llVar.rfZ;
            bankcard.field_bankcardType = llVar.lMV;
            bankcard.field_bindSerial = llVar.lMW;
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", new Object[]{bankcard.field_bindSerial});
            if (2 == bi.getInt(llVar.rfX, 2)) {
                bankcard.field_cardType |= Bankcard.plJ;
            }
            if ("NORMAL".equals(llVar.rpc)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.plK;
            }
            if (!bi.oW(llVar.bTi)) {
                bankcard.field_mobile = URLDecoder.decode(llVar.bTi.replaceAll("x", "%"), "utf-8");
            }
            bankcard.field_onceQuotaKind = bi.getDouble(llVar.roY, 0.0d) / 100.0d;
            bankcard.field_onceQuotaVirtual = bi.getDouble(llVar.roW, 0.0d) / 100.0d;
            bankcard.field_dayQuotaKind = bi.getDouble(llVar.roU, 0.0d) / 100.0d;
            bankcard.field_dayQuotaVirtual = bi.getDouble(llVar.roS, 0.0d) / 100.0d;
            bankcard.field_bankcardTail = llVar.rfY;
            bankcard.field_forbidWord = llVar.lMX;
            bankcard.field_repay_url = llVar.qwz;
            bankcard.field_wxcreditState = 2;
            if (!bi.oW(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == bi.getInt(llVar.roV, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (bi.getInt(llVar.pnv, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = llVar.pnw;
            bankcard.field_fetchArriveTime = bi.getLong(llVar.rph, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = llVar.rpt;
            bankcard.field_bankcardTag = bi.getInt(llVar.roZ, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.plI;
            }
            if (llVar.rpe != 1) {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + llVar.rpe);
            bankcard.field_arrive_type = llVar.rpn;
            bankcard.field_avail_save_wording = llVar.rpp;
            int i = llVar.rpu;
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = llVar.rpv;
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = llVar.rpw;
            bankcard.field_tips = llVar.hyz;
            bankcard.field_forbid_title = llVar.rfQ;
            bankcard.field_forbid_url = llVar.rfR;
            bankcard.field_no_micro_word = llVar.rpo;
            bankcard.field_card_bottom_wording = llVar.rpC;
            bankcard.field_support_lqt_turn_in = llVar.rpF;
            bankcard.field_support_lqt_turn_out = llVar.rpG;
            bankcard.field_is_hightlight_pre_arrive_time_wording = llVar.rpE;
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "parseFromBindQueryRecord() error:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void d(Bankcard bankcard) {
        if (bankcard != null) {
            if (bankcard.bOs()) {
                bankcard.field_desc = bankcard.field_bankName;
            } else if (bankcard.bOw()) {
                bankcard.field_desc = ad.getContext().getString(i.wallet_honeypay_card_desc, new Object[]{bankcard.pmj, e.dy(bankcard.pmg, 8)});
            } else if (bankcard.bOu()) {
                bankcard.field_desc = ad.getContext().getString(i.wallet_credit_card_desc, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else if (bankcard.bOr()) {
                bankcard.field_desc = ad.getContext().getString(i.wallet_wxcredit_card_desc, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else {
                bankcard.field_desc = ad.getContext().getString(i.wallet_deposit_card_desc, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            }
        }
    }
}
