package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;

class j$a implements i<Bundle, Bundle> {
    private j$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        Bundle bundle = (Bundle) obj;
        j$b j_b = new j$b();
        j_b.fromBundle(bundle);
        j.a(j.aeV()).put(j_b.fuL, j_b);
        return bundle;
    }
}
