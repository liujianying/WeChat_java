package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> lap;

    public final void bck() {
        a aVar = null;
        boolean bcm = bcm();
        au.HU();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(102408, Boolean.valueOf(false))).booleanValue();
        boolean z = (q.GQ() & GLIcon.RIGHT) == 0;
        x.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[]{Boolean.valueOf(booleanValue)});
        if (z && !booleanValue && bcm) {
            x.d("MicroMsg.MassSendService", "set top conversation");
            au.HU();
            if (com.tencent.mm.model.c.FW().Yq("masssendapp") == null) {
                au.HU();
                if (com.tencent.mm.model.c.FW().Yq("masssendapp") == null) {
                    ai aiVar = new ai();
                    aiVar.setUsername("masssendapp");
                    aiVar.setContent(ad.getContext().getResources().getString(R.l.contact_info_masssend_tip));
                    aiVar.as(bi.VF() + 2000);
                    aiVar.eX(0);
                    aiVar.eV(0);
                    au.HU();
                    com.tencent.mm.model.c.FW().d(aiVar);
                }
            } else {
                String string;
                Cursor b = h.bco().dCZ.b("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
                if (b != null) {
                    a aVar2;
                    if (b.moveToFirst()) {
                        aVar2 = new a();
                        aVar2.d(b);
                    } else {
                        aVar2 = null;
                    }
                    b.close();
                    aVar = aVar2;
                }
                if (aVar == null) {
                    string = ad.getContext().getResources().getString(R.l.contact_info_masssend_tip);
                } else {
                    h.bco();
                    string = b.a(aVar);
                }
                ai aiVar2 = new ai();
                aiVar2.setUsername("masssendapp");
                aiVar2.setContent(string);
                aiVar2.as(bi.VF() + 2000);
                aiVar2.eX(0);
                aiVar2.eV(0);
                au.HU();
                com.tencent.mm.model.c.FW().a(aiVar2, "masssendapp");
            }
            h.mEJ.k(10425, "");
            au.HU();
            com.tencent.mm.model.c.DT().set(102409, Long.valueOf(bi.VF()));
            au.HU();
            com.tencent.mm.model.c.DT().set(102408, Boolean.valueOf(true));
        } else if (!bcm) {
            au.HU();
            com.tencent.mm.model.c.DT().set(102408, Boolean.valueOf(false));
        }
    }

    public static void dV(long j) {
        au.HU();
        com.tencent.mm.model.c.DT().set(102409, Long.valueOf(j));
    }

    private static String bcl() {
        if (!au.HX()) {
            return "";
        }
        r1 = new Object[2];
        au.HU();
        r1[0] = com.tencent.mm.model.c.Gp();
        r1[1] = w.chP();
        x.d("MicroMsg.MassSendService", "config file path is %s", new Object[]{String.format("%s/masssend_%s.ini", r1)});
        return String.format("%s/masssend_%s.ini", r1);
    }

    private boolean bcm() {
        if (this.lap == null) {
            String bcl = bcl();
            byte[] f = e.f(bcl, 0, -1);
            if (f == null) {
                return false;
            }
            try {
                this.lap = ((e) new e().aG(f)).laq;
            } catch (Exception e) {
                e.deleteFile(bcl);
                return false;
            }
        }
        if (this.lap == null) {
            x.w("MicroMsg.MassSendService", "info list is empty");
            return false;
        }
        x.i("MicroMsg.MassSendService", "info list[%s]", new Object[]{this.lap.toString()});
        long VE = bi.VE();
        Iterator it = this.lap.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.bwe) <= VE && VE <= ((long) dVar.end)) {
                return true;
            }
        }
        return false;
    }

    public final void Gj(String str) {
        if (!bi.oW(str)) {
            Map z = bl.z(str, "Festivals");
            if (z != null) {
                e eVar = new e();
                int i = 0;
                while (true) {
                    String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
                    if (!z.containsKey(str2)) {
                        break;
                    }
                    d dVar = new d();
                    dVar.bwe = bi.WL((String) z.get(str2 + ".StartTime"));
                    dVar.end = bi.WL((String) z.get(str2 + ".EndTime")) + 86400000;
                    eVar.laq.add(dVar);
                    i++;
                }
                eVar.count = eVar.laq.size();
                this.lap = eVar.laq;
                try {
                    byte[] toByteArray = eVar.toByteArray();
                    String bcl = bcl();
                    if (bi.oW(bcl)) {
                        x.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                        return;
                    }
                    File file = new File(bcl);
                    if (file.exists()) {
                        int i2;
                        if (g.m(file).equals(g.u(toByteArray))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            au.HU();
                            com.tencent.mm.model.c.DT().set(102408, Boolean.valueOf(false));
                        }
                    } else {
                        au.HU();
                        com.tencent.mm.model.c.DT().set(102408, Boolean.valueOf(false));
                    }
                    x.d("MicroMsg.MassSendService", "save to config file : %s", new Object[]{eVar.toString()});
                    e.b(bcl, toByteArray, toByteArray.length);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
                }
            }
        }
    }
}
