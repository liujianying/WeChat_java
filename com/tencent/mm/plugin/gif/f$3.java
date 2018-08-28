package com.tencent.mm.plugin.gif;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f kiu;

    f$3(f fVar) {
        this.kiu = fVar;
    }

    public final void run() {
        if (f.f(this.kiu)) {
            x.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
        } else if (f.a(this.kiu)) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
        } else if (f.g(this.kiu) == null || f.g(this.kiu).isRecycled()) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
        } else if (f.h(this.kiu) == 0) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
            h.mEJ.a(401, 18, 1, false);
        } else {
            f.a(this.kiu, true);
            long currentTimeMillis = System.currentTimeMillis();
            int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(f.h(this.kiu), null, 0, f.g(this.kiu), f.i(this.kiu));
            if (nativeDecodeBufferFrame == -904) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
                h.mEJ.a(401, 8, 1, false);
                return;
            }
            if (nativeDecodeBufferFrame == -909) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
                h.mEJ.a(401, 11, 1, false);
            } else if (nativeDecodeBufferFrame == -1) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
                return;
            }
            f.a(this.kiu, f.b(this.kiu) + 1);
            if (f.b(this.kiu) >= f.j(this.kiu) - 1 || nativeDecodeBufferFrame == 1) {
                f.a(this.kiu, -1);
                nativeDecodeBufferFrame = MMWXGFJNI.nativeRewindBuffer(f.h(this.kiu));
                if (nativeDecodeBufferFrame != 0) {
                    if (nativeDecodeBufferFrame == -905) {
                        h.mEJ.a(711, 9, 1, false);
                    }
                    x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                    return;
                }
            }
            f.b(this.kiu, System.currentTimeMillis() - currentTimeMillis);
            if (f.k(this.kiu) != 0) {
                f.c(this.kiu, (f.k(this.kiu) - f.l(this.kiu)) - f.m(this.kiu));
                if (f.e(this.kiu) < 0) {
                    x.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[]{Long.valueOf(f.l(this.kiu)), Long.valueOf(f.m(this.kiu)), Long.valueOf(f.e(this.kiu)), Long.valueOf(f.k(this.kiu)), Integer.valueOf(f.b(this.kiu))});
                    if (f.e(this.kiu) < -100) {
                        h.mEJ.a(401, 16, 1, false);
                        h.mEJ.a(401, 17, Math.abs(f.e(this.kiu)), false);
                    }
                }
            }
            f.a(this.kiu, f.d(this.kiu), f.e(this.kiu) > 0 ? f.e(this.kiu) : 0);
            f.d(this.kiu, (long) (f.i(this.kiu)[0] > 0 ? f.i(this.kiu)[0] : 100));
            f.a(this.kiu, false);
        }
    }
}
