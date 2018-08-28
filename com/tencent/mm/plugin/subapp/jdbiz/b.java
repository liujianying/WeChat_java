package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class b implements a {
    public String bWW = "";
    public long eiD = 0;
    public String iconUrl = "";
    public String jumpUrl = "";
    public String oqG = "";
    public String oqH = "";
    public boolean oqI = false;
    public boolean oqJ = false;
    public String oqK = "";
    public String oqL = "";
    public long oqM;
    public long oqN;
    public long oqO;
    public long oqP;
    public String oqQ = "";
    public String oqR = "";
    public String oqS = "";
    public String oqT = "";
    public long startTime;
    public String title = "";

    public static b bFY() {
        au.HU();
        String str = (String) c.DT().get(327942, "");
        b bVar = new b();
        x.i("MicroMsg.JdMsgContent", " create xml : " + str);
        bVar.MU(str);
        return bVar;
    }

    public final void MU(String str) {
        this.oqG = "";
        this.oqH = "";
        this.eiD = 0;
        this.oqK = "";
        this.oqI = false;
        this.oqJ = false;
        this.oqR = "";
        this.oqS = "";
        this.oqT = "";
        this.oqQ = "";
        this.jumpUrl = "";
        this.bWW = "";
        this.bWW = str;
        if (!bi.oW(str)) {
            x.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[]{str});
            Map z = bl.z(str, "sysmsg");
            if (z != null) {
                this.oqG = bi.aG((String) z.get(".sysmsg.biztype"), "");
                this.oqQ = bi.aG((String) z.get(".sysmsg.alert"), "");
                this.oqH = bi.aG((String) z.get(".sysmsg.activityid"), "");
                this.startTime = bi.WV((String) z.get(".sysmsg.starttime"));
                this.eiD = bi.WV((String) z.get(".sysmsg.expiretime"));
                this.title = bi.aG((String) z.get(".sysmsg.content.title"), "");
                this.iconUrl = bi.aG((String) z.get(".sysmsg.content.icon"), "");
                this.jumpUrl = bi.aG((String) z.get(".sysmsg.content.jumpurl"), "");
                this.oqM = bi.WV((String) z.get(".sysmsg.content.urlstarttime"));
                this.oqN = bi.WV((String) z.get(".sysmsg.content.urlexpiretime"));
                this.oqK = bi.aG((String) z.get(".sysmsg.content.jdcelltitle"), "");
                this.oqL = bi.aG((String) z.get(".sysmsg.content.jdcellicon"), "");
                this.oqO = bi.WV((String) z.get(".sysmsg.content.titlestarttime"));
                this.oqP = bi.WV((String) z.get(".sysmsg.content.titleexpiretime"));
                this.oqI = "1".equals(z.get(".sysmsg.content.findshowreddot"));
                this.oqJ = "1".equals(z.get(".sysmsg.content.jdcellshowred"));
                this.oqR = bi.aG((String) z.get(".sysmsg.content.alertviewtitle"), "");
                this.oqS = bi.aG((String) z.get(".sysmsg.content.alertviewconfirm"), "");
                this.oqT = bi.aG((String) z.get(".sysmsg.content.alertviewcancel"), "");
            }
        }
    }

    public final boolean aiS() {
        return this.startTime < System.currentTimeMillis() / 1000;
    }

    public final boolean bFZ() {
        return this.eiD != 0 && this.eiD < System.currentTimeMillis() / 1000;
    }

    public final boolean a(b bVar) {
        if (bVar != null && bi.aG(this.oqH, "").equals(bi.aG(bVar.oqH, ""))) {
            return false;
        }
        return true;
    }

    public final String bGa() {
        return bi.aG(this.bWW, "");
    }

    public final String bGb() {
        return this.oqH;
    }

    public final String bGc() {
        return this.oqK;
    }

    public final boolean bGd() {
        return this.oqJ;
    }

    public final String bGe() {
        return this.oqG;
    }

    public final String bGf() {
        return this.jumpUrl;
    }
}
