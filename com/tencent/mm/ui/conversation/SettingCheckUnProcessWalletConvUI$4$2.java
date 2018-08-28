package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4;

class SettingCheckUnProcessWalletConvUI$4$2 implements d {
    final /* synthetic */ String dhh;
    final /* synthetic */ ai taG;
    final /* synthetic */ 4 urF;

    SettingCheckUnProcessWalletConvUI$4$2(4 4, String str, ai aiVar) {
        this.urF = 4;
        this.dhh = str;
        this.taG = aiVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1) {
            b.a(this.dhh, this.urF.urE, this.taG, new Runnable() {
                public final void run() {
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI$4$2.this.urF.urE).remove(SettingCheckUnProcessWalletConvUI$4$2.this.dhh);
                    SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI$4$2.this.urF.urE).notifyDataSetChanged();
                }
            }, false, true);
        }
    }
}
