package com.tencent.tencentmap.mapsdk.a;

public final class rt {
    private ru a;
    private ru b;

    public rt(ru ruVar, ru ruVar2) {
        a a = new a().a(ruVar).a(ruVar2);
        this.a = new ru(a.a(a), a.b(a));
        this.b = new ru(a.c(a), a.d(a));
    }

    public final ru a() {
        return this.a;
    }

    public final ru b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rt)) {
            return false;
        }
        rt rtVar = (rt) obj;
        return this.a.equals(rtVar.a) && this.b.equals(rtVar.b);
    }

    public final int hashCode() {
        return sz.a(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return sz.a(new String[]{sz.a("southwest", this.a), sz.a("northeast", this.b)});
    }
}
