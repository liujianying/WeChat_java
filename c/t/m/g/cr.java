package c.t.m.g;

import android.location.Location;
import java.util.List;

public final class cr {
    public final ct a;
    public volatile boolean b = false;
    public cs c;
    public dp d;
    public List<dp> e;
    public dt f;
    public dq g;
    public Location h;

    public cr(ct ctVar) {
        this.a = ctVar;
    }

    public final void a() {
        this.e = null;
        this.d = null;
        this.g = null;
        this.g = null;
    }

    public final boolean b() {
        if (this.g != null) {
            boolean z;
            dq dqVar = this.g;
            if (dqVar.a == null || dqVar.a.getAltitude() == 0.0d || System.currentTimeMillis() - dqVar.b > 10000) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        if (b()) {
            if (this.e == null || this.e.size() == 0) {
                this.e = ec.a(this.a);
            }
            if (this.e != null && this.e.size() != 0) {
                if (this.c != null) {
                    this.c.a(this.g, null, this.e);
                }
                if (this.h == null) {
                    this.h = new Location(this.g.a);
                } else {
                    this.h.set(this.g.a);
                }
            }
        }
    }
}
