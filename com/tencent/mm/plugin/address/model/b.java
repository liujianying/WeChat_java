package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;

    public b() {
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
            com.tencent.mm.plugin.address.a.a.Zw().eXD = new com.tencent.mm.plugin.q.a.a();
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            ajb ajb = (ajb) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + ajb.rLM);
            if (ajb.rLM != null) {
                try {
                    JSONArray jSONArray = new JSONObject(ajb.rLM).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                com.tencent.mm.plugin.q.a.b bVar = new com.tencent.mm.plugin.q.a.b();
                                bVar.knA = jSONObject.getInt("group_id");
                                bVar.knJ = jSONObject.getString("invoice_url");
                                x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt("group_id") + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
                                JSONArray jSONArray2 = jSONObject.getJSONArray("field_list");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5;
                                        if (i6 < jSONArray2.length()) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i6);
                                            String string = jSONObject2.getString("key");
                                            Object obj = -1;
                                            switch (string.hashCode()) {
                                                case -1787383122:
                                                    if (string.equals("bank_name")) {
                                                        obj = 2;
                                                        break;
                                                    }
                                                    break;
                                                case -192204195:
                                                    if (string.equals("tax_number")) {
                                                        obj = 1;
                                                        break;
                                                    }
                                                    break;
                                                case 3575610:
                                                    if (string.equals("type")) {
                                                        obj = 4;
                                                        break;
                                                    }
                                                    break;
                                                case 96619420:
                                                    if (string.equals("email")) {
                                                        obj = 5;
                                                        break;
                                                    }
                                                    break;
                                                case 106642798:
                                                    if (string.equals("phone")) {
                                                        obj = 6;
                                                        break;
                                                    }
                                                    break;
                                                case 110371416:
                                                    if (string.equals("title")) {
                                                        obj = null;
                                                        break;
                                                    }
                                                    break;
                                                case 330208940:
                                                    if (string.equals("bank_number")) {
                                                        obj = 3;
                                                        break;
                                                    }
                                                    break;
                                                case 944498430:
                                                    if (string.equals("company_address_detail")) {
                                                        obj = 7;
                                                        break;
                                                    }
                                                    break;
                                            }
                                            switch (obj) {
                                                case null:
                                                    bVar.title = jSONObject2.getString("value");
                                                    break;
                                                case 1:
                                                    bVar.knC = jSONObject2.getString("value");
                                                    break;
                                                case 2:
                                                    bVar.knE = jSONObject2.getString("value");
                                                    break;
                                                case 3:
                                                    bVar.knD = jSONObject2.getString("value");
                                                    break;
                                                case 4:
                                                    bVar.type = jSONObject2.getString("value");
                                                    break;
                                                case 5:
                                                    bVar.csD = jSONObject2.getString("value");
                                                    break;
                                                case 6:
                                                    bVar.knG = jSONObject2.getString("value");
                                                    bVar.knH = jSONObject2.getString("value");
                                                    break;
                                                case 7:
                                                    bVar.knI = jSONObject2.getString("value");
                                                    break;
                                                default:
                                                    break;
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.address.b.a.a Zw = com.tencent.mm.plugin.address.a.a.Zw();
                                if (bVar.type != null && bVar.type.equals("0")) {
                                    bVar.knB = "";
                                    bVar.knH = "";
                                    bVar.csD = "";
                                    Zw.eXD.knz.add(bVar);
                                } else if (bVar.type != null && bVar.type.equals("1")) {
                                    bVar.knB = bVar.title;
                                    bVar.title = "";
                                    bVar.knG = "";
                                    bVar.knC = "";
                                    bVar.knD = "";
                                    bVar.knE = "";
                                    bVar.knI = "";
                                    Zw.eXD.knz.add(bVar);
                                }
                                x.i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e) {
                                x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no." + i4);
                            }
                        }
                    }
                } catch (JSONException e2) {
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
