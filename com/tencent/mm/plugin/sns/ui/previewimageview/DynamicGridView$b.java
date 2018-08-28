package com.tencent.mm.plugin.sns.ui.previewimageview;

import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.j;

class DynamicGridView$b implements j {
    static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
    final /* synthetic */ DynamicGridView omz;
    private int yA;
    private int yz;

    public DynamicGridView$b(DynamicGridView dynamicGridView, int i, int i2) {
        this.omz = dynamicGridView;
        this.yz = i;
        this.yA = i2;
    }

    public final void dJ(int i, int i2) {
        if ($assertionsDisabled || DynamicGridView.g(this.omz) != null) {
            this.omz.getViewTreeObserver().addOnPreDrawListener(new a(this, DynamicGridView.g(this.omz), i, i2));
            DynamicGridView.b(this.omz, this.omz.fr(DynamicGridView.h(this.omz)));
            return;
        }
        throw new AssertionError();
    }
}
