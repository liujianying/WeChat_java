package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.LinkedList;

class SelectContactUI$7 implements OnClickListener {
    final /* synthetic */ SelectContactUI ulL;
    final /* synthetic */ LinkedList ulO;

    SelectContactUI$7(SelectContactUI selectContactUI, LinkedList linkedList) {
        this.ulL = selectContactUI;
        this.ulO = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SelectContactUI.a(this.ulL, this.ulO);
    }
}
