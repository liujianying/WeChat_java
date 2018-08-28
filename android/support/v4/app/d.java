package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class d {
    private static final b mv;

    private static class b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public String permissionToOp(String str) {
            return null;
        }

        public int c(Context context, String str, String str2) {
            return 1;
        }
    }

    private static class a extends b {
        private a() {
            super();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String permissionToOp(String str) {
            return AppOpsManager.permissionToOp(str);
        }

        public final int c(Context context, String str, String str2) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            mv = new a();
        } else {
            mv = new b();
        }
    }

    public static String permissionToOp(String str) {
        return mv.permissionToOp(str);
    }

    public static int c(Context context, String str, String str2) {
        return mv.c(context, str, str2);
    }
}
