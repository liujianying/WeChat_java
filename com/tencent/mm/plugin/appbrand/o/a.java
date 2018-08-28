package com.tencent.mm.plugin.appbrand.o;

import android.database.Cursor;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.az.b;
import java.util.Map;

public final class a implements com.tencent.mm.storage.az.a {
    public final void a(ai aiVar, az azVar) {
        if (aiVar != null && !bi.oW(aiVar.field_username)) {
            String str = aiVar.field_username;
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                x.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[]{str});
            } else if (ab.gr(str) && !s.hr(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                aiVar.ef("appbrandcustomerservicemsg");
                ai Yq = ((i) g.l(i.class)).FW().Yq("appbrandcustomerservicemsg");
                if (Yq == null) {
                    x.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    Yq = new ai("appbrandcustomerservicemsg");
                    Yq.clx();
                    a(aiVar, Yq);
                    ((i) g.l(i.class)).FW().d(Yq);
                    return;
                }
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                Yq.ef(null);
                a(aiVar, Yq);
                ((i) g.l(i.class)).FW().a(Yq, "appbrandcustomerservicemsg");
            } else if (s.hN(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aiVar.ef(null);
            }
        }
    }

    private static void a(ai aiVar, ai aiVar2) {
        am amVar;
        cm GE;
        String str = null;
        Cursor b = ((i) g.l(i.class)).FW().b(s.dAT, null, "appbrandcustomerservicemsg");
        if (b != null) {
            ai aiVar3;
            if (b.getCount() <= 0 || !b.moveToFirst()) {
                aiVar3 = null;
            } else {
                aiVar3 = new ai();
                aiVar3.d(b);
            }
            b.close();
            amVar = aiVar3;
        } else {
            amVar = null;
        }
        if (amVar != null) {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", new Object[]{amVar.field_username});
            GE = ((i) g.l(i.class)).bcY().GE(amVar.field_username);
        } else {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            GE = ((i) g.l(i.class)).bcY().GE(aiVar.field_username);
        }
        if (GE == null || GE.field_msgId <= 0) {
            x.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            aiVar2.clx();
            return;
        }
        aiVar2.aj(GE);
        aiVar2.setContent(GE.field_talker + ":" + GE.field_content);
        aiVar2.ec(Integer.toString(GE.getType()));
        b vu = ((i) g.l(i.class)).FW().vu();
        if (vu != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            GE.ep(aiVar.field_parentRef);
            GE.setContent(aiVar2.field_content);
            vu.a(GE, pString, pString2, pInt, true);
            int type = GE.getType();
            String str2 = GE.field_content;
            if (!bi.oW(str2)) {
                switch (type) {
                    case a$k.AppCompatTheme_actionButtonStyle /*49*/:
                        Map z = bl.z(str2, "msg");
                        if (z != null) {
                            x.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[]{(String) z.get(".msg.appmsg.title")});
                            str = r0;
                            break;
                        }
                        break;
                }
            }
            aiVar2.ed(bi.oV(pString.value).concat(bi.oW(str) ? "" : " " + bi.oV(str)));
            aiVar2.ee(pString2.value);
            aiVar2.eY(pInt.value);
        }
    }
}
