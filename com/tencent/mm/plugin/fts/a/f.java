package com.tencent.mm.plugin.fts.a;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.d.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static final e a(String str, String str2, d dVar) {
        e a = a(dVar);
        a.jrO = TextUtils.concat(new CharSequence[]{str, a.jrO, str2});
        return a;
    }

    public static final SpannableString d(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        b bVar = new b();
        bVar.jrM = 0;
        bVar.jrN = i;
        b(spannableString, bVar, new d());
        return spannableString;
    }

    public static final e a(d dVar) {
        int i;
        e eVar = new e();
        SpannableString spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{dVar.jrD, dVar.jrw, dVar.jrE}));
        eVar.bjW = -1;
        eVar.jrO = spannableString;
        if (bi.K(dVar.jrw) || dVar.jrx == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return eVar;
        }
        List aw;
        String Cv = d.Cv(dVar.jrw.toString());
        ArrayList arrayList = new ArrayList();
        if (dVar.jry) {
            aw = aw(Cv, dVar.jrz);
        } else {
            Object aw2 = arrayList;
        }
        b bVar;
        e b;
        if (dVar.jrx.jrZ.size() == 1 || a(spannableString, dVar)) {
            bVar = new b();
            if (dVar.jrx.jrZ.size() == 1) {
                bVar.jrL = (c) dVar.jrx.jrZ.get(0);
                if (dVar.jry) {
                    a(aw2, bVar, dVar);
                } else {
                    a(Cv, bVar, dVar);
                }
                if (!bVar.isAvailable()) {
                    return eVar;
                }
                try {
                    b = b(spannableString, bVar, dVar);
                } catch (Exception e) {
                    eVar.jrO = spannableString;
                    b = eVar;
                }
                return b;
            }
            for (c cVar : dVar.jrx.jrZ) {
                bVar.jrL = cVar;
                if (dVar.jry) {
                    a(aw2, bVar, dVar);
                } else {
                    a(Cv, bVar, dVar);
                }
                if (bVar.isAvailable()) {
                    try {
                        return b(spannableString, bVar, dVar);
                    } catch (Exception e2) {
                        eVar.jrO = spannableString;
                        return eVar;
                    }
                }
            }
            return eVar;
        }
        b bVar2 = new b();
        bVar2.jrL = new c();
        g.b bVar3 = new g.b();
        bVar3.jsc = g.d.jsh;
        bVar3.content = dVar.jrx.jrW;
        bVar2.jrL.jse.add(bVar3);
        if (dVar.jry) {
            a(aw2, bVar2, dVar);
        } else {
            a(Cv, bVar2, dVar);
        }
        if (bVar2.isAvailable()) {
            try {
                return b(spannableString, bVar2, dVar);
            } catch (Exception e3) {
                eVar.jrO = spannableString;
                return eVar;
            }
        }
        List<b> arrayList2 = new ArrayList();
        for (c cVar2 : dVar.jrx.jrZ) {
            bVar = new b();
            bVar.jrL = cVar2;
            arrayList2.add(bVar);
        }
        for (b bVar22 : arrayList2) {
            if (dVar.jry) {
                a(aw2, bVar22, dVar);
            } else {
                a(Cv, bVar22, dVar);
            }
        }
        for (b bVar222 : arrayList2) {
            if (bVar222.isAvailable()) {
                b = b(spannableString, bVar222, dVar);
                if (b.bjW == 0) {
                    eVar = b;
                }
            }
        }
        return eVar;
    }

    private static boolean a(SpannableString spannableString, d dVar) {
        if (dVar.jrC <= 0.0f || dVar.dug == null || dVar.jrC - (dVar.dug.getTextSize() * 2.0f) >= dVar.dug.measureText(spannableString.toString())) {
            return false;
        }
        return true;
    }

    private static e a(SpannableString spannableString, b bVar, d dVar) {
        e eVar = new e();
        float textSize = dVar.jrC - (dVar.dug.getTextSize() * 2.0f);
        float measureText = dVar.dug.measureText("…");
        float measureText2 = dVar.dug.measureText(spannableString, 0, bVar.jrM);
        float measureText3 = dVar.dug.measureText(spannableString, bVar.jrM, bVar.jrN);
        float measureText4 = dVar.dug.measureText(spannableString, bVar.jrN, spannableString.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            return c(spannableString, bVar, dVar);
        }
        CharSequence spannableString2;
        CharSequence spannableString3;
        if (dVar.jrA == a.jrJ) {
            spannableString2 = new SpannableString(TextUtils.concat(new CharSequence[]{dVar.jrF, spannableString.subSequence(bVar.jrM, bVar.jrN), dVar.jrG}));
        } else {
            Object backgroundColorSpan;
            if (dVar.jrA == a.jrI) {
                backgroundColorSpan = new BackgroundColorSpan(dVar.jrB);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(dVar.jrB);
            }
            spannableString3 = new SpannableString(spannableString.subSequence(bVar.jrM, bVar.jrN));
            try {
                spannableString3.setSpan(backgroundColorSpan, 0, spannableString3.length(), 33);
                spannableString2 = spannableString3;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
                eVar.bjW = -1;
                eVar.jrO = spannableString;
                return eVar;
            }
        }
        if ((measureText2 + measureText3) + measureText < textSize) {
            spannableString3 = new SpannableStringBuilder(spannableString, 0, bVar.jrM);
            spannableString3.append(spannableString2);
            spannableString3.append(TextUtils.ellipsize(spannableString.subSequence(bVar.jrN, spannableString.length()), dVar.dug, (textSize - measureText2) - measureText3, TruncateAt.END));
            eVar.jrO = spannableString3;
        } else if ((measureText + measureText3) + measureText4 < textSize) {
            spannableString3 = new SpannableStringBuilder();
            spannableString3.append(TextUtils.ellipsize(spannableString.subSequence(0, bVar.jrM), dVar.dug, (textSize - measureText3) - measureText4, TruncateAt.START));
            spannableString3.append(spannableString2);
            spannableString3.append(spannableString, bVar.jrN, spannableString.length());
            eVar.jrO = spannableString3;
        } else if ((measureText + measureText3) + measureText >= textSize) {
            spannableString3 = new SpannableStringBuilder();
            spannableString3.append(TextUtils.ellipsize(spannableString2, dVar.dug, textSize, TruncateAt.END));
            eVar.jrO = spannableString3;
        } else {
            spannableString3 = new SpannableStringBuilder();
            textSize = (textSize - measureText3) / 2.0f;
            CharSequence subSequence = spannableString.subSequence(0, bVar.jrM);
            CharSequence subSequence2 = spannableString.subSequence(bVar.jrN, spannableString.length());
            spannableString3.append(TextUtils.ellipsize(subSequence, dVar.dug, textSize, TruncateAt.START));
            spannableString3.append(spannableString2);
            spannableString3.append(TextUtils.ellipsize(subSequence2, dVar.dug, textSize, TruncateAt.END));
            eVar.jrO = spannableString3;
        }
        eVar.bjW = 0;
        return eVar;
    }

    private static e b(SpannableString spannableString, b bVar, d dVar) {
        if (a(spannableString, dVar)) {
            return a(spannableString, bVar, dVar);
        }
        return c(spannableString, bVar, dVar);
    }

    private static e c(SpannableString spannableString, b bVar, d dVar) {
        e eVar = new e();
        if (dVar.jrA == a.jrJ) {
            String spannableString2 = spannableString.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(spannableString2.substring(0, bVar.jrM));
            stringBuffer.append(dVar.jrF);
            stringBuffer.append(spannableString2.substring(bVar.jrM, bVar.jrN));
            stringBuffer.append(dVar.jrG);
            if (bVar.jrN < spannableString2.length()) {
                stringBuffer.append(spannableString2.substring(bVar.jrN, spannableString2.length()));
            }
            eVar.jrO = stringBuffer.toString();
            eVar.bjW = 0;
        } else {
            Object backgroundColorSpan;
            if (dVar.jrA == a.jrI) {
                backgroundColorSpan = new BackgroundColorSpan(dVar.jrB);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(dVar.jrB);
            }
            try {
                spannableString.setSpan(backgroundColorSpan, bVar.jrM, bVar.jrN, 18);
                eVar.jrO = spannableString;
                eVar.bjW = 0;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
                eVar.jrO = spannableString;
                eVar.bjW = -1;
            }
        }
        return eVar;
    }

    private static void a(String str, b bVar, d dVar) {
        String str2;
        if (bVar.jrL != null && bVar.jrL.jse.size() > 0) {
            for (g.b bVar2 : bVar.jrL.jse) {
                if (bVar2.jsc == g.d.jsh) {
                    str2 = bVar2.content;
                    break;
                }
            }
        }
        str2 = null;
        if (!bi.oW(str2)) {
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                bVar.jrM = indexOf;
                bVar.jrN = str2.length() + indexOf;
            }
            if (bVar.isAvailable() && dVar.jrD != null) {
                bVar.jrM += dVar.jrD.length();
                bVar.jrN += dVar.jrD.length();
            }
        }
    }

    private static void a(List<List<String>> list, b bVar, d dVar) {
        g.b bVar2;
        if (dVar.jrz) {
            for (g.b bVar22 : bVar.jrL.jse) {
                if (bVar22.jsc == g.d.jsg) {
                    break;
                }
            }
            bVar22 = null;
            if (bVar22 != null) {
                int f = f(list, bVar22.jsd);
                if (f >= 0) {
                    bVar.jrM = f;
                    bVar.jrN = bVar22.jsd.size() + f;
                }
            } else {
                return;
            }
        }
        for (g.b bVar222 : bVar.jrL.jse) {
            if (bVar222.jsc == g.d.jsf) {
                int f2 = f(list, bVar222.jsd);
                if (f2 >= 0) {
                    bVar.jrM = f2;
                    bVar.jrN = bVar222.jsd.size() + f2;
                    break;
                }
            }
        }
        if (bVar.isAvailable() && dVar.jrD != null) {
            bVar.jrM += dVar.jrD.length();
            bVar.jrN += dVar.jrD.length();
        }
    }

    private static int f(List<List<String>> list, List<String> list2) {
        int i = 0;
        for (int i2 = 0; i2 < (list.size() - list2.size()) + 1; i2++) {
            Object obj;
            while (true) {
                int i3 = i;
                if (i3 >= list2.size()) {
                    int obj2 = 1;
                    i = i3;
                    break;
                }
                List<String> list3 = (List) list.get(i2 + i3);
                String str = (String) list2.get(i3);
                if (!list3.contains(str)) {
                    if (i3 != list2.size() - 1) {
                        obj2 = null;
                        i = 0;
                        break;
                    }
                    for (String startsWith : list3) {
                        if (startsWith.startsWith(str)) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        obj2 = null;
                        i = 0;
                        break;
                    }
                    i = i3 + 1;
                } else {
                    i = i3 + 1;
                }
            }
            if (obj2 != null) {
                return i2;
            }
        }
        return -1;
    }

    private static List<List<String>> aw(String str, boolean z) {
        List<List<String>> arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            List arrayList2 = new ArrayList(2);
            if (g.i(charAt)) {
                String[] strArr = (String[]) g.jrm.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    for (Object obj : strArr) {
                        Object obj2;
                        if (z) {
                            obj2 = obj2.substring(0, 1);
                        }
                        if (!arrayList2.contains(obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    @Deprecated
    public static Spannable a(CharSequence charSequence, String str) {
        e a = a(d.b(charSequence, str));
        if (a.jrO instanceof Spannable) {
            return (Spannable) a.jrO;
        }
        return new SpannableString(a.jrO);
    }
}
