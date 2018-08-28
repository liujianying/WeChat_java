package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class ComposeUI$16 implements OnClickListener {
    final /* synthetic */ String dat;
    final /* synthetic */ int dgZ;
    final /* synthetic */ ComposeUI mfs;
    final /* synthetic */ File val$file;

    ComposeUI$16(ComposeUI composeUI, int i, File file, String str) {
        this.mfs = composeUI;
        this.dgZ = i;
        this.val$file = file;
        this.dat = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ComposeUI.E(this.mfs).boW() + this.dgZ > 52428800) {
            h.a(this.mfs, R.l.plugin_qqmail_upload_attach_size_exceed, R.l.app_tip, null);
            return;
        }
        if (ComposeUI.j(this.mfs).getText().toString().trim().length() == 0) {
            String trim = this.val$file.getName().trim();
            int lastIndexOf = trim.lastIndexOf(".");
            EditText j = ComposeUI.j(this.mfs);
            if (lastIndexOf <= 0) {
                lastIndexOf = trim.length();
            }
            j.setText(trim.substring(0, lastIndexOf));
        }
        x.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(ComposeUI.a(this.mfs))});
        ComposeUI.E(this.mfs).eg(this.dat, null);
    }
}
