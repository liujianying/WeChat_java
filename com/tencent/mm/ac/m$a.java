package com.tencent.mm.ac;

import android.graphics.Bitmap;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m$a {
    at dMA = null;
    List<a> dMx = new ArrayList();
    Map<String, Integer> dMy = new HashMap();
    Map<String, WeakReference<Bitmap>> dMz = new HashMap();

    public final void a(a aVar) {
        this.dMx.add(aVar);
    }

    public final void b(a aVar) {
        this.dMx.remove(aVar);
    }

    public final void MS() {
        this.dMx.clear();
    }

    public static String kW(String str) {
        if (g.Eg().Dx()) {
            return ((o) g.l(o.class)).Gl() + "/brand_" + com.tencent.mm.a.g.u(str.getBytes());
        }
        return "";
    }

    final void g(String str, Bitmap bitmap) {
        Bitmap bitmap2 = this.dMz.containsKey(str) ? (Bitmap) ((WeakReference) this.dMz.get(str)).get() : null;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            try {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, MapRouteSectionWithName.kMaxRoadNameLength, MapRouteSectionWithName.kMaxRoadNameLength, true);
                bitmap2 = c.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
            } catch (OutOfMemoryError e) {
                bitmap2 = bitmap;
            }
            this.dMz.remove(str);
            this.dMz.put(str, new WeakReference(bitmap2));
        }
        if (bitmap2 != bitmap) {
            x.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
