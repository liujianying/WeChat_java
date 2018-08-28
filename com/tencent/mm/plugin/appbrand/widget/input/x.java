package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.sdk.platformtools.ag;

public final class x {
    public b gIR;
    final Runnable gIS = new 1(this);
    final ag guJ;
    private final EditText im;

    public x(EditText editText) {
        this.im = editText;
        this.guJ = new ag(Looper.getMainLooper());
    }

    public final Editable c(Editable editable) {
        editable.setSpan(new 2(this), 0, editable.length(), 18);
        editable.setSpan(new 3(this), 0, editable.length(), 18);
        return editable;
    }
}
