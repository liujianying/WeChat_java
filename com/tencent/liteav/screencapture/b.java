package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.rtmp.video.TXScreenCapture$TXScreenCaptureAssistantActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
public class b {
    private static final String b = b.class.getSimpleName();
    private static b c = new b();
    Callback a;
    private HashMap<Surface, VirtualDisplay> d;
    private Context e;
    private MediaProjectionManager f;
    private MediaProjection g;
    private HashSet<a> h;
    private int i;
    private Handler j;
    private HashSet<Object> k;
    private boolean l;
    private WeakReference<a> m;
    private BroadcastReceiver n;

    private b() {
        this.d = new HashMap();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new HashSet();
        this.i = 1;
        this.j = null;
        this.k = new HashSet();
        this.l = false;
        this.m = null;
        this.a = new 1(this);
        this.n = new 3(this);
        this.j = new Handler(Looper.getMainLooper());
    }

    public static b a() {
        return c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.m = null;
        } else {
            this.m = new WeakReference(aVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.e;	 Catch:{ all -> 0x0026 }
        if (r0 == r3) goto L_0x0024;
    L_0x0005:
        r2.b();	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r2.f = r0;	 Catch:{ all -> 0x0026 }
        r2.e = r3;	 Catch:{ all -> 0x0026 }
        r0 = r2.e;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
    L_0x0012:
        return;
    L_0x0013:
        r0 = r2.f;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x0024;
    L_0x0017:
        r0 = r2.e;	 Catch:{ all -> 0x0026 }
        r1 = "media_projection";
        r0 = r0.getSystemService(r1);	 Catch:{ all -> 0x0026 }
        r0 = (android.media.projection.MediaProjectionManager) r0;	 Catch:{ all -> 0x0026 }
        r2.f = r0;	 Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x0012;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.screencapture.b.a(android.content.Context):void");
    }

    @TargetApi(21)
    public boolean a(Surface surface, int i, int i2) {
        boolean z = false;
        synchronized (this) {
            try {
                if (this.i == 3 || this.i == 4) {
                    if (this.g != null) {
                        boolean z2;
                        VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", i, i2, 1, 1, surface, null, null);
                        if (createVirtualDisplay != null) {
                            this.l = true;
                            try {
                                this.i = 3;
                                this.d.put(surface, createVirtualDisplay);
                                z2 = true;
                            } catch (Exception e) {
                                z = true;
                            }
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                    if (!z) {
                        com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
                    }
                } else {
                    a aVar = new a(this, null);
                    aVar.c = i2;
                    aVar.b = i;
                    aVar.a = surface;
                    this.h.add(aVar);
                    z = e();
                    if (z) {
                        com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
                    }
                }
            } catch (Exception e2) {
            }
        }
        return z;
    }

    public void a(Surface surface) {
        synchronized (this) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null && aVar.a != null && aVar.b != 0 && aVar.c != 0 && aVar.a == surface) {
                    this.h.remove(aVar);
                    break;
                }
            }
            if (this.d.containsKey(surface)) {
                ((VirtualDisplay) this.d.get(surface)).release();
                this.d.remove(surface);
                c();
                return;
            }
        }
    }

    public void b() {
        synchronized (this) {
            d();
        }
    }

    private void c() {
        this.i = 4;
        this.j.postDelayed(new 2(this), 1000);
    }

    private void d() {
        for (VirtualDisplay virtualDisplay : this.d.values()) {
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        }
        this.d.clear();
        this.k.clear();
        f();
    }

    @TargetApi(21)
    private boolean e() {
        if (this.i != 1) {
            return true;
        }
        if (this.e == null || this.f == null) {
            return false;
        }
        this.i = 2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TXScreenCapture.OnAssistantActivityResult");
        this.e.registerReceiver(this.n, intentFilter);
        Intent intent = new Intent(this.e, TXScreenCapture$TXScreenCaptureAssistantActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
        this.e.startActivity(intent);
        return true;
    }

    @TargetApi(21)
    private void f() {
        if (this.k.isEmpty()) {
            this.l = false;
            if (this.g != null) {
                this.g.stop();
                this.g.unregisterCallback(this.a);
            }
            try {
                if (this.e != null) {
                    this.e.unregisterReceiver(this.n);
                }
            } catch (Exception e) {
            }
            this.g = null;
            this.i = 1;
        }
    }

    @TargetApi(21)
    private void a(int i, int i2, Intent intent) {
        try {
            synchronized (this) {
                try {
                    if (this.e != null) {
                        this.e.unregisterReceiver(this.n);
                    }
                } catch (Exception e) {
                }
                if (i == 1001 && i2 == -1) {
                    if (this.i == 2) {
                        this.g = this.f.getMediaProjection(i2, intent);
                        this.g.registerCallback(this.a, this.j);
                        this.l = true;
                        if (this.h.size() == 0) {
                            com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
                            this.i = 1;
                            return;
                        }
                        Iterator it = this.h.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (!(aVar == null || aVar.a == null || aVar.b == 0 || aVar.c == 0)) {
                                VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", aVar.b, aVar.c, 1, 1, aVar.a, null, null);
                                if (createVirtualDisplay == null) {
                                    com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
                                    this.i = 1;
                                    return;
                                }
                                this.d.put(aVar.a, createVirtualDisplay);
                            }
                        }
                        this.h.clear();
                        this.i = 3;
                        com.tencent.liteav.basic.util.a.a(this.m, 1004, "录屏启动成功");
                        return;
                    }
                }
                this.i = 1;
                com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
            }
        } catch (Exception e2) {
            this.i = 1;
            com.tencent.liteav.basic.util.a.a(this.m, -1308, "录屏失败");
        }
    }
}
