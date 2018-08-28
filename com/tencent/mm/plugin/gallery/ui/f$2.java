package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements a {
    final /* synthetic */ f jEt;
    final /* synthetic */ f$a jEx;

    f$2(f fVar, f$a f_a) {
        this.jEt = fVar;
        this.jEx = f_a;
    }

    public final void aRO() {
        x.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[]{Integer.valueOf(this.jEx.jBN.getWidth()), Integer.valueOf(this.jEx.jBN.getHeight())});
    }
}
