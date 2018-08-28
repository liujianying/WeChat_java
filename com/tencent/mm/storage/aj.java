package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.az.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aj extends m implements az {
    public static final String[] diD = new String[]{i.a(a.dhO, "rconversation"), i.a(a.dhO, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private final e diF;
    private com.tencent.mm.plugin.messenger.foundation.a.e taA;
    private a taB = new a((byte) 0);
    private k<az.a, ai> taC = new 1(this);
    private k<az.a, ai> taD = new 2(this);
    private b taz;

    public aj(e eVar) {
        byte b;
        Assert.assertTrue(eVar instanceof h);
        Cursor b2 = eVar.b("PRAGMA table_info( rconversation)", null, 2);
        int columnIndex = b2.getColumnIndex("name");
        while (b2.moveToNext()) {
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(b2.getString(columnIndex))) {
                    b = (byte) 1;
                    break;
                }
            }
        }
        b = (byte) 0;
        b2.close();
        List<String> a = i.a(a.dhO, "rconversation", eVar);
        a.addAll(i.a(a.dhO, "rbottleconversation", eVar));
        for (String fV : a) {
            eVar.fV("rconversation", fV);
        }
        if (b == (byte) 0) {
            eVar.fV("rconversation", "update rconversation set flag = conversationTime");
        }
        this.diF = eVar;
    }

    private static String Yo(String str) {
        x.v("MicroMsg.ConversationStorage", "talker :" + str);
        if (ab.gY(str)) {
            return "rbottleconversation";
        }
        return "rconversation";
    }

    public final void a(b bVar) {
        this.taz = bVar;
    }

    public final b vu() {
        return this.taz;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.e eVar) {
        this.taA = eVar;
    }

    public final com.tencent.mm.vending.b.b a(f fVar) {
        return this.taB.aI(fVar);
    }

    public final void a(az.a aVar, Looper looper) {
        this.taD.a(aVar, looper);
    }

    public final void a(az.a aVar) {
        this.taD.remove(aVar);
    }

    public final void b(az.a aVar) {
        this.taC.a(aVar, null);
    }

    public final void c(az.a aVar) {
        this.taC.remove(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.f r18, com.tencent.mm.plugin.messenger.foundation.a.a.f.c r19) {
        /*
        r17 = this;
        if (r19 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "null notifyInfo";
        com.tencent.mm.sdk.platformtools.x.f(r2, r3);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r19;
        r5 = r0.talker;
        r4 = 0;
        r0 = r17;
        r2 = r0.Yq(r5);
        r0 = r18;
        r3 = r0.GE(r5);
        if (r2 != 0) goto L_0x0532;
    L_0x001f:
        r2 = "MicroMsg.ConversationStorage";
        r4 = "create new cvs:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r6);
        r2 = new com.tencent.mm.storage.ai;
        r2.<init>(r5);
        r4 = com.tencent.mm.storage.ab.gY(r5);
        if (r4 == 0) goto L_0x003d;
    L_0x0039:
        r4 = 1;
        r2.eW(r4);
    L_0x003d:
        r4 = 1;
        r8 = r2;
        r9 = r4;
    L_0x0040:
        r0 = r17;
        r2 = r0.taB;
        r0 = r19;
        r2.a(r3, r8, r9, r0);
        r2 = "MicroMsg.ConversationStorage";
        r4 = "dkevent user:%s func:%s cnt:%d ";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r0 = r19;
        r7 = r0.talker;
        r5[r6] = r7;
        r6 = 1;
        r0 = r19;
        r7 = r0.lcx;
        r5[r6] = r7;
        r6 = 2;
        r0 = r19;
        r7 = r0.lcz;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        if (r3 == 0) goto L_0x017a;
    L_0x0070:
        r4 = r3.field_msgId;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x017a;
    L_0x0078:
        r0 = r19;
        r2 = r0.lcz;
        r4 = 1;
        if (r2 != r4) goto L_0x00bb;
    L_0x007f:
        r0 = r19;
        r2 = r0.lcy;
        r4 = 0;
        r2 = r2.get(r4);
        r2 = (com.tencent.mm.storage.bd) r2;
        r4 = r2.field_msgId;
        r6 = r3.field_msgId;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00bb;
    L_0x0092:
        r4 = "MicroMsg.ConversationStorage";
        r5 = "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d";
        r2 = 2;
        r6 = new java.lang.Object[r2];
        r2 = 0;
        r10 = r3.field_msgId;
        r7 = java.lang.Long.valueOf(r10);
        r6[r2] = r7;
        r7 = 1;
        r0 = r19;
        r2 = r0.lcy;
        r10 = 0;
        r2 = r2.get(r10);
        r2 = (com.tencent.mm.storage.bd) r2;
        r10 = r2.field_msgId;
        r2 = java.lang.Long.valueOf(r10);
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);
    L_0x00bb:
        r2 = r3.field_flag;
        r4 = r8.field_lastSeq;
        r6 = r3.field_msgSeq;
        r10 = r8.field_UnDeliverCount;
        r10 = (long) r10;
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]";
        r14 = 4;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = java.lang.Integer.valueOf(r2);
        r14[r15] = r16;
        r15 = 1;
        r16 = java.lang.Long.valueOf(r6);
        r14[r15] = r16;
        r15 = 2;
        r16 = java.lang.Long.valueOf(r4);
        r14[r15] = r16;
        r15 = 3;
        r16 = java.lang.Long.valueOf(r10);
        r14[r15] = r16;
        com.tencent.mm.sdk.platformtools.x.i(r12, r13, r14);
        r0 = r19;
        r12 = r0.lcx;
        r13 = "insert";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x00ff;
    L_0x00f9:
        r0 = r19;
        r12 = r0.lcz;
        if (r12 > 0) goto L_0x0115;
    L_0x00ff:
        r0 = r19;
        r12 = r0.lcx;
        r13 = "update";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x01f3;
    L_0x010c:
        r12 = r8.field_unReadCount;
        r0 = r19;
        r13 = r0.lcz;
        r12 = r12 + r13;
        if (r12 < 0) goto L_0x01f3;
    L_0x0115:
        r12 = r8.field_unReadCount;
        r0 = r19;
        r13 = r0.lcz;
        r12 = r12 + r13;
        r8.eV(r12);
        r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r12 <= 0) goto L_0x0168;
    L_0x0123:
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr insert or update reset lastseq[%d]";
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r16 = java.lang.Long.valueOf(r6);
        r14[r15] = r16;
        com.tencent.mm.sdk.platformtools.x.i(r12, r13, r14);
        r12 = 0;
        r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r12 <= 0) goto L_0x01ee;
    L_0x013c:
        r12 = r2 & 2;
        if (r12 != 0) goto L_0x01ee;
    L_0x0140:
        r12 = "MicroMsg.ConversationStorage";
        r13 = "summerbadcr insert or update reset lastseq but undeliver flag not match[%d, %d, %d, %d]";
        r14 = 4;
        r14 = new java.lang.Object[r14];
        r15 = 0;
        r6 = java.lang.Long.valueOf(r6);
        r14[r15] = r6;
        r6 = 1;
        r4 = java.lang.Long.valueOf(r4);
        r14[r6] = r4;
        r4 = 2;
        r5 = java.lang.Long.valueOf(r10);
        r14[r4] = r5;
        r4 = 3;
        r2 = java.lang.Integer.valueOf(r2);
        r14[r4] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r12, r13, r14);
    L_0x0168:
        r2 = r3.cmk();
        if (r2 == 0) goto L_0x017a;
    L_0x016e:
        r2 = r3.field_isSend;
        r4 = 1;
        if (r2 != r4) goto L_0x017a;
    L_0x0173:
        r4 = r3.field_createTime;
        r8.field_sightTime = r4;
        r2 = 1;
        r8.ctD = r2;
    L_0x017a:
        r0 = r19;
        r2 = r0.lcx;
        r4 = "insert";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0285;
    L_0x0187:
        r0 = r19;
        r2 = r0.lcy;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x0285;
    L_0x0191:
        r0 = r19;
        r2 = r0.talker;
        r2 = com.tencent.mm.model.s.fq(r2);
        if (r2 == 0) goto L_0x0285;
    L_0x019b:
        r5 = com.tencent.mm.model.q.GF();
        r0 = r19;
        r2 = r0.lcy;
        r6 = r2.iterator();
    L_0x01a7:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x0285;
    L_0x01ad:
        r2 = r6.next();
        r2 = (com.tencent.mm.storage.bd) r2;
        r4 = r2.field_isSend;
        r7 = 1;
        if (r4 == r7) goto L_0x01d7;
    L_0x01b8:
        r4 = r2.isText();
        if (r4 != 0) goto L_0x01ca;
    L_0x01be:
        r4 = r2.getType();
        r7 = 503316529; // 0x1e000031 float:6.776303E-21 double:2.48671406E-315;
        if (r4 != r7) goto L_0x0264;
    L_0x01c7:
        r4 = 1;
    L_0x01c8:
        if (r4 == 0) goto L_0x01d7;
    L_0x01ca:
        r4 = r2.YU(r5);
        if (r4 == 0) goto L_0x0267;
    L_0x01d0:
        r4 = r8.field_atCount;
        r4 = r4 + 1;
        r8.fa(r4);
    L_0x01d7:
        r2 = r2.field_content;
        r4 = "sysmsg";
        r2 = com.tencent.mm.c.f.z(r2, r4);
        r4 = com.tencent.mm.storage.bd.av(r2);
        if (r4 == 0) goto L_0x0276;
    L_0x01e6:
        r2 = r8.field_UnReadInvite;
        r2 = r2 + 1;
        r8.fd(r2);
        goto L_0x01a7;
    L_0x01ee:
        r8.au(r6);
        goto L_0x0168;
    L_0x01f3:
        r0 = r19;
        r2 = r0.lcB;
        if (r2 <= 0) goto L_0x0168;
    L_0x01f9:
        r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x01fd:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.bcY();
        r10 = r8.field_username;
        r2 = r2.J(r10, r4);
        r10 = r2.field_msgId;
        r12 = 0;
        r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x0168;
    L_0x0217:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.bcY();
        r10 = r8.field_username;
        r10 = r2.Ha(r10);
        r2 = "MicroMsg.ConversationStorage";
        r12 = "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]";
        r13 = 3;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = java.lang.Long.valueOf(r4);
        r13[r14] = r15;
        r14 = 1;
        r15 = java.lang.Long.valueOf(r6);
        r13[r14] = r15;
        r14 = 2;
        r15 = java.lang.Long.valueOf(r10);
        r13[r14] = r15;
        com.tencent.mm.sdk.platformtools.x.i(r2, r12, r13);
        r8.au(r6);
        r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0168;
    L_0x0251:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.Gx();
        r4 = r8.field_username;
        r2.F(r4, r10);
        goto L_0x0168;
    L_0x0264:
        r4 = 0;
        goto L_0x01c8;
    L_0x0267:
        r4 = r2.cmG();
        if (r4 == 0) goto L_0x01d7;
    L_0x026d:
        r4 = r8.field_atCount;
        r4 = r4 + 4096;
        r8.fa(r4);
        goto L_0x01d7;
    L_0x0276:
        r2 = com.tencent.mm.storage.bd.aw(r2);
        if (r2 == 0) goto L_0x01a7;
    L_0x027c:
        r2 = r8.field_UnReadInvite;
        r2 = r2 + 4096;
        r8.fd(r2);
        goto L_0x01a7;
    L_0x0285:
        r4 = 0;
        r2 = 0;
        r5 = 0;
        if (r19 == 0) goto L_0x052f;
    L_0x028a:
        r0 = r19;
        r5 = r0.talker;
        r12 = r5;
    L_0x028f:
        if (r19 == 0) goto L_0x02c5;
    L_0x0291:
        r0 = r19;
        r5 = r0.lcx;
        if (r5 == 0) goto L_0x02c5;
    L_0x0297:
        r0 = r19;
        r5 = r0.lcx;
        r6 = "delete";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x02c5;
    L_0x02a4:
        r0 = r19;
        r5 = r0.lcB;
        if (r5 <= 0) goto L_0x02ae;
    L_0x02aa:
        r0 = r19;
        r2 = r0.lcB;
    L_0x02ae:
        r5 = "MicroMsg.ConversationStorage";
        r6 = "notify delete count %d ";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r10 = 0;
        r0 = r19;
        r11 = r0.lcB;
        r11 = java.lang.Integer.valueOf(r11);
        r7[r10] = r11;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
    L_0x02c5:
        r11 = r2;
        if (r19 == 0) goto L_0x052c;
    L_0x02c8:
        r0 = r19;
        r2 = r0.lcx;
        if (r2 == 0) goto L_0x052c;
    L_0x02ce:
        r0 = r19;
        r2 = r0.lcx;
        r5 = "insert";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x052c;
    L_0x02db:
        r0 = r19;
        r2 = r0.lcA;
        if (r2 <= 0) goto L_0x0529;
    L_0x02e1:
        r0 = r19;
        r2 = r0.lcA;
    L_0x02e5:
        r4 = "MicroMsg.ConversationStorage";
        r5 = "notify insert all count %d ";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r19;
        r10 = r0.lcA;
        r10 = java.lang.Integer.valueOf(r10);
        r6[r7] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r10 = r2;
    L_0x02fd:
        r2 = "MicroMsg.ConversationStorage";
        r6 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d], ParentRef[%s]";
        r4 = 7;
        r7 = new java.lang.Object[r4];
        r4 = 0;
        r5 = "";
        r5 = com.tencent.mm.sdk.platformtools.bi.aG(r12, r5);
        r7[r4] = r5;
        r13 = 1;
        if (r3 == 0) goto L_0x0363;
    L_0x0313:
        r4 = r3.field_msgSeq;
    L_0x0315:
        r4 = java.lang.Long.valueOf(r4);
        r7[r13] = r4;
        r4 = 2;
        r5 = java.lang.Boolean.valueOf(r9);
        r7[r4] = r5;
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r10);
        r7[r4] = r5;
        r4 = 4;
        r5 = java.lang.Integer.valueOf(r11);
        r7[r4] = r5;
        r4 = 5;
        r5 = java.lang.Thread.currentThread();
        r14 = r5.getId();
        r5 = java.lang.Long.valueOf(r14);
        r7[r4] = r5;
        r4 = 6;
        r5 = r8.field_parentRef;
        r7[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r6, r7);
        if (r9 == 0) goto L_0x0366;
    L_0x0349:
        if (r11 <= 0) goto L_0x0366;
    L_0x034b:
        if (r10 != 0) goto L_0x0366;
    L_0x034d:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "summerdel ignore delete event [%s, %s]";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r12;
        r5 = 1;
        r6 = r8.field_username;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        goto L_0x000b;
    L_0x0363:
        r4 = -1;
        goto L_0x0315;
    L_0x0366:
        r0 = r17;
        r2 = r0.taC;
        r2.ci(r8);
        r0 = r17;
        r2 = r0.taC;
        r2.doNotify();
        if (r12 != 0) goto L_0x0381;
    L_0x0376:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "talker == null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x000b;
    L_0x0381:
        r2 = r8.field_username;
        r2 = r12.equals(r2);
        if (r2 != 0) goto L_0x0394;
    L_0x0389:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "process message for conversation failed: inconsist username";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x000b;
    L_0x0394:
        if (r3 == 0) goto L_0x04ca;
    L_0x0396:
        r4 = r3.field_msgId;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x04ca;
    L_0x039e:
        r2 = "MicroMsg.ConversationStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "onNotifyChange   msgId:";
        r4.<init>(r5);
        r6 = r3.field_msgId;
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.v(r2, r4);
        r8.aj(r3);
        r0 = r17;
        r2 = r0.taz;
        if (r2 == 0) goto L_0x047d;
    L_0x03bf:
        r4 = new com.tencent.mm.pointers.PString;
        r4.<init>();
        r5 = new com.tencent.mm.pointers.PString;
        r5.<init>();
        r6 = new com.tencent.mm.pointers.PInt;
        r6.<init>();
        r0 = r17;
        r2 = r0.taz;
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r7 = r8.gh(r7);
        r2.a(r3, r4, r5, r6, r7);
        r2 = "MicroMsg.ConversationStorage";
        r7 = "oreh onNotifyChange genDigest: pDigestUser.value=%s";
        r13 = 1;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = r5.value;
        r13[r14] = r15;
        com.tencent.mm.sdk.platformtools.x.d(r2, r7, r13);
        r2 = r4.value;
        r8.ed(r2);
        r2 = r5.value;
        r8.ee(r2);
        r2 = r6.value;
        r8.eY(r2);
    L_0x03fb:
        r2 = r3.getType();
        r2 = java.lang.Integer.toString(r2);
        r8.ec(r2);
        r0 = r17;
        r2 = r0.taA;
        if (r2 == 0) goto L_0x0413;
    L_0x040c:
        r0 = r17;
        r2 = r0.taA;
        r2.a(r3, r8);
    L_0x0413:
        r2 = 1;
        r4 = r3.field_createTime;
        r4 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(r8, r2, r4);
        r8.at(r4);
        if (r9 == 0) goto L_0x04be;
    L_0x041f:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.FR();
        r2 = r2.Yg(r12);
        if (r2 == 0) goto L_0x0449;
    L_0x0431:
        r4 = r2.field_username;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x0449;
    L_0x0439:
        r2 = r2.BG();
        if (r2 == 0) goto L_0x0449;
    L_0x043f:
        r2 = 2;
        r4 = 0;
        r4 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(r8, r2, r4);
        r8.at(r4);
    L_0x0449:
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = r3.cmk();
        if (r2 != 0) goto L_0x045a;
    L_0x0454:
        r2 = com.tencent.mm.sdk.a.b.chr();
        if (r2 == 0) goto L_0x04b6;
    L_0x045a:
        r4 = r3.field_createTime;
        r8.as(r4);
    L_0x045f:
        r0 = r17;
        r0.d(r8);
    L_0x0464:
        r0 = r17;
        r2 = r0.taD;
        r2.ci(r8);
        r0 = r17;
        r2 = r0.taD;
        r2.doNotify();
        r0 = r17;
        r2 = r0.taB;
        r0 = r19;
        r2.b(r3, r8, r9, r0);
        goto L_0x000b;
    L_0x047d:
        r2 = r3.getType();
        r4 = r8.field_content;
        r0 = r17;
        r2 = r0.aZ(r2, r4);
        r4 = r8.field_digest;
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r4);
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r5 == 0) goto L_0x04a1;
    L_0x0495:
        r2 = "";
    L_0x0498:
        r2 = r4.concat(r2);
        r8.ed(r2);
        goto L_0x03fb;
    L_0x04a1:
        r5 = new java.lang.StringBuilder;
        r6 = " ";
        r5.<init>(r6);
        r2 = com.tencent.mm.sdk.platformtools.bi.oV(r2);
        r2 = r5.append(r2);
        r2 = r2.toString();
        goto L_0x0498;
    L_0x04b6:
        r4 = com.tencent.mm.sdk.platformtools.bi.VF();
        r8.as(r4);
        goto L_0x045f;
    L_0x04be:
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = 1;
        r0 = r17;
        r0.a(r8, r12, r2);
        goto L_0x0464;
    L_0x04ca:
        r2 = "MicroMsg.ConversationStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "update null conversation with talker ";
        r4.<init>(r5);
        r4 = r4.append(r12);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r4);
        if (r9 != 0) goto L_0x04f2;
    L_0x04e2:
        r8.clx();
        r0 = r17;
        r0.a(r8, r11, r10);
        r2 = 1;
        r0 = r17;
        r0.a(r8, r12, r2);
        goto L_0x0464;
    L_0x04f2:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.bcY();
        r2 = r2.GT(r12);
        if (r2 <= 0) goto L_0x0464;
    L_0x0504:
        r2 = r3.cmk();
        if (r2 != 0) goto L_0x0510;
    L_0x050a:
        r2 = com.tencent.mm.sdk.a.b.chr();
        if (r2 == 0) goto L_0x0521;
    L_0x0510:
        r4 = r3.field_createTime;
        r8.as(r4);
    L_0x0515:
        r0 = r17;
        r0.a(r8, r11, r10);
        r0 = r17;
        r0.d(r8);
        goto L_0x0464;
    L_0x0521:
        r4 = com.tencent.mm.sdk.platformtools.bi.VF();
        r8.as(r4);
        goto L_0x0515;
    L_0x0529:
        r2 = r4;
        goto L_0x02e5;
    L_0x052c:
        r10 = r4;
        goto L_0x02fd;
    L_0x052f:
        r12 = r5;
        goto L_0x028f;
    L_0x0532:
        r8 = r2;
        r9 = r4;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.aj.b(com.tencent.mm.plugin.messenger.foundation.a.a.f, com.tencent.mm.plugin.messenger.foundation.a.a.f$c):void");
    }

    private static long c(ai aiVar) {
        if (aiVar != null) {
            return com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, aiVar.field_conversationTime);
        }
        return bi.VF() & 72057594037927935L;
    }

    public final void Yp(String str) {
        x.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[]{str, com.tencent.mm.sdk.platformtools.aj.cio()});
        if (this.diF.delete(Yo(str), "username=?", new String[]{str}) != 0) {
            b(5, this, str);
        }
    }

    public final boolean cly() {
        boolean z = this.diF.fV("rconversation", "delete from rconversation") || this.diF.fV("rconversation", "delete from rbottleconversation");
        if (z) {
            b(5, this, "");
        }
        return z;
    }

    public final boolean clz() {
        x.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", new Object[]{com.tencent.mm.sdk.platformtools.aj.cio()});
        boolean fV = this.diF.fV("rconversation", "delete from rbottleconversation");
        if (fV) {
            b(5, this, "");
        }
        return fV;
    }

    public final boolean GL(String str) {
        x.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[]{str, com.tencent.mm.sdk.platformtools.aj.cio()});
        boolean fV = this.diF.fV("rconversation", "delete from " + Yo(str) + " where username like '%" + str + "'");
        if (fV) {
            b(5, this, str);
        }
        return fV;
    }

    public final ai Yq(String str) {
        Cursor a = this.diF.a(Yo(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            ai aiVar = new ai();
            aiVar.d(a);
            a.close();
            return aiVar;
        }
        x.w("MicroMsg.ConversationStorage", "get null with username:" + str);
        a.close();
        return null;
    }

    public final void ak(bd bdVar) {
        String str = bdVar.field_talker;
        boolean z = false;
        ai Yq = Yq(str);
        if (Yq == null || Yq.field_conversationTime <= bdVar.field_createTime || Yq.field_conversationTime == Long.MAX_VALUE) {
            if (Yq == null) {
                Yq = new ai(str);
                z = true;
            }
            Yq.eX(bdVar.field_isSend);
            Yq.eV(Yq.field_unReadCount);
            Yq.aj(bdVar);
            Yq.ec(Integer.toString(bdVar.getType()));
            Yq.at((Yq.field_flag & 4611686018427387904L) | (bdVar.field_createTime & 72057594037927935L));
            if (z) {
                d(Yq);
                return;
            } else {
                a(Yq, str, true);
                return;
            }
        }
        x.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
    }

    public final HashMap<String, Long> clA() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap();
        Cursor a = this.diF.a("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null, 2);
        if (a.moveToFirst()) {
            while (true) {
                int i = a == null ? 0 : (a.isClosed() || a.isBeforeFirst() || a.isAfterLast()) ? 0 : 1;
                if (i != 0) {
                    hashMap.put(a.getString(0), Long.valueOf(a.getLong(1)));
                    a.moveToNext();
                } else {
                    a.close();
                    x.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                    return hashMap;
                }
            }
        }
        a.close();
        return hashMap;
    }

    public final long d(ai aiVar) {
        String oV = bi.oV(aiVar.field_username);
        if (oV.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            return -1;
        }
        aiVar.at(c(aiVar));
        e(aiVar);
        long insert = this.diF.insert(Yo(oV), null, aiVar.wH());
        if (insert != -1) {
            b(2, this, aiVar.field_username);
        } else {
            x.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[]{Yo(oV)});
        }
        return insert;
    }

    public final void a(ai aiVar, int i, int i2) {
        if (!((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GU(aiVar.field_username)) {
            return;
        }
        if (bi.oV(aiVar.field_username).length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            return;
        }
        if (aiVar.field_msgCount == 0) {
            aiVar.eU(((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GV(aiVar.field_username));
            x.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aiVar.eU(aiVar.field_msgCount - i);
            if (aiVar.field_msgCount < 0) {
                x.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                aiVar.eU(0);
            }
        } else if (i2 > 0) {
            aiVar.eU(aiVar.field_msgCount + i2);
        }
        x.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[]{Integer.valueOf(aiVar.field_msgCount), aiVar.field_username, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void clB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.diF.update("rconversation", contentValues, null, null);
    }

    public final void Yr(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.diF.update("rconversation", contentValues, "username=?", new String[]{str});
    }

    public final boolean Ys(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
        } else {
            x.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", new Object[]{str});
            ai Yq = Yq(str);
            if (Yq == null) {
                return true;
            }
            if (Yq.field_unReadCount == 0 && Yq.field_unReadMuteCount == 0 && str.equals(Yq.field_username)) {
                a(str, 1048576, false, Yq.field_attrflag);
                ContentValues contentValues = new ContentValues();
                contentValues.put("UnReadInvite", Integer.valueOf(0));
                if (this.diF.update(Yo(str), contentValues, "username= ?", new String[]{bi.oU(str)}) <= 0) {
                    return true;
                }
                b(3, this, str);
                return true;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("unReadCount", Integer.valueOf(0));
            contentValues2.put("unReadMuteCount", Integer.valueOf(0));
            contentValues2.put("UnReadInvite", Integer.valueOf(0));
            contentValues2.put("atCount", Integer.valueOf(0));
            contentValues2.put("attrflag", Integer.valueOf(Yq.field_attrflag & -1048577));
            int update = this.diF.update(Yo(str), contentValues2, "username= ?", new String[]{bi.oU(str)});
            if (update > 0) {
                b(3, this, str);
            }
            if (update > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean Yt(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        ai Yq = Yq(str);
        if (Yq == null || (Yq.field_unReadCount > 0 && str.equals(Yq.field_username))) {
            return true;
        }
        boolean fV = this.diF.fV("rconversation", "update " + Yo(str) + " set unReadCount = 1, atCount = 0, attrflag = " + (Yq.field_attrflag | 1048576) + " where username = \"" + bi.oU(str) + "\"");
        if (!fV) {
            return fV;
        }
        b(3, this, str);
        return fV;
    }

    public final boolean a(String str, int i, boolean z, int i2) {
        if (bi.oW(str)) {
            return false;
        }
        if (Yq(str) == null) {
            return true;
        }
        int i3;
        if (z) {
            i3 = i2 | i;
        } else {
            i3 = (i ^ -1) & i2;
        }
        if (i3 == i2) {
            return false;
        }
        boolean fV = this.diF.fV("rconversation", "update " + Yo(str) + " set attrflag = " + i3 + " where username = \"" + bi.oU(str) + "\"");
        if (!fV) {
            return fV;
        }
        b(3, this, str);
        return fV;
    }

    public final int a(ai aiVar, String str) {
        return a(aiVar, str, true);
    }

    public final int a(ai aiVar, String str, boolean z) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
            return 0;
        }
        if (z) {
            aiVar.at(c(aiVar));
        }
        e(aiVar);
        int update = this.diF.update(Yo(str), aiVar.wH(), "username=?", new String[]{str});
        if (update != 0) {
            b(3, this, str);
            return update;
        }
        x.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[]{Yo(str)});
        return update;
    }

    private static void e(ai aiVar) {
        if (aiVar != null && aiVar.field_unReadCount > 0) {
            x.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((aiVar.field_attrflag & 1048576) != 0) {
                aiVar.eV(aiVar.field_unReadCount - 1);
                aiVar.eZ(aiVar.field_attrflag & -1048577);
            }
        }
    }

    private long clC() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor b = this.diF.b("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (b.moveToNext()) {
            j = b.getLong(0);
        }
        b.close();
        x.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return j;
    }

    public final boolean Yu(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
        } else {
            ai Yq = Yq(str);
            if (Yq == null) {
                x.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
            } else {
                z = this.diF.fV("rconversation", "update " + Yo(Yq.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(Yq, 1, clC() + 1) + " where username = \"" + bi.oU(Yq.field_username) + "\"");
                if (z) {
                    b(3, this, Yq.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Yv(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
        } else {
            ai aiVar;
            if (Yq(str) == null) {
                aiVar = new ai(str);
                aiVar.as(System.currentTimeMillis());
                d(aiVar);
                x.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + str);
            }
            aiVar = Yq(str);
            if (aiVar != null) {
                z = this.diF.fV("rconversation", "update " + Yo(aiVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 2, 0) + " where username = \"" + bi.oU(aiVar.field_username) + "\"");
                if (z) {
                    b(3, this, aiVar.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Yw(String str) {
        if (str != null && str.length() > 0) {
            return f(Yq(str));
        }
        x.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
        return false;
    }

    public final boolean f(ai aiVar) {
        if (aiVar == null) {
            x.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            return false;
        }
        boolean fV = this.diF.fV("rconversation", "update " + Yo(aiVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 3, aiVar.field_conversationTime) + " where username = \"" + bi.oU(aiVar.field_username) + "\"");
        if (!fV) {
            return fV;
        }
        b(3, this, aiVar.field_username);
        return fV;
    }

    public final boolean Yx(String str) {
        if (str != null && str.length() > 0) {
            return g(Yq(str));
        }
        x.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
        return false;
    }

    public final boolean g(ai aiVar) {
        if (aiVar == null) {
            x.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final Cursor b(String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (a.dhR == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bi.oU(str2)).append("' ");
        }
        stringBuilder.append(bi.oV(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime desc");
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final List<String> clD() {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation,rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(bi.oV(bi.oV(s.dAN)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
        for (String append : s.dAV) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag desc, conversationTime desc");
        Cursor b = this.diF.b(stringBuilder.toString(), null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                do {
                    arrayList.add(b.getString(0));
                } while (b.moveToNext());
            }
            b.close();
        }
        x.d("MicroMsg.ConversationStorage", "user list:%s", new Object[]{arrayList});
        return arrayList;
    }

    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (a.dhR == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bi.oU(str2)).append("' ");
        }
        stringBuilder.append(bi.oV(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        x.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        return this.diF.b(stringBuilder.toString(), null, z ? 4 : 0);
    }

    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            if (i2 != arrayList.size() - 1) {
                stringBuilder.append("username = '" + ((String) arrayList.get(i2)) + "' OR ");
            } else {
                stringBuilder.append("username = '" + ((String) arrayList.get(i2)) + "'");
            }
            i = i2 + 1;
        }
        stringBuilder.append(") and ");
        if (a.dhR == str2) {
            stringBuilder.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bi.oU(str2)).append("' ");
        }
        stringBuilder.append(bi.oV(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username != '").append(append).append("'");
            }
        }
        x.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + stringBuilder.toString());
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor a(String str, List<String> list, boolean z, String str2) {
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        String str5 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username = rcontact.username" + str4 + bi.oV(str);
        str4 = "";
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                str3 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str3 + " and rconversation.username != '" + ((String) it.next()) + "'";
            }
            str4 = str3;
        }
        str4 = str5 + str4;
        if (z) {
            str4 = str4 + " and ( verifyFlag & 8 ) = 0";
        }
        if (str2 != null && str2.length() > 0) {
            str4 = str4 + (" and ( rconversation.username like '%" + str2 + "%' or content like '%" + str2 + "%' or rcontact.nickname like '%" + str2 + "%' or rcontact.alias like '%" + str2 + "%' or rcontact.pyInitial like '%" + str2 + "%' or rcontact.quanPin like '%" + str2 + "%' or rcontact.conRemark like '%" + str2 + "%'  ) ");
        }
        if (str2 == null || str2.equals("")) {
            str4 = str4 + " order by flag desc, conversationTime desc";
        } else {
            str4 = str4 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        x.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + str4);
        return this.diF.rawQuery(str4, null);
    }

    public final Cursor Yy(String str) {
        return this.diF.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bi.oV(str) + " order by flag desc, conversationTime desc", null);
    }

    public final void as(LinkedList<String> linkedList) {
        x.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[]{com.tencent.mm.sdk.platformtools.aj.cio()});
        if (linkedList.isEmpty()) {
            x.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        x.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[]{stringBuilder.toString()});
        this.diF.fV("rconversation", stringBuilder.toString());
    }

    public final List<String> clE() {
        int i;
        List arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        String str = "select username from rconversation";
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= arrayList.size()) {
                break;
            }
            str = str + (i > 0 ? " and " : " where ") + "username != \"" + bi.oU((String) arrayList.get(i)) + "\"";
            i2 = i + 1;
        }
        Cursor rawQuery = this.diF.rawQuery(str + " order by flag desc, conversationTime desc", null);
        i = rawQuery.getColumnIndex("username");
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(i));
        }
        rawQuery.close();
        return arrayList2;
    }

    public final Cursor k(List<String> list, int i) {
        String str = "select username from rconversation";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                str = str + (i3 > 0 ? " and " : " where ") + "username != \"" + bi.oU((String) list.get(i3)) + "\"";
                i2 = i3 + 1;
            } else {
                return this.diF.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
            }
        }
    }

    public final Cursor clF() {
        return this.diF.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    }

    public final boolean Cp(String str) {
        boolean z;
        Cursor a = this.diF.a(Yo(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        a.close();
        return z;
    }

    public final Cursor Yz(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE username LIKE '%@chatroom' ");
        stringBuilder.append(bi.oV(str));
        stringBuilder.append(" AND unReadCount > 0");
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor fZ(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount");
        stringBuilder.append(" from rconversation where username = '").append(str).append("' AND ( parentRef is ").append(a.dhR).append(" or parentRef = '' ) ").append(bi.oV(str2));
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    private static boolean clG() {
        return ((o) g.n(o.class)).getBizTimeLineCallback() != null && ((o) g.n(o.class)).getBizTimeLineCallback().auK() && ((o) g.n(o.class)).getBizTimeLineCallback().auL();
    }

    public final Cursor t(String str, List<String> list) {
        x.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[]{str, bi.cjd()});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(unReadCount) from rconversation, rcontact");
        stringBuilder.append(" where rconversation.unReadCount > 0 AND (rconversation.parentRef is ").append(a.dhR).append(" or parentRef = '' ) AND rconversation.username = rcontact.username").append(bi.oV(str)).append(" AND ( type & 512 ) == 0");
        if (!clG()) {
            stringBuilder.append(" AND rcontact.username != 'officialaccounts'");
        }
        if (!(list == null || list.isEmpty())) {
            for (String append : list) {
                stringBuilder.append(" AND rconversation.username != '").append(append).append("'");
            }
        }
        x.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[]{stringBuilder.toString()});
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor YA(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(rconversation.username)");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bi.oV(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(a.dhR).append(" or parentRef = '' ) ");
        if (!clG()) {
            stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        }
        x.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[]{stringBuilder.toString()});
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor YB(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bi.oV(str));
        stringBuilder.append(" AND ( type & 512 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(a.dhR).append(" or parentRef = '' ) ");
        if (!clG()) {
            stringBuilder.append(" AND rcontact.username != 'officialaccounts')");
        }
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        x.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[]{stringBuilder.toString()});
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public final int clH() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT SUM(rconversation.unReadCount)");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        x.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[]{stringBuilder.toString()});
        Cursor b = this.diF.b(r1, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final String clI() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        x.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor b = this.diF.b(r1, null, 2);
        if (b == null) {
            return null;
        }
        if (b.moveToFirst()) {
            String string = b.getString(0);
            b.close();
            return string;
        }
        b.close();
        return null;
    }

    public final int YC(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        x.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor b = this.diF.b(r1, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final String YD(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime DESC ");
        stringBuilder.append(" LIMIT 1 ");
        x.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor b = this.diF.b(r1, null, 2);
        if (b == null) {
            return null;
        }
        if (b.moveToFirst()) {
            String string = b.getString(0);
            b.close();
            return string;
        }
        b.close();
        return null;
    }

    public final Cursor clJ() {
        x.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[]{"select count(*) from rbottleconversation where unReadCount > 0"});
        return this.diF.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    }

    public final int hX(String str) {
        int i = 0;
        Cursor b = this.diF.b("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bi.oV(str), null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final ai clK() {
        Cursor b = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().b(s.dAN, null, "officialaccounts");
        if (b == null) {
            return null;
        }
        ai aiVar;
        if (b.getCount() <= 0 || !b.moveToFirst()) {
            aiVar = null;
        } else {
            aiVar = new ai();
            aiVar.d(b);
        }
        b.close();
        return aiVar;
    }

    public final ai YE(String str) {
        Cursor b = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().b(s.dAN, null, str);
        if (b == null) {
            return null;
        }
        ai aiVar;
        if (b.getCount() <= 0 || !b.moveToFirst()) {
            aiVar = null;
        } else {
            aiVar = new ai();
            aiVar.d(b);
        }
        b.close();
        return aiVar;
    }

    public final void d(String[] strArr, String str) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(bi.oV(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        x.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[]{stringBuilder.toString()});
        if (this.diF.fV("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                b(3, this, strArr[0]);
            }
        }
    }

    public final int YF(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!bi.oW(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        x.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[]{stringBuilder.toString()});
        Cursor b = this.diF.b(r1, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final String aZ(int i, String str) {
        if (bi.oW(str)) {
            return null;
        }
        switch (i) {
            case a$k.AppCompatTheme_actionButtonStyle /*49*/:
                Map z = bl.z(str, "msg");
                if (z == null) {
                    return null;
                }
                x.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[]{(String) z.get(".msg.appmsg.title")});
                return (String) z.get(".msg.appmsg.title");
            default:
                return null;
        }
    }

    protected final boolean Xu() {
        if (this.diF != null && !this.diF.cjr()) {
            return true;
        }
        String str = "MicroMsg.ConversationStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.diF == null ? "null" : Boolean.valueOf(this.diF.cjr());
        x.w(str, str2, objArr);
        return false;
    }

    public final void YG(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bi.oU(str) + "\"");
        x.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[]{stringBuilder.toString()});
        if (this.diF.fV("rconversation", stringBuilder.toString())) {
            b(3, this, str);
        }
    }

    public final void YH(String str) {
        x.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[]{str, Integer.valueOf(this.diF.delete(Yo(str), "username=? or parentRef =?", new String[]{str, str}))});
        if (this.diF.delete(Yo(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
            b(5, this, str);
        }
    }

    public final int YI(String str) {
        int i = -1;
        if (str != null && str.length() > 0) {
            Cursor b = this.diF.b("select msgCount from rconversation where username=" + h.fz(str), null, 2);
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }
}
