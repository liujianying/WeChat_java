package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c implements TagHandler {
    private static final Pattern ayE = Pattern.compile("\\d+");
    private static final Pattern qpC = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> qpD;
    private Stack<a> qpA = new Stack();
    final HashMap<String, String> qpB = new HashMap();

    private static class b {
        int fi;
        String qpE;
        String qpF;
        String qpG;

        private b() {
            this.fi = Integer.MIN_VALUE;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class d extends c {
        d(int i) {
            super(i);
        }
    }

    private static class f extends c {
        f(int i) {
            super(i);
        }
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Object obj;
        int intValue;
        int i;
        boolean z2 = true;
        boolean z3 = false;
        this.qpB.clear();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            declaredField = obj2.getClass().getDeclaredField("data");
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(obj2);
            Field declaredField3 = obj2.getClass().getDeclaredField("length");
            declaredField3.setAccessible(true);
            intValue = ((Integer) declaredField3.get(obj2)).intValue();
            for (i = 0; i < intValue; i++) {
                this.qpB.put(strArr[(i * 5) + 1], strArr[(i * 5) + 4]);
            }
        } catch (Exception e) {
        }
        int spanStart;
        int bZC;
        String str2;
        if (!z) {
            c cVar;
            int length;
            if (str.equalsIgnoreCase("wx-ul")) {
                kq(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                kq(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.qpI) {
                        editable.setSpan(new k(((e) cVar).qpJ, com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bZC(), spanStart == length, false, false), spanStart, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.qpI) {
                        bZC = com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bZC();
                        if (cVar instanceof d) {
                            obj = new m(1, bZC, spanStart == length, false, false);
                        } else {
                            if (spanStart != length) {
                                z2 = false;
                            }
                            obj = new com.tencent.mm.plugin.wenote.model.nativenote.spans.d(bZC, z2, false, false);
                        }
                        editable.setSpan(obj, spanStart, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                bZC = editable.length();
                obj = a(editable, b.class);
                if (obj != null) {
                    intValue = editable.getSpanStart(obj);
                    editable.removeSpan(obj);
                    if (intValue != bZC) {
                        b bVar = (b) obj;
                        if (!TextUtils.isEmpty(bVar.qpG)) {
                            editable.setSpan(new TypefaceSpan(bVar.qpG), intValue, bZC, 33);
                        }
                        if (bVar.fi > 0) {
                            editable.setSpan(new AbsoluteSizeSpan(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Bt(bVar.fi)), intValue, bZC, 33);
                        }
                        if (!TextUtils.isEmpty(bVar.qpE)) {
                            i = Sl(bVar.qpE);
                            if (i != -1) {
                                editable.setSpan(new ForegroundColorSpan(i | -16777216), intValue, bZC, 33);
                            }
                        }
                        if (TextUtils.isEmpty(bVar.qpF)) {
                            z2 = false;
                        }
                        if (z2) {
                            int Sl = Sl(bVar.qpF);
                            if (Sl != -1) {
                                editable.setSpan(new BackgroundColorSpan(Sl | -16777216), intValue, bZC, 33);
                            }
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                BoldSpan boldSpan = new BoldSpan();
                bZC = editable.length();
                obj = a(editable, a.class);
                intValue = editable.getSpanStart(obj);
                editable.removeSpan(obj);
                if (intValue != bZC) {
                    editable.setSpan(boldSpan, intValue, bZC, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.qpB.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            a(false, q.qtg);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            a(true, q.qth);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.qpA.push(new a(q.qti, 1, 1));
            str2 = (String) this.qpB.get("checked");
            if (!bi.oW(str2) && str2.equals("1")) {
                z3 = true;
            }
            a(editable, new e(((a) this.qpA.peek()).qsL, z3));
        } else if (str.equalsIgnoreCase("wx-li")) {
            str2 = (String) this.qpB.get("done");
            if (bi.oW(str2) || !str2.equals("true")) {
                z2 = false;
            }
            if (this.qpA.isEmpty()) {
                obj = new f(0);
            } else {
                a aVar = (a) this.qpA.peek();
                q qVar = aVar.qsK;
                intValue = aVar.qsL;
                obj = qVar.caM() ? new d(intValue) : qVar.caL() ? new f(intValue) : qVar.caN() ? new e(intValue, z2) : null;
            }
            if (obj != null) {
                a(editable, obj);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            String str3;
            String str4;
            intValue = Integer.MIN_VALUE;
            str2 = (String) this.qpB.get("style");
            if (str2 != null) {
                String[] split = str2.toLowerCase(Locale.ENGLISH).split(";");
                spanStart = split.length;
                int i2 = 0;
                str2 = null;
                str3 = null;
                while (i2 < spanStart) {
                    Object obj3 = split[i2];
                    Matcher matcher;
                    if (obj3.startsWith("font-size")) {
                        matcher = ayE.matcher(obj3);
                        if (matcher.find(0)) {
                            try {
                                bZC = Integer.parseInt(obj3.substring(matcher.start(), matcher.end()));
                            } catch (NumberFormatException e2) {
                            }
                        }
                        bZC = intValue;
                    } else if (obj3.startsWith("color")) {
                        matcher = qpC.matcher(obj3);
                        if (matcher.find(0)) {
                            str3 = obj3.substring(matcher.start(), matcher.end());
                        }
                        bZC = intValue;
                    } else {
                        if (obj3.startsWith("background-color")) {
                            matcher = qpC.matcher(obj3);
                            if (matcher.find(0)) {
                                str2 = obj3.substring(matcher.start(), matcher.end());
                                bZC = intValue;
                            }
                        }
                        bZC = intValue;
                    }
                    i2++;
                    intValue = bZC;
                }
                str4 = str2;
            } else {
                str4 = null;
                str3 = null;
            }
            str2 = (String) this.qpB.get("face");
            bZC = editable.length();
            b bVar2 = new b();
            bVar2.fi = intValue;
            bVar2.qpE = str3;
            bVar2.qpF = str4;
            editable.setSpan(bVar2.qpG = str2, bZC, bZC, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            a(editable, new a((byte) 0));
        } else if (str.equalsIgnoreCase("wx-p")) {
            d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            d(editable);
        }
        a.qpy = editable;
    }

    private static void d(Editable editable) {
        int length = editable.length();
        if ((length <= 0 || editable.charAt(length - 1) != 10) && length != 0) {
            editable.append("\n");
        }
    }

    private void a(boolean z, q qVar) {
        if (z) {
            qVar = q.qth;
        }
        a aVar = this.qpA.isEmpty() ? null : (a) this.qpA.peek();
        if (aVar == null) {
            this.qpA.push(new a(qVar, 1, 1));
        } else if (aVar.qsK == qVar) {
            aVar.qsL++;
            aVar.qsM++;
        } else {
            this.qpA.push(new a(qVar, aVar.qsL + 1, 1));
        }
    }

    private void kq(boolean z) {
        while (!this.qpA.isEmpty()) {
            a aVar = (a) this.qpA.peek();
            q qVar = aVar.qsK;
            if (!(z && qVar.caM()) && ((z || !qVar.caL()) && (z || !qVar.caN()))) {
                this.qpA.pop();
            } else {
                int i = aVar.qsM;
                if (i > 1) {
                    aVar.qsM = i - 1;
                    aVar.qsL--;
                    return;
                }
                this.qpA.pop();
                return;
            }
        }
    }

    private static Object a(Editable editable, Class<? extends Object> cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        return spans.length == 0 ? null : spans[spans.length - 1];
    }

    private static void a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    static {
        HashMap hashMap = new HashMap();
        qpD = hashMap;
        hashMap.put("aqua", Integer.valueOf(65535));
        qpD.put("black", Integer.valueOf(0));
        qpD.put("blue", Integer.valueOf(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE));
        qpD.put("fuchsia", Integer.valueOf(16711935));
        qpD.put("green", Integer.valueOf(32768));
        qpD.put("grey", Integer.valueOf(8421504));
        qpD.put("lime", Integer.valueOf(65280));
        qpD.put("maroon", Integer.valueOf(8388608));
        qpD.put("navy", Integer.valueOf(128));
        qpD.put("olive", Integer.valueOf(8421376));
        qpD.put("purple", Integer.valueOf(8388736));
        qpD.put("red", Integer.valueOf(16711680));
        qpD.put("silver", Integer.valueOf(12632256));
        qpD.put("teal", Integer.valueOf(32896));
        qpD.put("white", Integer.valueOf(16777215));
        qpD.put("yellow", Integer.valueOf(16776960));
    }

    @SuppressLint({"DefaultLocale"})
    private static int Sl(String str) {
        Integer num = (Integer) qpD.get(str.toLowerCase());
        if (num != null) {
            return num.intValue();
        }
        if (str == null) {
            return -1;
        }
        try {
            int i;
            int i2;
            int i3;
            String charSequence = str.toString();
            int length = charSequence.length();
            int i4 = 10;
            if ('-' == charSequence.charAt(0)) {
                i = 1;
                i2 = -1;
            } else {
                i = 0;
                i2 = 1;
            }
            if ('0' == charSequence.charAt(i)) {
                if (i == length - 1) {
                    return 0;
                }
                char charAt = charSequence.charAt(i + 1);
                if ('x' == charAt || 'X' == charAt) {
                    i3 = i + 2;
                    i4 = 16;
                } else {
                    i3 = i + 1;
                    i4 = 8;
                }
            } else if ('#' == charSequence.charAt(i)) {
                i3 = i + 1;
                i4 = 16;
            } else {
                i3 = i;
            }
            return Integer.parseInt(charSequence.substring(i3), i4) * i2;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
