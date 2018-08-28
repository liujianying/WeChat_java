package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.af.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock cWJ = null;
    private static WakerLock cWW = null;
    private static Set<Long> cWX = new HashSet();
    private static Lock cWY = new ReentrantLock(false);
    private static byte[] cWZ = new byte[0];
    private static byte[] cXa = new byte[0];
    private static a cXb;
    private static boolean cXc = true;

    public static void xz() {
        x.i("MicroMsg.NotifyReceiver", "markUIShow");
        cXc = false;
        aa.US().edit().putBoolean("is_in_notify_mode", false).commit();
    }

    public static void xA() {
        g.DF().b(138, cXb);
        g.DF().b(39, cXb);
        g.DF().b(268369922, cXb);
        if (cXb == null) {
            cXb = new a();
        }
        g.DF().a(138, cXb);
        g.DF().a(39, cXb);
        g.DF().a(268369922, cXb);
    }

    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[]{intent});
        if (intent != null) {
            if (k.bA(context)) {
                x.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
                return;
            }
            a.hE(intent.getIntExtra("notify_respType", -1));
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            context.startService(intent2);
        }
    }
}
