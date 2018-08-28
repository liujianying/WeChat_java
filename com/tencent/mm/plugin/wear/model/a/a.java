package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.c.au;
import com.google.android.gms.c.av;
import com.google.android.gms.c.be;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a.1;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.v.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c$d;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n$a;
import com.google.android.gms.wearable.p;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private c pJK;

    public a() {
        boolean z;
        c cVar = null;
        boolean z2 = true;
        com.google.android.gms.common.api.c.a aVar = new com.google.android.gms.common.api.c.a(ad.getContext());
        com.google.android.gms.common.api.a aVar2 = p.baY;
        aVar.aJZ.put(aVar2, null);
        aVar.aJT.addAll(aVar2.or().ot());
        if (aVar.aJZ.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        w.e(z, "must call addApi() to add at least one API");
        if (aVar.aKb >= 0) {
            o oVar = new o(aVar.mContext.getApplicationContext(), aVar.aKe, aVar.oB(), aVar.aKf, aVar.aKg, aVar.aJZ, aVar.aKh, aVar.aKi, aVar.aKb, -1);
            u a = u.a(aVar.aKa);
            if (a == null) {
                new Handler(aVar.mContext.getMainLooper()).post(new 1(aVar, oVar));
            } else {
                aVar.a(a, oVar);
            }
            cVar = oVar;
        } else if (aVar.aKc >= 0) {
            v c = v.c(aVar.aKa);
            int i = aVar.aKc;
            if (c.getActivity() != null) {
                com.google.android.gms.common.api.v.a dp = c.dp(i);
                if (dp != null) {
                    cVar = dp.aLT;
                }
            }
            if (cVar == null) {
                cVar = new o(aVar.mContext.getApplicationContext(), aVar.aKe, aVar.oB(), aVar.aKf, aVar.aKg, aVar.aJZ, aVar.aKh, aVar.aKi, -1, aVar.aKc);
            }
            i = aVar.aKc;
            c.c cVar2 = aVar.aKd;
            w.j(cVar, "GoogleApiClient instance cannot be null");
            if (c.aLR.indexOfKey(i) >= 0) {
                z2 = false;
            }
            w.d(z2, "Already managing a GoogleApiClient with id " + i);
            c.aLR.put(i, new b(cVar, cVar2, (byte) 0));
            if (c.getActivity() != null) {
                android.support.v4.app.u.DEBUG = false;
                c.getLoaderManager().a(i, c);
            }
        } else {
            cVar = new o(aVar.mContext, aVar.aKe, aVar.oB(), aVar.aKf, aVar.aKg, aVar.aJZ, aVar.aKh, aVar.aKi, -1, -1);
        }
        this.pJK = cVar;
    }

    public final boolean isAvailable() {
        return h.aEp() || h.aEo();
    }

    public final void bSt() {
        this.pJK.disconnect();
        bSu();
    }

    public final c bSu() {
        if (!this.pJK.isConnected()) {
            x.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.pJK.a(TimeUnit.SECONDS).isSuccess()) {
                x.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", new Object[]{Integer.valueOf(this.pJK.a(TimeUnit.SECONDS).aJC)});
            }
        }
        return this.pJK;
    }

    public final byte[] a(Asset asset) {
        c$d c_d = (c$d) p.bdt.a(bSu(), asset).oE();
        if (c_d.oF().isSuccess()) {
            return e.g(c_d.getInputStream());
        }
        x.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[]{Integer.valueOf(c_d.oF().aJC), c_d.oF().aKu});
        return null;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a t(String str, byte[] bArr) {
        HashSet bSv = bSv();
        com.tencent.mm.plugin.wear.model.a.b.a aVar = new com.tencent.mm.plugin.wear.model.a.b.a();
        Iterator it = bSv.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wear.model.a.b.a aVar2;
            String str2 = (String) it.next();
            if (bSu().isConnected()) {
                com.tencent.mm.plugin.wear.model.a.b.a aVar3 = new com.tencent.mm.plugin.wear.model.a.b.a();
                Status oF = ((k.b) p.bdv.a(bSu(), str2, str, bArr).b(TimeUnit.SECONDS)).oF();
                if (!oF.isSuccess()) {
                    aVar3.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    aVar3.Yy = oF.aKu;
                    x.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[]{Integer.valueOf(oF.aJC), oF.aKu});
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                x.d(str3, str4, objArr);
                aVar2 = aVar3;
            } else {
                aVar2 = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
            }
            if (aVar2.code != 0) {
                return aVar2;
            }
        }
        return aVar;
    }

    public final HashSet<String> bSv() {
        HashSet<String> hashSet = new HashSet();
        n$a n_a = (n$a) p.bdw.b(bSu()).oE();
        if (n_a != null) {
            for (m id : n_a.rS()) {
                hashSet.add(id.getId());
            }
        }
        return hashSet;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a u(String str, byte[] bArr) {
        if (!bSu().isConnected()) {
            return new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
        }
        com.google.android.gms.wearable.o oVar = new com.google.android.gms.wearable.o(PutDataRequest.bD(str));
        oVar.bdp.putLong("key_timestamp", System.currentTimeMillis());
        oVar.bdp.a("key_data", Asset.o(bArr));
        i iVar = oVar.bdp;
        av avVar = new av();
        List arrayList = new ArrayList();
        avVar.aZv = au.a(iVar, arrayList);
        com.google.android.gms.c.au.a aVar = new com.google.android.gms.c.au.a(avVar, arrayList);
        oVar.bdq.bdf = be.c(aVar.aZt);
        int size = aVar.aZu.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) aVar.aZu.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    new StringBuilder("asPutDataRequest: adding asset: ").append(num).append(" ").append(asset);
                }
                oVar.bdq.b(num, asset);
                i++;
            }
        }
        p.bdt.a(bSu(), oVar.bdq);
        x.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", new Object[]{r0.aMJ.getPath(), Integer.valueOf(r0.bdf.length)});
        return new com.tencent.mm.plugin.wear.model.a.b.a();
    }

    public final boolean i(Uri uri) {
        p.bdt.b(bSu(), uri);
        x.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[]{uri});
        return true;
    }

    public final boolean bSw() {
        if (bSu().isConnected() && bSv().size() != 0) {
            return true;
        }
        return false;
    }

    public final void finish() {
        this.pJK.disconnect();
    }

    public final void bSx() {
        com.google.android.gms.wearable.h hVar = (com.google.android.gms.wearable.h) p.bdt.a(bSu()).oE();
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.getUri().toString().startsWith("/wechat")) {
                x.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[]{fVar.getUri().toString()});
                p.bdt.b(bSu(), fVar.getUri());
            }
        }
        hVar.release();
    }
}
