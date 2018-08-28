package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.sdk.platformtools.x;

public final class r {
    public static void a(g gVar, b bVar, String str) {
        if (gVar == null || bVar == null || str == null || str.length() == 0) {
            x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime or filePath is null.");
        } else if (d$a.jC(gVar.fcu.frm.fih)) {
            x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
        } else {
            String a = ao.a(gVar, str + ".map");
            if (a == null || a.length() == 0) {
                x.i("MicroMsg.SourceMapInjector", "sourceMap of the script(%s) is null or nil.", new Object[]{str});
                return;
            }
            i.a(bVar, String.format("var __wxSourceMap ={ '%s': %s };", new Object[]{str, a}), new 2(str));
        }
    }

    public static String st(String str) {
        return "https://servicewechat.qq.com/" + str;
    }
}
