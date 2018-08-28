package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static volatile ah fHR;
    private static String fHS = "app_brand_audio_player";
    private static Object lockObj = new Object();
    private static ag mHandler;
    private static AtomicInteger vLP = new AtomicInteger(0);

    public static void onCreate(String str) {
        x.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[]{str});
        if (vLP.incrementAndGet() == 1) {
            synchronized (lockObj) {
                ahV();
            }
        }
    }

    private static void ahV() {
        if (fHR == null) {
            fHR = new ah(fHS);
            g.a(fHS, new h(fHR.lnJ.getLooper(), fHS));
        }
        mHandler = new ag(fHR.lnJ.getLooper());
    }

    public static void Pa(String str) {
        x.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[]{str});
        if (vLP.decrementAndGet() == 0) {
            synchronized (lockObj) {
                if (!(fHR == null || fHR == null)) {
                    g.abF(fHS);
                    fHR.lnJ.quit();
                    fHR = null;
                    mHandler = null;
                }
            }
        }
    }

    public static void q(Runnable runnable) {
        synchronized (lockObj) {
            if (mHandler != null) {
                mHandler.post(runnable);
            } else {
                x.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
                ahV();
                mHandler.post(runnable);
            }
        }
    }
}
