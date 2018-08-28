package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;

public final class o extends e<Bitmap, b> {
    public static o dvq = new o();

    protected final /* synthetic */ long aR(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.fS(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ Comparable aS(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        return new b(bitmap.getWidth(), bitmap.getHeight());
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new a((b) comparable);
    }

    private o() {
    }

    public final synchronized Bitmap a(b bVar) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.a(bVar);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = b(bVar);
        }
        return bitmap;
    }

    /* renamed from: k */
    public final synchronized void aQ(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                super.aQ(bitmap);
            }
        }
    }

    private static Bitmap b(b bVar) {
        return Bitmap.createBitmap(bVar.width, bVar.height, k.dvc);
    }

    protected final long Fk() {
        return 1228800;
    }

    protected final long Fl() {
        return 307200;
    }
}
