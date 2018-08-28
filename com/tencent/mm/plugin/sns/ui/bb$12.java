package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class bb$12 implements d {
    final /* synthetic */ bb ogl;

    bb$12(bb bbVar) {
        this.ogl = bbVar;
    }

    public final boolean aCh() {
        View childAt = this.ogl.kww.getChildAt(this.ogl.kww.getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            return false;
        }
        return true;
    }
}
