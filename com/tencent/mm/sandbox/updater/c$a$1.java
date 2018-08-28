package com.tencent.mm.sandbox.updater;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.sandbox.updater.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class c$a$1 extends OutputStream {
    private ag handler = new ag(Looper.getMainLooper());
    private ByteArrayOutputStream sDU = new ByteArrayOutputStream();
    final /* synthetic */ a sDV;

    c$a$1(a aVar) {
        this.sDV = aVar;
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.sDU.write(bArr, i, i2);
        if (this.sDU.size() >= 131072 || a.a(this.sDV) + this.sDU.size() >= a.b(this.sDV)) {
            int size = this.sDU.size();
            int a = e.a(this.sDV.sDP.beJ(), this.sDU.toByteArray(), size);
            this.sDU.reset();
            if (a != 0) {
                throw new IOException("appendToFile failed :" + a);
            }
            a.a(this.sDV, a.a(this.sDV) + size);
            this.handler.post(new 1(this, size));
            if (this.sDV.sDP.dZm) {
                throw new IOException("manual force cancel!");
            }
        }
    }

    public final void write(int i) {
        throw new IOException("unexpected operation");
    }
}
