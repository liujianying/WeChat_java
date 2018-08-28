package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            Object linkedList = new LinkedList();
            String a = ab.a(byVar.rcj);
            String a2 = ab.a(byVar.rck);
            String str = ((String) g.Ei().DT().get(2, null)).equals(a) ? a2 : a;
            String a3 = ab.a(byVar.rcl);
            x.d("MicroMsg.TrackMsgExtension", "cmd " + a3);
            Map z = bl.z(a3, "sysmsg");
            if (z != null) {
                try {
                    String br;
                    String bs;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("talk  " + str + "\r\n");
                    stringBuffer.append("from fromUser " + a + "\r\n");
                    stringBuffer.append("from toUser " + a2 + "\r\n");
                    String str2 = (String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                    double FL = FL((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                    stringBuffer.append("lat " + FL + "\r\n");
                    double FL2 = FL((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                    stringBuffer.append("lng " + FL2 + "\r\n");
                    stringBuffer.append("times " + bi.getInt((String) z.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + "\r\n");
                    int i = 0;
                    while (true) {
                        a3 = (String) z.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                        if (bi.oW(a3)) {
                            break;
                        }
                        i++;
                        linkedList.add(a3);
                    }
                    stringBuffer.append("userNameList size " + linkedList.size() + "\r\n");
                    x.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                    if (str.equals(l.aZi().kDN)) {
                        br = br(linkedList);
                        bs = bi.oW(br) ? bs(linkedList) : null;
                    } else {
                        bs = null;
                        br = null;
                    }
                    l.aZj().a(str, linkedList, FL, FL2, str2, br, bs);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    private static double FL(String str) {
        if (str == null) {
            return 0.0d;
        }
        return bi.getDouble(str, 0.0d);
    }

    private static String br(List<String> list) {
        String str;
        List<String> aZp = l.aZi().aZp();
        List linkedList = new LinkedList();
        for (String str2 : list) {
            Object obj;
            for (String equals : aZp) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(q.GF())) {
                return str2;
            }
        }
        return null;
    }

    private static String bs(List<String> list) {
        String str;
        List<String> aZp = l.aZi().aZp();
        List linkedList = new LinkedList();
        for (String str2 : aZp) {
            Object obj;
            for (String str3 : list) {
                if (str3.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str3 = (String) linkedList.get(i);
            if (!str3.equals(q.GF())) {
                return str3;
            }
        }
        return null;
    }
}
