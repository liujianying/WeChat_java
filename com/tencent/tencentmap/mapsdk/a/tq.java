package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;

public final class tq {
    private boolean a = false;
    private su b;
    private sl c;
    private Handler d = new Handler();
    private a e;
    private float f = 0.0f;

    public tq(sl slVar) {
        this.c = slVar;
    }

    public final void a(boolean z) {
        if (!z || !this.a || this.b == null) {
            if (z) {
                rg rgVar = new rg();
                rgVar.a(ti.a(this.c, tc$a.TRAFFIC)).b(false).a(true).a(0.0f);
                this.b = this.c.g().a(rgVar);
                this.e = new a(this, 60000);
                this.d.post(this.e);
            } else if (this.b != null) {
                this.b.b();
                this.b = null;
                this.e.a(false);
                this.d.removeCallbacks(this.e);
                this.e = null;
            } else {
                return;
            }
            this.a = z;
        }
    }

    public final boolean a() {
        return this.a;
    }
}
