package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.c.q;

class MallIndexUI$9 implements OnClickListener {
    final /* synthetic */ MallIndexUI lab;

    MallIndexUI$9(MallIndexUI mallIndexUI) {
        this.lab = mallIndexUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        d.b(this.lab.mController.tml, "offline", ".ui.WalletOfflineEntranceUI", intent);
        q.fu(9, 0);
        h.mEJ.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
        h.mEJ.h(14419, new Object[]{this.lab.fMk, Integer.valueOf(1)});
    }
}
