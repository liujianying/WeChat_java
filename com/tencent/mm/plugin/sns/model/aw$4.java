package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.bk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class aw$4 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ String efo;
    final /* synthetic */ aw nsc;
    final /* synthetic */ int nsd;
    final /* synthetic */ atf nse;
    final /* synthetic */ List nsf;
    final /* synthetic */ bsu nsg;
    final /* synthetic */ boolean nsh;
    final /* synthetic */ LinkedList nsi;
    final /* synthetic */ b nsj;

    aw$4(aw awVar, String str, atf atf, List list, bsu bsu, int i, boolean z, LinkedList linkedList, b bVar, String str2) {
        this.nsc = awVar;
        this.efo = str;
        this.nse = atf;
        this.nsf = list;
        this.nsg = bsu;
        this.nsd = i;
        this.nsh = z;
        this.nsi = linkedList;
        this.nsj = bVar;
        this.dEt = str2;
    }

    public final void run() {
        if (af.bxX()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        aw.a(this.nsc, new s(this.efo, this.nse.rVG, this.nse.rWb, this.nsf, this.nsg, this.nsd, this.nse.rcc, this.nse.rWg, this.nse.rWh, this.nse.rWi, this.nse, this.nsh, this.nsi, this.nse.rWn, this.nsj, this.dEt));
        g.Ek();
        g.Eh().dpP.a(aw.d(this.nsc), 0);
    }
}
