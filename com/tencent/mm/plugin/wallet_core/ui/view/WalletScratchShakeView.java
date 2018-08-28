package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class WalletScratchShakeView extends FrameLayout {
    boolean pAa;
    boolean pAb;
    private a pAc;
    b pzZ;

    public WalletScratchShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScratchShakeCallback(a aVar) {
        this.pAc = aVar;
    }

    public final void onDestroy() {
        if (this.pzZ != null) {
            b bVar = this.pzZ;
            x.i("MicroMsg.WalletScratchShakeView", "onDestroy");
            if (bVar.lAY != null) {
                bVar.lAY.aDc();
            }
        }
    }
}
