package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class g implements e {
    private Context context;
    private ProgressDialog dId;
    a eNf;
    private boolean eNg = true;
    String eNh = "";

    public g(Context context, a aVar) {
        this.context = context;
        this.eNf = aVar;
        this.eNg = true;
    }

    public g(Context context, a aVar, byte b) {
        this.context = context;
        this.eNf = aVar;
        this.eNg = false;
    }

    public final void g(int[] iArr) {
        com.tencent.mm.kernel.g.DF().a(116, this);
        final ah ahVar = new ah(iArr);
        com.tencent.mm.kernel.g.DF().a(ahVar, 0);
        if (this.eNg) {
            Context context = this.context;
            this.context.getString(j.inviteqqfriends_title);
            this.dId = h.a(context, this.context.getString(j.inviteqqfriends_inviting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.kernel.g.DF().c(ahVar);
                    g.this.eNf.c(false, g.this.eNh);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 116) {
            if (this.dId != null) {
                this.dId.dismiss();
                this.dId = null;
            }
            com.tencent.mm.kernel.g.DF().b(116, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
                if (this.eNg) {
                    h.a(this.context, j.inviteqqfriends_invite_success, j.app_tip, new 2(this));
                    return;
                } else {
                    this.eNf.c(true, this.eNh);
                    return;
                }
            }
            x.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
            this.eNf.c(false, this.eNh);
        }
    }
}
