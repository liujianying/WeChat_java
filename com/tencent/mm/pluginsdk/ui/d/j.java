package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j {
    static LinkedList<g> qPZ = new LinkedList();
    private static boolean qQa = bi.fU(ad.getContext());

    public static void a(g gVar) {
        qPZ.add(gVar);
    }

    public static void b(g gVar) {
        qPZ.remove(gVar);
    }

    public static SpannableString a(TextView textView, Object obj) {
        return a(textView, true, obj);
    }

    public static SpannableString a(TextView textView, boolean z, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQM = true;
        pVar.qQO = true;
        pVar.qQQ = 1;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        p h = pVar.h(textView);
        h.qQJ = true;
        h.qQL = true;
        if (obj != null) {
            h.qQT = obj;
        }
        return h.a(textView.getText(), textSize, z);
    }

    public static SpannableString g(TextView textView, int i) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQQ = i;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        p h = pVar.h(textView);
        if (i == 1) {
            h.qQJ = true;
            h.qQL = true;
        } else if (i == 2) {
            h.qQJ = false;
            h.qQL = false;
        }
        return h.a(textView.getText(), textSize, true);
    }

    public static SpannableString b(TextView textView, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQQ = 1;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        p h = pVar.h(textView);
        h.qQT = obj;
        h.fmS = null;
        h.qQJ = true;
        h.qQL = true;
        return h.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj, String str) {
        p pVar = new p(context);
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQQ = 1;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        pVar = pVar.h(null);
        pVar.qQT = obj;
        pVar.fmS = str;
        pVar.qQJ = true;
        pVar.qQL = true;
        return pVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, true);
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, false);
    }

    public static SpannableString b(Context context, CharSequence charSequence, int i) {
        p pVar = new p(context);
        pVar.qQI = false;
        pVar.qQJ = false;
        pVar.qQF = false;
        pVar.qQK = false;
        pVar.qQQ = i;
        pVar.qQH = false;
        pVar.qQS = false;
        CharSequence a = pVar.a(charSequence, 0, true);
        d(a);
        return a;
    }

    private static void d(Spannable spannable) {
        int i = 0;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        return a(context, charSequence, 0, true);
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        p pVar = new p(context);
        pVar.qQI = false;
        pVar.qQJ = false;
        pVar.qQF = false;
        pVar.qQK = false;
        pVar.qQH = false;
        pVar.qQS = false;
        CharSequence a = pVar.a(charSequence, i, z);
        d(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2) {
        p pVar = new p(context);
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQQ = i2;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        if (i2 == 1) {
            pVar.qQJ = true;
            pVar.qQL = true;
        } else if (i2 == 2) {
            pVar.qQJ = false;
            pVar.qQL = false;
        }
        return pVar.a(charSequence, i, true);
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i) {
        p pVar = new p(context);
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQO = true;
        pVar.qQQ = 1;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        pVar.qQT = null;
        pVar.qQJ = true;
        pVar.qQL = true;
        return pVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        p pVar = new p(context);
        pVar.qQH = true;
        pVar.qQF = true;
        pVar.qQG = qQa;
        pVar.qQO = true;
        pVar.qQQ = 1;
        pVar.qQI = true;
        pVar.qQK = false;
        pVar.qQS = true;
        pVar.qQT = obj;
        pVar.qQJ = true;
        pVar.qQL = true;
        return pVar.a(charSequence, i, false);
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        return b(context, charSequence, i, true);
    }

    public static SpannableString c(Context context, CharSequence charSequence, float f) {
        return b(context, charSequence, (int) f, false);
    }

    private static SpannableString b(Context context, CharSequence charSequence, int i, boolean z) {
        p pVar = new p(context);
        pVar.qQH = false;
        pVar.qQF = true;
        pVar.qQM = true;
        pVar.qQN = z;
        pVar.qQO = true;
        pVar.qQQ = 1;
        pVar.qQI = false;
        pVar.qQK = false;
        pVar.qQJ = false;
        pVar.qQL = false;
        pVar.qQS = false;
        return pVar.a(charSequence, i, true);
    }

    public static String TT(String str) {
        if (bi.oW(str)) {
            return str;
        }
        p pVar = new p(ad.getContext());
        pVar.qQH = false;
        pVar.qQF = true;
        pVar.qQM = true;
        pVar.qQN = true;
        pVar.qQO = true;
        pVar.qQQ = 1;
        pVar.qQI = false;
        pVar.qQK = false;
        pVar.qQJ = false;
        pVar.qQL = false;
        pVar.qQP = false;
        pVar.qQS = false;
        return pVar.a(str, 0, false).toString();
    }

    public static void clearCache() {
        x.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        p.clearCache();
    }

    public static SpannableString g(TextView textView) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.qQH = false;
        pVar.qQF = false;
        pVar.qQG = false;
        pVar.qQI = false;
        pVar.qQK = false;
        pVar.qQS = true;
        p h = pVar.h(textView);
        h.qQJ = false;
        h.qQL = false;
        return h.a(textView.getText(), textSize, false);
    }
}
