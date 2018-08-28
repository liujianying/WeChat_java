package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.plugin.appbrand.widget.input.b.a;

public final class q extends p implements a {
    private InputConnection gHM;

    public final /* bridge */ /* synthetic */ boolean apz() {
        return super.apz();
    }

    public final /* bridge */ /* synthetic */ boolean canScrollVertically(int i) {
        return super.canScrollVertically(i);
    }

    public final /* bridge */ /* synthetic */ void setGravity(int i) {
        super.setGravity(i);
    }

    public q(Context context) {
        super(context);
        super.setKeyListener(new 1(this));
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
        while (i < inputFilterArr.length) {
            inputFilterArr2[i] = inputFilterArr[i];
            i++;
        }
        inputFilterArr2[i] = new AllCaps();
        super.setFilters(inputFilterArr2);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public final InputConnection apA() {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        this.gHM = onCreateInputConnection;
        return onCreateInputConnection;
    }

    public final void setPasswordMode(boolean z) {
        apP();
        int inputType = getInputType() | 2;
        if (z) {
            inputType |= 16;
        } else {
            inputType &= -17;
        }
        setInputType(inputType);
        super.setPasswordMode(z);
        apQ();
    }

    public final View getInputPanel() {
        return t.bZ(this);
    }

    public final void apx() {
        ((t) getInputPanel()).setInputEditText(this);
    }
}
