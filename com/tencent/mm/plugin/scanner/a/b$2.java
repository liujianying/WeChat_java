package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.a.1;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class b$2 extends c<cb> {
    final /* synthetic */ b mFK;

    b$2(b bVar) {
        this.mFK = bVar;
        this.sFo = cb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 2;
        cb cbVar = (cb) bVar;
        if (cbVar == null || !(cbVar instanceof cb)) {
            x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
        } else {
            this.mFK.bsa();
            this.mFK.mFE = cbVar.bJq.bHL;
            this.mFK.mActivity = cbVar.bJq.activity;
            x.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", new Object[]{this.mFK.mActivity, this.mFK.mFE, Integer.valueOf(cbVar.bJq.bJr), Integer.valueOf(cbVar.bJq.bJs), Integer.valueOf(cbVar.bJq.bJu)});
            if (cbVar.bJq.bJr == 19 || cbVar.bJq.bJr == 22) {
                this.mFK.mFF = new e();
                this.mFK.mFF.bJt = cbVar.bJq.bJt;
                this.mFK.mFF.imagePath = cbVar.bJq.imagePath;
                this.mFK.mFF.bJw = cbVar.bJq.bJw;
                this.mFK.mFF.bhd = cbVar.bJq.bhd;
                if (cbVar.bJq.bJu >= 0) {
                    i = 3;
                }
                if (cbVar.bJq.scene > 0) {
                    this.mFK.mFF.iVT = cbVar.bJq.scene;
                }
                if (i == 3) {
                    this.mFK.mFF.appId = cbVar.bJq.bJv;
                }
                this.mFK.mFF.a(this.mFK.mActivity, this.mFK.mFE, i, cbVar.bJq.bJr, cbVar.bJq.bJs, this.mFK.mFH, cbVar.bJq.bJx);
            } else {
                this.mFK.mFG = new a();
                a aVar = this.mFK.mFG;
                Context context = this.mFK.mActivity;
                String str = this.mFK.mFE;
                int i2 = cbVar.bJq.bJr;
                int i3 = cbVar.bJq.bJs;
                Bundle bundle = cbVar.bJq.bJx;
                if (!bi.oW(str)) {
                    String[] split = str.split(",");
                    if (split == null || split.length < 2) {
                        x.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                    } else {
                        aVar.bOb = context;
                        aVar.bJx = bundle;
                        f fVar = new f(p.KS(split[0]), split[1], i2, i3);
                        au.DF().a(1061, aVar);
                        au.DF().a(fVar, 0);
                        context.getString(R.l.app_tip);
                        aVar.eHw = h.a(context, context.getString(R.l.qrcode_scan_default), true, new 1(aVar, fVar));
                    }
                }
            }
        }
        return false;
    }
}
