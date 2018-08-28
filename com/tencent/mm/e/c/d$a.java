package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

final class d$a implements Runnable {
    final /* synthetic */ d bFQ;

    public final void run() {
        while (true) {
            boolean z;
            synchronized (this.bFQ) {
                z = this.bFQ.bFD;
            }
            x.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.bFQ.bFC.size());
            if (!z || !this.bFQ.bFC.isEmpty()) {
                try {
                    a aVar = (a) this.bFQ.bFC.poll(200, TimeUnit.MILLISECONDS);
                    if (aVar == null) {
                        x.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.bFQ.bFE);
                    } else {
                        this.bFQ.a(aVar, 0, false);
                    }
                } catch (InterruptedException e) {
                    x.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                }
            } else {
                return;
            }
        }
        while (true) {
        }
    }
}
