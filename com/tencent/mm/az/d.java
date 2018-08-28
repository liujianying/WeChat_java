package com.tencent.mm.az;

import com.tencent.mm.g.a.kl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import java.util.HashMap;
import java.util.List;

public class d implements ar {
    public static int[] eln = new int[1000];
    public static int num = 0;
    private final int bzF = 0;
    private e elj = new e();
    private b elk = new b();
    private final long ell = 259200000;
    private final int elm = 2;
    private c elo = new 1(this);

    public static au SE() {
        g.Eg().Ds();
        au auVar = (au) ((i) g.l(i.class)).bcX();
        auVar.a(SF(), g.Em().lnJ.getLooper());
        return auVar;
    }

    public static as SF() {
        g.Eg().Ds();
        return (as) ((i) g.l(i.class)).bcW();
    }

    public static bb SG() {
        g.Eg().Ds();
        return (bb) ((i) g.l(i.class)).bcV();
    }

    public static bp SH() {
        g.Eg().Ds();
        return (bp) ((i) g.l(i.class)).bcU();
    }

    public final void onAccountRelease() {
        com.tencent.mm.ab.d.c.b(Integer.valueOf(37), this.elj);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(65), this.elj);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(40), this.elk);
        a.sFg.c(this.elo);
        com.tencent.mm.model.au.getNotification().xR();
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(37), this.elj);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(65), this.elj);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(40), this.elk);
        a.sFg.b(this.elo);
        int clP = SF().clP();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.model.au.HU();
        currentTimeMillis -= bi.a((Long) com.tencent.mm.model.c.DT().get(340225, null), 0);
        x.i("MicroMsg.SubCoreVerify", "timeInterval = " + currentTimeMillis);
        if (currentTimeMillis > 259200000 && clP > 0) {
            List clQ = SF().clQ();
            int size = clQ.size();
            String str = (String) clQ.get(0);
            for (clP = 1; clP < size; clP++) {
                str = str + ", " + ((String) clQ.get(clP));
            }
            x.i("MicroMsg.SubCoreVerify", "title = " + str);
            kl klVar = new kl();
            klVar.bUL.userName = null;
            klVar.bUL.bgn = str;
            klVar.bUL.type = 0;
            a.sFg.m(klVar);
            com.tencent.mm.model.au.HU();
            com.tencent.mm.model.c.DT().set(340225, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void bo(boolean z) {
    }

    public static void a(by byVar, com.tencent.mm.storage.bd.d dVar) {
        x.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + byVar.hcd + ", id = " + byVar.rcq);
        ba baVar = new ba();
        baVar.field_content = ab.a(byVar.rcl);
        baVar.field_createtime = bi.VE();
        baVar.field_imgpath = "";
        baVar.field_sayhicontent = dVar.content;
        baVar.field_sayhiuser = dVar.otZ;
        baVar.field_scene = dVar.scene;
        baVar.field_status = byVar.hcd > 3 ? byVar.hcd : 3;
        baVar.field_svrid = byVar.rcq;
        baVar.field_talker = ab.a(byVar.rcj);
        baVar.field_type = byVar.jQd;
        baVar.field_isSend = 0;
        baVar.field_sayhiencryptuser = dVar.tbT;
        baVar.field_ticket = dVar.juZ;
        baVar.field_flag = 1;
        ((bb) ((i) g.l(i.class)).bcV()).a(baVar);
        com.tencent.mm.aa.c.J(baVar.field_sayhiencryptuser, 3);
    }

    public static void b(by byVar, com.tencent.mm.storage.bd.d dVar) {
        x.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + byVar.hcd + ", id = " + byVar.rcq);
        bo boVar = new bo();
        boVar.field_content = ab.a(byVar.rcl);
        boVar.field_createtime = bi.VE();
        boVar.field_imgpath = "";
        boVar.field_sayhicontent = dVar.content;
        boVar.field_sayhiuser = dVar.otZ;
        boVar.field_scene = dVar.scene;
        boVar.field_status = byVar.hcd > 3 ? byVar.hcd : 3;
        boVar.field_svrid = byVar.rcq;
        boVar.field_talker = ab.a(byVar.rcj);
        boVar.field_type = byVar.jQd;
        boVar.field_isSend = 0;
        ((bp) ((i) g.l(i.class)).bcU()).b(boVar);
        com.tencent.mm.aa.c.J(boVar.field_sayhiuser, 3);
    }
}
