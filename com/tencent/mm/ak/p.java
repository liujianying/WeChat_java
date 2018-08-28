package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class p implements com.tencent.mm.ak.c.c {
    List<c> dWH = new LinkedList();
    c dWI = null;
    boolean dWJ = false;

    private static class c {
        public a dWL;
        public String url;

        public c(String str, a aVar) {
            this.url = str;
            this.dWL = aVar;
        }
    }

    public final void a(String str, a aVar) {
        if (bi.oW(str) || aVar == null) {
            x.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
        } else if (this.dWI != null && this.dWI.url.equals(str) && this.dWI.dWL == aVar) {
            x.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        } else {
            for (c cVar : this.dWH) {
                if (cVar.url.equals(str) && cVar.dWL == aVar) {
                    x.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    return;
                }
            }
            this.dWH.add(new c(str, aVar));
            Pm();
        }
    }

    final void Pm() {
        while (this.dWI == null && this.dWH.size() != 0) {
            this.dWI = (c) this.dWH.get(0);
            this.dWH.remove(0);
            this.dWJ = false;
            o.Pe();
            Bitmap jz = c.jz(this.dWI.url);
            if (jz != null) {
                x.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.dWI.url);
                if (!this.dWJ) {
                    this.dWI.dWL.i(this.dWI.url, jz);
                }
                this.dWI = null;
            } else {
                new 1(this).execute(new String[]{this.dWI.url});
                return;
            }
        }
        x.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
    }

    static String lV(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (bi.oW(encode)) {
                x.e("MicroMsg.UrlImageCacheService", "encode result is null: " + str);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.dgk);
            int length = encode.length();
            int i = 0;
            while (i < length) {
                stringBuilder.append('/');
                if (i + 20 < length) {
                    stringBuilder.append(encode.substring(i, i + 20));
                    i += 20;
                } else {
                    stringBuilder.append(encode.substring(i, length));
                    i = length;
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + str);
            return null;
        }
    }

    public final void r(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.dWI.url);
            this.dWI = null;
            Pm();
            return;
        }
        x.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[]{this.dWI.url});
        new 2(this).execute(new b[]{new b(lV(this.dWI.url), bitmap)});
        if (!this.dWJ) {
            o.Pe();
            c.h(this.dWI.url, bitmap);
            this.dWI.dWL.i(this.dWI.url, bitmap);
        }
        this.dWI = null;
        Pm();
    }
}
