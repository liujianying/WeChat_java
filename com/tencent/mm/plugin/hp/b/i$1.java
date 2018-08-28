package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import java.util.LinkedList;

class i$1 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ String kmK;
    final /* synthetic */ String kmL;
    final /* synthetic */ String kmM;
    final /* synthetic */ OnClickListener kmN;
    final /* synthetic */ OnClickListener kmO;

    i$1(String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.dEt = str;
        this.kmK = str2;
        this.kmL = str3;
        this.kmM = str4;
        this.kmN = onClickListener;
        this.kmO = onClickListener2;
    }

    public final void run() {
        ia iaVar = new ia();
        b bVar = new b();
        bVar.title = this.dEt;
        bVar.bIr = this.kmK;
        bVar.qXY = new LinkedList();
        a aVar = new a();
        aVar.qXW = this.kmL;
        bVar.qXY.add(aVar);
        aVar = new a();
        aVar.qXW = this.kmM;
        bVar.qXY.add(aVar);
        iaVar.bRy.type = 1;
        iaVar.bRy.bRz = bVar;
        iaVar.bRy.bRA = this.kmN;
        iaVar.bRy.bRB = this.kmO;
        com.tencent.mm.sdk.b.a.sFg.m(iaVar);
    }
}
