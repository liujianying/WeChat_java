package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b.c;
import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.Iterator;
import java.util.LinkedList;

public final class d implements b, com.tencent.mm.plugin.backup.f.b.d {
    public static boolean gTb = false;
    public static boolean gUB = false;
    public byte[] bitmapData;
    public com.tencent.mm.plugin.backup.a.b.d gSW;
    public boolean gTY = false;
    public int gUA = 0;
    private int gUC;
    private int gUD;
    private int gUE = 0;
    public e gUF = new e(new 5(this), b.arv().aqP());
    public c gUo = new 2(this);
    private final a gUp = new 3(this);
    public final i.a gUq = new 4(this);
    public LinkedList<String> gUu;
    private com.tencent.mm.plugin.backup.b.b gUv;
    private com.tencent.mm.plugin.backup.b.c gUw;
    public long gUx = 0;
    public long gUy = 0;
    public boolean gUz = false;

    public final void an(boolean z) {
        x.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", new Object[]{aj.cin()});
        if (!z) {
            arE();
        }
        if (this.gUw != null) {
            this.gUw.cancel();
        }
        if (this.gUv != null) {
            this.gUv.cancel();
            this.gUv = null;
        }
        x.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.f.b.asm();
        com.tencent.mm.plugin.backup.f.b.aso();
    }

