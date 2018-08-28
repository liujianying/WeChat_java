package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g extends a {
    private static b hoi;

    public g(Object obj) {
        super(0, obj);
        this.tDC = true;
    }

    public final b auQ() {
        if (hoi == null) {
            hoi = new 1(this);
        }
        return hoi;
    }

    public final a.a auR() {
        return new a();
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
    }
}
