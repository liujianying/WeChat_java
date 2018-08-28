package android.support.v4.app;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.provider.Settings.Secure;
import java.util.HashSet;
import java.util.Set;

public final class ag {
    private static final int qm = qu.bC();
    private static final Object qn = new Object();
    private static String qo;
    private static Set<String> qp = new HashSet();
    private static final Object qs = new Object();
    private static h qt;
    public static final b qu;
    public final Context mContext;
    public final NotificationManager qr = ((NotificationManager) this.mContext.getSystemService("notification"));

    private static class a implements i {
        final int id;
        final String packageName;
        final boolean qv = false;
        final String tag = null;

        public a(String str, int i) {
            this.packageName = str;
            this.id = i;
        }

        public final void a(s sVar) {
            if (this.qv) {
                sVar.K(this.packageName);
            } else {
                sVar.b(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.qv);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class g {
        final ComponentName qx;
        final IBinder qy;

        public g(ComponentName componentName, IBinder iBinder) {
            this.qx = componentName;
            this.qy = iBinder;
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            qu = new e();
        } else if (VERSION.SDK_INT >= 5) {
            qu = new d();
        } else {
            qu = new c();
        }
    }

    public static ag L(Context context) {
        return new ag(context);
    }

    private ag(Context context) {
        this.mContext = context;
    }

    public static Set<String> M(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(qo))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (qn) {
                qp = hashSet;
                qo = string;
            }
        }
        return qp;
    }

    public final void a(i iVar) {
        synchronized (qs) {
            if (qt == null) {
                qt = new h(this.mContext.getApplicationContext());
            }
        }
        qt.mHandler.obtainMessage(0, iVar).sendToTarget();
    }
}
