package com.tencent.mm.platformtools;

import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class b {
    public static final HashSet<com.tencent.mm.plugin.account.a.a.b> evt = new HashSet();
    private static final com.tencent.mm.plugin.account.a.a.b evu = new 1();
    private static Thread thread = null;

    public static boolean Vn() {
        return syncAddrBook(evu);
    }

    public static boolean syncAddrBook(final com.tencent.mm.plugin.account.a.a.b bVar) {
        final long id = Thread.currentThread().getId();
        if (l.XF()) {
            ah.A(new Runnable() {
                public final void run() {
                    boolean z = b.thread != null && b.thread.isAlive();
                    x.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(b.evt.size()), Long.valueOf(id), bVar});
                    b.evt.add(bVar);
                    if (!z) {
                        b.thread = e.d(new a((byte) 0), "AddrBookSyncHelper_addrBookRead", 1);
                        l.Xz();
                        b.thread.start();
                    }
                }
            });
            return true;
        }
        x.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[]{Boolean.valueOf(l.XF())});
        return false;
    }

    public static boolean Vo() {
        return a.dRw;
    }
}
