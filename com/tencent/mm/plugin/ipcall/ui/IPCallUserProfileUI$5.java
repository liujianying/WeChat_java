package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

class IPCallUserProfileUI$5 implements OnLongClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;
    final /* synthetic */ TextView kzz;

    IPCallUserProfileUI$5(IPCallUserProfileUI iPCallUserProfileUI, TextView textView) {
        this.kzx = iPCallUserProfileUI;
        this.kzz = textView;
    }

    public final boolean onLongClick(View view) {
        IPCallUserProfileUI.a(this.kzx, this.kzz);
        return true;
    }
}
