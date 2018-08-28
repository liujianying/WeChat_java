package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.ui.base.l;

public abstract class a {
    public int gjO;

    public abstract void a(Context context, p pVar, l lVar, String str);

    public abstract void a(Context context, p pVar, String str, k kVar);

    public a(int i) {
        this.gjO = i;
    }
}
