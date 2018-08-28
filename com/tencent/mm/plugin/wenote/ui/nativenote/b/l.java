package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class l extends h {
    public l(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(0);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setTag(this);
        this.qvq.setOnClickListener(this.jXR);
    }

    public final void a(b bVar, int i, int i2) {
        this.qvt.setImageResource(R.k.msg_state_fail_resend);
        this.qvr.setText(((i) bVar).title);
        this.qvs.setText(((i) bVar).content);
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 0;
    }
}
