package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.a;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.protocal.c.chz;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements i<Bundle, Bundle> {
    private a$c() {
    }

    private static Bundle p(Bundle bundle) {
        boolean z = true;
        String string = bundle.getString("appId");
        int i = bundle.getInt("pkgType");
        int i2 = bundle.getInt("pkgVersion");
        int i3 = bundle.getInt("scene");
        int i4 = bundle.getInt("widgetType");
        String string2 = bundle.getString("preloadLaunchData", "");
        Bundle bundle2 = new Bundle();
        try {
            j afo = new a(string, i, i2, i3, i4, string2).afo();
            if (afo == null) {
                return bundle2;
            }
            if (afo.field_jsApiInfo != null) {
                bundle2.putByteArray("jsApiInfo", afo.field_jsApiInfo.toByteArray());
            }
            if (afo.field_launchAction != null) {
                bundle2.putByteArray("launchAction", afo.field_launchAction.toByteArray());
            }
            if (afo.field_versionInfo != null) {
                bundle2.putByteArray("versionInfo", afo.field_versionInfo.toByteArray());
            }
            WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
            widgetRuntimeConfig.appId = string;
            widgetRuntimeConfig.fwV = i4;
            chz chz = afo.field_widgetSetting;
            if (chz != null) {
                widgetRuntimeConfig.fxl = chz.sBV;
                widgetRuntimeConfig.fxn = chz.sBX;
                widgetRuntimeConfig.fxm = chz.sBW;
            }
            bundle2.putParcelable("runtimeConfig", widgetRuntimeConfig);
            com.tencent.mm.plugin.appbrand.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.widget.a.a) com.tencent.mm.plugin.appbrand.dynamic.k.a.z(com.tencent.mm.plugin.appbrand.widget.a.a.class);
            if (aVar == null) {
                return bundle2;
            }
            l wg = aVar.abd().wg(string);
            DebuggerInfo sD = b.sD(string);
            DebuggerInfo debuggerInfo = new DebuggerInfo();
            boolean z2 = wg != null && wg.field_openDebug;
            debuggerInfo.fvE = z2;
            if (d$a.ho(i) || (sD != null && sD.fvD)) {
                z2 = true;
            } else {
                z2 = false;
            }
            debuggerInfo.fvD = z2;
            if (sD == null || !sD.fvF) {
                z = false;
            }
            debuggerInfo.fvF = z;
            bundle2.putParcelable("debuggerInfo", debuggerInfo);
            AppBrandGlobalSystemConfig adZ = AppBrandGlobalSystemConfig.adZ();
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.fpO = adZ.fpO;
            widgetSysConfig.fpP = adZ.fpP;
            widgetSysConfig.fpQ = adZ.fpQ;
            bundle2.putParcelable("sysConfig", widgetSysConfig);
            return bundle2;
        } catch (Exception e) {
            x.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[]{e});
        }
    }
}
