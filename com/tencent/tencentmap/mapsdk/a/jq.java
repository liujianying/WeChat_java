package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class jq extends mf {
    static ArrayList<js> b = new ArrayList();
    public ArrayList<js> a = null;

    public jq(ArrayList<js> arrayList) {
        this.a = arrayList;
    }

    public final void writeTo(me meVar) {
        meVar.a(this.a, 0);
    }

    static {
        b.add(new js());
    }

    public final void readFrom(md mdVar) {
        this.a = (ArrayList) mdVar.a(b, 0, true);
    }
}
