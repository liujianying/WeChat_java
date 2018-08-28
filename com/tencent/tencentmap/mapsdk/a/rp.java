package com.tencent.tencentmap.mapsdk.a;

public final class rp {
    private int a = 0;
    private int b = 0;
    private String c = "default";
    private String d = "";
    private String e = "";

    public rp(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.d = str;
        this.e = str2;
        this.c = str3;
    }

    public final int a() {
        return (this.a * 10) + this.b;
    }

    public final boolean a(rr rrVar) {
        switch (this.a) {
            case 0:
                if ("default".equals(this.c)) {
                    return true;
                }
                if (rrVar == null) {
                    return false;
                }
                ru a = rrVar.a();
                sk.a();
                return sk.a(a, sk.c(this.c));
            case 1:
                if ("default".equals(this.c)) {
                    return true;
                }
                if (rrVar != null) {
                    sk.a();
                    ru[] c = sk.c(this.c);
                    for (ru a2 : rrVar.b()) {
                        if (sk.a(a2, c)) {
                            return true;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }
}
