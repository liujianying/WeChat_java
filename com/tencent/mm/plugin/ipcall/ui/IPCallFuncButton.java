package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;

public class IPCallFuncButton extends LinearLayout {
    private boolean hvk = false;
    private ImageView kwm;
    private TextView kwn;
    private Drawable kwo;
    private Drawable kwp;
    private Drawable kwq;
    private boolean kwr;
    private boolean kws = true;
    private a kwt;
    private OnTouchListener kwu = new 1(this);
    private String text;

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.ip_call_func_button, this);
        this.kwm = (ImageView) findViewById(R.h.button);
        this.kwn = (TextView) findViewById(R.h.text);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.n.IPCallFuncButton, 0, 0);
        this.kwo = obtainStyledAttributes.getDrawable(R.n.IPCallFuncButton_drawableNormal);
        this.kwp = obtainStyledAttributes.getDrawable(R.n.IPCallFuncButton_drawablePress);
        this.kwr = obtainStyledAttributes.getBoolean(R.n.IPCallFuncButton_checkBoxMode, false);
        this.kwq = obtainStyledAttributes.getDrawable(R.n.IPCallFuncButton_drawableDisable);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.IPCallFuncButton_funcText, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (bi.oW(this.text)) {
            this.kwn.setVisibility(8);
        } else {
            this.kwn.setText(this.text);
        }
        if (this.kwo != null) {
            this.kwm.setImageDrawable(this.kwo);
        }
        this.kwm.setClickable(true);
        this.kwm.setOnTouchListener(this.kwu);
    }

    public void setClickCallback(a aVar) {
        this.kwt = aVar;
    }

    public String getFuncText() {
        return this.text;
    }

    public void setFuncText(String str) {
        this.text = str;
        this.kwn.setText(this.text);
    }

    public final boolean isChecked() {
        if (this.kwr) {
            return this.hvk;
        }
        return false;
    }

    public void setCheckBoxMode(boolean z) {
        if (this.kwr != z) {
            this.kwr = z;
            this.hvk = false;
            if (this.kwo != null) {
                this.kwm.setImageDrawable(this.kwo);
            }
        }
    }

    public void setEnable(boolean z) {
        if (z != this.kws) {
            this.kws = z;
            if (this.kws || this.kwq == null) {
                this.kwm.setImageDrawable(this.kwo);
            } else {
                this.kwm.setImageDrawable(this.kwq);
            }
            this.hvk = false;
        }
    }

    public void setChecked(boolean z) {
        if (z != this.hvk && this.kwr) {
            this.hvk = z;
            if (this.hvk) {
                this.kwm.setImageDrawable(this.kwp);
            } else {
                this.kwm.setImageDrawable(this.kwo);
            }
        }
    }
}
