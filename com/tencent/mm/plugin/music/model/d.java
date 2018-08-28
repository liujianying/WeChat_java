package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.an.a;
import com.tencent.mm.an.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public f<String, Bitmap> cYh = new f(5);
    public a lxU;
    public g lxV = new g() {
        public final void me(String str) {
        }

        public final Bitmap a(String str, b bVar) {
            return null;
        }

        public final void a(String str, View view, b bVar) {
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            x.i(str2, str3, objArr);
            final a aVar = (a) view.getTag();
            if (bVar.bitmap != null && aVar != null) {
                d.this.a(aVar, bVar.bitmap);
                final int[] s = c.s(bVar.bitmap);
                if (!aVar.f(s)) {
                    h.bid().Z(aVar.field_musicId, s[0], s[1]);
                }
                if (d.this.lxU != null) {
                    ah.A(new Runnable() {
                        public final void run() {
                            d.this.lxU.a(aVar, s);
                        }
                    });
                }
            }
        }
    };
    public ag lxW = new ag(Looper.getMainLooper());

    public final void a(a aVar, Bitmap bitmap) {
        x.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[]{aVar.field_musicId});
        this.cYh.put(aVar.field_musicId, bitmap);
    }
}
