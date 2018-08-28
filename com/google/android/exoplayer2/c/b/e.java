package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.Format;

public final class e {
    public final Format aep;
    public final long aet;
    public final int alp;
    public final long amd;
    public final long ame;
    public final int amf;
    public final long[] amg;
    public final long[] amh;
    private final f[] ami;
    public final int id;
    public final int type;

    public e(int i, int i2, long j, long j2, long j3, Format format, int i3, f[] fVarArr, int i4, long[] jArr, long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.amd = j;
        this.ame = j2;
        this.aet = j3;
        this.aep = format;
        this.amf = i3;
        this.ami = fVarArr;
        this.alp = i4;
        this.amg = jArr;
        this.amh = jArr2;
    }

    public final f cx(int i) {
        return this.ami == null ? null : this.ami[i];
    }
}
