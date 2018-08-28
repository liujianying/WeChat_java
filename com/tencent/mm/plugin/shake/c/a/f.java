package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    public List<WeakReference<a>> htB;
    private String mXu;

    public interface a {
        void buL();
    }

    public static class d extends c {
        protected String mXC;
        protected String mXD;
        protected String mXE;
    }

    public f() {
        this.htB = new ArrayList();
        this.mXu = "";
        this.mXu = com.tencent.mm.plugin.shake.c.c.a.buX();
    }

    public final void e(String str, long j, int i) {
        d dVar = null;
        x.i("MicroMsg.ShakeCardMsgMgr", "msg_id is " + j);
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            return;
        }
        Map z;
        if (i == 0) {
            b bVar;
            x.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            z = bl.z(str, "sysmsg");
            if (z != null) {
                b bVar2 = new b();
                String str2 = (String) z.get(".sysmsg.begintime");
                if (TextUtils.isEmpty(str2) || !xW(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is " + str2);
                    bVar2.mXv = 0;
                } else {
                    bVar2.mXv = Integer.valueOf(str2).intValue();
                }
                str2 = (String) z.get(".sysmsg.endtime");
                if (TextUtils.isEmpty(str2) || !xW(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is " + str2);
                    bVar2.mXw = 0;
                } else {
                    bVar2.mXw = Integer.valueOf(str2).intValue();
                }
                bVar2.mXx = (String) z.get(".sysmsg.entrancename");
                str2 = (String) z.get(".sysmsg.activitytype");
                if (TextUtils.isEmpty(str2) || !xW(str2)) {
                    bVar2.mXy = 1;
                } else {
                    bVar2.mXy = Integer.valueOf(str2).intValue();
                }
                x.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is " + str2);
                str2 = (String) z.get(".sysmsg.flowcontrollevelmin");
                if (TextUtils.isEmpty(str2) || !xW(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is " + str2);
                    bVar2.mXz = 0;
                } else {
                    bVar2.mXz = Integer.valueOf(str2).intValue();
                }
                bVar2.mXB = (String) z.get(".sysmsg.shakecardentrancetip");
                str2 = (String) z.get(".sysmsg.flowcontrollevelmax");
                if (TextUtils.isEmpty(str2) || !xW(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is " + str2);
                    bVar2.mXA = 0;
                } else {
                    bVar2.mXA = Integer.valueOf(str2).intValue();
                }
                bVar = bVar2;
            }
            if (bVar == null) {
                x.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            } else {
                x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
                if (!com.tencent.mm.plugin.shake.c.c.a.bux()) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
                }
                x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.mXv + "  endtime:" + bVar.mXw + "  flowlevelmin:" + bVar.mXz + "  flowlevelmax:" + bVar.mXA + " entrancename:" + bVar.mXx + " activitytype:" + bVar.mXy);
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOB, Integer.valueOf(bVar.mXv));
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOC, Integer.valueOf(bVar.mXw));
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOD, bVar.mXx);
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOH, Integer.valueOf(bVar.mXy));
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOE, Integer.valueOf(bVar.mXz));
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOF, Integer.valueOf(bVar.mXA));
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOG, bVar.mXB);
            }
            buK();
        } else if (i == 1) {
            x.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            z = bl.z(str, "sysmsg");
            if (z != null) {
                d dVar2 = new d();
                dVar2.mXC = (String) z.get(".sysmsg.reddotid");
                dVar2.mXD = (String) z.get(".sysmsg.reddotdesc");
                dVar2.mXE = (String) z.get(".sysmsg.reddottext");
                dVar = dVar2;
            }
            if (dVar == null) {
                x.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            } else {
                x.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.mXC);
                x.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.mXu);
                if (TextUtils.isEmpty(dVar.mXC)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
                } else if (TextUtils.isEmpty(this.mXu)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
                    com.tencent.mm.s.c.Cp().v(262154, true);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOI, dVar.mXC);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOJ, dVar.mXD);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOK, dVar.mXE);
                    auM();
                } else if (!this.mXu.equals(dVar.mXC)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
                    com.tencent.mm.s.c.Cp().v(262154, true);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOI, dVar.mXC);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOJ, dVar.mXD);
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sOK, dVar.mXE);
                    auM();
                } else if (this.mXu.equals(dVar.mXC)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
                }
            }
            buK();
        }
        com.tencent.mm.plugin.shake.c.c.a.buw();
    }

    private static void buK() {
        com.tencent.mm.sdk.b.a.sFg.m(new pg());
    }

    private static boolean xW(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void auM() {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.buL();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
