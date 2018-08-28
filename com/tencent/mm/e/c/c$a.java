package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

final class c$a implements Runnable {
    final /* synthetic */ c bFN;

    private c$a(c cVar) {
        this.bFN = cVar;
    }

    public /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    public final void run() {
        x.i("MicroMsg.SilkWriter", "Silk Thread start run");
        while (true) {
            boolean a;
            synchronized (this.bFN) {
                a = c.a(this.bFN);
            }
            x.d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + c.b(this.bFN).size());
            if (!a || !c.b(this.bFN).isEmpty()) {
                try {
                    a aVar = (a) c.b(this.bFN).poll(200, TimeUnit.MILLISECONDS);
                    if (aVar == null) {
                        x.i("MicroMsg.SilkWriter", "poll byte null file:" + c.c(this.bFN));
                    } else {
                        int size = c.b(this.bFN).size();
                        if (size > 10 || a) {
                            x.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                            size = false;
                        } else if (size < 9) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (c.wD().count >= 10 && c.wD().bFz > 240) {
                            size = 0;
                        }
                        this.bFN.a(aVar, size, false);
                    }
                } catch (InterruptedException e) {
                    x.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                }
            } else {
                return;
            }
        }
        while (true) {
        }
    }
}
