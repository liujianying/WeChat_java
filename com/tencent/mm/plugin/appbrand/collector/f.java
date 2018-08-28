package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f {
    private static final AtomicInteger fof = new AtomicInteger();
    private static final AtomicLong fog = new AtomicLong();
    private static boolean foh;

    public static void bO(long j) {
        if (foh && j > 0) {
            x.v("MicroMsg.FPSCollector", "collect(cost : %s)", Long.valueOf(j));
            fog.addAndGet(j);
            fof.getAndIncrement();
        }
    }

    public static void reset() {
        fof.set(0);
        fog.set(0);
    }

    public static void cy(boolean z) {
        foh = z;
    }

    public static boolean ads() {
        return foh;
    }

    public static String adt() {
        float f = 0.0f;
        int i = fof.get();
        long j = fog.get();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("fps : ");
        int i2 = fof.get();
        long j2 = fog.get();
        float f2 = (!foh || j2 <= 0) ? 0.0f : (((float) i2) * 1000.0f) / ((float) j2);
        append.append(f2);
        stringBuilder.append("\ncount : ").append(i);
        StringBuilder append2 = stringBuilder.append("\naverage cost : ");
        if (i > 0) {
            f = (1.0f * ((float) j)) / ((float) i);
        }
        append2.append(f);
        return stringBuilder.toString();
    }
}
