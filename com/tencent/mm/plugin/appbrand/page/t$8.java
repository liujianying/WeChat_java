package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

class t$8 implements o {
    final /* synthetic */ t goK;

    t$8(t tVar) {
        this.goK = tVar;
    }

    public final boolean z(MotionEvent motionEvent) {
        return this.goK.N(motionEvent);
    }

    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.goK.c(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void akr() {
        this.goK.cAz();
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        this.goK.d(i, i2, z, z2);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        if (t.i(this.goK) != null) {
            t.i(this.goK).onScrollChanged(i, i2, i3, i4, view);
        }
        this.goK.A(i, i2, i3, i4);
    }

    public final boolean A(MotionEvent motionEvent) {
        return this.goK.O(motionEvent);
    }

    public final boolean B(MotionEvent motionEvent) {
        return this.goK.P(motionEvent);
    }
}
