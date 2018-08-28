package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask;

class JsApiScanCode$GetA8KeyTask$1 implements a {
    final /* synthetic */ h fGW;
    final /* synthetic */ GetA8KeyTask fGX;

    JsApiScanCode$GetA8KeyTask$1(GetA8KeyTask getA8KeyTask, h hVar) {
        this.fGX = getA8KeyTask;
        this.fGW = hVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            this.fGX.actionCode = this.fGW.QN();
            switch (this.fGX.actionCode) {
                case 26:
                    this.fGX.fGU = this.fGW.QL();
                    break;
                default:
                    this.fGX.fGU = "";
                    break;
            }
            GetA8KeyTask.b(this.fGX);
        } else {
            this.fGX.actionCode = -1;
            GetA8KeyTask.a(this.fGX);
        }
        return 0;
    }
}
