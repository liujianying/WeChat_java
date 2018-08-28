package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class RoomExptDebugUI$4 implements OnClickListener {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$4(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void onClick(View view) {
        a.aIx().aIA();
        RoomExptDebugUI.d(this.iIF).clear();
        Toast.makeText(this.iIF, "del db finish", 0).show();
    }
}
