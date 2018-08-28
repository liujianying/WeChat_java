package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.s.a;
import com.tencent.mm.plugin.game.model.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class u {
    public static String B(Map<String, String> map) {
        return bi.aG((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
    }

    static void a(Map<String, String> map, s sVar) {
        sVar.jMr.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                h hVar = new h();
                hVar.userName = bi.aG((String) map.get(str2 + ".username"), "");
                hVar.bgn = bi.aG((String) map.get(str2 + ".nickname"), "");
                hVar.jNp = bi.aG((String) map.get(str2 + ".usericon"), "");
                hVar.jNr = bi.aG((String) map.get(str2 + ".badge_icon"), "");
                hVar.jNs = bi.aG((String) map.get(str2 + ".$jump_id"), "");
                sVar.jMr.add(hVar);
                i++;
            } else {
                return;
            }
        }
    }

    public static long C(Map<String, String> map) {
        return bi.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
    }

    public static void b(Map<String, String> map, s sVar) {
        boolean z;
        boolean z2 = true;
        sVar.jMI.url = bi.aG((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        a aVar = sVar.jMI;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.jMc = z;
        sVar.jMI.orientation = bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        aVar = sVar.jMI;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.jNf = z2;
    }
}
