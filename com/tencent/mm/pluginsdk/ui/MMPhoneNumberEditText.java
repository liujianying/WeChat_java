package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.R;
import com.tencent.mm.br.g;
import com.tencent.mm.sdk.platformtools.x;

public class MMPhoneNumberEditText extends EditText {
    public String gLA = "";
    private OnFocusChangeListener mqZ = null;
    public boolean qFM = false;
    public Drawable qFN;
    private a qFO;
    public boolean qFP;
    private boolean qFQ = false;
    int qrg = 0;

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.qFN = getResources().getDrawable(R.g.list_clear);
        this.qFN.setBounds(0, 0, this.qFN.getIntrinsicWidth(), this.qFN.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[]{Integer.valueOf(this.qFN.getIntrinsicWidth()), Integer.valueOf(this.qFN.getIntrinsicHeight())});
        cdi();
        setHeight(this.qFN.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.f.OneDPPadding) * 5));
        clearFocus();
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        super.setOnFocusChangeListener(new 3(this));
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.qrg = 0;
            String obj = getText().toString();
            try {
                Tx(obj);
            } catch (IndexOutOfBoundsException e) {
                x.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[]{Integer.valueOf(this.qrg)});
                if (this.qrg < 3) {
                    this.qrg++;
                    Tx(" " + obj);
                } else {
                    x.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void Tx(String str) {
        int selectionStart = getSelectionStart();
        g cjL = g.cjL();
        getContext();
        setText(cjL.a(str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mqZ = onFocusChangeListener;
    }

    private void cdi() {
        if (getText().toString().equals("")) {
            cdk();
        } else {
            cdj();
        }
    }

    final void cdj() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.qFN, getCompoundDrawables()[3]);
    }

    private void cdk() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            if (!this.qFM) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setCallback(a aVar) {
        this.qFO = aVar;
    }
}
