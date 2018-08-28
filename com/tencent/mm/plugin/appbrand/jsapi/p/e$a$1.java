package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class e$a$1 implements a {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ e.a gdl;

    e$a$1(e.a aVar, MMActivity mMActivity) {
        this.gdl = aVar;
        this.gdk = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        e.d(this.gdl.gdb).b(this.gdk, i, i2, intent);
    }
}
