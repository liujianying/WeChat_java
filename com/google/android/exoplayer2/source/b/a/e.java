package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements a<s<c>> {
    public final d atN;
    final com.google.android.exoplayer2.source.a.a atP;
    public final s.a<c> atX;
    public a ats;
    public final IdentityHashMap<a.a, a> avA = new IdentityHashMap();
    public final Handler avB = new Handler();
    final e avC;
    public final List<b> avD = new ArrayList();
    public final r avE = new r("HlsPlaylistTracker:MasterPlaylist");
    public a.a avF;
    b avG;
    public boolean avH;
    public final Uri avy;
    public final int avz;

    public static final class c extends IOException {
        public final String url;

        /* synthetic */ c(String str, byte b) {
            this(str);
        }

        private c(String str) {
            this.url = str;
        }
    }

    public final /* synthetic */ void a(com.google.android.exoplayer2.h.r.c cVar, long j, long j2) {
        a aVar;
        s sVar = (s) cVar;
        c cVar2 = (c) sVar.result;
        boolean z = cVar2 instanceof b;
        if (z) {
            if (((b) cVar2).auM) {
                this.atP.kw();
            }
            List singletonList = Collections.singletonList(new a.a(cVar2.auW, Format.g("0", "application/x-mpegURL")));
            List emptyList = Collections.emptyList();
            aVar = new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        } else {
            aVar = (a) cVar2;
        }
        this.ats = aVar;
        this.avF = (a.a) aVar.auC.get(0);
        List arrayList = new ArrayList();
        arrayList.addAll(aVar.auC);
        arrayList.addAll(aVar.auD);
        arrayList.addAll(aVar.auE);
        n(arrayList);
        a aVar2 = (a) this.avA.get(this.avF);
        if (z) {
            a.a(aVar2, (b) cVar2);
        } else {
            aVar2.lg();
        }
        this.atP.a(sVar.asJ, j, j2, sVar.aBT);
    }

    public e(Uri uri, d dVar, com.google.android.exoplayer2.source.a.a aVar, int i, e eVar, s.a<c> aVar2) {
        this.avy = uri;
        this.atN = dVar;
        this.atP = aVar;
        this.avz = i;
        this.avC = eVar;
        this.atX = aVar2;
    }

    public final b c(a.a aVar) {
        b bVar = ((a) this.avA.get(aVar)).avL;
        if (bVar != null && aVar != this.avF && this.ats.auC.contains(aVar) && (this.avG == null || !this.avG.auM)) {
            this.avF = aVar;
            ((a) this.avA.get(this.avF)).lg();
        }
        return bVar;
    }

    public final void d(a.a aVar) {
        a aVar2 = (a) this.avA.get(aVar);
        aVar2.avJ.kC();
        if (aVar2.avR != null) {
            throw aVar2.avR;
        }
    }

    private void n(List<a.a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.a aVar = (a.a) list.get(i);
            this.avA.put(aVar, new a(this, aVar));
        }
    }

    static b.a a(b bVar, b bVar2) {
        int i = bVar2.auJ - bVar.auJ;
        List list = bVar.auP;
        return i < list.size() ? (b.a) list.get(i) : null;
    }
}
