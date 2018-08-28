package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    public a gMI;

    public abstract View ajw();

    public final <T extends e> T C(Class<T> cls) {
        a dq = dq(true);
        this.gMI = dq;
        if (dq == null) {
            return null;
        }
        try {
            dq.setPickerImpl((e) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{dq.getContext()}));
            return dq.getPicker();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", new Object[]{cls.getSimpleName(), e});
            return null;
        }
    }

    public final a dq(boolean z) {
        if (this.gMI != null) {
            return this.gMI;
        }
        if (ajw() == null) {
            return null;
        }
        l bV = l.bV(ajw());
        if (bV == null) {
            return null;
        }
        a ci = a.ci(bV);
        if (ci != null || !z) {
            return ci;
        }
        ci = new a(ajw().getContext());
        bV.f(ci, true);
        return ci;
    }
}
