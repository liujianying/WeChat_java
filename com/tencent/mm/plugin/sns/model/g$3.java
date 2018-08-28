package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.model.al.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class g$3 implements a {
    final /* synthetic */ g nnr;

    g$3(g gVar) {
        this.nnr = gVar;
    }

    public final boolean bP(Object obj) {
        String str = (String) obj;
        if (!g.a(this.nnr, str)) {
            return false;
        }
        al a = g.a(this.nnr);
        try {
            Bitmap bitmap;
            Object obj2 = ((b) a.nrg.get(str)).obj;
            if (obj2 instanceof Bitmap) {
                bitmap = (Bitmap) obj2;
            } else {
                WeakReference weakReference = (WeakReference) ((b) a.nrg.get(str)).obj;
                bitmap = weakReference != null ? (Bitmap) weakReference.get() : null;
            }
            if (!(bitmap == null || bitmap.isRecycled())) {
                x.d("MicroMsg.SnsLRUMap", "remove key:" + str);
                bitmap.recycle();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsLRUMap", e, "", new Object[0]);
            x.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
        }
        x.d("MicroMsg.SnsLRUMap", "internalMap " + a.nrg.size() + " bfSize :" + a.nrg.size() + " o == null " + (a.nrg.remove(str) != null));
        x.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(this.nnr).nrg.size() + " listPaitSize:" + g.b(this.nnr).size());
        return true;
    }
}
