package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class c extends e {
    public c(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int If() {
        return 1573;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_qrcodeusebindquery";
    }
}
