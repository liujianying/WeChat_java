package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public final class k implements w {
    public boolean iWc = true;

    public final boolean t(g gVar) {
        Throwable th;
        InputStream inputStream;
        if (gVar == null) {
            return true;
        }
        if (b.f(gVar)) {
            return true;
        }
        g dy = ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId);
        vx c;
        String str;
        wk wkVar;
        switch (gVar.field_type) {
            case 1:
                return bi.oW(gVar.field_favProto.desc);
            case 2:
            case 8:
                return !new b(b.b(b.c(gVar))).exists();
            case 3:
                if (this.iWc) {
                    return true;
                }
                return false;
            case 4:
                c = b.c(gVar);
                if (new b(b.b(c)).exists()) {
                    return false;
                }
                return bi.oW(c.rzv);
            case 5:
                wr wrVar = gVar.field_favProto.rBG;
                xa xaVar = gVar.field_favProto.rAN;
                str = null;
                if (xaVar != null) {
                    str = xaVar.rCn;
                }
                if (wrVar != null && bi.oW(r0)) {
                    str = wrVar.egr;
                }
                return bi.oW(str);
            case 6:
                return gVar.field_favProto.rAL == null;
            case 7:
                c = b.c(gVar);
                return bi.oW(c.rzv) && bi.oW(c.rzx) && bi.oW(c.rzz) && bi.oW(c.rzz);
            case 10:
                wkVar = gVar.field_favProto.rAP;
                return wkVar == null || bi.oW(wkVar.info);
            case 11:
                wkVar = gVar.field_favProto.rAP;
                return wkVar == null || bi.oW(wkVar.info);
            case 14:
            case 18:
                if (gVar.field_id <= 0 && dy != null) {
                    return true;
                }
                if (gVar.field_type == 18 && (gVar.field_favProto == null || gVar.field_favProto.rBI.size() <= 1)) {
                    return true;
                }
                if (gVar.field_type == 18 && (bi.oW(((vx) gVar.field_favProto.rBI.get(0)).rzo) || bi.oW(((vx) gVar.field_favProto.rBI.get(0)).rzq))) {
                    return true;
                }
                Iterator it = gVar.field_favProto.rBI.iterator();
                while (it.hasNext()) {
                    c = (vx) it.next();
                    if ((c.bjS == 2 || c.bjS == 8 || c.bjS == 15 || c.bjS == 4) && !d.cn(b.b(c))) {
                        return true;
                    }
                }
                return false;
            case 15:
                wu wuVar = gVar.field_favProto.rAR;
                return wuVar == null || bi.oW(wuVar.info);
            case 16:
                if (bi.WU(com.tencent.mm.k.g.AT().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                }
                vx c2 = b.c(gVar);
                b bVar = new b(b.b(c2));
                x.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), bVar.cBX().toString(), Boolean.valueOf(bVar.exists())});
                if (!bVar.exists()) {
                    return true;
                }
                if (Math.abs(c2.rzJ - bVar.length()) <= 16) {
                    return false;
                }
                InputStream o;
                try {
                    o = d.o(bVar.aMJ);
                    try {
                        str = com.tencent.mm.a.g.b(o, 4096);
                        if (o != null) {
                            try {
                                o.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = o;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    o = null;
                    str = null;
                    if (o != null) {
                        try {
                            o.close();
                        } catch (IOException e5) {
                        }
                    }
                    x.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", new Object[]{Long.valueOf(r4), str, Long.valueOf(r6), c2.rzF});
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e32) {
                        }
                    }
                    throw th;
                }
                x.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", new Object[]{Long.valueOf(r4), str, Long.valueOf(r6), c2.rzF});
                return true;
            default:
                return false;
        }
    }

    public static boolean h(vx vxVar) {
        if (vxVar == null) {
            return true;
        }
        switch (vxVar.bjS) {
            case 2:
            case 8:
                if (new b(b.b(vxVar)).exists()) {
                    return false;
                }
                return true;
            case 3:
                return true;
            case 4:
                if (new b(b.b(vxVar)).exists()) {
                    return false;
                }
                return bi.oW(vxVar.rzv);
            case 7:
                if (bi.oW(vxVar.rzv) && bi.oW(vxVar.rzx) && bi.oW(vxVar.rzz) && bi.oW(vxVar.rzz)) {
                    return true;
                }
                return false;
            case 15:
                if (bi.WU(com.tencent.mm.k.g.AT().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                } else if (new b(b.b(vxVar)).exists()) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    public static boolean u(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.field_itemStatus > 0 && !b.g(gVar)) {
            return false;
        }
        g dy = ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId);
        b bVar = new b(b.b(b.c(gVar)));
        switch (gVar.field_type) {
            case 2:
            case 8:
                if (!bVar.exists()) {
                    return true;
                }
                break;
            case 4:
                if (bi.oW(b.c(gVar).rzv) && !bVar.exists()) {
                    return true;
                }
            case 14:
            case 18:
                if (gVar.field_id > 0 || dy == null) {
                    if (gVar.field_favProto != null && gVar.field_favProto.rBI.size() > 1) {
                        Iterator it = gVar.field_favProto.rBI.iterator();
                        while (it.hasNext()) {
                            vx vxVar = (vx) it.next();
                            if (!bi.oW(vxVar.rzo) && !bi.oW(vxVar.rzq) && !d.cn(b.b(vxVar))) {
                                return true;
                            }
                        }
                        break;
                    }
                    return false;
                }
                return false;
                break;
            case 16:
                if (bi.WU(com.tencent.mm.k.g.AT().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return false;
                } else if (!bVar.exists()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
