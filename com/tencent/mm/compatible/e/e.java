package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import com.tencent.mm.compatible.e.d.a;

final class e implements a {
    e() {
    }

    public static d$a$a zg() {
        d$a$a d_a_a = new d$a$a();
        try {
            d_a_a.ddt = Camera.open();
            d_a_a.bYE = 0;
            if (d_a_a.ddt == null) {
                return null;
            }
            return d_a_a;
        } catch (Exception e) {
            return null;
        }
    }
}
