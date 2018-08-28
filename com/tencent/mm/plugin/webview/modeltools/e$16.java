package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

class e$16 extends c<ua> {
    final /* synthetic */ e pUl;

    e$16(e eVar) {
        this.pUl = eVar;
        this.sFo = ua.class.getName().hashCode();
    }

    private static boolean a(ua uaVar) {
        if (!(uaVar instanceof ua)) {
            return false;
        }
        String str;
        String GF = q.GF();
        List arrayList = new ArrayList();
        arrayList.add(uaVar.cfH.cfI);
        arrayList.add(uaVar.cfH.cfJ);
        arrayList.add(uaVar.cfH.cfK);
        arrayList.add(uaVar.cfH.cfL);
        arrayList.add(uaVar.cfH.url);
        arrayList.add(uaVar.cfH.cfM);
        arrayList.add(uaVar.cfH.cfN);
        arrayList.add(uaVar.cfH.cfO);
        arrayList.add(uaVar.cfH.cfP);
        arrayList.add(uaVar.cfH.cfQ);
        arrayList.add(GF);
        arrayList.add(uaVar.cfH.cfR);
        arrayList.add(uaVar.cfH.cfS);
        PString pString = new PString();
        String a = ((i) g.l(i.class)).a(uaVar.cfH.cfT, pString);
        arrayList.add(a);
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        int N = t.N(uaVar.cfH.cfK, uaVar.cfH.cfL);
        int N2 = t.N(GF, uaVar.cfH.cfN);
        arrayList.add(String.valueOf(N));
        arrayList.add(String.valueOf(N2));
        Object obj = uaVar.cfH.cfU;
        try {
            obj = URLEncoder.encode(obj, "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
        }
        arrayList.add(obj);
        arrayList.add(pString.value);
        String str2 = "MicroMsg.SubCoreTools";
        String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
        Object[] objArr = new Object[19];
        objArr[0] = uaVar.cfH.cfI;
        objArr[1] = uaVar.cfH.cfJ;
        objArr[2] = uaVar.cfH.cfK;
        objArr[3] = uaVar.cfH.cfL;
        if (uaVar.cfH.url == null) {
            str = uaVar.cfH.url;
        } else {
            str = uaVar.cfH.url.replace(",", "!");
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(uaVar.cfH.cfM);
        objArr[6] = uaVar.cfH.cfN;
        objArr[7] = uaVar.cfH.cfO;
        objArr[8] = Integer.valueOf(uaVar.cfH.cfP);
        objArr[9] = Integer.valueOf(uaVar.cfH.cfQ);
        objArr[10] = GF;
        objArr[11] = Integer.valueOf(uaVar.cfH.cfR);
        if (uaVar.cfH.cfS == null) {
            str = uaVar.cfH.cfS;
        } else {
            str = uaVar.cfH.cfS.replace(",", "!");
        }
        objArr[12] = str;
        objArr[13] = uaVar.cfH.cfT;
        objArr[14] = a;
        objArr[15] = Integer.valueOf(N);
        objArr[16] = Integer.valueOf(N2);
        objArr[17] = uaVar.cfH.cfU;
        objArr[18] = pString.value;
        x.d(str2, str3, objArr);
        if (uaVar.cfH.cfV != 2) {
            h hVar = h.mEJ;
            h.e(11954, arrayList);
        }
        return true;
    }
}
