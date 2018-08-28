package com.tencent.mm.graphics.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.graphics.b.d;

class WxBaseImageView$1 implements OnAttachStateChangeListener {
    final /* synthetic */ WxBaseImageView djS;

    WxBaseImageView$1(WxBaseImageView wxBaseImageView) {
        this.djS = wxBaseImageView;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        d.djo.Cl();
        WxBaseImageView.a(this.djS);
    }
}
