package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v extends i implements d {
    public int amount;
    public String bOe;
    public String bQa = null;
    public String bXz;
    public a cao;
    public String hTI;
    public String hVy;
    private int lNG;
    public int mxB = 0;
    public String mxC;
    public String mxD;
    public double mxE;
    public double mxF;
    public String mxG;
    public boolean mxH;
    public double mxI;
    public String mxJ;
    public double mxK;
    public double mxL;
    public String mxM;
    public String mxN;
    public String mxO;
    public double mxP = 0.0d;
    public String mxQ = "";
    public String mxR = "";
    public String mxS;
    public int mxT;
    public String mxU;
    public String mxV;
    public int mxW;
    public String mxX;
    public String mxY;
    public String mxZ;
    public String mxk = "";
    public fo mxl = null;
    public String mya;

    public v(double d, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, fo foVar) {
        x.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), str8, str9, str10, str11});
        this.mxP = d;
        this.lNG = i;
        this.mxk = str8;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("transfer_scene", String.valueOf(i2));
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("receiver_openid", str7);
        hashMap.put("mask_truename", str3);
        hashMap.put("mch_name", str9);
        hashMap.put("nickname", str10);
        hashMap.put("receiver_true_name", str11);
        String str12 = "dynamic_code_source";
        Object obj = (foVar == null || foVar.bNX.bOa != 1) ? "0" : "1";
        hashMap.put(str12, obj);
        this.mxl = foVar;
        try {
            long longValue;
            int i4;
            Map hashMap2;
            if (this.lNG == 33 || this.lNG == 32) {
                x.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[]{str4, str5});
                if (!bi.oW(str4)) {
                    hashMap.put("f2f_payer_desc", p.encode(str4, "UTF-8"));
                }
                if (!bi.oW(str5)) {
                    hashMap.put("desc", p.encode(str5, "UTF-8"));
                }
                if (!bi.oW(str8)) {
                    hashMap.put("dynamic_code_url", p.encode(str8, "UTF-8"));
                }
                hashMap.put("transfer_qrcode_id", str6);
                if (i2 == 0 || i2 == 2) {
                    g.Ek();
                    longValue = ((Long) g.Ei().DT().get(147457, Long.valueOf(0))).longValue();
                    i4 = 0;
                    if ((16 & longValue) != 0) {
                        i4 = 2;
                    } else if ((longValue & 32) != 0) {
                        i4 = 1;
                    }
                    hashMap.put("delay_confirm_flag", String.valueOf(i4));
                    x.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
                }
                F(hashMap);
                if (this.lNG != 32 || this.lNG == 33) {
                    hashMap2 = new HashMap();
                    hashMap2.put("channel", String.valueOf(i3));
                    aC(hashMap2);
                }
                return;
            }
            if (!bi.oW(str4)) {
                hashMap.put("desc", p.encode(str4, "UTF-8"));
            }
            hashMap.put("transfer_qrcode_id", str6);
            g.Ek();
            longValue = ((Long) g.Ei().DT().get(147457, Long.valueOf(0))).longValue();
            i4 = 0;
            if ((16 & longValue) != 0) {
                i4 = 2;
            } else if ((longValue & 32) != 0) {
                i4 = 1;
            }
            hashMap.put("delay_confirm_flag", String.valueOf(i4));
            x.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i4)});
            F(hashMap);
            if (this.lNG != 32) {
            }
            hashMap2 = new HashMap();
            hashMap2.put("channel", String.valueOf(i3));
            aC(hashMap2);
        } catch (UnsupportedEncodingException e) {
            x.e("Micromsg.NetSceneTenpayRemittanceGen", e.getMessage(), new Object[]{e});
        }
    }

    public final int If() {
        if (this.lNG == 32 || this.lNG == 33) {
            return 1582;
        }
        return 1544;
    }

    public final int aBO() {
        return 0;
    }

    public final String getUri() {
        if (this.lNG == 32 || this.lNG == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        x.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i + " errMsg: " + str);
        if (i == 0 || i == 2) {
            if (jSONObject.has("used_fee")) {
                this.mxL = jSONObject.optDouble("used_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.bQa = jSONObject.optString("req_key");
            this.mxB = jSONObject.optInt("tansfering_num", 0);
            this.mxC = jSONObject.optString("transfer_interrupt_desc");
            this.mxD = jSONObject.optString("appmsgcontent");
            this.mxG = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") != 1) {
                z = false;
            }
            this.mxH = z;
            this.mxM = jSONObject.optString("receiver_true_name");
            this.mxN = jSONObject.optString("f2f_id", "");
            this.hTI = jSONObject.optString("trans_id", "");
            this.hVy = jSONObject.optString("extend_str", "");
            this.mxO = jSONObject.optString("receiver_open_id", "");
            this.amount = jSONObject.optInt("amount", 0);
            this.bXz = jSONObject.optString("transfer_id", "");
            this.bOe = jSONObject.optString("transaction_id", "");
            this.mxS = jSONObject.optString("receiver_openid", "");
            if (bi.oW(this.mxM)) {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.mxI = jSONObject.optDouble("remain_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.mxK = jSONObject.optDouble("exceed_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.mxE = jSONObject.optDouble("charge_fee");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.mxF = jSONObject.optDouble("free_limit");
            } else {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                x.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("showmessage");
                aVar.kRu = optJSONObject.optString("left_button_wording");
                aVar.kRv = optJSONObject.optString("right_button_wording");
                aVar.hUt = optJSONObject.optString("right_button_url");
                this.cao = aVar;
                this.cao.bSc = str;
            }
            if (jSONObject.has("fee")) {
                this.mxQ = jSONObject.optString("fee");
            }
            if (jSONObject.has("double_check_wording")) {
                x.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
                this.mxR = jSONObject.optString("double_check_wording");
            }
            this.mxT = jSONObject.optInt("scan_scene", 0);
            this.mxU = jSONObject.optString("placeorder_suc_sign");
            this.mxV = jSONObject.optString("pay_suc_extend");
            if (TextUtils.isEmpty(this.mxD)) {
                x.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
            this.mxW = jSONObject.optInt("get_dynamic_code_flag", 0);
            this.mxX = jSONObject.optString("get_dynamic_code_sign", "");
            this.mxY = jSONObject.optString("get_dynamic_code_extend", "");
            this.mxZ = jSONObject.optString("show_paying_wording", "");
            this.mya = jSONObject.optString("dynamic_code_spam_wording", "");
        }
    }

    public final boolean brf() {
        return true;
    }
}
