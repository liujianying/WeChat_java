package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.an.c;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

final class an$b implements c {
    private an$b() {
    }

    /* synthetic */ an$b(byte b) {
        this();
    }

    public final void u(Map<String, String> map) {
        e(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
        int i = 0;
        do {
            i++;
        } while (e(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + i, map));
    }

    private boolean e(String str, Map<String, String> map) {
        x.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[]{str});
        if (map.get(str) == null) {
            return false;
        }
        String str2 = (String) map.get(str + ".AppID");
        String str3 = (String) map.get(str + ".UserName");
        int i = bi.getInt((String) map.get(str + ".Type"), 1);
        String str4 = (String) map.get(str + ".URL");
        long j = bi.getLong((String) map.get(str + ".StartTime"), bi.VE());
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[]{str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(bi.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(e.abi().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10))});
        if (e.abi().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
            if (XWalkEnvironment.LOCAL_TEST_VERSION != i) {
                r.se(str3);
                ah.A(new 1(this, str2, i, q.rX(str2)));
            } else {
                m.fgc.cs(false);
            }
            e.abg().a(str3, i, false, false, 0, 0, null);
        }
        return true;
    }
}
