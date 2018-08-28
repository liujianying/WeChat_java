package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;

class k$2 implements Runnable {
    final /* synthetic */ String enZ;
    final /* synthetic */ g iVs;
    final /* synthetic */ k jaT;
    final /* synthetic */ vx jam;

    public k$2(k kVar, String str, g gVar, vx vxVar) {
        this.jaT = kVar;
        this.enZ = str;
        this.iVs = gVar;
        this.jam = vxVar;
    }

    public final void run() {
        if (k.BD(this.enZ)) {
            b.a(this.iVs, this.jam, false);
        }
    }

    public final String toString() {
        return super.toString() + "|attachImg";
    }
}
