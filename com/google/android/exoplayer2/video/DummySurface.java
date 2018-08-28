package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean aCR;
    private static boolean aCS;
    private final a aCT;
    private boolean aCU;
    public final boolean apr;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean X(android.content.Context r6) {
        /*
        r5 = 24;
        r0 = 1;
        r1 = 0;
        r3 = com.google.android.exoplayer2.video.DummySurface.class;
        monitor-enter(r3);
        r2 = aCS;	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x002d;
    L_0x000b:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        if (r2 < r5) goto L_0x0059;
    L_0x000f:
        r2 = 0;
        r2 = android.opengl.EGL14.eglGetDisplay(r2);	 Catch:{ all -> 0x005b }
        r4 = 12373; // 0x3055 float:1.7338E-41 double:6.113E-320;
        r2 = android.opengl.EGL14.eglQueryString(r2, r4);	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x0025;
    L_0x001c:
        r4 = "EGL_EXT_protected_content";
        r2 = r2.contains(r4);	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x0031;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        if (r2 == 0) goto L_0x0059;
    L_0x0028:
        aCR = r0;	 Catch:{ all -> 0x005b }
        r0 = 1;
        aCS = r0;	 Catch:{ all -> 0x005b }
    L_0x002d:
        r0 = aCR;	 Catch:{ all -> 0x005b }
        monitor-exit(r3);
        return r0;
    L_0x0031:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        if (r2 != r5) goto L_0x0042;
    L_0x0035:
        r2 = "samsung";
        r4 = com.google.android.exoplayer2.i.t.MANUFACTURER;	 Catch:{ all -> 0x005b }
        r2 = r2.equals(r4);	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x0042;
    L_0x0040:
        r2 = r1;
        goto L_0x0026;
    L_0x0042:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ all -> 0x005b }
        r4 = 26;
        if (r2 >= r4) goto L_0x0057;
    L_0x0048:
        r2 = r6.getPackageManager();	 Catch:{ all -> 0x005b }
        r4 = "android.hardware.vr.high_performance";
        r2 = r2.hasSystemFeature(r4);	 Catch:{ all -> 0x005b }
        if (r2 != 0) goto L_0x0057;
    L_0x0055:
        r2 = r1;
        goto L_0x0026;
    L_0x0057:
        r2 = r0;
        goto L_0x0026;
    L_0x0059:
        r0 = r1;
        goto L_0x0028;
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DummySurface.X(android.content.Context):boolean");
    }

    public static DummySurface g(Context context, boolean z) {
        if (t.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        boolean z2 = !z || X(context);
        a.ap(z2);
        return new a().aq(z);
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.aCT = aVar;
        this.apr = z;
    }

    public final void release() {
        super.release();
        synchronized (this.aCT) {
            if (!this.aCU) {
                this.aCT.handler.sendEmptyMessage(3);
                this.aCU = true;
            }
        }
    }
}
