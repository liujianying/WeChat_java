package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends h {
    public String lJY;
    public String lJZ;
    public String lKa;
    public String lKc;
    public int lKd;
    public String lKe;
    public String lKf;
    public String lKg;
    private String lKi;
    private int lKj;
    public String lKk;
    public int lKl;
    int lKm;
    public String token;

    public m(String str, int i) {
        this(str, i, i);
    }

    public m(String str, int i, int i2) {
        int i3;
        CharSequence genUserSig;
        this.token = "";
        this.lJY = "";
        this.lJZ = "";
        this.lKa = "";
        this.lKc = "";
        this.lKd = 0;
        this.lKe = "";
        this.lKf = "";
        this.lKg = "";
        this.lKl = 0;
        this.lKm = 0;
        x.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[]{Integer.valueOf(i), bi.cjd().toString()});
        Object blM = a.blM();
        k.bkO();
        String uk = k.uk(196628);
        if (TextUtils.isEmpty(uk)) {
            uk = q.zz();
        }
        if (TextUtils.isEmpty(blM)) {
            uk = uk + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000);
        } else {
            uk = uk + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000) + "&" + blM;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_src", uk);
        String str2 = "";
        k.bkO();
        String uk2 = k.uk(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        h.mEJ.a(135, (long) i3, 1, true);
        com.tencent.mm.wallet_core.c.a.cCW();
        if (com.tencent.mm.wallet_core.c.a.isCertExist(uk2)) {
            com.tencent.mm.wallet_core.c.a.cCW();
            genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(uk2, uk);
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cCW();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
            h.mEJ.a(135, 6, 1, true);
            g.Ek();
            uk = (String) g.Ei().DT().get(aa.a.sOy, "");
            if (uk == null || !uk.equals(q.zy())) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                h.mEJ.a(135, 5, 1, true);
            } else {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
            }
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + uk2);
            Object genUserSig2 = str2;
        }
        if (TextUtils.isEmpty(genUserSig2)) {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            h.mEJ.a(135, 4, 1, true);
        } else {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig2);
        hashMap.put("cert_no", uk2);
        hashMap.put("type", k.lKb);
        hashMap.put("version_number", k.lKb);
        if (a.blL() == 2) {
            hashMap.put("last_token", a.blN());
        } else {
            hashMap.put("last_token", a.blM());
        }
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[]{Boolean.valueOf(k.lJx)});
        if (i == 65281) {
            hashMap.put("fetch_tag", "2");
        } else if (k.lJx) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", "0");
        }
        if (i == 65281) {
            i = 3;
        }
        hashMap.put("scene", String.valueOf(i));
        F(hashMap);
    }

    public final int aBO() {
        if (k.lJx) {
            return 52;
        }
        return 1725;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.lJY = jSONObject.optString("valid_end");
            this.lJZ = jSONObject.optString("encrypt_str");
            this.lKa = jSONObject.optString("deviceid");
            this.lKc = jSONObject.optString("token_v2");
            this.lKd = jSONObject.optInt("algorithm_type");
            this.lKe = jSONObject.optString("card_list");
            this.lKf = jSONObject.optString("key_list");
            this.lKg = jSONObject.optString("token_pin");
            this.lKi = jSONObject.optString("auth_codes");
            this.lKj = jSONObject.optInt("update_interval");
            this.lKk = jSONObject.optString("code_ver");
            this.lKl = jSONObject.optInt("reget_token_num", 0);
            this.lKm = jSONObject.optInt("cipher_type", 0);
            if (this.lKl > 0) {
                k.lJy = this.lKl;
            } else {
                k.lJy = 10;
            }
            x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[]{jSONObject.toString()});
        }
    }

    public final boolean bkV() {
        boolean z = true;
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.bkO();
        k.aw(196626, this.lJY);
        k.bkO();
        k.aw(196627, this.lJZ);
        k.bkO();
        k.aw(196628, this.lKa);
        k.bkO();
        k.aw(196632, (System.currentTimeMillis() / 1000));
        a.n(this.token, this.lKc, this.lKe, this.lKf);
        a.uq(this.lKd);
        k.bkO();
        k.aw(196647, this.lKg);
        k.bkO();
        String uk = k.uk(196617);
        com.tencent.mm.wallet_core.c.a.cCW();
        com.tencent.mm.wallet_core.c.a.clearToken(uk);
        com.tencent.mm.wallet_core.c.a.cCW();
        String str = this.lKi;
        if (this.lKm != 1) {
            z = false;
        }
        z = com.tencent.mm.wallet_core.c.a.t(uk, str, z);
        if (z) {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cCW();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
        }
        k.bkO();
        k.aw(196649, this.lKj);
        g.Ek();
        g.Ei().DT().a(aa.a.sOz, this.lKk);
        return z;
    }

    public final int If() {
        if (k.lJx) {
            return 571;
        }
        return 1725;
    }

    public final String getUri() {
        if (k.lJx) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
