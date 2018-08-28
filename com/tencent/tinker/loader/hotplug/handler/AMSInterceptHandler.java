package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Method;

public class AMSInterceptHandler implements BinderInvocationHandler {
    private static final int[] vue = new int[]{16842840};
    private static final int vuf;
    private final Context mContext;

    static {
        int intValue;
        if (VERSION.SDK_INT < 27) {
            try {
                intValue = ((Integer) ShareReflectUtil.d(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
            } catch (Throwable th) {
                intValue = 2;
            }
        } else {
            intValue = 2;
        }
        vuf = intValue;
    }

    public AMSInterceptHandler(Context context) {
        Context context2;
        while (true) {
            context2 = context;
            if (!(context2 instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context2).getBaseContext();
            if (context == null) {
                break;
            }
        }
        this.mContext = context2;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        int i = 0;
        String name = method.getName();
        if ("startActivity".equals(name)) {
            return a(obj, method, objArr);
        }
        if ("startActivities".equals(name)) {
            int i2 = 0;
            while (i2 < objArr.length) {
                if (objArr[i2] instanceof Intent[]) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 != -1) {
                Intent[] intentArr = (Intent[]) objArr[i2];
                while (i < intentArr.length) {
                    Intent intent = new Intent(intentArr[i]);
                    aD(intent);
                    intentArr[i] = intent;
                    i++;
                }
            }
            return method.invoke(obj, objArr);
        } else if ("startActivityAndWait".equals(name)) {
            return a(obj, method, objArr);
        } else {
            if ("startActivityWithConfig".equals(name)) {
                return a(obj, method, objArr);
            }
            if ("startActivityAsUser".equals(name)) {
                return a(obj, method, objArr);
            }
            if ("getIntentSender".equals(name)) {
                return b(obj, method, objArr);
            }
            return method.invoke(obj, objArr);
        }
    }

    private Object a(Object obj, Method method, Object[] objArr) {
        int i;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof Intent) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i != -1) {
            Intent intent = new Intent((Intent) objArr[i]);
            aD(intent);
            objArr[i] = intent;
        }
        return method.invoke(obj, objArr);
    }

    private Object b(Object obj, Method method, Object[] objArr) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (objArr[i3] instanceof Intent[]) {
                i = i3;
                break;
            }
        }
        i = -1;
        if (i != -1 && ((Integer) objArr[0]).intValue() == vuf) {
            Intent[] intentArr = (Intent[]) objArr[i];
            while (i2 < intentArr.length) {
                Intent intent = new Intent(intentArr[i2]);
                aD(intent);
                intentArr[i2] = intent;
                i2++;
            }
        }
        return method.invoke(obj, objArr);
    }

    private void aD(Intent intent) {
        String packageName;
        String className;
        String str;
        if (intent.getComponent() != null) {
            packageName = intent.getComponent().getPackageName();
            className = intent.getComponent().getClassName();
            str = packageName;
        } else {
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                resolveActivity = IncrementComponentManager.aC(intent);
            }
            if (resolveActivity == null || resolveActivity.filter == null || !resolveActivity.filter.hasCategory("android.intent.category.DEFAULT")) {
                className = null;
                str = null;
            } else {
                packageName = resolveActivity.activityInfo.packageName;
                className = resolveActivity.activityInfo.name;
                str = packageName;
            }
        }
        if (IncrementComponentManager.acR(className)) {
            ActivityInfo acS = IncrementComponentManager.acS(className);
            packageName = ActivityStubManager.r(className, acS.launchMode, a(acS));
            Parcelable componentName = new ComponentName(str, className);
            ShareIntentUtil.a(intent, this.mContext.getClassLoader());
            intent.putExtra("tinker_iek_old_component", componentName);
            intent.setComponent(new ComponentName(str, packageName));
        }
    }

    private boolean a(ActivityInfo activityInfo) {
        boolean z = false;
        int themeResource = activityInfo.getThemeResource();
        Theme newTheme = this.mContext.getResources().newTheme();
        newTheme.applyStyle(themeResource, true);
        TypedArray typedArray = null;
        try {
            typedArray = newTheme.obtainStyledAttributes(vue);
            z = typedArray.getBoolean(0, false);
            if (typedArray != null) {
                typedArray.recycle();
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return z;
    }
}
