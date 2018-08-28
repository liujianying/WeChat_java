package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class i {
    private static final AtomicInteger jsm = new AtomicInteger(0);
    public String bWm = null;
    public ag handler = null;
    public final int id = jsm.incrementAndGet();
    public int jsn = 0;
    public String jso = null;
    public String jsp = null;
    public int[] jsq = null;
    public int[] jsr = null;
    public int jss = Integer.MAX_VALUE;
    public HashSet<String> jst = new HashSet();
    public Comparator<l> jsu = null;
    public l jsv = null;
    public int scene = -1;
    public String talker = null;

    public static i a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<l> comparator, l lVar, ag agVar) {
        i iVar = new i();
        iVar.bWm = str;
        iVar.jso = null;
        iVar.jsq = iArr;
        iVar.jsr = iArr2;
        iVar.jss = i;
        iVar.jst = hashSet;
        iVar.jsu = comparator;
        iVar.jsv = lVar;
        iVar.handler = agVar;
        return iVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.id != ((i) obj).id) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("{id: %d, query: %s}", new Object[]{Integer.valueOf(this.id), this.bWm});
    }
}
