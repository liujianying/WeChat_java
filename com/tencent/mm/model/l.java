package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public static boolean gz(String str) {
        if (!s.fq(str)) {
            return false;
        }
        long j;
        boolean z;
        ai Yq = ((i) g.l(i.class)).FW().Yq(str);
        if (Yq != null) {
            boolean z2;
            if (Yq.field_lastSeq == 0 || ((i) g.l(i.class)).bcY().J(str, Yq.field_lastSeq).field_msgId != 0) {
                j = 0;
                z2 = false;
            } else {
                j = Yq.field_lastSeq;
                z2 = true;
            }
            if (Yq.field_firstUnDeliverSeq != 0) {
                Yq.av(0);
                Yq.au(0);
                ((i) g.l(i.class)).FW().a(Yq, str);
                x.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            }
            z = z2;
        } else {
            j = 0;
            z = false;
        }
        if (!z) {
            bd Hb = ((i) g.l(i.class)).bcY().Hb(str);
            if (!(Hb == null || Hb.field_msgId == 0)) {
                z = true;
            }
        }
        if (j == 0) {
            j = ((i) g.l(i.class)).bcY().Ha(str);
        }
        if (j != 0) {
            ((i) g.l(i.class)).Gx().F(str, j);
        }
        x.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j)});
        return z;
    }

    public static List<Boolean> E(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String gz : list) {
            arrayList.add(Boolean.valueOf(gz(gz)));
        }
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        a(str, list, str2, z, str3, 2);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        bd bdVar = new bd();
        bdVar.ep(str);
        bdVar.setType(10000);
        bdVar.ay(System.currentTimeMillis());
        bdVar.setStatus(4);
        bdVar.eX(i);
        CharSequence stringBuffer = new StringBuffer();
        if (list != null) {
            String GF = q.GF();
            String string = ad.getContext().getString(a.chatroom_sys_msg_invite_split);
            for (String str4 : list) {
                if (!str4.equals(GF)) {
                    ab Yg = ((i) g.l(i.class)).FR().Yg(str4);
                    if (Yg == null || ((int) Yg.dhP) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + Yg.BL() + "</a>" + string);
                    } else {
                        stringBuffer.append(Yg.BL() + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        bdVar.setContent(str2.replace("%s", stringBuffer));
        ((i) g.l(i.class)).bcY().T(bdVar);
    }
}
