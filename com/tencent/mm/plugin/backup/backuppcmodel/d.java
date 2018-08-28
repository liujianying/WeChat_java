package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.xwalk.core.XWalkResourceClient;

public final class d implements com.tencent.mm.plugin.backup.a.b.d {
    private static boolean gTT = false;
    private static boolean gWH = false;
    private boolean dJO = false;
    private com.tencent.mm.plugin.backup.b.d gTJ;
    private long gTK = 0;
    LinkedList<String> gTL;
    LinkedList<Long> gTM;
    private HashSet<String> gTQ = new HashSet();
    private long gTR = 0;
    private long gTS = 0;
    private boolean gTb = false;
    public Set<c> gWI = new HashSet();
    public a gWJ;
    private long gWK = 0;
    private boolean gWL = false;
    private final com.tencent.mm.plugin.backup.f.b.d gWM = new 1(this);
    private Object lock = new Object();
    private long recvSize = 0;

    static /* synthetic */ void I(byte[] bArr, int i) {
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            return;
        }
        ag agVar = new ag();
        agVar.hda = afVar.hda;
        agVar.hdc = afVar.hdc;
        agVar.hdb = afVar.hdb;
        agVar.hbD = afVar.hbD;
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "PacketSvrIDResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", new Object[]{Integer.valueOf(b.arV().aqP().gRC), Boolean.valueOf(gWH)});
        switch (b.arV().aqP().gRC) {
            case -21:
            case XWalkResourceClient.ERROR_FILE /*-13*/:
            case XWalkResourceClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                b.arV().arw().stop();
                return;
            case XWalkResourceClient.ERROR_AUTHENTICATION /*-4*/:
                dVar.a(true, false, 0);
                return;
            case 1:
            case 21:
                b.arV().arw().stop();
                b.arV().aqP().gRC = -100;
                dVar.mw(-100);
                return;
            case 4:
            case 22:
            case 23:
                if (!b.arV().arW().gWA || gWH) {
                    x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    dVar.a(true, false, -4);
                    b.arV().arw().stop();
                    h.mEJ.a(400, 17, 1, false);
                    dVar.mG(3);
                    return;
                }
                switch (b.asr()) {
                    case 0:
                    case 2:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", new Object[]{Integer.valueOf(b.asr())});
                        dVar.mG(19);
                        dVar.gWL = true;
                        b.a(b.arV().arW().gWF);
                        return;
                    case 1:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", new Object[]{Integer.valueOf(b.asr())});
                        return;
                    default:
                        return;
                }
            case 27:
                b.arV().arw().stop();
                b.arV().aqP().gRC = -100;
                dVar.mw(-100);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(d dVar, byte[] bArr) {
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", new Object[]{Boolean.valueOf(gTT)});
        if (gTT) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            return;
        }
        gTT = true;
        if (g.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", new Object[]{Integer.valueOf(bi.bD(bArr))});
        }
        au.HU();
        com.tencent.mm.model.c.DT().a(aa.a.sUZ, Boolean.valueOf(false));
        b.asm();
        b.aso();
        gWH = true;
        b.arV().aqP().D(24, dVar.gTQ.size(), dVar.gTL.size());
        dVar.mw(24);
        h.mEJ.a(400, 19, 1, false);
        dVar.gWK = bi.VF();
        h.mEJ.a(400, 20, (dVar.gWK - dVar.gTR) / 1000, false);
        h.mEJ.a(400, 21, dVar.gTK / 1024, false);
        dVar.mG(0);
        if (!dVar.gWL) {
            dVar.mG(21);
        }
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", new Object[]{Boolean.valueOf(dVar.gWL), Long.valueOf(r10 / 1000), Long.valueOf(dVar.gTR), Long.valueOf(dVar.gWK), Long.valueOf(dVar.gTK / 1024)});
    }

    static /* synthetic */ void b(d dVar, byte[] bArr, int i) {
        i iVar = (i) g.a(new i(), bArr);
        if (iVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            b.arV().aqP().gRC = -21;
            dVar.mw(-21);
            return;
        }
        dVar.gTL = iVar.hbH;
        dVar.gTM = iVar.hbI;
        if (dVar.gTM.size() != dVar.gTL.size() * 2) {
            dVar.a(false, false, -21);
            h.mEJ.a(400, 119, 1, false);
            return;
        }
        b.arV().aqP().D(23, 1, dVar.gTL.size());
        dVar.mw(23);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        au.HU().Gz().a(dVar.gTL, dVar.gTM, linkedList, linkedList2);
        j jVar = new j();
        jVar.hbH = linkedList;
        jVar.hbI = linkedList2;
        b.asn();
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(dVar.gTL.size()), Integer.valueOf(linkedList2.size())});
            b.o(jVar.toByteArray(), 12, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void c(d dVar, byte[] bArr, int i) {
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "dataPushNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive recoverData id:%s, type:%d, start:%d, end:%d, isCancel:%b", new Object[]{xVar.hcI, Integer.valueOf(xVar.hcJ), Integer.valueOf(xVar.hcL), Integer.valueOf(xVar.hcM), Boolean.valueOf(dVar.dJO)});
        if (!dVar.dJO) {
            if (!(b.arV().gRA == null || xVar.hbs == null)) {
                xVar.hbs = new com.tencent.mm.bk.b(AesEcb.aesCryptEcb(xVar.hbs.lR, b.arV().gRA, false, xVar.hcM == xVar.hcK));
            }
            if (xVar.hcJ == 1 && xVar.hbs != null) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush text dataid:%s, dir:%s", new Object[]{xVar.hcI, g.wt(xVar.hcI)});
                g.b(r2, xVar);
                dVar.recvSize += (long) xVar.hbs.lR.length;
            }
            if (xVar.hcJ == 2) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush media dataid:%s, dir:%s", new Object[]{xVar.hcI, g.wu(xVar.hcI)});
                g.a(r2, xVar);
                dVar.recvSize += (long) xVar.hbs.lR.length;
            }
            x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(dVar.recvSize), Long.valueOf(dVar.gTK)});
            if (dVar.gTK < dVar.recvSize) {
                dVar.gTK = dVar.recvSize;
            }
            b(xVar.hcI, xVar.hcJ, xVar.hcL, xVar.hcM, 0, i);
        }
    }

    public static void ase() {
        gWH = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcRecoverServer", "init");
        this.gWL = false;
        gWH = false;
        gTT = false;
        b.a(this.gWM);
        this.gTK = 0;
        this.recvSize = 0;
        this.dJO = false;
        this.gTb = false;
        this.gTQ.clear();
    }

    public static boolean arA() {
        return au.HU().GA().ckv();
    }

    public final void arB() {
        x.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.gTQ.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aj.cin()});
        gWH = true;
        if (!z) {
            b.arV().arW();
            c.arE();
        }
        synchronized (this.lock) {
            this.dJO = true;
            if (this.gTJ != null) {
                this.gTJ.g(z2, i);
                this.gTJ = null;
            } else {
                i2 = 1;
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.arV().aqP().gRC = i;
            mw(i);
        }
        if (z2) {
            arB();
        }
        b.asm();
        b.aso();
        b.asq();
    }

    public final void mG(int i) {
        long j = 0;
        if (this.gTR != 0) {
            j = bi.bH(this.gTR);
        }
        h.mEJ.h(13737, new Object[]{Integer.valueOf(i), Long.valueOf(this.gTK / 1024), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(b.arV().arW().gWC)});
        x.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.gTK / 1024), Long.valueOf(j / 1000)});
    }

    private static void b(String str, int i, int i2, int i3, int i4, int i5) {
        y yVar = new y();
        yVar.hcI = str;
        yVar.hcJ = i;
        yVar.hcL = i2;
        yVar.hcM = i3;
        yVar.hcd = i4;
        try {
            b.o(yVar.toByteArray(), 7, i5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    private static void d(int i, int i2, long j) {
        o oVar = new o();
        oVar.ID = b.arV().gRu;
        oVar.hcd = i;
        oVar.hbY = g.bU(j);
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[]{Integer.valueOf(i)});
            b.o(oVar.toByteArray(), 4, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
        }
    }

    public final void arg() {
        synchronized (this.lock) {
            if (this.dJO) {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge isCancel true.");
            } else if (this.gTJ == null || !this.gTJ.gSS) {
                int ckw;
                if (this.gTJ != null) {
                    this.gTJ.g(false, 0);
                }
                if (this.gTQ == null || this.gTQ.size() <= 0) {
                    ckw = au.HU().GA().ckw();
                } else {
                    ckw = this.gTQ.size();
                }
                b.arV().aqP().D(26, 1, ckw);
                mw(26);
                if (this.gTL == null) {
                    this.gTL = new LinkedList();
                }
                if (this.gTM == null) {
                    this.gTM = new LinkedList();
                }
                this.gTS = bi.VF();
                this.gTJ = new com.tencent.mm.plugin.backup.b.d(b.arV(), 1, this, ckw, this.gTb, this.gTL, this.gTM);
                this.gTJ.arg();
                h.mEJ.a(400, 24, 1, false);
            } else {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public final void mw(int i) {
        Set hashSet = new HashSet();
        hashSet.addAll(this.gWI);
        ah.A(new 3(this, hashSet, i));
        if (this.gWJ != null) {
            ah.A(new 4(this, i));
        }
    }

    public final void aqO() {
        arB();
        h.mEJ.a(400, 27, 1, false);
        h.mEJ.a(400, 28, bi.bH(this.gTS) / 1000, false);
        b.asm();
        b.aso();
    }
}
