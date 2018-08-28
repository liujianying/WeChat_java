package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;

class k$5 implements Runnable {
    final /* synthetic */ String enZ;
    final /* synthetic */ g iVs;
    final /* synthetic */ vx jam;

    k$5(String str, g gVar, vx vxVar) {
        this.enZ = str;
        this.iVs = gVar;
        this.jam = vxVar;
    }

    public final void run() {
        if (k.BD(this.enZ)) {
            b.a(this.iVs, this.jam);
        }
    }

    public final String toString() {
        return super.toString() + "|getThumb";
    }
}
