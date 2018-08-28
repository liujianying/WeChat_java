package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.mm.sdk.platformtools.x;

class h$1 extends Thread {
    final /* synthetic */ h gey;

    h$1(h hVar) {
        this.gey = hVar;
    }

    public final void run() {
        while (this.gey.Sx) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (!this.gey.fcO) {
                    h hVar = this.gey;
                    synchronized (hVar.gek) {
                        if (hVar.Sx) {
                            V8Locker locker = hVar.gek.getLocker();
                            locker.acquire();
                            while (true) {
                                Runnable runnable = (Runnable) hVar.gew.poll();
                                if (runnable == null) {
                                    locker.release();
                                    break;
                                }
                                try {
                                    runnable.run();
                                } catch (V8ScriptException e2) {
                                    x.e("J2V8", "V8 Script Error: %s", new Object[]{e2});
                                    if (hVar.gex != null) {
                                        hVar.gex.aR(e2.getJSMessage(), e2.getJSStackTrace());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
