package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ab extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public int hxg;
    public String hxh;
    public int hxi;
    public String hxj;

    public ab(LinkedList<ky> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        a aVar = new a();
        aVar.dIG = new abl();
        aVar.dIH = new abm();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        aVar.dIF = 690;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        abl abl = (abl) this.diG.dID.dIL;
        abl.qZS = linkedList;
        abl.cae = i;
        abl.rcN = str;
        abl.sign = str2;
        abl.qZO = str3;
        abl.qZN = str4;
        abl.rGk = str5;
        abl.qZP = i2;
    }

    public final int getType() {
        return 690;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.hwU = ((abm) this.diG.dIE.dIL).hwU;
            if (TextUtils.isEmpty(this.hwU)) {
                x.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.hwU);
                    this.hxg = jSONObject.optInt("accept_button_status", 0);
                    this.hxh = jSONObject.optString("accept_button_wording");
                    this.hxi = jSONObject.optInt("private_status", 0);
                    this.hxj = jSONObject.optString("private_wording");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    x.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
