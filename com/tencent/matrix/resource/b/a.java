package com.tencent.matrix.resource.b;

import java.util.concurrent.TimeUnit;

public final class a {
    private static final long bru = TimeUnit.MINUTES.toMillis(1);
    public static final a bry = new a(bru, 3, true);
    public final long brv;
    public final int brw;
    public final boolean brx;

    public static final class a {
        public long brv = a.bru;
        public int brw = 3;
        public boolean brx = true;
    }

    public /* synthetic */ a(long j, int i, boolean z, byte b) {
        this(j, i, z);
    }

    private a(long j, int i, boolean z) {
        this.brv = j;
        this.brw = i;
        this.brx = z;
    }
}
