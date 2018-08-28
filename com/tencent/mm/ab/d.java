package com.tencent.mm.ab;

import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.concurrent.ConcurrentHashMap;

public interface d {

    public static class a {
        public by dIN;
        public boolean dIO = false;
        public boolean dIP = false;
        public boolean dIQ = false;

        public a(by byVar, boolean z, boolean z2, boolean z3) {
            this.dIN = byVar;
            this.dIO = z;
            this.dIP = z2;
            this.dIQ = z3;
        }

        public final String toString() {
            return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.dIO), Boolean.valueOf(this.dIP), Boolean.valueOf(this.dIQ)});
        }
    }

    public static class b {
        public bd bGS;
        public boolean dIR;

        public b(bd bdVar, boolean z) {
            this.bGS = bdVar;
            this.dIR = z;
        }
    }

    public static class c {
        private static ConcurrentHashMap<Object, d> dIS = new ConcurrentHashMap();

        public static void a(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, dVar);
            dIS.put(obj, dVar);
        }

        public static void b(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, dVar);
            dIS.remove(obj);
        }

        public static d ba(Object obj) {
            return (d) dIS.get(obj);
        }
    }

    b b(a aVar);

    void h(bd bdVar);
}
