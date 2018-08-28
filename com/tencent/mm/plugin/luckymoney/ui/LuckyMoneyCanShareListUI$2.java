package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.sdk.platformtools.bi;

class LuckyMoneyCanShareListUI$2 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyCanShareListUI kUU;

    LuckyMoneyCanShareListUI$2(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        this.kUU = luckyMoneyCanShareListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i sm = LuckyMoneyCanShareListUI.a(this.kUU).sm((int) j);
        if (sm != null && !bi.oW(sm.kLZ)) {
            Intent intent = new Intent();
            intent.setClass(this.kUU.mController.tml, LuckyMoneyDetailUI.class);
            intent.putExtra("key_sendid", sm.kLZ);
            this.kUU.startActivity(intent);
        }
    }
}
