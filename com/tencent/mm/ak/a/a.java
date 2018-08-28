package com.tencent.mm.ak.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ak.a.a.b;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.b.h;
import com.tencent.mm.ak.a.c.d;
import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.ak.a.c.j;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ExecutorService;

public final class a {
    private static a dWR = null;
    public b dWO;
    private b dWP;
    private final i dWQ = new h();

    public static synchronized a Pq() {
        a aVar;
        synchronized (a.class) {
            if (dWR == null) {
                dWR = new a(ad.getContext());
            }
            aVar = dWR;
        }
        return aVar;
    }

    public a(Context context) {
        a(b.bN(context));
    }

    public a(b bVar) {
        a(bVar);
    }

    private synchronized void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("[cpan] image loader configuration is null.");
        } else if (this.dWP == null) {
            this.dWO = new b(bVar);
            this.dWP = bVar;
        } else {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
        }
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, null, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, g gVar) {
        a(str, imageView, null, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, g gVar) {
        a(str, imageView, cVar, iVar, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, e eVar, d dVar, l lVar) {
        a(str, imageView, cVar, null, null, null, eVar, dVar, lVar);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        a(str, imageView, cVar, iVar, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, j jVar, g gVar, e eVar, d dVar, l lVar) {
        c cVar2;
        i iVar2;
        if (cVar == null) {
            cVar2 = this.dWP.dXk;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.dWQ;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        if (imageView == null || cVar2 == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
        } else {
            Object obj = (cVar2.dXR > 0 || cVar2.dXS != null) ? 1 : null;
            if (obj == null) {
                imageView.setBackgroundDrawable(null);
            } else if (cVar2.dXR == 0) {
                imageView.setBackgroundDrawable(cVar2.dXR != 0 ? this.dWP.dXh.getDrawable(cVar2.dXR) : cVar2.dXS);
            } else {
                imageView.setBackgroundResource(cVar2.dXR);
            }
        }
        if (bi.oW(str)) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            a(imageView, cVar2);
            this.dWO.a(cVar3);
            iVar2.a(str, null, cVar2.dYc);
            return;
        }
        ag agVar = cVar2.handler;
        if (agVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            agVar = new ag();
        }
        com.tencent.mm.ak.a.f.b bVar = new com.tencent.mm.ak.a.f.b(str, cVar3, agVar, cVar2, iVar2, jVar, this.dWO, gVar, eVar, dVar, lVar);
        Bitmap ma = this.dWO.ma(bVar.mg(str));
        if (ma == null || ma.isRecycled()) {
            if (imageView != null) {
                a(imageView, cVar2);
            }
            if (bVar.dXk.dXz || !this.dWO.dWT.wc()) {
                Object obj2;
                b bVar2 = this.dWO;
                if (!bi.oW(str)) {
                    String str2 = (String) bVar2.dWV.get(Integer.valueOf(cVar3.Pr()));
                    if (bi.oW(str2) || !str.equals(str2)) {
                        bVar2.dWV.put(Integer.valueOf(cVar3.Pr()), str);
                        obj2 = 1;
                        if (obj2 != null) {
                            b bVar3 = this.dWO;
                            if (!(bVar3.dWW == null || bVar.dYk == null)) {
                                com.tencent.mm.ak.a.f.b bVar4 = (com.tencent.mm.ak.a.f.b) bVar3.dWW.get(Integer.valueOf(bVar.dYk.Pr()));
                                if (!(bVar4 == null || bVar4.dYk == null || bVar.dYk.Pr() != bVar4.dYk.Pr())) {
                                    bVar3.dWT.remove(bVar4);
                                    x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[]{bVar4.url});
                                }
                                bVar3.dWW.put(Integer.valueOf(bVar.dYk.Pr()), bVar);
                            }
                            bVar3 = this.dWO;
                            boolean z = cVar2.dXx;
                            if (((ExecutorService) bVar3.dWS.dXs).isShutdown()) {
                                bVar3.dWT = com.tencent.mm.ak.a.a.a.bf(bVar3.dWS.dXi, bVar3.dWS.dXj);
                            }
                            bVar3.dWT.execute(bVar);
                            if (z && com.tencent.mm.ak.a.g.b.Px()) {
                                bVar3.dWU.execute(new com.tencent.mm.ak.a.f.d());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    b bVar32 = this.dWO;
                    if (!(bVar32.dWW == null || bVar.dYk == null)) {
                        com.tencent.mm.ak.a.f.b bVar42 = (com.tencent.mm.ak.a.f.b) bVar32.dWW.get(Integer.valueOf(bVar.dYk.Pr()));
                        if (!(bVar42 == null || bVar42.dYk == null || bVar.dYk.Pr() != bVar42.dYk.Pr())) {
                            bVar32.dWT.remove(bVar42);
                            x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[]{bVar42.url});
                        }
                        bVar32.dWW.put(Integer.valueOf(bVar.dYk.Pr()), bVar);
                    }
                    bVar32 = this.dWO;
                    boolean z2 = cVar2.dXx;
                    if (((ExecutorService) bVar32.dWS.dXs).isShutdown()) {
                        bVar32.dWT = com.tencent.mm.ak.a.a.a.bf(bVar32.dWS.dXi, bVar32.dWS.dXj);
                    }
                    bVar32.dWT.execute(bVar);
                    if (z2 && com.tencent.mm.ak.a.g.b.Px()) {
                        bVar32.dWU.execute(new com.tencent.mm.ak.a.f.d());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[]{r5});
        if (cVar2.dXI) {
            ma = com.tencent.mm.sdk.platformtools.c.e(ma, cVar2.dXJ);
        }
        if (imageView != null) {
            imageView.setImageBitmap(ma);
        }
        bVar.bv(0);
        if (gVar != null) {
            gVar.a(str, imageView, new com.tencent.mm.ak.a.d.b(ma));
        }
        this.dWO.a(cVar3);
    }

    public final void br(int i) {
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[]{Integer.valueOf(i)});
        if (i == 0 || i == 1) {
            x.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.dWO.dWT.resume();
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.dWO.dWT.pause();
    }

    public final void detach() {
        if (this.dWO != null) {
            b bVar = this.dWO;
            if (bVar.dWS != null) {
                bVar.dWS.dXl.clear();
                bVar.dWS.dXm.Pu();
            }
        }
    }

    public final Bitmap ma(String str) {
        if (this.dWO != null) {
            return this.dWO.ma(str);
        }
        return null;
    }

    public final void j(String str, Bitmap bitmap) {
        if (this.dWO != null) {
            b bVar = this.dWO;
            if (bVar.dWS != null) {
                bVar.dWS.dXl.d(str, bitmap);
            }
        }
    }

    private void a(ImageView imageView, c cVar) {
        if (imageView == null || cVar == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            return;
        }
        Object obj = (cVar.dXN > 0 || cVar.dXO != null) ? 1 : null;
        if (obj != null) {
            if (cVar.dXN == 0) {
                imageView.setImageDrawable(cVar.dXN != 0 ? this.dWP.dXh.getDrawable(cVar.dXN) : cVar.dXO);
            } else {
                imageView.setImageResource(cVar.dXN);
            }
        } else if (cVar.dXV) {
            imageView.setImageDrawable(null);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.ak.a.c.c cVar2) {
        this.dWO.dWT.execute(new com.tencent.mm.ak.a.f.a(str, cVar, this.dWO, cVar2));
    }
}
