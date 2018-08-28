package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.ui.widget.b.a;

class a$d$1 extends a {
    final /* synthetic */ d gzn;

    a$d$1(d dVar, Context context) {
        this.gzn = dVar;
        super(context);
    }

    public final boolean bU(int i, int i2) {
        if (this.gzn.SU.getParent() != null) {
            this.gzn.SU.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.bU(i, i2);
    }

    public final void onDismiss() {
        if (this.gzn.SU.getParent() != null) {
            this.gzn.SU.getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.onDismiss();
    }
}
