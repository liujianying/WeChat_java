package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.sdk.platformtools.ah;

class e$2 implements b {
    final /* synthetic */ c fJo;
    final /* synthetic */ AppBrandPreInitTask fVT;

    e$2(AppBrandPreInitTask appBrandPreInitTask, c cVar) {
        this.fVT = appBrandPreInitTask;
        this.fJo = cVar;
    }

    public final void hj(int i) {
        if (i == 0) {
            this.fVT.akA();
        } else {
            ah.A(new Runnable() {
                public final void run() {
                    h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(e$2.this.fJo.getContext());
                    bVar.setTitle(j.appbrand_gdpr_deny_alert_title);
                    int i = j.appbrand_gdpr_deny_alert_message;
                    bVar.tlz.setVisibility(0);
                    bVar.tlx.setVisibility(0);
                    bVar.tlx.setText(i);
                    bVar.setCanceledOnTouchOutside(false);
                    bVar.a(j.app_ok, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    e$2.this.fJo.getRuntime().a(bVar);
                }
            });
        }
    }
}
