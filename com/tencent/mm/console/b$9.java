package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mm.R;

class b$9 implements OnClickListener {
    final /* synthetic */ Context dhl;
    final /* synthetic */ String dhm;

    b$9(Context context, String str) {
        this.dhl = context;
        this.dhm = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.dhl.getSystemService("clipboard")).setText(this.dhm);
        Toast.makeText(this.dhl, R.l.voip_get_key_copy_note, 0).show();
    }
}
