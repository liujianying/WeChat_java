package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VoiceInputUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ VoiceInputUI qHV;

    VoiceInputUI$3(VoiceInputUI voiceInputUI) {
        this.qHV = voiceInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VoiceInputUI.c(this.qHV).setText("");
        VoiceInputUI.d(this.qHV);
        this.qHV.BW(6);
        return true;
    }
}
