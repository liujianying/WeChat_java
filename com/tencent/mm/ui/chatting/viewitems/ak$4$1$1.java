package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ak.4.1;
import com.tencent.mm.y.g.a;

class ak$4$1$1 implements e {
    final /* synthetic */ 1 ueX;

    ak$4$1$1(1 1) {
        this.ueX = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + lVar.getType());
        if (i == 0 && i2 == 0) {
            a gp;
            String str2 = this.ueX.ueW.ueR.field_content;
            if (str2 != null) {
                gp = a.gp(str2);
            } else {
                gp = null;
            }
            if (gp != null) {
                com.tencent.mm.pluginsdk.model.app.l.fJ(this.ueX.ueW.ueR.field_msgId);
            }
            bd.aU(this.ueX.ueW.ueR.field_msgId);
            Toast.makeText(ak.a(this.ueX.ueW.ueT).tTq.getContext(), ak.a(this.ueX.ueW.ueT).tTq.getMMResources().getString(R.l.chatting_item_voice_reminder_del_succ), 0).show();
        }
        au.DF().b(331, ak.b(this.ueX.ueW.ueT));
        ak.a(this.ueX.ueW.ueT, null);
        if (ak.c(this.ueX.ueW.ueT) != null) {
            ak.c(this.ueX.ueW.ueT).dismiss();
        }
    }
}
