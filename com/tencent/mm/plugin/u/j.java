package com.tencent.mm.plugin.u;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    long aeq;
    public long aqC;
    boolean hEj;
    ag ldC;
    ag ldD;
    ag ldE;
    long ldF;
    boolean ldG = false;
    public k ldH;
    boolean ldI = false;
    a ldJ;
    private a ldK = new 1(this);
    private a ldL = new a() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!j.this.ldH.bdz()) {
                        j.this.ldh.obtainMessage(5, -1, -1).sendToTarget();
                        break;
                    }
                    j.this.aqC = j.this.ldH.aqC;
                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                    break;
                case 2:
                    g gVar = j.this.ldg;
                    long bI = bi.bI(gVar.lcY);
                    if (gVar.lcY > 0 && bI >= 30) {
                        x.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[]{gVar.avA(), Long.valueOf(gVar.lcY), Long.valueOf(bI)});
                        gVar.lcZ = 0;
                    }
                    if (!d.sB(j.this.ldH.state)) {
                        boolean z;
                        int v = j.this.ldH.v(j.this.aeq, j.this.ldF);
                        if (d.sy(v)) {
                            j.this.ldE.obtainMessage(2).sendToTarget();
                        }
                        if (v == 7) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (!d.sD(v)) {
                                if (j.this.state == 3) {
                                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), j.this.ldg.lcZ);
                                } else if (j.this.state == 5) {
                                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 1) {
                                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 0) {
                                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 6) {
                                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                                } else {
                                    j.this.ldC.removeMessages(2);
                                }
                                j.this.ldg.lcY = bi.VG();
                                break;
                            }
                            j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                            j.this.ldg.lcY = bi.VG();
                            break;
                        }
                        j.this.ldE.obtainMessage(7).sendToTarget();
                        j.this.ldC.removeMessages(2);
                        break;
                    }
                    j.this.ldE.obtainMessage(9).sendToTarget();
                    j.this.ldC.removeMessages(2);
                    break;
                case 3:
                    j.this.sH(3);
                    j.this.ldH.start();
                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                    break;
                case 4:
                    j.this.sH(4);
                    j.this.a(j.this.ldC, SystemClock.elapsedRealtime(), 0);
                    j.this.ldH.pause();
                    break;
                case 7:
                    j.this.ldH.release();
                    j.this.ldG = true;
                    j.this.ldE.obtainMessage(0).sendToTarget();
                    break;
            }
            return false;
        }
    };
    private a ldM = new a() {
        public final boolean handleMessage(Message message) {
            if (j.this.ldJ != null) {
                switch (message.what) {
                    case 1:
                        if (!j.this.ldJ.bdz()) {
                            j.this.ldJ = null;
                        }
                        j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!d.sB(j.this.ldJ.state)) {
                            if (d.sy(j.this.ldJ.v(j.this.aeq, j.this.ldF))) {
                                j.this.ldE.sendMessageDelayed(j.this.ldE.obtainMessage(2), 10);
                            }
                            if (j.this.state != 3) {
                                if (j.this.state != 5) {
                                    if (j.this.state != 1) {
                                        if (j.this.state != 0) {
                                            j.this.ldD.removeMessages(2);
                                            break;
                                        }
                                        j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), j.this.ldg.lcZ);
                            break;
                        }
                        j.this.ldE.obtainMessage(9).sendToTarget();
                        j.this.ldD.removeMessages(2);
                        break;
                    case 3:
                        j.this.ldJ.start();
                        j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        j.this.a(j.this.ldD, SystemClock.elapsedRealtime(), 0);
                        j.this.ldJ.pause();
                        break;
                    case 7:
                        j.this.ldJ.release();
                        j.this.ldI = true;
                        j.this.ldE.obtainMessage(0).sendToTarget();
                        break;
                }
            }
            return false;
        }
    };
    public g ldg;
    ag ldh;
    int state;

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[]{jVar.ldg.avA()});
        jVar.ldH.setState(5);
        if (jVar.ldJ != null) {
            jVar.ldg.lcX = jVar.ldJ.sF((int) jVar.ldg.lcV);
            jVar.ldJ.setState(5);
        }
        jVar.sH(7);
        jVar.setState(4);
        jVar.ldh.obtainMessage(3, 0, 0).sendToTarget();
        jVar.ldg.lcW = jVar.ldg.lcV * 1000;
        jVar.ldg.lcV = -1;
    }

    public j(ag agVar, Looper looper, Looper looper2, Looper looper3) {
        this.ldh = agVar;
        this.hEj = false;
        this.ldg = new g(this.hEj);
        this.ldE = new ag(looper, this.ldK);
        this.ldH = new k(this.ldg, this.ldh);
        this.ldC = new ag(looper2, this.ldL);
        if (looper3 != null) {
            this.ldJ = new a(this.ldg, this.ldh);
            this.ldD = new ag(looper3, this.ldM);
        }
    }

    public final void bdB() {
        x.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[]{this.ldg.avA(), Long.valueOf(this.ldg.lcW)});
        if (this.ldH != null) {
            this.ldH.w(this.ldg.lcW, -1);
            this.ldH.bdx();
            this.ldH.ldk = 0;
        }
    }

    public final void bdC() {
        if (this.ldH != null) {
            x.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[]{this.ldg.avA()});
            this.ldH.setState(10);
            a(this.ldC, SystemClock.elapsedRealtime(), 0);
        }
    }

    public final void start() {
        setState(3);
        this.ldC.obtainMessage(3).sendToTarget();
        if (this.ldJ != null) {
            this.ldD.obtainMessage(3).sendToTarget();
        }
    }

    public final void pause() {
        setState(4);
        this.ldC.obtainMessage(4).sendToTarget();
        if (this.ldJ != null) {
            this.ldD.obtainMessage(4).sendToTarget();
        }
    }

    public final void sG(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[]{this.ldg.avA(), Integer.valueOf(i), Boolean.valueOf(true)});
        this.ldH.pause();
        if (this.ldJ != null) {
            this.ldJ.pause();
        }
        if (((long) i) >= this.aqC) {
            x.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[]{Integer.valueOf(i), Long.valueOf(this.aqC)});
            setState(6);
            this.ldE.obtainMessage(9).sendToTarget();
            return;
        }
        long sF = this.ldH.sF(i);
        boolean z = sF >= 0 && sF < ((long) i);
        x.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[]{this.ldg.avA(), Boolean.valueOf(z), Long.valueOf(sF), Integer.valueOf(i)});
        this.ldH.setState(6);
        setState(6);
        if (z) {
            this.ldg.lcV = (long) i;
        } else {
            this.ldg.lcV = sF;
        }
        sH(6);
        a(this.ldC, SystemClock.elapsedRealtime(), 0);
    }

    public final void stop() {
        setState(8);
    }

    public final void release() {
        setState(9);
        this.ldE.removeMessages(2);
        this.ldE.removeMessages(9);
        this.ldC.removeMessages(1);
        this.ldC.removeMessages(2);
        this.ldC.removeMessages(3);
        this.ldC.removeMessages(4);
        this.ldC.removeMessages(6);
        this.ldC.removeCallbacksAndMessages(null);
        try {
            this.ldH.setState(9);
            x.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[]{r0.avA(), Boolean.valueOf(this.ldH.ldO)});
            if (this.ldH.ldO && d.fT(19)) {
                this.ldH.ll();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "release error %s", new Object[]{e.toString()});
        }
        this.ldC.obtainMessage(7).sendToTarget();
        if (this.ldD != null) {
            this.ldD.removeMessages(1);
            this.ldD.removeMessages(2);
            this.ldD.removeMessages(3);
            this.ldD.removeMessages(4);
            this.ldD.removeMessages(6);
            this.ldD.obtainMessage(7).sendToTarget();
        }
        g gVar = this.ldg;
        gVar.lcT = 0;
        gVar.lcU = 0;
        gVar.lcV = -1;
        gVar.aeq = 0;
        gVar.lcW = 0;
        gVar.lcX = 0;
    }

    protected final void setState(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", new Object[]{this.ldg.avA(), Integer.valueOf(this.state), Integer.valueOf(i), bi.cjd()});
        this.state = i;
        this.ldg.lcY = 0;
    }

    final void sH(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[]{this.ldg.avA(), Integer.valueOf(i), Long.valueOf(this.ldg.lcT), Long.valueOf(this.ldg.lcU), Long.valueOf(this.ldg.aeq)});
        g gVar;
        switch (i) {
            case 3:
                if (this.ldg.lcU > 0) {
                    gVar = this.ldg;
                    gVar.aeq += this.ldg.lcU - this.ldg.lcT;
                    this.ldg.lcU = 0;
                }
                this.ldg.lcT = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.ldg.lcT > 0) {
                    this.ldg.lcU = SystemClock.elapsedRealtime();
                    break;
                }
                this.ldg.lcU = 0;
                break;
            case 5:
                this.ldg.aeq = this.ldg.lcV;
                this.ldg.lcT = SystemClock.elapsedRealtime();
                this.ldg.lcU = 0;
                gVar = this.ldg;
                this.ldg.lcX = 0;
                gVar.lcW = 0;
                break;
            case 6:
                this.ldg.aeq = this.ldg.lcV;
                gVar = this.ldg;
                this.ldg.lcU = 0;
                gVar.lcT = 0;
                gVar = this.ldg;
                this.ldg.lcX = 0;
                gVar.lcW = 0;
                break;
            case 7:
                this.ldg.aeq = this.ldg.lcV;
                gVar = this.ldg;
                this.ldg.lcU = 0;
                gVar.lcT = 0;
                break;
        }
        this.ldF = this.ldg.lcT;
        this.aeq = this.ldg.aeq;
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[]{this.ldg.avA(), Integer.valueOf(i), Long.valueOf(this.ldF), Long.valueOf(this.aeq)});
    }

    private void a(ag agVar, long j, long j2) {
        if (!d.sB(this.state)) {
            try {
                Thread thread = agVar.getLooper().getThread();
                if (!(thread == null || thread.isAlive())) {
                    return;
                }
            } catch (Exception e) {
            }
            agVar.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                agVar.sendEmptyMessage(2);
            } else {
                agVar.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }
}
