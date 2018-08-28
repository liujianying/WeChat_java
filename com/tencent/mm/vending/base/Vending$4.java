package com.tencent.mm.vending.base;

import com.tencent.mm.vending.f.a;

class Vending$4 implements c$a {
    final /* synthetic */ Vending uQd;

    Vending$4(Vending vending) {
        this.uQd = vending;
    }

    public final void cBy() {
        a.i("Vending", "%s beforeSynchronize", new Object[]{this.uQd});
        Vending.access$300(this.uQd).cBA();
    }

    public final void synchronizing(int i, Object obj) {
        a.i("Vending", "%s synchronizing", new Object[]{this.uQd});
        this.uQd.mVendingDeferring.clear();
        Vending.access$300(this.uQd).cBA();
        Vending.access$400(this.uQd).removeCallbacksAndMessages(null);
        if (i == 2) {
            obj = this.uQd.prepareVendingDataAsynchronous();
        }
        if (i == 2 || i == 1) {
            this.uQd.applyChangeSynchronized(obj);
        }
        this.uQd.synchronizing(i, obj);
        Vending.access$500(this.uQd).clear();
    }

    public final void cBz() {
        a.i("Vending", "%s afterSynchronize", new Object[]{this.uQd});
        if (Vending.access$600(this.uQd) != null) {
            Vending.access$600(this.uQd).cBC();
        }
    }
}
