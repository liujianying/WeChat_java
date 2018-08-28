package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.plugin.appbrand.widget.c.c;
import com.tencent.mm.plugin.appbrand.widget.c.c$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$2 implements Runnable {
    final /* synthetic */ OperateWXDataTask fJJ;
    final /* synthetic */ LinkedList fyu;

    JsApiOperateWXData$OperateWXDataTask$2(OperateWXDataTask operateWXDataTask, LinkedList linkedList) {
        this.fJJ = operateWXDataTask;
        this.fyu = linkedList;
    }

    public final void run() {
        c$a anonymousClass1 = new c$a() {
            public final void f(int i, Bundle bundle) {
                x.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                switch (i) {
                    case 1:
                    case 2:
                        JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJv = "operateWXDataConfirm";
                        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                        if (arrayList == null || arrayList.size() <= 0) {
                            JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJI = "";
                        } else {
                            JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJI = (String) arrayList.get(0);
                        }
                        JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJx = i;
                        AppBrandMainProcessService.a(JsApiOperateWXData$OperateWXDataTask$2.this.fJJ);
                        if (i == 2) {
                            JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJr.a(JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJs, JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fFd, "fail auth deny");
                            JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJt.aia();
                            return;
                        }
                        return;
                    default:
                        x.d("MicroMsg.JsApiOperateWXData", "press back button!");
                        JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJr.a(JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJs, JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fFd, "fail auth cancel");
                        JsApiOperateWXData$OperateWXDataTask$2.this.fJJ.fJt.aia();
                        return;
                }
            }
        };
        g runtime = this.fJJ.fJs.getRuntime();
        c cVar = this.fJJ.fJr;
        runtime.a(new c(this.fJJ.fJs.getRuntime().fcq, this.fyu, this.fJJ.mAppName, this.fJJ.fyq, anonymousClass1));
    }
}
