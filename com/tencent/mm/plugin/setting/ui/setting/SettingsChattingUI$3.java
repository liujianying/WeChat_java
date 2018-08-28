package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.ny;
import com.tencent.mm.model.bd.a;

class SettingsChattingUI$3 implements a {
    final /* synthetic */ SettingsChattingUI mSa;

    SettingsChattingUI$3(SettingsChattingUI settingsChattingUI) {
        this.mSa = settingsChattingUI;
    }

    public final boolean Ip() {
        return SettingsChattingUI.c(this.mSa);
    }

    public final void Io() {
        if (SettingsChattingUI.a(this.mSa) != null) {
            SettingsChattingUI.a(this.mSa).dismiss();
            SettingsChattingUI.a(this.mSa, null);
        }
        com.tencent.mm.sdk.b.a.sFg.m(new ny());
    }
}
