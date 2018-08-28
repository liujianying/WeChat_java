package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    private b uYH;
    private a uYI;

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(b bVar) {
        if (bVar != null) {
            this.uYH = bVar;
        }
    }

    public void setOnScrollListener(a aVar) {
        this.uYI = aVar;
    }

    public final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
    }

    public void onFocusChange(final View view, boolean z) {
        x.d("MicroMsg.MMScrollView", "onFocusChange:" + z);
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    MMScrollView.this.scrollTo(0, view.getTop() - a.fromDPToPix(MMScrollView.this.getContext(), 10));
                }
            }, 200);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(this.uYH == null || i2 == i4)) {
            this.uYH.jv(i2 < i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
