package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.i;
import com.tencent.mm.vending.f.a;

class Vending$7 implements a<_Index> {
    final /* synthetic */ Vending uQd;

    Vending$7(Vending vending) {
        this.uQd = vending;
    }

    public final void cs(_Index _index) {
        i lock = this.uQd.getLock(_index);
        boolean access$1100 = Vending.access$1100(this.uQd, lock, _index);
        if (lock.uPP) {
            a.d("Vending", "This lock is defer to return %s %s", new Object[]{lock, _index});
        } else if (!access$1100) {
            Vending.access$1300(this.uQd, lock);
        }
    }

    public final void cancel() {
        this.uQd.loaderClear();
        Vending.access$200(this.uQd);
    }
}
