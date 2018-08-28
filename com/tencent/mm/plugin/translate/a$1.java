package com.tencent.mm.plugin.translate;

import android.util.SparseArray;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.c;

class a$1 implements a {
    final /* synthetic */ a oEl;

    a$1(a aVar) {
        this.oEl = aVar;
    }

    public final void a(int i, SparseArray<c> sparseArray) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < sparseArray.size()) {
                c cVar = (c) sparseArray.valueAt(i3);
                if (cVar != null) {
                    this.oEl.oEh.c(new 1(this, i, cVar));
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
