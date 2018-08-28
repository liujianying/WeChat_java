package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.plugin.report.service.h;

class NormalUserFooterPreference$c$2 implements OnClickListener {
    final /* synthetic */ c lXI;

    NormalUserFooterPreference$c$2(c cVar) {
        this.lXI = cVar;
    }

    public final void onClick(View view) {
        this.lXI.bnF();
        if (NormalUserFooterPreference.E(this.lXI.lXw) != 0) {
            h.mEJ.h(11263, new Object[]{Integer.valueOf(NormalUserFooterPreference.E(this.lXI.lXw)), NormalUserFooterPreference.a(this.lXI.lXw).field_username});
        }
    }
}
