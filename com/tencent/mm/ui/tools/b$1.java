package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.storage.ab;

class b$1 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ ab hMD;
    final /* synthetic */ d uvL;
    final /* synthetic */ boolean uvM;
    final /* synthetic */ int uvN;
    final /* synthetic */ Runnable uvO;

    b$1(d dVar, Activity activity, ab abVar, boolean z, int i, Runnable runnable) {
        this.uvL = dVar;
        this.ews = activity;
        this.hMD = abVar;
        this.uvM = z;
        this.uvN = i;
        this.uvO = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.uvL, this.ews, this.hMD, this.uvM, this.uvN);
        if (this.uvO != null) {
            this.uvO.run();
        }
    }
}
