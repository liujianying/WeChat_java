package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.q;

class NewTaskUI$2 implements OnCancelListener {
    final /* synthetic */ NewTaskUI uBg;
    final /* synthetic */ q uBh;

    NewTaskUI$2(NewTaskUI newTaskUI, q qVar) {
        this.uBg = newTaskUI;
        this.uBh = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.uBh);
    }
}
