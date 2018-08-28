package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent extends MMFrameLayout {
    private int fAU = 120;
    public ArrayList<TagImageView> nPW = new ArrayList();
    private float nPX;

    public final void bCz() {
        this.nPW.clear();
    }

    public final void a(TagImageView tagImageView) {
        this.nPW.add(tagImageView);
    }

    public void setImageViewWidth(int i) {
        if (i > 0) {
            this.nPX = getResources().getDisplayMetrics().density;
            this.fAU = (int) (((float) this.fAU) * this.nPX);
            if (i >= this.fAU) {
                i = this.fAU;
            }
            for (int i2 = 0; i2 < this.nPW.size(); i2++) {
                View childAt = getChildAt(i2);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(childAt.getLayoutParams());
                marginLayoutParams.width = i;
                marginLayoutParams.height = i;
                marginLayoutParams.leftMargin = (int) (((float) (i2 % 3)) * (((float) i) + (this.nPX * 3.0f)));
                marginLayoutParams.topMargin = (int) (((float) (i2 / 3)) * (((float) i) + (this.nPX * 3.0f)));
                LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
                layoutParams.gravity = 51;
                childAt.setLayoutParams(layoutParams);
            }
            int size = this.nPW.size() / 3;
            if (size > 0) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
                marginLayoutParams2.height = (int) ((((float) (size - 1)) * (this.nPX * 3.0f)) + ((float) (i * size)));
                setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public final TagImageView xm(int i) {
        if (i < this.nPW.size()) {
            return (TagImageView) this.nPW.get(i);
        }
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
