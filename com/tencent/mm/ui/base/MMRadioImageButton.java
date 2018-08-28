package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean txd;
    private boolean txe;
    private boolean txf;
    private a txg;
    private a txh;

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.txe = true;
    }

    public void toggle() {
        if (!this.txe) {
            if (this.txg != null) {
                this.txg.b(this);
            }
            if (this.txh != null) {
                this.txh.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.txf);
        }
    }

    public boolean performClick() {
        toggle();
        return false;
    }

    public boolean isChecked() {
        return this.txf;
    }

    public void setChecked(boolean z) {
        if (this.txf != z) {
            this.txf = z;
            setSelected(this.txf);
            refreshDrawableState();
            if (!this.txd) {
                this.txd = true;
                if (this.txg != null) {
                    this.txg.a(this);
                }
                if (this.txh != null) {
                    this.txh.a(this);
                }
                this.txd = false;
            }
        }
    }

    public void setCheckable(boolean z) {
        this.txe = z;
    }

    public void setOnMMRadioButtonCheckedChangeListener(a aVar) {
        this.txg = aVar;
    }

    public void setOnOtherMMRadioButtonCheckedChangeListener(a aVar) {
        this.txh = aVar;
    }
}
