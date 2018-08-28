package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class an extends d {
    an() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        j a;
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        File rb = lVar.fdO.fcw.rb(str);
        if (rb == null || !rb.exists() || !rb.isFile()) {
            h hVar = new h();
            lVar.fdO.fcw.a(str, hVar);
            if (hVar.value == null) {
                return new a(format, new Object[0]);
            }
            Closeable aVar = new com.tencent.mm.plugin.appbrand.l.a((ByteBuffer) hVar.value);
            a = lVar.fdO.fcw.a(optString, aVar, false);
            bi.d(aVar);
        } else if (k.z(rb)) {
            return new a("fail \"%s\" not a regular file", new Object[]{str});
        } else {
            a = lVar.fdO.fcw.a(optString, rb, false);
        }
        switch (1.fQo[a.ordinal()]) {
            case 1:
                return new a(format2, new Object[0]);
            case 2:
                return new a(format, new Object[0]);
            case 3:
                return new a("fail sdcard not mounted", new Object[0]);
            case 4:
                return new a("fail illegal operation on a directory, open \"%s\"", new Object[]{optString});
            case 5:
                return new a("fail \"%s\" is not a regular file", new Object[]{optString});
            case 6:
                return new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
            case 7:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }

    protected final String q(JSONObject jSONObject) {
        return jSONObject.optString("srcPath");
    }
}
