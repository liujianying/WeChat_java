package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class JDRemindDialog$1 implements OnClickListener {
    final /* synthetic */ JDRemindDialog oqC;

    JDRemindDialog$1(JDRemindDialog jDRemindDialog) {
        this.oqC = jDRemindDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = null;
        String str2 = "";
        if (!(this.oqC.getIntent() == null || this.oqC.getIntent().getExtras() == null)) {
            str = this.oqC.getIntent().getExtras().getString("alertjumpurl");
            str2 = this.oqC.getIntent().getExtras().getString("alert_activityid");
        }
        if (str2.equals(c.bGg().bGl().oqH) && c.bGg().bGh()) {
            c.bGg().bGk();
            c.bGg().bGj();
        }
        if (!bi.oW(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            d.b(this.oqC, "webview", ".ui.tools.WebViewUI", intent);
            h.mEJ.h(11179, new Object[]{str, c.bGg().bGl().oqH, Integer.valueOf(5)});
        }
        this.oqC.finish();
    }
}
