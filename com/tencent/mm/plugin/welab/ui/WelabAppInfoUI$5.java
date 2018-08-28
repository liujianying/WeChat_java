package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.a;

class WelabAppInfoUI$5 implements OnClickListener {
    final /* synthetic */ WelabAppInfoUI qng;

    WelabAppInfoUI$5(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final void onClick(View view) {
        String obj = view.getTag().toString();
        Intent intent = new Intent();
        intent.putExtra("nowUrl", obj);
        intent.putExtra("urlList", (String[]) ((a) WelabAppInfoUI.e(this.qng).getAdapter()).hWN.toArray(new String[0]));
        WelabAppInfoUI welabAppInfoUI = this.qng;
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        d.b(welabAppInfoUI, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
    }
}
