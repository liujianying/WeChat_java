package android.support.design.widget;

import android.support.v4.view.z;
import android.view.View;

class s$b implements Runnable {
    final /* synthetic */ s hf;
    private final boolean hg;
    private final View mView;

    s$b(s sVar, View view, boolean z) {
        this.hf = sVar;
        this.mView = view;
        this.hg = z;
    }

    public final void run() {
        if (s.b(this.hf) != null && s.b(this.hf).cX()) {
            z.a(this.mView, this);
        } else if (this.hg && s.a(this.hf) != null) {
            s.a(this.hf).onDismiss(this.mView);
        }
    }
}
