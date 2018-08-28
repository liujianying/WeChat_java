package com.tencent.f;

public final class a implements com.tencent.f.b.a {
    private g vwx;
    private boolean vwy = true;

    protected a(g gVar) {
        this.vwx = gVar;
    }

    public final void w(String str, Object obj) {
        if (this.vwy) {
            f cHr = f.cHr();
            if (obj == null) {
                throw new h("TpfServiceCenter|registerService|name or service should not be null");
            }
            synchronized (cHr.vwE) {
                cHr.vwC.put(str, obj);
            }
        }
    }
}
