package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.bd.a;

class e$3 implements a {
    final /* synthetic */ e lVZ;

    e$3(e eVar) {
        this.lVZ = eVar;
    }

    public final boolean Ip() {
        return this.lVZ.isDeleteCancel;
    }

    public final void Io() {
        if (this.lVZ.tipDialog != null) {
            this.lVZ.tipDialog.dismiss();
            this.lVZ.tipDialog = null;
        }
    }
}
