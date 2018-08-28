package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;

public final class v {
    private static final a pk;

    interface a {
        String a(Context context, ActivityInfo activityInfo);

        boolean a(Activity activity, Intent intent);

        Intent b(Activity activity);

        void b(Activity activity, Intent intent);
    }

    static class b implements a {
        b() {
        }

        public Intent b(Activity activity) {
            String c = v.c(activity);
            if (c == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, c);
            try {
                return v.b((Context) activity, componentName) == null ? android.support.v4.content.b.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                new StringBuilder("getParentActivityIntent: bad parentActivityName '").append(c).append("' in manifest");
                return null;
            }
        }

        public boolean a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class c extends b {
        c() {
        }

        public final Intent b(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent == null) {
                return super.b(activity);
            }
            return parentActivityIntent;
        }

        public final boolean a(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }

        public final void b(Activity activity, Intent intent) {
            activity.navigateUpTo(intent);
        }

        public final String a(Context context, ActivityInfo activityInfo) {
            String str = activityInfo.parentActivityName;
            if (str == null) {
                return super.a(context, activityInfo);
            }
            return str;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            pk = new c();
        } else {
            pk = new b();
        }
    }

    public static boolean a(Activity activity, Intent intent) {
        return pk.a(activity, intent);
    }

    public static void b(Activity activity, Intent intent) {
        pk.b(activity, intent);
    }

    public static Intent b(Activity activity) {
        return pk.b(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? android.support.v4.content.b.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String c(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        return pk.a(context, context.getPackageManager().getActivityInfo(componentName, FileUtils.S_IWUSR));
    }
}
