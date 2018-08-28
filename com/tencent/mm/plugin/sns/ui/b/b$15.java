package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.x;

class b$15 implements OnClickListener {
    final /* synthetic */ b olf;

    b$15(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            String str = (String) view.getTag();
            x.d("MicroMsg.TimelineClickListener", "localId " + str);
            aj.wz(v.NF(str));
            aj.wx(v.NF(str));
            af.byk().bwX();
            this.olf.bBS();
            if (this.olf.olc != null) {
                this.olf.olc.bDV();
            }
        }
    }
}
