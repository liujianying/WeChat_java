package com.tencent.mm.plugin.product.b;

import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public String lRl;
    public int lRm;
    public int lRn = Integer.MAX_VALUE;
    public int lRo = Integer.MAX_VALUE;
    public c lRp;
    public n lRq;
    public LinkedList<l> lRr = new LinkedList();
    public f lRs;
    public String lRt;
    public String lRu;
    public String lRv;
    public int status = 6;

    public static m a(m mVar, String str) {
        m mVar2;
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.lRl = jSONObject.getString("product_id");
            mVar2.lRm = jSONObject.getInt("product_type");
            mVar2.lRn = jSONObject.optInt("quantity", Integer.MAX_VALUE);
            mVar2.lRo = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt("status", 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.lRs = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.lRs;
                    j jVar = new j();
                    jVar.bWA = optJSONObject.getInt("flag");
                    fVar.lRN = jVar;
                } else {
                    mVar2.lRs.lRO = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.lRp = new c();
                mVar2.lRp.name = optJSONObject2.getString("name");
                mVar2.lRp.lRA = optJSONObject2.getInt("ori_price");
                mVar2.lRp.lRB = optJSONObject2.getInt("up_price");
                mVar2.lRp.lRC = optJSONObject2.getInt("low_price");
                mVar2.lRp.lRD = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!bi.oW(string)) {
                        mVar2.lRp.lRD.add(string);
                    }
                }
                mVar2.lRp.dzA = optJSONObject2.getString("digest");
                mVar2.lRp.lNV = optJSONObject2.getString("fee_type");
                mVar2.lRp.detail = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.lRp.lRL = new k();
                    mVar2.lRp.lRL.lMY = optJSONObject.optString("icon_url");
                    mVar2.lRp.lRL.url = optJSONObject.optString("url");
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.lRp.lRJ = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.lRU = jSONObject2.getString("id");
                        mVar3.lRV = jSONObject2.getString("name");
                        mVar3.lRW = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString("id");
                            hVar.name = jSONObject3.getString("name");
                            hVar.lRP = true;
                            mVar3.lRW.add(hVar);
                        }
                        mVar2.lRp.lRJ.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.lRp.lRK = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.jPe = jSONObject2.getString("name");
                        aVar.hcE = 0;
                        if (!bi.oW(aVar.jPe)) {
                            mVar2.lRp.lRK.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.jPe = jSONObject4.getString("name");
                            aVar2.lRx = jSONObject4.getString("tips");
                            aVar2.hcE = jSONObject4.getInt("type");
                            aVar2.jSA = jSONObject4.getString("content");
                            aVar2.jPG = jSONObject4.getString("icon_url");
                            mVar2.lRp.lRK.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.lRr = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.lRR = optJSONObject.getString("id_info");
                    lVar.lRS = optJSONObject.getInt("price");
                    lVar.lRn = optJSONObject.getInt("quantity");
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.lRT = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt("id");
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt("price");
                        lVar.lRT.add(eVar);
                    }
                    mVar2.lRr.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.lRq = new n();
                mVar2.lRq.bPS = optJSONObject.getString("appid");
                mVar2.lRq.name = optJSONObject.getString("name");
                mVar2.lRq.username = optJSONObject.getString("username");
                mVar2.lRq.lRX = optJSONObject.optString("logo");
                mVar2.lRq.bWA = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.lRu = optJSONObject.optString("self_buy_button_word");
                mVar2.lRv = optJSONObject.optString("product_mixed_h5_html");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        if (mVar == null) {
            mVar = new m();
        }
        Map z = bl.z(str, "mallProductInfo");
        if (z == null) {
            return null;
        }
        mVar.lRl = bi.oV((String) z.get(".mallProductInfo.id"));
        mVar.lRm = bi.getInt((String) z.get(".mallProductInfo.type"), 0);
        mVar.lRp = new c();
        mVar.lRp.name = bi.oV((String) z.get(".mallProductInfo.name"));
        mVar.lRp.dzA = bi.oV((String) z.get(".mallProductInfo.digest"));
        mVar.lRp.lRB = bi.getInt((String) z.get(".mallProductInfo.highPrice"), 0);
        mVar.lRp.lRC = bi.getInt((String) z.get(".mallProductInfo.lowPrice"), 0);
        mVar.lRp.lRA = bi.getInt((String) z.get(".mallProductInfo.originPrice"), 0);
        mVar.lRt = bi.oV((String) z.get(".mallProductInfo.sourceUrl"));
        int i2 = bi.getInt((String) z.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.lRp.lRD = new LinkedList();
            while (i < i2) {
                String oV;
                if (i == 0) {
                    oV = bi.oV((String) z.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    oV = bi.oV((String) z.get(".mallProductInfo.imgList.imgUrl" + i));
                }
                if (!bi.oW(oV)) {
                    mVar.lRp.lRD.add(oV);
                }
                i++;
            }
        }
        mVar.lRp.lRL = new k();
        mVar.lRp.lRL.url = bi.oV((String) z.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.lRp.lRL.lMY = bi.oV((String) z.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.lRq = new n();
        mVar.lRq.bPS = bi.oV((String) z.get(".mallProductInfo.sellerInfo.appID"));
        mVar.lRq.name = bi.oV((String) z.get(".mallProductInfo.sellerInfo.appName"));
        mVar.lRq.username = bi.oV((String) z.get(".mallProductInfo.sellerInfo.usrName"));
        return mVar;
    }

    public final String bnb() {
        if (this.lRp != null && this.lRp.lRL != null && !bi.oW(this.lRp.lRL.lMY)) {
            return this.lRp.lRL.lMY;
        }
        if (this.lRp == null || this.lRp.lRD == null || this.lRp.lRD.size() <= 0) {
            return null;
        }
        return (String) this.lRp.lRD.get(0);
    }
}
