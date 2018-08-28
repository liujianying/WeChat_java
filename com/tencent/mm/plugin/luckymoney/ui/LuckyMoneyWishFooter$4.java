package com.tencent.mm.plugin.luckymoney.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyWishFooter$4 implements ChatFooterPanel$a {
    final /* synthetic */ LuckyMoneyWishFooter kXP;

    LuckyMoneyWishFooter$4(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.kXP = luckyMoneyWishFooter;
    }

    public final void bbF() {
    }

    public final void gp(boolean z) {
    }

    public final void apK() {
        LuckyMoneyWishFooter.a(this.kXP).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        LuckyMoneyWishFooter.a(this.kXP).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            LuckyMoneyWishFooter.a(this.kXP).abr(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
        }
    }
}
