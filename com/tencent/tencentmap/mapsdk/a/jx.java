package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class jx extends mf {
    static ArrayList<jv> c = new ArrayList();
    public int a = 0;
    public ArrayList<jv> b = null;

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        if (this.b != null) {
            meVar.a(this.b, 1);
        }
    }

    static {
        c.add(new jv());
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(this.a, 0, true);
        this.b = (ArrayList) mdVar.a(c, 1, false);
    }
}
