package com.tencent.mm.modelappbrand.b;

import android.graphics.Bitmap;
import android.support.v4.b.a;
import com.tencent.mm.a.f;
import com.tencent.mm.modelappbrand.b.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class b$c$1 extends f<String, Reference<Bitmap>> {
    private final Map<Reference<Bitmap>, Integer> dFZ = new ConcurrentHashMap();
    final /* synthetic */ c dGa;

    b$c$1(c cVar) {
        this.dGa = cVar;
        super(31457280);
    }

    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        Reference reference = (Reference) obj2;
        Reference reference2 = (Reference) obj3;
        String str2 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
        String str3 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.dGa.dFY.size() / 10);
        objArr[1] = Integer.valueOf(this.dGa.dFY.maxSize() / 10);
        objArr[2] = reference == null ? "null-ref" : reference.get();
        objArr[3] = reference2 == null ? "null-ref" : reference2.get();
        x.d(str2, str3, objArr);
        super.entryRemoved(z, str, reference, reference2);
        Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
        if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
            this.dGa.k(bitmap);
        }
        this.dFZ.remove(reference);
    }

    protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
        Reference reference = (Reference) obj2;
        if (reference == null) {
            return 0;
        }
        Integer num = (Integer) this.dFZ.get(reference);
        if (num != null && num.intValue() >= 0) {
            return num.intValue();
        }
        Bitmap bitmap = (Bitmap) reference.get();
        int e = (bitmap == null || bitmap.isRecycled()) ? 0 : a.e(bitmap);
        this.dFZ.put(reference, Integer.valueOf(e));
        return e;
    }

    public final void clear() {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
        super.clear();
        this.dFZ.clear();
    }

    public final void a(f.a<String, Reference<Bitmap>> aVar) {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
        super.a(aVar);
        this.dFZ.clear();
    }
}
