package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<lw> {
    public a() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aDH();
        au.HU();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOY, Boolean.valueOf(true))).booleanValue();
        au.HU();
        boolean z = System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sPb, Long.valueOf(0))).longValue() > 86400000 && booleanValue;
        if (z) {
            au.DF().a(new e(), 0);
        }
        ei(false);
        eh(false);
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOU, Boolean.valueOf(false))).booleanValue()) {
            au.HU();
            Object obj = com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOS, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            if (System.currentTimeMillis() - longValue > 86400000) {
                z = true;
                if (z) {
                    au.DF().a(new n(8, 15), 0);
                }
                au.HU();
                if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sPe, Long.valueOf(0))).longValue() > 86400000) {
                    int ln = i.aEA().igx.ln(false);
                    h.mEJ.h(11597, new Object[]{Integer.valueOf(ln)});
                    au.HU();
                    com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPe, Long.valueOf(System.currentTimeMillis()));
                }
                return false;
            }
        }
        z = false;
        if (z) {
            au.DF().a(new n(8, 15), 0);
        }
        au.HU();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sPe, Long.valueOf(0))).longValue() > 86400000) {
            int ln2 = i.aEA().igx.ln(false);
            h.mEJ.h(11597, new Object[]{Integer.valueOf(ln2)});
            au.HU();
            com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPe, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    public static void eh(boolean z) {
        long j;
        au.HU();
        Object obj = com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOR, null);
        if (obj == null || !(obj instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) obj).longValue();
        }
        if ((System.currentTimeMillis() - j > 86400000) || z) {
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[]{Boolean.valueOf(i.aEA().igy.cnq())});
            if (i.aEA().igy.cnq() || z) {
                au.DF().a(new s(i.aEA().igy.cns(), 1), 0);
                return;
            }
            au.HU();
            com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sOU, Boolean.valueOf(true));
        }
    }

    public static void ei(boolean z) {
        int i;
        au.HU();
        boolean i2;
        if (bi.a((Boolean) com.tencent.mm.model.c.DT().get(348165, null), false)) {
            long j;
            au.HU();
            Object obj = com.tencent.mm.model.c.DT().get(348166, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                i2 = 1;
            } else {
                i2 = false;
            }
        } else {
            i2 = false;
        }
        if (i2 != 0 || z) {
            ArrayList cnL = i.aEA().igx.cnL();
            if (cnL.size() > 0) {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[]{Integer.valueOf(cnL.size())});
                List arrayList = new ArrayList();
                int size = cnL.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add(new d((String) cnL.get(i3)));
                    x.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[]{cnL.get(i3)});
                }
                i.aEx().ije.aO(arrayList);
                i.aEx().ije.aEV();
            } else {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                au.HU();
                com.tencent.mm.model.c.DT().set(348165, Boolean.valueOf(false));
            }
            au.HU();
            com.tencent.mm.model.c.DT().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void aDH() {
        int i;
        au.HU();
        boolean a = bi.a((Boolean) com.tencent.mm.model.c.DT().get(348162, null), false);
        au.HU();
        boolean i2;
        if (bi.a((Boolean) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOQ, null), false) || !a) {
            i2 = false;
        } else {
            long j;
            au.HU();
            Object obj = com.tencent.mm.model.c.DT().get(348163, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                i2 = 1;
            } else {
                i2 = false;
            }
        }
        if (i2 != 0) {
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) i.aEA().igx.cnH();
            if (arrayList.size() <= 0) {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                au.HU();
                com.tencent.mm.model.c.DT().set(348162, Boolean.valueOf(false));
                return;
            }
            au.HU();
            com.tencent.mm.model.c.DT().set(348163, Long.valueOf(System.currentTimeMillis()));
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[]{Integer.valueOf(size / 50)});
                for (int i3 = 0; i3 <= r6; i3++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = i3 * 50;
                    int i5 = ((i3 + 1) * 50) + -1 >= size ? size : (i3 + 1) * 50;
                    x.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                    if (i5 > i4) {
                        arrayList2.addAll(arrayList.subList(i4, i5));
                        au.DF().a(new com.tencent.mm.plugin.emoji.f.d(arrayList2), 0);
                    }
                }
                return;
            }
            au.DF().a(new com.tencent.mm.plugin.emoji.f.d(arrayList), 0);
        }
    }
}
