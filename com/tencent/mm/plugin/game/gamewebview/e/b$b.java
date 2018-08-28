package com.tencent.mm.plugin.game.gamewebview.e;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.game.gamewebview.ui.f;

class b$b extends f {
    final /* synthetic */ b jKU;

    private b$b(b bVar) {
        this.jKU = bVar;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final boolean z(MotionEvent motionEvent) {
        return this.jKU.N(motionEvent);
    }

    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.jKU.c(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final boolean A(MotionEvent motionEvent) {
        return this.jKU.O(motionEvent);
    }

    public final void akr() {
        this.jKU.cAz();
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        this.jKU.d(i, i2, z, z2);
    }

    public final boolean B(MotionEvent motionEvent) {
        return this.jKU.P(motionEvent);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        this.jKU.A(i, i2, i3, i4);
        if (b.i(this.jKU) != null) {
            b.i(this.jKU).onScrollChanged(i, i2, i3, i4, view);
        }
    }
}
