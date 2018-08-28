package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class bb$11 implements c {
    final /* synthetic */ bb ogl;

    bb$11(bb bbVar) {
        this.ogl = bbVar;
    }

    public final boolean aCi() {
        View childAt = this.ogl.kww.getChildAt(this.ogl.kww.getChildCount() - 1);
        if (childAt == null || childAt.getBottom() > this.ogl.kww.getHeight() || this.ogl.kww.getLastVisiblePosition() != this.ogl.kww.getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
