package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class b {
    private static boolean dti = false;
    private static String mPackageName = "";
    private static boolean tfq = false;
    private static boolean tfr = false;

    public static void cQ(String str) {
        mPackageName = str;
    }

    public static final boolean col() {
        return tfr;
    }

    public static final void lp(boolean z) {
        tfr = z;
    }

    private static final Object ZN(String str) {
        try {
            Class cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Throwable e) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
        } catch (Throwable e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
        } catch (Throwable e22) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e22, "ClassNotFoundException", new Object[0]);
        } catch (Throwable e222) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e222, "IllegalAccessException", new Object[0]);
        }
        return null;
    }

    public static final boolean com() {
        if (!dti) {
            Object ZN = ZN("WxSVGCode");
            if (ZN == null) {
                tfq = false;
            } else {
                tfq = ((Boolean) ZN).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(tfq));
            dti = true;
        }
        if (tfq) {
            return false;
        }
        return true;
    }

    public static final Class<?> con() {
        Object ZN = ZN("WxSVGRawClass");
        if (ZN != null) {
            return (Class) ZN;
        }
        return null;
    }

    public static long coo() {
        return System.nanoTime();
    }

    public static long gq(long j) {
        return (System.nanoTime() - j) / 1000;
    }
}
