package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ah;

class m$3 implements Runnable {
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ boolean hlD;
    final /* synthetic */ m lWI;

    m$3(m mVar, boolean z, ProgressDialog progressDialog) {
        this.lWI = mVar;
        this.hlD = z;
        this.hZo = progressDialog;
    }

    public final void run() {
        boolean z = this.hlD;
        br.r(6, z ? "3" : "4");
        int GQ = q.GQ();
        int i = z ? GQ & -129 : GQ | 128;
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            bd.iE("qqsync");
            au.HU();
            c.FW().Yp("qqsync");
        }
        ah.A(new 1(this));
    }
}
