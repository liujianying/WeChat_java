package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftAcceptUI$1 implements OnCancelListener {
    final /* synthetic */ CardGiftAcceptUI hCZ;

    CardGiftAcceptUI$1(CardGiftAcceptUI cardGiftAcceptUI) {
        this.hCZ = cardGiftAcceptUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (CardGiftAcceptUI.a(this.hCZ) != null && CardGiftAcceptUI.a(this.hCZ).isShowing()) {
            CardGiftAcceptUI.a(this.hCZ).dismiss();
        }
        x.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        this.hCZ.finish();
    }
}
