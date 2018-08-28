package com.tencent.mm.ao;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bh;
import java.util.Map;

public final class e implements m {
    public final b a(String str, Map<String, String> map, a aVar) {
        x.d("dancy", "dancy consumeNewXml， subType:%s", new Object[]{str});
        if (bi.oV(str).equals("newtips") && map != null) {
            bh bhVar;
            com.tencent.mm.plugin.ab.a.bji();
            if (map == null) {
                x.e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
                bhVar = null;
            } else {
                long VE = bi.VE();
                bh bhVar2 = new bh();
                bhVar2.field_tipId = bi.getInt((String) map.get(".sysmsg.newtips.control.tips_id"), 0);
                bhVar2.field_tipVersion = bi.getInt((String) map.get(".sysmsg.newtips.control.tips_version"), 0);
                bhVar2.field_tipType = bi.getInt((String) map.get(".sysmsg.newtips.control.tips_type"), 0);
                bhVar2.field_beginShowTime = Math.max(bi.getLong((String) map.get(".sysmsg.newtips.control.begin_time"), 0), VE);
                bhVar2.field_overdueTime = bi.getLong((String) map.get(".sysmsg.newtips.control.overdue_time"), 0);
                bhVar2.field_disappearTime = bi.getLong((String) map.get(".sysmsg.newtips.control.disappear_time"), 0);
                if (map.get(".sysmsg.newtips.control.tips_showInfo") != null) {
                    bhVar2.field_tipsShowInfo = new btb();
                    bhVar2.field_tipsShowInfo.showType = bi.getInt((String) map.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
                    bhVar2.field_tipsShowInfo.title = (String) map.get(".sysmsg.newtips.control.tips_showInfo.title");
                    bhVar2.field_tipsShowInfo.lMY = (String) map.get(".sysmsg.newtips.control.tips_showInfo.icon_url");
                    bhVar2.field_tipsShowInfo.path = (String) map.get(".sysmsg.newtips.control.tips_showInfo.path");
                }
                bhVar2.field_extInfo = (String) map.get(".sysmsg.newtips.control.tips_showInfo.");
                com.tencent.mm.plugin.ab.a.bjj().Do(bhVar2.field_tipId);
                com.tencent.mm.plugin.ab.a.bjk();
                Object obj = (c.a(bhVar2) && c.b(bhVar2) && c.c(bhVar2) && !bhVar2.field_isReject) ? 1 : null;
                if (obj != null) {
                    bhVar2.field_isExit = true;
                    com.tencent.mm.plugin.ab.a.bjj().a(bhVar2, new String[0]);
                }
                bhVar = bhVar2;
            }
            if (bhVar != null) {
                int i;
                int i2 = bhVar.field_tipId;
                int i3 = bhVar.field_tipVersion;
                int i4 = bhVar.field_tipType;
                ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", bi.VF()).commit();
                int i5 = bhVar.field_tipsShowInfo != null ? bhVar.field_tipsShowInfo.showType : 0;
                String str2 = bhVar.field_tipsShowInfo != null ? bhVar.field_tipsShowInfo.title : "";
                String str3 = bhVar.field_tipsShowInfo != null ? bhVar.field_tipsShowInfo.lMY : "";
                String str4 = bhVar.field_tipsShowInfo != null ? bhVar.field_tipsShowInfo.path : "";
                com.tencent.mm.plugin.ab.a.bjk();
                if (!c.b(bhVar)) {
                    i = 2;
                } else if (!c.c(bhVar)) {
                    i = 3;
                } else if (c.a(bhVar)) {
                    bh Do = com.tencent.mm.plugin.ab.a.bjj().Do(bhVar.field_tipId);
                    Object obj2 = (Do == null || bhVar.field_tipType != Do.field_tipType) ? null : 1;
                    if (obj2 == null) {
                        i = 5;
                    } else {
                        i = (com.tencent.mm.plugin.ab.a.bjj().Do(bhVar.field_tipId) != null ? 1 : null) == null ? 6 : bhVar.field_isReject ? 7 : 0;
                    }
                } else {
                    i = 4;
                }
                h.mEJ.h(14995, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(r12), "", "", "", "", "", "", "", Integer.valueOf(i5), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(b.ebz), ""});
                d.a aVar2 = com.tencent.mm.plugin.ab.a.bji().ebC;
                if (aVar2 != null) {
                    com.tencent.mm.plugin.ab.a.bjk();
                    if (c.d(bhVar)) {
                        x.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[]{Boolean.valueOf(bhVar.field_isExit), Long.valueOf(bhVar.field_beginShowTime)});
                        aVar2.e(bhVar);
                    }
                }
            }
        }
        return null;
    }
}
