package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;

class c$2 implements OnClickListener {
    c$2() {
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof n) {
            n nVar = (n) view.getTag();
            if (nVar != null && !bi.oW(nVar.bAK())) {
                c.Q(view.getContext(), nVar.bAK());
            }
        }
    }
}
