package com.tencent.mm.lib.riskscanner;

import android.os.Bundle;
import com.tencent.c.a.c.a;

class RiskScannerReqBufferProvider$1 implements a {
    final /* synthetic */ Bundle[] duI;
    final /* synthetic */ RiskScannerReqBufferProvider duJ;

    RiskScannerReqBufferProvider$1(RiskScannerReqBufferProvider riskScannerReqBufferProvider, Bundle[] bundleArr) {
        this.duJ = riskScannerReqBufferProvider;
        this.duI = bundleArr;
    }

    public final void f(int i, byte[] bArr) {
        a.gP(i);
        Bundle[] bundleArr = this.duI;
        Bundle bundle = new Bundle();
        bundleArr[0] = bundle;
        if (i == 0 && bArr != null) {
            bundle.putInt("errCode", i);
            bundle.putByteArray("reqBufferBase64", bArr);
        }
    }
}
