package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public int phg;
    public String phh;
    public int phi;
    public String phj;
    public String phk;
    public String phl;

    public c() {
        Map hashMap = new HashMap();
        hashMap.put("deviceid", q.getDeviceID(ad.getContext()));
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        x.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[]{jSONObject.toString()});
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", "0");
            if (!xW(optString)) {
                optString = "0";
            }
            this.phg = Integer.valueOf(optString).intValue();
            this.phh = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!xW(optString)) {
                optString = "84600";
            }
            this.phi = Integer.valueOf(optString).intValue();
            this.phj = jSONObject.optString("deduct_title", "");
            this.phk = jSONObject.optString("realname_url", "");
            this.phl = jSONObject.optString("forget_pwd_url", "");
            optString = jSONObject.optString("payway_select_wording", "");
            String optString2 = jSONObject.optString("payway_change_wording", "");
            z zVar = new z();
            zVar.field_is_show = this.phg;
            zVar.field_pref_key = "wallet_open_auto_pay";
            zVar.field_pref_title = this.phj;
            zVar.field_pref_url = this.phh;
            h bOV = o.bOV();
            String str2 = "wallet_open_auto_pay";
            if (!bi.oW(str2)) {
                bOV.diF.fV("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str2 + "'");
            }
            x.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[]{Integer.valueOf(this.phi), this.phl});
            o.bOV().b(zVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject != null) {
                String optString3 = optJSONObject.optString("unreg_title", "");
                String optString4 = optJSONObject.optString("unreg_url", "");
                g.Ek();
                g.Ei().DT().a(a.sYH, optString3);
                g.Ek();
                g.Ei().DT().a(a.sYI, optString4);
            } else {
                g.Ek();
                g.Ei().DT().a(a.sYH, "");
                g.Ek();
                g.Ei().DT().a(a.sYI, "");
            }
            g.Ek();
            g.Ei().DT().a(a.sSY, Long.valueOf(new Date().getTime() / 1000));
            g.Ek();
            g.Ei().DT().a(a.sSZ, Integer.valueOf(this.phi));
            g.Ek();
            g.Ei().DT().a(a.sTf, this.phk);
            g.Ek();
            g.Ei().DT().a(a.sTf, this.phl);
            if (!bi.oW(optString)) {
                g.Ek();
                g.Ei().DT().a(a.sTm, optString);
            }
            if (!bi.oW(optString2)) {
                g.Ek();
                g.Ei().DT().a(a.sTn, optString2);
            }
            g.Ek();
            g.Ei().DT().lm(true);
        }
    }

    public static boolean bFZ() {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(a.sSY, Long.valueOf(0))).longValue();
        g.Ek();
        x.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[]{Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) g.Ei().DT().get(a.sSZ, Integer.valueOf(0))).intValue()) + longValue)});
        if (longValue <= 0) {
            return true;
        }
        if (Long.valueOf(new Date().getTime() / 1000).longValue() > longValue + ((long) r0)) {
            return true;
        }
        return false;
    }

    private static boolean xW(String str) {
        if (bi.oW(str)) {
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            charAt = str.charAt(length);
            if (charAt < '0') {
                return false;
            }
        } while (charAt <= '9');
        return false;
    }

    public final int If() {
        return 1654;
    }

    public final int bNX() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
