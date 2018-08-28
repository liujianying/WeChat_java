package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.a;

class MobileLoginOrForceReg$5 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ String eTD;
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$5(MobileLoginOrForceReg mobileLoginOrForceReg, l lVar, String str) {
        this.eTx = mobileLoginOrForceReg;
        this.bFp = lVar;
        this.eTD = str;
    }

    public final void run() {
        MobileLoginOrForceReg.a(this.eTx, ((s) this.bFp).Rn());
        at.dBv.T("login_user_name", this.eTD);
        e.deleteFile(com.tencent.mm.compatible.util.e.dgs + "temp.avatar");
        Intent be = a.ezn.be(this.eTx);
        be.addFlags(67108864);
        this.eTx.startActivity(be);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",4").toString());
        this.eTx.finish();
    }
}
