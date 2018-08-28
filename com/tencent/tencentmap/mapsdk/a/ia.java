package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;
import com.tencent.map.lib.d;
import java.util.ArrayList;

public class ia implements hz {
    private ArrayList<hz> a = new ArrayList();

    public synchronized void a(hz hzVar) {
        if (hzVar != null) {
            if (!this.a.contains(hzVar)) {
                this.a.add(hzVar);
            }
        }
    }

    public synchronized void b(hz hzVar) {
        this.a.remove(hzVar);
    }

    public synchronized boolean a(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).a(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean b(float f, float f2) {
        boolean z;
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).b(f, f2)) {
                z = true;
                break;
            }
        }
        d.a("notify onSingleTap");
        for (size = this.a.size() - 1; size >= 0; size--) {
            ((hz) this.a.get(size)).d();
        }
        z = false;
        return z;
    }

    public void d() {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((hz) this.a.get(size)).d();
        }
    }

    public synchronized boolean c(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).c(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean d(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).d(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean e(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).e(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean f(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).f(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean g(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).g(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean h(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).h(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean a() {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).a()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean b() {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).b()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean a(float f) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).a(f)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean c() {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).c()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean a(PointF pointF, PointF pointF2, float f) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).a(pointF, pointF2, f)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).a(pointF, pointF2, d, d2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean i(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).i(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean j(float f, float f2) {
        boolean z;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).j(f, f2)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public boolean k(float f, float f2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((hz) this.a.get(size)).k(f, f2)) {
                return true;
            }
        }
        return false;
    }
}
