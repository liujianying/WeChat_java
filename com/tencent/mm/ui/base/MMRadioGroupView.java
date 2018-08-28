package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.ui.base.MMRadioImageButton.a;

public class MMRadioGroupView extends LinearLayout {
    private int twV = -1;
    private int twW = -1;
    private a twX = new a(this);
    private b twY;
    private c twZ = new c(this, (byte) 0);
    private MMRadioImageButton txa;
    private d txb;

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnHierarchyChangeListener(this.twZ);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.twV != -1) {
            al(this.twV, true);
            setCheckedId(this.twV);
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.twV != -1) {
                    al(this.twV, false);
                }
                setCheckedId(mMRadioImageButton.getId());
                setCheckedButton(mMRadioImageButton);
            }
        }
        super.addView(view, i, layoutParams);
    }

    private void al(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
    }

    private void setCheckedId(int i) {
        this.twV = i;
    }

    private void setClickedId(int i) {
        this.twW = i;
    }

    private void setCheckedButton(MMRadioImageButton mMRadioImageButton) {
        this.txa = mMRadioImageButton;
    }

    public void setOnMMRadioGroupCheckedChangeListener(b bVar) {
        this.twY = bVar;
    }

    public int getCheckedRadioButtonId() {
        return this.twV;
    }

    public int getClickedRadioButtonId() {
        return this.twW;
    }

    public MMRadioImageButton getCheckedRadioButton() {
        return this.txa;
    }

    public void setOnSizeChangeObserver(d dVar) {
        this.txb = dVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.txb != null) {
            this.txb.Eo(i);
        }
    }
}
