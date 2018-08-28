package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;

class h$8 implements c {
    final /* synthetic */ String dEt;
    final /* synthetic */ ArrayList dha;

    h$8(String str, ArrayList arrayList) {
        this.dEt = str;
        this.dha = arrayList;
    }

    public final void a(l lVar) {
        lVar.setHeaderTitle(this.dEt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dha.size()) {
                lVar.e(i2, (CharSequence) this.dha.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
