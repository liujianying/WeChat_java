package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class f implements a {
    private static f fqB;
    public final Map<String, AppBrandInitConfig> fqC = new android.support.v4.e.a();
    public final Map<String, String> fqD = new android.support.v4.e.a();

    private f() {
    }

    public static void init() {
        synchronized (f.class) {
            fqB = new f();
            q.aei().c(fqB);
        }
    }

    public static void release() {
        synchronized (f.class) {
            fqB = null;
        }
    }

    public static f aee() {
        f fVar;
        synchronized (f.class) {
            fVar = fqB;
        }
        return fVar;
    }

    public final void a(String str, l lVar) {
        if ("single".equals(str)) {
            if (String.class.isInstance(lVar.obj)) {
                String valueOf = String.valueOf(lVar.obj);
                if (!bi.oW(valueOf)) {
                    rM(valueOf);
                }
            }
        } else if ("batch".equals(str)) {
            synchronized (this.fqC) {
                this.fqC.clear();
            }
        }
    }

    public final String rL(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2;
        synchronized (this.fqD) {
            str2 = (String) this.fqD.get(str);
        }
        return str2;
    }

    private AppBrandInitConfig rM(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2;
        synchronized (this.fqD) {
            str2 = (String) this.fqD.get(str);
        }
        if (!bi.oW(str2)) {
            return rN(str2);
        }
        AppBrandInitConfig a = a(e.aba().e(str, new String[]{"appId", "appInfo", "brandIconURL", "nickname"}));
        if (a == null) {
            return a;
        }
        synchronized (this.fqD) {
            this.fqD.put(str, a.appId);
        }
        return a;
    }

    public static AppBrandInitConfig a(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig();
        appBrandInitConfig.username = wxaAttributes.field_username;
        appBrandInitConfig.appId = wxaAttributes.field_appId;
        appBrandInitConfig.bKC = wxaAttributes.field_nickname;
        appBrandInitConfig.iconUrl = wxaAttributes.field_brandIconURL;
        appBrandInitConfig.bGM = wxaAttributes.aej().dCn;
        appBrandInitConfig.fqr = wxaAttributes.aej().frT > 0;
        return appBrandInitConfig;
    }

    public final AppBrandInitConfig rN(String str) {
        if (bi.oW(str)) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig;
        synchronized (this.fqC) {
            appBrandInitConfig = (AppBrandInitConfig) this.fqC.remove(str);
        }
        if (appBrandInitConfig != null) {
            return appBrandInitConfig;
        }
        return a(e.aba().f(str, new String[]{"appInfo", "brandIconURL", "nickname"}));
    }
}
