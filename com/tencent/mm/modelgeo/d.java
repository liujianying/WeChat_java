package com.tencent.mm.modelgeo;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends l implements k {
    private String bPL = "";
    public final b diG;
    private e diJ;

    public d(double d, double d2) {
        a aVar = new a();
        aVar.dIG = new yy();
        aVar.dIH = new yz();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.dIF = 655;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        yy yyVar = (yy) this.diG.dID.dIL;
        yyVar.rjj = d;
        yyVar.rji = d2;
    }

    public final int getType() {
        return 655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.bPL = ((yz) ((b) qVar).dIE.dIL).rFb;
            x.d("MicroMsg.NetSceneGetAddress", this.bPL);
            if (this.diJ != null) {
                this.diJ.a(i2, i3, str, this);
            }
        } else if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final Addr OE() {
        if (bi.oW(this.bPL)) {
            return null;
        }
        Addr addr = new Addr();
        try {
            x.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[]{this.bPL});
            JSONObject jSONObject = new JSONObject(this.bPL);
            addr.dRR = jSONObject.optString("request_id");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            addr.dRH = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            addr.dRI = jSONObject2.getString("p");
            addr.dRJ = jSONObject2.getString("c");
            addr.dRL = jSONObject2.getString("d");
            addr.dRM = "";
            addr.dRN = "";
            addr.dRO = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.dRN = jSONObject2.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.dRO = jSONObject2.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.dRP = jSONObject2.getString("rough_address_name");
                    }
                } catch (Exception e) {
                }
            }
            if (!bi.oW(addr.dRO)) {
                addr.dRN = "";
            }
            return addr;
        } catch (Exception e2) {
            return null;
        }
    }
}
