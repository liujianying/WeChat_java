package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a;
import java.util.LinkedList;

class IPCallUserProfileUI$8 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;

    IPCallUserProfileUI$8(IPCallUserProfileUI iPCallUserProfileUI) {
        this.kzx = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(12766, new Object[]{Integer.valueOf(3)});
        a aVar = new a(this.kzx, new 1(this));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(86));
        aVar.qHX = new 2(this);
        aVar.b(IPCallUserProfileUI.c(this.kzx), linkedList, true);
    }
}
