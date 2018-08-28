package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class j extends h {
    private View qvI;

    public j(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(8);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setOnClickListener(null);
        this.qvv.setOnClickListener(new 1(this));
    }

    public final void a(b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -1) {
            LayoutParams layoutParams = (LayoutParams) this.qvw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.qvw.setLayoutParams(layoutParams);
            this.qvv.setVisibility(0);
            this.qvI = this.SU.findViewById(R.h.note_split_line);
        }
    }

    public final int caZ() {
        return -1;
    }
}
