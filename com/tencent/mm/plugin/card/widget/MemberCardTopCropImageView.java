package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public class MemberCardTopCropImageView extends ImageView {
    protected int hGJ = -1;
    protected int hJO = -1;
    private float hJP;
    protected int itemPadding = -1;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public float getShowScale() {
        return this.hJP;
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        this.hGJ = a.ad(ad.getContext(), b.card_item_height);
        this.itemPadding = a.ad(ad.getContext(), b.MiddlePadding) * 2;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            return super.setFrame(i, i2, i3, i4);
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.hJO = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i5 = this.hJO;
        int i6 = this.hGJ;
        if (intrinsicWidth * i6 > intrinsicHeight * i5) {
            this.hJP = ((float) i6) / ((float) intrinsicHeight);
        } else {
            this.hJP = ((float) i5) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.hJP, this.hJP);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
