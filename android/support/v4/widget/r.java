package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class r {
    static final f Cp;

    interface f {
        void a(TextView textView, Drawable drawable);

        int b(TextView textView);
    }

    static class b implements f {
        b() {
        }

        public void a(TextView textView, Drawable drawable) {
            textView.setCompoundDrawables(drawable, null, null, null);
        }

        public int b(TextView textView) {
            if (!s.Ct) {
                s.Cs = s.L("mMaxMode");
                s.Ct = true;
            }
            if (s.Cs != null && s.a(s.Cs, textView) == 1) {
                if (!s.Cr) {
                    s.Cq = s.L("mMaximum");
                    s.Cr = true;
                }
                if (s.Cq != null) {
                    return s.a(s.Cq, textView);
                }
            }
            return -1;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Cp = new a();
        } else if (i >= 18) {
            Cp = new d();
        } else if (i >= 17) {
            Cp = new c();
        } else if (i >= 16) {
            Cp = new e();
        } else {
            Cp = new b();
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        Cp.a(textView, drawable);
    }

    public static int b(TextView textView) {
        return Cp.b(textView);
    }
}
