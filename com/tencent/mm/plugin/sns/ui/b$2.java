package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.plugin.sns.ui.b.a;

class b$2 extends ScaleAnimation {
    final /* synthetic */ b nKl;
    final /* synthetic */ View nKm;
    final /* synthetic */ a nKn = null;

    b$2(b bVar, float f, float f2, View view) {
        this.nKl = bVar;
        this.nKm = view;
        super(1.0f, f, 1.0f, f2);
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (!(this.nKl.nJS == 0 || this.nKl.nJT == 0)) {
            Rect rect = new Rect();
            this.nKm.getGlobalVisibleRect(rect);
            int i = (rect.right - rect.left) / 2;
            int i2 = ((rect.bottom - rect.top) + this.nKl.nJY) / 2;
            int i3 = (int) (((((float) (this.nKl.nJS - this.nKl.mWidth)) * (1.0f - f)) + ((float) this.nKl.mWidth)) / (1.0f - ((1.0f - this.nKl.nJW) * f)));
            int i4 = (int) (((((float) (this.nKl.nJT - this.nKl.mHeight)) * (1.0f - f)) + ((float) this.nKl.mHeight)) / (1.0f - ((1.0f - this.nKl.nJW) * f)));
            int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.nKl.nJZ) * f) / (1.0f - ((1.0f - this.nKl.nJW) * f))));
            int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.nKl.nJY) * (1.0f - f)) / 2.0f)) + ((((float) this.nKl.nKb) * f) / (1.0f - ((1.0f - this.nKl.nJW) * f))));
            i = (int) (((float) (i + (i3 / 2))) - ((((float) this.nKl.nKa) * f) / (1.0f - ((1.0f - this.nKl.nJW) * f))));
            i2 = (int) (((float) (i2 + (i4 / 2))) - ((((float) this.nKl.nKc) * f) / (1.0f - ((1.0f - this.nKl.nJW) * f))));
            if (VERSION.SDK_INT >= 21) {
                this.nKm.setClipBounds(new Rect(i5, i6, i, i2));
            } else if (VERSION.SDK_INT >= 18 && this.nKn == null) {
                this.nKm.setClipBounds(new Rect(i5 + this.nKm.getScrollX(), i6, i + this.nKm.getScrollX(), i2));
            }
        }
        super.applyTransformation(f, transformation);
    }
}
