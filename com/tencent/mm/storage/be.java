package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.d;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class be extends j implements f {
    public static final String[] diD;
    private final h dCZ;
    private ay gYD;
    private az gYF;
    private final k<a, c> sNT = new k<a, c>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            ((a) obj).a(be.this, (c) obj2);
        }

        public final void cY(List<c> list) {
            if (!isLocked() && be.this.gYF != null) {
                for (c cVar : list) {
                    if (cVar != null) {
                        be.this.gYF.b(be.this, cVar);
                    }
                }
            }
        }
    };
    private final long taQ = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private boolean tbX = false;
    private final List<e> tbY = new CopyOnWriteArrayList();
    private List<b> tbZ;
    private final com.tencent.mm.a.f<Integer, bd.c> tca = new com.tencent.mm.a.f(100);
    private final com.tencent.mm.a.f<Integer, d> tcb = new com.tencent.mm.a.f(100);
    private final com.tencent.mm.a.f<Integer, bd.a> tcc = new com.tencent.mm.a.f(100);
    private final com.tencent.mm.a.f<Integer, bd.b> tcd = new com.tencent.mm.a.f(100);
    private final com.tencent.mm.a.f<Integer, Object> tce = new com.tencent.mm.a.f(100);
    private final com.tencent.mm.a.f<String, Long> tcf = new com.tencent.mm.a.f(100);
    private al tcg = new al();
    private Map<String, c> tch = new HashMap();
    private boolean tci = false;
    private String tcj = "";
    private long tck = 0;

    public final void a(e eVar) {
        if (!this.tbY.contains(eVar)) {
            x.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", eVar);
            this.tbY.add(eVar);
        }
    }

    public final h bdc() {
        return this.dCZ;
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT) ";
        diD = strArr;
    }

    public final void a(c cVar) {
        if (this.sNT.ci(cVar)) {
            this.sNT.doNotify();
        }
    }

    public final void a(a aVar, Looper looper) {
        this.sNT.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.sNT.remove(aVar);
    }

    public final void lock() {
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    }

    public final void unlock() {
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    }

    public final void Gz(String str) {
        x.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.tci), Integer.valueOf(this.sKC.sKF), Integer.valueOf(this.sNT.sKF), Integer.valueOf(this.tch.size()), this.tcj, Long.valueOf(bi.bH(this.tck)));
        if (bi.oW(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.tci) {
            x.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.tcj, Long.valueOf(bi.bH(this.tck)));
            return;
        }
        this.tcj = str;
        this.tck = bi.VF();
        this.tci = true;
        super.lock();
        this.sNT.lock();
    }

    public final void GA(String str) {
        x.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.tci), Integer.valueOf(this.sKC.sKF), Integer.valueOf(this.sNT.sKF), Integer.valueOf(this.tch.size()), this.tcj, Long.valueOf(bi.bH(this.tck)));
        if (bi.oW(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.tci) {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, bi.cjd());
        } else if (str.equals(this.tcj)) {
            this.tci = false;
            this.tck = 0;
            this.tcj = "";
            for (String str2 : this.tch.keySet()) {
                a((c) this.tch.get(str2));
            }
            this.tch.clear();
            super.unlock();
            this.sNT.unlock();
            doNotify();
        } else {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.tcj, Long.valueOf(bi.bH(this.tck)), str);
        }
    }

    public final void GB(String str) {
        if (this.tci) {
            c cVar = null;
            if (this.tch.containsKey(str)) {
                cVar = (c) this.tch.get(str);
            }
            if (cVar == null) {
                x.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", str, bi.cjd());
            } else if (cVar.lcx != null && cVar.lcx.equals("insert") && cVar.lcz > 0) {
                x.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", str, Integer.valueOf(cVar.lcz));
                cVar.lcz = 0;
            }
        }
    }

    public final void a(h hVar, String str) {
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor b = hVar.b("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = b.getColumnIndex("name");
        while (b.moveToNext()) {
            if (columnIndex >= 0) {
                String string = b.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj9 = 1;
                }
            }
        }
        b.close();
        long dO = hVar.dO(Thread.currentThread().getId());
        if (obj == null) {
            hVar.fV(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            hVar.fV(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            hVar.fV(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            hVar.fV(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            hVar.fV(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            hVar.fV(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            hVar.fV(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            hVar.fV(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            hVar.fV(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        hVar.gp(dO);
    }

    public final void H(String str, long j) {
        b Ze = Ze(str);
        long j2 = Ze.dTS;
        Random random = new Random();
        this.dCZ.fV("message", "BEGIN;");
        cm bdVar = new bd(str);
        for (int i = 0; ((long) i) < j; i++) {
            bdVar.ay(System.currentTimeMillis());
            bdVar.setType(1);
            bdVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bi.cjc());
            bdVar.setMsgId(j2);
            bdVar.setStatus(random.nextInt(4));
            bdVar.eX(random.nextInt(1));
            j2++;
            Ze.dTS++;
            bdVar.ax(System.currentTimeMillis() + ((long) bi.cjc()));
            this.dCZ.fV("message", "INSERT INTO " + GX(bdVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + bdVar.field_msgId + "," + bdVar.field_msgSvrId + "," + bdVar.getType() + "," + bdVar.field_status + "," + bdVar.field_createTime + ",'" + bdVar.field_talker + "','" + bdVar.field_content + "'," + Za(str) + ");");
            if (i % 10000 == 0) {
                this.dCZ.fV("message", "COMMIT;");
                this.dCZ.fV("message", "BEGIN;");
            }
        }
        this.dCZ.fV("message", "COMMIT;");
        this.gYF.Yr(str);
        bdVar.setMsgId(1 + j2);
        T(bdVar);
    }

    private void cmQ() {
        long currentTimeMillis = System.currentTimeMillis();
        long dO = this.dCZ.dO(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        String str = "message";
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId,type,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId,status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId,isSend,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId,msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId,type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker,type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker,msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker,flag,msgSeq )"};
        if (!this.tbX) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                this.dCZ.fV("message", (String) arrayList.get(i2));
                i = i2 + 1;
            } else {
                x.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                this.dCZ.gp(dO);
                x.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
        }
    }

    public final void bdd() {
        g.Ek();
        g.Ei().DT().set(348167, Integer.valueOf(1));
    }

    public be(h hVar, ay ayVar, az azVar) {
        this.dCZ = hVar;
        this.gYD = ayVar;
        this.gYF = azVar;
        g.Ek();
        if (((Integer) g.Ei().DT().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.dCZ.delete("message", "msgId> ? ", new String[]{"80000000"});
            x.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            g.Ek();
            g.Ei().DT().set(348169, Integer.valueOf(1));
        }
        a(hVar, "message");
        cmQ();
        if (this.tbZ == null) {
            this.tbZ = new LinkedList();
        }
        this.tbZ.clear();
        a(new b(1, "message", b.a(1, 1000000, 10000000, 90000000)));
    }

    public final void a(b bVar) {
        synchronized (this.tbZ) {
            this.tbZ.add(bVar);
        }
        b(bVar);
    }

    public final void bde() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.tbZ.size()) {
                b((b) this.tbZ.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(b bVar) {
        Cursor b = this.dCZ.b("select max(msgid) from " + bVar.name, null, 2);
        if (b.moveToFirst()) {
            int i = b.getInt(0);
            x.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(bVar.dTS));
            if (((long) i) >= bVar.dTS) {
                x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(bVar.dTS), Integer.valueOf(i), Long.valueOf(bVar.lct[0].lcw), Long.valueOf(bVar.lct[1].lcv), bi.cjd());
                if (((long) i) <= bVar.lct[0].lcw || ((long) i) >= bVar.lct[1].lcv) {
                    bVar.dTS = (long) i;
                } else {
                    x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(bVar.lct[1].lcv));
                    bVar.dTS = bVar.lct[1].lcv;
                    com.tencent.mm.plugin.report.f.mDy.a(111, 169, 1, false);
                }
            }
        }
        b.close();
        x.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.dTS);
    }

    public final void bdf() {
        if (this.tbX) {
            String str = "message";
            Cursor b = this.dCZ.b("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (b != null) {
                int i = b.moveToFirst() ? b.getInt(0) : 0;
                b.close();
                if (i > 0) {
                    x.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.dCZ.fV(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.dCZ.fV(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)") && this.tbX) {
                        this.dCZ.fV("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.dCZ.fV("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.dCZ.fV("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.dCZ.fV("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.dCZ.fV("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        x.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
        }
    }

    public final bd dW(long j) {
        bd bdVar = new bd();
        Cursor a = this.dCZ.a(go(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bdVar.d(a);
        }
        a.close();
        return bdVar;
    }

    public final bd I(String str, long j) {
        bd bdVar = new bd();
        Cursor a = this.dCZ.a(GX(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bdVar.d(a);
        }
        a.close();
        return bdVar;
    }

    public final bd J(String str, long j) {
        bd bdVar = new bd();
        Cursor a = this.dCZ.a(GX(str), null, YZ(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bdVar.d(a);
        }
        a.close();
        return bdVar;
    }

    public final bd K(String str, long j) {
        bd bdVar = new bd();
        Cursor a = this.dCZ.a(GX(str), null, "createTime=? AND" + YZ(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bdVar.d(a);
        }
        a.close();
        return bdVar;
    }

    public final Cursor GC(String str) {
        return this.dCZ.query(GX(str), new String[]{"createTime", "msgId"}, YZ(str), null, "createTime", null, "createTime ASC");
    }

    public final List<bd> L(String str, long j) {
        List<bd> arrayList = new ArrayList();
        String str2 = "Select * From " + GX(str) + " Where " + YZ(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
        Cursor b = this.dCZ.b(str2, new String[]{String.valueOf(j)}, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            arrayList.add(bdVar);
        }
        b.close();
        return arrayList;
    }

    public final List<bd> M(String str, long j) {
        List<bd> arrayList = new ArrayList();
        String str2 = "Select * From " + GX(str) + " Where " + YZ(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
        Cursor b = this.dCZ.b(str2, new String[]{String.valueOf(j)}, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            arrayList.add(bdVar);
        }
        b.close();
        return arrayList;
    }

    public final bd N(String str, long j) {
        bd bdVar = new bd();
        String str2 = "Select * From " + GX(str) + " Where " + YZ(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
        Cursor b = this.dCZ.b(str2, new String[]{String.valueOf(j)}, 2);
        if (b.moveToFirst()) {
            bdVar.d(b);
        }
        b.close();
        return bdVar;
    }

    public final bd O(String str, long j) {
        bd bdVar = new bd();
        String str2 = "Select * From " + GX(str) + " Where " + YZ(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
        Cursor b = this.dCZ.b(str2, new String[]{String.valueOf(j)}, 2);
        if (b.moveToFirst()) {
            bdVar.d(b);
        }
        b.close();
        return bdVar;
    }

    private String YZ(String str) {
        String GX = GX(str);
        if (this.tbX && GX.equals("message")) {
            return " talkerId=" + Za(str) + " ";
        }
        return " talker= '" + bi.oU(str) + "' ";
    }

    private long Za(String str) {
        long Yh = this.gYD.Yh(str);
        if (Yh < 0) {
            ab abVar = new ab(str);
            abVar.setType(2);
            this.gYD.T(abVar);
            Yh = this.gYD.Yh(str);
        }
        if (!com.tencent.mm.sdk.a.b.chr()) {
            x.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(Yh), Boolean.valueOf(r2), bi.cjd());
        }
        return Yh;
    }

    public final ArrayList<bd> bdg() {
        ArrayList<bd> arrayList = new ArrayList();
        Cursor a = this.dCZ.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            cm bdVar = new bd();
            bdVar.d(a);
            if (!(((!bdVar.cmx() ? 1 : 0) & 1) == 0 || ab.XO(bdVar.field_talker) || ab.XQ(bdVar.field_talker) || ab.gY(bdVar.field_talker))) {
                arrayList.add(bdVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final void E(ArrayList<Long> arrayList) {
        long dO = this.dCZ.dO(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                bd dW = dW(longValue);
                dW.eC(dW.cqa | 32);
                x.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, dW);
            }
        } finally {
            this.dCZ.gp(dO);
        }
    }

    public final boolean P(String str, long j) {
        return K(str, j).field_msgId > 0;
    }

    public final int c(String str, long j, int i) {
        String str2 = "SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor b = this.dCZ.b(str2, null, 0);
        int count = b.getCount();
        b.close();
        x.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        return count;
    }

    public final bd GD(String str) {
        bd bdVar = new bd();
        Cursor a = this.dCZ.a(GX(str), null, YZ(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            bdVar.d(a);
        }
        a.close();
        return bdVar;
    }

    public final bd GE(String str) {
        if (bi.oW(str)) {
            return null;
        }
        bd bdVar = new bd();
        Cursor b = this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + "order by createTime DESC limit 1", null, 2);
        if (b.moveToFirst()) {
            bdVar.d(b);
        }
        b.close();
        return bdVar;
    }

    public final bd dG(String str, String str2) {
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            return null;
        }
        cm bdVar = new bd();
        Cursor b = this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (b.moveToFirst()) {
            bdVar.d(b);
        }
        b.close();
        x.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(bdVar.field_msgId));
        return bdVar;
    }

    public final bd GF(String str) {
        if (bi.oW(str)) {
            return null;
        }
        bd bdVar = new bd();
        Cursor b = this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + "and isSend = 0  order by createTime DESC limit 1", null, 2);
        if (b.moveToFirst()) {
            bdVar.d(b);
        }
        b.close();
        return bdVar;
    }

    public final List<bd> by(String str, int i) {
        List<bd> arrayList = new ArrayList();
        Assert.assertTrue(this.tbZ != null);
        Cursor b = this.dCZ.b("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            arrayList.add(bdVar);
        }
        b.close();
        return arrayList;
    }

    public final bd sx(int i) {
        if (this.tbZ == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        bd bdVar = new bd();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.tbZ.size()) {
                return bdVar;
            }
            if ((((b) this.tbZ.get(i3)).lcu & i) != 0) {
                Cursor b = this.dCZ.b("select * from " + ((b) this.tbZ.get(i3)).name + "  order by createTime DESC limit 1", null, 2);
                if (b.moveToFirst()) {
                    long j2 = b.getLong(b.getColumnIndex("createTime"));
                    if (j < j2) {
                        bdVar.d(b);
                        j = j2;
                    }
                }
                b.close();
            }
            i2 = i3 + 1;
        }
    }

    public final bd GG(String str) {
        if (this.tbZ == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        String str2;
        bd bdVar = new bd();
        long j = 0;
        if (bi.oW(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tbZ.size()) {
                return bdVar;
            }
            if ((((b) this.tbZ.get(i2)).lcu & 8) != 0) {
                Cursor b = this.dCZ.b("select * from " + ((b) this.tbZ.get(i2)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                if (b.moveToFirst()) {
                    long j2 = b.getLong(b.getColumnIndex("createTime"));
                    if (j < j2) {
                        bdVar.d(b);
                        j = j2;
                    }
                }
                b.close();
            }
            i = i2 + 1;
        }
    }

    public final List<bd> bdh() {
        List<bd> arrayList = new ArrayList();
        Assert.assertTrue(this.tbZ != null);
        List<bd> arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tbZ.size()) {
                break;
            }
            Cursor a = this.dCZ.a(((b) this.tbZ.get(i2)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                cm bdVar = new bd();
                bdVar.d(a);
                if (bdVar.isText() || bdVar.cmi() || bdVar.aQo() || bdVar.cms()) {
                    if (bd.Ik() - bdVar.field_createTime > 600000) {
                        arrayList2.add(bdVar);
                    } else {
                        arrayList.add(bdVar);
                    }
                }
            }
            a.close();
            i = i2 + 1;
        }
        if (arrayList2.size() > 0) {
            long dO = this.dCZ.dO(-1);
            for (bd bdVar2 : arrayList2) {
                x.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(bdVar2.field_msgId), Long.valueOf(bdVar2.field_createTime), bdVar2.field_talker, bi.Xf(bdVar2.field_content));
                bdVar2.setStatus(5);
                a(bdVar2.field_msgId, bdVar2);
            }
            this.dCZ.gp(dO);
        }
        return arrayList;
    }

    public final List<bd> bz(String str, int i) {
        List<bd> arrayList = new ArrayList();
        Assert.assertTrue(this.tbZ != null);
        Cursor b = this.dCZ.b("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            if (bdVar.isText()) {
                arrayList.add(bdVar);
            }
        }
        b.close();
        return arrayList;
    }

    public final List<bd> X(String str, int i, int i2) {
        List<bd> arrayList = new ArrayList();
        x.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + GX(str) + " WHERE type = 49 ORDER BY createTime DESC LIMIT " + i + " , " + i2);
        Cursor b = this.dCZ.b(r1, null, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            if (bdVar.aQm()) {
                arrayList.add(bdVar);
            }
        }
        b.close();
        return arrayList;
    }

    public final int S(bd bdVar) {
        int i = 0;
        if (!(bdVar == null || bi.oW(bdVar.field_talker))) {
            Cursor b = this.dCZ.b("SELECT count(msgId) FROM " + GX(bdVar.field_talker) + " WHERE" + YZ(bdVar.field_talker) + "AND isSend = 0 AND msgId >= " + bdVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    private static String Zb(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            Map z = bl.z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                return null;
            }
            return (String) z.get(".msgsource.bizmsg.msgcluster");
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorage", "exception:%s", bi.i(e));
            x.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            return null;
        }
    }

    private static void am(bd bdVar) {
        if (bdVar != null && bdVar.aQm()) {
            try {
                String str = bdVar.field_content;
                int indexOf = str.indexOf("<msg>");
                if (indexOf > 0 && indexOf < str.length()) {
                    str = str.substring(indexOf).trim();
                }
                Map z = bl.z(str, "msg");
                if (z != null && z.size() > 0) {
                    bdVar.er(ay.au(z));
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgInfoStorage", e.getMessage());
            }
        }
    }

    public final long T(bd bdVar) {
        return b(bdVar, false);
    }

    public final long b(bd bdVar, boolean z) {
        String str;
        if (bdVar == null || bi.oW(bdVar.field_talker)) {
            com.tencent.mm.plugin.report.f.mDy.a(111, 250, 1, false);
            str = "MicroMsg.MsgInfoStorage";
            String str2 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = bdVar;
            objArr[1] = bdVar == null ? "-1" : bdVar.field_talker;
            x.e(str, str2, objArr);
            return -1;
        }
        x.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.tci), Long.valueOf(bdVar.field_msgSeq));
        String str3 = null;
        bd.b iF = bd.iF(bdVar.cqb);
        if (iF != null) {
            str3 = iF.dCl;
        }
        if (s.hK(str3)) {
            x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str3);
            if (bdVar.getType() == 436207665) {
                x.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                return -1;
            }
            bdVar.ep("notifymessage");
        }
        b Ze = Ze(bdVar.field_talker);
        if (Ze == null) {
            com.tencent.mm.plugin.report.f.mDy.a(111, 249, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", bdVar.field_talker);
            return -1;
        }
        Ze.bdn();
        bdVar.setMsgId(Ze.dTS);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(bdVar.field_msgId), Ze, go(bdVar.field_msgId)}), Ze.name.equals(go(bdVar.field_msgId)));
        if (bdVar.field_msgSvrId != 0) {
            bdVar.cGF = 1;
            bdVar.cpN = true;
        }
        for (e a : this.tbY) {
            if (!a.a(bdVar, iF)) {
                x.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", bdVar.field_talker, bdVar.cqb);
                return -1;
            }
        }
        am(bdVar);
        if (Ze.name.equals("message")) {
            bdVar.field_talkerId = (int) Za(bdVar.field_talker);
            bdVar.cpO = true;
        }
        x.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.dCZ.a(Ze.name, "msgId", bdVar.wH(), z)), bdVar.field_talker, Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.getType()), Integer.valueOf(bdVar.field_status), Long.valueOf(bdVar.field_msgSvrId), Long.valueOf(bdVar.field_msgSeq), Integer.valueOf(bdVar.field_flag), Long.valueOf(bdVar.field_createTime), Integer.valueOf(bdVar.field_isSend), this.tcj, Long.valueOf(bi.bH(this.tck)));
        if (this.dCZ.a(Ze.name, "msgId", bdVar.wH(), z) == -1) {
            com.tencent.mm.plugin.report.f.mDy.a(111, 248, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(bdVar.field_msgSvrId), Long.valueOf(r10));
            return -1;
        }
        if (this.tci && bi.bH(this.tck) > 2000 && bdVar.field_isSend == 1 && bdVar.field_status == 1) {
            x.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.tcj, Long.valueOf(bi.bH(this.tck)));
            GA(this.tcj);
        }
        c cVar;
        if (this.tci) {
            Object obj;
            str3 = null;
            if (e.sNP != null) {
                str3 = e.sNP.I(bdVar);
            }
            if (bi.oW(str3)) {
                obj = bdVar.field_talker;
            } else {
                str = str3;
            }
            cVar = null;
            if (this.tch.containsKey(obj)) {
                cVar = (c) this.tch.get(obj);
            }
            if (cVar == null) {
                cVar = new c(bdVar.field_talker, "insert", bdVar);
            } else {
                cVar.lcy.add(bdVar);
            }
            if (c.W(bdVar)) {
                cVar.lcz++;
            }
            cVar.lcA++;
            this.tch.put(obj, cVar);
        } else {
            cVar = new c(bdVar.field_talker, "insert", bdVar);
            if (c.W(bdVar)) {
                cVar.lcz = 1;
            }
            cVar.lcA = 1;
            doNotify();
            a(cVar);
        }
        return bdVar.field_msgId;
    }

    public final int dX(long j) {
        cm dW = dW(j);
        String str = dW.field_talker;
        this.tcg.j((int) (bi.VE() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), dW.field_msgSvrId, dW.field_createTime / 1000);
        int delete = this.dCZ.delete(go(j), "msgId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            Xp("delete_id " + j);
            c cVar = new c(str, "delete", dW, 1, (byte) 0);
            cVar.lcC = j;
            cVar.hpD = dW.field_bizChatId;
            a(cVar);
        } else {
            com.tencent.mm.plugin.report.f.mDy.a(111, 245, 1, false);
        }
        return delete;
    }

    public final List<bd> GH(String str) {
        List<bd> list = null;
        Cursor b = this.dCZ.b("select * from " + str, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    bd bdVar = new bd();
                    bdVar.d(b);
                    list.add(bdVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final long Q(String str, long j) {
        String str2 = "select createTime from " + GX(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor b = this.dCZ.b(str2, null, 2);
        if (b.moveToFirst()) {
            j2 = b.getLong(0);
        }
        b.close();
        return j2;
    }

    public final List<bd> d(String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
            return null;
        }
        long Q = Q(str, j);
        if (Q == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<bd> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + GX(str) + " where" + YZ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime > " + Q + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + GX(str) + " where" + YZ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + Q + "  order by createTime DESC limit 10";
        }
        Cursor b = this.dCZ.b(str2, null, 2);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            arrayList.add(bdVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        b.close();
        return arrayList;
    }

    public final Cursor Y(String str, int i, int i2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.dCZ.b("select * from ( select * from " + GX(str) + " where" + YZ(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
    }

    public final Cursor n(String str, long j, long j2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
    }

    public final Cursor GI(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String GX = GX(str);
        Cursor b = this.dCZ.b("select * from " + GX + " " + Zc(GX) + " where" + YZ(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime", null, 0);
        x.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), GX);
        return b;
    }

    public final Cursor bA(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + " AND type = 49  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
    }

    public final Cursor bB(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend from ").append(GX(str)).append(" where").append(YZ(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 587202609");
        stringBuilder.append(" or type = 553648177) ");
        return this.dCZ.b(append.append(stringBuilder.toString()).append("  order by createTime DESC limit 100 OFFSET ").append(i).toString(), null, 0);
    }

    public final void b(String str, String str2, String[] strArr) {
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((bi.VE() - 172800) * 1000);
        if (!bi.oW(str2)) {
            str3 = str3 + " AND " + str2;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Cursor b = this.dCZ.b(str3, strArr, 2);
        if (b.moveToFirst()) {
            do {
                long j = b.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(b.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (b.moveToNext());
            this.tcg.h(arrayList, arrayList2);
        }
        b.close();
    }

    public final boolean dY(long j) {
        return this.tcg.gm(j);
    }

    public final void GJ(String str) {
        b(str, "", null);
        if (this.dCZ.fV(str, "delete from " + str)) {
            Xp("delete_all " + str);
        } else {
            com.tencent.mm.plugin.report.f.mDy.a(111, 247, 1, false);
        }
    }

    public final int R(String str, long j) {
        cm I = I(str, j);
        this.tcg.j((int) (bi.VE() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), I.field_msgSvrId, I.field_createTime / 1000);
        int delete = this.dCZ.delete(GX(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            a(new c(str, "delete", null, 1, (byte) 0));
        } else {
            com.tencent.mm.plugin.report.f.mDy.a(111, 246, 1, false);
        }
        return delete;
    }

    public final int GK(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, aj.cio());
        b(GX(str), YZ(str), null);
        int delete = this.dCZ.delete(GX(str), YZ(str), null);
        if (delete != 0) {
            Xp("delete_talker " + str);
            c cVar = new c(str, "delete", null, delete, (byte) 0);
            cVar.lcC = -1;
            a(cVar);
        }
        return delete;
    }

    public final int S(String str, long j) {
        String str2 = YZ(str) + " and createTime <= " + j;
        b(GX(str), str2, null);
        int delete = this.dCZ.delete(GX(str), str2, null);
        if (delete != 0) {
            Xp("delete_talker " + str);
            c cVar = new c(str, "delete", null, delete, (byte) 0);
            cVar.lcC = -1;
            a(cVar);
        }
        return delete;
    }

    public final int bC(String str, int i) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), aj.cio());
        Assert.assertTrue(str.equals(I(str, (long) i).field_talker));
        b(GX(str), "createTime<=? AND" + YZ(str), new String[]{r0.field_createTime});
        int delete = this.dCZ.delete(GX(str), "createTime<=? AND" + YZ(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            a(new c(str, "delete", null, delete, (byte) 0));
        }
        return delete;
    }

    public final boolean GL(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, aj.cio());
        b(GX(str), " talker like '%" + str + "'", null);
        boolean fV = this.dCZ.fV(GX(str), "delete from " + GX(str) + " where talker like '%" + str + "'");
        if (fV) {
            doNotify();
        }
        return fV;
    }

    public final Cursor bD(String str, int i) {
        Assert.assertTrue(str.equals(I(str, (long) i).field_talker));
        return this.dCZ.query(GX(str), null, "createTime<=? AND" + YZ(str), new String[]{r5.field_createTime}, null, null, null);
    }

    public final void a(long j, bd bdVar) {
        if (bdVar.cmg()) {
            if (s.hK(Zb(bdVar.cqb))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Zb(bdVar.cqb));
                bdVar.ep("notifymessage");
            }
        }
        am(bdVar);
        if (this.dCZ.update(go(j), bdVar.wH(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c(bdVar.field_talker, "update", bdVar));
            return;
        }
        com.tencent.mm.plugin.report.f.mDy.a(111, 244, 1, false);
    }

    public final void U(bd bdVar) {
        if (bdVar != null && bdVar.field_status != 4) {
            bdVar.setStatus(4);
            String go = go(bdVar.field_msgId);
            if (go != null && go.length() > 0) {
                if (this.dCZ.update(go, bdVar.wH(), "msgId=?", new String[]{bdVar.field_msgId}) != 0) {
                    doNotify();
                    a(new c(bdVar.field_talker, "update", bdVar, -1));
                }
            }
        }
    }

    public final void b(long j, bd bdVar) {
        Assert.assertTrue("no talker set when update by svrid", bi.oV(bdVar.field_talker).length() > 0);
        if (bdVar.cmg()) {
            if (s.hK(Zb(bdVar.cqb))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Zb(bdVar.cqb));
                bdVar.ep("notifymessage");
            }
        }
        am(bdVar);
        if (this.dCZ.update(GX(bdVar.field_talker), bdVar.wH(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c(bdVar.field_talker, "update", bdVar));
            return;
        }
        com.tencent.mm.plugin.report.f.mDy.a(111, 243, 1, false);
    }

    public final int GM(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        int update = this.dCZ.update(GX(str), contentValues, YZ(str) + "AND isSend=? AND status!=? ", new String[]{"0", "4"});
        if (update != 0) {
            doNotify();
            a(new c(str, "update", null));
        }
        return update;
    }

    public final int V(bd bdVar) {
        int i = 0;
        if (bdVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", bdVar.field_content);
            contentValues.put("status", Integer.valueOf(bdVar.field_status));
            i = this.dCZ.update(go(bdVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(bdVar.field_msgId)});
            if (i != 0) {
                doNotify();
                a(new c(bdVar.field_talker, "update", bdVar));
            }
        }
        return i;
    }

    public final Cursor GN(String str) {
        return this.dCZ.query(GX(str), null, YZ(str), null, null, null, "createTime ASC ");
    }

    public final Cursor f(String str, int i, long j) {
        return this.dCZ.b("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
    }

    public final Cursor dH(String str, String str2) {
        return this.dCZ.b(("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
    }

    public final Cursor g(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return this.dCZ.b("SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final Cursor h(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime <= " + j);
        return this.dCZ.b("SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime <= " + j, null, 0);
    }

    public final Cursor GO(String str) {
        return this.dCZ.query(GX(str), null, "isSend=? AND" + YZ(str) + "AND status!=?", new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bE(String str, int i) {
        return this.dCZ.query(GX(str), null, "isSend=? AND" + YZ(str) + "AND status!=?  order by msgId DESC limit " + i, new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bdi() {
        return this.dCZ.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{"0", "4"}, "talker", null, null);
    }

    public final bd.c GP(String str) {
        bd.c cVar = (bd.c) this.tca.get(Integer.valueOf(str.hashCode()));
        if (cVar != null) {
            return cVar;
        }
        cVar = bd.c.YX(str);
        this.tca.m(Integer.valueOf(str.hashCode()), cVar);
        return cVar;
    }

    public final d GQ(String str) {
        d dVar = (d) this.tcb.get(Integer.valueOf(str.hashCode()));
        if (dVar != null) {
            return dVar;
        }
        dVar = d.YY(str);
        this.tcb.m(Integer.valueOf(str.hashCode()), dVar);
        return dVar;
    }

    public final bd.a GR(String str) {
        bd.a aVar = null;
        if (bi.oW(str) || this.tcc == null) {
            x.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(bi.oW(str)));
            x.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (bd.a) this.tcc.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = bd.a.YV(str);
            if (this.tcc != null) {
                this.tcc.m(Integer.valueOf(bi.aG(str, "").hashCode()), aVar);
            }
        }
        return aVar;
    }

    public final bd.b GS(String str) {
        bd.b bVar = (bd.b) this.tcd.get(Integer.valueOf(str.hashCode()));
        if (bVar != null) {
            return bVar;
        }
        bVar = bd.b.YW(str);
        this.tcd.m(Integer.valueOf(str.hashCode()), bVar);
        return bVar;
    }

    public final Cursor bdj() {
        boolean z;
        if (this.tbZ.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        return this.dCZ.query(((b) this.tbZ.get(0)).name, null, "msgId=?", new String[]{"-1"}, null, null, null);
    }

    public final int GT(String str) {
        int i = 0;
        if (GU(str)) {
            int YI = this.gYF.YI(str);
            if (YI > 0) {
                x.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(YI));
                return YI;
            }
            x.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            if ("appbrandmessage".equals(GX(str))) {
                Cursor b = this.dCZ.b("SELECT COUNT(*) FROM " + GX(str) + " WHERE" + YZ(str), null, 0);
                if (b.moveToLast()) {
                    i = b.getInt(0);
                }
                b.close();
                return i;
            }
        }
        return GV(str);
    }

    public final boolean GU(String str) {
        return "message".equals(GX(str));
    }

    public final int GV(String str) {
        int i;
        Cursor b = this.dCZ.b("SELECT COUNT(*) FROM " + GX(str) + " " + (this.tbX ? "INDEXED BY messageTalkerIdStatusIndex" : "INDEXED BY messageTalkerStatusIndex") + " WHERE" + YZ(str), null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        } else {
            i = 0;
        }
        b.close();
        return i;
    }

    private String Zc(String str) {
        if (str == null || !str.equals("message")) {
            return "";
        }
        if (this.tbX) {
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        }
        return "INDEXED BY messageCreateTaklerTypeTimeIndex";
    }

    public final int bF(String str, int i) {
        int i2 = 0;
        Cursor b = this.dCZ.b("SELECT COUNT(*) FROM " + GX(str) + " WHERE" + YZ(str) + "AND type = " + i, null, 2);
        if (b.moveToFirst()) {
            i2 = b.getInt(0);
        }
        b.close();
        return i2;
    }

    public final int o(String str, long j, long j2) {
        int i = 0;
        Cursor b = this.dCZ.b("SELECT COUNT(*) FROM " + GX(str) + " WHERE" + YZ(str) + "AND type = 50 AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final int GW(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = Ze(str).name;
        Cursor b = this.dCZ.b(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(bi.oU(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final int T(String str, long j) {
        int i = 0;
        cm dW = dW(j);
        if (dW.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String GX = GX(str);
            Cursor b = this.dCZ.b("SELECT COUNT(*) FROM " + GX + " " + Zc(GX) + " WHERE " + YZ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + dW.field_createTime, null, 2);
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final String U(String str, long j) {
        String str2 = null;
        int i = 0;
        cm dW = dW(j);
        if (dW.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String GX = GX(str);
            Cursor b = this.dCZ.b("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + GX + " " + Zc(GX) + " WHERE" + YZ(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + dW.field_createTime, null, 0);
            str2 = "";
            if (b.moveToFirst()) {
                while (i < b.getColumnCount()) {
                    str2 = str2 + b.getString(i) + " ";
                    i++;
                }
            }
            b.close();
        }
        return str2;
    }

    public final String bdk() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String bdl() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    public final String GX(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return Ze(str).name;
    }

    private b Zd(String str) {
        String str2 = "tableName == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        for (int i = 0; i < this.tbZ.size(); i++) {
            if (str.equals(((b) this.tbZ.get(i)).name)) {
                return (b) this.tbZ.get(i);
            }
        }
        Assert.assertTrue("no table match", false);
        return null;
    }

    private b Ze(String str) {
        boolean z;
        String XG;
        boolean z2 = true;
        String str2 = "username == null";
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(str2, z);
        if (str == null || str.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        for (e XG2 : this.tbY) {
            XG = XG2.XG(str);
            if (!bi.oW(XG)) {
                break;
            }
        }
        XG = "message";
        return Zd(XG);
    }

    public final boolean dZ(long j) {
        for (int i = 0; i < this.tbZ.size(); i++) {
            if (((b) this.tbZ.get(i)).eb(j)) {
                return true;
            }
        }
        return false;
    }

    private String go(long j) {
        if (j == 0 || j == -1) {
            return null;
        }
        bd.gn(j);
        for (int i = 0; i < this.tbZ.size(); i++) {
            if (((b) this.tbZ.get(i)).eb(j)) {
                return ((b) this.tbZ.get(i)).name;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        return null;
    }

    public final long GY(String str) {
        String str2 = "select createTime from message where" + YZ(str) + "order by createTime LIMIT 1 OFFSET 0";
        x.d("MicroMsg.MsgInfoStorage", "get first message create time: " + str2);
        Cursor b = this.dCZ.b(str2, null, 2);
        if (b == null) {
            x.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + str);
            return -1;
        } else if (b.moveToFirst()) {
            long j = b.getLong(0);
            b.close();
            return j;
        } else {
            b.close();
            return -1;
        }
    }

    public final long GZ(String str) {
        String str2 = "select createTime from message where" + YZ(str) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.MsgInfoStorage", "get last message create time: " + str2);
        Cursor b = this.dCZ.b(str2, null, 2);
        if (b == null) {
            x.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + str);
            return -1;
        } else if (b.moveToFirst()) {
            long j = b.getLong(0);
            b.close();
            return j;
        } else {
            b.close();
            return -1;
        }
    }

    public final long Ha(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        String str2 = "select msgSeq from message where" + YZ(str) + "order by msgSeq DESC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + str2);
        Cursor b = this.dCZ.b(str2, null, 2);
        if (b == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + str);
            return 0;
        } else if (b.moveToFirst()) {
            long j = b.getLong(0);
            b.close();
            return j;
        } else {
            b.close();
            return 0;
        }
    }

    public final bd V(String str, long j) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = "select * from message where" + YZ(str) + " and msgSeq > " + j + " order by msgSeq ASC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq: " + str2);
        Cursor b = this.dCZ.b(str2, null, 0);
        if (b == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (b.moveToFirst()) {
            bd bdVar = new bd();
            bdVar.d(b);
            b.close();
            return bdVar;
        } else {
            b.close();
            return null;
        }
    }

    public final bd W(String str, long j) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = "select * from message where" + YZ(str) + " and msgSeq < " + j + " order by msgSeq DESC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: " + str2);
        Cursor b = this.dCZ.b(str2, null, 0);
        if (b == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (b.moveToFirst()) {
            bd bdVar = new bd();
            bdVar.d(b);
            b.close();
            return bdVar;
        } else {
            b.close();
            return null;
        }
    }

    public final bd Hb(String str) {
        if (bi.oW(str)) {
            return null;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.valueOf(false));
        Long l = (Long) this.tcf.get(str);
        bd bdVar;
        if (l == null || l.longValue() <= 0) {
            x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            bdVar = new bd();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor b = this.dCZ.b("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ", null, 2);
            x.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (b == null) {
                x.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + str);
                return bdVar;
            }
            if (b.moveToFirst()) {
                bdVar.d(b);
            }
            b.close();
            this.tcf.m(str, Long.valueOf(bdVar.field_msgId));
            return bdVar;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        bdVar = dW(l.longValue());
        if ((bdVar.field_flag & 1) != 0) {
            return bdVar;
        }
        this.tcf.remove(str);
        return null;
    }

    public final int p(String str, long j, long j2) {
        long j3;
        long j4;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        x.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j4), Long.valueOf(j3));
        String str2 = "SELECT COUNT(msgId) FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        x.d("MicroMsg.MsgInfoStorage", "get count sql: " + str2);
        Cursor b = this.dCZ.b(str2, null, 2);
        if (b == null) {
            x.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            return 0;
        } else if (b.moveToFirst()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(b.getInt(0)));
            b.close();
            return b.getInt(0);
        } else {
            b.close();
            return 0;
        }
    }

    public final Cursor a(String str, long j, long j2, boolean z) {
        long j3;
        long j4;
        int i;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(GX(str)).append(" WHERE").append(YZ(str)).append("AND createTime >= ").append(j4).append(" AND createTime <= ").append(j3).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + stringBuilder);
        return this.dCZ.b(stringBuilder, null, 0);
    }

    public final Cursor q(String str, long j, long j2) {
        long j3;
        long j4;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3 + " ORDER BY createTime ASC ";
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.dCZ.b(str2, null, 0);
    }

    public final Cursor b(String str, long j, long j2, int i) {
        String str2;
        if (j2 == 0) {
            str2 = "SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
            x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
            return this.dCZ.b(str2, null, 0);
        }
        long j3;
        long j4;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        str2 = "SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime > " + j4 + " AND createTime < " + j3 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.dCZ.b(str2, null, 0);
    }

    public final int r(String str, long j, long j2) {
        long j3;
        long j4;
        int i;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        Cursor b = this.dCZ.b("SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime > " + j4 + " AND createTime < " + j3, null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        } else {
            i = 0;
        }
        b.close();
        return i;
    }

    public final Cursor s(String str, long j, long j2) {
        long j3;
        long j4;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.dCZ.b(str2, null, 0);
    }

    public final Cursor E(String str, String str2, int i) {
        x.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        return this.dCZ.b(" SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final Cursor bG(String str, int i) {
        x.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + i);
        return this.dCZ.b(" SELECT * FROM " + GX(str) + " WHERE" + YZ(str) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final int dI(String str, String str2) {
        int i;
        Cursor b = this.dCZ.b(" SELECT COUNT(*) FROM " + GX(str) + " WHERE" + YZ(str) + "AND content LIKE '" + str2 + "%' ", null, 2);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            } else {
                i = 0;
            }
            b.close();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            b.close();
            i = 0;
        } catch (Throwable e2) {
            b.close();
            throw e2;
        }
        x.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", str, str2, Integer.valueOf(i), r2);
        return i;
    }

    public final int Hc(String str) {
        int i;
        Cursor b = this.dCZ.b(" SELECT COUNT(*) FROM " + GX(str) + " WHERE" + YZ(str) + "AND isSend=1", null, 2);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            } else {
                i = 0;
            }
            b.close();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            b.close();
            i = 0;
        } catch (Throwable e2) {
            b.close();
            throw e2;
        }
        x.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", str, Integer.valueOf(i), r2);
        return i;
    }

    public final long X(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT 18");
        Cursor b = this.dCZ.b(r0, null, 0);
        if (b == null) {
            x.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            return j;
        } else if (b.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(b.getLong(0)));
            b.close();
            return b.getLong(0);
        } else {
            b.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final long Y(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + GX(str) + " WHERE" + YZ(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 18");
        Cursor b = this.dCZ.b(r0, null, 0);
        if (b == null) {
            x.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            return j;
        } else if (b.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(b.getLong(0)));
            b.close();
            return b.getLong(0);
        } else {
            b.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final bd[] bH(String str, int i) {
        if (str == null || str.length() == 0 || i <= 0) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            return null;
        }
        Cursor b = this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + "order by createTime DESC limit " + i, null, 2);
        if (b.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                bd bdVar = new bd();
                bdVar.d(b);
                arrayList.add(bdVar);
            } while (b.moveToNext());
            b.close();
            x.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            return (bd[]) arrayList.toArray(new bd[arrayList.size()]);
        }
        x.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        b.close();
        return null;
    }

    public final LinkedList<bd> dJ(String str, String str2) {
        LinkedList<bd> linkedList = null;
        Cursor a = this.dCZ.a("message", null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            x.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        } else {
            linkedList = new LinkedList();
            do {
                bd bdVar = new bd();
                bdVar.d(a);
                linkedList.add(bdVar);
            } while (a.moveToNext());
            a.close();
        }
        return linkedList;
    }

    public final void ea(long j) {
        this.tcg.a(0, j, 0, false);
    }

    public final List<bd> Hd(String str) {
        Throwable e;
        Cursor cursor = null;
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.dCZ.a("message", null, "talker=? AND createTime>=? AND type IN (436207665,419430449)", new String[]{bi.oU(str), String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    bd bdVar = new bd();
                    bdVar.d(a);
                    arrayList.add(bdVar);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
    }

    public final Cursor Hf(String str) {
        try {
            return this.dCZ.a(GX(str), null, YZ(str) + " AND createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
            return null;
        }
    }

    public final List<bd> bdm() {
        Throwable e;
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.dCZ.a("message", null, "createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    bd bdVar = new bd();
                    bdVar.d(a);
                    arrayList.add(bdVar);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    public final long He(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        b Zd = Zd(str);
        if (Zd != null) {
            return Zd.dTS;
        }
        return 0;
    }

    public final Cursor d(String str, long j, int i) {
        Cursor cursor = null;
        try {
            return this.dCZ.b("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j + "  order by msgId ASC  limit " + i, null, 0);
        } catch (Exception e) {
            return cursor;
        }
    }

    public final Cursor bI(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.dCZ.b("select * from " + GX(str) + " where" + YZ(str) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
    }
}
