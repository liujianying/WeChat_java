package com.tencent.mm.ui;

import com.tencent.mm.g.a.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class z$1 extends c<an> {
    final /* synthetic */ z too;

    z$1(z zVar) {
        this.too = zVar;
        this.sFo = an.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = ((an) bVar).bHV.index;
        if (i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.too.ZS("tab_main");
                    break;
                case 1:
                    this.too.ZS("tab_address");
                    break;
                case 2:
                    this.too.ZS("tab_find_friend");
                    break;
                case 3:
                    this.too.ZS("tab_settings");
                    break;
            }
        }
        return false;
    }
}
