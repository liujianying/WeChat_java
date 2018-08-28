package com.tencent.tinker.loader.hotplug.interceptor;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class TinkerHackInstrumentation extends Instrumentation {
    public final Instrumentation vuu;
    public final Object vuv;
    public final Field vuw;

    public static TinkerHackInstrumentation hU(Context context) {
        try {
            Object c = ShareReflectUtil.c(context, null);
            Field b = ShareReflectUtil.b(c, "mInstrumentation");
            Instrumentation instrumentation = (Instrumentation) b.get(c);
            if (instrumentation instanceof TinkerHackInstrumentation) {
                return (TinkerHackInstrumentation) instrumentation;
            }
            return new TinkerHackInstrumentation(instrumentation, c, b);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("see next stacktrace", th);
        }
    }

    public final void cHc() {
        if (!(this.vuw.get(this.vuv) instanceof TinkerHackInstrumentation)) {
            this.vuw.set(this.vuv, this);
        }
    }

    private TinkerHackInstrumentation(Instrumentation instrumentation, Object obj, Field field) {
        this.vuu = instrumentation;
        this.vuv = obj;
        this.vuw = field;
        try {
            a(instrumentation);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        a(context.getClassLoader(), intent);
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        if (a(classLoader, intent)) {
            return super.newActivity(classLoader, intent.getComponent().getClassName(), intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        if (activity != null) {
            ActivityInfo acS = IncrementComponentManager.acS(activity.getClass().getName());
            if (acS != null) {
                a(activity, acS);
            }
        }
        super.callActivityOnCreate(activity, bundle);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        if (activity != null) {
            ActivityInfo acS = IncrementComponentManager.acS(activity.getClass().getName());
            if (acS != null) {
                a(activity, acS);
            }
        }
        super.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        if (activity != null) {
            a(activity.getClass().getClassLoader(), intent);
        }
        super.callActivityOnNewIntent(activity, intent);
    }

    private static boolean a(ClassLoader classLoader, Intent intent) {
        if (intent == null) {
            return false;
        }
        ShareIntentUtil.a(intent, classLoader);
        ComponentName componentName = (ComponentName) intent.getParcelableExtra("tinker_iek_old_component");
        if (componentName == null) {
            new StringBuilder("oldComponent was null, start ").append(intent.getComponent()).append(" next.");
            return false;
        } else if (IncrementComponentManager.acS(componentName.getClassName()) == null) {
            return false;
        } else {
            intent.setComponent(componentName);
            intent.removeExtra("tinker_iek_old_component");
            return true;
        }
    }

    private static void a(Activity activity, ActivityInfo activityInfo) {
        activity.setRequestedOrientation(activityInfo.screenOrientation);
        activity.setTheme(activityInfo.theme);
        try {
            ShareReflectUtil.b(activity, "mActivityInfo").set(activity, activityInfo);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("see next stacktrace.", th);
        }
    }

    private void a(Instrumentation instrumentation) {
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(this, declaredFields[i].get(instrumentation));
        }
    }
}
