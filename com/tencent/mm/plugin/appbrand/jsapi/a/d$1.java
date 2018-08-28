package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class d$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ d fKu;

    d$1(d dVar, p pVar, int i) {
        this.fKu = dVar;
        this.fJO = pVar;
        this.doP = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        Map hashMap = new HashMap();
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            ajb ajb = (ajb) bVar.dIE.dIL;
            x.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
            Object obj = "";
            if (!TextUtils.isEmpty(ajb.rLM)) {
                obj = ajb.rLM;
            }
            Object obj2 = "";
            if (!TextUtils.isEmpty(ajb.rLN)) {
                obj2 = ajb.rLN;
            }
            int i3 = ajb.reL;
            Collection collection = ajb.rLO;
            x.i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", new Object[]{obj2, Integer.valueOf(i3)});
            x.i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", new Object[]{obj});
            hashMap.put("userData", obj);
            hashMap.put("authStatus", Integer.valueOf(i3));
            hashMap.put("authInfo", obj2);
            if (collection != null && collection.size() > 0) {
                hashMap.put("authGroupList", new JSONArray(collection));
                x.i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new Object[]{new JSONArray(collection).toString()});
            }
            this.fJO.E(this.doP, this.fKu.f("ok", hashMap));
            return;
        }
        x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        hashMap.put("ret", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            this.fJO.E(this.doP, this.fKu.f("fail: ErrMsg: cgi fail", hashMap));
        } else {
            this.fJO.E(this.doP, this.fKu.f("fail: ErrMsg:" + str, hashMap));
        }
    }
}
