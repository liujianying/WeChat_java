package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.e;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public final class a implements l {
    private final List<l> fPX = new LinkedList();
    private final l fPY = new g();

    public static a s(com.tencent.mm.plugin.appbrand.g gVar) {
        return new a(gVar);
    }

    private a(com.tencent.mm.plugin.appbrand.g gVar) {
        l k = aj.k(gVar);
        com.tencent.mm.plugin.appbrand.appstorage.a aVar = new com.tencent.mm.plugin.appbrand.appstorage.a(gVar.mAppId);
        e eVar = new e(new String[]{o.getString(gVar.fcu.uin), gVar.mAppId});
        eVar.fjZ = (gVar.fcu.fqZ > 0 ? gVar.fcu.fqZ : 10) * 1048576;
        this.fPX.add(eVar);
        this.fPX.add(aVar);
        this.fPX.add(k);
        initialize();
    }

    final <T extends l> T B(Class<T> cls) {
        for (l lVar : this.fPX) {
            if (lVar.getClass() == cls) {
                return lVar;
            }
        }
        return null;
    }

    private l tx(String str) {
        if (bi.oW(str)) {
            return this.fPY;
        }
        for (l lVar : this.fPX) {
            if (lVar.bV(str)) {
                return lVar;
            }
        }
        return this.fPY;
    }

    public final j ra(String str) {
        return tx(str).ra(str);
    }

    public final j rf(String str) {
        return tx(str).rf(str);
    }

    public final j rg(String str) {
        return tx(str).rg(str);
    }

    public final j rh(String str) {
        return tx(str).rh(str);
    }

    public final j b(String str, h<List<com.tencent.mm.plugin.appbrand.appstorage.h>> hVar) {
        return tx(str).b(str, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return tx(str).a(str, hVar);
    }

    public final j a(String str, InputStream inputStream, boolean z) {
        return tx(str).a(str, inputStream, z);
    }

    public final j ri(String str) {
        return tx(str).ri(str);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return tx(str).a(str, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return tx(str).a(str, file, z);
    }

    public final File rb(String str) {
        return tx(str).rb(str);
    }

    public final boolean bV(String str) {
        return true;
    }

    public final void initialize() {
        for (l initialize : this.fPX) {
            initialize.initialize();
        }
        this.fPY.initialize();
    }

    public final void release() {
        for (l release : this.fPX) {
            release.release();
        }
        this.fPY.release();
    }
}
