package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class h$2 implements c {
    final /* synthetic */ String dEt;
    final /* synthetic */ List nNJ;
    final /* synthetic */ List nNf;
    final /* synthetic */ String ttu;

    h$2(String str, List list, List list2, String str2) {
        this.dEt = str;
        this.nNJ = list;
        this.nNf = list2;
        this.ttu = str2;
    }

    public final void a(l lVar) {
        if (!bi.oW(this.dEt)) {
            lVar.setHeaderTitle(this.dEt);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.nNJ.size()) {
                break;
            }
            lVar.e(((Integer) this.nNf.get(i2)).intValue(), (CharSequence) this.nNJ.get(i2));
            i = i2 + 1;
        }
        if (!bi.oW(this.ttu)) {
            lVar.e(-1, this.ttu);
        }
    }
}
