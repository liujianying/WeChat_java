package com.tencent.mm.plugin.collect.b;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.w$b;
import com.tencent.mm.sdk.platformtools.c;

class c$1 implements w$b {
    final /* synthetic */ c hTK;

    c$1(c cVar) {
        this.hTK = cVar;
    }

    public final Bitmap oO(String str) {
        return c.decodeFile(str, null);
    }
}
