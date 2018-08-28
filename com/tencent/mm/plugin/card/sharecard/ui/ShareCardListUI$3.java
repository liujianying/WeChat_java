package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.report.service.h;

class ShareCardListUI$3 implements OnClickListener {
    final /* synthetic */ ShareCardListUI hAq;

    ShareCardListUI$3(ShareCardListUI shareCardListUI) {
        this.hAq = shareCardListUI;
    }

    public final void onClick(View view) {
        ShareCardListUI.c(this.hAq);
        if (b.axI()) {
            ShareCardListUI.c(this.hAq);
            if (b.axH()) {
                ShareCardListUI.a(this.hAq, 2);
                h.mEJ.h(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
                am.axn().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.hAq)));
                ShareCardListUI.e(this.hAq);
                ShareCardListUI.f(this.hAq).aL();
                ShareCardListUI.c(this.hAq);
                b.hyf = true;
            }
        }
        ShareCardListUI.c(this.hAq);
        if (b.axH()) {
            ShareCardListUI.a(this.hAq, 3);
        }
        h.mEJ.h(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
        am.axn().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.hAq)));
        ShareCardListUI.e(this.hAq);
        ShareCardListUI.f(this.hAq).aL();
        ShareCardListUI.c(this.hAq);
        b.hyf = true;
    }
}
