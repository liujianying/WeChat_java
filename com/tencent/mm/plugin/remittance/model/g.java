package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private e diJ;
    private b eAN;
    jd mxa;
    public je mxb;
    public c mxc;
    public d mxd;
    public boolean mxe = false;
    public String mxf = "";
    public boolean mxg = false;
    public int mxh = 0;

    public g(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, c cVar, d dVar) {
        this.mxf = System.currentTimeMillis() + i;
        a aVar = new a();
        this.mxh = i;
        aVar.dIG = new jd();
        aVar.dIH = new je();
        aVar.dIF = 2677;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.mxa = (jd) this.eAN.dID.dIL;
        this.mxa.amount = i;
        this.mxa.bVU = i2;
        this.mxa.mwQ = i3;
        this.mxa.rky = str;
        this.mxa.myi = str2;
        this.mxa.mwR = str3;
        this.mxa.myl = str4;
        this.mxa.rcH = str5;
        this.mxa.mwS = str6;
        this.mxa.rkz = i4;
        this.mxc = cVar;
        this.mxd = dVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", new Object[]{Integer.valueOf(this.mxa.amount)}));
        stringBuffer.append(String.format("request.channel %s", new Object[]{Integer.valueOf(this.mxa.bVU)}));
        stringBuffer.append(String.format("request.scan_scene %s", new Object[]{Integer.valueOf(this.mxa.mwQ)}));
        stringBuffer.append(String.format("request.receiver_desc %s", new Object[]{this.mxa.rky}));
        stringBuffer.append(String.format("request.mch_name %s", new Object[]{this.mxa.myi}));
        stringBuffer.append(String.format("request.favor_req_sign %s", new Object[]{this.mxa.mwR}));
        stringBuffer.append(String.format("request.receiver_openid %s", new Object[]{this.mxa.myl}));
        stringBuffer.append(String.format("request.receiver_username %s", new Object[]{this.mxa.rcH}));
        stringBuffer.append(String.format("request.favor_req_extend %s", new Object[]{this.mxa.mwS}));
        stringBuffer.append(String.format("request.fail_click_cell %s", new Object[]{Integer.valueOf(this.mxa.rkz)}));
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[]{stringBuffer.toString()});
    }

    public final int getType() {
        return 2677;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxb = (je) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[]{Integer.valueOf(this.mxb.hwV), this.mxb.hwW, a.a(this.mxb.mwU)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
