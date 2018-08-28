package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

abstract class h {
    a gAw;

    abstract void aog();

    abstract View aoh();

    abstract void onDetached();

    abstract void onResume();

    h() {
    }

    protected final void df(boolean z) {
        if (aoh() != null) {
            if (z) {
                if (aoh().getVisibility() != 0) {
                    aoh().setVisibility(0);
                }
            } else if (aoh().getVisibility() != 8) {
                aoh().setVisibility(8);
            }
            if (this.gAw != null) {
                this.gAw.a(this, aoh(), z);
            }
        }
    }

    protected final boolean aol() {
        if (aoh() != null && aoh().getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
