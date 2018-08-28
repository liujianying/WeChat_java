package com.tencent.matrix.trace.a;

import android.content.Context;
import java.util.HashSet;

public final class a {
    public final boolean bsX;
    public final boolean bsY;
    public final HashSet<String> bsZ;
    public final long bta;
    public final long btb;
    private final long btc;
    public final long btd;
    public final long bte;
    private final float btf;
    private int mDeviceLevel;

    public static class a {
        public boolean btg = false;
        public boolean bth = false;
        public float bti = 16.666668f;
        public HashSet<String> btj;
        public long btk = 6000;
        public long btl = 8000;
        public long btm = 1000;
        public long bto = 1000;
        public long btp = 120000;
    }

    public /* synthetic */ a(boolean z, boolean z2, HashSet hashSet, long j, long j2, long j3, long j4, float f, long j5, byte b) {
        this(z, z2, hashSet, j, j2, j3, j4, f, j5);
    }

    private a(boolean z, boolean z2, HashSet<String> hashSet, long j, long j2, long j3, long j4, float f, long j5) {
        this.mDeviceLevel = 0;
        this.bsX = z;
        this.bsY = z2;
        this.bsZ = hashSet;
        this.bta = j;
        this.btd = 1000000 * j2;
        this.btc = j4;
        this.btb = j3;
        this.bte = j5;
        if (f == 0.0f) {
            f = 16.666668f;
        }
        this.btf = f;
    }

    public final String toString() {
        int i = 0;
        String str = "fpsEnable:%s,methodTraceEnable:%s,sceneSet size:%s,fpsTimeSliceMs:%s,EvilThresholdNano:%sns,frameRefreshRate:%s";
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(this.bsX);
        objArr[1] = Boolean.valueOf(this.bsY);
        if (this.bsZ != null) {
            i = this.bsZ.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Long.valueOf(this.bta);
        objArr[4] = Long.valueOf(this.btd);
        objArr[5] = Float.valueOf(this.btf);
        return String.format(str, objArr);
    }

    public final int aA(Context context) {
        if (this.mDeviceLevel != 0) {
            return this.mDeviceLevel;
        }
        int i = com.tencent.matrix.trace.e.a.aB(context).value;
        this.mDeviceLevel = i;
        return i;
    }
}
