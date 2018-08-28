package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d psn = null;
    public Map<String, MallNews> psm = new HashMap();

    public static d bPO() {
        if (psn == null) {
            psn = new d();
        }
        return psn;
    }

    private d() {
        Wj();
    }

    public final void Wj() {
        this.psm.clear();
        g.Ek();
        String str = (String) g.Ei().DT().get(270341, "");
        x.d("MicroMsg.MallNewsManagerNewVersion", "data : " + str);
        for (String str2 : bi.F(str2.split(";"))) {
            MallNews Pg = Pg(str2);
            if (Pg != null) {
                this.psm.put(Pg.psc, Pg);
            }
        }
    }

    public final boolean bna() {
        x.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.psm.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.psm.keySet()) {
            if (!bi.oW(str)) {
                MallNews mallNews = (MallNews) this.psm.get(str);
                stringBuffer.append(mallNews.psj.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.oqH + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.psa + "</showflag><newsTipFlag>" + mallNews.psb + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        x.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        g.Ek();
        g.Ei().DT().set(270341, stringBuffer.toString());
        return true;
    }

    public final MallNews Ph(String str) {
        return (MallNews) this.psm.get(str);
    }

    public final MallNews Pf(String str) {
        x.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : " + str);
        if (bi.oW(str) || !this.psm.containsKey(str)) {
            return null;
        }
        MallNews mallNews = (MallNews) this.psm.get(str);
        if (!"0".equals(mallNews.psa)) {
            return mallNews;
        }
        mallNews.psa = "1";
        bna();
        return mallNews;
    }

    private static MallNews Pg(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.oqH = (String) z.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) z.get(".sysmsg.mallactivitynew.type");
            mallNews.showType = bi.getInt((String) z.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (z.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.psa = (String) z.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.psa = "0";
            }
            if (z.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.psb = (String) z.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.psb = "0";
            }
            mallNews.psj = str;
            if (bi.oW(mallNews.psc)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            x.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            return null;
        }
    }
}
