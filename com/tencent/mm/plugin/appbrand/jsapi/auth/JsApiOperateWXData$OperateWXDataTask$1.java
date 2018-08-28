package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.a;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$1 implements a {
    final /* synthetic */ OperateWXDataTask fJJ;

    JsApiOperateWXData$OperateWXDataTask$1(OperateWXDataTask operateWXDataTask) {
        this.fJJ = operateWXDataTask;
    }

    public final void qe(String str) {
        x.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
        this.fJJ.fJH = str;
        this.fJJ.fJw = "ok";
        OperateWXDataTask.a(this.fJJ);
    }

    public final void fM(String str) {
        x.e("MicroMsg.JsApiOperateWXData", "onFailure !");
        this.fJJ.fJw = "fail:" + str;
        OperateWXDataTask.b(this.fJJ);
    }

    public final void a(LinkedList<bio> linkedList, String str, String str2) {
        x.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
        this.fJJ.fJy = linkedList.size();
        int i = 0;
        while (i < this.fJJ.fJy) {
            try {
                this.fJJ.fJz.putByteArray(String.valueOf(i), ((bio) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                this.fJJ.fJw = "fail";
                OperateWXDataTask.c(this.fJJ);
                return;
            }
        }
        this.fJJ.mAppName = str;
        this.fJJ.fyq = str2;
        this.fJJ.fJw = "needConfirm";
        OperateWXDataTask.d(this.fJJ);
    }
}
