package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.bg.9;
import com.tencent.mm.storage.ab;

class bg$9$1 implements a {
    final /* synthetic */ 9 ohK;

    bg$9$1(9 9) {
        this.ohK = 9;
    }

    public final void x(String str, boolean z) {
        if (this.ohK.ohJ.tipDialog != null) {
            this.ohK.ohJ.tipDialog.dismiss();
        }
        if (z) {
            c.J(str, 3);
            q.KJ().jO(str);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            g.Ek();
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (Yg != null && Yg.ckW()) {
                h.mEJ.k(10298, str + ",37");
                intent.putExtra("Contact_Scene", 37);
            }
            com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.ohK.ohJ.context);
            return;
        }
        Toast.makeText(this.ohK.ohJ.context, this.ohK.ohJ.context.getString(j.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
    }
}
