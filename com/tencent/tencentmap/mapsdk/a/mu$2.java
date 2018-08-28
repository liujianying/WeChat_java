package com.tencent.tencentmap.mapsdk.a;

import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.a.mu.a;

class mu$2 implements a {
    final /* synthetic */ mu a;
    private pa b = null;
    private boolean c = false;

    mu$2(mu muVar) {
        this.a = muVar;
    }

    public void a() {
        this.c = false;
        this.b = null;
    }

    public void a(MotionEvent motionEvent) {
        if (this.c && this.b != null) {
            ac$m y = this.b.y();
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                case 4:
                    this.c = false;
                    if (y != null) {
                        y.c(this.b);
                    }
                    if (mu.c(this.a) != null) {
                        mu.c(this.a).c(this.b);
                    }
                    this.b = null;
                    return;
                case 2:
                    this.b.a(kh.a(mu.b(this.a).getMap().s().a(new DoublePoint((double) ((int) motionEvent.getX()), (double) ((int) motionEvent.getY())))));
                    if (y != null) {
                        y.b(this.b);
                    }
                    if (mu.c(this.a) != null) {
                        mu.c(this.a).b(this.b);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(String str) {
        if (str.trim().length() == 0) {
            this.b = null;
            this.c = false;
            return;
        }
        this.b = mu.a(this.a, str);
        if (this.b == null) {
            return;
        }
        if (this.b.m()) {
            this.c = true;
            if (mu.c(this.a) != null) {
                mu.c(this.a).a(this.b);
                return;
            }
            return;
        }
        this.b = null;
        this.c = false;
    }
}
