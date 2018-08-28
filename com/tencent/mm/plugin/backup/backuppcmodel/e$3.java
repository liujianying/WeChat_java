package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

class e$3 implements d {
    final /* synthetic */ e gWV;

    e$3(e eVar) {
        this.gWV = eVar;
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupPcServer";
        String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Boolean.valueOf(e.access$300());
        x.i(str, str2, objArr);
        if (!z || bArr == null) {
            if (1 != b.arV().arW().gWw && 3 != b.arV().arW().gWw) {
                return;
            }
            if (i == 10) {
                try {
                    new f().aG(bArr);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[]{Long.valueOf(r0.gXZ)});
            } else if (i == 5) {
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                this.gWV.an(true);
                b.arV().aqP().gRC = -100;
                this.gWV.mH(-100);
                h.mEJ.a(400, 51, 1, false);
                this.gWV.mG(5);
            } else if (i == 18) {
                c cVar = new c();
                try {
                    cVar.aG(bArr);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[]{Integer.valueOf(cVar.hbr)});
                if (cVar.hbr == 9) {
                    if (b.asr() == 1) {
                        b.mJ(2);
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                        this.gWV.mG(20);
                        b.asq();
                        b.arV().aqP().gRC = 14;
                        this.gWV.mH(14);
                        b.a(new 1(this));
                        return;
                    }
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[]{Integer.valueOf(b.asr())});
                }
            } else if (i == 17) {
                com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                try {
                    bVar.aG(bArr);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e22, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[]{Integer.valueOf(bVar.hbr)});
                if (bVar.hbr == 10) {
                    int i3 = b.arV().aqP().gRC;
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 12 || i3 == 14) {
                        this.gWV.an(true);
                        b.arV().arw().stop();
                        b.arV().aqP().gRC = -4;
                        this.gWV.mH(-4);
                        h.mEJ.a(400, 51, 1, false);
                        this.gWV.mG(5);
                        long j = 0;
                        if (e.b(this.gWV).gSk != 0) {
                            j = bi.bH(e.b(this.gWV).gSk);
                        }
                        h.mEJ.h(13737, new Object[]{Integer.valueOf(3), Long.valueOf(e.b(this.gWV).arc()), Long.valueOf(j / 1000), Integer.valueOf(1)});
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[]{Long.valueOf(e.b(this.gWV).arc()), Long.valueOf(j / 1000)});
                    }
                }
            }
        } else if (10011 == i) {
            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
            switch (b.arV().aqP().gRC) {
                case -21:
                case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    b.arV().arw().stop();
                    return;
                case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                    this.gWV.an(true);
                    return;
                case 1:
                case 11:
                    b.arV().arw().stop();
                    b.arV().aqP().gRC = -100;
                    this.gWV.mH(-100);
                    return;
                case 4:
                case 12:
                case 14:
                    if (!b.arV().arW().gWA || e.access$300()) {
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                        this.gWV.an(true);
                        b.arV().arw().stop();
                        b.arV().aqP().gRC = -4;
                        this.gWV.mH(-4);
                        h.mEJ.a(400, 9, 1, false);
                        this.gWV.mG(3);
                        return;
                    }
                    switch (b.asr()) {
                        case 0:
                        case 2:
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[]{Integer.valueOf(b.asr())});
                            this.gWV.mG(19);
                            e.c(this.gWV);
                            b.a(b.arV().arW().gWF);
                            return;
                        case 1:
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[]{Integer.valueOf(b.asr())});
                            return;
                        default:
                            return;
                    }
                case 15:
                    b.arV().arw().stop();
                    b.arV().aqP().gRC = -100;
                    this.gWV.mH(-100);
                    return;
                default:
                    return;
            }
        }
    }
}
