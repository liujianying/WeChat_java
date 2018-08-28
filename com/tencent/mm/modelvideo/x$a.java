package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public class x$a implements e {
    private static int bFl = 0;
    Queue<String> bFd = new LinkedList();
    Queue<String> bFe = new LinkedList();
    Map<String, a> bFf = new HashMap();
    boolean bFg = false;
    private boolean bFh = false;
    private boolean bFi = false;
    int bFj = 0;
    private long bFk = 0;
    a bFn = new a();
    private al bFo = null;
    HandlerThread eor = com.tencent.mm.sdk.f.e.cZ("VideoService_runThread", 0);
    ag eos;
    boolean eot = false;
    public List<v> eou = new ArrayList();
    Queue<String> eov = new LinkedList();
    Queue<String> eow = new LinkedList();
    public d eox = null;
    g eoy = null;

    static /* synthetic */ int KF() {
        int i = bFl;
        bFl = i + 1;
        return i;
    }

    static /* synthetic */ int Ty() {
        int i = bFl;
        bFl = i - 1;
        return i;
    }

    static /* synthetic */ void a(x$a x_a) {
        String str;
        boolean z = true;
        x_a.bFk = System.currentTimeMillis();
        if ((!x_a.bFg && x_a.bFe.size() + x_a.eov.size() == 0) || (!x_a.bFh && x_a.bFd.size() == 0)) {
            long VG = bi.VG();
            List<String> Tw = o.Ta().Tw();
            List<String> Tt = o.Ta().Tt();
            List<String> Tu = o.Ta().Tu();
            List<String> Tv = o.Ta().Tv();
            if (Tw != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + Tw.size());
                for (String str2 : Tw) {
                    if (x_a.bFf.containsKey(str2)) {
                        x.d("MicroMsg.VideoService", "need sendList File is Already running:" + str2);
                    } else {
                        x_a.bFd.offer(str2);
                        x_a.bFf.put(str2, null);
                    }
                }
            }
            if (Tt != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + Tt.size());
                for (String str22 : Tt) {
                    if (x_a.bFf.containsKey(str22)) {
                        x.d("MicroMsg.VideoService", "need recvList File is Already running:" + str22);
                    } else {
                        x_a.bFe.offer(str22);
                        x_a.bFf.put(str22, null);
                    }
                }
            }
            if (Tu != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + Tu.size());
                for (String str222 : Tu) {
                    if (x_a.bFf.containsKey(str222)) {
                        x.d("MicroMsg.VideoService", "online videoList File is Already running:" + str222);
                    } else {
                        x_a.eov.offer(str222);
                        x_a.bFf.put(str222, null);
                    }
                }
            }
            if (Tv != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo hevc video list size: " + Tv.size());
                for (String str2222 : Tv) {
                    if (x_a.bFf.containsKey(str2222)) {
                        x.d("MicroMsg.VideoService", "hevc videoList File is Already running:" + str2222);
                    } else {
                        x_a.eow.offer(str2222);
                        x_a.bFf.put(str2222, null);
                    }
                }
            }
            x.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d hevc:%d]", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(x_a.bFf.size()), Integer.valueOf(x_a.bFe.size()), Integer.valueOf(x_a.eov.size()), Integer.valueOf(x_a.bFd.size()), Integer.valueOf(x_a.eow.size())});
            x_a.bFe.size();
            x_a.bFd.size();
            x_a.eov.size();
            x_a.eow.size();
        }
        int i = (x_a.eow.size() == 0 || !d.NX()) ? true : 0;
        if (x_a.bFg || x_a.bFe.size() + x_a.eov.size() != 0 || i == 0 || x_a.bFh || x_a.bFd.size() != 0) {
            if (!x_a.bFg && (x_a.bFe.size() > 0 || x_a.eov.size() > 0 || i == 0)) {
                if (x_a.eov.size() > 0) {
                    str2222 = (String) x_a.eov.poll();
                    x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                    if (!bi.oW(str2222)) {
                        x_a.bFf.put(str2222, new a());
                        x_a.bFg = true;
                        Assert.assertTrue("sceneDown should null", x_a.eox == null);
                        x_a.eox = new d(str2222, true);
                        g.DF().a(x_a.eox, 0);
                    }
                }
                if (!x_a.bFg && x_a.bFe.size() > 0) {
                    str2222 = (String) x_a.bFe.poll();
                    x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                    if (str2222 != null) {
                        x_a.bFf.put(str2222, new a());
                        x_a.bFg = true;
                        Assert.assertTrue("sceneDown should null", x_a.eox == null);
                        x_a.eox = new d(str2222);
                        g.DF().a(x_a.eox, 0);
                    }
                }
                if (!x_a.bFg) {
                    str2222 = (String) x_a.eow.poll();
                    x.i("MicroMsg.VideoService", "Start recv hecv: " + str2222);
                    if (!bi.oW(str2222)) {
                        x_a.bFf.put(str2222, new a());
                        x_a.bFg = true;
                        Assert.assertTrue("sceneDown should null", x_a.eox == null);
                        x_a.eox = new d(str2222, true);
                        g.DF().a(x_a.eox, 0);
                    }
                }
            }
            if (!x_a.bFh && x_a.bFd.size() > 0) {
                str2222 = (String) x_a.bFd.poll();
                x.i("MicroMsg.VideoService", "Start Send :" + str2222);
                if (str2222 != null) {
                    x_a.bFf.put(str2222, new a());
                    x_a.bFh = true;
                    String str3 = "sceneUp should null";
                    if (x_a.eoy != null) {
                        z = false;
                    }
                    Assert.assertTrue(str3, z);
                    if (x_a.eou != null && x_a.eou.size() > 0) {
                        for (v ob : x_a.eou) {
                            ob.ob(str2222);
                        }
                    }
                    x_a.eoy = new g(str2222);
                    g.DF().a(x_a.eoy, 0);
                    return;
                }
                return;
            }
            return;
        }
        x_a.k();
        x.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
    }

    public x$a() {
        g.DF().a(149, this);
        g.DF().a(150, this);
        this.eor.start();
        this.eot = true;
        this.eos = new ag(this.eor.getLooper());
        this.bFo = new al(this.eor.getLooper(), new 1(this), false);
        x.i("MicroMsg.VideoService", "create VideoService, start video send thread");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eor == null || !this.eot || this.eos == null) {
            x.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        } else {
            this.eos.post(new 2(this, lVar, i, i2));
        }
    }

    /* renamed from: wx */
    public final void k() {
        this.bFf.clear();
        this.bFd.clear();
        this.bFe.clear();
        this.eov.clear();
        this.eow.clear();
        this.bFh = false;
        this.bFg = false;
        this.bFi = false;
        x.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.bFn.Ad());
    }

    public final void run() {
        if (this.eor == null || !this.eot || this.eos == null) {
            x.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        } else {
            this.eos.post(new Runnable() {
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis() - x$a.this.bFk;
                    x.d("MicroMsg.VideoService", "Try Run service runningFlag:" + x$a.this.bFi + " timeWait:" + currentTimeMillis + " sending:" + x$a.this.bFh + " recving:" + x$a.this.bFg);
                    if (x$a.this.bFi) {
                        if (currentTimeMillis >= 60000) {
                            x.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + x$a.this.bFi + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + x$a.this.bFh + " recving:" + x$a.this.bFg);
                        } else {
                            return;
                        }
                    }
                    x$a.this.bFj = 3;
                    x$a.this.bFi = true;
                    x$a.this.bFh = false;
                    x$a.this.bFg = false;
                    x$a.this.eoy = null;
                    x$a.this.eox = null;
                    x$a.this.bFn.dgA = SystemClock.elapsedRealtime();
                    x$a.this.bFo.J(10, 10);
                }

                public final String toString() {
                    return super.toString() + "|run";
                }
            });
        }
    }

    public final boolean Tx() {
        boolean z;
        if (this.eox != null) {
            g.DF().c(this.eox);
            z = true;
            this.bFi = false;
        } else {
            z = false;
        }
        this.bFf.clear();
        this.bFd.clear();
        this.bFe.clear();
        this.eov.clear();
        this.eow.clear();
        return z;
    }
}
