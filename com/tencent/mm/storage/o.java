package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.ac.a.a;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o extends e {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public o(f fVar) {
        super(fVar);
        a(bdc(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
    }

    public final String XG(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (com.tencent.mm.ac.f.eZ(str)) {
            return "bizchatmessage";
        }
        return null;
    }

    private static String ap(String str, long j) {
        return " bizChatId= " + j + " AND talker= '" + str + "'";
    }

    public final bd aq(String str, long j) {
        if (bi.oW(str)) {
            return null;
        }
        bd bdVar = new bd();
        Cursor b = bdc().b("select * from " + GX(str) + " where" + ap(str, j) + "order by createTime DESC limit 1", null, 0);
        if (b.getCount() != 0) {
            b.moveToFirst();
            bdVar.d(b);
        }
        b.close();
        return bdVar;
    }

    public final List<bd> h(String str, long j, int i) {
        List<bd> arrayList = new ArrayList();
        Cursor b = bdc().b("SELECT * FROM " + GX(str) + " WHERE" + ap(str, j) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (b.moveToFirst()) {
            while (!b.isAfterLast()) {
                bd bdVar = new bd();
                bdVar.d(b);
                b.moveToNext();
                if (bdVar.isText()) {
                    arrayList.add(bdVar);
                }
            }
        }
        b.close();
        return arrayList;
    }

    protected final boolean a(bd bdVar, bd.b bVar) {
        if (bdVar == null) {
            x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            return false;
        }
        bdVar.az(-1);
        if (bVar != null) {
            if (com.tencent.mm.ac.f.eZ(bdVar.field_talker)) {
                if (bi.oW(bVar.dCu)) {
                    x.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[]{bdVar.cqb});
                    return false;
                }
                c cVar = new c();
                cVar.field_bizChatServId = bVar.dCu;
                cVar.field_brandUserName = bdVar.field_talker;
                if (!bi.oW(bVar.dCv)) {
                    cVar.field_chatVersion = bi.getInt(bVar.dCv, -1);
                }
                if (!bi.oW(bVar.dCt)) {
                    cVar.field_chatType = bi.getInt(bVar.dCt, -1);
                }
                x.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[]{bVar.dCu, bVar.userId});
                cVar = e.e(cVar);
                if (cVar != null) {
                    bdVar.az(cVar.field_bizChatLocalId);
                    bdVar.field_bizChatUserId = bi.oV(bVar.userId);
                    bdVar.cGu = true;
                    if (bVar.dCx.equals("1")) {
                        bdVar.eX(1);
                    }
                    if (!(bdVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(z.Nc().cA(bdVar.field_talker))) {
                            bdVar.eX(1);
                        }
                    }
                    if (!bi.oW(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.dCw;
                        jVar.field_brandUserName = bdVar.field_talker;
                        z.Nc().c(jVar);
                    }
                } else {
                    x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    return false;
                }
            } else if (!bi.oW(bVar.dCu)) {
                x.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                return false;
            }
        }
        return true;
    }

    public final List<bd> b(String str, long j, long j2, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
            return null;
        }
        long Q = this.sNO.Q(str, j2);
        if (Q == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<bd> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + GX(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ap(str, j) + "AND " + this.sNO.bdk() + " AND createTime > " + Q + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + GX(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ap(str, j) + "AND " + this.sNO.bdk() + " AND createTime < " + Q + "  order by createTime DESC limit 10";
        }
        Cursor b = bdc().b(str2, null, 0);
        if (b.moveToFirst()) {
            while (!b.isAfterLast()) {
                bd bdVar = new bd();
                bdVar.d(b);
                b.moveToNext();
                if (z) {
                    arrayList.add(bdVar);
                } else {
                    arrayList.add(0, bdVar);
                }
            }
        }
        b.close();
        x.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList;
    }

    public final Cursor ar(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        Cursor b = bdc().b("select * from " + GX(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ap(str, j) + "AND " + this.sNO.bdl() + "  order by createTime", null, 0);
        x.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1});
        return b;
    }

    public final Cursor b(String str, long j, int i, int i2) {
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return bdc().b("select * from ( select * from " + GX(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ap(str, j) + "AND " + this.sNO.bdk() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
    }

    public final Cursor b(String str, long j, long j2, long j3) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return bdc().b("select * from " + GX(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ap(str, j) + "AND " + this.sNO.bdk() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
    }

    public final int as(String str, long j) {
        x.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[]{str, aj.cio()});
        fW(GX(str), ap(str, j));
        int delete = bdc().delete(GX(str), ap(str, j), null);
        if (delete != 0) {
            this.sNO.Xp("delete_talker " + str);
            f.c cVar = new f.c(str, "delete", null, delete, (byte) 0);
            cVar.lcC = -1;
            a(cVar);
        }
        return delete;
    }

    public final int GK(String str) {
        x.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[]{str, aj.cio()});
        String str2 = "talker= '" + str + "'";
        fW(GX(str), str2);
        int delete = bdc().delete(GX(str), str2, null);
        if (delete != 0) {
            this.sNO.Xp("delete_talker " + str);
            f.c cVar = new f.c(str, "delete", null, delete, (byte) 0);
            cVar.lcC = -1;
            a(cVar);
        }
        return delete;
    }

    public final Cursor at(String str, long j) {
        return bdc().query(GX(str), null, ap(str, j), null, null, null, "createTime ASC ");
    }

    public final Cursor i(String str, long j, int i) {
        x.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + ap(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC"});
        return bdc().b("SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + ap(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final int au(String str, long j) {
        if (str == null) {
            x.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[]{str, Long.valueOf(j)});
            return -1;
        }
        a bd = z.Nb().bd(j);
        if (bd.field_msgCount != 0) {
            return bd.field_msgCount;
        }
        x.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[]{str});
        return av(str, j);
    }

    public final int av(String str, long j) {
        int i = 0;
        x.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[]{"SELECT COUNT(*) FROM " + GX(str) + " WHERE " + ap(str, j)});
        Cursor b = bdc().b(r1, null, 0);
        if (b.moveToLast()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final int aw(String str, long j) {
        int i = 0;
        Cursor b = bdc().b("SELECT COUNT(*) FROM " + this.sNO.GX(str) + " WHERE " + ap(str, j) + "AND " + this.sNO.bdk(), null, 0);
        if (b.moveToLast()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final int v(String str, long j, long j2) {
        int i = 0;
        bd dW = this.sNO.dW(j2);
        if (dW.field_msgId == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            Cursor b = bdc().b("SELECT COUNT(*) FROM " + GX(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + ap(str, j) + "AND " + this.sNO.bdk() + " AND createTime < " + dW.field_createTime, null, 0);
            if (b.moveToLast()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final long ax(String str, long j) {
        String str2 = "select createTime from " + GX(str) + " where" + ap(str, j) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + str2);
        Cursor b = bdc().b(str2, null, 0);
        if (b == null) {
            x.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + str);
            return -1;
        } else if (b.moveToFirst()) {
            long j2 = b.getLong(0);
            b.close();
            return j2;
        } else {
            b.close();
            return -1;
        }
    }

    public final int c(String str, long j, long j2, long j3) {
        long j4;
        long j5;
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        x.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[]{str, Long.valueOf(j5), Long.valueOf(j4)});
        String str2 = "SELECT COUNT(msgId) FROM " + GX(str) + " WHERE" + ap(str, j) + "AND createTime >= " + j5 + " AND createTime <= " + j4;
        x.d("MicroMsg.BizChatMessageStorage", "get count sql: " + str2);
        Cursor b = bdc().b(str2, null, 0);
        if (b == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
            return 0;
        } else if (b.moveToFirst()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg count %d", new Object[]{Integer.valueOf(b.getInt(0))});
            b.close();
            return b.getInt(0);
        } else {
            b.close();
            return 0;
        }
    }

    public final Cursor d(String str, long j, long j2, long j3) {
        long j4;
        long j5;
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM " + GX(str) + " WHERE" + ap(str, j) + "AND createTime >= " + j5 + " AND createTime <= " + j4 + " ORDER BY createTime ASC ";
        x.d("MicroMsg.BizChatMessageStorage", "get cursor: " + str2);
        return bdc().b(str2, null, 0);
    }

    public final long w(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[]{str, Long.valueOf(j2), Integer.valueOf(18)});
        x.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", new Object[]{"SELECT createTime FROM " + GX(str) + " WHERE" + ap(str, j) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT 18"});
        Cursor b = bdc().b(r0, null, 0);
        if (b == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
            return j2;
        } else if (b.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[]{Long.valueOf(b.getLong(0))});
            b.close();
            return b.getLong(0);
        } else {
            b.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }

    public final long x(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[]{str, Long.valueOf(j2), Integer.valueOf(18)});
        x.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", new Object[]{"SELECT createTime FROM " + GX(str) + " WHERE" + ap(str, j) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT 18"});
        Cursor b = bdc().b(r0, null, 0);
        if (b == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
            return j2;
        } else if (b.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[]{Long.valueOf(b.getLong(0))});
            b.close();
            return b.getLong(0);
        } else {
            b.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }
}
