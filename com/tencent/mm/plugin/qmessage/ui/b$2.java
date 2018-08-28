package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class b$2 implements OnClickListener {
    final /* synthetic */ b mbL;
    final /* synthetic */ CheckBoxPreference mbM;

    b$2(b bVar, CheckBoxPreference checkBoxPreference) {
        this.mbL = bVar;
        this.mbM = checkBoxPreference;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mbM.qpJ = true;
        this.mbL.auv();
    }
}
