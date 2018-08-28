package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class EditHintView$8 implements OnClickListener {
    final /* synthetic */ EditHintView uYF;

    EditHintView$8(EditHintView editHintView) {
        this.uYF = editHintView;
    }

    public final void onClick(View view) {
        if (EditHintView.l(this.uYF).getVisibility() != 0) {
            return;
        }
        if (this.uYF.eYJ && !bi.oW(this.uYF.getText())) {
            this.uYF.uYu.ClearInput();
        } else if (EditHintView.f(this.uYF) != 1) {
            EditHintView.o(this.uYF);
        } else if (EditHintView.m(this.uYF) != null && !EditHintView.n(this.uYF)) {
        }
    }
}
