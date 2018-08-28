package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.x5.a.a.a.a.b;

class a$3 extends b {
    final /* synthetic */ a gcK;

    a$3(a aVar) {
        this.gcK = aVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return a.c(this.gcK).z(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return a.c(this.gcK).B(motionEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return a.c(this.gcK).A(motionEvent);
    }

    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return a.c(this.gcK).b(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        a.c(this.gcK).onScrollChanged(i, i2, i3, i4, view);
    }

    public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        a.c(this.gcK).c(i, i2, z, z2);
    }

    public final void computeScroll(View view) {
        a.c(this.gcK).akr();
    }
}
