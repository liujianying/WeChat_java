package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.b.e;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.c.cfz;
import com.tencent.mm.protocal.c.cga;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a {
    public static WxaPkgWrappingInfo b(String str, String str2, String str3, int i, int i2) {
        Parcelable bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str3);
        WxaPkgWrappingInfo sC = e.sC(D(str2, i, i2));
        if (sC == null) {
            sC = (WxaPkgWrappingInfo) f.a("com.tencent.mm", bundle, a.class);
            if (sC != null) {
                e.a(D(str2, i, i2), sC);
            }
        }
        return sC;
    }

    public static d a(String str, int i, int i2, int i3, int i4, String str2) {
        Parcelable bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        bundle.putString("preloadLaunchData", str2);
        Bundle bundle2 = (Bundle) f.a("com.tencent.mm", bundle, c.class);
        if (bundle2 == null) {
            return null;
        }
        d dVar = new d();
        dVar.appId = str;
        dVar.fxI = (DebuggerInfo) bundle2.getParcelable("debuggerInfo");
        byte[] byteArray = bundle2.getByteArray("jsApiInfo");
        if (byteArray != null) {
            dVar.fxM = new ob();
            try {
                dVar.fxM.aG(byteArray);
            } catch (IOException e) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e});
            }
        }
        byteArray = bundle2.getByteArray("launchAction");
        if (byteArray != null) {
            dVar.fxL = new cfz();
            try {
                dVar.fxL.aG(byteArray);
            } catch (IOException e2) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e2});
            }
        }
        byteArray = bundle2.getByteArray("versionInfo");
        if (byteArray != null) {
            dVar.fxN = new cga();
            try {
                dVar.fxN.aG(byteArray);
            } catch (IOException e22) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e22});
            }
        }
        dVar.fxJ = (WidgetSysConfig) bundle2.getParcelable("sysConfig");
        dVar.fxK = (WidgetRuntimeConfig) bundle2.getParcelable("runtimeConfig");
        if (dVar.fxK == null) {
            dVar.fxK = new WidgetRuntimeConfig();
        }
        return dVar;
    }

    private static String D(String str, int i, int i2) {
        return str + "#" + i + "#" + i2;
    }
}
