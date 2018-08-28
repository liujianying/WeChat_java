package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

class CardGiftReceiveUI$1 implements OnGlobalLayoutListener {
    final /* synthetic */ CardGiftReceiveUI hEd;

    CardGiftReceiveUI$1(CardGiftReceiveUI cardGiftReceiveUI) {
        this.hEd = cardGiftReceiveUI;
    }

    public final void onGlobalLayout() {
        x.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[]{Integer.valueOf(a.fromDPToPix(this.hEd.mController.tml, 67)), Integer.valueOf(CardGiftReceiveUI.a(this.hEd).getChildAt(0).getHeight() + a.fromDPToPix(this.hEd.mController.tml, 67)), Integer.valueOf(this.hEd.getWindow().findViewById(16908290).getHeight())});
        CardGiftReceiveUI.a(this.hEd).setFillViewport(true);
        if (CardGiftReceiveUI.a(this.hEd).getChildAt(0).getHeight() + a.fromDPToPix(this.hEd.mController.tml, 67) > this.hEd.getWindow().findViewById(16908290).getHeight()) {
            CardGiftReceiveUI.a(this.hEd, true);
        } else {
            CardGiftReceiveUI.a(this.hEd, false);
        }
        CardGiftReceiveUI.a(this.hEd).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
