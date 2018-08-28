package com.tencent.mm.app;

import android.os.Debug;
import android.support.design.a$i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements Runnable {
    int bxW = 0;
    private final Runnable bxX = new 1(this);

    a$c() {
    }

    public final void run() {
        h.mEJ.a(510, 0, 1, true);
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", new Object[]{Thread.currentThread()});
        int i = -1;
        while (!r10.isInterrupted()) {
            int i2 = this.bxW;
            a.uz().post(this.bxX);
            try {
                Thread.sleep((long) a.ux());
                if (this.bxW == i2) {
                    if (a.uB() || !Debug.isDebuggerConnected()) {
                        a$a k;
                        a.uz().removeCallbacks(this.bxX);
                        long zw = (long) a.uC().zw();
                        long zx = (long) a.uC().zx();
                        long zv = (long) a.uC().zv();
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", new Object[]{Long.valueOf(zw), Long.valueOf(zx), Long.valueOf(zv)});
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                        }
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", new Object[]{a.uD(), Integer.valueOf(i2), Integer.valueOf(this.bxW), Long.valueOf(System.currentTimeMillis())});
                        if (a.uD() != null) {
                            k = a$a.k(a.uD(), a.uE());
                        } else {
                            k = a$a.uK();
                        }
                        h.mEJ.a(510, 1, 1, true);
                        switch (a.uF()) {
                            case 1:
                                h.mEJ.a(510, 2, 1, true);
                                break;
                            case 2:
                                h.mEJ.a(510, 3, 1, true);
                                break;
                            case 4:
                                h.mEJ.a(510, 4, 1, true);
                                break;
                            case 8:
                                h.mEJ.a(510, 5, 1, true);
                                break;
                            case 16:
                                h.mEJ.a(510, 6, 1, true);
                                break;
                            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                                h.mEJ.a(510, 13, 1, true);
                                break;
                        }
                        if (a.uG() > 0) {
                            h.mEJ.a(510, 7, 1, true);
                        }
                        a.uH().c(k);
                        a.uI();
                        if (a.uG() >= 10) {
                            a.uJ();
                        }
                        zw = ((long) ((a.er(a.uG()) * 5) * 60)) * 1000;
                        this.bxW = 0;
                        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", new Object[]{Integer.valueOf(a.uG()), Long.valueOf(zw), Integer.valueOf(0), Integer.valueOf(this.bxW)});
                        try {
                            Thread.sleep(zw);
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", new Object[]{Integer.valueOf(a.uG()), Long.valueOf(zw), Integer.valueOf(0), Integer.valueOf(this.bxW)});
                        } catch (InterruptedException e2) {
                            a.uA().a(e2);
                            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                            return;
                        }
                    }
                    if (this.bxW != i) {
                        x.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i = this.bxW;
                }
            } catch (InterruptedException e22) {
                a.uA().a(e22);
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
                return;
            }
        }
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", new Object[]{Boolean.valueOf(r10.isInterrupted())});
    }
}
