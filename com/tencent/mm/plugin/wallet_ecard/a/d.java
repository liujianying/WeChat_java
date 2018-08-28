package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends l implements k {
    private b diG;
    private e diJ;
    public int hUm;
    public String hUn;
    public axp pBY;
    public String pBZ;
    public String pCa;
    public String pCb;

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this(str, str2, str3, str4, str5, i, z, false);
    }

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2) {
        this.hUm = 0;
        this.hUn = "";
        a aVar = new a();
        aVar.dIG = new axo();
        aVar.dIH = new axp();
        aVar.dIF = 1985;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        axo axo = (axo) this.diG.dID.dIL;
        axo.rhb = str;
        axo.rhc = str2;
        this.diG.dIU = true;
        if (z) {
            axo.saH = str3;
        } else {
            axo.saI = str3;
        }
        if (z2) {
            axo.saJ = 1;
        } else {
            axo.saJ = 0;
        }
        axo.pjw = str4;
        axo.lMV = str5;
        axo.bVB = i;
        axo.saG = false;
        this.pBZ = str3;
        this.pCa = str4;
        this.pCb = str5;
        x.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[]{str3});
        x.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s", new Object[]{str, str2, Integer.valueOf(i), str4, str5});
    }

    public d(String str, String str2, int i) {
        this.hUm = 0;
        this.hUn = "";
        a aVar = new a();
        aVar.dIG = new axo();
        aVar.dIH = new axp();
        aVar.dIF = 1985;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        axo axo = (axo) this.diG.dID.dIL;
        axo.rhb = str;
        axo.rhc = str2;
        this.diG.dIU = true;
        axo.saJ = 0;
        axo.bVB = i;
        axo.saG = true;
        x.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[]{str, str2, Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pBY = (axp) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.pBY.hwV), this.pBY.hwW});
        if (!bi.oW(this.pBY.saE)) {
            x.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[]{this.pBY.saE});
            try {
                JSONObject jSONObject = new JSONObject(this.pBY.saE);
                this.hUm = jSONObject.optInt("retcode", 0);
                this.hUn = jSONObject.optString("retmsg", "");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOpenECard", e, "", new Object[0]);
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
