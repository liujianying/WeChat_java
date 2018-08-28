package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.sdk.platformtools.c;

class c$1 implements b {
    final /* synthetic */ c pzQ;

    c$1(c cVar) {
        this.pzQ = cVar;
    }

    public final Bitmap oO(String str) {
        return c.decodeFile(str, null);
    }
}
