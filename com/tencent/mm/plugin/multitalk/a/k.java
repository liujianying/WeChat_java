package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.talkroom.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class k implements Runnable {
    boolean bFi;
    protected volatile a ltC;
    protected LinkedBlockingQueue<c> lum = new LinkedBlockingQueue();
    protected ag[] lun;
    volatile d luo = new d("multitalk_network");
    private int lup;
    private int luq = 5;
    private int lur;
    private int lus;

    public class c {
        boolean dDR;
        int[] luv;
        int luw;
        int lux;
        int luy;
        String username;

        c(boolean z) {
            this.dDR = z;
        }
    }

    public k(a aVar) {
        this.ltC = aVar;
    }

    public final void start() {
        int i;
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[]{Integer.valueOf(this.lup)});
        this.bFi = true;
        e.d(this, "MultiTalk_videoReceiver1", 1).start();
        e.d(this, "MultiTalk_videoReceiver2", 1).start();
        this.lun = new ag[2];
        for (i = 0; i < this.lun.length; i++) {
            e.d(new a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.lum.add(new c(false));
        }
    }

    public final void stop() {
        int i = 0;
        this.ltC = null;
        this.bFi = false;
        this.lup = 0;
        if (this.lun != null) {
            while (i < this.lun.length) {
                if (this.lun[i] != null) {
                    this.lun[i].removeCallbacksAndMessages(null);
                    this.lun[i].getLooper().quit();
                    this.lun[i] = null;
                }
                i++;
            }
        }
        this.lum.clear();
        this.lum.add(new c(true));
        this.lum.add(new c(true));
    }

    public final void run() {
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.luq);
        while (this.bFi) {
            this.luo.Tf("_total");
            c cVar = null;
            try {
                cVar = (c) this.lum.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (cVar != null) {
                if (cVar.dDR) {
                    break;
                }
                z = a(cVar);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.luq);
                } catch (InterruptedException e2) {
                }
            }
        }
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    }

    public final void tl(int i) {
        this.lup = i;
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize " + i);
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            if (cVar != null) {
                if (cVar.luv == null) {
                    cVar.luv = new int[57600];
                }
                cVar.luv[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    cVar.luv[0] = 1;
                }
                f t = o.bgM().lta.t(cVar.luv);
                if (this.ltC == null || t.ret <= 0 || bi.oW(t.vgr)) {
                    if (t.ret == 0) {
                        this.lur++;
                    }
                    this.luo.Tf("_fail");
                    x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", new Object[]{Integer.valueOf(t.ret)});
                    if ((this.lur + this.lus) % 100 == 0) {
                        x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", new Object[]{Float.valueOf(((float) this.lur) / ((float) (this.lur + this.lus))), Float.valueOf(((float) this.lus) / ((float) (this.lur + this.lus)))});
                    }
                    try {
                        this.lum.put(cVar);
                    } catch (InterruptedException e) {
                    }
                    z = false;
                } else {
                    int Hx = this.ltC.Hx(t.vgr);
                    cVar.username = t.vgr;
                    cVar.lux = t.vgv;
                    cVar.luy = t.vgw;
                    cVar.luw = t.vgu;
                    x.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", new Object[]{cVar.username, Integer.valueOf(Hx)});
                    if (Hx >= 0 && this.lun[Hx % 2] != null) {
                        this.lun[Hx % 2].post(new b(this, cVar));
                    }
                    this.luo.Tf("_success");
                    this.lus++;
                    if ((this.lur + this.lus) % 100 == 0) {
                        x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", new Object[]{Integer.valueOf(this.lur / (this.lur + this.lus)), Integer.valueOf(this.lus / (this.lur + this.lus))});
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }
}
