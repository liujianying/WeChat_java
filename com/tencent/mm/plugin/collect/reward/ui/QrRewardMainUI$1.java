package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$1 implements TextWatcher {
    int hWe = 0;
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$1(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        x.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[]{editable.toString(), Integer.valueOf(editable.length())});
        CharSequence obj = editable.toString();
        if (bi.oW(obj)) {
            this.hWe = 0;
        } else if (this.hWe == 0) {
            if (((a) g.l(a.class)).u(obj) || ((a) g.l(a.class)).v(obj)) {
                this.hWe = editable.length();
            } else {
                this.hWe = 1;
            }
        }
        editable.delete(this.hWe, editable.length());
    }
}
