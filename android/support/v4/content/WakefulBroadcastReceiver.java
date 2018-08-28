package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> rl = new SparseArray();
    private static int rm = 1;

    public static ComponentName b(Context context, Intent intent) {
        synchronized (rl) {
            int i = rm;
            int i2 = rm + 1;
            rm = i2;
            if (i2 <= 0) {
                rm = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            rl.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean b(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (rl) {
            WakeLock wakeLock = (WakeLock) rl.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                rl.remove(intExtra);
                return true;
            }
            return true;
        }
    }
}
