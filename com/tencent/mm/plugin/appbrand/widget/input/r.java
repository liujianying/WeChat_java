package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;

final class r extends p {
    public r(Context context) {
        super(context);
    }

    public final View getInputPanel() {
        return u.cb(this);
    }

    public final void setPasswordMode(boolean z) {
        apP();
        int inputType = getInputType() | 1;
        if (z) {
            inputType |= 128;
        } else {
            inputType &= -129;
        }
        setInputType(inputType);
        super.setPasswordMode(z);
        apQ();
    }

    public final void apx() {
        af.cg(this).restartInput(this);
    }
}
