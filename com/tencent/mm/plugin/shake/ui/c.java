package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;

final class c {
    al bAZ = new al(new a() {
        public final boolean vD() {
            c.this.bvj();
            return false;
        }
    }, false);
    View view;

    public c(View view) {
        this.view = view;
    }

    public final void bvj() {
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
    }
}
