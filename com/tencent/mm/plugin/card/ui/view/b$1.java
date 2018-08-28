package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.card.b.f;

class b$1 implements OnClickListener {
    final /* synthetic */ f hHq;
    final /* synthetic */ b hHr;

    b$1(b bVar, f fVar) {
        this.hHr = bVar;
        this.hHq = fVar;
    }

    public final void onClick(View view) {
        if (((CheckBox) view).isChecked()) {
            this.hHq.awL().hvk = true;
        } else {
            this.hHq.awL().hvk = false;
        }
    }
}
