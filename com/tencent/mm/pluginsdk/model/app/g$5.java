package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g.a;

class g$5 implements OnClickListener {
    final /* synthetic */ a jLF;
    final /* synthetic */ String qzJ;
    final /* synthetic */ String qzK;
    final /* synthetic */ String sg;

    g$5(String str, String str2, String str3, a aVar) {
        this.sg = str;
        this.qzJ = str2;
        this.qzK = str3;
        this.jLF = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), this.sg, this.qzJ, this.qzK});
        if (this.jLF != null) {
            this.jLF.cI(false);
        }
    }
}
