package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

class a$2 implements o {
    final /* synthetic */ a gcK;

    a$2(a aVar) {
        this.gcK = aVar;
    }

    public final boolean z(MotionEvent motionEvent) {
        return a.b(this.gcK).N(motionEvent);
    }

    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return a.b(this.gcK).c(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void akr() {
        a.b(this.gcK).cAz();
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        a.b(this.gcK).d(i, i2, z, z2);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        a.b(this.gcK).A(i, i2, i3, i4);
    }

    public final boolean A(MotionEvent motionEvent) {
        return a.b(this.gcK).O(motionEvent);
    }

    public final boolean B(MotionEvent motionEvent) {
        return a.b(this.gcK).P(motionEvent);
    }
}
