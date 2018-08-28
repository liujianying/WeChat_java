package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class RoomExptDebugUI$5 implements OnClickListener {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$5(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void onClick(View view) {
        a.aIx().iIp = 3;
        Toast.makeText(this.iIF, "set show finish", 0).show();
    }
}
