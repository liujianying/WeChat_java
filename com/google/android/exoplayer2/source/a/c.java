package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public abstract class c extends a {
    private volatile boolean asP;
    public byte[] data;
    private int limit;

    public abstract void e(byte[] bArr, int i);

    public c(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr) {
        super(fVar, iVar, 3, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public final long kP() {
        return (long) this.limit;
    }

    public final void kQ() {
        this.asP = true;
    }

    public final boolean kR() {
        return this.asP;
    }

    public final void kS() {
        int i = 0;
        try {
            this.aiC.a(this.asJ);
            this.limit = 0;
            while (i != -1 && !this.asP) {
                if (this.data == null) {
                    this.data = new byte[16384];
                } else if (this.data.length < this.limit + 16384) {
                    this.data = Arrays.copyOf(this.data, this.data.length + 16384);
                }
                i = this.aiC.read(this.data, this.limit, 16384);
                if (i != -1) {
                    this.limit += i;
                }
            }
            if (!this.asP) {
                e(this.data, this.limit);
            }
            t.a(this.aiC);
        } catch (Throwable th) {
            t.a(this.aiC);
        }
    }
}
