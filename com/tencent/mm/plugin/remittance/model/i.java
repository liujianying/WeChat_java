package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.jh;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import java.net.URLDecoder;

public final class i extends l implements k, d {
    private e diJ;
    public b eAN;
    public ji mxj;
    public String mxk;
    public fo mxl = null;

    public i(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6, int i4, int i5, String str7, xb xbVar, String str8, int i6, String str9, String str10, String str11, String str12) {
        a aVar = new a();
        aVar.dIG = new jh();
        aVar.dIH = new ji();
        aVar.dIF = 1633;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.dII = 0;
        aVar.dIJ = 0;
        c bFh = com.tencent.mm.plugin.soter.c.b.bFh();
        String str13 = bFh.onE;
        String str14 = bFh.onF;
        this.mxk = str9;
        this.eAN = aVar.KT();
        jh jhVar = (jh) this.eAN.dID.dIL;
        jhVar.myl = str;
        jhVar.rkC = URLDecoder.decode(str2);
        jhVar.scene = i;
        jhVar.rkD = str3;
        jhVar.myf = str4;
        jhVar.rcI = i2;
        jhVar.bVU = i3;
        jhVar.myg = str5;
        jhVar.mym = str6;
        jhVar.myk = i4;
        jhVar.rcH = str7;
        if (xbVar != null) {
            jhVar.rcG = xbVar;
        }
        jhVar.rkw = str8;
        jhVar.mwQ = i6;
        if (i5 == 1) {
            WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
            if (wifiInfo != null) {
                jhVar.rkE = wifiInfo.getBSSID();
            } else {
                x.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            jhVar.rkF = 0;
        }
        jhVar.onE = str13;
        jhVar.onF = str14;
        jhVar.rkH = o.bOW().bPu();
        g.l(com.tencent.mm.pluginsdk.k.class);
        jhVar.rkG = false;
        jhVar.rkI = str9;
        jhVar.myi = str10;
        jhVar.nickname = str11;
        jhVar.mxM = str12;
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[]{str9});
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), str2, Integer.valueOf(i5), a.a(xbVar), str9});
    }

    public final int getType() {
        return 1633;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxj = (ji) ((b) qVar).dIE.dIL;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("trans_id: %s,", new Object[]{this.mxj.rcE}));
        stringBuffer.append(String.format("zero_pay_flag: %s,", new Object[]{Integer.valueOf(this.mxj.rkP)}));
        stringBuffer.append(String.format("can_use_fingerprint: %s,", new Object[]{Integer.valueOf(this.mxj.rkV)}));
        stringBuffer.append(String.format("payer_need_auth_flag: %s,", new Object[]{Integer.valueOf(this.mxj.rkQ)}));
        x.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[]{Integer.valueOf(this.mxj.hwV), this.mxj.hwW, this.mxj.rcE, this.mxj.rcD, Integer.valueOf(this.mxj.rkO), this.mxj.rcF, this.mxj.bQa, stringBuffer.toString()});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
