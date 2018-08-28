package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class ReaderWizard {
    private DexLoader a;
    private ReaderCallback b;

    public ReaderWizard(ReaderCallback readerCallback) {
        this.a = null;
        this.b = null;
        this.a = a();
        this.b = readerCallback;
    }

    private static DexLoader a() {
        bi c = o.a(true).c();
        return c != null ? c.b() : null;
    }

    public static Drawable getResDrawable(int i) {
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, new Object[]{Integer.valueOf(i)});
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    public static String getResString(int i) {
        String str = "";
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, new Object[]{Integer.valueOf(i)});
            if (invokeStaticMethod instanceof String) {
                return (String) invokeStaticMethod;
            }
        }
        return str;
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, new Object[]{context});
            if (invokeStaticMethod instanceof Boolean) {
                return ((Boolean) invokeStaticMethod).booleanValue();
            }
        }
        return false;
    }

    public static boolean isSupportExt(String str) {
        DexLoader a = a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, new Object[]{str});
            if (invokeStaticMethod instanceof Boolean) {
                return ((Boolean) invokeStaticMethod).booleanValue();
            }
        }
        return false;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        if (this.a == null) {
            return false;
        }
        Object invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, new Object[]{context, str, Boolean.valueOf(z)});
        return !(invokeMethod instanceof Boolean) ? false : ((Boolean) invokeMethod).booleanValue();
    }

    public void destroy(Object obj) {
        this.b = null;
        if (this.a != null && obj != null) {
            this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        }
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        if (this.a != null) {
            Object[] objArr = new Object[]{new Integer(num.intValue()), obj2, obj3};
            Object obj4 = obj;
            this.a.invokeMethod(obj4, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, objArr);
        }
    }

    public Object getTbsReader() {
        return this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean initTbsReader(Object obj, Context context) {
        if (this.a == null || obj == null) {
            return false;
        }
        Object invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, new Object[]{context, this.a, this});
        return !(invokeMethod instanceof Boolean) ? false : ((Boolean) invokeMethod).booleanValue();
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        if (this.b != null) {
            this.b.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        if (this.a != null) {
            Object[] objArr = new Object[]{new Integer(i), new Integer(i2)};
            Object obj2 = obj;
            this.a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, objArr);
        }
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        if (this.a == null) {
            return false;
        }
        Object invokeMethod = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, new Object[]{context, bundle, frameLayout});
        return !(invokeMethod instanceof Boolean) ? false : ((Boolean) invokeMethod).booleanValue();
    }

    public void userStatistics(Object obj, String str) {
        if (this.a != null) {
            Object obj2 = obj;
            this.a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, new Object[]{str});
        }
    }
}
