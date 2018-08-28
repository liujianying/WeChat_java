package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipBigIconButton extends FrameLayout {
    private TextView ih;
    private ImageView isa;
    private Drawable oQI = null;
    private Drawable oQJ = null;
    private Drawable oQK = null;
    private Drawable oQL = null;
    private OnTouchListener oQM = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    VoipBigIconButton.this.isa.setBackgroundDrawable(VoipBigIconButton.this.oQJ);
                    VoipBigIconButton.this.isa.setImageDrawable(VoipBigIconButton.this.oQL);
                    VoipBigIconButton.this.ih.setTextColor(-855638017);
                    break;
                case 1:
                    VoipBigIconButton.this.isa.setBackgroundDrawable(VoipBigIconButton.this.oQI);
                    VoipBigIconButton.this.isa.setImageDrawable(VoipBigIconButton.this.oQK);
                    VoipBigIconButton.this.ih.setTextColor(-1);
                    break;
            }
            return false;
        }
    };

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.layout_voip_big_icon_button, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.VoipButton, 0, 0);
        try {
            CharSequence string;
            this.oQI = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconBackground);
            this.oQJ = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconBackgroundPressed);
            this.oQK = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconRes);
            this.oQL = obtainStyledAttributes.getDrawable(R.n.VoipButton_iconResPressed);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.VoipButton_iconTip, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.n.VoipButton_iconTip, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.oQJ = this.oQJ == null ? this.oQI : this.oQJ;
            this.oQL = this.oQL == null ? this.oQK : this.oQL;
            this.isa = (ImageView) findViewById(R.h.big_icon_button);
            this.isa.setBackgroundDrawable(this.oQI);
            this.isa.setImageDrawable(this.oQK);
            this.isa.setOnTouchListener(this.oQM);
            this.isa.setContentDescription(string);
            this.ih = (TextView) findViewById(R.h.big_icon_text);
            if (resourceId != -1) {
                this.ih.setText(getContext().getString(resourceId));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.isa.setEnabled(z);
        this.ih.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.isa.setOnClickListener(onClickListener);
    }
}
