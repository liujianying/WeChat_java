package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends i {
    public static String lKb = "3";
    public String lJW = "";
    public String lJX = "";
    public String lJY = "";
    public String lJZ = "";
    public String lKa = "";
    public String lKc = "";
    public int lKd = 0;
    public String lKe = "";
    public String lKf = "";
    public String lKg = "";
    public int lKh = 20000;
    public String token = "";

    public k(Bankcard bankcard, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.zz());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.qVN));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.lKh = i;
        String ce = ac.ce(ac.ce(e.getUsername()) + ac.ce(q.zz()));
        hashMap.put("user_id", ce);
        a cCW = a.cCW();
        b.cCO();
        String dw = cCW.dw(ce, b.cCQ() ? 1 : 0);
        Object[] objArr = new Object[2];
        objArr[0] = dw;
        b.cCO();
        objArr[1] = Boolean.valueOf(b.cCQ());
        x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", objArr);
        hashMap.put("crt_csr", dw);
        hashMap.put(DownloadSettingTable$Columns.TYPE, lKb);
        hashMap.put("version_number", lKb);
        F(hashMap);
    }

    public final int aBO() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lJX = jSONObject.optString("crt_crt");
            this.lJW = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.lJY = jSONObject.optString("valid_end");
            this.lJZ = jSONObject.optString("encrypt_str");
            this.lKa = jSONObject.optString("deviceid");
            if (a.cCW().importCert(this.lJW, this.lJX)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.lKc = jSONObject.optString("token_v2");
            this.lKd = jSONObject.optInt("algorithm_type");
            this.lKe = jSONObject.optString("card_list");
            this.lKf = jSONObject.optString("key_list");
            this.lKg = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            String optString3 = jSONObject.optString("code_ver");
            int optInt2 = jSONObject.optInt("cipher_type", 0);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196617, this.lJW);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196626, this.lJY);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196627, this.lJZ);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196628, this.lKa);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196630, "1");
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196632, (System.currentTimeMillis() / 1000));
            com.tencent.mm.plugin.offline.c.a.n(this.token, this.lKc, this.lKe, this.lKf);
            com.tencent.mm.plugin.offline.c.a.uq(this.lKd);
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196647, this.lKg);
            com.tencent.mm.plugin.offline.c.a.Jd(optString);
            com.tencent.mm.plugin.offline.k.bkO();
            optString = com.tencent.mm.plugin.offline.k.uk(196617);
            a.cCW();
            a.clearToken(optString);
            a.cCW();
            x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[]{Boolean.valueOf(a.t(this.lJW, optString2, optInt2 == 1)), this.lJW});
            if (a.t(this.lJW, optString2, optInt2 == 1)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                a.cCW();
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(a.getLastError()).toString());
            }
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196649, String.valueOf(optInt));
            g.Ek();
            g.Ei().DT().a(aa.a.sOy, q.zy());
            g.Ek();
            g.Ei().DT().a(aa.a.sOz, optString3);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.offline.k.bkO();
            com.tencent.mm.plugin.offline.k.aw(196630, "0");
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.f.a.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.f.a.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.mEJ.b(arrayList, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cCW().cCX();
    }

    public final int If() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
