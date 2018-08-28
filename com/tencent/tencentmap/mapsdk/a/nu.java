package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tencentmap.mapsdk.a.ac.c;
import com.tencent.tencentmap.mapsdk.a.ac.g;
import com.tencent.tencentmap.mapsdk.a.ac.h;
import com.tencent.tencentmap.mapsdk.a.ac.i;
import com.tencent.tencentmap.mapsdk.a.ac.j;
import com.tencent.tencentmap.mapsdk.a.ac.l;
import com.tencent.tencentmap.mapsdk.a.ac.p;

public class nu {
    private nz a = null;
    private p b = null;
    private Handler c = new 1(this, Looper.getMainLooper());

    public nu(nz nzVar) {
        this.a = nzVar;
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public or b() {
        if (this.a == null) {
            return null;
        }
        return this.a.d();
    }

    public final float c() {
        if (this.a == null) {
            return -1.0f;
        }
        return this.a.e();
    }

    public final float d() {
        if (this.a == null) {
            return -1.0f;
        }
        return this.a.f();
    }

    public final int a(x xVar) {
        if (this.a == null) {
            return Integer.MIN_VALUE;
        }
        return this.a.a(xVar);
    }

    public final int a(x xVar, long j, ac$a ac_a) {
        if (this.a == null) {
            return Integer.MIN_VALUE;
        }
        return this.a.a(xVar, j, ac_a);
    }

    public final void e() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public final void a(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public final void b(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public final boolean f() {
        if (this.a == null) {
            return false;
        }
        return this.a.h();
    }

    public final void a(h hVar) {
        if (this.a != null) {
            this.a.a(hVar);
        }
    }

    public final void a(j jVar) {
        if (this.a != null) {
            this.a.a(jVar);
        }
    }

    public final void a(c cVar) {
        if (this.a != null) {
            this.a.a(cVar);
        }
    }

    public void g() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public void h() {
        if (this.a != null) {
            this.a.k();
        }
    }

    public void i() {
        if (this.a != null) {
            this.a.p();
        }
    }

    public void j() {
        if (this.a != null) {
            this.a.q();
        }
    }

    public void k() {
        if (this.a != null) {
            this.a.l();
        }
    }

    public void l() {
        if (this.a != null) {
            this.a.m();
        }
    }

    private void a(Handler handler, Config config) {
        if (this.a != null) {
            this.a.a(handler, config);
        }
    }

    public void a(p pVar, Config config) {
        if (this.a != null && pVar != null) {
            this.b = pVar;
            a(this.c, config);
        }
    }

    public void a(float f, float f2, boolean z) {
        if (this.a != null) {
            this.a.a(f, f2, z);
        }
    }

    public String m() {
        if (this.a == null) {
            return "";
        }
        return this.a.n();
    }

    public void a(i iVar) {
        if (this.a != null) {
            this.a.a(iVar);
        }
    }

    public final void a(l lVar) {
        if (this.a != null) {
            this.a.a(lVar);
        }
    }

    public final void a(g gVar) {
        if (this.a != null) {
            this.a.a(gVar);
        }
    }

    public void c(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public void d(boolean z) {
        if (this.a != null) {
            this.a.e(z);
        }
    }

    public boolean n() {
        if (this.a == null) {
            return false;
        }
        return this.a.t();
    }
}
