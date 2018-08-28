package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.k.c.1;
import java.util.HashMap;
import java.util.Map;

class c$1$1 implements OnClickListener {
    final /* synthetic */ 1 fXO;

    c$1$1(1 1) {
        this.fXO = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Map hashMap = new HashMap();
        hashMap.put("confirm", Boolean.valueOf(true));
        hashMap.put("cancel", Boolean.valueOf(false));
        this.fXO.fCl.E(this.fXO.doP, this.fXO.fXN.f("ok", hashMap));
    }
}
