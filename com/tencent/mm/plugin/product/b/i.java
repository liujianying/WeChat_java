package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends l implements k {
    private b diG;
    private e diJ;
    public LinkedList<sg> lRj;
    public String mUrl;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new agq();
        aVar.dIH = new agr();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        aVar.dIF = 579;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        agq agq = (agq) this.diG.dID.dIL;
        agq.rmM = str;
        this.mUrl = str2;
        agq.jPK = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        agr agr = (agr) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0 && agr.rmN == 0) {
            x.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + agr.rJY);
            try {
                JSONArray optJSONArray = new JSONObject(agr.rJY).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.lRj = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        sg sgVar = new sg();
                        sgVar.bHD = jSONObject.getString("title");
                        sgVar.rlz = jSONObject.getInt("fee");
                        this.lRj.add(sgVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && agr.rmN != 0) {
            i3 = agr.rmN;
            str = agr.rmO;
        }
        x.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
