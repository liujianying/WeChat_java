package com.tencent.mm.modelstat;

public final class f {
    private static f ejD = null;
    public com.tencent.mm.a.f<String, Long> ejE = new com.tencent.mm.a.f(10);
    public String ejF;

    public static f RY() {
        if (ejD == null) {
            ejD = new f();
        }
        return ejD;
    }

    private f() {
    }

    public final void r(String str, long j) {
        if (this.ejE != null) {
            this.ejF = str;
            this.ejE.put(str, Long.valueOf(j));
        }
    }
}
