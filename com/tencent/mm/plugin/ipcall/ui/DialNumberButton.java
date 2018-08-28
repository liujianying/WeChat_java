package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;

public class DialNumberButton extends RelativeLayout {
    TextView ksJ;
    TextView ksK;
    private boolean ksL = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dial_number_button, this);
        this.ksJ = (TextView) findViewById(R.h.dial_button_number);
        this.ksK = (TextView) findViewById(R.h.dial_button_text);
        if (d.fR(16)) {
            this.ksJ.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ksK.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
    }

    public String getNumberText() {
        return this.ksJ.getText().toString();
    }

    public String getOtherText() {
        return this.ksK.getText().toString();
    }

    public void setInTalkUIMode(boolean z) {
        this.ksL = z;
        if (this.ksL) {
            if ("#".equals(this.ksJ.getText()) || "*".equals(this.ksJ.getText())) {
                this.ksJ.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
            } else {
                this.ksJ.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_text_color_white));
            }
            this.ksK.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
            setBackgroundDrawable(getResources().getDrawable(R.g.dial_number_button_background_black));
            return;
        }
        if ("#".equals(this.ksJ.getText()) || "*".equals(this.ksJ.getText())) {
            this.ksJ.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
        } else {
            this.ksJ.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_text_color));
        }
        this.ksK.setTextColor(getContext().getResources().getColor(R.e.dial_number_button_other_text_color));
        setBackgroundDrawable(getResources().getDrawable(R.g.dial_number_button_background_white));
    }
}
