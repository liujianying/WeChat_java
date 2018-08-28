package com.tencent.mm.bi;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.mm.bd.a.e;
import com.tencent.mm.view.footer.SelectColorBar;

class a$3 implements AnimationListener {
    final /* synthetic */ a qVu;

    a$3(a aVar) {
        this.qVu = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.qVu.qVl.getTextEditView().setVisibility(0);
        EditText editText = (EditText) this.qVu.qVl.getTextEditView().findViewById(e.text_edit);
        editText.requestFocus();
        editText.setSelection(editText.length());
        this.qVu.qVl.getSelectedFeatureListener().aD(true);
        ((SelectColorBar) this.qVu.qVl.findViewById(e.select_color_bar)).setSelectColor(editText.getCurrentTextColor());
        this.qVu.qVl.getActionBar().post(new 1(this));
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
