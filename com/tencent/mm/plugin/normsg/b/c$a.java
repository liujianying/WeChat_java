package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

final class c$a implements OnClickListener {
    private final OnClickListener lGU;

    c$a(OnClickListener onClickListener) {
        this.lGU = onClickListener;
    }

    public final void onClick(View view) {
        synchronized (c.ajb()) {
            if (c.ajb().containsKey(view)) {
                synchronized (c.QV()) {
                    if (c.QV().containsKey(view)) {
                        c.QV().remove(view);
                    } else {
                        Class cls = (Class) c.ajb().get(view);
                        if (cls != null) {
                            try {
                                a.sFg.m((b) cls.newInstance());
                            } catch (Throwable th) {
                                x.printErrStackTrace("MicroMsg.CBCH", th, "failure to instantiate event class: " + cls.getName(), new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        if (this.lGU != null) {
            this.lGU.onClick(view);
        }
    }
}
