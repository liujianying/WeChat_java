package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.g;

final class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
    a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        ((g) com.tencent.mm.kernel.g.l(g.class)).d(bundle.getInt("action"), bundle);
    }
}
