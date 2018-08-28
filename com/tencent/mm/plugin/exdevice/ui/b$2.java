package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements OnClickListener {
    final /* synthetic */ b iES;

    b$2(b bVar) {
        this.iES = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        b.a(this.iES).Ax(this.iES.pl(((Integer) view.getTag()).intValue()).iHF.field_username);
    }
}
