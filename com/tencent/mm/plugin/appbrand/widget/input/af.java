package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Method;

public enum af {
    ;
    
    static final Class gJt = null;

    public enum a {
        private static final /* synthetic */ a[] gJv = null;

        static {
            gJv = new a[0];
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) gJv.clone();
        }

        public static void a(Activity activity, View view) {
            if (apT() && activity.getResources().getConfiguration().orientation != 2) {
                activity.getWindow().setFlags(1024, 1024);
                activity.getWindow().addFlags(2048);
                view.setPadding(0, e.eL(activity), 0, 0);
            }
        }

        private static boolean apT() {
            try {
                return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception e) {
                if (Build.DEVICE.equals("mx2")) {
                    return true;
                }
                if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                    return false;
                }
                return false;
            }
        }
    }

    enum b {
        private static final /* synthetic */ b[] gJw = null;

        static {
            gJw = new b[0];
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) gJw.clone();
        }

        static void c(EditText editText) {
            if (editText != null) {
                af.cg(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
            }
        }

        static void setNoSystemInputOnEditText(EditText editText) {
            if (editText != null) {
                if (VERSION.SDK_INT >= 21) {
                    editText.setShowSoftInputOnFocus(false);
                    return;
                }
                Class cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(editText, new Object[]{Boolean.valueOf(false)});
                    method.setAccessible(false);
                } catch (NoSuchMethodException e) {
                    x.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                    try {
                        Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method2.setAccessible(true);
                        method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
                        method2.setAccessible(false);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[]{bi.i(e2)});
                        if (editText.getContext() != null && (editText.getContext() instanceof MMActivity)) {
                            ((MMActivity) editText.getContext()).hideVKB(editText);
                        }
                    }
                } catch (Throwable e22) {
                    x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[]{bi.i(e22)});
                }
            }
        }

        static int a(EditText editText, float f, float f2) {
            if (editText == null) {
                return -1;
            }
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null) {
                return -1;
            }
            Editable editableText = editText.getEditableText();
            if (editableText == null) {
                return -1;
            }
            TextPaint paint = editText.getPaint();
            if (paint == null) {
                return -1;
            }
            int lineStart;
            int i;
            Rect rect = new Rect();
            int i2 = 0;
            loop0:
            while (true) {
                int i3 = i2;
                if (i3 >= layout.getLineCount()) {
                    return -1;
                }
                layout.getLineBounds(i3, rect);
                paddingTop += rect.height();
                if (((float) paddingTop) >= f2) {
                    lineStart = layout.getLineStart(i3);
                    int lineEnd = layout.getLineEnd(i3);
                    RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, lineEnd, RelativeSizeSpan.class);
                    float f3 = 1.0f;
                    if (relativeSizeSpanArr != null) {
                        for (RelativeSizeSpan sizeChange : relativeSizeSpanArr) {
                            f3 = sizeChange.getSizeChange();
                        }
                    }
                    float f4 = f3;
                    String charSequence = editableText.subSequence(lineStart, lineEnd).toString();
                    float[] fArr = new float[charSequence.length()];
                    paint.getTextWidths(charSequence, fArr);
                    f3 = 0.0f;
                    i = 0;
                    while (i < charSequence.length()) {
                        f3 += fArr[i] * f4;
                        if (f3 < f && i != charSequence.length() - 1) {
                            i++;
                        }
                    }
                    continue;
                }
                i2 = i3 + 1;
            }
            return lineStart + i;
        }
    }

    static {
        Class cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[]{e});
        }
        gJt = cls;
    }

    static Spannable r(CharSequence charSequence) {
        CharSequence charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            return (Spannable) charSequence2;
        }
        return new SpannableStringBuilder(charSequence2);
    }

    public static boolean s(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, spanned.length(), gJt);
        if (spans == null || spans.length <= 0) {
            return false;
        }
        return true;
    }

    static boolean bt(Object obj) {
        return gJt.isInstance(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.view.inputmethod.InputMethodManager cg(android.view.View r2) {
        /*
        if (r2 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r2.getContext();
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
    L_0x000c:
        r1 = "input_method";
        r0 = r0.getSystemService(r1);
        r0 = (android.view.inputmethod.InputMethodManager) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.af.cg(android.view.View):android.view.inputmethod.InputMethodManager");
    }

    static boolean f(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
