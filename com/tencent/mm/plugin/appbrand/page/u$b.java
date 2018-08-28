package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.u.a;
import java.lang.ref.WeakReference;

class u$b {
    WeakReference<View> gpb;
    public int gpc;
    boolean gpd;
    a gpe;
    int id;
    int z;

    public u$b(View view, int i, int i2, int i3, boolean z) {
        this.gpb = new WeakReference(view);
        this.id = i;
        this.gpc = i2;
        this.z = i3;
        this.gpd = z;
    }
}
