package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.widget.b.a;

class SettingCheckUnProcessWalletConvUI$4 implements OnItemLongClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI urE;

    SettingCheckUnProcessWalletConvUI$4(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.urE = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ai FU = SettingCheckUnProcessWalletConvUI.b(this.urE).FU(i - SettingCheckUnProcessWalletConvUI.c(this.urE).getHeaderViewsCount());
        if (FU == null) {
            return true;
        }
        String str = FU.field_username;
        a aVar = new a(this.urE);
        aVar.uKW = new 1(this);
        aVar.a(view, i, j, this.urE, new 2(this, str, FU), SettingCheckUnProcessWalletConvUI.a(this.urE)[0], SettingCheckUnProcessWalletConvUI.a(this.urE)[1]);
        return true;
    }
}
