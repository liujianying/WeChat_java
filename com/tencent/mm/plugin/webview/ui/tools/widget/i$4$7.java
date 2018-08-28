package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$7 implements Runnable {
    final /* synthetic */ double dSA;
    final /* synthetic */ String ffJ;
    final /* synthetic */ String pZW;
    final /* synthetic */ int pZX;
    final /* synthetic */ int pZY;
    final /* synthetic */ double pZZ;
    final /* synthetic */ float qaa;
    final /* synthetic */ 4 qkX;

    i$4$7(4 4, String str, String str2, int i, int i2, double d, double d2, float f) {
        this.qkX = 4;
        this.ffJ = str;
        this.pZW = str2;
        this.pZX = i;
        this.pZY = i2;
        this.dSA = d;
        this.pZZ = d2;
        this.qaa = f;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.RG(this.ffJ);
            this.qkX.qkV.qfM.a(this.pZW, this.pZX, this.pZY, this.dSA, this.pZZ, this.qaa);
        }
    }
}
