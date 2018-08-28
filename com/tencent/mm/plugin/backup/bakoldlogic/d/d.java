package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.HashMap;

public final class d {
    public static void l(HashMap<String, Integer> hashMap) {
        for (String str : hashMap.keySet()) {
            bd dG = b.atl().atm().FT().dG(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dG != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dG.field_talker;
                x.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[]{str2, Integer.valueOf(intValue)});
                ai Yq = b.atl().atm().FW().Yq(str2);
                if (Yq == null || Yq.field_conversationTime <= dG.field_createTime || Yq.field_conversationTime == Long.MAX_VALUE) {
                    int i;
                    if (Yq == null) {
                        x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[]{str2});
                        Yq = new ai(str2);
                        i = 1;
                    } else {
                        i = 0;
                    }
                    Yq.eX(dG.field_isSend);
                    Yq.eV(intValue + Yq.field_unReadCount);
                    Yq.aj(dG);
                    Yq.ec(Integer.toString(dG.getType()));
                    Yq.at((Yq.field_flag & 4611686018427387904L) | (dG.field_createTime & 72057594037927935L));
                    Yq.eU(0);
                    if (i != 0) {
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[]{str2, Long.valueOf(Yq.field_flag)});
                        b.atl().atm().FW().d(Yq);
                    } else {
                        b.atl().atm().FW().a(Yq, str2);
                    }
                } else {
                    x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        b.atl().atm().FW().clB();
    }

    public static boolean fq(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(bd bdVar) {
        ab Yg = b.atl().atm().FR().Yg(bdVar.field_talker);
        if (Yg == null || ((int) Yg.dhP) == 0) {
            if (!bi.oW(bdVar.field_talker)) {
                b.atl().atn().f(2, bdVar.field_talker);
                b.atl().atm().FR().T(new ab(bdVar.field_talker));
            } else if (bdVar.field_talker.endsWith("@chatroom")) {
                c atm = b.atl().atm();
                if (atm.uin == 0) {
                    throw new b();
                } else if (atm.gYK.il(bdVar.field_talker) == null) {
                    b.atl().atn().f(2, bdVar.field_talker);
                }
            }
        }
        long T = b.atl().atm().FT().T(bdVar);
        if (T < 0) {
            x.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[]{Integer.valueOf(bdVar.getType()), bdVar.field_talker});
        }
        return T;
    }

    public static int iA(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
            return indexOf;
        }
        return -1;
    }

    public static r wF(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return b.atl().atm().Ta().nI(str);
    }

    public static String wG(String str) {
        c atm = b.atl().atm();
        if (atm.uin == 0) {
            throw new b();
        }
        String b = h.b(atm.dqp + "voice2/", "msg_", str, ".amr", 2);
        if (bi.oW(b)) {
            return null;
        }
        if (new File(b).exists()) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c atm2 = b.atl().atm();
        if (atm2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(atm2.dqp + "voice/").append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            j.q(stringBuilder2 + ".amr", b, true);
            return b;
        } else if (!new File(stringBuilder2).exists()) {
            return b;
        } else {
            j.q(stringBuilder2, b, true);
            return b;
        }
    }
}
