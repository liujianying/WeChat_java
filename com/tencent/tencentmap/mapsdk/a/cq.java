package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class cq extends cx implements Cloneable {
    private static ArrayList<cp> b;
    public ArrayList<cp> a = null;

    public final void a(cw cwVar) {
        cwVar.a(this.a, 0);
    }

    public final void a(cv cvVar) {
        if (b == null) {
            b = new ArrayList();
            b.add(new cp());
        }
        this.a = (ArrayList) cvVar.a(b, 0, true);
    }
}
