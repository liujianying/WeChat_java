package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a;

class a$1 implements OnDismissListener {
    final /* synthetic */ a gJP;

    a$1(a aVar) {
        this.gJP = aVar;
    }

    public final void onDismiss() {
        if (a.a(this.gJP) != null && !a.b(this.gJP)) {
            a.a(this.gJP).a("", a.gKy);
        }
    }
}
