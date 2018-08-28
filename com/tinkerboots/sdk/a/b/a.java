package com.tinkerboots.sdk.a.b;

public class a {
    public final com.tinkerboots.sdk.a.c.a vGe;

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.vGe = aVar;
    }

    public static a cJD() {
        a aVar = new a();
        aVar.vGe = new com.tinkerboots.sdk.a.c.a();
        if (aVar.vGe != null) {
            return new a(aVar.vGe);
        }
        throw new RuntimeException("You need init conditions property");
    }
}
