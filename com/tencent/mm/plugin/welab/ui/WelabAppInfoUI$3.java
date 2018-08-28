package com.tencent.mm.plugin.welab.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.x;

class WelabAppInfoUI$3 implements OnClickListener {
    final /* synthetic */ WelabAppInfoUI qng;

    WelabAppInfoUI$3(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final void onClick(View view) {
        x.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(this.qng));
        b bYI = b.bYI();
        WelabAppInfoUI welabAppInfoUI = this.qng;
        String b = WelabAppInfoUI.b(this.qng);
        com.tencent.mm.plugin.welab.a.a.b bVar = (com.tencent.mm.plugin.welab.a.a.b) bYI.qmN.get(b);
        if (bVar != null) {
            x.i("WelabMgr", "use custome opener to open " + b);
            bVar.e(welabAppInfoUI, b);
        } else {
            x.i("WelabMgr", "use default opener open " + b);
            if (bYI.RT(b).field_Type != 2) {
                x.e("WelabMgr", "can not find opener for " + b);
            } else if (bYI.qmO != null) {
                bYI.qmO.e(welabAppInfoUI, b);
            } else {
                x.e("WelabMgr", "defaultWeAppOpener is null!");
            }
        }
        e.n(WelabAppInfoUI.b(this.qng), 7, WelabAppInfoUI.c(this.qng));
    }
}
