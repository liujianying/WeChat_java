package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appcache.an.c;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class b implements c, DebuggerShell$a {
    public final void u(Map<String, String> map) {
        if (DebuggerShell.aeq()) {
            String str = (String) map.get(".sysmsg.AppBrandForceKill.AppId");
            int i = bi.getInt((String) map.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
            if (!bi.oW(str)) {
                e.aN(str, i);
            }
        }
    }

    public final String name() {
        return "ForceKillAppNotify";
    }

    public final void s(Intent intent) {
        e.aN(intent.getStringExtra("appId"), intent.getIntExtra("versionType", 0));
    }
}
