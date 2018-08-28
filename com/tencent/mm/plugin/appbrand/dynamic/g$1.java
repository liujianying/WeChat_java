package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.network.n.a;

class g$1 extends a {
    g$1() {
    }

    public final void ev(int i) {
        Parcelable bundle = new Bundle();
        bundle.putInt("status", i);
        for (String a : i.aeT().aeU()) {
            f.a(a, bundle, g$a.class, null);
        }
    }
}
