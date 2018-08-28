package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class JsApiLaunchApplication extends a {
    private static final int CTRL_INDEX = 427;
    private static final String NAME = "launchApplication";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiLaunchApplication", "data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int i2 = bi.getInt(jSONObject.optString("alertType"), 0);
        int i3 = bi.getInt(jSONObject.optString("operateDirectly"), 0);
        x.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{optString, optString2, jSONObject.optString("extInfo"), optString3});
        if (bi.oW(optString) && bi.oW(optString2)) {
            x.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            lVar.E(i, f("fail:appid and scheme is null or nil", null));
            return;
        }
        String url;
        String str = lVar.mAppId;
        p d = d(lVar);
        if (d != null) {
            url = d.getURL();
        } else {
            x.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
            url = null;
        }
        Bundle bundle = new Bundle();
        if (!bi.oW(url)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        bundle.putString("current_page_appid", str);
        a aVar = new a();
        aVar.dIG = new aog();
        aVar.dIH = new aoh();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.dIF = 1125;
        aog aog = (aog) aVar.KT().dID.dIL;
        aog.bPS = str;
        aog.rQM = optString;
        aog.scene = lVar.fdO.fcE.scene;
        aog.url = url;
        aog.rQN = optString2;
        aog.hUp = i2;
        aog.rQO = 1;
        aog.rQP = i3;
        x.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[]{str, optString, Integer.valueOf(aog.scene), aog.url, aog.rQN, Integer.valueOf(aog.hUp), Integer.valueOf(aog.rQP)});
        b.a(aVar.KT(), new 1(this, lVar, i, optString2, bundle, optString, optString3, r8));
    }
}
