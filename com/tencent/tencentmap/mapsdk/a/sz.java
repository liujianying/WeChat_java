package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class sz {
    private static final int a = Float.floatToRawIntBits(0.0f);
    private static final int b = Float.floatToRawIntBits(-0.0f);

    static {
        Double.doubleToRawLongBits(0.0d);
        Double.doubleToRawLongBits(-0.0d);
        Double.longBitsToDouble(4368491638549381120L);
        Double.longBitsToDouble(4503599627370496L);
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmap2 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap2;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
        } catch (Exception e) {
            return bitmap2;
        }
    }

    public static qv a(qw qwVar) {
        return new qv((int) (qwVar.b() * 1000000.0d), (int) (qwVar.c() * 1000000.0d));
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(sl.a().getPackageName(), 128);
            Object string = applicationInfo.metaData.getString("com.tencent.map.api_key");
            return TextUtils.isEmpty(string) ? applicationInfo.metaData.getString("TencentMapSDK") : string;
        } catch (Exception e) {
            new StringBuilder("error get mapkey:").append(e.getMessage());
            return str;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i++;
            i2++;
        }
        return stringBuilder.toString();
    }

    public static void a(View view, int i) {
        Field field = null;
        for (Method method : View.class.getMethods()) {
            if (method.getName().equals("setLayerType")) {
                break;
            }
        }
        Method method2 = null;
        if (method2 != null) {
            switch (i) {
                case 0:
                    field = View.class.getField("LAYER_TYPE_NONE");
                    break;
                case 1:
                    field = View.class.getField("LAYER_TYPE_SOFTWARE");
                    break;
                case 2:
                    field = View.class.getField("LAYER_TYPE_HARDWARE");
                    break;
            }
            if (field == null) {
                try {
                    field = View.class.getField("LAYER_TYPE_SOFTWARE");
                } catch (Exception e) {
                    return;
                }
            }
            method2.invoke(view, new Object[]{Integer.valueOf(field.getInt(null)), null});
        }
    }

    public static boolean a(float f, float f2) {
        boolean z;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int floatToRawIntBits2 = Float.floatToRawIntBits(0.0f);
        if (((floatToRawIntBits ^ floatToRawIntBits2) & Integer.MIN_VALUE) == 0) {
            z = Math.abs(floatToRawIntBits - floatToRawIntBits2) <= 1;
        } else {
            int i;
            if (floatToRawIntBits < floatToRawIntBits2) {
                i = floatToRawIntBits2 - a;
                floatToRawIntBits -= b;
            } else {
                i = floatToRawIntBits - a;
                floatToRawIntBits = floatToRawIntBits2 - b;
            }
            z = i <= 1 && floatToRawIntBits <= 1 - i;
        }
        return (!z || Float.isNaN(f) || Float.isNaN(0.0f)) ? false : true;
    }

    public static boolean a(qw qwVar, List<qw> list) {
        if (list == null || list.size() < 3 || qwVar == null) {
            return false;
        }
        boolean z = false;
        int size = list.size() - 1;
        int i = 0;
        while (i < list.size()) {
            if (((((qw) list.get(i)).b() < qwVar.b() && ((qw) list.get(size)).b() >= qwVar.b()) || (((qw) list.get(size)).b() < qwVar.b() && ((qw) list.get(i)).b() >= qwVar.b())) && (((qw) list.get(i)).c() <= qwVar.c() || ((qw) list.get(size)).c() <= qwVar.c())) {
                z ^= ((qw) list.get(i)).c() + (((qwVar.b() - ((qw) list.get(i)).b()) / (((qw) list.get(size)).b() - ((qw) list.get(i)).b())) * (((qw) list.get(size)).c() - ((qw) list.get(i)).c())) < qwVar.c() ? 1 : 0;
            }
            z = z;
            size = i;
            i++;
        }
        return z;
    }

    public static final boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }
}
