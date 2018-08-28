package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.y;
import com.tencent.mm.ac.z;

class c$16 implements OnCancelListener {
    final /* synthetic */ c lVT;
    final /* synthetic */ y lVX;

    c$16(c cVar, y yVar) {
        this.lVT = cVar;
        this.lVX = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        z.Nh();
        c.a(this.lVX);
    }
}
