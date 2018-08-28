package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class as extends d {
    as() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[]{str, jSONObject.optString("newPath")});
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[]{str, r0});
        File rb = lVar.fdO.fcw.rb(str);
        if (rb == null || !rb.exists()) {
            return new a(format, new Object[0]);
        }
        if (k.z(rb)) {
            return new a("fail \"%s\" not a regular file", new Object[]{str});
        }
        j a = lVar.fdO.fcw.a(r0, rb, true);
        switch (1.fQo[a.ordinal()]) {
            case 1:
                return new a(format2, new Object[0]);
            case 2:
                return new a(format, new Object[0]);
            case 3:
                return new a("fail sdcard not mounted", new Object[0]);
            case 4:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }

    protected final String q(JSONObject jSONObject) {
        return jSONObject.optString("oldPath");
    }
}
