package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class bj {
    protected DexLoader a = null;

    public bj(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public Object a(Context context) {
        return this.a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, new Object[]{context, this.a.getClassLoader()});
    }

    public void a(Object obj) {
        this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }

    public void a(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        this.a.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, new Object[]{activity, Integer.valueOf(i)});
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        if (obj2 != null) {
            invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, new Object[]{bundle, frameLayout, obj2});
        } else {
            invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, new Object[]{bundle, frameLayout});
        }
        return invokeMethod instanceof Boolean ? ((Boolean) invokeMethod).booleanValue() : false;
    }
}
