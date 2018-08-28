package com.tencent.mm.modelvoice;

import android.content.ComponentName;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method eoN;
    private static Method eoO;
    private AudioManager eoL;
    private ComponentName eoM;

    static {
        try {
            if (eoN == null) {
                eoN = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (eoO == null) {
                eoO = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
        } catch (NoSuchMethodException e) {
        }
    }

    protected final void finalize() {
        try {
            if (eoO != null) {
                eoO.invoke(this.eoL, new Object[]{this.eoM});
                RemoteControlReceiver.TA();
            }
        } catch (Throwable e) {
            Throwable th = e;
            Throwable e2 = th.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException(th);
            }
        } catch (IllegalAccessException e3) {
            x.e("MicroMsg.RemoteControlReceiver", "unexpected " + e3);
        }
        super.finalize();
    }
}
