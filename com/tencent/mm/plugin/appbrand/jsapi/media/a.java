package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.json.JSONObject;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    abstract boolean tG(String str);

    abstract String tH(String str);

    abstract void tI(String str);

    a() {
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("filePath", "");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail filePath invalid", null));
        } else {
            c.Em().H(new 1(this, lVar, optString, i));
        }
    }

    static boolean d(String str, InputStream inputStream) {
        Exception e;
        Throwable th;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                byte[] bArr = new byte[GLIcon.LEFT];
                while (true) {
                    int read = inputStream.read(bArr, 0, GLIcon.LEFT);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        bi.d(fileOutputStream);
                        bi.d(inputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", new Object[]{e});
                    bi.d(fileOutputStream);
                    bi.d(inputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(fileOutputStream);
                    bi.d(inputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            x.e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", new Object[]{e});
            bi.d(fileOutputStream);
            bi.d(inputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bi.d(fileOutputStream);
            bi.d(inputStream);
            throw th;
        }
    }
}
