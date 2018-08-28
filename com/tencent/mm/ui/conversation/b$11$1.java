package com.tencent.mm.ui.conversation;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.ui.conversation.b.11;

class b$11$1 implements a {
    final /* synthetic */ 11 unH;

    b$11$1(11 11) {
        this.unH = 11;
    }

    public final boolean Ip() {
        return this.unH.unC.value || this.unH.hsv == null || !this.unH.hsv.isShowing();
    }

    public final void Io() {
        e.D(this.unH.tif, false);
        if (this.unH.hsv != null) {
            this.unH.hsv.dismiss();
        }
    }
}
