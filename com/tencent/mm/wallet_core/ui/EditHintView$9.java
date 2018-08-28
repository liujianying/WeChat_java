package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class EditHintView$9 implements OnClickListener {
    final /* synthetic */ EditHintView uYF;

    EditHintView$9(EditHintView editHintView) {
        this.uYF = editHintView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EditHintView.p(this.uYF).dismiss();
    }
}
