package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;

public class f$a implements a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        if (bundle.getBoolean("isOpenWeappFial", false)) {
            f.aeS().ax(f.sy(bundle.getString("sceneNote")), bundle.getInt("widgetState") + 3000);
            return;
        }
        f.aeS().ax(bundle.getString("id"), bundle.getInt("widgetState"));
    }
}
