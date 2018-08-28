package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;
import java.util.List;

class c$a extends TranslateAnimation {
    final /* synthetic */ c kJf;
    private List<View> kJh = new ArrayList();

    public c$a(c cVar, float f) {
        this.kJf = cVar;
        super(0.0f, 0.0f, 0.0f, f);
    }

    public final c$a baf() {
        setFillEnabled(true);
        setFillAfter(true);
        return this;
    }

    public final c$a cr(View view) {
        this.kJh.add(view);
        return this;
    }

    public final void bag() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kJh.size()) {
                ((View) this.kJh.get(i2)).startAnimation(this);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
