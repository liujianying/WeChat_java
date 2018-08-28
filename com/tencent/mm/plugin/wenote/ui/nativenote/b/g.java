package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class g extends h {
    public g(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(0);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setTag(this);
        this.qvq.setOnClickListener(this.jXR);
    }

    public final void a(b bVar, int i, int i2) {
        this.qvt.setImageResource(R.k.app_attach_file_icon_location);
        this.qvr.setText(((f) bVar).kFa);
        this.qvs.setText(((f) bVar).dRH);
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 3;
    }
}
