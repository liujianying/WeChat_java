package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b implements a {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private Context diZ;
    private List<Double> dja = new ArrayList(100);
    private int djb = 0;
    public double djc = 0.0d;
    public double djd = 0.0d;
    public double dje = 2.147483647E9d;
    public double djf = 0.0d;
    public double djg = 0.0d;

    public b(Context context) {
        this.diZ = context;
        this.djc = bz(context);
        x.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.djc);
    }

    public final void Cj() {
        this.djb = this.dja.size();
        if (this.djb == 0) {
            x.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
            return;
        }
        Double valueOf = Double.valueOf(0.0d);
        Double d = valueOf;
        for (Double valueOf2 : this.dja) {
            d = Double.valueOf(d.doubleValue() + valueOf2.doubleValue());
            this.djd = Math.max(this.djd, valueOf2.doubleValue());
            this.dje = Math.min(this.dje, valueOf2.doubleValue());
        }
        Double valueOf3 = Double.valueOf(d.doubleValue() / ((double) this.djb));
        this.djg = valueOf3.doubleValue() - this.djc;
        this.djd -= this.djc;
        this.dje -= this.djc;
        long j = 0;
        Iterator it = this.dja.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = (long) (Math.pow(((Double) it.next()).doubleValue() - valueOf3.doubleValue(), 2.0d) + ((double) j2));
            } else {
                this.djf = Math.sqrt((double) (j2 / ((long) this.djb)));
                return;
            }
        }
    }

    public final void Ck() {
        if (this.dja != null && this.dja.size() <= 10000 && this.diZ != null) {
            double bz = bz(this.diZ);
            this.djc = Math.min(bz, this.djc);
            if (this.djc == bz) {
                x.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.djc);
            }
            this.dja.add(Double.valueOf(bz));
        }
    }

    private static double bz(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        if ($assertionsDisabled || activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return (((double) (memoryInfo.totalMem - memoryInfo.availMem)) / 1024.0d) / 1024.0d;
        }
        throw new AssertionError();
    }
}
