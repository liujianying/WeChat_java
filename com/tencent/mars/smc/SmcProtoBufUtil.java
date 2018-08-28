package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.protocal.c.pc;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static pb toMMReportKvReq(i iVar) {
        pb pbVar = new pb();
        pbVar.rti = iVar.qXj;
        pbVar.rtj = iVar.qXz;
        pbVar.rtk = iVar.qXx;
        for (int i = 0; i < iVar.qXA.size(); i++) {
            e eVar = (e) iVar.qXA.get(i);
            pa paVar = new pa();
            paVar.iwE = eVar.uin;
            paVar.rgt = eVar.qXh;
            paVar.rth = eVar.nettype;
            paVar.rjN = eVar.qXt;
            paVar.rjL = eVar.qXr;
            paVar.rjM = eVar.qXs;
            paVar.rjO = eVar.qXu;
            paVar.rjP = eVar.qXv;
            paVar.hcJ = eVar.qXw;
            for (int i2 = 0; i2 < eVar.qXi.size(); i2++) {
                d dVar = (d) eVar.qXi.get(i2);
                apv apv = new apv();
                apv.rSt = dVar.qXg;
                apv.rSu = dVar.qXp;
                apv.rSv = dVar.qXq;
                apv.rvJ = dVar.mXw;
                apv.hbF = dVar.count;
                paVar.jQF.add(apv);
            }
            pbVar.rtl.add(paVar);
        }
        return pbVar;
    }

    public static pb toMMReportIdkeyReq(g gVar) {
        pb pbVar = new pb();
        pbVar.rti = gVar.qXj;
        pbVar.rtj = gVar.qXz;
        pbVar.rtk = 0;
        for (int i = 0; i < gVar.qXA.size(); i++) {
            b bVar = (b) gVar.qXA.get(i);
            pa paVar = new pa();
            paVar.iwE = bVar.uin;
            paVar.rgt = bVar.qXh;
            paVar.rth = bVar.nettype;
            for (int i2 = 0; i2 < bVar.qXi.size(); i2++) {
                a aVar = (a) bVar.qXi.get(i2);
                apv apv = new apv();
                apv.rSt = aVar.qXg;
                apv.rvJ = 0;
                apv.rSv = 0;
                apv.hbF = aVar.count;
                apv.rSu = com.tencent.mm.bk.b.bi(Integer.toString(aVar.value).getBytes());
                paVar.jQF.add(apv);
            }
            pbVar.rtl.add(paVar);
        }
        return pbVar;
    }

    private static o fillStrategyTable(LinkedList<brg> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            brg brg = (brg) linkedList.get(i);
            m mVar = new m();
            mVar.qXM = brg.spu;
            mVar.qXN = brg.spv;
            for (int i2 = 0; i2 < brg.spw.size(); i2++) {
                awc awc = (awc) brg.spw.get(i2);
                n nVar = new n();
                nVar.qXg = awc.rSt;
                nVar.qXP = awc.rZr;
                nVar.qXQ = awc.rZp;
                nVar.qXR = awc.rZq;
                nVar.qXS = awc.rZs;
                nVar.qXT = awc.rZt;
                nVar.qXU = awc.rZu;
                mVar.qXO.add(nVar);
            }
            oVar.qXV.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(pc pcVar) {
        j jVar = new j();
        jVar.ret = pcVar.rfn;
        jVar.qXj = pcVar.rto;
        jVar.qXk = pcVar.rtp;
        jVar.qXx = pcVar.rtq;
        jVar.qXn = pcVar.rtu;
        jVar.qXC = pcVar.rtv;
        jVar.qXo = pcVar.rtw;
        jVar.qXl = fillStrategyTable(pcVar.rtr);
        jVar.qXm = fillStrategyTable(pcVar.rts);
        jVar.qXy = fillStrategyTable(pcVar.rtt);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(pc pcVar) {
        h hVar = new h();
        hVar.ret = pcVar.rfn;
        hVar.qXj = pcVar.rto;
        hVar.qXk = pcVar.rtp;
        hVar.qXn = pcVar.rtu;
        hVar.qXC = pcVar.rtv;
        hVar.qXo = pcVar.rtw;
        hVar.qXl = fillStrategyTable(pcVar.rtr);
        hVar.qXm = fillStrategyTable(pcVar.rts);
        return hVar;
    }

    public static ace toMMGetStrategyReq() {
        ace ace = new ace();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        ace.rti = ((Integer) strategyVersions.get(0)).intValue();
        ace.rtj = ((Integer) strategyVersions.get(1)).intValue();
        ace.rtk = ((Integer) strategyVersions.get(2)).intValue();
        ace.rGN = ((Integer) strategyVersions.get(3)).intValue();
        ace.rGO = ((Integer) strategyVersions.get(4)).intValue();
        ace.rGP = ((Integer) strategyVersions.get(5)).intValue();
        return ace;
    }

    public static f toSmcKVStrategyResp(acf acf) {
        f fVar = new f();
        fVar.ret = acf.rfn;
        fVar.qXj = acf.rGN;
        fVar.qXk = acf.rGO;
        fVar.qXx = acf.rGP;
        fVar.qXn = acf.rtu;
        fVar.qXo = acf.rtw;
        fVar.qXl = fillStrategyTable(acf.rGQ);
        fVar.qXm = fillStrategyTable(acf.rGR);
        fVar.qXy = fillStrategyTable(acf.rGS);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(acf acf) {
        c cVar = new c();
        cVar.ret = acf.rfn;
        cVar.qXj = acf.rto;
        cVar.qXk = acf.rtp;
        cVar.qXn = acf.rtu;
        cVar.qXo = acf.rtw;
        cVar.qXl = fillStrategyTable(acf.rtr);
        cVar.qXm = fillStrategyTable(acf.rts);
        return cVar;
    }

    public static ank toMMSelfMonitor(k kVar) {
        ank ank = new ank();
        ank.rPZ = kVar.qXD;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= kVar.qXE.size()) {
                return ank;
            }
            anl anl = new anl();
            l lVar = (l) kVar.qXE.get(i2);
            anl.rQa = lVar.qXF;
            anl.bHC = lVar.action;
            anl.rQb = lVar.qXG;
            anl.rQc = lVar.qXH;
            anl.rQd = lVar.qXI;
            anl.rQe = lVar.qXJ;
            anl.rQf = lVar.qXK;
            anl.rQg = lVar.qXL;
            ank.jQF.add(anl);
            i = i2 + 1;
        }
    }
}
