package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class IPCallUserProfileUI$4 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;
    final /* synthetic */ String kzy;

    IPCallUserProfileUI$4(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        this.kzx = iPCallUserProfileUI;
        this.kzy = str;
    }

    public final void onClick(View view) {
        IPCallUserProfileUI.a(this.kzx, this.kzy);
    }
}
