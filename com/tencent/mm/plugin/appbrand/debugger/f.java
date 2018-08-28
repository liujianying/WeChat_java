package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class f implements n {
    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
            String str3 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
            String str4 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
            String str5 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
            String str6 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
            String str7 = (String) map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
            x.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", new Object[]{str2, str3, str4, str5, str6, str7});
            if (bi.oW(str2) || bi.oW(str3) || bi.oW(str5)) {
                x.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[]{str2, str3, str5});
                return;
            }
            if (e.abi().a(str2, 1, str5, str6, 0, bi.VE() + 7200)) {
                com.tencent.mm.plugin.appbrand.task.e.aN(str2, 1);
            }
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.dFz = str7;
            ((h) e.x(h.class)).n(str2, 1, str7);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1101;
            appBrandStatObject.bGG = str2 + ":" + str3;
            AppBrandLaunchProxyUI.a(ad.getContext(), str3, str4, 1, -1, appBrandStatObject, launchParamsOptional);
        }
    }
}
