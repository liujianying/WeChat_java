package com.tencent.mm.model.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean dDX = false;
    public ArrayList<a> mListeners = new ArrayList();

    public static String IZ() {
        au.HU();
        return (String) c.DT().get(a.sXA, "");
    }

    public static String Ja() {
        au.HU();
        return (String) c.DT().get(a.sXB, "");
    }

    public static boolean Jb() {
        au.HU();
        return ((Boolean) c.DT().get(a.sXD, Boolean.valueOf(false))).booleanValue();
    }

    public static String Jc() {
        au.HU();
        return (String) c.DT().get(a.sXu, "");
    }

    public static String Jd() {
        au.HU();
        return (String) c.DT().get(a.sXv, "");
    }

    public static boolean Je() {
        au.HU();
        return ((Boolean) c.DT().get(a.sXx, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Jf() {
        au.HU();
        return ((Boolean) c.DT().get(a.sXy, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Jg() {
        au.HU();
        return ((Boolean) c.DT().get(a.sXH, Boolean.valueOf(false))).booleanValue();
    }

    public final void r(Map<String, String> map) {
        if (map != null) {
            h.mEJ.a(633, 3, 1, false);
            String oV = bi.oV((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.url"));
            String oV2 = bi.oV((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.wording"));
            long j = bi.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0);
            boolean z = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1;
            boolean z2 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) == 1;
            String oV3 = bi.oV((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.url"));
            String oV4 = bi.oV((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.wording"));
            long j2 = bi.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0);
            boolean z3 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) == 1;
            boolean z4 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) == 1;
            if (!bi.oW(oV2) || !bi.oW(oV4)) {
                au.HU();
                c.DT().a(a.sXu, oV4);
                au.HU();
                c.DT().a(a.sXv, oV3);
                au.HU();
                c.DT().a(a.sXw, Long.valueOf(j2));
                au.HU();
                c.DT().a(a.sXx, Boolean.valueOf(z4));
                au.HU();
                c.DT().a(a.sXy, Boolean.valueOf(z3));
                au.HU();
                c.DT().a(a.sXA, oV2);
                au.HU();
                c.DT().a(a.sXB, oV);
                au.HU();
                c.DT().a(a.sXC, Long.valueOf(j));
                au.HU();
                c.DT().a(a.sXD, Boolean.valueOf(z2));
                au.HU();
                c.DT().a(a.sXE, Boolean.valueOf(z));
                au.HU();
                c.DT().a(a.sXG, Long.valueOf(bi.VE()));
                au.HU();
                c.DT().a(a.sXz, Boolean.valueOf(false));
                au.HU();
                c.DT().a(a.sXF, Boolean.valueOf(false));
                au.HU();
                c.DT().a(a.sXH, Boolean.valueOf(false));
                au.HU();
                c.DT().lm(true);
                Jh();
            }
        }
    }

    public static boolean a(b bVar) {
        long longValue;
        boolean booleanValue;
        boolean Jf;
        String Jc;
        x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[]{bVar});
        long VE = bi.VE();
        au.HU();
        long longValue2 = ((Long) c.DT().get(a.sXG, Long.valueOf(-1))).longValue();
        if (bVar == b.dDZ) {
            au.HU();
            longValue = ((Long) c.DT().get(a.sXw, Long.valueOf(0))).longValue();
            au.HU();
            booleanValue = ((Boolean) c.DT().get(a.sXz, Boolean.valueOf(false))).booleanValue();
            Jf = Jf();
            Jc = Jc();
        } else {
            au.HU();
            longValue = ((Long) c.DT().get(a.sXC, Long.valueOf(0))).longValue();
            au.HU();
            booleanValue = ((Boolean) c.DT().get(a.sXF, Boolean.valueOf(false))).booleanValue();
            au.HU();
            Jf = ((Boolean) c.DT().get(a.sXE, Boolean.valueOf(false))).booleanValue();
            Jc = IZ();
        }
        if (bi.oW(Jc)) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            return false;
        } else if (booleanValue) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            return false;
        } else if (longValue2 < 0) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            return false;
        } else if (Jf && !Jg()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            return false;
        } else if (longValue == -1) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            return true;
        } else if (longValue2 + longValue > VE) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            return true;
        } else {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            return false;
        }
    }

    private void Jh() {
        synchronized (b.class) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Jj();
            }
        }
    }

    public final void Ji() {
        if (!Jg()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            au.HU();
            c.DT().a(a.sXG, Long.valueOf(bi.VE()));
            au.HU();
            c.DT().a(a.sXH, Boolean.valueOf(true));
            Jh();
        }
    }

    public final void b(b bVar) {
        if (bVar == b.dDY) {
            au.HU();
            c.DT().a(a.sXF, Boolean.valueOf(false));
        } else {
            au.HU();
            c.DT().a(a.sXz, Boolean.valueOf(false));
        }
        Jh();
    }

    public final void c(b bVar) {
        if (bVar == b.dDY) {
            au.HU();
            c.DT().a(a.sXC, Long.valueOf(0));
        } else if (bVar != b.dDZ) {
            return;
        } else {
            if (Jf()) {
                au.HU();
                c.DT().a(a.sXz, Boolean.valueOf(true));
            } else {
                au.HU();
                c.DT().a(a.sXw, Long.valueOf(0));
            }
        }
        Jh();
    }
}
