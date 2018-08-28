package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.sdk.platformtools.x;

class SnsSightUploadSayFooter$5 implements ChatFooterPanel$a {
    final /* synthetic */ SnsSightUploadSayFooter obk;

    SnsSightUploadSayFooter$5(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.obk = snsSightUploadSayFooter;
    }

    public final void bbF() {
    }

    public final void gp(boolean z) {
    }

    public final void apK() {
        SnsSightUploadSayFooter.b(this.obk).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsSightUploadSayFooter.b(this.obk).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            SnsSightUploadSayFooter.b(this.obk).abr(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
        }
    }
}
