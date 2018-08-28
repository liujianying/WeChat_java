package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ byte[] bAa;
    final /* synthetic */ b gZs;

    b$4(b bVar, byte[] bArr) {
        this.gZs = bVar;
        this.bAa = bArr;
    }

    public final void run() {
        try {
            synchronized (b.a(this.gZs)) {
                b.b(this.gZs).write(this.bAa);
                b.b(this.gZs).flush();
            }
        } catch (Exception e) {
            x.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[]{e});
            b.c(this.gZs);
            b.a(this.gZs, 10008, ("send_error " + e).getBytes());
        }
    }
}
