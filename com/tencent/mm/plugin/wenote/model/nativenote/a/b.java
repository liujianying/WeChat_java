package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        if (spanned == null || bi.oW(spanned.toString())) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        a(spanned, stringBuilder);
        return stringBuilder.toString();
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder) {
        ArrayList arrayList = new j(spanned).qrn;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int indexOf;
            e eVar = (n) arrayList.get(i);
            Set<r> a = a(spanned, eVar);
            q qVar = null;
            for (r rVar : a) {
                if (rVar.qsK.qtl) {
                    qVar = rVar.qsK;
                    break;
                }
            }
            q qVar2 = q.qtf;
            q qVar3 = qVar2;
            int i2 = 0;
            for (r rVar2 : a) {
                int i3 = (rVar2.qsK.caL() || rVar2.qsK.caM() || rVar2.qsK.caN()) ? 1 : 0;
                i2 += i3;
                q qVar4 = rVar2.qsK;
                boolean z = rVar2.qsK.caL() ? ((d) rVar2.qtr).qsQ : rVar2.qsK.caM() ? ((m) rVar2.qtr).qsQ : rVar2.qsK.caN() ? ((k) rVar2.qtr).qsQ : true;
                qVar2 = z ? q.qtf : qVar4.caL() ? q.qtg : qVar4.caM() ? q.qth : qVar4.caN() ? q.qti : qVar3;
                qVar3 = qVar2;
            }
            a(stack, stringBuilder, new a(qVar3, i2, 0));
            if (qVar3.caN()) {
                k[] kVarArr = (k[]) spanned.getSpans(eVar.Tw, eVar.tK, k.class);
                if (kVarArr.length > 0) {
                    qVar3.qtp = kVarArr[0].qsW;
                    indexOf = qVar3.qtm.indexOf("\"") + 1;
                    i2 = qVar3.qtm.lastIndexOf("\"");
                    if (indexOf < i2) {
                        String substring = qVar3.qtm.substring(indexOf, i2);
                        if (!bi.oW(substring)) {
                            if (!substring.trim().equals(qVar3.qtp ? "1" : "0")) {
                                String str;
                                String str2 = qVar3.qtm;
                                if (qVar3.qtp) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                qVar3.qtm = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            stringBuilder.append(qVar3.qtm);
            if (qVar != null) {
                stringBuilder.append(qVar.qtj);
            }
            indexOf = eVar.Tw;
            int i4 = eVar.tK;
            SortedSet treeSet = new TreeSet(new 1(spanned));
            treeSet.addAll(Arrays.asList(spanned.getSpans(indexOf, i4, CharacterStyle.class)));
            a(spanned, stringBuilder, indexOf, i4, treeSet);
            if (qVar != null) {
                a(stringBuilder, qVar);
                stringBuilder.append(qVar.qtk);
            }
            a(stringBuilder, qVar3);
            stringBuilder.append(qVar3.qtn);
        }
        while (!stack.isEmpty()) {
            a(stack, stringBuilder);
        }
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        while (i < i2) {
            Object obj;
            if (sortedSet.isEmpty()) {
                obj = null;
            } else {
                CharacterStyle obj2 = (CharacterStyle) sortedSet.first();
            }
            int spanStart = obj2 == null ? Integer.MAX_VALUE : spanned.getSpanStart(obj2);
            int spanEnd = obj2 == null ? Integer.MAX_VALUE : spanned.getSpanEnd(obj2);
            if (i < spanStart) {
                a(spanned, stringBuilder, i, Math.min(i2, spanStart));
                i = spanStart;
            } else {
                sortedSet.remove(obj2);
                String toHexString;
                if (obj2 instanceof BoldSpan) {
                    stringBuilder.append("<wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 1) {
                    stringBuilder.append("<wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 2) {
                    stringBuilder.append("<i>");
                } else if (obj2 instanceof UnderlineSpan) {
                    stringBuilder.append("<u>");
                } else if (obj2 instanceof RelativeSizeSpan) {
                    stringBuilder.append("<wx-font style=\"font-size:");
                    stringBuilder.append((float) com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Bu((int) (((RelativeSizeSpan) obj2).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
                    stringBuilder.append("px\">");
                } else if (obj2 instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("<wx-font style=\"font-size:");
                    stringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Bu(((AbsoluteSizeSpan) obj2).getSize()));
                    stringBuilder.append("px\">");
                } else if (obj2 instanceof ForegroundColorSpan) {
                    stringBuilder.append("<wx-font style=\"color:#");
                    toHexString = Integer.toHexString(((ForegroundColorSpan) obj2).getForegroundColor() + 16777216);
                    while (toHexString.length() < 6) {
                        toHexString = "0" + toHexString;
                    }
                    stringBuilder.append(toHexString);
                    stringBuilder.append("\">");
                } else if (obj2 instanceof BackgroundColorSpan) {
                    stringBuilder.append("<wx-font style=\"background-color:#");
                    toHexString = Integer.toHexString(((BackgroundColorSpan) obj2).getBackgroundColor() + 16777216);
                    while (toHexString.length() < 6) {
                        toHexString = "0" + toHexString;
                    }
                    stringBuilder.append(toHexString);
                    stringBuilder.append("\">");
                }
                a(spanned, stringBuilder, Math.max(spanStart, i), Math.min(spanEnd, i2), sortedSet);
                if (obj2 instanceof ForegroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof BackgroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof UnderlineSpan) {
                    stringBuilder.append("</u>");
                } else if (obj2 instanceof BoldSpan) {
                    stringBuilder.append("</wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 2) {
                    stringBuilder.append("</i>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 1) {
                    stringBuilder.append("</wx-b>");
                } else if (obj2 instanceof RelativeSizeSpan) {
                    stringBuilder.append("</wx-font>");
                }
                i = spanEnd;
            }
        }
    }

    public static void a(CharSequence charSequence, StringBuilder stringBuilder, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (charAt == 10) {
                stringBuilder.append("<br/>");
            } else if (charAt == '<') {
                stringBuilder.append("&lt;");
            } else if (charAt == '>') {
                stringBuilder.append("&gt;");
            } else if (charAt == '&') {
                stringBuilder.append("&amp;");
            } else if (charAt == ' ') {
                while (i3 + 1 < i2 && charSequence.charAt(i3 + 1) == ' ') {
                    stringBuilder.append("&nbsp;");
                    i3++;
                }
                stringBuilder.append(' ');
            } else if (charAt < ' ') {
                stringBuilder.append("&#" + charAt + ";");
            } else {
                stringBuilder.append(charAt);
            }
            i3++;
        }
    }

    private static void a(StringBuilder stringBuilder, q qVar) {
        if (qVar.qto && stringBuilder.length() >= 5) {
            int length = stringBuilder.length() - 5;
            int length2 = stringBuilder.length();
            if (stringBuilder.subSequence(length, length2).equals("<br/>")) {
                stringBuilder.delete(length, length2);
            }
        }
    }

    private static Set<r> a(Spanned spanned, e eVar) {
        Set<r> hashSet = new HashSet();
        for (ParagraphStyle paragraphStyle : (ParagraphStyle[]) spanned.getSpans(eVar.Tw, eVar.tK, ParagraphStyle.class)) {
            q a = q.a(paragraphStyle);
            if (a != null) {
                hashSet.add(new r(a, paragraphStyle));
            }
        }
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        while (true) {
            int i = 0;
            q qVar = q.qtf;
            if (!stack.isEmpty()) {
                a aVar2 = (a) stack.peek();
                i = aVar2.qsL;
                qVar = aVar2.qsK;
            }
            if (aVar.qsL > i) {
                aVar.qsM = aVar.qsL - i;
                b(stack, stringBuilder, aVar);
                return;
            } else if (aVar.qsL < i) {
                a((Stack) stack, stringBuilder);
            } else if (aVar.qsK != qVar) {
                aVar.qsM = a((Stack) stack, stringBuilder);
                b(stack, stringBuilder, aVar);
                return;
            } else {
                return;
            }
        }
    }

    private static int a(Stack<a> stack, StringBuilder stringBuilder) {
        int i = 0;
        if (stack.isEmpty()) {
            return 0;
        }
        a aVar = (a) stack.pop();
        String str = aVar.qsK.qtk;
        int i2 = aVar.qsM;
        while (i < i2) {
            stringBuilder.append(str);
            i++;
        }
        return aVar.qsM;
    }

    private static void b(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        String str = aVar.qsK.qtj;
        int i = aVar.qsM;
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        stack.push(aVar);
    }
}
