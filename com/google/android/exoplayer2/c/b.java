package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import java.io.EOFException;
import java.util.Arrays;

public final class b implements e {
    private static final byte[] aiB = new byte[4096];
    private final f aiC;
    private final long aiD;
    private byte[] aiE = new byte[65536];
    private int aiF;
    private int aiG;
    private long position;

    public b(f fVar, long j, long j2) {
        this.aiC = fVar;
        this.position = j;
        this.aiD = j2;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int c = c(bArr, i, i2);
        if (c == 0) {
            c = a(bArr, i, i2, 0, true);
        }
        co(c);
        return c;
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        int c = c(bArr, i, i2);
        while (c < i2 && c != -1) {
            c = a(bArr, i, i2, c, z);
        }
        co(c);
        return c != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        a(bArr, i, i2, false);
    }

    public final int cj(int i) {
        int cm = cm(i);
        if (cm == 0) {
            cm = a(aiB, 0, Math.min(i, aiB.length), 0, true);
        }
        co(cm);
        return cm;
    }

    public final void ck(int i) {
        int cm = cm(i);
        while (cm < i && cm != -1) {
            cm = a(aiB, -cm, Math.min(i, aiB.length + cm), cm, false);
        }
        co(cm);
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) {
        if (!p(i2, z)) {
            return false;
        }
        System.arraycopy(this.aiE, this.aiF - i2, bArr, i, i2);
        return true;
    }

    public final void b(byte[] bArr, int i, int i2) {
        b(bArr, i, i2, false);
    }

    private boolean p(int i, boolean z) {
        int i2 = this.aiF + i;
        if (i2 > this.aiE.length) {
            this.aiE = Arrays.copyOf(this.aiE, t.u(this.aiE.length * 2, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.aiG - this.aiF, i);
        while (min < i) {
            min = a(this.aiE, this.aiF, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.aiF += i;
        this.aiG = Math.max(this.aiG, this.aiF);
        return true;
    }

    public final void cl(int i) {
        p(i, false);
    }

    public final void jS() {
        this.aiF = 0;
    }

    public final long jT() {
        return this.position + ((long) this.aiF);
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getLength() {
        return this.aiD;
    }

    private int cm(int i) {
        int min = Math.min(this.aiG, i);
        cn(min);
        return min;
    }

    private int c(byte[] bArr, int i, int i2) {
        if (this.aiG == 0) {
            return 0;
        }
        int min = Math.min(this.aiG, i2);
        System.arraycopy(this.aiE, 0, bArr, i, min);
        cn(min);
        return min;
    }

    private void cn(int i) {
        this.aiG -= i;
        this.aiF = 0;
        Object obj = this.aiE;
        if (this.aiG < this.aiE.length - 524288) {
            obj = new byte[(this.aiG + 65536)];
        }
        System.arraycopy(this.aiE, i, obj, 0, this.aiG);
        this.aiE = obj;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.aiC.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void co(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }
}
