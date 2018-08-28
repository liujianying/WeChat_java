package com.tencent.matrix.d;

import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Iterator;

public class a {
    private static HandlerThread buT;
    private static HashSet<HandlerThread> buU = new HashSet();

    public static HandlerThread tJ() {
        if (buT != null) {
            return buT;
        }
        synchronized (a.class) {
            if (buT == null) {
                HandlerThread handlerThread = new HandlerThread("default_matrix_thread");
                buT = handlerThread;
                handlerThread.start();
                b.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal", new Object[0]);
            }
        }
        return buT;
    }

    public static HandlerThread cd(String str) {
        Iterator it = buU.iterator();
        while (it.hasNext()) {
            if (!((HandlerThread) it.next()).isAlive()) {
                it.remove();
                b.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", str);
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        buU.add(handlerThread);
        b.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", str, Integer.valueOf(buU.size()));
        return handlerThread;
    }
}
