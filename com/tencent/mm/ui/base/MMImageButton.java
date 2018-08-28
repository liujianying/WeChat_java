package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.w.a.d;

public class MMImageButton extends FrameLayout {
    private ImageView bRk;
    private TextView lSz;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bRk = new ImageView(context);
        this.bRk.setLayoutParams(layoutParams);
        addView(this.bRk);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.lSz = new TextView(context);
        this.lSz.setLayoutParams(layoutParams);
        this.lSz.setClickable(false);
        this.lSz.setFocusable(false);
        this.lSz.setFocusableInTouchMode(false);
        this.lSz.setTextColor(a.ac(context, d.mm_title_btn_text));
        addView(this.lSz);
    }

    public void setImageRsource(int i) {
        setImageDrawable(a.f(getContext(), i));
    }

    public void setImageDrawable(Drawable drawable) {
        this.bRk.setImageDrawable(drawable);
        this.bRk.setVisibility(0);
        this.lSz.setVisibility(8);
    }

    public void setText(String str) {
        this.lSz.setText(str);
        this.lSz.setVisibility(0);
        this.bRk.setVisibility(8);
    }

    public void setText(int i) {
        this.lSz.setText(i);
        this.lSz.setVisibility(0);
        this.bRk.setVisibility(8);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.lSz.setEnabled(z);
        this.bRk.setEnabled(z);
    }
}
