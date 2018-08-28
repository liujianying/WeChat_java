package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

public final class ScanSettingsCompat$a {
    private int fNR = 0;
    private final int fNS = 1;
    private long fNT = 0;

    public final ScanSettingsCompat$a kD(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid scan mode " + i);
        }
        this.fNR = i;
        return this;
    }

    public final ScanSettingsCompat aiy() {
        return new ScanSettingsCompat(this.fNR, this.fNT, (byte) 0);
    }
}
