package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.ui.base.h;

class a$5 implements OnClickListener {
    final /* synthetic */ boolean iXH;
    final /* synthetic */ a mfY;
    final /* synthetic */ EditText mga;

    a$5(a aVar, boolean z, EditText editText) {
        this.mfY = aVar;
        this.iXH = z;
        this.mga = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        n nVar = new n(this.iXH, g.u(this.mga.getText().toString().trim().getBytes()));
        au.DF().a(nVar, 0);
        a aVar = this.mfY;
        Context a = a.a(this.mfY);
        a.a(this.mfY).getString(R.l.contact_info_qqmailhelper_enable);
        a.a(aVar, h.a(a, a.a(this.mfY).getString(R.l.app_waiting), true, new 1(this, nVar)));
    }
}
