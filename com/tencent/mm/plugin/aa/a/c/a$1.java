package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class a$1 implements a<Void, com.tencent.mm.ab.a.a<x>> {
    final /* synthetic */ b eBj;
    final /* synthetic */ a eBk;

    a$1(a aVar, b bVar) {
        this.eBk = aVar;
        this.eBj = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
        if (aVar.errType == 0 && aVar.errCode == 0) {
            x xVar = (x) aVar.dIv;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", Integer.valueOf(xVar.hUm), xVar.hUn);
            if (xVar.hUm == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", Integer.valueOf(xVar.qYU.size()));
                this.eBk.eBc += xVar.qYU.size();
                this.eBk.eBd = xVar.qYQ;
                this.eBk.eBe = xVar.qYR;
                this.eBk.eBf = xVar.qYS;
                this.eBk.eBg = xVar.qYT;
                if (bi.oW(this.eBk.eBd) || bi.oW(this.eBk.eBg)) {
                    this.eBk.eBh = false;
                } else {
                    this.eBk.eBh = true;
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AAQueryListInteractor", "bill_id: %s, trans_id %s", this.eBk.eBd, this.eBk.eBg);
                this.eBj.v(xVar.qYU, xVar.qYV, Boolean.valueOf(this.eBk.eBh));
                h.mEJ.a(407, 30, 1, false);
            } else if (xVar.hUm <= 0 || !bi.oW(xVar.hUn)) {
                this.eBj.ct(Boolean.valueOf(false));
                h.mEJ.a(407, 32, 1, false);
            } else {
                this.eBj.ct(xVar.hUn);
                h.mEJ.a(407, 32, 1, false);
            }
        } else {
            this.eBj.ct(Boolean.valueOf(false));
            h.mEJ.a(407, 31, 1, false);
        }
        return uQG;
    }
}
