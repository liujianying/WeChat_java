package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.v.g;
import java.lang.ref.WeakReference;

public final class h {
    public final SparseArray<c> gGJ;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$4 */
    class AnonymousClass4 implements aa {
        final /* synthetic */ WeakReference fQJ;
        final /* synthetic */ int fQL;

        public AnonymousClass4(WeakReference weakReference, int i) {
            this.fQJ = weakReference;
            this.fQL = i;
        }

        public final void lW(int i) {
            try {
                p pVar = (p) this.fQJ.get();
                if (pVar != null) {
                    pVar.j("onKeyboardShow", g.Dc().D("inputId", this.fQL).D("height", f.lO(i)).toString(), 0);
                }
            } catch (Exception e) {
            }
        }
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.gGJ = new SparseArray();
    }
}
