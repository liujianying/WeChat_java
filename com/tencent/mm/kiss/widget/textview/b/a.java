package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;

public class a {
    private static boolean dpg;
    private static boolean duA;
    private static Constructor<StaticLayout> duB;
    private static Object duC;

    @TargetApi(18)
    private static synchronized void Ff() {
        synchronized (a.class) {
            if (!dpg) {
                try {
                    Class cls;
                    if (VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        duC = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader classLoader = a.class.getClassLoader();
                        cls = classLoader.loadClass("android.text.TextDirectionHeuristic");
                        Class loadClass = classLoader.loadClass("android.text.TextDirectionHeuristics");
                        duC = loadClass.getField("FIRSTSTRONG_LTR").get(loadClass);
                    }
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TruncateAt.class, Integer.TYPE, Integer.TYPE});
                    duB = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    dpg = true;
                } catch (NoSuchMethodException e) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", e);
                    duA = true;
                    dpg = true;
                } catch (ClassNotFoundException e2) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", e2);
                    duA = true;
                    dpg = true;
                } catch (NoSuchFieldException e3) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e3);
                    duA = true;
                    dpg = true;
                } catch (IllegalAccessException e4) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e4);
                    duA = true;
                    dpg = true;
                } catch (Exception e5) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", e5);
                    duA = true;
                    dpg = true;
                } catch (Throwable th) {
                    dpg = true;
                }
                x.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + duA);
            }
        }
        return;
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            Ff();
            if (duA) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) duB.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, duC, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            Ff();
            if (duA) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) duB.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, textDirectionHeuristic, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }
}
