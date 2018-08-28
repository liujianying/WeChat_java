package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;

class a$2 implements c<Bundle> {
    final /* synthetic */ a$e fxG;

    public a$2(a$e a_e) {
        this.fxG = a_e;
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.fxG != null) {
            this.fxG.T(bundle.getString("appId"), bundle.getBoolean("result"));
        }
    }
}
