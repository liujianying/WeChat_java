package com.tencent.mm.ad;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class a$a {
    private static final f<Integer, a$a> dzj = new f(100);
    public String bSS;
    public String dNZ;
    public String dOa;
    public String dOb;
    public String dOc;
    public String dOd;
    public String dOe;
    public String dOf;
    public String dOg;
    public String dOh;
    public String toUser;

    public static final a$a ln(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BrandQALogic", "empty xml to parse");
            return null;
        }
        int indexOf = str.indexOf("<qamsg");
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        a$a a_a = (a$a) dzj.get(Integer.valueOf(hashCode));
        if (a_a != null) {
            return a_a;
        }
        Map z = bl.z(str, "qamsg");
        if (z == null) {
            x.e("MicroMsg.BrandQALogic", "parse msg failed");
            return null;
        }
        try {
            a$a a_a2 = new a$a();
            a_a2.bSS = (String) z.get(".qamsg.$fromUser");
            a_a2.dNZ = (String) z.get(".qamsg.$fromNickname");
            a_a2.toUser = (String) z.get(".qamsg.$title");
            a_a2.dOa = (String) z.get(".qamsg.question.$id");
            a_a2.dOb = (String) z.get(".qamsg.question.$fromUser");
            a_a2.dOc = (String) z.get(".qamsg.question.content");
            a_a2.dOd = (String) z.get(".qamsg.answer.$id");
            a_a2.dOe = (String) z.get(".qamsg.answer.$fromUser");
            a_a2.dOf = (String) z.get(".qamsg.answer.content");
            a_a2.dOd = (String) z.get(".qamsg.answer1.$id");
            a_a2.dOg = (String) z.get(".qamsg.answer1.$fromUser");
            a_a2.dOh = (String) z.get(".qamsg.answer1.content");
            dzj.m(Integer.valueOf(hashCode), a_a2);
            return a_a2;
        } catch (Throwable e) {
            x.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
            x.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
            return null;
        }
    }
}
