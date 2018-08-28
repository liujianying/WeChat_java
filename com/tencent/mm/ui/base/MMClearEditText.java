package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;

public class MMClearEditText extends EditText {
    public String gLA = "";
    private OnFocusChangeListener mqZ = null;
    private OnTouchListener oQM = new 3(this);
    public boolean qFM = false;
    final Drawable qFN = getResources().getDrawable(f.list_clear);
    int qrg = 0;
    private boolean ttU = false;

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        crs();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        crs();
    }

    private void crs() {
        this.qFN.setBounds(0, 0, this.qFN.getIntrinsicWidth(), this.qFN.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[]{Integer.valueOf(this.qFN.getIntrinsicWidth()), Integer.valueOf(this.qFN.getIntrinsicHeight())});
        cdi();
        setHeight(this.qFN.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.OneDPPadding) * 5));
        setOnTouchListener(this.oQM);
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MMClearEditText.this.cdi();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (MMClearEditText.this.mqZ != null) {
                    MMClearEditText.this.mqZ.onFocusChange(view, z);
                }
                MMClearEditText.this.cdi();
            }
        });
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
        setText(b.d(getContext(), str, getTextSize()));
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

    public OnTouchListener getDefaultOnTouchListener() {
        return this.oQM;
    }

    private void cdi() {
        if (getText().toString().equals("") || !isFocused()) {
            cdk();
        } else if (!this.ttU) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.qFN, getCompoundDrawables()[3]);
        }
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
}
