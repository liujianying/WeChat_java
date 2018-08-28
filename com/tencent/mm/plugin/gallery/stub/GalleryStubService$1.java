package com.tencent.mm.plugin.gallery.stub;

import android.os.Process;
import com.tencent.mm.g.a.il;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.k.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.storage.aa;

class GalleryStubService$1 extends a {
    private int dYK;
    final /* synthetic */ GalleryStubService jBw;

    GalleryStubService$1(GalleryStubService galleryStubService) {
        this.jBw = galleryStubService;
    }

    public final void al(int i, String str) {
        h.mEJ.k(i, str);
    }

    public final void a(String str, String str2, boolean z, int i, boolean z2) {
        if (com.tencent.mm.sdk.b.a.sFg != null) {
            il ilVar = new il();
            ilVar.bRT.bRU = Boolean.valueOf(z);
            ilVar.bRT.imagePath = str;
            ilVar.bRT.bRV = i;
            ilVar.bRT.toUser = str2;
            ilVar.bRT.bRW = Boolean.valueOf(z2);
            com.tencent.mm.sdk.b.a.sFg.m(ilVar);
        }
    }

    public final void aRL() {
        g.vv(19);
    }

    public final int AC() {
        return b.AC();
    }

    public final int AA() {
        return b.AA();
    }

    public final int Az() {
        return b.Az();
    }

    public final boolean fi(boolean z) {
        au.HU();
        return c.DT().getBoolean(aa.a.sVr, z);
    }

    public final int CV(String str) {
        PInt pInt = new PInt();
        t.a(str, pInt, new PInt());
        return pInt.value;
    }

    public final int aRM() {
        HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.dYK);
        return HardCoderJNI.startPerformance(HardCoderJNI.hcAlbumScrollEnable, HardCoderJNI.hcAlbumScrollDelay, HardCoderJNI.hcAlbumScrollCPU, HardCoderJNI.hcAlbumScrollIO, HardCoderJNI.hcAlbumScrollThr ? Process.myTid() : 0, HardCoderJNI.hcAlbumScrollTimeout, 702, HardCoderJNI.hcAlbumScrollAction, "MicroMsg.GalleryStubService");
    }

    public final int qv(int i) {
        int stopPerformace = HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.dYK);
        this.dYK = 0;
        return stopPerformace;
    }
}
