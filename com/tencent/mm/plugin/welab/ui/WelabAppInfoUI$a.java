package com.tencent.mm.plugin.welab.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.b;
import java.util.List;

class WelabAppInfoUI$a extends a<b> {
    public List<String> hWN;
    final /* synthetic */ WelabAppInfoUI qng;

    public WelabAppInfoUI$a(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final int getItemCount() {
        return this.hWN.size();
    }
}
