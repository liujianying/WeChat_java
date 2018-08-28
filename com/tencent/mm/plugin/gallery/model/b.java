package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Vector;

public final class b {
    k<b, String> dHn = new 1(this);
    public Vector<b> dHo = new Vector();
    f<String, a> jAp = new f(100, new 3(this));
    d jAq;
    private final b jAr = new b() {
        public final void CR(String str) {
            x.i("MicroMsg.GalleryCache", "now listener size : " + b.this.dHo.size());
            for (int size = b.this.dHo.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) b.this.dHo.get(size);
                } catch (Exception e) {
                    x.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", new Object[]{e.toString()});
                    bVar = null;
                }
                if (bVar == null) {
                    x.d("MicroMsg.GalleryCache", "get listener is null");
                } else {
                    bVar.CR(str);
                }
            }
        }
    };

    private class a {
        Bitmap bitmap;
        private int type;

        public a(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void CR(String str);
    }

    public b() {
        d dVar = new d(new File(e.bnE + "/diskcache"));
        dVar.jAJ = ad.getContext().getSharedPreferences(ad.chY(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        dVar.aRn();
        dVar.qo(-1);
        this.jAq = dVar;
        this.dHn.a(this.jAr, null);
    }

    public final Bitmap getBitmap(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.GalleryCache", "null filepath");
            return null;
        } else if (this.jAp == null) {
            x.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            return null;
        } else {
            if (this.jAp.bb(str)) {
                a aVar = (a) this.jAp.get(str);
                if (aVar == null) {
                    x.d("MicroMsg.GalleryCache", "weakreference is null");
                    this.jAp.remove(str);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.jAp.remove(str);
                    x.i("MicroMsg.GalleryCache", "get bitmap is null");
                } else if (bitmap.isRecycled()) {
                    x.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
                    this.jAp.remove(str);
                    return null;
                } else {
                    x.i("MicroMsg.GalleryCache", "get cached bitmap:" + str);
                    return bitmap;
                }
            }
            return null;
        }
    }
}
