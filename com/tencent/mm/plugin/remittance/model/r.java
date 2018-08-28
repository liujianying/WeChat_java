package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r extends a {
    public long cfh;
    public String desc;
    public String hUA;
    public int hUB;
    public int hUw;
    public String hUx;
    public String hUy;
    public String hUz;
    public String mxw;
    public String mxx;
    public String mxy;

    public r(String str) {
        Map hashMap = new HashMap();
        try {
            if (!bi.oW(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        F(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", new Object[]{str});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.mxw = jSONObject.optString("recv_username", "");
        this.hUA = jSONObject.optString("recv_realname", "");
        this.mxx = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.cfh = jSONObject.optLong("amount", 0);
        this.hUB = jSONObject.optInt("set_amount", 0);
        this.hUw = jSONObject.optInt("currency", 0);
        this.hUx = jSONObject.optString("currencyunit", "");
        this.mxy = jSONObject.optString("qrcodeid", "");
        this.hUy = jSONObject.optString("notice", "");
        this.hUz = jSONObject.optString("notice_url", "");
        x.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", new Object[]{this.mxw, this.mxx, this.desc, Long.valueOf(this.cfh), Integer.valueOf(this.hUB), this.hUx});
        x.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", new Object[]{this.hUA});
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    public final int getType() {
        return 1301;
    }

    public final int aBM() {
        return 1301;
    }
}
