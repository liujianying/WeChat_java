package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

class OpenFileChooserUI$6 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ OpenFileChooserUI pWh;

    OpenFileChooserUI$6(OpenFileChooserUI openFileChooserUI, String str) {
        this.pWh = openFileChooserUI;
        this.dat = str;
    }

    public final void run() {
        List arrayList = new ArrayList();
        int a = OpenFileChooserUI.a(this.pWh, this.dat);
        if (a == -50002) {
            ah.A(new 1(this));
            return;
        }
        String o;
        String d;
        if (a == -50006) {
            o = OpenFileChooserUI.o(this.dat, arrayList);
            OpenFileChooserUI.b(this.pWh, this.dat);
            d = OpenFileChooserUI.d(this.pWh);
        } else if (a == 1) {
            o = OpenFileChooserUI.c(this.pWh, this.dat);
            OpenFileChooserUI.b(this.pWh, this.dat);
            d = OpenFileChooserUI.d(this.pWh);
            if (bi.oW(o) && OpenFileChooserUI.b(this.pWh) == 7 && OpenFileChooserUI.c(this.pWh) == 2) {
                ah.A(new 2(this));
                return;
            }
        } else {
            ah.A(new 3(this));
            return;
        }
        if (bi.oW(o)) {
            ah.A(new 5(this));
        } else {
            ah.A(new 4(this, o, d));
        }
    }
}
