package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class CardHomePageUI$8 implements OnClickListener {
    final /* synthetic */ CardHomePageUI hEJ;

    CardHomePageUI$8(CardHomePageUI cardHomePageUI) {
        this.hEJ = cardHomePageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.hEJ, CardIndexUI.class);
        intent.putExtra("key_card_type", 3);
        this.hEJ.startActivity(intent);
        h.mEJ.h(11324, new Object[]{"ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
