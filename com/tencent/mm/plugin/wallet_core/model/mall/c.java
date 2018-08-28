package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static c psl = null;
    public Map<String, MallNews> psm = new HashMap();

    public static c bPK() {
        if (psl == null) {
            psl = new c();
        }
        return psl;
    }

    private c() {
        Wj();
    }

    public final void Wj() {
        this.psm.clear();
        g.Ek();
        String str = (String) g.Ei().DT().get(270339, "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bi.F(str2.split(";"))) {
            MallNews Pg = Pg(str2);
            if (Pg != null) {
                this.psm.put(Pg.psc, Pg);
            }
        }
    }

    public final List<String> bPL() {
        List<String> arrayList = new ArrayList();
        for (MallNews mallNews : this.psm.values()) {
            if (!bi.oW(mallNews.bLe)) {
                arrayList.add(mallNews.bLe);
            }
        }
        x.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        g.Ek();
        List F = bi.F(((String) g.Ei().DT().get(a.sVG, "")).split(","));
        x.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[]{r0});
        if (mallNews == null) {
            return false;
        }
        if (bi.oW(mallNews.oqH)) {
            return false;
        }
        if (F.contains(mallNews.oqH)) {
            return true;
        }
        return false;
    }

    public static void c(MallFunction mallFunction) {
        try {
            if (!bi.oW(mallFunction.prU.oqH)) {
                g.Ek();
                List F = bi.F(((String) g.Ei().DT().get(a.sVG, "")).split(","));
                while (F.size() > 20) {
                    F.remove(0);
                }
                if (!F.contains(mallFunction.prU.oqH)) {
                    F.add(mallFunction.prU.oqH);
                    x.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[]{mallFunction.prU.oqH, bi.c(F, ",")});
                    g.Ek();
                    g.Ei().DT().a(a.sVG, r0);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
        }
    }

    public static void Pd(String str) {
        if (!bi.oW(str)) {
            Map z = bl.z(str, "sysmsg");
            if (z != null) {
                int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                String str2;
                int i2;
                if (i == 31) {
                    str2 = (String) z.get(".sysmsg.paymsg.WalletRedDotWording");
                    i2 = bi.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1);
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[]{str2, Integer.valueOf(bi.getInt((String) z.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(bi.getInt((String) z.get(".sysmsg.paymsg.LQTRedDot"), -1))});
                    g.Ek();
                    g.Ei().DT().a(a.sXL, str2);
                    g.Ek();
                    g.Ei().DT().a(a.sXM, Integer.valueOf(i2));
                    g.Ek();
                    g.Ei().DT().a(a.sXN, Integer.valueOf(r4));
                    g.Ek();
                    g.Ei().DT().a(a.sXO, Integer.valueOf(r1));
                    bPN();
                } else if (i == 34) {
                    Set<String> keySet = z.keySet();
                    x.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[]{str, keySet.toString()});
                    if (keySet.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (String str22 : keySet) {
                            if (str22.startsWith(".sysmsg.paymsg.reddot.item")) {
                                String str3 = (String) z.get(str22);
                                str22 = (String) z.get(str22 + ".$wording");
                                if (!bi.oW(str3)) {
                                    x.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s", new Object[]{str3, str22});
                                    if ("mainentry_me".equals(str3)) {
                                        g.Ek();
                                        g.Ei().DT().a(a.sZt, Boolean.valueOf(true));
                                    } else if ("entry_wxpay_wallet".equals(str3)) {
                                        g.Ek();
                                        g.Ei().DT().a(a.sZu, Boolean.valueOf(true));
                                        if (bi.oW(str22)) {
                                            g.Ek();
                                            g.Ei().DT().a(a.sZs, "");
                                        } else {
                                            g.Ek();
                                            g.Ei().DT().a(a.sZs, str22);
                                        }
                                    } else if ("entry_wxpay_paycenter".equals(str3)) {
                                        g.Ek();
                                        g.Ei().DT().a(a.sZo, Boolean.valueOf(true));
                                    } else {
                                        try {
                                            jSONObject.put(str3, 1);
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "put redDotConfig json failed: %s", new Object[]{e.getMessage()});
                                        }
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[]{jSONObject.toString()});
                        if (jSONObject.length() > 0) {
                            g.Ek();
                            g.Ei().DT().a(a.sZn, jSONObject.toString());
                            g.Ek();
                            g.Ei().DT().a(a.sZo, Boolean.valueOf(true));
                        }
                    }
                } else if (i == 36) {
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[]{(String) z.get(".sysmsg.paymsg.WalletRedDotWording"), Integer.valueOf(bi.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1)), Integer.valueOf(bi.getInt((String) z.get(".sysmsg.paymsg.LQBRedDot"), -1))});
                    g.Ek();
                    g.Ei().DT().a(a.sXL, str22);
                    g.Ek();
                    g.Ei().DT().a(a.sXM, Integer.valueOf(i2));
                    g.Ek();
                    g.Ei().DT().a(a.sXP, Integer.valueOf(r1));
                    bPN();
                }
            }
        }
    }

    public static void bPM() {
        g.Ek();
        g.Ei().DT().a(a.sXL, "");
        g.Ek();
        g.Ei().DT().a(a.sXM, Integer.valueOf(-1));
    }

    public static void bPN() {
        x.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.s.c.Cp().aV(262156, 266248);
    }

    public final boolean bna() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.psm.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.psm.keySet()) {
            if (!bi.oW(str)) {
                MallNews mallNews = (MallNews) this.psm.get(str);
                stringBuffer.append(mallNews.psj.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.psa + "</showflag><newsTipFlag>" + mallNews.psb + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Ek();
        g.Ei().DT().set(270339, stringBuffer.toString());
        return true;
    }

    public final String Pe(String str) {
        MallNews mallNews = (MallNews) this.psm.get(str);
        if (mallNews == null || bi.oW(mallNews.bLe)) {
            return null;
        }
        return mallNews.bLe;
    }

    public final MallNews Pf(String str) {
        x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
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

    public static MallNews Pg(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivity.functionid"));
            mallNews.oqH = (String) z.get(".sysmsg.mallactivity.activityid");
            mallNews.bLe = (String) z.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) z.get(".sysmsg.mallactivity.type");
            mallNews.showType = bi.getInt((String) z.get(".sysmsg.mallactivity.showtype"), 0);
            if (z.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.psa = (String) z.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.psa = "0";
            }
            if (z.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.psb = (String) z.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.psb = "0";
            }
            mallNews.psj = str;
            if (bi.oW(mallNews.psc)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            x.e("MicroMsg.MallNewsManager", "cmdid error");
            return null;
        }
    }

    public final void Q(ArrayList<MallFunction> arrayList) {
        if (arrayList != null) {
            Set<String> hashSet = new HashSet(this.psm.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).moy);
            }
            for (String remove : hashSet) {
                this.psm.remove(remove);
            }
            bna();
        }
    }
}
