package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends a {
    public long cfh;
    public String desc;
    public String hUA;
    public int hUB;
    public int hUm;
    public String hUn;
    public String hUo;
    public int hUp;
    public String hUq;
    public String hUr;
    public String hUs;
    public String hUt;
    public String hUu;
    public String hUv;
    public int hUw;
    public String hUx;
    public String hUy;
    public String hUz;

    public m(int i) {
        Map hashMap = new HashMap();
        hashMap.put("set_amount", "0");
        hashMap.put("wallet_type", String.valueOf(i));
        F(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
    }

    public m(long j, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!bi.oW(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        F(hashMap);
        this.cfh = j;
        this.desc = str;
        x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[]{Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hUm = jSONObject.optInt("retcode", 0);
        this.hUn = jSONObject.optString("retmsg", "");
        this.hUo = jSONObject.optString("qrcode_url", "");
        this.hUp = jSONObject.optInt("alert_type", 0);
        this.hUq = jSONObject.optString("alert_title", "");
        this.hUr = jSONObject.optString("left_button_text", "");
        this.hUs = jSONObject.optString("right_button_text", "");
        this.hUt = jSONObject.optString("right_button_url", "");
        this.hUu = jSONObject.optString("bottom_text", "");
        this.hUv = jSONObject.optString("bottom_url", "");
        this.hUw = jSONObject.optInt("currency", 0);
        this.hUx = jSONObject.optString("currencyunit", "");
        this.hUy = jSONObject.optString("notice", "");
        this.hUz = jSONObject.optString("notice_url", "");
        this.hUA = jSONObject.optString("recv_realname", "");
        this.hUB = jSONObject.optInt("set_amount", 0);
        if (this.hUB == 0) {
            g.Ek();
            g.Ei().DT().a(aa.a.sXo, this.hUo);
            x.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[]{this.hUo});
        }
        x.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[]{this.hUo, Integer.valueOf(this.hUw)});
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    public final int getType() {
        return 1335;
    }

    public final int aBM() {
        return 1335;
    }

    public final boolean aBN() {
        return true;
    }
}
