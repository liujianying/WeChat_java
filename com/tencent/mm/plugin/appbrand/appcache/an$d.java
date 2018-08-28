package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.an.c;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class an$d implements c {
    private an$d() {
    }

    /* synthetic */ an$d(byte b) {
        this();
    }

    public final void u(Map<String, String> map) {
        if (map.get(".sysmsg.AppPublicLibraryNotify") != null) {
            int i = bi.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
            String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
            String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
            int i2 = bi.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
            if (bi.oW(str2) || bi.oW(str) || i <= 0) {
                x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[]{str2, str, Integer.valueOf(i)});
                return;
            }
            x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
            cgl cgl = new cgl();
            cgl.version = i;
            cgl.bKg = str;
            cgl.url = str2;
            cgl.seJ = i2;
            ac.a(cgl);
        }
    }
}
