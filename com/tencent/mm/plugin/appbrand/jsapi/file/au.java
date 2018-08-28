package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

final class au extends d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.au$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fQo = new int[j.values().length];

        static {
            try {
                fQo[j.fkI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fQo[j.fkO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fQo[j.fkL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fQo[j.fkM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    au() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        FileStructStat fileStructStat = new FileStructStat();
        j a = lVar.fdO.fcw.a(str, fileStructStat);
        switch (AnonymousClass1.fQo[a.ordinal()]) {
            case 1:
                return new a("ok", new Object[0]).t("mode", Integer.valueOf(fileStructStat.st_mode)).t("size", Long.valueOf(fileStructStat.st_size)).t("lastAccessedTime", Long.valueOf(fileStructStat.st_atime)).t("lastModifiedTime", Long.valueOf(fileStructStat.st_mtime));
            case 2:
            case 3:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 4:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
