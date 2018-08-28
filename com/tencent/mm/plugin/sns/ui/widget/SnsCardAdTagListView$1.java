package com.tencent.mm.plugin.sns.ui.widget;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;

class SnsCardAdTagListView$1 implements OnPreDrawListener {
    final /* synthetic */ TextView omW;
    final /* synthetic */ View omX;
    final /* synthetic */ SnsCardAdTagListView omY;

    SnsCardAdTagListView$1(SnsCardAdTagListView snsCardAdTagListView, TextView textView, View view) {
        this.omY = snsCardAdTagListView;
        this.omW = textView;
        this.omX = view;
    }

    public final boolean onPreDraw() {
        if (!(this.omW.getLayout() == null || bi.K(this.omW.getLayout().getText()) || this.omW.getLayout().getText().charAt(0) != 8230)) {
            this.omY.removeView(this.omX);
            SnsCardAdTagListView.a(this.omY).remove(this.omX);
        }
        this.omY.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
