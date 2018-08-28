package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.s.a;
import com.tencent.mm.plugin.game.model.s.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class z {
    public static z jNy;

    public static z aUg() {
        if (jNy == null) {
            jNy = new z();
        }
        return jNy;
    }

    static void c(Map<String, String> map, s sVar) {
        String str = ".sysmsg.gamecenter.jump_info.jump";
        sVar.jMw.clear();
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                String str3 = (String) map.get(str2 + ".$id");
                d dVar = new d();
                dVar.jNj = bi.getInt((String) map.get(str2 + ".jump_type"), 0);
                dVar.iCI = bi.aG((String) map.get(str2 + ".jump_url"), "");
                if (!bi.oW(str3)) {
                    sVar.jMw.put(str3, dVar);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void d(Map<String, String> map, s sVar) {
        sVar.jNa = bi.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        sVar.jNb = bi.aG((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
    }

    public static void e(Map<String, String> map, s sVar) {
        boolean z;
        boolean z2 = true;
        sVar.jMI.url = bi.aG((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        a aVar = sVar.jMI;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.jMc = z;
        sVar.jMI.orientation = bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        aVar = sVar.jMI;
        if (bi.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.jNf = z2;
    }
}
