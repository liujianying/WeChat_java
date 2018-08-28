package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.k;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;

public final class g implements a, b.a {
    public boolean bXc = false;
    com.tencent.mm.plugin.ipcall.a.f.a koA = new com.tencent.mm.plugin.ipcall.a.f.a();
    h koB = new h();
    c koC = new c();
    public e koD = new e();
    com.tencent.mm.plugin.ipcall.a.f.g koE = new com.tencent.mm.plugin.ipcall.a.f.g();
    f koF = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c koG;
    public boolean koH = false;
    public boolean koI = false;
    n koJ = new 1(this);
    public int kos = 0;
    public int kot = 0;
    public int kou = 0;
    public boolean kov = false;
    public boolean kow = false;
    public a kox;
    public d koy = new d();
    i koz = new i();

    public final void aXn() {
        if (this.koG.kpT) {
            x.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.kov = true;
        x.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(this.koG.kpr)});
        this.koC.stop();
        this.koz.stop();
        this.koA.a(this.koG);
        this.koE.a(this.koG);
    }

    public final void rw(int i) {
        if (!this.koG.kpT) {
            x.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        x.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(this.koG.kpr)});
        this.kow = true;
        this.koC.stop();
        this.koz.stop();
        this.koB.kss = false;
        this.koB.ksr = i;
        this.koB.a(this.koG);
        this.koE.a(this.koG);
    }

    private void fO(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.kov), Boolean.valueOf(this.kow)});
        if (this.kov || this.kow) {
            x.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
        } else if (z) {
            if (this.kox != null) {
                if (this.koG.kpD) {
                    this.kox.aWH();
                } else {
                    this.kox.aWM();
                }
            }
            x.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.koz.a(this.koG);
        } else if (this.kox == null) {
        } else {
            if (this.koG.kpA) {
                this.kox.z(this.koG.kpv, this.koG.iwT, this.koG.kpu);
            } else if (this.koG.kpB) {
                this.kox.A(this.koG.kpv, this.koG.iwT, this.koG.kpu);
            } else if (this.koG.kpC) {
                this.kox.B(this.koG.kpv, this.koG.iwT, this.koG.kpu);
            } else if (this.koG.kpD) {
                this.kox.y(this.koG.kpv, this.koG.iwT, this.koG.kpu);
            } else {
                this.kox.aWM();
            }
        }
    }

    private void fP(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.kos = 0;
            return;
        }
        this.kos++;
        if (this.kos >= 2) {
            x.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
            this.koC.stop();
            if (i.aXt().aXm() && this.kox != null) {
                this.kox.aWL();
            }
        }
    }

    private void k(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[]{Boolean.valueOf(z)});
        if (!z && i < 0 && this.kou <= 0) {
            this.kou++;
            x.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[]{Integer.valueOf(this.kou)});
            this.koA.a(this.koG);
        }
    }

    private void l(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.koB.kss)});
        if (!z && i < 0 && this.kot <= 0) {
            this.kot++;
            x.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[]{Integer.valueOf(this.kot), Boolean.valueOf(this.koB.kss)});
            this.koB.a(this.koG);
        }
    }

    private void fQ(boolean z) {
        int i = 1;
        x.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aXq().kqA) {
            i.aXq().ry(this.koG.kpJ);
        }
        if (!z) {
            x.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.koz.stop();
            if (i.aXt().mCurrentState != 3) {
                i = 0;
            }
            if (i != 0 && this.kox != null) {
                this.kox.bw(this.koG.iwT, this.koG.kpu);
            }
        } else if (this.koG != null && z) {
            rx(this.koG.aXH());
        }
    }

    private void fR(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[]{Boolean.valueOf(z)});
        if (z && i.aXq().kqA) {
            i.aXq().ry(this.koG.kpJ);
        }
        if (this.koG != null && z) {
            int aXH = this.koG.aXH();
            if (aXH == 2 || aXH == 1) {
                if (this.koI) {
                    x.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    return;
                } else {
                    au.DF().a(new o(this.koG.kpo, this.koG.kpp, this.koG.aXG(), this.koG.kpq, false), 0);
                }
            }
            rx(this.koG.aXH());
        }
    }

    public final boolean rx(int i) {
        switch (i) {
            case 1:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (this.koH) {
                    return true;
                }
                this.koH = true;
                if (this.kox == null) {
                    return true;
                }
                this.kox.aWI();
                return true;
            case 2:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[]{Boolean.valueOf(this.kov), Boolean.valueOf(this.kow)});
                if (this.kov || this.kow) {
                    return true;
                }
                this.koz.stop();
                if (this.bXc) {
                    return true;
                }
                this.bXc = true;
                if (this.koG != null) {
                    this.koG.kpT = true;
                }
                if (this.kox != null) {
                    this.kox.aWJ();
                }
                this.koC.a(this.koG);
                return true;
            case 3:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.koz.stop();
                this.koC.stop();
                if (this.kox == null) {
                    return true;
                }
                this.kox.bv(this.koG.iwT, this.koG.kpu);
                return true;
            case 4:
            case 7:
            case 8:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.koG.kpC) {
                    if (this.kox == null) {
                        return true;
                    }
                    this.kox.B(this.koG.kpv, this.koG.iwT, this.koG.kpu);
                    return true;
                } else if (this.kox == null) {
                    return true;
                } else {
                    this.kox.bu(this.koG.iwT, this.koG.kpu);
                    return true;
                }
            case 5:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.kox == null) {
                    return true;
                }
                this.kox.aWK();
                return true;
            case 6:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.koG.kpA = true;
                if (this.kox == null) {
                    return true;
                }
                this.kox.z(this.koG.kpv, this.koG.iwT, this.koG.kpu);
                return true;
            default:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[]{Integer.valueOf(i)});
                return false;
        }
    }

    private void fS(boolean z) {
        byy byy = null;
        x.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            byy byy2;
            com.tencent.mm.plugin.ipcall.a.c.a aXq = i.aXq();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.koG;
            x.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.gUH == null || cVar.gUH.size() <= 0) {
                byy2 = null;
            } else {
                byy2 = com.tencent.mm.plugin.ipcall.b.c.V(cVar.gUH);
            }
            if (!(cVar == null || cVar.kpM == null || cVar.kpM.size() <= 0)) {
                byy = com.tencent.mm.plugin.ipcall.b.c.V(cVar.kpM);
            }
            aXq.kqx.a(byy2, byy2, byy, 0, 0);
        }
    }

    public final void a(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fO(true);
                return;
            case 3:
                k(true, i3);
                return;
            case 4:
                l(true, i3);
                return;
            case 6:
                fS(true);
                return;
            case 8:
                fR(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fO(false);
                return;
            case 3:
                k(false, i3);
                return;
            case 4:
                l(false, i3);
                return;
            case 6:
                fS(false);
                return;
            case 8:
                fR(false);
                return;
            default:
                return;
        }
    }

    public final void a(int i, l lVar, int i2, int i3) {
        if (c(i, lVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fQ(true);
                return;
            case 5:
                fP(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, l lVar, int i2, int i3) {
        if (c(i, lVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fQ(false);
                return;
            case 5:
                fP(false);
                return;
            default:
                return;
        }
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        if (this.koG == null || obj == null) {
            x.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            return true;
        }
        Object obj2;
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.i) {
                    com.tencent.mm.plugin.ipcall.a.d.i iVar = (com.tencent.mm.plugin.ipcall.a.d.i) obj;
                    bcc bcc = iVar.krx;
                    if (this.koG.kpr == iVar.krw.sef) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[]{Integer.valueOf(this.koG.kpr)});
                        com.tencent.mm.plugin.ipcall.a.c.b aXr = i.aXr();
                        if (aXr.kpr == this.koG.kpr) {
                            x.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[]{Integer.valueOf(i3)});
                            aXr.kqP = i3;
                        }
                        if (i2 == 0 && i3 == 0) {
                            if (this.koG != null) {
                                this.koG.kpo = bcc.rxG;
                                this.koG.kpp = bcc.rxH;
                                this.koG.kpq = bcc.seh;
                                this.koG.kpw = bcc.seq;
                                this.koG.kpy = bcc.ser * TbsLog.TBSLOG_CODE_SDK_BASE;
                                this.koG.kpF = bcc.kpF;
                                this.koG.kpG = bcc.kpG;
                                this.koG.gUH = bcc.rfi;
                                this.koG.kpM = bcc.ses;
                                this.koG.kpR = bcc.set;
                                if (bcc.kpN > 0) {
                                    this.koG.kpN = bcc.kpN;
                                }
                                this.koG.kpH = bcc.kpH;
                                this.koG.kpI = bcc.kpI;
                                this.koG.kpE = bcc.sev;
                                if (bcc.kpK > 0) {
                                    this.koG.kpK = bcc.kpK - 1;
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.koG.kpK + "] from Invite resp");
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.koG.kpK = 2;
                                }
                                this.koG.kpL = bcc.seu;
                                x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[]{Integer.valueOf(bcc.kpz)});
                                if (bcc.kpz > 0) {
                                    this.koG.kpD = false;
                                    this.koG.kpz = bcc.kpz;
                                } else {
                                    this.koG.kpD = true;
                                    this.koG.kpz = 0;
                                }
                                this.koG.kpv = bcc.kpv;
                                this.koG.kpu = bcc.kpu;
                                this.koG.iwS = i3;
                                this.koG.iwT = bi.oV(ab.a(bcc.six.rgv));
                                break;
                            }
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (bcc.six == null) {
                            this.koG.kpv = "";
                            this.koG.kpu = 2;
                            this.koG.iwT = ad.getContext().getString(R.l.callout_failed_network);
                            this.koG.iwS = i3;
                            break;
                        }
                        if (i3 == 433) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.koG.kpA = true;
                        } else if (i3 == at.CTRL_INDEX) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.koG.kpB = true;
                        } else if (i3 == 435) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.koG.kpC = true;
                        }
                        if (bcc.kpz > 0) {
                            this.koG.kpD = false;
                            this.koG.kpz = bcc.kpz;
                        } else {
                            this.koG.kpD = true;
                            this.koG.kpz = 0;
                        }
                        this.koG.kpv = bcc.kpv;
                        this.koG.kpu = bcc.kpu;
                        this.koG.iwS = i3;
                        if (bcc.six != null) {
                            this.koG.iwT = bi.oV(ab.a(bcc.six.rgv));
                            x.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[]{Integer.valueOf(bcc.kpu), Integer.valueOf(i3), this.koG.iwT});
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.koG.kpr), Integer.valueOf(iVar.krw.sef)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                return true;
                break;
            case 2:
                if (obj instanceof o) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    o oVar = (o) obj;
                    bcl bcl = oVar.krJ;
                    if (this.koG.kpo == oVar.krI.rxG) {
                        if (i2 == 0 && i3 == 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[]{Integer.valueOf(bcl.rxG), Integer.valueOf(bcl.seF), Integer.valueOf(bcl.seG), Integer.valueOf(bcl.seD)});
                            if (bcl.rxG == this.koG.kpo && bcl.rxH == this.koG.kpp) {
                                if (bcl.seG == this.koG.kpw) {
                                    x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (bcl.seD > this.koG.kpx) {
                                        this.koG.kpx = bcl.seD;
                                        if (bcl.seF != 0) {
                                            this.koG.fOu = bcl.seF;
                                        }
                                    }
                                } else {
                                    x.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    obj2 = null;
                                    it = this.koG.kpO.iterator();
                                    while (true) {
                                        Object obj3 = obj2;
                                        if (it.hasNext()) {
                                            dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                            if (dVar.kpU == bcl.seG) {
                                                if (bcl.seD > dVar.kpx) {
                                                    dVar.kpx = bcl.seD;
                                                    if (bcl.seF != 0) {
                                                        dVar.dpx = bcl.seF;
                                                    }
                                                }
                                                obj2 = 1;
                                            } else {
                                                obj2 = obj3;
                                            }
                                        } else if (obj3 == null) {
                                            dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                            dVar.kpU = bcl.seG;
                                            dVar.dpx = bcl.seF;
                                            dVar.kpx = bcl.seD;
                                            this.koG.kpO.add(dVar);
                                        }
                                    }
                                }
                                if (bcl.iwS == TbsListener$ErrorCode.INFO_DISABLE_X5 || bcl.iwS == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.koG.kpC = true;
                                }
                                this.koG.iwT = bcl.iwT;
                                this.koG.iwS = bcl.iwS;
                                this.koG.kpu = bcl.kpu;
                                this.koG.kpv = bcl.kpv;
                                this.koG.kpJ = bcl.kpJ;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(oVar.krI.rxG)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.koG.kpr != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).krf.sef) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[]{Integer.valueOf(this.koG.kpr), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).krf.sef)});
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.n) {
                    if (this.koG.kpo == ((com.tencent.mm.plugin.ipcall.a.d.n) obj).krG.rxG) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.koG.fOu = 5;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.n) obj).krG.rxG)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (this.koG.kpo != ((com.tencent.mm.plugin.ipcall.a.d.h) obj).kru.rxG) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.h) obj).kru.rxG)});
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                return true;
                break;
            case 6:
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    bcf bcf = kVar.krB;
                    if (this.koG.kpo == kVar.krA.rxG) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.koG.gUH = bcf.rfi;
                        this.koG.kpM = bcf.ses;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(kVar.krA.rxG)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                return true;
                break;
            case 8:
                if (obj instanceof bcd) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    bcd bcd = (bcd) obj;
                    if (this.koG.kpo == bcd.rxG) {
                        if (i2 == 0 && i3 == 0) {
                            this.koG.kpJ = bcd.kpJ;
                            x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[]{Integer.valueOf(bcd.sew.size())});
                            it = bcd.sew.iterator();
                            while (it.hasNext()) {
                                bcm bcm = (bcm) it.next();
                                if (this.koG.kpw == bcm.seG) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(this.koG.kpw), Integer.valueOf(bcm.sdf), Integer.valueOf(bcm.seH)});
                                    if (bcm.seH > this.koG.kpx) {
                                        this.koG.kpx = bcm.seH;
                                        if (bcm.sdf != 0) {
                                            this.koG.fOu = bcm.sdf;
                                        }
                                    }
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[]{Integer.valueOf(bcm.seG), Integer.valueOf(bcm.sdf), Integer.valueOf(bcm.seH)});
                                    Object obj4 = null;
                                    Iterator it2 = this.koG.kpO.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.kpU == bcm.seG) {
                                            if (bcm.seH > dVar.kpx) {
                                                dVar.kpx = bcm.seH;
                                                if (bcm.sdf != 0) {
                                                    dVar.dpx = bcm.sdf;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.kpU = bcm.seG;
                                        dVar.dpx = bcm.sdf;
                                        dVar.kpx = bcm.seH;
                                        this.koG.kpO.add(dVar);
                                    }
                                }
                                if (bcm.iwS == TbsListener$ErrorCode.INFO_DISABLE_X5 || bcm.iwS == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.koG.kpC = true;
                                }
                                this.koG.iwT = bcm.iwT;
                                this.koG.iwS = bcm.iwS;
                                this.koG.kpu = bcm.kpu;
                                this.koG.kpv = bcm.kpv;
                            }
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[]{Integer.valueOf(this.koG.kpo), Integer.valueOf(bcd.rxG)});
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                return true;
                break;
        }
        return false;
    }
}
