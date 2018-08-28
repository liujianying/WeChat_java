package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class RoomExptDebugUI$3 implements OnClickListener {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$3(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void onClick(View view) {
        a.aIx().aIB();
        RoomExptDebugUI.c(this.iIF);
        Toast.makeText(this.iIF, "reset finish", 0).show();
    }
}
