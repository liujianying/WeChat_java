package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

class ax extends d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ax$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fQo = new int[j.values().length];

        static {
            try {
                fQo[j.fkL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fQo[j.fkN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fQo[j.fkM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fQo[j.fkS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                fQo[j.fkT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                fQo[j.fkI.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    ax() {
    }

    a a(l lVar, String str, JSONObject jSONObject) {
        InputStream aVar;
        boolean optBoolean = jSONObject.optBoolean("append");
        String optString = jSONObject.optString("encoding");
        m.a(lVar, jSONObject, this.fQc);
        Object opt = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA);
        if (opt instanceof String) {
            e eVar;
            if (bi.oW(optString)) {
                eVar = (e) e.a.fQd.get("utf8");
            } else {
                e eVar2 = (e) e.a.fQd.get(optString.toLowerCase());
                if (eVar2 == null) {
                    return new a("fail invalid encoding", new Object[0]);
                }
                eVar = eVar2;
            }
            try {
                aVar = new com.tencent.mm.plugin.appbrand.l.a(eVar.ty((String) opt));
            } catch (Exception e) {
                return new a("fail " + e.getMessage(), new Object[0]);
            }
        } else if (opt instanceof ByteBuffer) {
            aVar = new com.tencent.mm.plugin.appbrand.l.a((ByteBuffer) opt);
        } else if (opt != null) {
            return new a("fail invalid data", new Object[0]);
        } else {
            if (optBoolean) {
                return new a("ok", new Object[0]);
            }
            aVar = new ByteArrayInputStream(new byte[0]);
        }
        j a = lVar.fdO.fcw.a(str, aVar, optBoolean);
        switch (AnonymousClass1.fQo[a.ordinal()]) {
            case 1:
                return new a("fail no such file or directory, open \"%s\"", new Object[]{str});
            case 2:
                return new a("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 4:
                return new a("fail \"%s\" is not a regular file", new Object[]{str});
            case 5:
                return new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
            case 6:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
