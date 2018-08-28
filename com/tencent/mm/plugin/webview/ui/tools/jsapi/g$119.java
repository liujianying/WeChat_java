package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;

class g$119 implements a {
    final /* synthetic */ String fFT;
    final /* synthetic */ Bundle fFU;
    final /* synthetic */ String fFV;
    final /* synthetic */ String fFW;
    final /* synthetic */ String fFX;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$119(g gVar, i iVar, String str, Bundle bundle, String str2, String str3, String str4) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.fFT = str;
        this.fFU = bundle;
        this.fFX = str2;
        this.fFV = str3;
        this.fFW = str4;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        com.tencent.mm.bu.a.post(new 1(this, i, i2, str, bVar));
        return 0;
    }
}
