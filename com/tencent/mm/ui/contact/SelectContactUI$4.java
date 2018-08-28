package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.b.a;

class SelectContactUI$4 implements OnCancelListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$4(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SelectContactUI.d(this.ulL, false);
        if (SelectContactUI.f(this.ulL) != null) {
            SelectContactUI.f(this.ulL).bTO.bTN = true;
            a.sFg.m(SelectContactUI.f(this.ulL));
        }
    }
}
