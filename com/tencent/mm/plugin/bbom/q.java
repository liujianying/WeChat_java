package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.tencent.mm.bh.d;
import com.tencent.mm.booter.g;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.j;
import com.tencent.mm.booter.n;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.x;
import java.util.List;

public final class q extends c<lw> {
    public q() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int f;
        long VE;
        long c;
        if (a.dBt != null) {
            a.dBt.HE();
        }
        Object obj = (au.HX() && !au.Dr() && (com.tencent.mm.model.q.GQ() & 16) == 0) ? 1 : null;
        if (obj != null && h.xG()) {
            atd atd;
            au.HU();
            x DT = com.tencent.mm.model.c.DT();
            int f2 = ai.f((Integer) DT.get(67073, null));
            int f3 = ai.f((Integer) DT.get(67074, null));
            int f4 = ai.f((Integer) DT.get(67075, null));
            f = ai.f((Integer) DT.get(67076, null));
            au.HU();
            f FT = com.tencent.mm.model.c.FT();
            int bF = FT.bF("medianote", 1);
            int bF2 = FT.bF("medianote", 3);
            int bF3 = FT.bF("medianote", 34);
            int bF4 = FT.bF("medianote", 43);
            if (bF - f2 > 0) {
                atd atd2 = new atd();
                atd2.rVB = bF - f2;
                atd2.rVC = 1;
                DT.set(67073, Integer.valueOf(bF));
            }
            if (bF2 - f3 > 0) {
                atd = new atd();
                atd.rVB = bF2 - f3;
                atd.rVC = 3;
                DT.set(67074, Integer.valueOf(bF2));
            }
            if (bF3 - f4 > 0) {
                atd = new atd();
                atd.rVB = bF3 - f4;
                atd.rVC = 34;
                DT.set(67075, Integer.valueOf(bF3));
            }
            if (bF4 - f > 0) {
                atd = new atd();
                atd.rVB = bF4 - f;
                atd.rVC = 43;
                DT.set(67076, Integer.valueOf(bF4));
            }
            au.HU();
            com.tencent.mm.model.c.DT().set(66817, Long.valueOf(ai.VE()));
        }
        com.tencent.mm.bh.a.run();
        au.HU();
        boolean e = ai.e((Boolean) com.tencent.mm.model.c.DT().get(67841, null));
        if (!(l.XC() == l.a.eKt || l.XC() == l.a.eKu)) {
            e = false;
        }
        if (e) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List pr = com.tencent.mm.plugin.account.b.getAddrUploadStg().pr("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + bi.oU("") + "\" )");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskUpdateCtRemark", "list " + pr.size());
            f = 0;
            while (true) {
                int i = f;
                if (i >= pr.size()) {
                    break;
                }
                String username = ((com.tencent.mm.plugin.account.friend.a.a) pr.get(i)).getUsername();
                String trim = ((com.tencent.mm.plugin.account.friend.a.a) pr.get(i)).Xj().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    au.HU();
                    ab Yg = com.tencent.mm.model.c.FR().Yg(username);
                    if (com.tencent.mm.l.a.gd(Yg.field_type) && (Yg.field_conRemark == null || Yg.field_conRemark.equals(""))) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        s.b(Yg, trim);
                    }
                }
                f = i + 1;
            }
            au.HU();
            com.tencent.mm.model.c.DT().set(67841, Boolean.valueOf(false));
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        br.IE().IF();
        i.run();
        if (d.xG()) {
            d.cfO();
        }
        n.run();
        g.run();
        if (au.HX() && !au.Dr()) {
            if (bi.oW(com.tencent.mm.bh.c.cfN())) {
                bf.iH("ver" + com.tencent.mm.protocal.d.qVN);
            } else {
                au.HU();
                if (bi.bG(bi.a((Long) com.tencent.mm.model.c.DT().get(77833, null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(10719, new Object[]{com.tencent.mm.bh.c.cfJ(), com.tencent.mm.bh.c.cfK(), com.tencent.mm.bh.c.cfL(), com.tencent.mm.bh.c.getRomInfo(), com.tencent.mm.bh.c.cfM(), "", com.tencent.mm.bh.c.cfN()});
                    au.HU();
                    com.tencent.mm.model.c.DT().set(77833, Long.valueOf(bi.VE()));
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (au.HX() && !au.Dr()) {
            VE = bi.VE();
            au.HU();
            if (bi.a((Long) com.tencent.mm.model.c.DT().get(331777, null), 0) < VE) {
                au.HU();
                com.tencent.mm.model.c.DT().set(331777, Long.valueOf(VE + 259200));
                com.tencent.mm.plugin.report.b.d.brJ();
            }
            com.tencent.mm.plugin.report.b.d.n(3, 0, "");
        }
        com.tencent.mm.bh.b.run();
        if (au.HX()) {
            au.HU();
            c = bi.c((Long) com.tencent.mm.model.c.DT().get(74, null));
            if (10010 == af.exm && af.exn > 0) {
                c = bi.VE() - ((long) af.exn);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", new Object[]{Integer.valueOf(af.exn), Long.valueOf(c)});
                af.exn = 0;
            }
            VE = bi.VE();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", new Object[]{Long.valueOf(VE), Long.valueOf(c), Long.valueOf(VE - c)});
            if ((VE - c) * 1000 >= 86400000) {
                au.HU();
                com.tencent.mm.model.c.DT().set(74, Long.valueOf(VE));
                if (com.tencent.mm.modelstat.q.Sj() == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    VE = (bi.VF() / 86400000) - 1;
                    k it = com.tencent.mm.modelstat.q.Sj().it((int) VE);
                    if (it == null || it.ejM != ((int) VE)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(it == null ? -1 : it.ejM);
                        objArr[1] = Long.valueOf(VE);
                        com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
                    } else if (com.tencent.mm.modelstat.q.Sh() == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        com.tencent.mm.modelstat.g.a RZ = com.tencent.mm.modelstat.q.Sh().RZ();
                        if (RZ == null) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            RZ = new com.tencent.mm.modelstat.g.a();
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", new Object[]{Long.valueOf(VE), Integer.valueOf(it.ejM), Integer.valueOf(it.ejY), Integer.valueOf(it.ekk), Integer.valueOf(it.ejX), Integer.valueOf(it.ekj), Integer.valueOf(it.ejW), Integer.valueOf(it.eki), Integer.valueOf(it.ejV), Integer.valueOf(it.ekh), Integer.valueOf(RZ.ejH), Integer.valueOf(RZ.bID), RZ.ispName, RZ.extraInfo});
                        com.tencent.mm.plugin.report.service.h.mEJ.h(10900, new Object[]{Long.valueOf((VE * 86400000) / 1000), Integer.valueOf(it.ejY), Integer.valueOf(it.ekk), Integer.valueOf(it.ejX), Integer.valueOf(it.ekj), Integer.valueOf(it.ejW), Integer.valueOf(it.eki), Integer.valueOf(it.ejV), Integer.valueOf(it.ekh), Integer.valueOf(RZ.ejH), Integer.valueOf(RZ.bID), RZ.ispName, RZ.extraInfo});
                    }
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        ae.run();
        au.HU();
        if ((ai.bH(ai.c((Long) com.tencent.mm.model.c.DT().get(282881, null))) > 172800000 ? 1 : null) != null) {
            au.HU();
            com.tencent.mm.model.c.DT().set(282881, Long.valueOf(ai.VF()));
            com.tencent.mm.sdk.b.a.sFg.m(new nz());
        }
        if (au.HX() && !au.Dr()) {
            VE = bi.VE();
            au.HU();
            if (bi.a((Long) com.tencent.mm.model.c.DT().get(aa.a.sPw, null), 0) < VE) {
                c = 604800 + VE;
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sPw, Long.valueOf(c));
                obj = com.tencent.mm.model.q.GF();
                if (!TextUtils.isEmpty(obj)) {
                    au.DF().a(new m(obj), 0);
                }
            }
        }
        if (au.HX() && !au.Dr()) {
            VE = bi.VE();
            au.HU();
            if (bi.a((Long) com.tencent.mm.model.c.DT().get(aa.a.sPJ, null), 0) < VE) {
                c = (bi.ciZ() / 1000) + 86400;
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sPJ, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11921, new Object[]{Integer.valueOf(1)});
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11921, new Object[]{Integer.valueOf(0)});
                    }
                }
            }
        }
        com.tencent.mm.booter.k.run();
        com.tencent.mm.booter.l.run();
        com.tencent.mm.booter.m.run();
        j.run();
        return false;
    }
}
