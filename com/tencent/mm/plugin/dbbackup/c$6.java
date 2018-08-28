package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.vfs.d;

class c$6 implements OnClickListener {
    final /* synthetic */ c hZp;
    final /* synthetic */ String hZz;
    final /* synthetic */ Context val$context;

    c$6(c cVar, String str, Context context) {
        this.hZp = cVar;
        this.hZz = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.I(this.hZz, false);
        Toast.makeText(this.val$context, "Corruption test database cleared.", 0).show();
    }
}
