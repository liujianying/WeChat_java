package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class i extends h {
    private ImageView qvG;
    private TextView qvH;

    public i(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(8);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setOnClickListener(null);
        this.qvG = (ImageView) view.findViewById(R.h.note_reminder_iv);
        this.qvH = (TextView) view.findViewById(R.h.note_reminder_tv);
    }

    public final void a(b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -4) {
            this.qvx.setVisibility(0);
        }
    }

    public final int caZ() {
        return -4;
    }
}
