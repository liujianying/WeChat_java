package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class t {
    private static final LayoutParams ucI = new LayoutParams(-1, -2);

    static /* synthetic */ int aaF(String str) {
        if (str.contains("m")) {
            return 18;
        }
        return str.contains("l") ? 21 : 14;
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        if (linearLayout == null) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (bi.oW(str)) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            return false;
        }
        String str2;
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[]{e.getMessage()});
        }
        int i = 0;
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? "" : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            b x = b.x(map, str2);
            if (x == null) {
                x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = " + str2);
            } else if (x.ucL >= x.ucM) {
                x.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + x.ucL + ", rangeTo = " + x.ucM);
            } else {
                int length;
                int i2 = x.ucL;
                int i3 = x.ucM;
                int i4 = x.fTC;
                boolean z = x.caQ;
                boolean z2 = x.ucJ;
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e2.getMessage()});
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e22.getMessage()});
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e3.getMessage()});
                    }
                }
                i2 = x.ucL;
                i3 = x.ucM;
                length = x.color;
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e32.getMessage()});
                }
            }
            i++;
        }
        x.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = " + i);
        i = 0;
        List arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? "" : String.valueOf(i));
            if (map.containsKey(str2)) {
                a w = a.w(map, str2);
                if (w == null) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = " + str2);
                } else {
                    arrayList.add(w);
                }
                i++;
            } else {
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = " + i);
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                return true;
            }
        }
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (a aVar : list) {
            if (aVar.offset > i) {
                View textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, ucI);
            }
            View textView2 = new TextView(linearLayout.getContext());
            textView2.setText(aaD(aVar.ucK));
            textView2.setSingleLine(true);
            if (aVar.fTC != 14) {
                textView2.setTextSize((float) aVar.fTC);
            }
            if (aVar.caQ) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.ucJ) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(aVar.color);
            linearLayout.addView(textView2, ucI);
            i = aVar.offset;
        }
        if (i >= length) {
            x.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
        } else {
            View textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) a.ad(textView3.getContext(), R.f.HintTextSize));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, ucI);
        }
        return true;
    }

    private static String aaD(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private static int aaE(String str) {
        int i = -16777216;
        if (bi.oW(str)) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
            return i;
        }
    }
}
