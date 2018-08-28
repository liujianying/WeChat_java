package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.az.a;

class i$2 implements a {
    final /* synthetic */ i hkf;

    i$2(i iVar) {
        this.hkf = iVar;
    }

    public final void a(ai aiVar, az azVar) {
        if (aiVar != null) {
            if ("_USER_FOR_THROWBOTTLE_".equals(aiVar.field_username)) {
                aiVar.setUsername("");
            } else if (1 != aiVar.field_isSend && ab.gY(aiVar.field_username) && !azVar.Cp(aiVar.field_username)) {
                c.wV(aiVar.field_username);
            }
        }
    }
}
