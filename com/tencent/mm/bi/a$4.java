package com.tencent.mm.bi;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.mm.bd.a.e;

class a$4 implements AnimationListener {
    final /* synthetic */ a qVu;

    a$4(a aVar) {
        this.qVu = aVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.qVu.qVl.getSelectedFeatureListener().aD(false);
    }

    public final void onAnimationEnd(Animation animation) {
        ((EditText) this.qVu.qVl.getTextEditView().findViewById(e.text_edit)).setText("");
        this.qVu.qVl.getTextEditView().setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
