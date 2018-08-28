package com.tencent.mm.plugin.sns.ui.previewimageview;

import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.j;

class DynamicGridView$i implements j {
    final /* synthetic */ DynamicGridView omz;
    private int yA;
    private int yz;

    public DynamicGridView$i(DynamicGridView dynamicGridView, int i, int i2) {
        this.omz = dynamicGridView;
        this.yz = i;
        this.yA = i2;
    }

    public final void dJ(int i, int i2) {
        DynamicGridView.a(this.omz, DynamicGridView.e(this.omz) + this.yA);
        DynamicGridView.b(this.omz, DynamicGridView.f(this.omz) + this.yz);
    }
}
