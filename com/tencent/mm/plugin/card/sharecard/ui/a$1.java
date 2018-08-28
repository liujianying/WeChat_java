package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;

class a$1 implements OnClickListener {
    final /* synthetic */ a hyY;

    a$1(a aVar) {
        this.hyY = aVar;
    }

    public final void onClick(View view) {
        if (view.getId() != d.notify_checkbox) {
            return;
        }
        if (this.hyY.hyR.isChecked()) {
            if (this.hyY.hyV != null) {
                this.hyY.hyV.nO(1);
            }
        } else if (this.hyY.hyV != null) {
            this.hyY.hyV.nO(0);
        }
    }
}
