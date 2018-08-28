package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.al.a;

class s$1 implements a {
    final /* synthetic */ s tyl;

    s$1(s sVar) {
        this.tyl = sVar;
    }

    public final boolean vD() {
        if (s.a(this.tyl) == -1) {
            this.tyl.show();
            return true;
        }
        s.b(this.tyl);
        if (s.c(this.tyl) >= 0) {
            this.tyl.show();
            return true;
        }
        this.tyl.cancel();
        return false;
    }
}
