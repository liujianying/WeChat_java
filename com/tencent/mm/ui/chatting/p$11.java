package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.o$a;
import com.tencent.mm.sdk.platformtools.ad;

class p$11 implements OnClickListener {
    final /* synthetic */ p tJl;

    p$11(p pVar) {
        this.tJl = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!o$a.qyi.HC(this.tJl.getTalkerUserName())) {
            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_system_master_multi_finish_msg), 0).show();
        } else if (!o$a.qyi.HJ(this.tJl.getTalkerUserName())) {
            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_error_300), 0).show();
        }
    }
}
