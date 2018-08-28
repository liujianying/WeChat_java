package com.tencent.mm.network;

import android.support.design.a$i;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class y {
    private static final byte[] ete = n.eo(7);
    public m etf;

    public final void onPush(int i, byte[] bArr) {
        x.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.etf.e(138, ete);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.etf.e(10, bArr);
                    return;
                }
                return;
            case 24:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[]{bi.bB(bArr)});
                this.etf.e(138, bArr);
                return;
            case a$i.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.etf.e(39, null);
                return;
            case 61:
                this.etf.e(174, bArr);
                return;
            case 120:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.etf.e(120, bArr);
                    return;
                }
                return;
            case 122:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.etf.e(268369921, bArr);
                    return;
                }
                return;
            case 192:
                this.etf.e(192, bArr);
                return;
            case 241:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.etf.e(241, bArr);
                return;
            case 244:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.etf.e(244, bArr);
                return;
            case 311:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.etf.e(311, bArr);
                return;
            case b.CTRL_INDEX /*318*/:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.etf.e(b.CTRL_INDEX, bArr);
                return;
            case 319:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.etf.e(319, bArr);
                return;
            case 268369923:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.etf.e(268369923, bArr);
                return;
            case 1000000205:
                this.etf.e(1000000205, bArr);
                return;
            case 2147480001:
                x.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", new Object[]{bi.bB(bArr)});
                this.etf.e(2147480001, bArr);
                return;
            default:
                return;
        }
    }
}
