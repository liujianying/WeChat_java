package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

public final class h extends InputStream {
    private final byte[] aAG;
    long aAH;
    private final f aiC;
    private final i asJ;
    private boolean closed = false;
    private boolean opened = false;

    public h(f fVar, i iVar) {
        this.aiC = fVar;
        this.asJ = iVar;
        this.aAG = new byte[1];
    }

    public final int read() {
        if (read(this.aAG) == -1) {
            return -1;
        }
        return this.aAG[0] & WebView.NORMAL_MODE_ALPHA;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        a.ap(!this.closed);
        lP();
        int read = this.aiC.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.aAH += (long) read;
        return read;
    }

    public final void close() {
        if (!this.closed) {
            this.aiC.close();
            this.closed = true;
        }
    }

    final void lP() {
        if (!this.opened) {
            this.aiC.a(this.asJ);
            this.opened = true;
        }
    }
}
