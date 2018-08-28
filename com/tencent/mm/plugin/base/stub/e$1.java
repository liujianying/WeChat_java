package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.net.Uri;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

class e$1 implements e {
    final /* synthetic */ Runnable hdN;
    final /* synthetic */ Activity mr;

    e$1(Activity activity, Runnable runnable) {
        this.mr = activity;
        this.hdN = runnable;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1200, this);
        x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[]{((aa) lVar).Rv()});
            try {
                Uri parse = Uri.parse(((aa) lVar).Rv());
                if (parse == null) {
                    x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                    e.n(this.mr);
                    return;
                }
                String queryParameter = parse.getQueryParameter("result");
                if (queryParameter != null) {
                    x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[]{URLDecoder.decode(queryParameter)});
                    cb cbVar = new cb();
                    cbVar.bJq.activity = this.mr;
                    cbVar.bJq.bHL = queryParameter;
                    cbVar.bJq.bJr = 19;
                    cbVar.bJq.bJu = 3;
                    cbVar.bJq.bJv = parse.getQueryParameter("appid");
                    cbVar.bJq.bJx = this.mr.getIntent().getBundleExtra("_stat_obj");
                    a.sFg.m(cbVar);
                    if (this.hdN != null) {
                        this.hdN.run();
                    }
                    ah.i(new Runnable() {
                        public final void run() {
                            e$1.this.mr.finish();
                        }
                    }, 100);
                    return;
                }
                return;
            } catch (Exception e) {
                x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[]{e});
                e.n(this.mr);
                return;
            }
        }
        x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
        e.n(this.mr);
    }
}
