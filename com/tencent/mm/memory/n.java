package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> dvk = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private ag dvh = new ag(Looper.getMainLooper());
    private boolean dvi = false;
    private AtomicInteger dvj = new AtomicInteger();
    private boolean dvl = true;
    private Runnable dvm = new 1(this);
    private int dvn = 0;
    private int dvo = 0;

    private n(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.dvj.set(1);
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bi.cjd().toString());
        }
        this.dvi = false;
        getAllocationByteCount();
    }

    public static n m(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new n(bitmap);
    }

    public final Bitmap Fw() {
        this.dvl = false;
        return this.bitmap;
    }

    public final void Fs() {
        this.dvj.incrementAndGet();
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.dvj + " bitmap:" + this.bitmap + " " + this + " " + bi.cjd().toString());
        }
    }

    public final void Ft() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.dvj + " bitmap:" + this.bitmap + " " + this + " " + bi.cjd().toString());
        }
        if (this.dvj.get() > 0) {
            this.dvj.decrementAndGet();
            if (this.dvj.get() >= 0) {
                this.dvh.removeCallbacks(this.dvm);
                this.dvh.postDelayed(this.dvm, 500);
            }
        }
    }

    public final Bitmap Fx() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bi.cjd().toString());
        }
        return this.bitmap;
    }

    public final boolean isRecycled() {
        return this.dvi || this.bitmap == null || this.bitmap.isRecycled();
    }

    public final boolean Fy() {
        this.dvj.decrementAndGet();
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.dvi + " isMutable:" + this.dvl + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.dvj + bi.cjd().toString());
        }
        Fz();
        return true;
    }

    private boolean Fz() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.dvi + " isMutable:" + this.dvl + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.dvj + bi.cjd().toString());
        }
        if (this.dvi || this.dvj.get() > 0) {
            return false;
        }
        this.dvi = true;
        if (this.DEBUG) {
            dvk.remove(this.bitmap);
        }
        if (!this.dvl) {
            return true;
        }
        l.Fu().l(this.bitmap);
        return true;
    }

    public final int getAllocationByteCount() {
        if (d.fS(19)) {
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                x.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.dvn + " " + toString());
                return this.dvn;
            }
            this.dvn = this.bitmap.getByteCount();
            return this.dvn;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            x.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.dvo + " " + toString());
            return this.dvo;
        } else {
            this.dvo = this.bitmap.getAllocationByteCount();
            return this.dvo;
        }
    }

    public final String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode() + " attachCount: " + this.dvj;
        if (this.bitmap != null) {
            return str + this.bitmap;
        }
        return str;
    }

    protected final void finalize() {
        if (this.DEBUG) {
            x.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
    }

    public final String FA() {
        return this + " " + this.bitmap;
    }
}
