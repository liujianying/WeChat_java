package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceManageDeviceUI$a$2 implements OnClickListener {
    final /* synthetic */ a iDr;

    ExdeviceManageDeviceUI$a$2(a aVar) {
        this.iDr = aVar;
    }

    public final void onClick(View view) {
        if (!a.b(this.iDr)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof Integer)) {
                int intValue = ((Integer) tag).intValue();
                if (intValue >= 0 && intValue < this.iDr.getCount()) {
                    b pk = this.iDr.pk(intValue);
                    Context context = (Context) a.c(this.iDr).get();
                    if (context == null) {
                        x.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                    } else {
                        a.a(context, pk);
                    }
                }
            }
        }
    }
}
