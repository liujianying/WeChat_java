package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class jw extends mf {
    static ArrayList<jt> c = new ArrayList();
    public int a = 0;
    public ArrayList<jt> b = null;

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
        if (this.b != null) {
            meVar.a(this.b, 1);
        }
    }

    static {
        c.add(new jt());
    }

    public final void readFrom(md mdVar) {
        this.a = mdVar.a(this.a, 0, true);
        this.b = (ArrayList) mdVar.a(c, 1, false);
    }
}
