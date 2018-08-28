package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class WelabMainUI$4 implements OnClickListener {
    final /* synthetic */ WelabMainUI qnr;

    WelabMainUI$4(WelabMainUI welabMainUI) {
        this.qnr = welabMainUI;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            a aVar = (a) tag;
            Intent intent = new Intent();
            intent.putExtra("para_appid", aVar.field_LabsAppId);
            intent.putExtra("para_from_with_red_point", b.bYX().e(aVar) ? 1 : 0);
            intent.setClass(this.qnr, WelabAppInfoUI.class);
            this.qnr.startActivity(intent);
            b bYX = b.bYX();
            String str = aVar.field_LabsAppId;
            bYX.qmR.put(str, Integer.valueOf(1));
            bYX.tag += "&" + str + "=1";
            g.Ei().DT().a(aa.a.sXi, bYX.tag);
            b.bYY();
            x.i("MicroMsg.WelabMainUI", "click " + aVar);
        }
    }
}
