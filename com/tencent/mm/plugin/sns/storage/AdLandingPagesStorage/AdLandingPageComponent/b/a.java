package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a {
    private Context mContext;
    View nHN;
    int nHO;
    LayoutParams nHP = ((LayoutParams) this.nHN.getLayoutParams());

    public a(Activity activity) {
        this.mContext = activity;
        this.nHN = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.nHN.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                a aVar = a.this;
                Rect rect = new Rect();
                aVar.nHN.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom;
                if (i != aVar.nHO) {
                    int height = aVar.nHN.getRootView().getHeight();
                    int i2 = height - i;
                    if (i2 > height / 4) {
                        aVar.nHP.height = height - i2;
                    } else {
                        aVar.nHP.height = i;
                    }
                    aVar.nHN.requestLayout();
                    aVar.nHO = i;
                }
            }
        });
    }
}
