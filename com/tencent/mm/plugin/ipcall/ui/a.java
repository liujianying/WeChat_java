package com.tencent.mm.plugin.ipcall.ui;

final class a {
    String countryCode;
    String dYy;
    String dYz;
    private int ksI;

    public a(String str, String str2, int i, String str3) {
        this.dYy = str;
        this.countryCode = str2;
        this.ksI = i;
        this.dYz = str3;
    }

    public final int aXZ() {
        if (this.ksI == 0) {
            return 0;
        }
        for (String equals : IPCallCountryCodeScrollbar.kuT) {
            if (equals.equals(String.valueOf((char) this.ksI))) {
                return this.ksI;
            }
        }
        return "#".charAt(0);
    }
}
