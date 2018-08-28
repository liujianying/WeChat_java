package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import android.view.ViewParent;

abstract class ad$a<Source extends View, Target extends View> {
    private Target me;

    abstract boolean cd(View view);

    abstract Target ce(View view);

    private ad$a() {
    }

    /* synthetic */ ad$a(byte b) {
        this();
    }

    public final Target cf(Source source) {
        if (this.me != null && z.ak(this.me)) {
            return this.me;
        }
        if (source == null || !z.ak(source)) {
            return null;
        }
        for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (cd((View) parent)) {
                Target ce = ce((View) parent);
                this.me = ce;
                return ce;
            }
        }
        return null;
    }
}
