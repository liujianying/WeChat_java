package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$d implements OnClickListener {
    private String id;
    final /* synthetic */ c laQ;

    public c$d(c cVar, String str) {
        this.laQ = cVar;
        this.id = str;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
        if (c.b(this.laQ) != null) {
            c.a(this.laQ, c.b(this.laQ).Gm(this.id));
            this.laQ.notifyDataSetChanged();
        }
    }
}
