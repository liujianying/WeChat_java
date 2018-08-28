package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

final class k {
    private static final Class<?>[] Fj = new Class[]{Context.class, AttributeSet.class};
    private static final int[] Fk = new int[]{16843375};
    private static final String[] Fl = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> Fm = new android.support.v4.e.a();
    private final Object[] Fn = new Object[2];

    private static class a implements OnClickListener {
        private final View Fo;
        private final String Fp;
        private Method Fq;
        private Context Fr;

        public a(View view, String str) {
            this.Fo = view;
            this.Fp = str;
        }

        public final void onClick(View view) {
            if (this.Fq == null) {
                for (Context context = this.Fo.getContext(); context != null; context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null) {
                    try {
                        if (!context.isRestricted()) {
                            Method method = context.getClass().getMethod(this.Fp, new Class[]{View.class});
                            if (method != null) {
                                this.Fq = method;
                                this.Fr = context;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                    }
                }
                int id = this.Fo.getId();
                throw new IllegalStateException("Could not find method " + this.Fp + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.Fo.getClass() + (id == -1 ? "" : " with id '" + this.Fo.getContext().getResources().getResourceEntryName(id) + "'"));
            }
            try {
                this.Fq.invoke(this.Fr, new Object[]{view});
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (Throwable e22) {
                throw new IllegalStateException("Could not execute method for android:onClick", e22);
            }
        }
    }

    k() {
    }

    final View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.Fn[0] = context;
            this.Fn[1] = attributeSet;
            View d;
            if (-1 == str.indexOf(46)) {
                for (String d2 : Fl) {
                    d = d(context, str, d2);
                    if (d != null) {
                        return d;
                    }
                }
                this.Fn[0] = null;
                this.Fn[1] = null;
                return null;
            }
            d = d(context, str, null);
            this.Fn[0] = null;
            this.Fn[1] = null;
            return d;
        } catch (Exception e) {
            return null;
        } finally {
            this.Fn[0] = null;
            this.Fn[1] = null;
            return null;
        }
    }

    static void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || z.al(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Fk);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View d(Context context, String str, String str2) {
        Constructor constructor = (Constructor) Fm.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(Fj);
                Fm.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.Fn);
    }

    static Context a(Context context, AttributeSet attributeSet, boolean z) {
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(android.support.v7.a.a.k.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (resourceId == 0) {
            resourceId2 = obtainStyledAttributes.getResourceId(android.support.v7.a.a.k.View_theme, 0);
        } else {
            resourceId2 = resourceId;
        }
        obtainStyledAttributes.recycle();
        if (resourceId2 == 0) {
            return context;
        }
        if ((context instanceof d) && ((d) context).Gt == resourceId2) {
            return context;
        }
        return new d(context, resourceId2);
    }
}
