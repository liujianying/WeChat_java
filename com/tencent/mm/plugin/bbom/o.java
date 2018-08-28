package com.tencent.mm.plugin.bbom;

import com.tencent.mm.a.n;
import com.tencent.mm.ab.u;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class o implements c {
    public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        String str;
        su suVar;
        switch (i) {
            case 10:
                x.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                b bVar = new b();
                bVar.deviceID = q.zz();
                try {
                    if (new u(bVar, 10).a(10, bArr, null)) {
                        au.DF().a(0, 0, "", new f(bVar));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", e, "", new Object[0]);
                    return;
                }
            case 102:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                return;
            case TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR /*120*/:
                NotifyService.eB("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                rn rnVar = new rn();
                rnVar.ccn.ccp = true;
                a.sFg.m(rnVar);
                str = rnVar.cco.ccr;
                if (!bi.oW(str)) {
                    x.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: " + str);
                    rnVar = new rn();
                    rnVar.ccn.ccq = true;
                    a.sFg.m(rnVar);
                }
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        suVar = new su();
                        suVar.cdE.bOh = 3;
                        suVar.cdE.cdy = bArr;
                        a.sFg.m(suVar);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        ij ijVar = new ij();
                        ijVar.bRR.bRS = bArr;
                        a.sFg.m(ijVar);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        suVar = new su();
                        suVar.cdE.bOh = 9;
                        suVar.cdE.cdy = bArr;
                        a.sFg.m(suVar);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        suVar = new su();
                        suVar.cdE.bOh = 10;
                        suVar.cdE.cdy = bArr;
                        a.sFg.m(suVar);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        ss ssVar = new ss();
                        ssVar.cdx.cdy = bArr;
                        a.sFg.m(ssVar);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 174:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                suVar = new su();
                suVar.cdE.bOh = 6;
                suVar.cdE.cdy = bArr;
                a.sFg.m(suVar);
                return;
            case 192:
                fy fyVar = new fy();
                fyVar.bOJ.bOK = bArr;
                a.sFg.m(fyVar);
                return;
            case 241:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
                if (bArr.length >= 8) {
                    Object obj = new byte[4];
                    Object obj2 = new byte[4];
                    System.arraycopy(bArr, 0, obj, 0, 4);
                    System.arraycopy(bArr, 4, obj2, 0, 4);
                    kg kgVar = new kg();
                    kgVar.bUD.bUE = n.r(obj, 0);
                    kgVar.bUD.bUF = n.r(obj2, 0);
                    x.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[]{Integer.valueOf(kgVar.bUD.bUE), Integer.valueOf(kgVar.bUD.bUF)});
                    a.sFg.m(kgVar);
                    return;
                }
                return;
            case TbsListener$ErrorCode.ERROR_QBSDK_INIT_ISSUPPORT /*318*/:
                byte[] decodeSecureNotifyData;
                String str2 = "MicroMsg.NotifyReceiverCallbackImpl";
                String str3 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                x.i(str2, str3, objArr);
                com.tencent.mm.plugin.report.f.mDy.a(403, 38, 1, false);
                if (bArr != null) {
                    bkd bkd = new bkd();
                    try {
                        bkd.aG(bArr);
                        x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[]{Integer.valueOf(bkd.sjL), Integer.valueOf(bkd.sjM), Integer.valueOf(bkd.sjN), Integer.valueOf(bkd.sjO), Integer.valueOf(bkd.sjP), Integer.valueOf(bkd.sjQ)});
                        decodeSecureNotifyData = MMProtocalJni.decodeSecureNotifyData(bArr2, bkd.sjL, bkd.sjM, bkd.sjN, bkd.sjO, bkd.sjP, bkd.sjQ, bkd.sjR, bkd.rwb.lR);
                    } catch (Exception e2) {
                        x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e2.getMessage());
                        com.tencent.mm.plugin.report.f.mDy.a(403, 39, 1, false);
                    }
                    if (decodeSecureNotifyData == null) {
                        x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[]{Integer.valueOf(decodeSecureNotifyData.length)});
                        po poVar = new po();
                        poVar.cav.data = decodeSecureNotifyData;
                        a.sFg.m(poVar);
                        return;
                    }
                    x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    com.tencent.mm.plugin.report.f.mDy.a(403, 40, 1, false);
                    return;
                }
                decodeSecureNotifyData = null;
                if (decodeSecureNotifyData == null) {
                    x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    com.tencent.mm.plugin.report.f.mDy.a(403, 40, 1, false);
                    return;
                }
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[]{Integer.valueOf(decodeSecureNotifyData.length)});
                po poVar2 = new po();
                poVar2.cav.data = decodeSecureNotifyData;
                a.sFg.m(poVar2);
                return;
            case 268369923:
                NotifyService.eB("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!bi.bC(bArr)) {
                    str = new String(bArr);
                    ah ahVar = new ah();
                    ahVar.bHy.type = 4;
                    ahVar.bHy.bHA = str;
                    a.sFg.m(ahVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
