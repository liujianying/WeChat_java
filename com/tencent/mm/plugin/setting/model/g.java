package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends l implements k {
    private b diG;
    private e diJ;

    public g() {
        a aVar = new a();
        aVar.dIG = new aja();
        aVar.dIH = new ajb();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.dIF = 1191;
        this.diG = aVar.KT();
        aja aja = (aja) this.diG.dID.dIL;
        aja.source = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        aja.rLL = linkedList;
        aja.rLK = false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            ajb ajb = (ajb) ((b) qVar).dIE.dIL;
            if (ajb.rLM != null) {
                try {
                    boolean z = new JSONObject(ajb.rLM).getBoolean("has_invoice_info");
                    x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is .." + z);
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sWn, Boolean.valueOf(z));
                } catch (JSONException e) {
                    x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
