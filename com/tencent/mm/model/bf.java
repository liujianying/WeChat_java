package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class bf {
    public static int dCI = 0;

    public static void y(String str, boolean z) {
        if (!"bizflag".equals(str)) {
            return;
        }
        if (z) {
            dCI |= 1;
        } else {
            dCI &= -2;
        }
    }

    public static String Iq() {
        StringBuilder stringBuilder = new StringBuilder();
        if (dCI != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(dCI);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        return stringBuilder.toString();
    }

    public static int k(bd bdVar) {
        if (bdVar == null) {
            return 0;
        }
        int i;
        Map z = bl.z(bdVar.cqb, "msgsource");
        if (z != null) {
            String str = (String) z.get(".msgsource.bizflag");
            if (!bi.oW(str)) {
                i = bi.getInt(str, 0);
                return i;
            }
        }
        i = 0;
        return i;
    }

    public static String Ir() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bi.oV(Iq()));
        if (stringBuilder.length() <= 0) {
            return null;
        }
        stringBuilder.insert(0, "<msgsource>");
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static boolean l(bd bdVar) {
        if (!(bdVar == null || bi.oW(bdVar.cqb))) {
            Map z = bl.z(bdVar.cqb, "msgsource");
            if (z != null && bi.WU((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                return true;
            }
        }
        return false;
    }

    public static void m(bd bdVar) {
        if (bdVar != null && !bi.oW(bdVar.cqb)) {
            Map z = bl.z(bdVar.cqb, "msgsource");
            if (z != null && bi.WU((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                try {
                    CharSequence substring = bdVar.cqb.substring(bdVar.cqb.indexOf("<sec_msg_node"), (bdVar.cqb.indexOf("</sec_msg_node") + 12) + 2);
                    x.i("MicroMsg.MsgSourceHelper", substring);
                    if (!bi.oW(substring)) {
                        bdVar.dt(bdVar.cqb.replace(substring, substring.replace(substring.substring(substring.indexOf("<sfn"), (substring.indexOf("</sfn") + 3) + 2), "<sfn>0<sfn/>")));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgSourceHelper", e, "resetShareForbidden msg exception", new Object[0]);
                }
            }
        }
    }

    public static boolean bG(bd bdVar) {
        if (!(bdVar == null || bi.oW(bdVar.cqb))) {
            Map z = bl.z(bdVar.cqb, "msgsource");
            if (z != null && bi.WU((String) z.get(".msgsource.sec_msg_node.fd")) == 1) {
                return true;
            }
        }
        return false;
    }

    public static String n(bd bdVar) {
        if (!(bdVar == null || bi.oW(bdVar.cqb))) {
            Map z = bl.z(bdVar.cqb, "msgsource");
            if (z != null) {
                String str = (String) z.get(".msgsource.sec_msg_node.show-h5");
                if (!bi.oW(str)) {
                    return str;
                }
            }
        }
        return "";
    }

    public static String Is() {
        String str = (String) g.Ei().DT().get(70, null);
        if (!bi.oW(str)) {
            g.Ei().DT().set(70, "");
        }
        x.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[]{str});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(bi.oV(str));
        if (dCI != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(dCI);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static void iH(String str) {
        x.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[]{str, ""});
    }
}
