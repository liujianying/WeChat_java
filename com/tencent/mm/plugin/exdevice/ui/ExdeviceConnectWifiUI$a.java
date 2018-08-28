package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.sdk.platformtools.bi;

class ExdeviceConnectWifiUI$a {
    public static String aa(int i, String str) {
        if (bi.oW(str)) {
            return null;
        }
        return i + "@" + str.hashCode();
    }
}
