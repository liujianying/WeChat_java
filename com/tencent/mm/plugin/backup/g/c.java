package com.tencent.mm.plugin.backup.g;

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

public final class c {
    public static void l(HashMap<String, Integer> hashMap) {
        x.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[]{Integer.valueOf(hashMap.size())});
        for (String str : hashMap.keySet()) {
            bd dG = d.asG().asH().FT().dG(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dG != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dG.field_talker;
                x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[]{str2, Integer.valueOf(intValue)});
                ai Yq = d.asG().asH().FW().Yq(str2);
                if (Yq == null || Yq.field_conversationTime <= dG.field_createTime || Yq.field_conversationTime == Long.MAX_VALUE) {
                    boolean z;
                    if (Yq == null) {
                        Yq = new ai(str2);
                        z = true;
                    } else {
                        z = false;
                    }
                    Yq.eX(dG.field_isSend);
                    Yq.eV(intValue + Yq.field_unReadCount);
                    Yq.aj(dG);
                    Yq.ec(Integer.toString(dG.getType()));
                    Yq.at((Yq.field_flag & 4611686018427387904L) | (dG.field_createTime & 72057594037927935L));
                    Yq.eU(0);
                    x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[]{Boolean.valueOf(z), str2, Long.valueOf(Yq.field_flag)});
                    if (z) {
                        d.asG().asH().FW().d(Yq);
                    } else {
                        d.asG().asH().FW().a(Yq, str2);
                    }
                } else {
                    x.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        d.asG().asH().FW().clB();
    }

    public static boolean fq(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(bd bdVar) {
        ab Yg = d.asG().asH().FR().Yg(bdVar.field_talker);
        if (Yg == null || ((int) Yg.dhP) == 0) {
            if (!bi.oW(bdVar.field_talker)) {
                d.asG().asI().f(2, bdVar.field_talker);
                d.asG().asH().FR().T(new ab(bdVar.field_talker));
            } else if (bdVar.field_talker.endsWith("@chatroom")) {
                b asH = d.asG().asH();
                if (asH.uin == 0) {
                    throw new b();
                } else if (asH.gYK.il(bdVar.field_talker) == null) {
                    d.asG().asI().f(2, bdVar.field_talker);
                }
            }
        }
        long T = d.asG().asH().FT().T(bdVar);
        if (T < 0) {
            x.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[]{Integer.valueOf(bdVar.getType()), bdVar.field_talker});
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
        return d.asG().asH().Ta().nI(str);
    }

    public static String wG(String str) {
        b asH = d.asG().asH();
        if (asH.uin == 0) {
            throw new b();
        }
        String b = h.b(asH.dqp + "voice2/", "msg_", str, ".amr", 2);
        if (bi.oW(b)) {
            return null;
        }
        if (new File(b).exists()) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b asH2 = d.asG().asH();
        if (asH2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(asH2.dqp + "voice/").append(str).toString();
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
