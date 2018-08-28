package com.tencent.mm.plugin.game.e;

import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void a(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfo");
        } else if (bi.oW(fVar.field_appId)) {
            x.e("MicroMsg.GameDataUtil", "Invalid appId");
        } else {
            boolean z;
            boolean l;
            String str = fVar.field_appId;
            f bl = g.bl(str, true);
            if (bl == null) {
                bl = new f();
                bl.field_appId = str;
                z = true;
            } else {
                z = false;
            }
            String chP = w.chP();
            if (chP.equals("zh_CN")) {
                bl.field_appName = fVar.field_appName;
            } else if (chP.equals("zh_TW") || chP.equals("zh_HK")) {
                bl.field_appName_tw = fVar.field_appName;
            } else {
                bl.field_appName_en = fVar.field_appName;
            }
            bl.field_appType = fVar.field_appType;
            bl.field_packageName = fVar.field_packageName;
            bl.di(fVar.cmE);
            bl.dl(fVar.cmJ);
            bl.eA(fVar.cmN);
            bl.dm(fVar.cmK);
            bl.dr(fVar.cmQ);
            bl.ds(fVar.cmR);
            bl.dp(fVar.cmO);
            bl.dq(fVar.cmP);
            bl.eB(fVar.cmT);
            if (!bi.oW(fVar.cmH)) {
                bl.dj(fVar.cmH);
            }
            if (z) {
                l = a.bmf().l(bl);
                com.tencent.mm.plugin.ac.a.a.a.bmm().Jp(str);
            } else if (bl.field_appVersion < fVar.field_appVersion) {
                x.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", Integer.valueOf(bl.field_appVersion), Integer.valueOf(fVar.field_appVersion));
                l = a.bmf().a(bl, new String[0]);
                com.tencent.mm.plugin.ac.a.a.a.bmm().Jp(str);
            } else {
                boolean z2 = (bl == null || bi.oW(bl.field_appIconUrl)) ? true : (fVar == null || bi.oW(fVar.field_appIconUrl)) ? false : !bl.field_appIconUrl.equals(fVar.field_appIconUrl);
                if (z2) {
                    x.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", bl.field_appIconUrl, fVar.field_appIconUrl);
                    bl.field_appIconUrl = fVar.field_appIconUrl;
                    l = a.bmf().a(bl, new String[0]);
                    a.bmd().cO(str, 1);
                    a.bmd().cO(str, 2);
                    a.bmd().cO(str, 3);
                    a.bmd().cO(str, 4);
                    a.bmd().cO(str, 5);
                } else {
                    l = a.bmf().a(bl, new String[0]);
                }
            }
            x.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", str, Boolean.valueOf(z), Boolean.valueOf(l));
        }
    }

    public static void S(LinkedList<? extends f> linkedList) {
        if (linkedList == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfos");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a((f) it.next());
        }
    }
}
