package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.j;

public class MMVisiblePasswordEditText extends EditText {
    public String gLA = "";
    final Drawable tzc = getResources().getDrawable(j.login_showpassword_icon);
    final Drawable tzd = getResources().getDrawable(j.login_showpassword_icon_activa);
    private boolean tze = false;

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        crs();
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        crs();
    }

    private void crs() {
        this.tzc.setBounds(0, 0, this.tzc.getIntrinsicWidth(), this.tzc.getIntrinsicHeight());
        this.tzd.setBounds(0, 0, this.tzd.getIntrinsicWidth(), this.tzd.getIntrinsicHeight());
        x.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[]{Integer.valueOf(this.tzc.getIntrinsicWidth()), Integer.valueOf(this.tzc.getIntrinsicHeight())});
        crX();
        setHeight(this.tzc.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.OneDPPadding) * 5));
        setOnTouchListener(new 1(this));
    }

    private void crX() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.tze) {
            setInputType(1);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.tzd, getCompoundDrawables()[3]);
        } else {
            setInputType(129);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.tzc, getCompoundDrawables()[3]);
        }
        setSelection(selectionStart, selectionEnd);
    }
}
