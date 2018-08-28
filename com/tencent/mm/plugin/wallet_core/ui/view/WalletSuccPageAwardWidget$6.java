package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$6 implements Runnable {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$6(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void run() {
        try {
            if (WalletSuccPageAwardWidget.p(this.pAM).getVisibility() == 0 && WalletSuccPageAwardWidget.q(this.pAM).getRight() > 0 && WalletSuccPageAwardWidget.p(this.pAM).getLeft() > 0 && WalletSuccPageAwardWidget.q(this.pAM).getRight() >= WalletSuccPageAwardWidget.p(this.pAM).getLeft() && !bi.K(WalletSuccPageAwardWidget.q(this.pAM).getText())) {
                float textSize = WalletSuccPageAwardWidget.q(this.pAM).getTextSize();
                x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[]{Integer.valueOf(WalletSuccPageAwardWidget.q(this.pAM).getRight()), Integer.valueOf(WalletSuccPageAwardWidget.p(this.pAM).getLeft())});
                Paint paint = new Paint();
                paint.setTextSize(textSize);
                String charSequence = WalletSuccPageAwardWidget.q(this.pAM).getText().toString();
                float left = (float) (WalletSuccPageAwardWidget.p(this.pAM).getLeft() - WalletSuccPageAwardWidget.q(this.pAM).getLeft());
                int i = 1;
                while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                    i++;
                }
                x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(charSequence.length())});
                CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                if (charSequence.length() > 9 && substring.length() < 9) {
                    substring = charSequence.substring(0, 9);
                }
                WalletSuccPageAwardWidget.q(this.pAM).setText(substring);
                WalletSuccPageAwardWidget.q(this.pAM).append("...");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "calc nameTv len error: %s", new Object[]{e.getMessage()});
        }
    }
}
