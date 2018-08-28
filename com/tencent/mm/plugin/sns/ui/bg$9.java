package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

class bg$9 implements OnClickListener {
    final /* synthetic */ bg ohJ;

    bg$9(bg bgVar) {
        this.ohJ = bgVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof bd) {
            bd bdVar = (bd) view.getTag();
            if (bi.oW(bdVar.ohf)) {
                x.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                Toast.makeText(this.ohJ.context, this.ohJ.context.getString(j.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                return;
            }
            g.Ek();
            ab Yg = ((i) g.l(i.class)).FR().Yg(bdVar.ohf);
            if (Yg == null || !Yg.field_username.equals(bdVar.ohf)) {
                a.dBr.a(bdVar.ohf, "", new 1(this));
                bg bgVar = this.ohJ;
                Context context = this.ohJ.context;
                this.ohJ.context.getString(j.app_tip);
                bgVar.tipDialog = h.a(context, this.ohJ.context.getString(j.app_waiting), true, new 2(this, bdVar));
                return;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("Contact_User", bdVar.ohf);
            com.tencent.mm.plugin.report.service.h.mEJ.k(10298, bdVar.ohf + ",37");
            intent.putExtra("Contact_Scene", 37);
            com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.ohJ.context);
        }
    }
}
