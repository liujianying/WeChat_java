package com.tencent.mm.plugin.appbrand.r;

import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.net.MalformedURLException;
import java.net.URL;

public final class i {
    public static void a(b bVar, String str, a aVar) {
        if (bi.oW(str)) {
            aVar.fM("isNullOrNil script");
            return;
        }
        bVar.evaluateJavascript(str + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new 1(aVar));
    }

    public static void a(b bVar, String str, String str2, a aVar) {
        if (bi.oW(str2)) {
            aVar.fM("isNullOrNil script");
            return;
        }
        String str3 = str2 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)});
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(r.st(str));
                }
            } catch (MalformedURLException e) {
                return;
            }
        }
        bVar.a(url, str3, new 2(aVar));
    }
}
