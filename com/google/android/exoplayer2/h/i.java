package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class i {
    public final byte[] aAI;
    public final long aAJ;
    public final long aAK;
    public final String aAL;
    public final int flags;
    public final long position;
    public final Uri uri;

    public i(Uri uri) {
        this(uri, (byte) 0);
    }

    public i(Uri uri, long j, long j2) {
        this(uri, j, j, j2, 0);
    }

    public i(Uri uri, byte b) {
        this(uri, 0, 0, -1, 1);
    }

    private i(Uri uri, long j, long j2, long j3, int i) {
        this(uri, null, j, j2, j3, null, i);
    }

    private i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        a.ao(j >= 0);
        a.ao(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        a.ao(z);
        this.uri = uri;
        this.aAI = bArr;
        this.aAJ = j;
        this.position = j2;
        this.aAK = j3;
        this.aAL = str;
        this.flags = i;
    }

    public final boolean lQ() {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.aAI) + ", " + this.aAJ + ", " + this.position + ", " + this.aAK + ", " + this.aAL + ", " + this.flags + "]";
    }

    public final i R(long j) {
        long j2 = -1;
        if (this.aAK != -1) {
            j2 = this.aAK - j;
        }
        return (j == 0 && this.aAK == j2) ? this : new i(this.uri, this.aAI, this.aAJ + j, this.position + j, j2, this.aAL, this.flags);
    }
}
