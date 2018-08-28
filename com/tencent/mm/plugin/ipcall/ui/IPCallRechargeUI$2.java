package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class IPCallRechargeUI$2 implements OnClickListener {
    final /* synthetic */ IPCallRechargeUI kxB;
    final /* synthetic */ String kxC;

    IPCallRechargeUI$2(IPCallRechargeUI iPCallRechargeUI, String str) {
        this.kxB = iPCallRechargeUI;
        this.kxC = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.kxC);
        intent.putExtra("showShare", false);
        d.b(this.kxB, "webview", ".ui.tools.WebViewUI", intent);
    }
}
