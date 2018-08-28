package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.model.bd.a;
import com.tencent.mm.ui.base.p;

class OpenBottleUI$3 implements a {
    final /* synthetic */ OpenBottleUI hmh;
    final /* synthetic */ p hmi;

    OpenBottleUI$3(OpenBottleUI openBottleUI, p pVar) {
        this.hmh = openBottleUI;
        this.hmi = pVar;
    }

    public final boolean Ip() {
        return OpenBottleUI.d(this.hmh);
    }

    public final void Io() {
        if (this.hmi != null) {
            this.hmi.dismiss();
        }
    }
}
