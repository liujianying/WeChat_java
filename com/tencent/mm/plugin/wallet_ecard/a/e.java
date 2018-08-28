package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public int hUm = 0;
    public String hUn = "";
    public axn pCc;
    public String token = null;

    public e(String str, String str2, int i, String str3) {
        a aVar = new a();
        aVar.dIG = new axm();
        aVar.dIH = new axn();
        aVar.dIF = 1958;
        aVar.uri = "/cgi-bin/mmpay-bin/openecardauth";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        axm axm = (axm) this.diG.dID.dIL;
        axm.rhb = str;
        axm.saD = str2;
        axm.bVB = i;
        axm.token = str3;
        this.token = null;
        x.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", new Object[]{str, Integer.valueOf(i), str3, Boolean.valueOf(bi.oW(str2))});
        x.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", new Object[]{str, Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pCc = (axn) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", new Object[]{Integer.valueOf(this.pCc.hwV), this.pCc.hwW, Boolean.valueOf(this.pCc.saF)});
        if (!bi.oW(this.pCc.saE)) {
            x.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", new Object[]{this.pCc.saE});
            try {
                JSONObject jSONObject = new JSONObject(this.pCc.saE);
                this.hUm = jSONObject.optInt("retcode", 0);
                this.hUn = jSONObject.optString("retmsg", "");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", e, "", new Object[0]);
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1958;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
