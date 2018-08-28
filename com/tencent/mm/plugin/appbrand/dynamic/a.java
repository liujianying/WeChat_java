package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String doU;
    public String fuc;
    h fud;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$2 */
    class AnonymousClass2 implements c<Bundle> {
        final /* synthetic */ String sk;

        public AnonymousClass2(String str) {
            this.sk = str;
        }

        public final /* synthetic */ void at(Object obj) {
            k.sB(this.sk);
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            c cVar2 = null;
            String string = ((Bundle) obj).getString("id");
            d aeQ = d.aeQ();
            if (bi.oW(string)) {
                x.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                c cVar3 = (c) aeQ.fuE.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                objArr[1] = cVar3 != null ? Integer.valueOf(cVar3.hashCode()) : null;
                x.d(str, str2, objArr);
                if (cVar3 != null) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                x.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            } else {
                b.o(new 1(this, cVar2, string, cVar));
            }
        }
    }

    public a(h hVar) {
        this.fud = hVar;
    }
}
