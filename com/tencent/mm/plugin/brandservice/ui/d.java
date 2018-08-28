package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a$a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d extends a {
    private static b hoi;
    String hoj;

    public d(Object obj) {
        super(1, obj);
    }

    public final b auQ() {
        if (hoi == null) {
            hoi = new 1(this);
        }
        return hoi;
    }

    public final a$a auR() {
        return new a();
    }

    public final void a(Context context, a$a a_a, Object... objArr) {
        if (this.data instanceof String) {
            this.hoj = (String) this.data;
        }
    }
}
