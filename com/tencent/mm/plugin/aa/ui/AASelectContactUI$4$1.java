package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AASelectContactUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 eCz;

    AASelectContactUI$4$1(4 4) {
        this.eCz = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (((long) AASelectContactUI.b(this.eCz.eCw).size()) > AASelectContactUI.d(this.eCz.eCw)) {
            h.b(this.eCz.eCw.mController.tml, this.eCz.eCw.getString(i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Long.valueOf(AASelectContactUI.d(this.eCz.eCw))}), "", true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13722, new Object[]{Integer.valueOf(3)});
            return;
        }
        List linkedList = new LinkedList();
        linkedList.addAll(AASelectContactUI.b(this.eCz.eCw));
        this.eCz.eCw.setResult(-1, this.eCz.eCw.getIntent().putExtra("Select_Contact", bi.c(linkedList, ",")));
        this.eCz.eCw.finish();
        com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(11)});
    }
}
