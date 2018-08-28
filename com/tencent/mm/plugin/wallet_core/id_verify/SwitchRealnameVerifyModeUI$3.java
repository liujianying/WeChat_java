package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.q$a;

class SwitchRealnameVerifyModeUI$3 implements q$a {
    final /* synthetic */ View gvo;
    final /* synthetic */ SwitchRealnameVerifyModeUI pkr;

    SwitchRealnameVerifyModeUI$3(SwitchRealnameVerifyModeUI switchRealnameVerifyModeUI, View view) {
        this.pkr = switchRealnameVerifyModeUI;
        this.gvo = view;
    }

    public final void bcc() {
        this.pkr.onClickImp(this.gvo);
        SwitchRealnameVerifyModeUI.b(this.pkr);
    }

    public final void cancel() {
        SwitchRealnameVerifyModeUI.c(this.pkr).bIq = false;
    }

    public final void bcd() {
        this.pkr.onClickImp(this.gvo);
    }
}
