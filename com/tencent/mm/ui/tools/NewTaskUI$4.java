package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NewTaskUI$4 implements OnCancelListener {
    final /* synthetic */ NewTaskUI uBg;

    NewTaskUI$4(NewTaskUI newTaskUI) {
        this.uBg = newTaskUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NewTaskUI.uBe != null) {
            NewTaskUI.uBe = null;
            this.uBg.finish();
        }
    }
}
