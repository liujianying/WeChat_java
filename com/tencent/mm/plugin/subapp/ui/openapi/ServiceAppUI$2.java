package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.c.p;
import com.tencent.mm.sdk.platformtools.x;

class ServiceAppUI$2 implements OnItemClickListener {
    final /* synthetic */ ServiceAppUI osX;

    ServiceAppUI$2(ServiceAppUI serviceAppUI) {
        this.osX = serviceAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ServiceAppUI.a(this.osX) == null) {
            x.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
            return;
        }
        p xV = ServiceAppUI.a(this.osX).xV(i);
        if (xV == null) {
            x.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
            return;
        }
        x.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(xV.cmZ), xV.field_packageName, xV.field_appId});
        ServiceAppUI.a(this.osX, xV);
    }
}
