package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;

class j$1 extends k {
    final /* synthetic */ j qla;

    j$1(j jVar) {
        this.qla = jVar;
    }

    public final boolean c(int i, Bundle bundle) {
        if (this.qla.qkY != null) {
            return this.qla.qkY.c(i, bundle);
        }
        return super.c(i, bundle);
    }

    public final void P(Bundle bundle) {
        if (this.qla.qkY instanceof e) {
            ((e) this.qla.qkY).Jn();
        } else {
            super.P(bundle);
        }
    }
}
