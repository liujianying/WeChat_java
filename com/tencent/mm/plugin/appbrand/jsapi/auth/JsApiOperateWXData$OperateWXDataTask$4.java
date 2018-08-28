package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.j.c;
import com.tencent.mm.plugin.appbrand.j.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$4 implements a<c> {
    final /* synthetic */ OperateWXDataTask fJJ;
    final /* synthetic */ OperateWXDataTask.a fJL;
    final /* synthetic */ int fvO;

    JsApiOperateWXData$OperateWXDataTask$4(OperateWXDataTask operateWXDataTask, OperateWXDataTask.a aVar, int i) {
        this.fJJ = operateWXDataTask;
        this.fJL = aVar;
        this.fvO = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        c cVar = (c) lVar;
        x.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.fJL.fM("");
        } else if (!(cVar instanceof c)) {
        } else {
            if (this.fvO == 2) {
                x.d("MicroMsg.JsApiOperateWXData", "press reject button");
                return;
            }
            apa apa = cVar.diG == null ? null : (apa) cVar.diG.dIE.dIL;
            int i3 = apa.rRd.bMH;
            String str2 = apa.rRd.bMI;
            bio bio = apa.rRk;
            LinkedList linkedList = new LinkedList();
            if (bio != null) {
                linkedList.add(bio);
            }
            String str3 = apa.jSv;
            String str4 = apa.rbh;
            x.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                this.fJL.a(linkedList, str3, str4);
            } else if (i3 == 0) {
                x.d("MicroMsg.JsApiOperateWXData", "resp data %s", new Object[]{apa.hbs.cfV()});
                this.fJL.qe(r0);
            } else {
                x.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[]{str2});
                this.fJL.fM(str2);
            }
        }
    }
}
