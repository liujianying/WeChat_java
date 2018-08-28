package com.tencent.mm.plugin.game.wepkg.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private a kgi;
    private long size;

    public b(File file, long j, long j2) {
        this.size = j2;
        this.kgi = new a(new FileInputStream(file));
        dJ(j);
        this.kgi.aVA();
    }

    public final int read() {
        if ((aVB() <= 0 ? 1 : null) != null) {
            return -1;
        }
        return this.kgi.read();
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        long dI = dI((long) i2);
        if (dI != 0 || i2 <= 0) {
            return this.kgi.read(bArr, i, (int) dI);
        }
        return -1;
    }

    public final long skip(long j) {
        return this.kgi.skip(dI(j));
    }

    public final int available() {
        return (int) dI((long) this.kgi.available());
    }

    private long dI(long j) {
        return Math.min(aVB(), j);
    }

    private long aVB() {
        return this.size - ((long) this.kgi.count);
    }

    private void dJ(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.kgi.skip(j - j2);
            if (skip <= 0) {
                break;
            }
            j2 += skip;
        }
        if (j2 < j) {
            throw new IOException("could not seek pos " + j);
        }
    }
}
