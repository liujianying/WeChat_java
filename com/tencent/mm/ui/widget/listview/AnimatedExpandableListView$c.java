package com.tencent.mm.ui.widget.listview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.d;

class AnimatedExpandableListView$c extends Animation {
    private int uKI;
    private int uKJ;
    private d uKK;
    private View view;

    private AnimatedExpandableListView$c(View view, int i, int i2, d dVar) {
        this.uKI = i;
        this.uKJ = i2 - i;
        this.view = view;
        this.uKK = dVar;
        this.view.getLayoutParams().height = i;
        this.view.requestLayout();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        int i;
        if (f < 1.0f) {
            i = this.uKI + ((int) (((float) this.uKJ) * f));
            this.view.getLayoutParams().height = i;
            this.uKK.uKN = i;
            this.view.requestLayout();
            return;
        }
        i = this.uKI + this.uKJ;
        this.view.getLayoutParams().height = i;
        this.uKK.uKN = i;
        this.view.requestLayout();
    }
}
