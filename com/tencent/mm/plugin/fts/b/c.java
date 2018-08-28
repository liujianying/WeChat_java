package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.pj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class c extends b implements a, j.a {
    m dhW;
    com.tencent.mm.plugin.fts.a.j iXo;
    com.tencent.mm.plugin.fts.c.c jup;
    boolean juq = false;
    private com.tencent.mm.sdk.b.c jur = new 1(this);
    private com.tencent.mm.sdk.b.c jus = new 2(this);
    private com.tencent.mm.sdk.b.c jut = new com.tencent.mm.sdk.b.c<pj>() {
        {
            this.sFo = pj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            c.this.dhW.a(65574, new 1(this));
            return false;
        }
    };
    com.tencent.mm.sdk.b.c juu = new 4(this);
    al juv = new al(g.Em().lnJ.getLooper(), new 5(this), false);
    com.tencent.mm.plugin.fts.a.a.g.a juw = new 6(this);

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private long cYP;

        public c(long j) {
            this.cYP = j;
        }

        public final boolean execute() {
            c.this.jup.b(com.tencent.mm.plugin.fts.a.c.jqc, this.cYP);
            return true;
        }

        public final String afC() {
            return String.format("{MsgId: %d}", new Object[]{Long.valueOf(this.cYP)});
        }

        public final String getName() {
            return "DeleteMessageTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        com.tencent.mm.plugin.fts.a.a.a kVar;
        switch (iVar.jsn) {
            case 1:
                x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[]{Long.valueOf(e.jqL.jqQ)});
                if (e.jqL.jqQ < 1000000) {
                    kVar = new k(this, iVar);
                    break;
                }
                kVar = new i(this, iVar);
                break;
            case 3:
                kVar = new h(this, iVar);
                break;
            case 10:
                kVar = new j(this, iVar);
                break;
            case 11:
                kVar = new g(this, iVar);
                break;
            default:
                kVar = new k(this, iVar);
                break;
        }
        return this.dhW.a(-65536, kVar);
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
            this.jup = (com.tencent.mm.plugin.fts.c.c) ((n) g.n(n.class)).getFTSIndexStorage(4);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.iXo = ((n) g.n(n.class)).getFTSMainDB();
            this.juu.cht();
            this.jut.cht();
            this.jus.cht();
            this.jur.cht();
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().c(this);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(this, null);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().d(this);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(this);
        this.juu.dead();
        this.jut.dead();
        this.jus.dead();
        this.jur.dead();
        this.jup = null;
        this.dhW = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    public final void a(f fVar, com.tencent.mm.plugin.messenger.foundation.a.a.f.c cVar) {
        if (cVar.lcx.equals("insert")) {
            List arrayList = new ArrayList();
            for (int i = 0; i < cVar.lcy.size(); i++) {
                Object obj;
                bd bdVar = (bd) cVar.lcy.get(i);
                if (bdVar == null || bi.oW(bdVar.field_talker) || bi.oW(bdVar.field_content)) {
                    obj = null;
                } else if (bdVar.field_talker.endsWith("@app")) {
                    obj = null;
                } else if (bdVar.field_talker.contains("@bottle")) {
                    obj = null;
                } else if (bdVar.getType() == 1 || bdVar.aQm() || bdVar.aQo()) {
                    int obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    arrayList.add(bdVar);
                }
            }
            if (arrayList.size() > 0) {
                this.dhW.a(65576, new e(this, arrayList));
            }
        }
    }

    public final void a(String str, l lVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0) {
            if (split[0].equals("delete_id")) {
                this.dhW.a(65576, new c(bi.getLong(split[1], 0)));
            } else if (split[0].equals("delete_talker")) {
                this.dhW.a(65576, new d(this, split[1]));
            } else if (split[0].equals("delete_all") && split[1].equals("message")) {
                this.dhW.a(65576, new b(this, (byte) 0));
            }
        }
    }

    public static List<String> CG(String str) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        List<String> arrayList = new ArrayList();
        String[] split = FTSJNIUtils.icuTokenizer(str).split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < split.length) {
            try {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split[i + 1]).intValue();
                int i2 = intValue2 - intValue;
                int intValue3 = Integer.valueOf(split[i + 2]).intValue();
                String substring = str.substring(intValue, intValue2);
                if (intValue3 < 400 || intValue3 >= 500) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                    if (!(substring.equals("*") || substring.equals(" "))) {
                        arrayList.add(substring);
                    }
                    i += 3;
                } else {
                    if (i2 == 1) {
                        stringBuffer.append(substring);
                    } else {
                        if (stringBuffer.length() > 0) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                        }
                        arrayList.add(substring);
                    }
                    i += 3;
                }
            } catch (Exception e) {
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(stringBuffer.toString());
        }
        x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[]{arrayList, r5});
        return arrayList;
    }
}
