package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;

class MallIndexBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexBaseUI kZq;

    MallIndexBaseUI$1(MallIndexBaseUI mallIndexBaseUI) {
        this.kZq = mallIndexBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        d.e(this.kZq, "com.tencent.mm.ui.LauncherUI", intent);
        this.kZq.finish();
        if (!f.cfE()) {
            h.mEJ.h(14954, new Object[]{f.cfF(), "open_wcpay_specific_view:ok"});
            f.cfG();
        }
        h.mEJ.h(14419, new Object[]{this.kZq.fMk, Integer.valueOf(6)});
        x.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
        return true;
    }
}
