package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class MallIndexUI$10 implements OnClickListener {
    final /* synthetic */ MallIndexUI lab;

    MallIndexUI$10(MallIndexUI mallIndexUI) {
        this.lab = mallIndexUI;
    }

    public final void onClick(View view) {
        x.i("MicorMsg.MallIndexUI", "onClick lqtEntrance, isLqbOpen: %s, lqbOpenUrl: %s", new Object[]{Boolean.valueOf(MallIndexUI.e(this.lab)), MallIndexUI.f(this.lab)});
        g.Ek();
        g.Ei().DT().a(a.sXP, Integer.valueOf(-1));
        MallIndexUI.g(this.lab).setVisibility(8);
        if (MallIndexUI.e(this.lab)) {
            d.A(this.lab.mController.tml, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        } else if (!bi.oW(MallIndexUI.f(this.lab))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", MallIndexUI.f(this.lab));
            x.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
            d.b(this.lab, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
