package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyBusiDetailUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;
    final /* synthetic */ f kUy;

    LuckyMoneyBusiDetailUI$4(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, f fVar) {
        this.kUw = luckyMoneyBusiDetailUI;
        this.kUy = fVar;
    }

    public final void onClick(View view) {
        if (TextUtils.isEmpty(this.kUy.kNh)) {
            e.He(12);
            h.ab(this.kUw.mController.tml, 1);
            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
            return;
        }
        x.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + this.kUy.kNh);
        if (this.kUy.kNh.startsWith("weixin://wxpay")) {
            e.He(12);
            h.ab(this.kUw.mController.tml, 1);
            return;
        }
        e.He(7);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.kUy.kNh);
        d.b(this.kUw.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
