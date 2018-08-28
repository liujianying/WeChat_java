package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.u.c.e.a;

class a$1 implements a {
    a$1() {
    }

    public final void C(String str, int i) {
        Parcelable bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("status", i);
        f.a("com.tencent.mm", bundle, a.a.class, null);
    }
}
