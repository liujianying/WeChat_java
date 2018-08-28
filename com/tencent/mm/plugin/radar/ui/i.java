package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import b.b;
import b.c.b.e;
import b.c.b.f;
import b.d;
import b.g;
import b.h;
import b.l;

public final class i {

    static final class a extends f implements b.c.a.a<T> {
        final /* synthetic */ Activity mnk;
        final /* synthetic */ int mnl;

        a(Activity activity, int i) {
            this.mnk = activity;
            this.mnl = i;
        }

        public final /* synthetic */ Object invoke() {
            View findViewById = this.mnk.findViewById(this.mnl);
            if (findViewById != null) {
                return findViewById;
            }
            throw new b.i("null cannot be cast to non-null type T");
        }
    }

    public static final <T extends View> b<T> D(View view, int i) {
        e.i(view, "$receiver");
        return a((b.c.a.a) new b(view, i));
    }

    static final <T> b<T> a(b.c.a.a<? extends T> aVar) {
        b.e eVar = b.e.vGs;
        e.i(eVar, "mode");
        e.i(aVar, "initializer");
        switch (d.mkC[eVar.ordinal()]) {
            case 1:
                return (b) new h(aVar, (byte) 0);
            case 2:
                return (b) new g(aVar);
            case 3:
                return (b) new l(aVar);
            default:
                throw new b.f();
        }
    }
}
