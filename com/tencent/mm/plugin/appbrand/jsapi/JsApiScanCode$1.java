package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

class JsApiScanCode$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiScanCode fGP;

    JsApiScanCode$1(JsApiScanCode jsApiScanCode, l lVar, int i) {
        this.fGP = jsApiScanCode;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        JsApiScanCode.Ju();
        if (i == (this.fGP.hashCode() & 65535)) {
            switch (i2) {
                case -1:
                    int intExtra;
                    int intExtra2;
                    Object obj = "";
                    Object encodeToString = Base64.encodeToString(new byte[0], 2);
                    if (intent != null) {
                        obj = intent.getStringExtra("key_scan_result");
                        byte[] byteArrayExtra = intent.getByteArrayExtra("key_scan_result_raw");
                        if (byteArrayExtra != null) {
                            encodeToString = Base64.encodeToString(byteArrayExtra, 2);
                        }
                        intent.getIntExtra("key_scan_result_type", 0);
                        intExtra = intent.getIntExtra("key_scan_result_code_type", 0);
                        intExtra2 = intent.getIntExtra("key_scan_result_code_version", 0);
                    } else {
                        intExtra2 = 0;
                        intExtra = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("charSet", "utf-8");
                    hashMap.put("rawData", encodeToString);
                    if (intExtra == 19 || intExtra == 22) {
                        hashMap.put("result", intExtra == 22 ? "" : obj);
                        hashMap.put("scanType", "QR_CODE");
                        GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                        getA8KeyTask.fGT = obj;
                        getA8KeyTask.bJr = intExtra;
                        getA8KeyTask.bJs = intExtra2;
                        getA8KeyTask.fGV = new 1(this, getA8KeyTask, hashMap);
                        getA8KeyTask.ahA();
                        AppBrandMainProcessService.a(getA8KeyTask);
                        return;
                    }
                    String[] split = obj.split(",");
                    String str = "result";
                    if (split.length > 1) {
                        obj = split[1];
                    }
                    hashMap.put(str, obj);
                    hashMap.put("scanType", split.length > 1 ? split[0] : "");
                    this.fCl.E(this.doP, this.fGP.f("ok", hashMap));
                    return;
                case 0:
                    this.fCl.E(this.doP, this.fGP.f("cancel", null));
                    return;
                default:
                    this.fCl.E(this.doP, this.fGP.f("fail", null));
                    return;
            }
        }
    }
}
