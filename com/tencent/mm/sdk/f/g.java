package com.tencent.mm.sdk.f;

import android.os.Debug;
import com.tencent.mm.sdk.f.e.b;
import junit.framework.Assert;

final class g implements Comparable<g>, Runnable {
    private static final String FORMAT;
    private static int sLk = 1000;
    long dFc;
    final String jGC;
    final int priority;
    final Runnable sHb;
    long sHf;
    long sHh;
    final boolean sLl;
    b sLm;
    boolean started = false;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.sHf) / ((long) sLk));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        return gVar.priority - i;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|pooled = %b");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        FORMAT = stringBuilder.toString();
    }

    g(Runnable runnable, String str, int i, boolean z, b bVar) {
        Assert.assertNotNull("ThreadTask arg task is null!", runnable);
        Assert.assertNotNull("ThreadTask arg name is null!", str);
        this.sHb = runnable;
        this.jGC = str;
        this.priority = i;
        this.sLl = z;
        this.sHf = System.currentTimeMillis();
        this.sLm = bVar;
    }

    public final void run() {
        this.dFc = System.currentTimeMillis();
        this.sHh = Debug.threadCpuTimeNanos();
        this.started = true;
        this.sHb.run();
        this.dFc = System.currentTimeMillis() - this.dFc;
        this.sHh = Debug.threadCpuTimeNanos() - this.sHh;
    }

    public final String toString() {
        return String.format(FORMAT, new Object[]{this.jGC, Integer.valueOf(this.priority), Boolean.valueOf(this.sLl), Long.valueOf(this.sHf), Long.valueOf(this.dFc), Long.valueOf(this.sHh), Boolean.valueOf(this.started)});
    }
}
