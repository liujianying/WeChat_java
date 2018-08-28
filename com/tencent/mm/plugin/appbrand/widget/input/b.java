package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.c.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.g;
import com.tencent.mm.plugin.appbrand.widget.input.c.g.1;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

enum b {
    ;

    static <Input extends EditText & z> void a(Input input, h hVar) {
        if (input != null && hVar != null) {
            int i;
            if (!(hVar.gLJ == null || hVar.gLJ.floatValue() == input.getTextSize())) {
                input.setTextSize(hVar.gLJ.floatValue());
            }
            if (hVar.gLI != null) {
                input.setTextColor(hVar.gLI.intValue());
            }
            if (hVar.gLH == null) {
                input.setBackground(null);
            } else if (!(input.getBackground() != null && (input.getBackground() instanceof ColorDrawable) && ((ColorDrawable) input.getBackground()).getColor() == hVar.gLH.intValue())) {
                input.setBackground(new ColorDrawable(hVar.gLH.intValue()));
            }
            if (!bi.oW(hVar.gLM)) {
                CharSequence spannableStringBuilder = new SpannableStringBuilder(hVar.gLM);
                int length = hVar.gLM.length();
                spannableStringBuilder.setSpan(new StyleSpan(c.wk(hVar.gLN).style), 0, length, 18);
                if (hVar.gLP != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(hVar.gLP.intValue()), 0, length, 18);
                }
                if (hVar.gLO != null) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(hVar.gLO.intValue(), false), 0, length, 18);
                }
                input.setHint(spannableStringBuilder);
            }
            if (hVar.gLK != null) {
                Typeface create = Typeface.create("sans-serif", c.wk(hVar.gLK).style);
                if (create != null) {
                    input.setTypeface(create);
                }
            }
            g wl = g.wl(hVar.fTI);
            z zVar = (z) input;
            if (zVar != null) {
                switch (1.gMg[wl.ordinal()]) {
                    case 1:
                        zVar.apM();
                        break;
                    case 2:
                        zVar.apN();
                        break;
                    case 3:
                        zVar.apO();
                        break;
                }
            }
            if (af.f(hVar.gLR)) {
                i = 8;
            } else {
                i = 0;
            }
            input.setVisibility(i);
            ((z) input).setFixed(af.f(hVar.gLV));
        }
    }

    static <Input extends EditText & z> void a(Input input, int i, int i2) {
        if (input == null || input.getEditableText() == null) {
            x.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[]{input});
            return;
        }
        int selectionStart;
        if (i <= -2) {
            selectionStart = input.getSelectionStart();
        } else if (i == -1 || i > input.getText().length()) {
            selectionStart = input.getText().length();
        } else {
            selectionStart = i;
        }
        int selectionEnd = i2 <= -2 ? input.getSelectionEnd() : (i2 == -1 || i2 > input.getText().length()) ? input.getText().length() : i2;
        if (selectionStart > selectionEnd) {
            selectionStart = selectionEnd;
        }
        Selection.removeSelection(input.getEditableText());
        input.setSelection(selectionStart, selectionEnd);
    }
}
