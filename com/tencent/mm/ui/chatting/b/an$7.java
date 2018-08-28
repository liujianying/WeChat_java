package com.tencent.mm.ui.chatting.b;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.t;

class an$7 implements a {
    final /* synthetic */ an tTe;

    an$7(an anVar) {
        this.tTe = anVar;
    }

    public final void b(int i, String str, String str2, int i2) {
        if (i == -50002) {
            Toast.makeText(this.tTe.bAG.tTq.getContext(), this.tTe.bAG.tTq.getContext().getString(R.l.video_export_file_too_big), 0).show();
        } else if (i < 0) {
            Toast.makeText(this.tTe.bAG.tTq.getContext(), this.tTe.bAG.tTq.getContext().getString(R.l.video_export_file_error), 0).show();
        } else {
            t.b(str, i2, this.tTe.bAG.getTalkerUserName(), str2);
            t.nR(str);
        }
        this.tTe.bAG.dismissDialog();
    }
}
