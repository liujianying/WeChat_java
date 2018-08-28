package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements e {
    final /* synthetic */ c gWG;

    c$1(c cVar) {
        this.gWG = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(595, c.a(this.gWG));
        if (i == 0 && i2 == 0) {
            ach asA = ((com.tencent.mm.plugin.backup.f.e) lVar).asA();
            au.HU();
            String str2;
            if (!bi.oV((String) c.DT().get(2, null)).equals(asA.rfk)) {
                x.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                b.arV().aqP().gRC = -5;
                b.arV().arX().mH(-5);
                h.mEJ.a(400, 112, 1, false);
                return;
            } else if (asA.rfi == null || asA.rfi.size() <= 0 || asA.rfi.getFirst() == null) {
                str2 = "MicroMsg.BackupPcProcessMgr";
                String str3 = "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(asA.rfh);
                objArr[1] = asA.rfi == null ? "null" : asA.rfi.size();
                x.e(str2, str3, objArr);
                b.arV().aqP().gRC = -5;
                b.arV().arX().mH(-5);
                h.mEJ.a(400, 113, 1, false);
                return;
            } else {
                pw pwVar = (pw) asA.rfi.getFirst();
                str2 = pwVar.rud;
                int intValue = ((Integer) pwVar.rue.getFirst()).intValue();
                c cVar = this.gWG;
                cVar.gWx = asA.rfl;
                cVar.gWy = str2;
                cVar.gWz = intValue;
                x.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(asA.hcE), Integer.valueOf(asA.otY), asA.rfl, str2, Integer.valueOf(intValue)});
                b.arV().gRu = asA.ID;
                b.arV().gRv = asA.rfr;
                b.arV().gRw = asA.rfs;
                b.arV().gRA = asA.reV.siK.lR;
                c.b(this.gWG);
                return;
            }
        }
        x.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        h.mEJ.a(400, 111, 1, false);
        if (i == 4 && i2 == -2011) {
            x.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
        }
        b.arV().aqP().gRC = -5;
        b.arV().arX().mH(-5);
    }
}
