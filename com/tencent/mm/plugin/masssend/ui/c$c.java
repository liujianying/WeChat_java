package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.sdk.platformtools.x;

class c$c implements OnClickListener {
    private String fileName;
    final /* synthetic */ c laQ;
    private int length;
    private int size;
    private int videoSource;

    public c$c(c cVar, String str, int i, int i2, int i3) {
        this.laQ = cVar;
        this.fileName = str;
        this.videoSource = i;
        this.length = i3;
        this.size = i2;
    }

    public final void onClick(View view) {
        au.HU();
        if (c.isSDCardAvailable()) {
            boolean z = this.videoSource == 2;
            o.Ta();
            x.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[]{this.fileName, Boolean.valueOf(z), Boolean.valueOf(q.nD(s.nK(this.fileName)))});
            a.ezn.a(z, r2, c.a(this.laQ), this.fileName, this.length, this.size);
            return;
        }
        com.tencent.mm.ui.base.s.gH(c.a(this.laQ));
    }
}
