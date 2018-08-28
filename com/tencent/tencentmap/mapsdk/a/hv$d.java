package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.tencentmap.mapsdk.a.hv.e;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class hv$d {
    final /* synthetic */ hv a;
    private final ArrayList<e> b;
    private e c;

    private hv$d(hv hvVar) {
        this.a = hvVar;
        this.b = new ArrayList();
    }

    private e b() {
        e eVar = null;
        synchronized (this.b) {
            if (this.b.size() > 0) {
                eVar = (e) this.b.get(0);
            }
        }
        return eVar;
    }

    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.b == null || this.b.isEmpty();
        }
        return z;
    }

    public synchronized e a(GL10 gl10) {
        e eVar = null;
        synchronized (this) {
            this.c = b();
            if (this.c != null) {
                if (this.c.c()) {
                    a(this.c);
                } else {
                    hv.c(this.a).h();
                    Rect c = e.c(this.c);
                    int d = e.d(this.c);
                    int e = e.e(this.c);
                    Rect rect = new Rect();
                    int density = (int) (SystemUtil.getDensity(hv.d(this.a)) * 20.0f);
                    d = ((hv.e(this.a).width() - d) / 2) + density;
                    rect.right = d;
                    rect.left = d;
                    d = ((hv.e(this.a).height() - e) / 2) + density;
                    rect.bottom = d;
                    rect.top = d;
                    hv.c(this.a).b(c, rect);
                    eVar = this.c;
                }
            }
        }
        return eVar;
    }

    public synchronized void a(GL10 gl10, hs hsVar, hh hhVar) {
        if (hv.a(this.a) != null) {
            iw f = e.f(this.c);
            if (f != null) {
                if (f instanceof in) {
                    ((in) f).a(hsVar, hhVar);
                }
                f.b(hsVar, hhVar);
            }
            hsVar.a();
        }
    }

    public synchronized void b(GL10 gl10, hs hsVar, hh hhVar) {
        if (!(this.c == null || this.c.c())) {
            int d = e.d(this.c);
            int e = e.e(this.c);
            ig g = e.g(this.c);
            iw f = e.f(this.c);
            Bitmap a = a(gl10, d, e);
            if (!(g == null || this.c.a())) {
                g.a(a, f);
            }
            a(this.c);
        }
    }

    private void a(e eVar) {
        if (eVar != null && !eVar.a()) {
            eVar.b();
            synchronized (this.b) {
                this.b.remove(eVar);
            }
            hv.c(this.a).i();
        }
    }

    private Bitmap a(GL10 gl10, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        Buffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        gl10.glReadPixels((hv.e(this.a).width() - i) / 2, (hv.e(this.a).height() - i2) / 2, i, i2, 6408, 5121, wrap);
        for (i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                iArr2[(((i2 - i3) - 1) * i) + i4] = ((i5 & -16711936) | ((i5 << 16) & 16711680)) | ((i5 >> 16) & 255);
            }
        }
        try {
            return Bitmap.createBitmap(iArr2, i, i2, Config.RGB_565);
        } catch (OutOfMemoryError e) {
            return Bitmap.createBitmap(iArr2, i, i2, Config.RGB_565);
        }
    }
}
