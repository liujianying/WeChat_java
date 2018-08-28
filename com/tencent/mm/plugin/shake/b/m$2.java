package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.s;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.az.a;

class m$2 implements a {
    final /* synthetic */ m mXg;

    m$2(m mVar) {
        this.mXg = mVar;
    }

    public final void a(ai aiVar, az azVar) {
        if (aiVar != null && s.hI(aiVar.field_username)) {
            aiVar.setUsername("");
        }
    }
}
