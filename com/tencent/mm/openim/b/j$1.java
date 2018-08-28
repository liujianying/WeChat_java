package com.tencent.mm.openim.b;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;

class j$1 implements g {
    final /* synthetic */ j euA;
    final /* synthetic */ j$a euz;

    j$1(j jVar, j$a j_a) {
        this.euA = jVar;
        this.euz = j_a;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.status == 0 && bVar.bitmap != null && !bVar.bitmap.isRecycled()) {
            this.euz.bitmap = bVar.bitmap;
        }
    }
}
