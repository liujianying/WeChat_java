package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.z.a;

final class u$a implements a {
    float goZ;
    float gpa;
    View view;
    float x;
    float y;

    private u$a() {
    }

    /* synthetic */ u$a(byte b) {
        this();
    }

    public final void bP(int i, int i2) {
        this.goZ = (float) i;
        this.gpa = (float) i2;
        this.view.setX(this.x + ((float) i));
        this.view.setY(this.y + ((float) i2));
    }
}
