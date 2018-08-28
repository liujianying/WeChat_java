package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;

class a$3 implements a {
    a$3() {
    }

    public final void a(e eVar) {
        if (eVar != null && eVar.Lr() != null) {
            if (a.bO() != null) {
                eVar.Lr().h("offline_token", a.bO().getBytes());
            }
            if (a.lMH != null) {
                eVar.Lr().h("offline_token_V2", a.lMH.getBytes());
            }
            if (a.lMK != null) {
                eVar.Lr().h("offline_key_list", a.lMK.getBytes());
            }
        }
    }
}
