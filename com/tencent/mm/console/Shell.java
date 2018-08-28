package com.tencent.mm.console;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class Shell {
    private static HashMap<String, a> dhs = new HashMap();
    public static IntentFilter dht = new IntentFilter();
    private static Runnable dhu = new 3();
    public Receiver dhr = null;

    static /* synthetic */ void AV() {
    }

    static {
        a("wechat.shell.SET_NEXTRET", new 1());
        a("wechat.shell.SET_LOGLEVEL", new 4());
        a("wechat.shell.SET_CDNTRANS", new a() {
            public final void n(Intent intent) {
                af.exg = intent.getBooleanExtra("value", false);
                x.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[]{Boolean.valueOf(af.exg)});
            }
        });
        a("wechat.shell.SET_DKTEST", new 6());
        a("wechat.shell.NET_DNS_TEST", new a() {
            public final void n(Intent intent) {
                af.exl = intent.getIntExtra("value", 0);
                x.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[]{Integer.toBinaryString(af.exl)});
            }
        });
        a("wechat.shell.IDC_ERROR", new 8());
        a("wechat.shell.SET_DK_WT_TEST", new a() {
            public final void n(Intent intent) {
                af.exq = intent.getStringExtra("acc");
                af.exr = intent.getStringExtra("pass");
                x.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[]{af.exq, af.exr});
            }
        });
        a("wechat.shell.SET_MUTE_ROOM_TEST", new 10());
        a("wechat.shell.HOTPATCH_TEST", new 11());
        a("wechat.shell.EXEC_SQL", new 2());
    }

    private static void a(String str, a aVar) {
        dht.addAction(str);
        dhs.put(str, aVar);
    }
}
