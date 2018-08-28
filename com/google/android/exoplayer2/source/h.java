package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.source.g.a;
import java.io.EOFException;

public final class h implements k {
    public final j aiZ = new j(32);
    public long anq;
    public final b asl;
    public final int asm;
    public final g asn = new g();
    public final a aso = new a();
    public a asp = new a(0, this.asm);
    public a asq = this.asp;
    public a asr = this.asp;
    public Format ass;
    private boolean ast;
    private Format asu;
    private long asv;
    public boolean asw;
    public b asx;

    public h(b bVar) {
        this.asl = bVar;
        this.asm = bVar.lN();
    }

    public final void rewind() {
        this.asn.rewind();
        this.asq = this.asp;
    }

    public final void kM() {
        L(this.asn.kL());
    }

    public final boolean e(long j, boolean z) {
        return this.asn.e(j, z);
    }

    public final void a(long j, byte[] bArr, int i) {
        K(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.asq.ald - j));
            System.arraycopy(this.asq.asA.data, this.asq.M(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == this.asq.ald) {
                this.asq = this.asq.asB;
            }
        }
    }

    public final void K(long j) {
        while (j >= this.asq.ald) {
            this.asq = this.asq.asB;
        }
    }

    public final void L(long j) {
        if (j != -1) {
            while (j >= this.asp.ald) {
                this.asl.a(this.asp.asA);
                this.asp = this.asp.kN();
            }
            if (this.asq.asy < this.asp.asy) {
                this.asq = this.asp;
            }
        }
    }

    public final void f(Format format) {
        long j = this.asv;
        Format u = format == null ? null : (j == 0 || format.aek == Long.MAX_VALUE) ? format : format.u(j + format.aek);
        boolean i = this.asn.i(u);
        this.asu = format;
        this.ast = false;
        if (this.asx != null && i) {
            this.asx.kO();
        }
    }

    public final int a(e eVar, int i, boolean z) {
        int read = eVar.read(this.asr.asA.data, this.asr.M(this.anq), cJ(i));
        if (read != -1) {
            cK(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void a(j jVar, int i) {
        while (i > 0) {
            int cJ = cJ(i);
            jVar.readBytes(this.asr.asA.data, this.asr.M(this.anq), cJ);
            i -= cJ;
            cK(cJ);
        }
    }

    public final void a(long j, int i, int i2, int i3, k.a aVar) {
        if (this.ast) {
            f(this.asu);
        }
        if (this.asw) {
            if ((i & 1) != 0 && this.asn.J(j)) {
                this.asw = false;
            } else {
                return;
            }
        }
        this.asn.a(j + this.asv, i, (this.anq - ((long) i2)) - ((long) i3), i2, aVar);
    }

    private int cJ(int i) {
        if (!this.asr.asz) {
            a aVar = this.asr;
            com.google.android.exoplayer2.h.a lL = this.asl.lL();
            a aVar2 = new a(this.asr.ald, this.asm);
            aVar.asA = lL;
            aVar.asB = aVar2;
            aVar.asz = true;
        }
        return Math.min(i, (int) (this.asr.ald - this.anq));
    }

    private void cK(int i) {
        this.anq += (long) i;
        if (this.anq == this.asr.ald) {
            this.asr = this.asr.asB;
        }
    }
}
