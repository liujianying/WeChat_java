package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$6 implements Runnable {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$6(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void run() {
        try {
            if (WalletOrderInfoNewUI.r(this.pwh).getVisibility() == 0 && WalletOrderInfoNewUI.s(this.pwh).getRight() > 0 && WalletOrderInfoNewUI.r(this.pwh).getLeft() > 0 && WalletOrderInfoNewUI.s(this.pwh).getRight() >= WalletOrderInfoNewUI.r(this.pwh).getLeft() && !bi.K(WalletOrderInfoNewUI.s(this.pwh).getText())) {
                float textSize = WalletOrderInfoNewUI.s(this.pwh).getTextSize();
                x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[]{Integer.valueOf(WalletOrderInfoNewUI.s(this.pwh).getRight()), Integer.valueOf(WalletOrderInfoNewUI.r(this.pwh).getLeft())});
                Paint paint = new Paint();
                paint.setTextSize(textSize);
                String charSequence = WalletOrderInfoNewUI.s(this.pwh).getText().toString();
                float left = (float) (WalletOrderInfoNewUI.r(this.pwh).getLeft() - WalletOrderInfoNewUI.s(this.pwh).getLeft());
                int i = 1;
                while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                    i++;
                }
                x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(charSequence.length())});
                CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                if (charSequence.length() > 9 && substring.length() < 9) {
                    substring = charSequence.substring(0, 9);
                }
                WalletOrderInfoNewUI.s(this.pwh).setText(substring);
                WalletOrderInfoNewUI.s(this.pwh).append("...");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", e, "calc tinyapp name error: %s", new Object[]{e.getMessage()});
        }
    }
}
