package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.sdk.platformtools.bi;

class CardListSelectedUI$5 implements OnClickListener {
    final /* synthetic */ CardListSelectedUI hFs;

    CardListSelectedUI$5(CardListSelectedUI cardListSelectedUI) {
        this.hFs = cardListSelectedUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.hFs.hFp)) {
            b.a(this.hFs, this.hFs.hFp, this.hFs.getString(g.card_invoice_url_slogan));
        }
    }
}
