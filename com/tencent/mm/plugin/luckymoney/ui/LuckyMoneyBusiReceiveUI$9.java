package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.t;

class LuckyMoneyBusiReceiveUI$9 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI kUO;
    final /* synthetic */ t kUQ;

    LuckyMoneyBusiReceiveUI$9(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI, t tVar) {
        this.kUO = luckyMoneyBusiReceiveUI;
        this.kUQ = tVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.kUO.mController.tml, LuckyMoneyBusiDetailUI.class);
        if (this.kUQ.kMP != null) {
            intent.putExtra("key_realname_guide_helper", this.kUQ.kMP);
        }
        intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(this.kUO));
        intent.putExtra("key_sendid", this.kUQ.kLZ);
        intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(this.kUO));
        this.kUO.startActivity(intent);
        this.kUO.finish();
    }
}
