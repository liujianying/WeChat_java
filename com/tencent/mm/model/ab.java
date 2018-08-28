package com.tencent.mm.model;

import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;

public final class ab {
    public static void HA() {
        for (com.tencent.mm.storage.ab abVar : s.Hu()) {
            if (!(abVar == null || ((int) abVar.dhP) == 0 || abVar.field_showHead != 32)) {
                abVar.eD(abVar.AY());
                x.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + abVar.field_username);
                au.HU();
                c.FR().a(abVar.field_username, abVar);
            }
        }
        for (String str : s.dAV) {
            com.tencent.mm.storage.ab Yg = c.FR().Yg(str);
            if (Yg != null && (((int) Yg.dhP) != 0 || a.gd(Yg.field_type))) {
                Yg.Bk();
                c.FR().a(str, Yg);
            }
        }
    }
}
