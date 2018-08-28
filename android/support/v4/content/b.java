package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class b {
    private static final a qV;

    interface a {
        Intent makeMainActivity(ComponentName componentName);
    }

    static class b implements a {
        b() {
        }

        public Intent makeMainActivity(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class c extends b {
        c() {
        }

        public final Intent makeMainActivity(ComponentName componentName) {
            return Intent.makeMainActivity(componentName);
        }
    }

    static class d extends c {
        d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            qV = new d();
        } else if (i >= 11) {
            qV = new c();
        } else {
            qV = new b();
        }
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        return qV.makeMainActivity(componentName);
    }
}
