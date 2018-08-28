package com.tencent.mm.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class bj extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public h dCZ;

    private static String iI(String str) {
        return "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
    }

    public static String hf(int i) {
        if (i == 20) {
            return "readerappnews1";
        }
        if (i == 11) {
            return "readerappweibo";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public bj(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(bi biVar) {
        if (biVar == null) {
            return false;
        }
        biVar.bWA = -1;
        ContentValues contentValues = new ContentValues();
        if ((biVar.bWA & 1) != 0) {
            contentValues.put("tweetid", biVar.Iv());
        }
        if ((biVar.bWA & 2) != 0) {
            contentValues.put("time", Long.valueOf(biVar.time));
        }
        if ((biVar.bWA & 4) != 0) {
            contentValues.put("type", Integer.valueOf(biVar.type));
        }
        if ((biVar.bWA & 8) != 0) {
            contentValues.put("name", biVar.getName());
        }
        if ((biVar.bWA & 16) != 0) {
            contentValues.put("title", biVar.getTitle());
        }
        if ((biVar.bWA & 32) != 0) {
            contentValues.put("url", biVar.getUrl());
        }
        if ((biVar.bWA & 64) != 0) {
            contentValues.put("shorturl", biVar.Iw());
        }
        if ((biVar.bWA & 128) != 0) {
            contentValues.put("longurl", biVar.dCQ == null ? "" : biVar.dCQ);
        }
        if ((biVar.bWA & 256) != 0) {
            contentValues.put("pubtime", Long.valueOf(biVar.dCR));
        }
        if ((biVar.bWA & 512) != 0) {
            contentValues.put("sourcename", biVar.Ix());
        }
        if ((biVar.bWA & 1024) != 0) {
            contentValues.put("sourceicon", biVar.Iy());
        }
        if ((biVar.bWA & 2048) != 0) {
            contentValues.put("istop", Integer.valueOf(biVar.dCU));
        }
        if ((biVar.bWA & 4096) != 0) {
            contentValues.put("cover", biVar.Iz());
        }
        if ((biVar.bWA & 8192) != 0) {
            contentValues.put("digest", biVar.IA());
        }
        if ((biVar.bWA & 16384) != 0) {
            contentValues.put("reserved1", Integer.valueOf(biVar.dCV));
        }
        if ((biVar.bWA & 32768) != 0) {
            contentValues.put("reserved2", Long.valueOf(biVar.dCW));
        }
        if ((biVar.bWA & 65536) != 0) {
            contentValues.put("reserved3", biVar.IB());
        }
        if ((biVar.bWA & 131072) != 0) {
            contentValues.put("reserved4", biVar.dCY == null ? "" : biVar.dCY);
        }
        if (((int) this.dCZ.insert(hf(biVar.type), "tweetid", contentValues)) != -1) {
            return true;
        }
        return false;
    }

    public final Cursor bb(int i, int i2) {
        return this.dCZ.b("SELECT time from " + hf(i2) + " GROUP BY time ORDER BY time ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + hf(i2) + " GROUP BY time)) -" + i, null, 0);
    }

    public final int hg(int i) {
        int i2 = 0;
        Cursor b = this.dCZ.b("select count(*) from (SELECT count(*) FROM " + hf(i) + " group by time)", null, 2);
        if (b.moveToFirst()) {
            i2 = b.getInt(0);
        }
        b.close();
        return i2;
    }

    public final List<bi> aV(long j) {
        List<bi> arrayList = new ArrayList();
        String str = iI(hf(20)) + " where reserved2 = " + j;
        x.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :" + str);
        Cursor b = this.dCZ.b(str, null, 2);
        while (b.moveToNext()) {
            bi biVar = new bi();
            biVar.d(b);
            arrayList.add(biVar);
        }
        b.close();
        return arrayList;
    }

    public final List<bi> c(long j, int i) {
        List<bi> arrayList = new ArrayList();
        String str = iI(hf(i)) + " where time = " + j + " order by istop desc , tweetid asc ";
        x.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :" + str);
        Cursor b = this.dCZ.b(str, null, 2);
        while (b.moveToNext()) {
            bi biVar = new bi();
            biVar.d(b);
            arrayList.add(biVar);
        }
        b.close();
        return arrayList;
    }

    public final void aW(long j) {
        x.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[]{"delete from " + hf(20) + " where reserved2 = " + j});
        if (this.dCZ.fV(hf(20), "delete from " + hf(20) + " where reserved2 = " + j)) {
            hi(20);
            doNotify();
        }
    }

    public final void b(String str, int i, boolean z, boolean z2) {
        List H = H(str, i);
        if (H != null && H.size() != 0) {
            bi biVar = (bi) H.get(0);
            Iterator it = H.iterator();
            while (true) {
                bi biVar2 = biVar;
                if (!it.hasNext()) {
                    break;
                }
                biVar = (bi) it.next();
                if (biVar.dCU != 1) {
                    biVar = biVar2;
                }
            }
            if (this.dCZ.delete(hf(i), "reserved3=?", new String[]{str}) >= 0 && z) {
                doNotify();
            }
            if (z2) {
                x.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[]{iI(hf(i)) + " where istop = 1  group by time ORDER BY time DESC  limit 2"});
                Cursor b = this.dCZ.b(r0, null, 2);
                if (b.moveToFirst()) {
                    ai Yq = ((i) g.l(i.class)).FW().Yq(bi.he(i));
                    bi biVar3 = new bi();
                    biVar3.d(b);
                    b.close();
                    ai aiVar = new ai();
                    aiVar.setUsername(bi.he(i));
                    aiVar.setContent(biVar3.getTitle());
                    aiVar.as(biVar3.time);
                    aiVar.eX(0);
                    if (Yq.field_unReadCount <= 0 || biVar2 == null || !Yq.field_content.equals(biVar2.getTitle())) {
                        aiVar.eV(0);
                    } else {
                        aiVar.eV(Yq.field_unReadCount - 1);
                    }
                    ((i) g.l(i.class)).FW().a(aiVar, bi.he(i));
                    return;
                }
                b.close();
                ai aiVar2 = new ai();
                aiVar2.setUsername(bi.he(i));
                aiVar2.setContent("");
                aiVar2.as(0);
                aiVar2.eX(0);
                aiVar2.eV(0);
                ((i) g.l(i.class)).FW().a(aiVar2, bi.he(i));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.model.bi> H(java.lang.String r10, int r11) {
        /*
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = r9.dCZ;
        r1 = hf(r11);
        r2 = new java.lang.String[r4];
        r3 = "*";
        r2[r6] = r3;
        r3 = "reserved3=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 == 0) goto L_0x0043;
    L_0x0020:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0049 }
        if (r0 == 0) goto L_0x0043;
    L_0x0026:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0049 }
        r0.<init>();	 Catch:{ Exception -> 0x0049 }
    L_0x002b:
        r2 = new com.tencent.mm.model.bi;	 Catch:{ Exception -> 0x0049 }
        r2.<init>();	 Catch:{ Exception -> 0x0049 }
        r2.d(r1);	 Catch:{ Exception -> 0x0049 }
        r0.add(r2);	 Catch:{ Exception -> 0x0049 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0049 }
        if (r2 != 0) goto L_0x002b;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        r5 = r0;
    L_0x0042:
        return r5;
    L_0x0043:
        if (r1 == 0) goto L_0x0042;
    L_0x0045:
        r1.close();
        goto L_0x0042;
    L_0x0049:
        r0 = move-exception;
        r2 = "MicroMsg.ReaderAppInfoStorage";
        r3 = "getByFunctionMsgId, error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0063 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r4[r6] = r0;	 Catch:{ all -> 0x0063 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0063 }
        if (r1 == 0) goto L_0x0042;
    L_0x005f:
        r1.close();
        goto L_0x0042;
    L_0x0063:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.bj.H(java.lang.String, int):java.util.List<com.tencent.mm.model.bi>");
    }

    public final void hh(int i) {
        ai Yq = ((i) g.l(i.class)).FW().Yq(bi.he(i));
        if (Yq != null && Yq.field_username.equals(bi.he(i))) {
            Yq.setUsername(bi.he(i));
            Yq.setContent("");
            Yq.eX(0);
            Yq.eV(0);
            ((i) g.l(i.class)).FW().a(Yq, bi.he(i));
            if (this.dCZ.fV(hf(i), "delete from " + hf(i))) {
                doNotify();
            }
        }
    }

    public final void hi(int i) {
        x.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[]{iI(hf(i)) + " where istop = 1  group by time ORDER BY time DESC  limit 2"});
        Cursor b = this.dCZ.b(r0, null, 2);
        if (b.moveToFirst()) {
            bi biVar = new bi();
            biVar.d(b);
            b.close();
            ai aiVar = new ai();
            aiVar.setUsername(bi.he(i));
            aiVar.setContent(biVar.getTitle());
            aiVar.as(biVar.time);
            aiVar.eX(0);
            aiVar.eV(0);
            ((i) g.l(i.class)).FW().a(aiVar, bi.he(i));
            return;
        }
        b.close();
        ai aiVar2 = new ai();
        aiVar2.setUsername(bi.he(i));
        aiVar2.setContent("");
        aiVar2.as(0);
        aiVar2.eX(0);
        aiVar2.eV(0);
        ((i) g.l(i.class)).FW().a(aiVar2, bi.he(i));
    }
}
