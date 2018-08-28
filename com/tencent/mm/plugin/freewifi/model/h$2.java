package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class h$2 implements Comparator<ScanResult> {
    final /* synthetic */ h jkc;

    h$2(h hVar) {
        this.jkc = hVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        ScanResult scanResult = (ScanResult) obj;
        ScanResult scanResult2 = (ScanResult) obj2;
        if (scanResult.level < scanResult2.level) {
            return 1;
        }
        return scanResult.level == scanResult2.level ? 0 : -1;
    }
}
