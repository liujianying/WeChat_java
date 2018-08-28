package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipSmallIconButton extends FrameLayout {
    private TextView ih;
    private ImageView isa;
    private Drawable oQK = null;
    private Drawable oQL = null;
    private OnTouchListener oQM = new 1(this);

    public void setOnClickListener(OnClickListener onClickListener) {
        this.isa.setOnClickListener(onClickListener);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        CharSequence charSequence = 0;
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.layout_voip_small_icon_button, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.VoipButton, 0, 0);
        try {
            this.oQK = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconRes);
            this.oQL = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconResPressed);
            charSequence = obtainStyledAttributes.getString(R.n.VoipButton_iconTip);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.VoipButton_iconTip, -1);
            this.isa = (ImageView) findViewById(R.h.small_icon_button);
            this.isa.setImageDrawable(this.oQK);
            this.isa.setOnTouchListener(this.oQM);
            this.isa.setContentDescription(charSequence);
            this.ih = (TextView) findViewById(R.h.small_icon_text);
            if (resourceId != -1) {
                this.ih.setText(getContext().getString(resourceId));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.isa.setEnabled(z);
        this.ih.setEnabled(z);
    }
}
