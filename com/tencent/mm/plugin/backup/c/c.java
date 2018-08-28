package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements d, b.d {
    private static int dHg = 0;
    private static boolean gTT = false;
    private static boolean gTU = false;
    private static boolean gUi = false;
    String byN;
    private boolean dJO = false;
    public d gSW;
    private com.tencent.mm.plugin.backup.b.d gTJ;
    private long gTK = 0;
    private LinkedList<String> gTL;
    private LinkedList<Long> gTM;
    private LinkedList<String> gTN;
    private LinkedList<Long> gTO;
    public com.tencent.mm.plugin.backup.a.b.a gTP;
    private HashSet<String> gTQ = new HashSet();
    private long gTR = 0;
    private long gTS = 0;
    private boolean gTV = true;
    private HashSet<String> gTW = new HashSet();
    private int gTX = 0;
    public boolean gTY = false;
    private boolean gTZ = true;
    private boolean gTb = false;
    private boolean gUa = true;
    private boolean gUb = false;
    private boolean gUc = false;
    private int gUd;
    public String gUe;
    String gUf;
    int gUg;
    private al gUh;
    final e gUj = new 1(this);
    private final e gUk = new 6(this);
    private final e gUl = new 7(this);
    public long gUm;
    private int gUn;
    com.tencent.mm.plugin.backup.f.b.c gUo = new 11(this);
    private final com.tencent.mm.plugin.backup.f.f.a gUp = new 12(this);
    private final com.tencent.mm.plugin.backup.f.i.a gUq = new 2(this);
    private Object lock = new Object();
    private long recvSize = 0;

    private class a {
        byte[] buf;
        int egS;
        boolean gbk = false;
        int type;

        a(int i, int i2, byte[] bArr) {
            this.egS = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
        }
    }

    static /* synthetic */ void H(byte[] bArr, int i) {
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            return;
        }
        ag agVar = new ag();
        agVar.hda = afVar.hda;
        agVar.hdc = afVar.hdc;
        agVar.hdb = afVar.hdb;
        agVar.hbD = afVar.hbD;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void b(c cVar, byte[] bArr, int i) {
        if (cVar.gTV) {
            cVar.gTV = false;
        }
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", new Object[]{xVar.hcI, Integer.valueOf(xVar.hcJ), Integer.valueOf(xVar.hcL), Integer.valueOf(xVar.hcM)});
        if (xVar.hcJ == 1 && xVar.hbs != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", new Object[]{xVar.hcI, g.wt(xVar.hcI)});
            g.b(r2, xVar);
            cVar.recvSize += (long) xVar.hbs.lR.length;
        }
        if (xVar.hcJ == 2) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", new Object[]{xVar.hcI, g.wu(xVar.hcI)});
            g.a(r2, xVar);
            cVar.recvSize += (long) xVar.hbs.lR.length;
            cVar.gTW.add(xVar.hcI);
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(cVar.recvSize), Long.valueOf(cVar.gTK)});
        if (cVar.gTK < cVar.recvSize) {
            cVar.gTK = cVar.recvSize;
        }
        b(xVar.hcI, xVar.hcJ, xVar.hcL, xVar.hcM, 0, i);
    }

    static /* synthetic */ void c(c cVar, byte[] bArr, int i) {
        z zVar = (z) g.a(new z(), bArr);
        if (zVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive tag, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s", new Object[]{zVar.hcR, zVar.hbD, Long.valueOf(zVar.hcP), Long.valueOf(zVar.hcQ), zVar.hcS});
        cVar.gTQ.add(zVar.hbD);
        if (!cVar.dJO) {
            au.HU();
            com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sVc, Boolean.valueOf(true));
            b.arv().aqP().D(23, cVar.gTQ.size() < cVar.gTL.size() ? cVar.gTQ.size() : cVar.gTL.size(), cVar.gTL.size());
            cVar.mw(23);
        }
        if (au.HU().GA().XI(zVar.hcR) != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak the same tag has received, ignore. MsgDataID:%s", new Object[]{zVar.hcR});
        } else {
            Object obj;
            k kVar = new k();
            kVar.field_msgListDataId = zVar.hcR;
            kVar.field_sessionName = zVar.hbD;
            x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(au.HU().GA().b(kVar)), Long.valueOf(kVar.sKx)});
            n Gz = au.HU().Gz();
            String str = zVar.hbD;
            String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\"  AND startTime = " + zVar.hcP + " AND endTime = " + zVar.hcQ;
            x.d("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist:" + str2);
            Cursor rawQuery = Gz.diF.rawQuery(str2, null);
            if (rawQuery == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist failed, sessionName[%s], startTime[%d], endTime[%d] ", new Object[]{str, Long.valueOf(r4), Long.valueOf(r6)});
                obj = null;
            } else if (rawQuery.moveToNext()) {
                rawQuery.close();
                obj = 1;
            } else {
                rawQuery.close();
                obj = null;
            }
            if (obj == null) {
                m mVar = new m();
                mVar.field_sessionName = zVar.hbD;
                mVar.field_startTime = zVar.hcP;
                mVar.field_endTime = zVar.hcQ;
                x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(au.HU().Gz().b(mVar)), Long.valueOf(mVar.sKx)});
            }
        }
        aa aaVar = new aa();
        aaVar.hbD = zVar.hbD;
        aaVar.hcP = zVar.hcP;
        aaVar.hcQ = zVar.hcQ;
        aaVar.hcR = zVar.hcR;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "SendTagNotify send tag resp");
            b.o(aaVar.toByteArray(), 16, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to PacketBackupDataTagResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void h(c cVar) {
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        gTT = false;
        gTU = false;
        cVar.gTK = 0;
        cVar.recvSize = 0;
        cVar.dJO = false;
        cVar.gTQ.clear();
        cVar.gTV = true;
        cVar.gTW.clear();
    }

    public static boolean arA() {
        return au.HU().GA().ckv();
    }

    public final void arB() {
        x.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.gTQ.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), aj.cin()});
        if (!z) {
            arE();
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
            b.arv().aqP().gRC = i;
            mw(i);
        }
        if (z2) {
            arB();
        }
        b.asm();
        b.aso();
        b.arv().arw().gRS = null;
    }

    private void aS(String str, int i) {
        boolean z = true;
        b.arv().arw().connect(str, i);
        b.a(1, this.gUk);
        try {
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.gUa = z;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.arv().gRv, b.arv().gRw, com.tencent.mm.plugin.backup.a.d.aqT(), b.arv().gRu, com.tencent.mm.plugin.backup.a.c.gRm, 22);
        aVar.s(this.gUa, false);
        aVar.ass();
        x.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.gUh == null) {
            this.gUh = new al(new 5(this), false);
        }
        this.gUh.J(3000, 3000);
    }

    private void arC() {
        String str = this.gUe;
        String str2 = this.gUf;
        String cQ = g.cQ(ad.getContext());
        x.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[]{cQ, str, str2, Integer.valueOf(dHg)});
        if (cQ == null || cQ.equals("")) {
            h.mEJ.a(485, 1, 1, false);
            h.mEJ.h(11787, new Object[]{Integer.valueOf(1)});
            b.arv().aqP().gRC = -1;
            mw(-1);
        } else if (str == null || !str.equals(cQ)) {
            h.mEJ.a(485, 2, 1, false);
            h.mEJ.h(11787, new Object[]{Integer.valueOf(2)});
            b.arv().aqP().gRC = -2;
            mw(-2);
        } else if (!g.ww(str2)) {
            h.mEJ.a(485, 3, 1, false);
            h.mEJ.h(11787, new Object[]{Integer.valueOf(3)});
            b.arv().aqP().gRC = -3;
            mw(-3);
        } else if (dHg <= 0) {
            b.arv().aqP().gRC = -5;
            mw(-5);
            h.mEJ.a(485, 4, 1, false);
            h.mEJ.h(11787, new Object[]{Integer.valueOf(6)});
        } else {
            dHg--;
            aS(this.gUf, this.gUg);
        }
    }

    public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z && 10011 == i) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", new Object[]{Integer.valueOf(b.arv().aqP().gRC)});
            switch (b.arv().aqP().gRC) {
                case -21:
                case IX5WebViewClient.ERROR_FILE /*-13*/:
                case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    b.arv().arw().stop();
                    return;
                case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                    a(true, false, 0);
                    return;
                case 1:
                    b.arv().arw().stop();
                    if (gUi) {
                        b.arv().aqP().gRC = -4;
                        mw(-4);
                        return;
                    }
                    if (this.gUh != null) {
                        x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                        this.gUh.SO();
                    }
                    arC();
                    return;
                case 22:
                case 23:
                    a(true, false, -4);
                    b.arv().arw().stop();
                    gTU = true;
                    h.mEJ.a(485, 43, 1, false);
                    mA(4);
                    long j = 0;
                    if (this.gTR != 0) {
                        j = bi.bH(this.gTR);
                    }
                    x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[]{Long.valueOf(this.gTK), Long.valueOf(j)});
                    return;
                default:
                    return;
            }
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) g.a(new com.tencent.mm.plugin.backup.h.e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
                return;
            }
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", new Object[]{eVar, Long.valueOf(eVar.gXZ)});
            f fVar = new f();
            fVar.gXZ = eVar.gXZ;
            try {
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            f fVar2 = (f) g.a(new f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.gXZ : -1);
            x.i(str2, str3, objArr2);
        } else {
            if (i == 5) {
                h.mEJ.a(485, 51, 1, false);
                a(true, false, -100);
            }
            au.Em().H(new Runnable() {
                public final void run() {
                    if (i == 11) {
                        c.a(c.this, bArr, i2);
                    } else if (i == 6) {
                        c.b(c.this, bArr, i2);
                    } else if (i == 13) {
                        c.H(bArr, i2);
                    } else if (i == 15) {
                        c.c(c.this, bArr, i2);
                    } else if (i == 8) {
                        c.a(c.this, bArr);
                    }
                }
            });
        }
    }

    public final void du(boolean z) {
        this.gUc = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.arv().arw().gRS = new com.tencent.mm.plugin.backup.b.a.a() {
            public final void b(int i, int i2, byte[] bArr) {
                while (!c.this.dJO) {
                    try {
                        if (linkedBlockingQueue.offer(new a(i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.BackupMoveRecoverServer", "onBackupMoveRecoverDatapushCallback e:%s", new Object[]{e.getMessage()});
                    }
                }
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak offer datapushQueue, datapushQueue size:%d", new Object[]{Integer.valueOf(linkedBlockingQueue.size())});
            }
        };
        com.tencent.mm.sdk.f.e.b(new 10(this, linkedBlockingQueue), "onNotifyWorker").start();
        this.gTN = new LinkedList();
        this.gTO = new LinkedList();
        au.HU().Gz().a(this.gTL, this.gTM, this.gTN, this.gTO);
        if (!(this.gTb || z)) {
            LinkedList linkedList = this.gTN;
            LinkedList linkedList2 = this.gTO;
            this.gTN = new LinkedList();
            this.gTO = new LinkedList();
            au.HU().Gy().a(this.byN, linkedList, linkedList2, this.gTN, this.gTO);
        }
        j jVar = new j();
        jVar.hbH = this.gTN;
        jVar.hbI = this.gTO;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(this.gTL.size()), Integer.valueOf(jVar.hbI.size())});
            b.o(jVar.toByteArray(), 12, this.gUn);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        b.asn();
        b.arv().aqP().D(23, 1, this.gTL.size());
        mw(23);
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
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    public final void mA(int i) {
        long j = 0;
        if (this.gTR != 0) {
            j = bi.bH(this.gTR);
        }
        h.mEJ.h(11789, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.gUd), Long.valueOf(this.gTK / 1024), Long.valueOf(j / 1000)});
        x.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", new Object[]{Integer.valueOf(11789), Integer.valueOf(i), Long.valueOf(this.gTK / 1024), Long.valueOf(j / 1000)});
    }

    public final void arg() {
        synchronized (this.lock) {
            if (this.dJO) {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge isCancel true.");
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
                b.arv().aqP().D(26, 1, ckw);
                mw(26);
                this.gTS = bi.VF();
                this.gTJ = new com.tencent.mm.plugin.backup.b.d(b.arv(), 22, this, ckw, false, new LinkedList(), new LinkedList());
                this.gTJ.arg();
                h.mEJ.a(485, 46, 1, false);
            } else {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public static String arD() {
        return b.asp();
    }

    private static void arE() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.arv().gRu;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            b.J(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public final void mw(int i) {
        if (this.gSW != null) {
            ah.A(new 3(this, i));
        }
        if (this.gTP != null) {
            ah.A(new 4(this, i));
        }
    }

    public final void aqO() {
        h.mEJ.a(485, 49, 1, false);
        h.mEJ.a(485, 50, bi.bH(this.gTS) / 1000, false);
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sVe, Boolean.valueOf(true));
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.gTb) {
            n Gz = au.HU().Gz();
            LinkedList linkedList = new LinkedList();
            Cursor axc = Gz.axc();
            if (axc == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (axc.moveToNext()) {
                    m mVar = new m();
                    mVar.d(axc);
                    linkedList.add(mVar);
                }
                axc.close();
            }
            if (linkedList.size() <= 0) {
                x.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                x.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                au.HU().Gy().d(this.byN, linkedList);
            }
        }
        arB();
        b.asm();
        b.aso();
    }
}
