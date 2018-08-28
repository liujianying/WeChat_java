package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;

public final class b extends FileInputStream {
    private boolean eet = false;
    private a eex;
    private long eey = 0;

    public b(String str, long j) {
        super(str);
        this.eex = new a(j);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.eet) {
            x.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bi.cjd().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read >= 0) {
            this.eex.y(bArr, i2);
        }
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.eex.seek(j);
        return skip;
    }

    public final void close() {
        super.close();
        if (this.eex != null) {
            this.eex.free();
        }
        x.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    }

    public final void mark(int i) {
        this.eey = this.eex.QF();
    }

    public final void reset() {
        getChannel().position(this.eey);
        this.eex.reset();
    }

    public final boolean markSupported() {
        return true;
    }
}
