package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;

class RoomExptDebugUI$1 implements OnClickListener {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$1(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void onClick(View view) {
        g.Em().H(new 1(this));
    }
}
