package com.tencent.mm.ac.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.o;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends i<a> implements com.tencent.mm.sdk.e.m.b {
    public static final String[] diD = new String[]{i.a(a.dhO, "BizChatConversation")};
    final k<a, b> dKC = new k<a, b>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    public e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "BizChatConversation", null);
        this.diF = eVar;
        eVar.fV("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        eVar.fV("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        eVar.fV("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor b = eVar.b("PRAGMA table_info( BizChatConversation)", null, 2);
        while (b.moveToNext()) {
            int columnIndex = b.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(b.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        b.close();
        if (obj == null) {
            eVar.fV("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().a(this);
    }

    protected final void finalize() {
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().b(this);
    }

    public final void a(a aVar, Looper looper) {
        this.dKC.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.dKC != null) {
            this.dKC.remove(aVar);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (f.eZ(str) && !s.he(str)) {
                e.D(str, true);
            }
        }
    }

    public final a bd(long j) {
        a aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        return aVar;
    }

    public final boolean be(long j) {
        a bd = bd(j);
        boolean a = super.a(bd, new String[]{"bizChatId"});
        if (a) {
            b bVar = new b();
            bVar.dNf = bd.field_bizChatId;
            bVar.bKC = bd.field_brandUserName;
            bVar.dNe = a.dNb;
            bVar.dNg = bd;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return a;
    }

    /* renamed from: a */
    public final boolean b(a aVar) {
        x.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b(aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[]{Boolean.valueOf(b)});
        if (b) {
            b bVar = new b();
            bVar.dNf = aVar.field_bizChatId;
            bVar.bKC = aVar.field_brandUserName;
            bVar.dNe = a.dNa;
            bVar.dNg = aVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return b;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[]{Boolean.valueOf(a)});
        if (a) {
            e.g(z.Na().ak(aVar.field_bizChatId));
            b bVar = new b();
            bVar.dNf = aVar.field_bizChatId;
            bVar.bKC = aVar.field_brandUserName;
            bVar.dNe = a.dNc;
            bVar.dNg = aVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return a;
    }

    public final Cursor kY(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , lastMsgTime desc");
        x.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[]{stringBuilder.toString()});
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }

    public static void a(a aVar, int i, int i2) {
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((o) g.l(o.class)).FU().av(aVar.field_brandUserName, aVar.field_bizChatId);
            x.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                x.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        x.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[]{Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean bf(long j) {
        a bd = bd(j);
        if (!(bd.field_unReadCount == 0 && bd.field_bizChatId == j)) {
            bd.field_unReadCount = 0;
            bd.field_atCount = 0;
            b(bd);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        if (aVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bi.VF();
        }
        switch (i) {
            case 2:
                return a(aVar, j) | 4611686018427387904L;
            case 3:
                return a(aVar, j) & -4611686018427387905L;
            case 4:
                return a(aVar, j) & 4611686018427387904L;
            default:
                return a(aVar, j);
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean bg(long j) {
        return c(bd(j));
    }

    public static boolean c(a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bh(long j) {
        bd(j);
        a bd = bd(j);
        boolean fV = this.diF.fV("BizChatConversation", "update BizChatConversation set flag = " + a(bd, 2, 0) + " where bizChatId = " + bd.field_bizChatId);
        if (fV) {
            bd = bd(bd.field_bizChatId);
            b bVar = new b();
            bVar.dNf = bd.field_bizChatId;
            bVar.bKC = bd.field_brandUserName;
            bVar.dNe = a.dNc;
            bVar.dNg = bd;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return fV;
    }

    public final boolean bi(long j) {
        a bd = bd(j);
        boolean fV = this.diF.fV("BizChatConversation", "update BizChatConversation set flag = " + a(bd, 3, bd.field_lastMsgTime) + " where bizChatId = " + bd.field_bizChatId);
        if (fV) {
            bd = bd(bd.field_bizChatId);
            b bVar = new b();
            bVar.dNf = bd.field_bizChatId;
            bVar.bKC = bd.field_brandUserName;
            bVar.dNe = a.dNc;
            bVar.dNg = bd;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return fV;
    }
}
