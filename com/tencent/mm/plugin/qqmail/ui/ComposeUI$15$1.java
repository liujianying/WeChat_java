package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.15;
import java.io.File;

class ComposeUI$15$1 implements OnClickListener {
    final /* synthetic */ 15 mfz;

    ComposeUI$15$1(15 15) {
        this.mfz = 15;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        File file = new File(w.bow().mda.mcd.mcn + c.bV(ComposeUI.J(this.mfz.mfs), ComposeUI.K(this.mfz.mfs)));
        if (file.exists()) {
            file.delete();
        }
        this.mfz.mfs.setResult(-1);
        this.mfz.mfs.finish();
    }
}
