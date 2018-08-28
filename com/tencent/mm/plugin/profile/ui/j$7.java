package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.bd.a;
import com.tencent.mm.ui.base.p;

class j$7 implements a {
    final /* synthetic */ p hmi;

    j$7(p pVar) {
        this.hmi = pVar;
    }

    public final boolean Ip() {
        return j.access$200();
    }

    public final void Io() {
        if (this.hmi != null) {
            this.hmi.dismiss();
        }
    }
}
