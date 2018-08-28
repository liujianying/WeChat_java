package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class e$1 implements OnClickListener {
    final /* synthetic */ e kuf;

    e$1(e eVar) {
        this.kuf = eVar;
    }

    public final void onClick(View view) {
        Object obj;
        boolean z;
        au.HU();
        boolean booleanValue = ((Boolean) c.DT().get(a.sQV, Boolean.valueOf(false))).booleanValue();
        if (booleanValue) {
            au.HU();
            i.M(2, ((Integer) c.DT().get(a.sQW, Integer.valueOf(-1))).intValue(), -1);
            au.HU();
            c.DT().a(a.sQW, Integer.valueOf(-1));
            x.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", new Object[]{Integer.valueOf(r0)});
        }
        if (booleanValue) {
            obj = "true";
        } else {
            String obj2 = "false";
        }
        au.HU();
        String str = (String) c.DT().get(a.sQX, "");
        x.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", new Object[]{obj2, str});
        au.HU();
        c.DT().a(a.sQV, Boolean.valueOf(false));
        au.HU();
        c.DT().a(a.sQX, "");
        au.HU();
        if (((Integer) c.DT().get(a.sQZ, Integer.valueOf(0))).intValue() == 1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            au.HU();
            x.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", new Object[]{(String) c.DT().get(a.sQY, "")});
            au.HU();
            c.DT().a(a.sQY, "");
        }
        h.mEJ.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.kuf.aYd();
        Intent intent = new Intent();
        intent.setClass(this.kuf.ktY, IPCallShareCouponUI.class);
        this.kuf.ktY.startActivity(intent);
    }
}
