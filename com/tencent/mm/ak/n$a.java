package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n$a {
    static ag bvX;
    private ReentrantLock bvV = new ReentrantLock();
    private Condition bvW = this.bvV.newCondition();
    int dTO;
    a dVZ;

    public static class a {
        String dTV;
        PString dWc;
        PString dWd;
        PString dWe;
        PString dWf;
    }

    public static n$a a(n$e n_e) {
        synchronized (n$a.class) {
            if (bvX == null) {
                HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                handlerThread.start();
                bvX = new ag(handlerThread.getLooper());
            }
        }
        n$a n_a = new n$a();
        n_e.dWt = n_a;
        bvX.post(new 1(n_e.dWt, n_e));
        n_a.dTO = n_e.dTO;
        return n_a;
    }

    public final a OY() {
        this.bvV.lock();
        while (this.dVZ == null) {
            try {
                x.i("MicroMsg.SendImgSpeeder", "getResult await");
                this.bvW.await();
            } catch (Exception e) {
            } finally {
                this.bvV.unlock();
            }
        }
        return this.dVZ;
    }
}
