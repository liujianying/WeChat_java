package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.cache.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    private HashMap<String, c> dTw = new HashMap();

    protected final void finalize() {
        super.finalize();
    }

    public static void h(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.CdnImageService", "push fail, key is null");
        } else {
            a.a("local_cdn_img_cache", str, bitmap);
        }
    }

    public static Bitmap jz(String str) {
        if (str != null && str.length() != 0) {
            return (Bitmap) a.E("local_cdn_img_cache", str);
        }
        x.e("MicroMsg.CdnImageService", "get fail, key is null");
        return null;
    }

    public final void lF(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
        } else {
            this.dTw.remove(str);
        }
    }

    public final void a(String str, c cVar) {
        if (bi.oW(str)) {
            x.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            return;
        }
        Bitmap jz = jz(str);
        if (jz == null || jz.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (jz == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
            if (this.dTw.containsKey(str)) {
                x.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[]{str});
                return;
            }
            this.dTw.put(str, cVar);
            e.post(new b(str, this.dTw), "CdnImageService_download");
            return;
        }
        x.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[]{str});
        if (cVar != null) {
            cVar.r(jz);
        }
    }
}
