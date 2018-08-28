package com.tencent.mm.view.a;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.plugin.gif.g;

class c$3 implements l {
    final /* synthetic */ c uTM;

    c$3(c cVar) {
        this.uTM = cVar;
    }

    public final Bitmap K(byte[] bArr) {
        return g.ay(bArr);
    }

    public final Bitmap mf(String str) {
        return g.ay(e.e(str, 0, e.cm(str)));
    }
}
