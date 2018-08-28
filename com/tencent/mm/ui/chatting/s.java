package com.tencent.mm.ui.chatting;

import android.database.Cursor;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.viewitems.ai.d;
import com.tencent.mm.ui.chatting.viewitems.av;
import com.tencent.mm.ui.chatting.viewitems.b;
import com.tencent.mm.ui.chatting.viewitems.z;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class s extends r<bd> implements e, a, g {
    public com.tencent.mm.ui.chatting.c.a bAG;
    private int bRZ;
    private boolean byZ = true;
    public String dIc;
    private LayoutInflater eMa;
    int edl;
    public c hOC = null;
    private int hPo;
    public long hpD;
    ag ioW;
    private short[] laM;
    private boolean qIZ = false;
    private com.tencent.mm.pluginsdk.ui.d.g tGO;
    public long tJJ = -1;
    private HashSet<Long> tJK = new HashSet();
    public d tJL;
    String tJM;
    private final int tJN;
    private final int tJO;
    public f tJP;
    private f tJQ;
    public t.e tJR;
    private t.e tJS;
    public l tJT;
    private l tJU;
    public a tJV;
    private a tJW;
    public c tJX;
    private c tJY;
    private long tJZ = -1;
    public com.tencent.mm.ui.chatting.c.a tJh;
    private long tKa = -1;
    private long tKb = -1;
    private int tKc = 0;
    private int tKd = 0;
    boolean tKe = false;
    boolean tKf = false;
    private boolean tKg = false;
    private boolean tKh = false;
    private boolean tKi = false;
    boolean tKj = false;
    TreeSet<Long> tKk;
    private long tKl = -1;
    private Map<Long, View> tKm;
    private Map<Long, Integer> tKn;
    private Map<Long, Long> tKo;
    private ArrayList<b> tKp = new ArrayList();
    bd tKq = new bd();
    private boolean tKr = false;
    private boolean tKs = false;
    private boolean tKt = false;
    protected com.tencent.mm.plugin.messenger.foundation.a.a.f.a tKu = new com.tencent.mm.plugin.messenger.foundation.a.a.f.a() {
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.f fVar, com.tencent.mm.plugin.messenger.foundation.a.a.f.c cVar) {
            if (fVar != null && cVar != null && cVar.talker != null && s.this.talker != null && cVar.talker.equals(s.this.talker)) {
                s.this.ctG();
            }
        }
    };
    private OnClickListener tKv = null;
    public String talker;

    public final /* synthetic */ bd ES(int i) {
        return (bd) super.getItem(i);
    }

    public s(com.tencent.mm.ui.chatting.c.a aVar, bd bdVar, String str) {
        super(aVar.tTq.getContext(), bdVar);
        aVar.a(g.class, this);
        this.tKl = -1;
        this.tJh = aVar;
        this.bAG = aVar;
        this.bRZ = 211;
        this.tJN = aVar.tTq.getMMResources().getDimensionPixelSize(R.f.SmallestPadding);
        this.tJO = aVar.tTq.getMMResources().getDimensionPixelSize(R.f.LittlePadding);
        this.tGO = new 1(this, aVar, str);
        f fVar = new f();
        this.tJQ = fVar;
        this.tJP = fVar;
        t.e eVar = new t.e(aVar);
        this.tJS = eVar;
        this.tJR = eVar;
        l lVar = new l(aVar.tTq.getContext());
        this.tJU = lVar;
        this.tJT = lVar;
        a aVar2 = new a(this);
        this.tJW = aVar2;
        this.tJV = aVar2;
        c cVar = new c(aVar);
        this.tJY = cVar;
        this.tJX = cVar;
        Iterator it = this.tKp.iterator();
        while (it.hasNext()) {
            ((b) it.next()).tGg = aVar.cwr();
        }
        this.tKm = new HashMap();
        this.tKn = new HashMap();
        this.tKo = new HashMap(5);
        if (this.hOC == null) {
            c.a aVar3 = new c.a();
            aVar3.dXB = com.tencent.mm.ac.a.e.lj(this.tJh.getTalkerUserName());
            aVar3.dXy = true;
            aVar3.dXV = true;
            aVar3.dXN = R.k.default_avatar;
            this.hOC = aVar3.Pt();
        }
    }

    public final t.e ctv() {
        return this.tJR;
    }

    public final f ctw() {
        return this.tJP;
    }

    public final a ctx() {
        return this.tJV;
    }

    public final l cty() {
        return this.tJT;
    }

    public final c ctz() {
        return this.tJX;
    }

    public final void resume() {
        this.byZ = true;
        ctD();
        au.HU();
        com.tencent.mm.model.c.FT().a(this.tKu, Looper.getMainLooper());
        j.a(this.tGO);
        x.i("MicroMsg.ChattingListAdapter", "adapter resume");
    }

    public final void pause() {
        this.byZ = false;
        au.HU();
        com.tencent.mm.model.c.FT().a(this.tKu);
        j.b(this.tGO);
        x.i("MicroMsg.ChattingListAdapter", "adapter pause");
    }

    public final void ctA() {
        if (this.tKk != null) {
            this.tKk.clear();
        }
        this.edl = 0;
        this.hPo = -1;
        this.tJZ = -1;
        this.tKa = -1;
        this.tKb = -1;
        this.tJJ = -1;
        this.tKc = 0;
        this.tKd = 0;
        this.tKe = false;
        this.tKf = false;
        this.tKg = false;
        this.tKh = false;
        this.tKj = false;
    }

    public final int t(long j, boolean z) {
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(j);
        if (dW.field_msgId != j) {
            x.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", new Object[]{Long.valueOf(j)});
            return 0;
        }
        int p;
        long j2 = dW.field_createTime;
        if (j2 < this.tJZ || j2 > this.tKa) {
            this.tJZ = j2;
            this.tKb = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GZ(this.talker);
            if (z) {
                this.tKa = this.tKb;
            } else {
                au.HU();
                this.tKa = com.tencent.mm.model.c.FT().Y(this.talker, j2);
            }
            this.tKg = true;
            au.HU();
            x.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", new Object[]{Integer.valueOf(com.tencent.mm.model.c.FT().p(this.talker, this.tJZ, this.tKa))});
            if (com.tencent.mm.model.c.FT().p(this.talker, this.tJZ, this.tKa) < 18) {
                x.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[]{Long.valueOf(this.tJZ), Integer.valueOf(0)});
                au.HU();
                this.tJZ = com.tencent.mm.model.c.FT().X(this.talker, this.tJZ);
                au.HU();
                p = com.tencent.mm.model.c.FT().p(this.talker, this.tJZ, j2);
            } else {
                p = 0;
            }
        } else {
            au.HU();
            p = com.tencent.mm.model.c.FT().p(this.talker, this.tJZ, j2);
        }
        x.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", new Object[]{Long.valueOf(j), Long.valueOf(this.tJZ), Long.valueOf(this.tKa), Long.valueOf(this.tKb), Integer.valueOf(p)});
        return p;
    }

    private static bd a(bd bdVar, Cursor cursor) {
        if (bdVar == null) {
            bdVar = new bd();
        }
        bdVar.d(cursor);
        return bdVar;
    }

    public final boolean ctB() {
        if (this.tKg) {
            this.tKb = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GZ(this.talker);
            if (this.tKb >= this.tKa) {
                this.tKa = this.tKb;
                WT();
                return true;
            }
        }
        return false;
    }

    protected final void WS() {
        au.HU();
        setCursor(com.tencent.mm.model.c.FT().bdj());
    }

    public final long ctC() {
        if (this.tKl != -1) {
            return this.tKl;
        }
        this.tKl = 0;
        Cursor cursor = getCursor();
        int position = cursor.getPosition();
        int count = cursor.getCount();
        x.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", new Object[]{Integer.valueOf(position), Integer.valueOf(count)});
        if (cursor.moveToLast()) {
            do {
                this.tKq = null;
                this.tKq = a(this.tKq, cursor);
                if (this.tKq.field_isSend == 1) {
                    if ((this.tKq.cqa & 4) != 4) {
                        this.tKl = this.tKq.field_msgId;
                    }
                }
            } while (cursor.moveToPrevious());
        }
        if (count < 0) {
            if (count > 0) {
                cursor.moveToPosition(0);
            }
        } else if (position < count) {
            cursor.moveToPosition(position);
        } else if (count > 0) {
            cursor.moveToPosition(count - 1);
        }
        return this.tKl;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void WT() {
        /*
        r14 = this;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.Gx();
        r1 = r14.talker;
        r2 = r0.Gw(r1);
        r0 = r14.tJh;
        r1 = com.tencent.mm.ui.chatting.b.b.c.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.c) r0;
        r4 = r14.hpD;
        r6 = -1;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 == 0) goto L_0x0109;
    L_0x0024:
        r0 = r0.cur();
        if (r0 == 0) goto L_0x0109;
    L_0x002a:
        r0 = 1;
        r14.qIZ = r0;
    L_0x002d:
        r0 = r14.tKg;
        if (r0 != 0) goto L_0x0468;
    L_0x0031:
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x010e;
    L_0x0035:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r4 = r14.hpD;
        r0 = r0.au(r1, r4);
        r14.edl = r0;
    L_0x0046:
        r0 = 0;
        r1 = r14.hPo;
        if (r1 < 0) goto L_0x0051;
    L_0x004b:
        r1 = r14.hPo;
        r4 = r14.edl;
        if (r1 <= r4) goto L_0x0058;
    L_0x0051:
        r0 = 1;
        r1 = r14.edl;
        r1 = r1 + -18;
        r14.hPo = r1;
    L_0x0058:
        r1 = r0;
        r0 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr summerdel resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b, createTime:%s";
        r5 = 7;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Boolean.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = r14.hPo;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 2;
        r7 = r14.edl;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 3;
        r7 = r14.edl;
        r8 = r14.hPo;
        r7 = r7 - r8;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 4;
        r7 = r14.talker;
        r5[r6] = r7;
        r6 = 5;
        r7 = r14.qIZ;
        r7 = java.lang.Boolean.valueOf(r7);
        r5[r6] = r7;
        r6 = 6;
        r7 = java.lang.Long.valueOf(r2);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x011f;
    L_0x00a3:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.edl;
        r5 = r14.hPo;
        r4 = r4 - r5;
        r4 = r0.i(r1, r2, r4);
    L_0x00b7:
        if (r4 == 0) goto L_0x00bf;
    L_0x00b9:
        r0 = r4.isClosed();
        if (r0 == 0) goto L_0x041c;
    L_0x00bf:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos fail, cursor is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x00c8:
        r14.setCursor(r4);
    L_0x00cb:
        r0 = r14.getCount();
        if (r0 <= 0) goto L_0x00d5;
    L_0x00d1:
        r0 = new short[r0];
        r14.laM = r0;
    L_0x00d5:
        r0 = r14.tKm;
        r0.clear();
        r0 = r14.tKn;
        r0.clear();
        r0 = r14.tKo;
        r0.clear();
        super.notifyDataSetChanged();
        r0 = r14.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.q.class;
        r0 = r0.O(r1);
        if (r0 == 0) goto L_0x0108;
    L_0x00f1:
        r0 = r14.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.q.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.q) r0;
        r0 = r0.cvD();
        if (r0 == 0) goto L_0x0108;
    L_0x0101:
        r0 = com.tencent.mm.az.d.SG();
        r0.cma();
    L_0x0108:
        return;
    L_0x0109:
        r0 = 0;
        r14.qIZ = r0;
        goto L_0x002d;
    L_0x010e:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r0 = r0.GT(r1);
        r14.edl = r0;
        goto L_0x0046;
    L_0x011f:
        r0 = r14.tJh;
        r0 = r0.cwr();
        if (r0 != 0) goto L_0x013b;
    L_0x0127:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r4 = r14.edl;
        r5 = r14.hPo;
        r4 = r4 - r5;
        r4 = r0.g(r1, r4, r2);
        goto L_0x00b7;
    L_0x013b:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r4 = r14.talker;
        r5 = r14.edl;
        r6 = r14.hPo;
        r5 = r5 - r6;
        r4 = r0.g(r4, r5, r2);
        r0 = r14.tJh;
        r2 = com.tencent.mm.ui.chatting.b.b.z.class;
        r0 = r0.O(r2);
        r0 = (com.tencent.mm.ui.chatting.b.b.z) r0;
        if (r0 == 0) goto L_0x00b7;
    L_0x0159:
        r0 = r0.cvU();
        if (r0 == 0) goto L_0x00b7;
    L_0x015f:
        if (r4 != 0) goto L_0x0216;
    L_0x0161:
        r0 = -1;
    L_0x0162:
        r2 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault count[%d], talker[%s]";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r5[r6] = r7;
        r6 = 1;
        r7 = r14.talker;
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);
        if (r0 <= 0) goto L_0x00b7;
    L_0x017c:
        if (r1 == 0) goto L_0x021c;
    L_0x017e:
        r0 = r4.moveToLast();
        if (r0 == 0) goto L_0x0222;
    L_0x0184:
        r5 = 1;
        r6 = java.lang.System.currentTimeMillis();
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FW();
        r2 = r14.talker;
        r0 = r0.Yq(r2);
        if (r0 != 0) goto L_0x0224;
    L_0x0198:
        r0 = 0;
    L_0x0199:
        r2 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "msgSeq";
        r10 = r4.getColumnIndex(r10);
        r10 = r4.getInt(r10);
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r1);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r0);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r8);
        r2 = 0;
    L_0x01c6:
        r3 = "flag";
        r3 = r4.getColumnIndex(r3);
        r3 = r4.getInt(r3);
        r8 = r3 & 2;
        if (r8 != 0) goto L_0x0228;
    L_0x01d5:
        r8 = "isSend";
        r8 = r4.getColumnIndex(r8);
        r8 = r4.getInt(r8);
        if (r8 == 0) goto L_0x0228;
    L_0x01e2:
        r2 = r2 + 1;
    L_0x01e4:
        if (r1 == 0) goto L_0x0414;
    L_0x01e6:
        r3 = r4.moveToPrevious();
        if (r3 != 0) goto L_0x01c6;
    L_0x01ec:
        r1 = r5;
        r0 = r4;
    L_0x01ee:
        if (r1 == 0) goto L_0x0210;
    L_0x01f0:
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r4[r5] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
    L_0x0210:
        r1 = 0;
        r14.tKj = r1;
        r4 = r0;
        goto L_0x00b7;
    L_0x0216:
        r0 = r4.getCount();
        goto L_0x0162;
    L_0x021c:
        r0 = r4.moveToFirst();
        if (r0 != 0) goto L_0x0184;
    L_0x0222:
        r0 = r4;
        goto L_0x0210;
    L_0x0224:
        r0 = r0.field_UnDeliverCount;
        goto L_0x0199;
    L_0x0228:
        if (r0 != 0) goto L_0x02b6;
    L_0x022a:
        r8 = r3 & 2;
        if (r8 != 0) goto L_0x02b6;
    L_0x022e:
        r3 = "type";
        r3 = r4.getColumnIndex(r3);
        r3 = r4.getInt(r3);
        r8 = 50;
        if (r3 > r8) goto L_0x023f;
    L_0x023d:
        if (r3 >= 0) goto L_0x0242;
    L_0x023f:
        r2 = r2 + 1;
        goto L_0x01e4;
    L_0x0242:
        r0 = r14.tJh;
        r1 = com.tencent.mm.ui.chatting.b.b.z.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.z) r0;
        r0.cvV();
        r0 = new com.tencent.mm.storage.bd;
        r0.<init>();
        r0.d(r4);
        r4.moveToFirst();
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr revisedCursor check fault but not needCheckFault more break[%d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d";
        r5 = 8;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r9 = r0.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 1;
        r9 = r0.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 2;
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 3;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 4;
        r10 = r0.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 5;
        r0 = r0.getType();
        r0 = java.lang.Integer.valueOf(r0);
        r5[r8] = r0;
        r0 = 6;
        r8 = java.lang.System.currentTimeMillis();
        r8 = r8 - r6;
        r8 = java.lang.Long.valueOf(r8);
        r5[r0] = r8;
        r0 = 7;
        r8 = java.lang.Integer.valueOf(r2);
        r5[r0] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r5);
        r1 = 0;
        r0 = r4;
        goto L_0x01ee;
    L_0x02b6:
        r8 = r3 & 1;
        if (r8 != 0) goto L_0x02be;
    L_0x02ba:
        r2 = r2 + 1;
        goto L_0x01e4;
    L_0x02be:
        if (r2 != 0) goto L_0x02cd;
    L_0x02c0:
        r2 = r2 + 1;
        r3 = "MicroMsg.ChattingListAdapter";
        r8 = "summerbadcr revisedCursor check fault index == 0 continue";
        com.tencent.mm.sdk.platformtools.x.i(r3, r8);
        goto L_0x01e4;
    L_0x02cd:
        r3 = r3 & 4;
        if (r3 == 0) goto L_0x037e;
    L_0x02d1:
        r3 = 1;
    L_0x02d2:
        r8 = new com.tencent.mm.storage.bd;
        r8.<init>();
        r8.d(r4);
        if (r1 == 0) goto L_0x03d8;
    L_0x02dc:
        if (r3 == 0) goto L_0x0381;
    L_0x02de:
        r4.close();
        r0 = r14.edl;
        r0 = r0 - r2;
        r0 = r0 + -1;
        r14.hPo = r0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r4 = r14.edl;
        r5 = r14.hPo;
        r4 = r4 - r5;
        r10 = 0;
        r0 = r0.g(r1, r4, r10);
    L_0x02fc:
        r4 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault faultUp[%b]  break[%d, %d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d, nowCount:%d, fromCount:%d";
        r1 = 12;
        r9 = new java.lang.Object[r1];
        r1 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r9[r1] = r3;
        r1 = 1;
        r3 = r8.field_flag;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 2;
        r3 = r8.field_isSend;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 3;
        r10 = r8.field_msgId;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 4;
        r10 = r8.field_msgSvrId;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 5;
        r10 = r8.field_msgSeq;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 6;
        r3 = r8.getType();
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 7;
        r10 = r8.field_createTime;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 8;
        r10 = java.lang.System.currentTimeMillis();
        r10 = r10 - r6;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 9;
        r3 = java.lang.Integer.valueOf(r2);
        r9[r1] = r3;
        r3 = 10;
        if (r0 != 0) goto L_0x040e;
    L_0x0367:
        r1 = -1;
    L_0x0368:
        r1 = java.lang.Integer.valueOf(r1);
        r9[r3] = r1;
        r1 = 11;
        r3 = r14.hPo;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r9);
        r1 = 0;
        goto L_0x01ee;
    L_0x037e:
        r3 = 0;
        goto L_0x02d2;
    L_0x0381:
        r9 = "MicroMsg.ChattingListAdapter";
        r10 = "summerbadcr revisedCursor check fault faultUp[%s] upLoadMore[%s] but restart continue[%s, %s, %s, %s, %s, %s]";
        r11 = 8;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r11[r12] = r3;
        r3 = 1;
        r12 = r14.tKj;
        r12 = java.lang.Boolean.valueOf(r12);
        r11[r3] = r12;
        r3 = 2;
        r12 = r8.field_flag;
        r12 = java.lang.Integer.valueOf(r12);
        r11[r3] = r12;
        r3 = 3;
        r12 = r8.field_isSend;
        r12 = java.lang.Integer.valueOf(r12);
        r11[r3] = r12;
        r3 = 4;
        r12 = r8.field_msgId;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 5;
        r12 = r8.field_msgSvrId;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 6;
        r12 = r8.field_msgSeq;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 7;
        r8 = r8.getType();
        r8 = java.lang.Integer.valueOf(r8);
        r11[r3] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r9, r10, r11);
        goto L_0x01e4;
    L_0x03d8:
        r4.close();
        if (r3 == 0) goto L_0x03f8;
    L_0x03dd:
        r0 = r14.hPo;
        r0 = r0 + r2;
        r14.hPo = r0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r4 = r14.edl;
        r5 = r14.hPo;
        r4 = r4 - r5;
        r10 = 0;
        r0 = r0.g(r1, r4, r10);
        goto L_0x02fc;
    L_0x03f8:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r4 = r14.edl;
        r5 = r14.hPo;
        r4 = r4 - r5;
        r10 = r8.field_createTime;
        r0 = r0.h(r1, r4, r10);
        goto L_0x02fc;
    L_0x040e:
        r1 = r0.getCount();
        goto L_0x0368;
    L_0x0414:
        r3 = r4.moveToNext();
        if (r3 != 0) goto L_0x01c6;
    L_0x041a:
        goto L_0x01ec;
    L_0x041c:
        r0 = r4.moveToLast();
        if (r0 == 0) goto L_0x0430;
    L_0x0422:
        r0 = r14.tKq;
        r0 = a(r0, r4);
        r14.tKq = r0;
        r0 = r14.tKq;
        r0 = r0.field_createTime;
        r14.tKa = r0;
    L_0x0430:
        r0 = -1;
        r14.tKl = r0;
        r0 = r4.moveToFirst();
        if (r0 == 0) goto L_0x0448;
    L_0x043a:
        r0 = r14.tKq;
        r0 = a(r0, r4);
        r14.tKq = r0;
        r0 = r14.tKq;
        r0 = r0.field_createTime;
        r14.tJZ = r0;
    L_0x0448:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos topCreateTime[%d] downCreateTime[%d]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r6 = r14.tJZ;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 1;
        r6 = r14.tKa;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        goto L_0x00c8;
    L_0x0468:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "topLoadMore[%B] downLoadMore[%B]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r14.tKe;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r14.tKf;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r14.tKe;
        if (r0 != 0) goto L_0x04cb;
    L_0x048a:
        r0 = r14.tKf;
        if (r0 != 0) goto L_0x04cb;
    L_0x048e:
        r0 = r14.tKa;
        r2 = r14.tKb;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x04cb;
    L_0x0496:
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x05b6;
    L_0x049a:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r0 = r0.ax(r1, r2);
        r14.tKb = r0;
        r8 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tKa;
        r6 = r14.tKb;
        r0 = r0.c(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.tKd = r0;
    L_0x04c7:
        r0 = r14.tKb;
        r14.tKa = r0;
    L_0x04cb:
        r0 = r14.tKe;
        if (r0 == 0) goto L_0x0503;
    L_0x04cf:
        r0 = 0;
        r14.tKe = r0;
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x05e6;
    L_0x04d6:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tJZ;
        r4 = r0.w(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r6 = r14.tJZ;
        r0 = r0.c(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.tKc = r0;
    L_0x0501:
        r14.tJZ = r4;
    L_0x0503:
        r0 = r14.tKf;
        if (r0 == 0) goto L_0x053b;
    L_0x0507:
        r0 = 0;
        r14.tKf = r0;
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x0610;
    L_0x050e:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tKa;
        r6 = r0.x(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tKa;
        r0 = r0.c(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.tKd = r0;
    L_0x0539:
        r14.tKa = r6;
    L_0x053b:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]";
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r14.tJZ;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r14.tKa;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r14.tKb;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r14.tKc;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = r14.tKd;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.v(r0, r1, r2);
        r0 = r14.qIZ;
        if (r0 == 0) goto L_0x063a;
    L_0x0578:
        r8 = "MicroMsg.ChattingListAdapter";
        r9 = "count([top, down]) = %d";
        r0 = 1;
        r10 = new java.lang.Object[r0];
        r11 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tJZ;
        r6 = r14.tKa;
        r0 = r0.c(r1, r2, r4, r6);
        r0 = java.lang.Integer.valueOf(r0);
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r8, r9, r10);
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FU();
        r1 = r14.talker;
        r2 = r14.hpD;
        r4 = r14.tJZ;
        r6 = r14.tKa;
        r0 = r0.d(r1, r2, r4, r6);
        r14.setCursor(r0);
        goto L_0x00cb;
    L_0x05b6:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.bcY();
        r1 = r14.talker;
        r0 = r0.GZ(r1);
        r14.tKb = r0;
        r6 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tKa;
        r4 = r14.tKb;
        r0 = r0.p(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.tKd = r0;
        goto L_0x04c7;
    L_0x05e6:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tJZ;
        r2 = r0.X(r1, r2);
        r6 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r4 = r14.tJZ;
        r0 = r0.p(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.tKc = r0;
        r4 = r2;
        goto L_0x0501;
    L_0x0610:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tKa;
        r4 = r0.Y(r1, r2);
        r6 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tKa;
        r0 = r0.p(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.tKd = r0;
        r6 = r4;
        goto L_0x0539;
    L_0x063a:
        r6 = "MicroMsg.ChattingListAdapter";
        r7 = "count([top, down]) = %d";
        r0 = 1;
        r8 = new java.lang.Object[r0];
        r9 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tJZ;
        r4 = r14.tKa;
        r0 = r0.p(r1, r2, r4);
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r6, r7, r8);
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r14.talker;
        r2 = r14.tJZ;
        r4 = r14.tKa;
        r0 = r0.q(r1, r2, r4);
        r14.setCursor(r0);
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.s.WT():void");
    }

    public final void lS(boolean z) {
        this.tKr = z;
        if (!z) {
            this.tKt = false;
        }
        if (!z && this.tKs) {
            a(null, null);
            this.tKs = false;
        }
    }

    public final void ctD() {
        unlock();
        a(null, null);
    }

    public final void unlock() {
        this.tKs = false;
        this.tKr = false;
        this.tKt = false;
    }

    public final void ctE() {
        this.tKt = true;
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.f.a ctF() {
        return this.tKu;
    }

    public final void ctG() {
        if (this.tKt) {
            this.tKt = false;
        } else if (this.tKr) {
            this.tKs = true;
        } else if (bi.oW(this.talker)) {
            x.w("MicroMsg.ChattingListAdapter", "talker is null!");
        } else if (this.byZ) {
            super.a(null, null);
        } else {
            x.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
        }
    }

    public final int getItemViewType(int i) {
        return av.bF((bd) getItem(i));
    }

    public final int getViewTypeCount() {
        return av.cxT();
    }

    public final int EP(int i) {
        if (this.tKg) {
            return this.tKc;
        }
        if (i <= 0) {
            return 0;
        }
        if (this.hPo < i) {
            i = this.hPo;
            this.hPo = 0;
            return i;
        }
        this.hPo -= i;
        return i;
    }

    public final int ctH() {
        return this.hPo;
    }

    public final int ctI() {
        return this.edl;
    }

    public final boolean ctJ() {
        if (this.tKg) {
            return this.tJZ <= ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GY(this.talker);
        } else if (this.hPo <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean ctK() {
        if (!this.tKg) {
            return true;
        }
        boolean z;
        long GZ = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GZ(this.talker);
        String str = "MicroMsg.ChattingListAdapter";
        StringBuilder append = new StringBuilder("[showButtomAll] lastMsgCreateTime:").append(GZ).append(" lastBottomMsgCreateTime:").append(this.tKa).append(" ret:");
        if (this.tKa >= GZ) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, append.append(z).toString());
        if (this.tKa < GZ) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
        r10 = this;
        r0 = r10.getItem(r11);
        r0 = (com.tencent.mm.storage.bd) r0;
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s, flag:%s position:%s";
        r3 = 8;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r11);
        r3[r4] = r5;
        r4 = 1;
        r6 = r0.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r4 = 2;
        r6 = r0.field_msgSvrId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r4 = 3;
        r5 = r0.getType();
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = r0.field_isSend;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 5;
        r5 = r0.field_talker;
        r3[r4] = r5;
        r4 = 6;
        r5 = r0.field_flag;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 7;
        r5 = java.lang.Integer.valueOf(r11);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        if (r11 != 0) goto L_0x0067;
    L_0x0057:
        r1 = r10.tJh;
        r2 = "MicroMsg.ChattingContext";
        r3 = "[scrollToLastProtect]";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r1 = r1.tTr;
        r1.cue();
    L_0x0067:
        if (r11 == 0) goto L_0x009b;
    L_0x0069:
        r1 = r10.laM;
        r1 = r1[r11];
        if (r1 != 0) goto L_0x009b;
    L_0x006f:
        r1 = r11 + -1;
        r1 = r10.getItem(r1);
        r1 = (com.tencent.mm.storage.bd) r1;
        r2 = r1.field_createTime;
        r4 = r0.field_createTime;
        r6 = r4 - r2;
        r8 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x02ae;
    L_0x0084:
        r1 = 1;
    L_0x0085:
        r2 = r4 - r2;
        r4 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r2 = r2 / r4;
        r4 = 1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x02b1;
    L_0x0091:
        r2 = 1;
    L_0x0092:
        if (r1 != 0) goto L_0x0096;
    L_0x0094:
        if (r2 == 0) goto L_0x02b4;
    L_0x0096:
        r1 = r10.laM;
        r2 = 2;
        r1[r11] = r2;
    L_0x009b:
        r1 = r10.laM;
        r1 = r1[r11];
        r2 = 1;
        if (r1 == r2) goto L_0x00b2;
    L_0x00a2:
        if (r11 == 0) goto L_0x00b2;
    L_0x00a4:
        r1 = r10.tJK;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1 = r1.contains(r2);
        if (r1 == 0) goto L_0x02bb;
    L_0x00b2:
        r2 = r0.field_createTime;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x02bb;
    L_0x00ba:
        r1 = 1;
        r2 = r1;
    L_0x00bc:
        r4 = r0.field_msgId;
        r6 = r10.tJJ;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x02bf;
    L_0x00c4:
        r1 = 1;
        r4 = r1;
    L_0x00c6:
        if (r12 != 0) goto L_0x02c3;
    L_0x00c8:
        r1 = r10.eMa;
        if (r1 != 0) goto L_0x00da;
    L_0x00cc:
        r1 = r10.tJh;
        r1 = r1.tTq;
        r1 = r1.getContext();
        r1 = com.tencent.mm.ui.y.gq(r1);
        r10.eMa = r1;
    L_0x00da:
        r3 = com.tencent.mm.ui.chatting.viewitems.av.bE(r0);
        r1 = r10.eMa;
        r12 = r3.a(r1, r12);
        r1 = r12.getTag();
        r1 = (com.tencent.mm.ui.chatting.viewitems.b.a) r1;
        r1.tZx = r3;
        r3 = r1;
    L_0x00ed:
        if (r2 == 0) goto L_0x02cc;
    L_0x00ef:
        r1 = r3.hrs;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = r3.hrs;
        r2 = r10.tJh;
        r2 = r2.tTq;
        r2 = r2.getContext();
        r6 = r0.field_createTime;
        r5 = 0;
        r2 = com.tencent.mm.pluginsdk.f.h.c(r2, r6, r5);
        r1.setText(r2);
        r1 = r3.hrs;
        r1 = r1.getTextSize();
        r2 = r10.tJh;
        r2 = r2.tTq;
        r2 = r2.getContext();
        r5 = 25;
        r2 = com.tencent.mm.bp.a.fromDPToPix(r2, r5);
        r2 = (float) r2;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x013b;
    L_0x0122:
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "WDF!!! TextSize:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r3.hrs;
        r7 = r7.getTextSize();
        r7 = java.lang.Float.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r5);
    L_0x013b:
        r1 = r3.tZu;
        if (r1 == 0) goto L_0x0147;
    L_0x013f:
        if (r4 == 0) goto L_0x02d5;
    L_0x0141:
        r1 = r3.tZu;
        r2 = 0;
        r1.setVisibility(r2);
    L_0x0147:
        r1 = r3.tZx;
        r2 = r10.tlE;
        if (r2 == 0) goto L_0x016d;
    L_0x014d:
        r2 = 0;
        r3.tZw = r2;
        r2 = com.tencent.mm.an.b.Qa();
        if (r2 == 0) goto L_0x0168;
    L_0x0156:
        r4 = r2.rsp;
        if (r4 == 0) goto L_0x0168;
    L_0x015a:
        r4 = r2.rYj;
        if (r4 != 0) goto L_0x0168;
    L_0x015e:
        r4 = com.tencent.mm.an.b.PY();
        if (r4 == 0) goto L_0x0168;
    L_0x0164:
        r2 = r2.rsp;
        r3.tZw = r2;
    L_0x0168:
        r2 = r10.tJh;
        r1.a(r3, r11, r2, r0);
    L_0x016d:
        r1 = r10.bAG;
        r2 = com.tencent.mm.ui.chatting.b.b.b.class;
        r1 = r1.O(r2);
        r1 = (com.tencent.mm.ui.chatting.b.b.b) r1;
        r1 = r1.cuM();
        r2 = r3.hrs;
        r2 = r2.getVisibility();
        if (r2 != 0) goto L_0x01bb;
    L_0x0183:
        if (r1 == 0) goto L_0x01bb;
    L_0x0185:
        r2 = r3.hrs;
        r4 = r1.qER;
        r2.setTextColor(r4);
        r2 = r1.qES;
        if (r2 == 0) goto L_0x02de;
    L_0x0190:
        r2 = r3.hrs;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r6 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r7 = r1.qET;
        r2.setShadowLayer(r4, r5, r6, r7);
    L_0x019f:
        r2 = r1.qEU;
        if (r2 == 0) goto L_0x02f2;
    L_0x01a3:
        r2 = r1.qEV;
        if (r2 == 0) goto L_0x02e9;
    L_0x01a7:
        r2 = r3.hrs;
        r4 = com.tencent.mm.R.g.chat_tips_light_bg;
        r2.setBackgroundResource(r4);
    L_0x01ae:
        r2 = r3.hrs;
        r4 = r10.tJO;
        r5 = r10.tJN;
        r6 = r10.tJO;
        r7 = r10.tJN;
        r2.setPadding(r4, r5, r6, r7);
    L_0x01bb:
        r2 = r3.mQc;
        if (r2 == 0) goto L_0x01ed;
    L_0x01bf:
        r2 = r3.mQc;
        r2 = r2.getVisibility();
        if (r2 != 0) goto L_0x01ed;
    L_0x01c7:
        if (r1 == 0) goto L_0x01ed;
    L_0x01c9:
        r2 = r10.talker;
        r4 = "qqmail";
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x01ed;
    L_0x01d4:
        r2 = r0.getType();
        r4 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        if (r2 == r4) goto L_0x01ed;
    L_0x01dd:
        r2 = r3.mQc;
        r1 = r1.qEW;
        r2.setTextColor(r1);
        r1 = r3.mQc;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1.setShadowLayer(r2, r4, r5, r6);
    L_0x01ed:
        r1 = r10.tKh;
        if (r1 == 0) goto L_0x01fa;
    L_0x01f1:
        r1 = r0.isSystem();
        if (r1 == 0) goto L_0x02fa;
    L_0x01f7:
        r1 = 0;
    L_0x01f8:
        if (r1 != 0) goto L_0x01fe;
    L_0x01fa:
        r1 = r10.tKi;
        if (r1 == 0) goto L_0x02fd;
    L_0x01fe:
        r1 = r3.jBR;
        if (r1 == 0) goto L_0x0213;
    L_0x0202:
        r1 = r3.jBR;
        r2 = r10.tKk;
        r4 = r0.field_msgId;
        r4 = java.lang.Long.valueOf(r4);
        r2 = r2.contains(r4);
        r1.setChecked(r2);
    L_0x0213:
        r1 = r3.gFD;
        if (r1 == 0) goto L_0x0229;
    L_0x0217:
        r1 = r3.gFD;
        r4 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r4);
        r1.setTag(r2);
        r1 = r3.gFD;
        r2 = r10.tKv;
        r1.setOnClickListener(r2);
    L_0x0229:
        r1 = 1;
        r3.me(r1);
    L_0x022d:
        r1 = r10.tKm;
        r1 = r1.entrySet();
        r2 = r1.iterator();
    L_0x0237:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x025b;
    L_0x023d:
        r1 = r2.next();
        r1 = (java.util.Map.Entry) r1;
        r3 = r1.getValue();
        if (r3 != r12) goto L_0x0237;
    L_0x0249:
        r2 = r10.tKm;
        r3 = r1.getKey();
        r2.remove(r3);
        r2 = r10.tKn;
        r1 = r1.getKey();
        r2.remove(r1);
    L_0x025b:
        r1 = r10.tKm;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1.put(r2, r12);
        r1 = r0.ckA();
        if (r1 == 0) goto L_0x027d;
    L_0x026c:
        r1 = r10.tKn;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r3 = r0.field_isSend;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r3);
    L_0x027d:
        if (r11 == 0) goto L_0x02ad;
    L_0x027f:
        r1 = r10.bAG;
        r1 = r1.getTalkerUserName();
        r1 = com.tencent.mm.model.s.fq(r1);
        if (r1 == 0) goto L_0x02ad;
    L_0x028b:
        r1 = r0.field_flag;
        r1 = r1 & 1;
        if (r1 == 0) goto L_0x02ad;
    L_0x0291:
        r1 = r10.tKo;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1 = r1.get(r2);
        if (r1 != 0) goto L_0x02ad;
    L_0x029f:
        r1 = com.tencent.mm.kernel.g.Em();
        r2 = new com.tencent.mm.ui.chatting.s$4;
        r2.<init>(r0);
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r1.h(r2, r4);
    L_0x02ad:
        return r12;
    L_0x02ae:
        r1 = 0;
        goto L_0x0085;
    L_0x02b1:
        r2 = 0;
        goto L_0x0092;
    L_0x02b4:
        r1 = r10.laM;
        r2 = 1;
        r1[r11] = r2;
        goto L_0x009b;
    L_0x02bb:
        r1 = 0;
        r2 = r1;
        goto L_0x00bc;
    L_0x02bf:
        r1 = 0;
        r4 = r1;
        goto L_0x00c6;
    L_0x02c3:
        r1 = r12.getTag();
        r1 = (com.tencent.mm.ui.chatting.viewitems.b.a) r1;
        r3 = r1;
        goto L_0x00ed;
    L_0x02cc:
        r1 = r3.hrs;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x013b;
    L_0x02d5:
        r1 = r3.tZu;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x0147;
    L_0x02de:
        r2 = r3.hrs;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2.setShadowLayer(r4, r5, r6, r7);
        goto L_0x019f;
    L_0x02e9:
        r2 = r3.hrs;
        r4 = com.tencent.mm.R.g.chat_tips_bg;
        r2.setBackgroundResource(r4);
        goto L_0x01ae;
    L_0x02f2:
        r2 = r3.hrs;
        r4 = 0;
        r2.setBackgroundColor(r4);
        goto L_0x01bb;
    L_0x02fa:
        r1 = 1;
        goto L_0x01f8;
    L_0x02fd:
        r1 = 0;
        r3.me(r1);
        goto L_0x022d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.s.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void c(OnClickListener onClickListener) {
        this.tKv = onClickListener;
    }

    public final boolean gt(long j) {
        if (this.tKk.contains(Long.valueOf(j))) {
            x.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", new Object[]{Long.valueOf(j)});
            this.tKk.remove(Long.valueOf(j));
        } else {
            x.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", new Object[]{Long.valueOf(j)});
            if (this.tKk.size() >= 100) {
                h.b(this.tJh.tTq.getContext(), this.tJh.tTq.getMMResources().getString(R.l.exceed_select_item_warning, new Object[]{Integer.valueOf(100)}), "", true);
                return false;
            }
            this.tKk.add(Long.valueOf(j));
        }
        a(null, null);
        return true;
    }

    public final int boX() {
        return this.tKk.size();
    }

    public final Set<Long> ctL() {
        return this.tKk;
    }

    public final void ctM() {
        if (this.tKk != null) {
            this.tKk.clear();
        }
    }

    private void ctN() {
        x.d("MicroMsg.ChattingListAdapter", "disable clickListener");
        this.tJP = null;
        this.tJR = null;
        this.tJT = null;
        this.tJV = null;
        this.tJX = null;
    }

    public final void ctO() {
        this.tKh = true;
        notifyDataSetChanged();
        ctN();
    }

    public final void aMw() {
        this.tKh = false;
        notifyDataSetChanged();
        x.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
        this.tJP = this.tJQ;
        this.tJR = this.tJS;
        this.tJT = this.tJU;
        this.tJV = this.tJW;
        this.tJX = this.tJY;
        ((com.tencent.mm.ui.chatting.b.b.c) this.tJh.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuD();
    }

    public final boolean isInEditMode() {
        return this.tKh;
    }

    public final void EQ(int i) {
        bd bdVar = (bd) getItem(i);
        if (bdVar != null && bdVar.field_msgId != 0) {
            this.tJK.add(Long.valueOf(bdVar.field_msgId));
        }
    }

    public final void ER(int i) {
        bd bdVar = (bd) getItem(i);
        if (bdVar != null && bdVar.field_msgId != 0) {
            this.tJJ = bdVar.field_msgId;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.ioW != null) {
            this.ioW.post(new Runnable() {
                public final void run() {
                    s.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final void i(long j, int i, int i2) {
        if (this.tKm.containsKey(Long.valueOf(j)) && this.tKn.containsKey(Long.valueOf(j))) {
            z.b.a((b.a) ((View) this.tKm.get(Long.valueOf(j))).getTag(), i, i2);
        } else {
            x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }

    public final void u(long j, boolean z) {
        if (this.tKm.containsKey(Long.valueOf(j)) && this.tKn.containsKey(Long.valueOf(j))) {
            z.b.a((b.a) ((View) this.tKm.get(Long.valueOf(j))).getTag(), z);
        } else {
            x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }

    public final void a(long j, bd bdVar, boolean z) {
        if (this.tKm.containsKey(Long.valueOf(j)) && this.tKn.containsKey(Long.valueOf(j))) {
            z.a.a(this.tJh.tTq.getContext(), (b.a) ((View) this.tKm.get(Long.valueOf(j))).getTag(), bdVar, z);
            return;
        }
        x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
    }

    public final void cbR() {
        if (this.ioW != null) {
            this.ioW.post(new 6(this));
        }
    }

    public final void ctP() {
        this.tKi = true;
        ctN();
    }

    public final a ctQ() {
        return this;
    }

    public final void a(a.a aVar) {
        boolean z = false;
        if (!(aVar == null || aVar.enT == 3 || (aVar.enT != 2 && aVar.enT != -1 && aVar.enT != 1))) {
            z = d.b(aVar);
        }
        if (!z) {
            ah.A(new 7(this));
        }
    }

    public final c ctR() {
        return this.hOC;
    }
}
