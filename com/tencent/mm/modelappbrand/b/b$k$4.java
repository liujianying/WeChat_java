package com.tencent.mm.modelappbrand.b;

import com.tencent.mm.modelappbrand.b.b.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;

class b$k$4 implements Runnable {
    final /* synthetic */ k dGn;

    b$k$4(k kVar) {
        this.dGn = kVar;
    }

    public final void run() {
        Closeable bufferedInputStream;
        Throwable e;
        k kVar = this.dGn;
        Closeable jx;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kVar.dGg).openConnection();
            jx = kVar.dFR.jx(b.access$1500(kVar.dGg));
            if (jx == null) {
                bi.d(jx);
                bi.d(null);
            } else {
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = null;
                    try {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", new Object[]{kVar.dGg});
                        kVar.dFR.jy(b.access$1500(kVar.dGg));
                        bi.d(jx);
                        bi.d(bufferedInputStream);
                        b.d(this.dGn.dGe).j(new Runnable() {
                            public final void run() {
                                b$k$4.this.dGn.dGl = false;
                                b$k$4.this.dGn.Kk();
                            }
                        });
                    } catch (Throwable th) {
                        e = th;
                        bi.d(jx);
                        bi.d(bufferedInputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedInputStream = null;
                    bi.d(jx);
                    bi.d(bufferedInputStream);
                    throw e;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        jx.write(bArr, 0, read);
                    }
                    jx.flush();
                    bi.d(jx);
                    bi.d(bufferedInputStream);
                } catch (Exception e3) {
                    e = e3;
                    x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", new Object[]{kVar.dGg});
                    kVar.dFR.jy(b.access$1500(kVar.dGg));
                    bi.d(jx);
                    bi.d(bufferedInputStream);
                    b.d(this.dGn.dGe).j(/* anonymous class already generated */);
                }
            }
        } catch (Exception e4) {
            e = e4;
            jx = null;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            e = th3;
            jx = null;
            bufferedInputStream = null;
            bi.d(jx);
            bi.d(bufferedInputStream);
            throw e;
        }
        b.d(this.dGn.dGe).j(/* anonymous class already generated */);
    }
}
