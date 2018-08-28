package com.google.android.gms.common.api;

import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.m.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class m$f extends i {
    final /* synthetic */ m aLa;
    private final ArrayList<b> aLn;

    public m$f(m mVar, ArrayList<b> arrayList) {
        this.aLa = mVar;
        super(mVar, (byte) 0);
        this.aLn = arrayList;
    }

    public final void oI() {
        Set set = this.aLa.aKG.aLy;
        Set oQ = set.isEmpty() ? this.aLa.oQ() : set;
        Iterator it = this.aLn.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.aLa.aKU, oQ);
        }
    }
}
