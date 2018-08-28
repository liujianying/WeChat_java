package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class bd {
    private AtomicBoolean a = new AtomicBoolean();
    private long b = Millis100TimeProvider.INSTANCE.currentTimeMillis();
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private boolean i = true;
    private long j = 0;

    public void a(be beVar, bb bbVar, int i) {
        if (i == 0) {
            this.c = 0;
            this.d = 0;
            this.a.set(true);
            this.h = false;
            this.g++;
        } else if (i == 2) {
            if (this.a.get()) {
                this.a.set(false);
                this.c = 1;
                this.d = Millis100TimeProvider.INSTANCE.currentTimeMillis();
            } else {
                this.c++;
            }
            this.h = false;
            this.e++;
        } else if (i == 1) {
            if (this.a.get()) {
                this.a.set(false);
                this.c = 1;
                this.d = Millis100TimeProvider.INSTANCE.currentTimeMillis();
            } else {
                this.c++;
            }
            this.h = false;
            this.f++;
        } else if (i == 3) {
            this.h = true;
        }
        if (this.b + ((long) beVar.c().taf_timeout_interval()) < Millis100TimeProvider.INSTANCE.currentTimeMillis()) {
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.b = Millis100TimeProvider.INSTANCE.currentTimeMillis();
        }
        if (this.i) {
            long j = (this.e + this.f) + this.g;
            if (this.e >= ((long) beVar.c().taf_min_timeout_invoke()) && bw.a((double) this.e, (double) j, 2) > ((double) beVar.c().taf_timeout_radio())) {
                this.i = false;
            }
            if (this.i && this.c >= ((long) beVar.c().taf_frequence_fail_invoke()) && this.d + 5000 > Millis100TimeProvider.INSTANCE.currentTimeMillis()) {
                this.i = false;
            }
            if (this.i && this.h) {
                this.i = false;
            }
        } else if (i == 0) {
            this.i = true;
        }
    }

    public boolean a() {
        return this.i;
    }

    public long b() {
        return this.j;
    }

    public void a(long j) {
        this.j = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lastCallSucc:").append(this.a.get()).append("|");
        stringBuilder.append("timeout_startTime:").append(new Date(this.b)).append("|");
        stringBuilder.append("frequenceFailInvoke:").append(this.c).append("|");
        stringBuilder.append("timeoutCount:").append(this.e).append("|");
        stringBuilder.append("failedCount:").append(this.f).append("|");
        stringBuilder.append("succCount:").append(this.g).append("|");
        stringBuilder.append("netConnectTimeout:").append(this.h).append("|");
        stringBuilder.append("active:").append(this.i).append("|");
        return stringBuilder.toString();
    }
}
