package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.c;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.List;
import java.util.Map;

public final class bd {

    /* renamed from: com.tencent.mm.model.bd$1 */
    static class AnonymousClass1 implements Runnable {
        final int dCf = HardCoderJNI.sHCDBDELAY_WRITE;
        final int dCg = 30;
        final int dCh = 5;
        int dCi = 100;
        final /* synthetic */ List dCj;

        public AnonymousClass1(List list) {
            this.dCj = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.dCj.size()));
            for (String str : this.dCj) {
                long Gw = ((i) g.l(i.class)).Gx().Gw(str);
                if (Gw > 0) {
                    long VF = bi.VF();
                    int i = 0;
                    long j = 0;
                    while (true) {
                        long j2;
                        int i2 = i;
                        if (this.dCi < HardCoderJNI.sHCDBDELAY_WRITE && this.dCi > 30) {
                            if (j > 500) {
                                i = this.dCi - 5;
                            } else {
                                i = this.dCi + 5;
                            }
                            this.dCi = i;
                        }
                        long VF2 = bi.VF();
                        Cursor f = ((i) g.l(i.class)).bcY().f(str, this.dCi, Gw);
                        long j3 = 0;
                        j = 0;
                        while (true) {
                            j2 = j;
                            if (!f.moveToNext()) {
                                break;
                            }
                            cm bdVar = new com.tencent.mm.storage.bd();
                            bdVar.d(f);
                            if (j3 < bdVar.field_createTime) {
                                j3 = bdVar.field_createTime;
                            }
                            j = 1 + j2;
                            bd.j(bdVar);
                        }
                        f.close();
                        long VF3 = bi.VF();
                        if (j3 > 0 && j2 > 0) {
                            ((i) g.l(i.class)).bcY().S(str, j3);
                        }
                        i = (int) (((long) i2) + j2);
                        j = bi.VF() - VF2;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bi.Xf(str), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(Gw - j3), Long.valueOf(Gw), Long.valueOf(r20 - VF3), Long.valueOf(r20 - VF2), Long.valueOf(bi.VF() - VF), Integer.valueOf(this.dCi));
                        if (j2 <= 0) {
                            break;
                        }
                    }
                    ((i) g.l(i.class)).Gx().G(str, 0);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.model.bd$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ List dCj;

        public AnonymousClass5(List list) {
            this.dCj = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.dCj.size()));
            for (String str : this.dCj) {
                cm GE = ((i) g.l(i.class)).bcY().GE(str);
                long j = GE == null ? Long.MAX_VALUE : GE.field_createTime;
                if (GE != null && GE.field_createTime > 0) {
                    ((i) g.l(i.class)).Gx().G(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, GE, Long.valueOf(j));
                Cursor GN = ((i) g.l(i.class)).bcY().GN(str);
                if (GN != null) {
                    if (GN.moveToFirst()) {
                        while (!GN.isAfterLast()) {
                            com.tencent.mm.storage.bd bdVar = new com.tencent.mm.storage.bd();
                            bdVar.d(GN);
                            bd.j(bdVar);
                            GN.moveToNext();
                        }
                    }
                    GN.close();
                    int GK = ((i) g.l(i.class)).bcY().GK(str);
                    x.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(GK));
                    ((i) g.l(i.class)).Gx().G(str, 0);
                }
            }
        }
    }

    public interface a {
        void Io();

        boolean Ip();
    }

    public static class b {
        public int dCA;
        public int dCB;
        public int dCC;
        public String dCD;
        public String dCl;
        public int dCm;
        public int dCn;
        public int dCo;
        public String dCp;
        public String dCq;
        public int dCr;
        public String dCs;
        public String dCt;
        public String dCu;
        public String dCv;
        public String dCw;
        public String dCx;
        public String dCy;
        public int dCz;
        public int scene = 0;
        public String userId;
    }

    public static String U(String str, String str2) {
        if (bi.oW(str)) {
            return null;
        }
        return !bi.oW(str2) ? str2 + ": " + str : str;
    }

    public static int iA(String str) {
        if (str == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            return -1;
        } else if (str.length() <= 0) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                return indexOf;
            }
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            return -1;
        }
    }

    public static String iB(String str) {
        int iA = iA(str);
        if (iA == -1) {
            return null;
        }
        return str.substring(0, iA);
    }

    public static String iC(String str) {
        int iA = iA(str);
        return (iA != -1 && iA + 2 < str.length()) ? str.substring(iA + 2) : str;
    }

    public static long i(com.tencent.mm.storage.bd bdVar) {
        com.tencent.mm.l.a Yg = ((i) g.l(i.class)).FR().Yg(bdVar.field_talker);
        if (Yg == null || ((int) Yg.dhP) == 0) {
            ab abVar = new ab(bdVar.field_talker);
            abVar.setType(2);
            com.tencent.mm.sdk.b.b joVar = new jo();
            joVar.bTj.bTk = abVar;
            com.tencent.mm.sdk.b.a.sFg.m(joVar);
            ((i) g.l(i.class)).FR().T(abVar);
        }
        return ((i) g.l(i.class)).bcY().T(bdVar);
    }

    public static boolean hd(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long Ik() {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before fix, now is :%s", Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("client_server_diff_time_enable", 0);
        int i2 = sharedPreferences.getInt("client_server_diff_time_interval", 0);
        if (i <= 0 || i2 <= 0) {
            return currentTimeMillis;
        }
        g.Ek();
        Object obj = g.Ei().DT().get(com.tencent.mm.storage.aa.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, null);
        if (obj == null) {
            return currentTimeMillis;
        }
        long j = bi.getLong(obj.toString(), 0);
        if (Math.abs(j / 1000) > ((long) i2)) {
            return currentTimeMillis - j;
        }
        return currentTimeMillis;
    }

    public static long iD(String str) {
        long Ik = Ik();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(Ik));
        if (str != null) {
            cm GE = ((i) g.l(i.class)).bcY().GE(str);
            if (GE != null) {
                x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(GE.field_msgId), Long.valueOf(Ik));
                if (GE.field_createTime + 1 > Ik) {
                    return GE.field_createTime + 1;
                }
            }
        }
        return Ik;
    }

    public static long o(String str, long j) {
        long j2;
        if (str != null) {
            cm GE = ((i) g.l(i.class)).bcY().GE(str);
            if (GE != null) {
                j2 = GE.field_createTime + 1;
                return j2 <= j * 1000 ? j2 : j * 1000;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    public static void j(com.tencent.mm.storage.bd bdVar) {
        if (bdVar != null) {
            int type = bdVar.getType();
            switch (type) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    type = 49;
                    break;
            }
            d ba = c.ba(Integer.valueOf(type));
            if (ba != null) {
                ba.h(bdVar);
            }
            com.tencent.mm.sdk.b.b cdVar = new cd();
            cdVar.bJB.bJC = bdVar.field_msgId;
            cdVar.bJB.talker = bdVar.field_talker;
            cdVar.bJB.msgType = bdVar.getType();
            com.tencent.mm.sdk.b.a.sFg.m(cdVar);
        }
    }

    public static void I(List<Long> list) {
        if (list.size() != 0) {
            for (Long longValue : list) {
                aU(longValue.longValue());
            }
        }
    }

    public static int aU(long j) {
        cm dW = ((i) g.l(i.class)).bcY().dW(j);
        if (dW.field_msgId != j) {
            return 0;
        }
        j(dW);
        return ((i) g.l(i.class)).bcY().dX(j);
    }

    public static int p(String str, long j) {
        cm I = ((i) g.l(i.class)).bcY().I(str, j);
        if (I.field_msgSvrId != j) {
            return 0;
        }
        j(I);
        return ((i) g.l(i.class)).bcY().R(str, j);
    }

    public static int iE(String str) {
        return ((i) g.l(i.class)).bcY().GK(str);
    }

    public static int a(final String str, final a aVar) {
        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, bi.cjd());
        e.post(new Runnable() {
            final int dCf = HardCoderJNI.sHCDBDELAY_WRITE;
            final int dCg = 30;
            final int dCh = 5;
            int dCi = 100;

            public final void run() {
                cm GE = ((i) g.l(i.class)).bcY().GE(str);
                long j = GE == null ? Long.MAX_VALUE : GE.field_createTime;
                if (GE != null && GE.field_createTime > 0) {
                    ((i) g.l(i.class)).Gx().G(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), GE, Long.valueOf(j));
                long VF = bi.VF();
                int i = 0;
                long j2 = 0;
                long j3;
                do {
                    if (this.dCi < HardCoderJNI.sHCDBDELAY_WRITE && this.dCi > 30) {
                        int i2;
                        if (j2 > 500) {
                            i2 = this.dCi - 5;
                        } else {
                            i2 = this.dCi + 5;
                        }
                        this.dCi = i2;
                    }
                    long VF2 = bi.VF();
                    Cursor f = ((i) g.l(i.class)).bcY().f(str, this.dCi, j);
                    long j4 = 0;
                    j2 = 0;
                    while (true) {
                        j3 = j2;
                        if (!f.moveToNext()) {
                            break;
                        }
                        cm bdVar = new com.tencent.mm.storage.bd();
                        bdVar.d(f);
                        if (j4 < bdVar.field_createTime) {
                            j4 = bdVar.field_createTime;
                        }
                        j2 = 1 + j3;
                        bd.j(bdVar);
                    }
                    f.close();
                    long VF3 = bi.VF();
                    if (j4 > 0 && j3 > 0) {
                        ((i) g.l(i.class)).bcY().S(str, j4);
                    }
                    i = (int) (((long) i) + j3);
                    j2 = bi.VF() - VF2;
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bi.Xf(str), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j - j4), Long.valueOf(j), Long.valueOf(bi.VF() - VF3), Long.valueOf(bi.VF() - VF2), Long.valueOf(bi.VF() - VF), Integer.valueOf(this.dCi));
                } while (j3 > 0);
                ((i) g.l(i.class)).Gx().G(str, 0);
            }
        }, "deleteMsgByTalker");
        ah.A(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.Io();
                }
            }
        });
        return 0;
    }

    public static void a(final a aVar) {
        g.Ek();
        g.Em().H(new Runnable() {
            public final void run() {
                if (aVar == null || !aVar.Ip()) {
                    ((i) g.l(i.class)).FW().cly();
                    if (aVar == null || !aVar.Ip()) {
                        bd.Im();
                        if (aVar == null || !aVar.Ip()) {
                            bd.In();
                            if (aVar == null || !aVar.Ip()) {
                                bd.Il();
                                if (aVar == null || !aVar.Ip()) {
                                    List GH = ((i) g.l(i.class)).bcY().GH("message");
                                    if (GH != null) {
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= GH.size()) {
                                                break;
                                            }
                                            bd.j((com.tencent.mm.storage.bd) GH.get(i2));
                                            i = i2 + 1;
                                        }
                                    }
                                    ((i) g.l(i.class)).bcY().GJ("message");
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    ah.A(new Runnable() {
                        public final void run() {
                            aVar.Io();
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|deleteAllMsg";
            }
        });
    }

    public static void Il() {
        List GH = ((i) g.l(i.class)).bcY().GH("bottlemessage");
        if (GH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= GH.size()) {
                    break;
                }
                j((com.tencent.mm.storage.bd) GH.get(i2));
                i = i2 + 1;
            }
        }
        ((i) g.l(i.class)).bcY().GJ("bottlemessage");
    }

    public static void Im() {
        List GH = ((i) g.l(i.class)).bcY().GH("qmessage");
        if (GH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= GH.size()) {
                    break;
                }
                j((com.tencent.mm.storage.bd) GH.get(i2));
                i = i2 + 1;
            }
        }
        ((i) g.l(i.class)).bcY().GJ("qmessage");
    }

    public static void In() {
        List GH = ((i) g.l(i.class)).bcY().GH("tmessage");
        if (GH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= GH.size()) {
                    break;
                }
                j((com.tencent.mm.storage.bd) GH.get(i2));
                i = i2 + 1;
            }
        }
        ((i) g.l(i.class)).bcY().GJ("tmessage");
    }

    public static b iF(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            Map z = bl.z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                return null;
            }
            b bVar = new b();
            bVar.dCl = (String) z.get(".msgsource.bizmsg.msgcluster");
            bVar.dCq = (String) z.get(".msgsource.kf.kf_worker");
            bVar.dCp = bi.oV((String) z.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.dCt = bi.oV((String) z.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.dCu = bi.oV((String) z.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.dCv = bi.oV((String) z.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = bi.oV((String) z.get(".msgsource.enterprise_info.user_id"));
            bVar.dCw = bi.oV((String) z.get(".msgsource.enterprise_info.user_nickname"));
            bVar.dCx = bi.oV((String) z.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.dCs = (String) z.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = bi.getInt((String) z.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.dCy = (String) z.get(".msgsource.NotAutoDownloadRange");
            bVar.dCz = bi.getInt((String) z.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.dCA = bi.getInt((String) z.get(".msgsource.videopreloadlen"), 0);
            bVar.dCB = bi.getInt((String) z.get(".msgsource.PreDownload"), 0);
            bVar.dCC = bi.getInt((String) z.get(".msgsource.PreDownloadNetType"), 0);
            bVar.dCD = (String) z.get(".msgsource.NoPreDownloadRange");
            bVar.dCm = bi.getInt((String) z.get(".msgsource.msg_cluster_type"), -1);
            bVar.dCn = bi.getInt((String) z.get(".msgsource.service_type"), -1);
            bVar.dCo = bi.getInt((String) z.get(".msgsource.scene"), -1);
            bVar.dCr = bi.getInt((String) z.get(".msgsource.bizmsg.msg_predict"), 0);
            return bVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", bi.i(e));
            x.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            return null;
        }
    }

    public static String iG(String str) {
        b iF = iF(str);
        if (iF == null) {
            return null;
        }
        return iF.dCq;
    }

    public static void a(com.tencent.mm.storage.bd bdVar, com.tencent.mm.ab.d.a aVar) {
        if (bdVar == null || aVar == null || aVar.dIN == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", bi.cjd());
        } else if (bdVar.field_msgSvrId == aVar.dIN.rcq) {
            by byVar = aVar.dIN;
            if (bdVar.field_isSend == 0 || byVar.rcr != 0) {
                if (bdVar.field_msgSeq == 0 && byVar.rcr != 0) {
                    bdVar.aA((long) byVar.rcr);
                }
                int i = bdVar.field_flag;
                if (aVar.dIO) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.dIP) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.dIQ) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                bdVar.fg(i);
                if (bdVar.field_msgId == 0 && aVar.dIO) {
                    bdVar.ay(g(bdVar.field_talker, (long) aVar.dIN.lOH, (long) aVar.dIN.rcr));
                }
            }
        }
    }

    public static int c(com.tencent.mm.ab.d.a aVar) {
        int i = 0;
        if (aVar.dIO) {
            i = 2;
        }
        if (aVar.dIP) {
            i |= 1;
        }
        if (aVar.dIQ) {
            return i | 4;
        }
        return i;
    }

    public static String b(boolean z, String str, int i) {
        if (z && str != null && i == 0) {
            return iC(str);
        }
        return str;
    }

    public static long g(String str, long j, long j2) {
        cm GE;
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        if (str != null) {
            GE = ((i) g.l(i.class)).bcY().GE(str);
            if (GE != null) {
                j4 = GE.field_createTime;
            }
            j5 = ((i) g.l(i.class)).bcY().GY(str);
        }
        if (j5 == j4) {
            return j3 == j4 ? j3 + 1 : j3;
        } else {
            if (j5 >= j4) {
                x.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
                return j3;
            } else if (j3 == j5) {
                return j3 - 1;
            } else {
                if (j3 == j4) {
                    return j3 + 1;
                }
                if (j2 == 0 || j3 > j4) {
                    return j3;
                }
                cm K = ((i) g.l(i.class)).bcY().K(str, j3);
                if (!(K.field_msgSeq == 0 || K.field_msgSeq == j2)) {
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", Long.valueOf(K.field_msgSeq), Long.valueOf(j2), Long.valueOf(K.field_createTime), Long.valueOf(j3));
                    if (j2 < K.field_msgSeq) {
                        GE = ((i) g.l(i.class)).bcY().O(str, j3 - 1000);
                    } else {
                        GE = ((i) g.l(i.class)).bcY().N(str, 1000 + j3);
                    }
                    if (GE.field_msgSeq == 0 || GE.field_msgSeq == j2) {
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", Long.valueOf(K.field_msgSeq), Long.valueOf(j2), Long.valueOf(K.field_createTime), Long.valueOf(j3));
                    } else {
                        j4 = GE.field_msgSeq < j2 ? GE.field_createTime + 1 : GE.field_createTime - 1;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", Long.valueOf(K.field_msgSeq), Long.valueOf(GE.field_msgSeq), Long.valueOf(j2), Long.valueOf(K.field_createTime), Long.valueOf(GE.field_createTime), Long.valueOf(j4));
                        return j4;
                    }
                }
                j4 = j3;
                return j4;
            }
        }
    }
}
