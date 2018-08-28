package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$3 implements OnCancelListener {
    final /* synthetic */ CardGiftReceiveUI hEd;

    CardGiftReceiveUI$3(CardGiftReceiveUI cardGiftReceiveUI) {
        this.hEd = cardGiftReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (CardGiftReceiveUI.c(this.hEd) != null && CardGiftReceiveUI.c(this.hEd).isShowing()) {
            CardGiftReceiveUI.c(this.hEd).dismiss();
        }
        if (CardGiftReceiveUI.d(this.hEd).getVisibility() == 8 || CardGiftReceiveUI.e(this.hEd).getVisibility() == 4) {
            x.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            this.hEd.finish();
        }
    }
}
