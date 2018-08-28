package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<Bitmap> {
    private static int duS = 20971520;
    public static final c duT = new c();

    @TargetApi(19)
    protected final /* synthetic */ long aR(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.fS(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new b(((Integer) comparable).intValue());
    }

    private c() {
        x.i("MicroMsg.BitmapPool", "BitmapPool %dMB", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass())});
        if (((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass() > GLIcon.TOP) {
            duS = 20971520;
        } else {
            duS = 10485760;
        }
        Fo();
    }

    protected static Integer d(Integer num) {
        return Integer.valueOf(num.intValue() * 4);
    }

    protected final long Fk() {
        return (long) duS;
    }

    protected final long Fl() {
        return 1048576;
    }

    /* renamed from: e */
    public final synchronized Bitmap b(Integer num) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.b(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
        } else {
            x.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", new Object[]{bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), j(bitmap), num});
        }
        return bitmap;
    }

    private static Integer j(Bitmap bitmap) {
        if (bitmap == null) {
            return Integer.valueOf(0);
        }
        int byteCount;
        if (d.fS(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        return Integer.valueOf(byteCount);
    }

    /* renamed from: k */
    public final synchronized void aQ(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && !bitmap.isRecycled()) {
                x.i("MicroMsg.BitmapPool", "release: %s", new Object[]{bitmap});
                super.aQ(bitmap);
            }
        }
    }

    public final void Fm() {
        super.Fm();
    }
}
