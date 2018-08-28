package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2;

class SettingsChattingUI$2$3 implements OnClickListener {
    final /* synthetic */ 2 mSb;

    SettingsChattingUI$2$3(2 2) {
        this.mSb = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, Integer.valueOf(5), Integer.valueOf(3), "");
        SettingsChattingUI.a(this.mSb.mSa).show();
        SettingsChattingUI.a(this.mSb.mSa, false);
        SettingsChattingUI.b(this.mSb.mSa);
    }
}
