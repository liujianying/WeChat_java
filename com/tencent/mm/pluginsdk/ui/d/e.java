package com.tencent.mm.pluginsdk.ui.d;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private static int I(View view, int i) {
        if (view instanceof TextView) {
            if (((TextView) view).getLayout() == null) {
                return 0;
            }
            return ((TextView) view).getLayout().getLineEnd(i);
        } else if (!(view instanceof StaticTextView)) {
            return 0;
        } else {
            if (((StaticTextView) view).getTvLayout() == null) {
                return 0;
            }
            return ((StaticTextView) view).getTvLayout().getLineEnd(i);
        }
    }

    public static boolean a(View view, Spanned spanned) {
        if (!(view == null || spanned == null || (!(view instanceof TextView) && !(view instanceof StaticTextView)))) {
            int lineCount = view instanceof TextView ? ((TextView) view).getLineCount() : view instanceof StaticTextView ? ((StaticTextView) view).getLineCount() : 0;
            if (lineCount != 1 || spanned.length() <= 500) {
                for (int i = 1; i < lineCount; i++) {
                    if (I(view, i) - I(view, i - 1) > 500) {
                        x.e("MicroMsg.InvalidTextCheck", "error black dot");
                        return true;
                    }
                }
            } else {
                x.e("MicroMsg.InvalidTextCheck", "error black dot");
                return true;
            }
        }
        return false;
    }
}
