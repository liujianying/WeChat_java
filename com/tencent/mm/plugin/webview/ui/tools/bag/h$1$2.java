package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.1;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.2;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class h$1$2 implements Runnable {
    final /* synthetic */ 1 qbJ;

    h$1$2(1 1) {
        this.qbJ = 1;
    }

    public final void run() {
        MMActivity mMActivity = this.qbJ.gdk;
        Point point = this.qbJ.qbH;
        float f = this.qbJ.qbI;
        e eVar = this.qbJ.qbG;
        x.i("MicroMsg.TransformToBagAniHelper", "doMaskAnimation bogPos x:%d, y:%d lastSwipePosX:%f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f)});
        if (mMActivity.getSwipeBackLayout() == null) {
            x.w("MicroMsg.TransformToBagAniHelper", "doMaskAnimation getSwipeBackLayout null");
            eVar.bWQ();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        i iVar = new i(mMActivity, c.dk(mMActivity.getSwipeBackLayout().getTargetContentView()));
        iVar.setLayoutParams(new LayoutParams(-1, -1));
        int i = point.x;
        int i2 = point.y + b.qbk;
        int i3 = b.qbm / 2;
        iVar.qbS = i;
        iVar.qbT = i2;
        iVar.qbR = i3;
        iVar.setContentStartPosX((int) f);
        iVar.setListener(new 2(eVar));
        viewGroup.addView(iVar, viewGroup.getChildCount());
        mMActivity.getSwipeBackLayout().getTargetContentView().setVisibility(8);
        TimeInterpolator linearInterpolator = new LinearInterpolator();
        iVar.qbV = iVar.qbU > 0;
        int i4 = iVar.qbU < iVar.qbS ? iVar.qbU : iVar.qbS;
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("canvasTranslationX", new int[]{iVar.qbU, i4});
        i4 = iVar.qbS;
        if (iVar.qbV) {
            i4 = iVar.qbU < iVar.qbS ? iVar.qbS - iVar.qbU : 0;
        }
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("translationX", new int[]{0, i4});
        PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("translationY", new int[]{0, iVar.qbT});
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, (((float) iVar.qbR) * 2.0f) / ((float) iVar.mWidth)});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, (((float) iVar.qbR) * 2.0f) / ((float) iVar.mHeight)});
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt3, ofFloat, ofFloat2, ofInt});
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.setInterpolator(linearInterpolator);
        ofPropertyValuesHolder.addUpdateListener(new i$1(iVar));
        ofPropertyValuesHolder.addListener(new i.2(iVar));
        ofPropertyValuesHolder.start();
    }
}
