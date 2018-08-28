package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.b;
import java.util.HashMap;

class Vending$g<K, V> extends HashMap<K, V> {
    b uQo = null;

    Vending$g() {
    }

    public final void clear() {
        super.clear();
        if (this.uQo != null) {
            this.uQo.cBx();
        }
    }
}
