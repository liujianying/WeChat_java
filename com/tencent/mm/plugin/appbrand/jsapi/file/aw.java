package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

final class aw extends d {
    aw() {
    }

    final a a(l lVar, String str, JSONObject jSONObject) {
        Throwable e;
        String optString = jSONObject.optString("targetDirectory", "wxfile://usr");
        if (!optString.startsWith("wxfile://usr")) {
            return new a("fail invalid targetDirectory", new Object[0]);
        }
        switch (1.fQo[lVar.fdO.fcw.rf(optString).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new a(String.format("fail permission denied, open \"%s\"", new Object[]{optString}), new Object[0]);
            default:
                h hVar = new h();
                j a = lVar.fdO.fcw.a(str, hVar);
                switch (1.fQo[a.ordinal()]) {
                    case 1:
                        return new a("fail permission denied, open \"%s\"", new Object[]{str});
                    case 4:
                        return new a("fail no such file \"%s\"", new Object[]{str});
                    case 5:
                        Closeable zipInputStream;
                        a aVar;
                        try {
                            zipInputStream = new ZipInputStream(new com.tencent.mm.plugin.appbrand.l.a((ByteBuffer) hVar.value));
                            try {
                                j a2 = lVar.fdO.fcw.a(optString, zipInputStream, false);
                                switch (1.fQo[a2.ordinal()]) {
                                    case 1:
                                        aVar = new a("fail permission denied, open \"%s\"", new Object[]{str});
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case 5:
                                        aVar = new a("ok", new Object[0]);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case 6:
                                        aVar = new a("fail no such file or directory, open \"%s\"", new Object[]{str});
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case 7:
                                        aVar = new a("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case 8:
                                        aVar = new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    default:
                                        aVar = new a("fail " + a2.name(), new Object[0]);
                                        bi.d(zipInputStream);
                                        return aVar;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            e = e2;
                        } catch (Exception e3) {
                            e = e3;
                            zipInputStream = null;
                        } catch (Throwable th) {
                            e = th;
                            zipInputStream = null;
                            bi.d(zipInputStream);
                            throw e;
                        }
                        try {
                            x.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e, "write zip stream", new Object[0]);
                            aVar = new a("fail read zip data", new Object[0]);
                            bi.d(zipInputStream);
                            return aVar;
                        } catch (Throwable th2) {
                            e = th2;
                            bi.d(zipInputStream);
                            throw e;
                        }
                    default:
                        return new a("fail " + a.name(), new Object[0]);
                }
        }
    }

    protected final String q(JSONObject jSONObject) {
        return jSONObject.optString("zipFilePath");
    }
}
