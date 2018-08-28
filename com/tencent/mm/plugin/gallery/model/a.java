package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static final int jAd = (d.fS(14) ? 20 : 30);
    public b jAe = new b();
    private a jAf = new a(this, (byte) 0);
    private f<String> jAg = new f();
    private f<b> jAh = new f();
    private volatile boolean jAi = false;

    public final Bitmap b(String str, int i, String str2, long j) {
        if (bi.oW(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.jAe.getBitmap(str);
        if (bitmap != null) {
            x.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
            return bitmap;
        }
        x.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[]{Integer.valueOf(this.jAg.size())});
        if (this.jAg.bb(str)) {
            x.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[]{str});
            aRc();
            return null;
        }
        if (this.jAg.size() > jAd) {
            x.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
            x.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[]{Integer.valueOf(this.jAg.size()), Integer.valueOf(this.jAh.size())});
            if (!this.jAh.isEmpty()) {
                b bVar = (b) this.jAh.aRy();
                if (bVar != null) {
                    this.jAg.bB(bVar.mFilePath);
                }
            }
        }
        this.jAg.add(str);
        this.jAh.add(new b(this, str, i, str2, j));
        aRc();
        return null;
    }

    public final Bitmap CQ(String str) {
        if (bi.oW(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.jAe.getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        x.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
        return bitmap;
    }

    private void aRc() {
        while (!this.jAi) {
            if (this.jAh == null || this.jAh.size() <= 0) {
                x.i("MircoMsg.CacheService", "all job empty");
                if (c.aRg() != null) {
                    c.aRg().z(new Runnable() {
                        public final void run() {
                            b a = a.this.jAe;
                            if (a.jAq != null) {
                                d dVar = a.jAq;
                                if (dVar.iWf) {
                                    dVar.iWf = false;
                                    dVar.aRo();
                                    dVar.aRp();
                                    dVar.qo(-1);
                                    dVar.aRr();
                                }
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|tryStartDocode";
                        }
                    });
                    return;
                }
                return;
            }
            this.jAi = true;
            b bVar = (b) this.jAh.aRy();
            if (bVar == null) {
                x.e("MircoMsg.CacheService", "obj is null");
                this.jAi = false;
            } else {
                a aVar = this.jAf;
                if (c.aRg() == null) {
                    x.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                    return;
                }
                e aRg = c.aRg();
                1 1 = new 1(aVar, bVar);
                ag aRs = aRg.aRs();
                if (aRs == null) {
                    x.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
                    return;
                }
                boolean postAtFrontOfQueueV2 = aRs.postAtFrontOfQueueV2(1);
                x.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[]{Boolean.valueOf(postAtFrontOfQueueV2)});
                return;
            }
        }
        x.w("MircoMsg.CacheService", "is decoding now, wait a minute");
    }

    public final void a(b bVar) {
        b bVar2 = this.jAe;
        if (bVar2.dHo.size() > 64) {
            b bVar3 = (b) bVar2.dHo.remove(0);
            x.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[]{Integer.valueOf(64), bVar3});
        }
        x.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[]{bVar});
        if (!bVar2.dHo.contains(bVar)) {
            x.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[]{bVar});
            bVar2.dHo.add(bVar);
        }
    }
}
