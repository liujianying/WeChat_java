package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.plugin.appbrand.dynamic.a.b.a;

class b$3 implements Runnable {
    final /* synthetic */ b fvl;

    b$3(b bVar) {
        this.fvl = bVar;
    }

    public final void run() {
        if (g.fF("com.tencent.mm:support")) {
            Parcelable bundle = new Bundle();
            bundle.putBoolean("forceKillProcess", true);
            f.a("com.tencent.mm:support", bundle, a.class, new 1(this));
        }
    }
}
