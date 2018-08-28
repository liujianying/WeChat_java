package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends l implements k {
    private final b diG;
    private e diJ;
    public String huH;
    public int huI = 0;
    public String huJ;
    public int huK;
    public String huL;
    public String hyn;

    public f(String str, int i, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new asx();
        aVar.dIH = new asy();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.dIF = 907;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        asx asx = (asx) this.diG.dID.dIL;
        asx.cac = str;
        asx.rVh = i2;
        asx.rVg = i;
        asx.scene = i3;
        this.hyn = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            asy asy = (asy) this.diG.dIE.dIL;
            x.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + asy.hwU);
            Object obj = asy.hwU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    this.huH = jSONObject.optString("mark_user");
                    this.huI = jSONObject.optInt("mark_succ", 0);
                    this.huJ = jSONObject.optString("mark_card_id");
                    this.huK = jSONObject.optInt("expire_time", 0);
                    this.huL = jSONObject.optString("pay_qrcode_wording");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 907;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
