package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.masssend.a;

class MassSendHistoryUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$2(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (MassSendHistoryUI.g(this.lbg)) {
            this.lbg.finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            a.ezn.q(intent, this.lbg);
            this.lbg.finish();
        }
        return true;
    }
}