    public static void c(int i, long j, long j2, int i2) {
        x.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        b.arv();
        Editor edit = b.aqU().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (z && bArr != null && 10011 == i) {
            x.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", new Object[]{Integer.valueOf(b.arv().aqP().gRC)});
            switch (b.arv().aqP().gRC) {
                case -23:
                case -21:
                case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    b.arv().arw().stop();
                    break;
                case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                    an(true);
                    break;
                case 1:
                    b.arv().arw().stop();
                    b.arv().aqP().gRC = -100;
                    mw(-100);
                    break;
                case 12:
                case 14:
                    an(true);
                    b.arv().arw().stop();
                    b.arv().aqP().gRC = -4;
                    mw(-4);
                    h.mEJ.a(485, 24, 1, false);
                    if (!(this.gUw == null || this.gUw.gSk == 0)) {
                        long bH = bi.bH(this.gUw.gSk);
                        x.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[]{Long.valueOf(this.gUw.arc()), Long.valueOf(bH / 1000)});
                        break;
                    }
            }
        }
        if (i == 1) {
            v vVar = (v) g.a(new v(), bArr);
            if (vVar == null) {
                x.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
                b.arv().aqP().gRC = -5;
                mw(-5);
                return;
            }
            if (bi.oW(b.arv().gRu)) {
                b.arv().gRu = vVar.ID;
            }
            if (vVar.ID.equals(b.arv().gRu)) {
                x.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[]{vVar.ID, Integer.valueOf(vVar.hcC)});
                if (vVar.hcC == 0) {
                    if (!b.arv().gRv.equals(new String(k.a(vVar.hbs.lR, com.tencent.mm.plugin.backup.a.d.aqT())))) {
                        w wVar = new w();
                        wVar.hcC = 0;
                        wVar.ID = b.arv().gRu;
                        wVar.hcd = 1;
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            x.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, i2);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        b.arv().aqP().gRC = -5;
                        mw(-5);
                    }
                    if (vVar.hcD < com.tencent.mm.plugin.backup.a.c.gRm) {
                        x.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", new Object[]{Integer.valueOf(vVar.hcD)});
                        h.mEJ.a(485, 103, 1, false);
                        b.arv().aqP().gRC = -12;
                        mw(-12);
                        return;
                    }
                    x.i("MicroMsg.BackupMoveServer", "summerbak start move");
                    this.gUD = i2;
                    if (gUB || gTb) {
                        if (gUB && gTb && (vVar.hcF & com.tencent.mm.plugin.backup.a.c.gRr) == 0 && (vVar.hcF & com.tencent.mm.plugin.backup.a.c.gRs) == 0) {
                            b.arv().aqP().gRC = -31;
                            mw(-31);
                            this.gUE = 1;
                            return;
                        } else if (gUB && (vVar.hcF & com.tencent.mm.plugin.backup.a.c.gRr) == 0) {
                            b.arv().aqP().gRC = -32;
                            mw(-32);
                            this.gUE = 2;
                            return;
                        } else if (gTb && (vVar.hcF & com.tencent.mm.plugin.backup.a.c.gRs) == 0) {
                            b.arv().aqP().gRC = -33;
                            mw(-33);
                            this.gUE = 3;
                            return;
                        }
                    }
                    dw(false);
                    return;
                } else if (vVar.hcC == 1) {
                    if (!b.arv().gRw.equals(new String(k.a(vVar.hbs.lR, com.tencent.mm.plugin.backup.a.d.aqT())))) {
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.arv().aqP().gRC = -5;
                        mw(-5);
                    }
                    x.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    b.arv().aqP().gRC = 2;
                    mw(2);
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[]{b.arv().gRu, vVar.ID});
            an(false);
            b.arv().aqP().gRC = -5;
            mw(-5);
        } else if (i == 3) {
            this.gUC = i2;
            if (b.arv().arz().gTA) {
                arJ();
            } else {
                this.gUz = true;
            }
        } else if (i == 9) {
            e eVar = (e) g.a(new e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
                return;
            }
            x.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", new Object[]{eVar, Long.valueOf(eVar.gXZ)});
            f fVar = (f) g.a(new f(), bArr);
            fVar.gXZ = eVar.gXZ;
            try {
                x.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                com.tencent.mm.plugin.backup.f.b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            try {
                new f().aG(bArr);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
            }
        } else if (i == 5) {
            x.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            an(true);
            b.arv().aqP().gRC = -100;
            mw(-100);
        } else if (i == 12) {
            j jVar = (j) g.a(new j(), bArr);
            if (jVar == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[]{Integer.valueOf(bi.bD(bArr))});
                b.arv().aqP().gRC = -5;
                mw(-5);
                return;
            }
            int i3;
            LinkedList b = b(jVar.hbH, jVar.hbI);
            str2 = "MicroMsg.BackupMoveServer";
            String str3 = "summerbak backup receive requestsession response. backupSessionList:%d ";
            Object[] objArr2 = new Object[1];
            if (b == null) {
                i3 = -1;
            } else {
                i3 = b.size();
            }
            objArr2[0] = Integer.valueOf(i3);
            x.i(str2, str3, objArr2);
            if (b == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                arE();
                b.arv().aqP().gRC = -21;
                mw(-21);
                return;
            }
            com.tencent.mm.plugin.backup.f.b.a(this.gUp);
            com.tencent.mm.plugin.backup.f.b.asl();
            this.gUw = new com.tencent.mm.plugin.backup.b.c(b.arv(), 2, this);
            this.gUw.dt(false);
            this.gUw.a(b, b.arv().aqP().gRF, gTb);
        }
    }

    public final void dw(boolean z) {
        if (z) {
            switch (this.gUE) {
                case 1:
                    gUB = false;
                    gTb = false;
                    this.gUx = 0;
                    this.gUy = 0;
                    break;
                case 2:
                    gUB = false;
                    this.gUx = 0;
                    this.gUy = 0;
                    break;
                case 3:
                    gTb = false;
                    break;
            }
        }
        w wVar = new w();
        wVar.hcC = 0;
        wVar.ID = b.arv().gRu;
        wVar.hcD = com.tencent.mm.plugin.backup.a.c.gRm;
        wVar.hcd = 0;
        wVar.hcE = this.gUA;
        wVar.hbs = new com.tencent.mm.bk.b(k.b(b.arv().gRw.getBytes(), com.tencent.mm.plugin.backup.a.d.aqT()));
        if (bi.getInt(com.tencent.mm.k.g.AT().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.hcF |= com.tencent.mm.plugin.backup.a.c.gRq;
        }
        wVar.hcF |= com.tencent.mm.plugin.backup.a.c.gRr;
        wVar.hcF |= com.tencent.mm.plugin.backup.a.c.gRs;
        try {
            x.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, this.gUD);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        }
    }

    public final void arJ() {
        x.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.gUz = false;
        b.arv().aqP().gRC = 12;
        mw(12);
        com.tencent.mm.plugin.backup.g.d.asG().asJ();
        if (this.gUu != null) {
            long j;
            x.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[]{Integer.valueOf(this.gUu.size())});
            o oVar = new o();
            oVar.ID = b.arv().gRu;
            oVar.hcb = (long) this.gUu.size();
            a arz = b.arv().arz();
            if (arz.ars() == null) {
                j = 0;
            } else {
                Iterator it = arz.ars().iterator();
                j = 0;
                while (it.hasNext()) {
                    j = ((com.tencent.mm.plugin.backup.a.f.b) it.next()).gRL + j;
                }
            }
            oVar.hcc = j;
            oVar.hcd = 0;
            oVar.hce = this.gTY ? com.tencent.mm.plugin.backup.a.c.gRl : com.tencent.mm.plugin.backup.a.c.gRk;
            if (gTb) {
                oVar.hca = 3;
            }
            m mVar = new m();
            mVar.hbO = q.zz();
            mVar.hbP = Build.MANUFACTURER;
            mVar.hbQ = Build.MODEL;
            mVar.hbR = "Android";
            mVar.hbS = VERSION.RELEASE;
            mVar.hbT = com.tencent.mm.protocal.d.qVN;
            mVar.hbU = 0;
            x.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.qVN)});
            oVar.hbY = mVar;
            try {
                com.tencent.mm.plugin.backup.f.b.o(oVar.toByteArray(), 4, this.gUC);
                x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(this.gUu.size()), Long.valueOf(this.gUx), Long.valueOf(this.gUy)});
                com.tencent.mm.plugin.backup.h.i iVar = new com.tencent.mm.plugin.backup.h.i();
                iVar.hbH = this.gUu;
                iVar.hbI = new LinkedList();
                Iterator it2 = this.gUu.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    iVar.hbI.add(Long.valueOf(r0));
                    iVar.hbI.add(Long.valueOf(j));
                }
                try {
                    x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[]{Integer.valueOf(this.gUu.size())});
                    com.tencent.mm.plugin.backup.f.b.J(iVar.toByteArray(), 11);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "", new Object[0]);
            }
        }
    }

    private static void arE() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.arv().gRu;
        try {
            x.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            com.tencent.mm.plugin.backup.f.b.J(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public static String arK() {
        return com.tencent.mm.plugin.backup.f.b.asp();
    }

    public final void mw(int i) {
        if (this.gSW != null) {
            ah.A(new 1(this, i));
        }
    }

    public final void aqL() {
    }

    public final void aqM() {
        an(false);
    }

    private static LinkedList<com.tencent.mm.plugin.backup.a.f.a> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            return null;
        }
        LinkedList<com.tencent.mm.plugin.backup.a.f.a> linkedList3 = new LinkedList();
        Iterator it = linkedList2.iterator();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            linkedList3.add(new com.tencent.mm.plugin.backup.a.f.a(i, (String) linkedList.get(i), j2, j));
        }
        return linkedList3;
    }
}
