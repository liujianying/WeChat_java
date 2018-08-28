package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.aa.a;

class CardHomePageUI$7 implements OnClickListener {
    final /* synthetic */ CardHomePageUI hEJ;

    CardHomePageUI$7(CardHomePageUI cardHomePageUI) {
        this.hEJ = cardHomePageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.hEJ, ShareCardListUI.class);
        intent.putExtra("key_layout_buff", CardHomePageUI.e(this.hEJ));
        CardHomePageUI.f(this.hEJ);
        this.hEJ.startActivity(intent);
        l lVar = (l) am.axn().getValue("key_share_card_layout_data");
        if (lVar != null) {
            int i;
            int i2;
            int i3;
            int i4 = lVar.cal ? 1 : 0;
            if (lVar.cam) {
                i = 1;
            } else {
                i = 0;
            }
            if (lVar.hyy != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (TextUtils.isEmpty(lVar.hyz)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            h.mEJ.h(13685, new Object[]{Integer.valueOf(2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            if (lVar.cam) {
                CardHomePageUI.g(this.hEJ);
                lVar.cam = false;
            }
            if (lVar.cal) {
                CardHomePageUI.g(this.hEJ);
                lVar.cal = false;
                lVar.hyy = null;
                lVar.hyz = "";
            }
        }
        g.Ei().DT().a(a.sPU, "");
        h.mEJ.h(11324, new Object[]{"ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
