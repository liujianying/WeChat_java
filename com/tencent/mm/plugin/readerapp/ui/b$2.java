package com.tencent.mm.plugin.readerapp.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class b$2 implements OnClickListener {
    final /* synthetic */ b mnz;

    b$2(b bVar) {
        this.mnz = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(15413, new Object[]{Integer.valueOf(4), "", ""});
        b.m(this.mnz.context, false);
    }
}
