package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private b diG;
    private e diJ;
    public big eXJ;

    public i(com.tencent.mm.plugin.q.a.b bVar) {
        a aVar = new a();
        aVar.dIG = new bif();
        aVar.dIH = new big();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.dIF = 1180;
        this.diG = aVar.KT();
        bif bif = (bif) this.diG.dID.dIL;
        bif.source = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        au.HU();
        stringBuilder.append(stringBuilder2.append(c.Df()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals("0")) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.knA + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.knC + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.knD + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.knG + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.knI + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.knE + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.knA + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.knB + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.knH + "\"},{\"key\": \"email\",\"value\": \"" + bVar.csD + "\"}]}}");
        }
        stringBuilder.append("]}");
        bif.rLM = stringBuilder.toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.eXJ = (big) ((b) qVar).dIE.dIL;
            if (!(this.eXJ == null || this.eXJ.siW == null || this.eXJ.siW.size() <= 0 || this.eXJ.siW.get(0) == null)) {
                x.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((alj) this.eXJ.siW.get(0)).group_id);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1180;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
