package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import java.lang.ref.WeakReference;

class d$a implements c {
    private WeakReference<a> fnd;

    d$a(a aVar) {
        this.fnd = new WeakReference(aVar);
    }

    public final void invalidate() {
        a aVar = (a) this.fnd.get();
        if (aVar != null) {
            aVar.adk();
        }
    }
}
