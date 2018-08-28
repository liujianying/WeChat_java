package com.tencent.b.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    protected abstract void a(a aVar);

    protected abstract String read();

    protected abstract boolean tL();

    protected abstract a tM();

    protected abstract void write(String str);

    protected q(Context context) {
        this.context = context;
    }

    public final g tT() {
        String decode;
        if (tL()) {
            decode = s.decode(read());
        } else {
            decode = null;
        }
        if (decode != null) {
            return g.ch(decode);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (tL()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a tU() {
        if (tL()) {
            return tM();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && tL()) {
            a(aVar);
        }
    }
}
