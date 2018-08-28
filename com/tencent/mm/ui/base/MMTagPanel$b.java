package com.tencent.mm.ui.base;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.g;
import java.util.LinkedList;
import java.util.List;

public class MMTagPanel$b implements InputFilter {
    int mark;
    final /* synthetic */ MMTagPanel txS;
    List<String> txV = new LinkedList();

    public MMTagPanel$b(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        x.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(MMTagPanel.i(this.txS))});
        this.mark = -1;
        this.txV.clear();
        char[] cArr = new char[(i2 - i)];
        TextUtils.getChars(charSequence, i, i2, cArr, 0);
        if (MMTagPanel.j(this.txS)) {
            int i5 = i;
            while (i5 < i2) {
                if (cArr[i5] == 10 || cArr[i5] == ',' || cArr[i5] == ';' || cArr[i5] == 12289 || cArr[i5] == 65292 || cArr[i5] == 65307) {
                    if (-1 == this.mark) {
                        this.txV.add((spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i5)).trim());
                    } else {
                        this.txV.add(charSequence.subSequence(this.mark, i5).toString().trim());
                    }
                    this.mark = i5 + 1;
                }
                i5++;
            }
            if (MMTagPanel.h(this.txS)) {
                i5 = g.abd(spanned.toString());
                if (MMTagPanel.i(this.txS) && charSequence.equals("\n") && 36 < i5) {
                    this.txV.clear();
                }
            }
            if (this.txV.isEmpty()) {
                return null;
            }
            String charSequence2;
            if (MMTagPanel.e(this.txS) != null) {
                for (final String charSequence22 : this.txV) {
                    if (charSequence22.length() > 0) {
                        this.txS.post(new Runnable() {
                            public final void run() {
                                MMTagPanel.e(MMTagPanel$b.this.txS).zS(charSequence22.trim());
                            }
                        });
                    }
                }
            }
            if (this.mark >= i2) {
                spanned.length();
                charSequence22 = spanned.subSequence(i4, spanned.length()).toString();
            } else {
                charSequence22 = charSequence.subSequence(this.mark, i2).toString() + spanned.subSequence(i4, spanned.length());
            }
            this.txS.post(new Runnable() {
                public final void run() {
                    MMTagPanel.a(MMTagPanel$b.this.txS).setText("");
                    MMTagPanel.a(MMTagPanel$b.this.txS).append(charSequence22);
                }
            });
            return "";
        }
        Object obj = null;
        final StringBuilder stringBuilder = new StringBuilder();
        while (i < i2) {
            if (cArr[i] == 10) {
                obj = 1;
            } else {
                stringBuilder.append(cArr[i]);
            }
            i++;
        }
        if (obj == null) {
            return null;
        }
        CharSequence stringBuilder2 = stringBuilder.toString();
        stringBuilder.insert(0, spanned.subSequence(0, i3));
        stringBuilder.append(spanned.subSequence(i4, spanned.length()));
        this.txS.post(new Runnable() {
            public final void run() {
                MMTagPanel.e(MMTagPanel$b.this.txS).zS(stringBuilder.toString());
            }
        });
        return stringBuilder2;
    }
}
