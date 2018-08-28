package com.tencent.mm.plugin.kitchen.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.kitchen.b.d;
import com.tencent.mm.plugin.kitchen.ui.KvInfoUI.6;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class KvInfoUI$6$2 implements OnClickListener {
    final /* synthetic */ 6 kAv;
    final /* synthetic */ String kAw;

    KvInfoUI$6$2(6 6, String str) {
        this.kAv = 6;
        this.kAw = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            ((ClipboardManager) ad.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("kv_info", this.kAw));
            Toast.makeText(this.kAv.kAs.mController.tml, this.kAv.kAs.mController.tml.getString(d.app_copy_ok), 0).show();
        } catch (Exception e) {
            x.e("MicroMsg.KvInfoUI", "copy error [%s]", new Object[]{e.toString()});
            Toast.makeText(this.kAv.kAs.mController.tml, "copy failure", 0).show();
        }
    }
}
