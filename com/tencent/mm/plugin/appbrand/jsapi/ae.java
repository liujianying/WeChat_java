package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ae extends n {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    ae() {
    }

    public final String a(l lVar, JSONObject jSONObject) {
        return q(lVar.fdO);
    }

    public final String a(p pVar) {
        return q(pVar.fdO);
    }

    private String q(g gVar) {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = gVar.fcu;
        if (appBrandSysConfig == null) {
            return f("fail", null);
        }
        Map hashMap = new HashMap();
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfig.frm.fih != 0));
        hashMap.put("appMd5", bi.oV(appBrandSysConfig.frm.bKg));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfig.frm.fii));
        WxaPkgWrappingInfo abP = WxaCommLibRuntimeReader.abP();
        String str = "libDebug";
        if (abP.fih == 0) {
            z = false;
        }
        hashMap.put(str, Boolean.valueOf(z));
        hashMap.put("libMd5", bi.oV(abP.bKg));
        hashMap.put("libVersion", Integer.valueOf(abP.fii));
        hashMap.put("clientVersion", Integer.valueOf(d.qVN));
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ad.getContext())));
        return f("ok", hashMap);
    }
}
