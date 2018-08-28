package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$6 implements Runnable {
    final /* synthetic */ WalletBindCardResultUI ptz;

    WalletBindCardResultUI$6(WalletBindCardResultUI walletBindCardResultUI) {
        this.ptz = walletBindCardResultUI;
    }

    public final void run() {
        if (WalletBindCardResultUI.g(this.ptz).getVisibility() == 0 && WalletBindCardResultUI.h(this.ptz).getRight() >= WalletBindCardResultUI.g(this.ptz).getLeft() && !bi.K(WalletBindCardResultUI.h(this.ptz).getText())) {
            float textSize = WalletBindCardResultUI.h(this.ptz).getTextSize();
            x.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletBindCardResultUI.h(this.ptz).getRight()), Integer.valueOf(WalletBindCardResultUI.g(this.ptz).getLeft()));
            Paint paint = new Paint();
            paint.setTextSize(textSize);
            String charSequence = WalletBindCardResultUI.h(this.ptz).getText().toString();
            float measureText = paint.measureText(charSequence) - ((float) (WalletBindCardResultUI.h(this.ptz).getRight() - WalletBindCardResultUI.g(this.ptz).getLeft()));
            int i = 1;
            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                i++;
            }
            x.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
            WalletBindCardResultUI.h(this.ptz).setText(charSequence.substring(0, (charSequence.length() - i) - 1));
            WalletBindCardResultUI.h(this.ptz).append("...");
        }
    }
}
