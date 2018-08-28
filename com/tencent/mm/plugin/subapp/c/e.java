package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    private static final f<Integer, e> dzj = new f(100);
    public String bGP;
    public int dwo;
    public String dwp;
    public int orn;
    public int oro;
    public String orp;
    public int orq;
    public int orr;
    public int ors;
    public int ort;

    public static e Oj(String str) {
        if (bi.oW(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = (e) dzj.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            return eVar;
        }
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.dwo = bi.getInt((String) z.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.bGP = (String) z.get(".msg.appmsg.appattach.attachid");
            eVar2.dwp = (String) z.get(".msg.appmsg.appattach.fileext");
            eVar2.orn = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.oro = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.orp = (String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.orq = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.orr = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.ors = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.ort = bi.getInt((String) z.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            dzj.m(Integer.valueOf(hashCode), eVar2);
            return eVar2;
        } catch (Throwable e) {
            x.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            x.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e, "", new Object[0]);
            return null;
        }
    }
}
