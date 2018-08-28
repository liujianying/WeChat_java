package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.h;

class b$b implements i<ContentValues, Bundle> {
    private b$b() {
    }

    public final /* synthetic */ Object av(Object obj) {
        ContentValues contentValues = (ContentValues) obj;
        h abj = ((a) g.l(a.class)).abj();
        com.tencent.mm.plugin.appbrand.widget.g a = b.a(contentValues);
        boolean b = (a == null || (a.sKx > 0 && abj.a(a))) ? false : abj.b(a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", b);
        return bundle;
    }
}
