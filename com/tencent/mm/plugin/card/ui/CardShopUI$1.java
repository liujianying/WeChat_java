package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.x;

class CardShopUI$1 implements OnItemClickListener {
    final /* synthetic */ CardShopUI hGu;
    final /* synthetic */ Intent val$intent;

    CardShopUI$1(CardShopUI cardShopUI, Intent intent) {
        this.hGu = cardShopUI;
        this.val$intent = intent;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            return;
        }
        if (i > 0) {
            i--;
        }
        la laVar = (la) CardShopUI.a(this.hGu).get(i);
        if (!TextUtils.isEmpty(laVar.rnv) && !TextUtils.isEmpty(laVar.rnw)) {
            b.e(CardShopUI.b(this.hGu), laVar.rnv, laVar.rnw, 1052, this.val$intent.getIntExtra("key_from_appbrand_type", 0));
        } else if (!TextUtils.isEmpty(laVar.hwI)) {
            b.a(this.hGu, laVar.hwI, 1);
            h.mEJ.h(11941, new Object[]{Integer.valueOf(4), CardShopUI.c(this.hGu).awq(), CardShopUI.c(this.hGu).awr(), "", laVar.name});
        }
    }
}
