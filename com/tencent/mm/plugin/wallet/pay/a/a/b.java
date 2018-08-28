package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b extends j {
    private Map<String, String> lKr;
    private Map<String, String> peZ;
    public boolean pfa;
    public Orders pfb;
    public Authen pfc;
    public String pfd;
    public String pfe;
    private String pff;
    public int pfg;
    public String pfh;
    public int pfi;
    public String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b) {
        String str = null;
        this.pfa = false;
        this.pfb = null;
        this.token = null;
        this.pfd = null;
        this.pfe = null;
        this.pff = null;
        this.pfg = 0;
        this.pfi = 0;
        this.pfc = authen;
        this.pfb = orders;
        if (authen == null) {
            throw new IllegalArgumentException("authen == null");
        }
        List list = orders.ppf;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).bOe;
        }
        a(orders.bOd, str, authen.mpb.bVY, authen.mpb.bVU, authen.lMV, authen.lMW);
        if (authen.mpb == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.mpb.bVU);
        this.lKr = new HashMap();
        this.peZ = new HashMap();
        boolean z2 = (z || bi.oW(this.pfc.pli)) ? false : true;
        x.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[]{Boolean.valueOf(z2)});
        a(authen.mpb, this.lKr, this.peZ, z2);
        if (z) {
            this.lKr.put("brief_reg", "1");
        } else {
            this.lKr.put("passwd", authen.pli);
        }
        this.ppo = orders.ppo;
        this.lKr.put("default_favorcomposedid", authen.plt);
        this.lKr.put("favorcomposedid", authen.plu);
        this.lKr.put("arrive_type", authen.plq);
        this.lKr.put("sms_flag", authen.plv);
        this.lKr.put("ban_sms_bind_serial", authen.plw);
        this.lKr.put("ban_sms_bank_type", authen.plx);
        this.lKr.put("busi_sms_flag", authen.ply);
        this.lKr.put("buttontype", authen.mpb.qUR);
        this.lKr.put("mobile_area", authen.plz);
        x.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[]{Integer.valueOf(authen.mpb.qUR), Integer.valueOf(this.ppo), authen.plz});
        switch (authen.bWA) {
            case 1:
                this.lKr.put("flag", "1");
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("true_name", authen.plj);
                this.lKr.put("identify_card", authen.plk);
                if (authen.pll > 0) {
                    this.lKr.put("cre_type", authen.pll);
                }
                this.lKr.put("mobile_no", authen.pjw);
                this.lKr.put("bank_card_id", authen.plm);
                if (!bi.oW(authen.pln)) {
                    this.lKr.put("cvv2", authen.pln);
                }
                if (!bi.oW(authen.plo)) {
                    this.lKr.put("valid_thru", authen.plo);
                    break;
                }
                break;
            case 2:
                this.lKr.put("flag", "2");
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("h_bind_serial", authen.lMW);
                this.lKr.put("card_tail", authen.plp);
                if (!bi.oW(authen.plj)) {
                    this.lKr.put("true_name", authen.plj);
                }
                if (!bi.oW(authen.plk)) {
                    this.lKr.put("identify_card", authen.plk);
                }
                this.lKr.put("cre_type", authen.pll);
                this.lKr.put("mobile_no", authen.pjw);
                this.lKr.put("bank_card_id", authen.plm);
                if (!bi.oW(authen.pln)) {
                    this.lKr.put("cvv2", authen.pln);
                }
                if (!bi.oW(authen.plo)) {
                    this.lKr.put("valid_thru", authen.plo);
                    break;
                }
                break;
            case 3:
                if (authen.plh == 1) {
                    this.lKr.put("reset_flag", "1");
                    if (!bi.oW(authen.pjw)) {
                        this.lKr.put("mobile_no", authen.pjw);
                    }
                    if (!bi.oW(authen.pln)) {
                        this.lKr.put("cvv2", authen.pln);
                    }
                    if (!bi.oW(authen.plo)) {
                        this.lKr.put("valid_thru", authen.plo);
                    }
                }
                this.lKr.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("bind_serial", authen.lMW);
                break;
            case 4:
                this.lKr.put("flag", "4");
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("first_name", authen.plr);
                this.lKr.put("last_name", authen.pls);
                this.lKr.put("country", authen.country);
                this.lKr.put("area", authen.csK);
                this.lKr.put("city", authen.csL);
                this.lKr.put("address", authen.dRH);
                this.lKr.put("phone_number", authen.knG);
                this.lKr.put("zip_code", authen.eXM);
                this.lKr.put("email", authen.csD);
                this.lKr.put("bank_card_id", authen.plm);
                if (!bi.oW(authen.pln)) {
                    this.lKr.put("cvv2", authen.pln);
                }
                if (!bi.oW(authen.plo)) {
                    this.lKr.put("valid_thru", authen.plo);
                    break;
                }
                break;
            case 5:
                this.lKr.put("flag", "5");
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("first_name", authen.plr);
                this.lKr.put("last_name", authen.pls);
                this.lKr.put("country", authen.country);
                this.lKr.put("area", authen.csK);
                this.lKr.put("city", authen.csL);
                this.lKr.put("address", authen.dRH);
                this.lKr.put("phone_number", authen.knG);
                this.lKr.put("zip_code", authen.eXM);
                this.lKr.put("email", authen.csD);
                this.lKr.put("bank_card_id", authen.plm);
                if (!bi.oW(authen.pln)) {
                    this.lKr.put("cvv2", authen.pln);
                }
                if (!bi.oW(authen.plo)) {
                    this.lKr.put("valid_thru", authen.plo);
                }
                this.lKr.put("h_bind_serial", authen.lMW);
                this.lKr.put("card_tail", authen.plp);
                break;
            case 6:
                if (authen.plh == 1) {
                    this.lKr.put("reset_flag", "1");
                    if (!bi.oW(authen.pln)) {
                        this.lKr.put("cvv2", authen.pln);
                    }
                    if (!bi.oW(authen.plo)) {
                        this.lKr.put("valid_thru", authen.plo);
                    }
                }
                this.lKr.put("phone_number", authen.pjw);
                this.lKr.put("flag", "6");
                this.lKr.put("bank_type", authen.lMV);
                this.lKr.put("bind_serial", authen.lMW);
                break;
        }
        Q(this.lKr);
        F(this.lKr);
        Map aNs = ((k) g.l(k.class)).aNs();
        if (aNs != null) {
            this.peZ.putAll(aNs);
        }
        if (p.cDb()) {
            this.peZ.put("uuid_for_bindcard", p.cDd());
            this.peZ.put("bindcard_scene", p.cDc());
        }
        aC(this.peZ);
    }

    protected void Q(Map<String, String> map) {
    }

    public final boolean bkT() {
        super.bkT();
        this.lKr.put("is_repeat_send", "1");
        F(this.lKr);
        return true;
    }

    public int aBO() {
        return 0;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        x.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        x.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[]{this.pfd});
        this.pfa = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.pfd = jSONObject.optString("balance_mobile");
        this.pfe = jSONObject.optString("balance_help_url");
        this.pff = jSONObject.optString("modify_mobile_url");
        String optString = jSONObject.optString("bind_serial");
        if (!bi.oW(optString)) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.pgm = true;
            this.pfb = Orders.a(jSONObject, this.pfb);
        } else {
            this.pgm = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("verify_cre_tail_info");
        if (optJSONObject != null) {
            this.pfg = optJSONObject.optInt("is_can_verify_tail", 0);
            this.pfh = optJSONObject.optString("verify_tail_wording");
        }
        this.pfi = jSONObject.optInt("no_reset_mobile", 0);
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.pfc.mpb.bVY);
        if (i == 0 && this.pfc.mpb.bVY == 39) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            com.tencent.mm.plugin.wallet_core.e.b.am(jSONObject);
            return;
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + i);
    }

    public final String blM() {
        return this.token;
    }

    public String getUri() {
        if (this.pfc.mpb.bVY == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.pfc.mpb.bVY == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    public int If() {
        if (this.pfc.mpb.bVY == 11) {
            return 1610;
        }
        if (this.pfc.mpb.bVY == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean bNu() {
        return this.pfc.mpb.pxN == 1;
    }

    public final boolean bNv() {
        if (this.pfc.mpb.bVY == 11 || this.pfc.mpb.bVY == 21) {
            return true;
        }
        return false;
    }
}
