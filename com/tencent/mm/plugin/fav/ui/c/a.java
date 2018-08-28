package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<fw> {
    private k iYh;
    private aa<Long, g> jel;

    public a() {
        this.jel = new aa(10);
        this.sFo = fw.class.getName().hashCode();
    }

    private boolean a(fw fwVar) {
        g gVar;
        if (fwVar.bOx.bJA == 0) {
            gVar = null;
        } else if (fwVar.bOx.bOE) {
            gVar = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fwVar.bOx.bJA);
            if (gVar != null) {
                this.jel.put(Long.valueOf(fwVar.bOx.bJA), gVar);
            }
        } else {
            boolean z;
            g gVar2 = (g) this.jel.get(Long.valueOf(fwVar.bOx.bJA));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            if (gVar2 == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            if (gVar2 == null) {
                gVar = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fwVar.bOx.bJA);
                if (gVar != null) {
                    this.jel.put(Long.valueOf(fwVar.bOx.bJA), gVar);
                }
            } else {
                gVar = gVar2;
            }
        }
        x.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[]{Integer.valueOf(fwVar.bOx.opType), Long.valueOf(fwVar.bOx.bJA)});
        if (gVar != null || fwVar.bOx.opType == 3 || fwVar.bOx.opType == 4) {
            switch (fwVar.bOx.opType) {
                case 0:
                    fwVar.bOy.bOF = k.a(fwVar.bOx.bOz, gVar);
                    break;
                case 1:
                    if (this.iYh != null) {
                        this.iYh.b(fwVar.bOx.bOA, fwVar.bOx.bOz, gVar, fwVar.bOx.bOB, fwVar.bOx.width, fwVar.bOx.height);
                        break;
                    }
                    x.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    x.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[]{Boolean.valueOf(fwVar.bOx.bOC)});
                    if (!fwVar.bOx.bOC) {
                        fwVar.bOy.bOF = k.b(fwVar.bOx.bOz, gVar, fwVar.bOx.maxWidth);
                        break;
                    }
                    fwVar.bOy.bOF = k.j(fwVar.bOx.bOz);
                    break;
                case 3:
                    x.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.iYh != null) {
                        this.iYh.destory();
                    }
                    this.iYh = new k(fwVar.bOx.context, 16);
                    break;
                case 4:
                    x.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.iYh != null) {
                        this.iYh.destory();
                        this.iYh = null;
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
