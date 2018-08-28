package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.model.bc.b;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements b {
    final /* synthetic */ j usn;
    final /* synthetic */ Context val$context;

    j$1(j jVar, Context context) {
        this.usn = jVar;
        this.val$context = context;
    }

    public final void Ij() {
        this.usn.usm.post(new Runnable() {
            public final void run() {
                if (j$1.this.usn.usm != null) {
                    j$1.this.usn.usm.setVisibility(8);
                    j$1.this.usn.usm.removeAllViews();
                }
                a a = e.a(j$1.this.val$context, e.a.urX, null);
                if (a == null) {
                    a = e.a(j$1.this.val$context, e.a.urR, null);
                }
                if (a != null && a.getView() != null) {
                    x.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[]{a, a.getView()});
                    j$1.this.usn.usm.setVisibility(0);
                    j$1.this.usn.usm.addView(a.getView(), new LayoutParams(-1, -2));
                }
            }
        });
    }
}
