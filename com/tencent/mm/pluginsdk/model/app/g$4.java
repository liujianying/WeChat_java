package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g.a;

class g$4 implements OnClickListener {
    final /* synthetic */ a jLF;
    final /* synthetic */ String qzJ;
    final /* synthetic */ String qzK;
    final /* synthetic */ String sg;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    g$4(Context context, Intent intent, String str, String str2, String str3, a aVar) {
        this.val$context = context;
        this.val$intent = intent;
        this.sg = str;
        this.qzJ = str2;
        this.qzK = str3;
        this.jLF = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.val$context.startActivity(this.val$intent);
        h.mEJ.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.sg, this.qzJ, this.qzK});
        if (this.jLF != null) {
            this.jLF.cI(true);
        }
    }
}
