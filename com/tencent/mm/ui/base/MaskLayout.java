package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MaskLayout extends RelativeLayout {
    private ImageView jez;
    private Drawable tzg;
    private View view;

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.MaskLayout, i, 0);
        this.tzg = obtainStyledAttributes.getDrawable(m.MaskLayout_foreground);
        obtainStyledAttributes.recycle();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.view = findViewById(g.content);
        if (this.view == null) {
            x.d("MicroMsg.MaskLayout", "%s", new Object[]{"not found view by id, new one"});
            this.view = new View(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.jez = new ImageView(getContext());
        this.jez.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jez.setImageDrawable(this.tzg);
        addView(this.jez);
    }

    public void setMaskBitmap(Bitmap bitmap) {
        Eq(a.tzm);
        this.jez.setImageBitmap(bitmap);
    }

    public void setMaskDrawable(Drawable drawable) {
        Eq(a.tzm);
        this.jez.setImageDrawable(drawable);
    }

    public final void f(Bitmap bitmap, int i) {
        Eq(i);
        this.jez.setImageBitmap(bitmap);
    }

    public View getContentView() {
        return this.view;
    }

    private void Eq(int i) {
        removeView(this.jez);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (1.tzh[i - 1]) {
            case 1:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case 3:
                break;
            case 4:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                break;
        }
        addView(this.jez, layoutParams);
    }
}
