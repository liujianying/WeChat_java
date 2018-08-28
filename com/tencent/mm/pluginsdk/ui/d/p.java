package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class p {
    private static final f<String, SpannableString> qQB = new f(500);
    String fmS;
    private TextView ih;
    private Context mContext;
    private ArrayList<m> qQC;
    private ArrayList<a> qQD;
    private ArrayList<r> qQE;
    boolean qQF;
    boolean qQG;
    boolean qQH;
    boolean qQI;
    boolean qQJ;
    boolean qQK;
    boolean qQL;
    boolean qQM;
    boolean qQN;
    boolean qQO;
    boolean qQP;
    int qQQ;
    private int qQR;
    boolean qQS;
    Object qQT;

    class a {
        int end;
        int start;

        a(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    public p(Context context) {
        this.qQC = new ArrayList();
        this.qQD = new ArrayList();
        this.qQE = new ArrayList();
        this.ih = null;
        this.qQF = false;
        this.qQG = false;
        this.qQH = false;
        this.qQI = true;
        this.qQJ = true;
        this.qQK = false;
        this.qQL = false;
        this.qQM = false;
        this.qQN = false;
        this.qQO = false;
        this.qQP = true;
        this.qQQ = 0;
        this.qQR = 0;
        this.mContext = null;
        this.qQS = false;
        this.qQC = new ArrayList();
        this.qQD = new ArrayList();
        this.qQE = new ArrayList();
        this.mContext = context;
    }

    public final p h(TextView textView) {
        this.ih = textView;
        if (textView != null) {
            this.mContext = this.ih.getContext();
        }
        return this;
    }

    public final SpannableString a(CharSequence charSequence, int i, boolean z) {
        if (charSequence == null) {
            return new SpannableString("");
        }
        int i2;
        CharSequence charSequence2;
        CharSequence spannableString;
        Iterator it;
        this.qQR = i;
        String str = charSequence + "@" + this.qQR + "@" + this.qQF + "@" + this.qQH + "@" + this.qQI + "@" + this.qQJ + "@" + this.qQQ + "@" + this.qQS + "@" + this.qQM + "@" + this.qQN + "@" + this.qQO;
        if (z) {
            SpannableString spannableString2 = (SpannableString) qQB.get(str);
            if (spannableString2 != null) {
                e(spannableString2);
                f(spannableString2);
                a(spannableString2);
                return spannableString2;
            }
        }
        this.qQC = new ArrayList();
        if (this.qQR <= 0) {
            if (this.ih != null) {
                this.qQR = (int) this.ih.getTextSize();
            } else {
                this.qQR = com.tencent.mm.bp.a.ad(this.mContext, c.NormalTextSize);
            }
        }
        if (this.qQC == null) {
            this.qQC = new ArrayList();
        }
        if (this.qQD == null) {
            this.qQD = new ArrayList();
        }
        this.qQC.clear();
        this.qQD.clear();
        if (charSequence != null) {
            if (q.deW.ddJ == 1) {
                i2 = 1;
            } else if (VERSION.SDK_INT == 16 && bi.aG(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
                i2 = 1;
            }
            if (i2 != 0 && this.qQP && com.tencent.mm.pluginsdk.ui.d.d.a.qPH != null && (com.tencent.mm.pluginsdk.ui.d.d.a.qPH.v(charSequence) || com.tencent.mm.pluginsdk.ui.d.d.a.qPH.u(charSequence))) {
                charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
            if (this.qQF) {
                charSequence = charSequence.toString().contains("data-miniprogram-appid") ? C(charSequence) : B(charSequence);
            }
            if (this.qQM) {
                charSequence = z(charSequence);
            }
            if (this.qQO) {
                charSequence = A(charSequence);
            }
            if (this.qQP || com.tencent.mm.pluginsdk.ui.d.d.a.qPH == null) {
                charSequence2 = charSequence;
            } else {
                charSequence2 = com.tencent.mm.pluginsdk.ui.d.d.a.qPH.g(charSequence, this.qQR);
            }
            if (this.qQI) {
                this.qQD.addAll(D(charSequence2));
            }
            if (this.qQF) {
                this.qQD.addAll(E(charSequence2));
            }
            if (this.qQG) {
                this.qQD.addAll(F(charSequence2));
            }
            if (this.qQL) {
                this.qQD.addAll(J(charSequence2));
            }
            if (this.qQJ) {
                this.qQD.addAll(G(charSequence2));
            }
            if (this.qQH) {
                this.qQD.addAll(H(charSequence2));
            }
            if (this.qQK) {
                this.qQD.addAll(I(charSequence2));
            }
            spannableString = charSequence2 instanceof Spannable ? (SpannableString) charSequence2 : new SpannableString(charSequence2);
            if (this.qQS) {
                Iterator it2 = this.qQC.iterator();
                while (it2.hasNext()) {
                    m mVar = (m) it2.next();
                    mVar.fmS = this.fmS;
                    if (bi.oW(mVar.url)) {
                        spannableString.setSpan(new ForegroundColorSpan(mVar.linkColor), mVar.start, mVar.end, 33);
                    } else if (mVar.start <= spannableString.length() && mVar.end <= spannableString.length()) {
                        spannableString.setSpan(new n(this.qQQ, mVar), mVar.start, mVar.end, 33);
                    }
                }
            }
            it = this.qQE.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.start <= spannableString.length() && rVar.end <= spannableString.length()) {
                    Drawable drawable = this.mContext.getResources().getDrawable(rVar.id);
                    if (rVar.width <= 0 || rVar.height <= 0) {
                        int i3;
                        if (this.ih == null) {
                            i3 = (int) (((float) this.qQR) * 1.3f);
                        } else {
                            i3 = (int) (this.ih.getTextSize() * 1.3f);
                        }
                        drawable.setBounds(0, 0, i3, i3);
                    } else {
                        drawable.setBounds(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.mContext, rVar.width), com.tencent.mm.bp.a.fromDPToPix(this.mContext, rVar.height));
                    }
                    com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
                    aVar.uFY = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 2);
                    spannableString.setSpan(aVar, rVar.start, rVar.start + 1, 18);
                }
            }
            f(spannableString);
            a(spannableString);
            if (z) {
                qQB.m(str, new SpannableString(spannableString));
            }
            return spannableString;
        }
        i2 = 0;
        charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
        if (this.qQF) {
            charSequence = charSequence.toString().contains("data-miniprogram-appid") ? C(charSequence) : B(charSequence);
        }
        if (this.qQM) {
            charSequence = z(charSequence);
        }
        if (this.qQO) {
            charSequence = A(charSequence);
        }
        if (this.qQP) {
        }
        charSequence2 = charSequence;
        if (this.qQI) {
            this.qQD.addAll(D(charSequence2));
        }
        if (this.qQF) {
            this.qQD.addAll(E(charSequence2));
        }
        if (this.qQG) {
            this.qQD.addAll(F(charSequence2));
        }
        if (this.qQL) {
            this.qQD.addAll(J(charSequence2));
        }
        if (this.qQJ) {
            this.qQD.addAll(G(charSequence2));
        }
        if (this.qQH) {
            this.qQD.addAll(H(charSequence2));
        }
        if (this.qQK) {
            this.qQD.addAll(I(charSequence2));
        }
        if (charSequence2 instanceof Spannable) {
        }
        if (this.qQS) {
            Iterator it22 = this.qQC.iterator();
            while (it22.hasNext()) {
                m mVar2 = (m) it22.next();
                mVar2.fmS = this.fmS;
                if (bi.oW(mVar2.url)) {
                    spannableString.setSpan(new ForegroundColorSpan(mVar2.linkColor), mVar2.start, mVar2.end, 33);
                } else if (mVar2.start <= spannableString.length() && mVar2.end <= spannableString.length()) {
                    spannableString.setSpan(new n(this.qQQ, mVar2), mVar2.start, mVar2.end, 33);
                }
            }
        }
        it = this.qQE.iterator();
        while (it.hasNext()) {
            r rVar2 = (r) it.next();
            if (rVar2.start <= spannableString.length() && rVar2.end <= spannableString.length()) {
                Drawable drawable2 = this.mContext.getResources().getDrawable(rVar2.id);
                if (rVar2.width <= 0 || rVar2.height <= 0) {
                    int i32;
                    if (this.ih == null) {
                        i32 = (int) (((float) this.qQR) * 1.3f);
                    } else {
                        i32 = (int) (this.ih.getTextSize() * 1.3f);
                    }
                    drawable2.setBounds(0, 0, i32, i32);
                } else {
                    drawable2.setBounds(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.mContext, rVar2.width), com.tencent.mm.bp.a.fromDPToPix(this.mContext, rVar2.height));
                }
                com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(drawable2);
                aVar2.uFY = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 2);
                spannableString.setSpan(aVar2, rVar2.start, rVar2.start + 1, 18);
            }
        }
        f(spannableString);
        a(spannableString);
        if (z) {
            qQB.m(str, new SpannableString(spannableString));
        }
        return spannableString;
    }

    private static void e(Spannable spannable) {
        int i = 0;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            if (!((spans[i] instanceof com.tencent.mm.ui.widget.a) || (spans[i] instanceof n))) {
                spannable.removeSpan(spans[i]);
            }
            i++;
        }
    }

    private CharSequence z(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPP.matcher(charSequence.toString());
        while (true) {
            Matcher matcher2 = matcher;
            if (!matcher2.find()) {
                return charSequence;
            }
            if (this.qQN) {
                matcher = charSequence.toString().replace(matcher2.group(0), "");
            } else {
                matcher = charSequence.toString().replace(matcher2.group(0), "  ");
                String group = matcher2.group(1);
                int start = matcher2.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    r rVar = new r(start, i, identifier);
                    if (!bi.oW(group) && "original_label".equals(group)) {
                        rVar.height = 15;
                        rVar.width = 35;
                    }
                    this.qQE.add(rVar);
                } else {
                    x.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher2 = com.tencent.mm.pluginsdk.ui.d.i.a.qPK.matcher(matcher);
        }
    }

    private CharSequence A(CharSequence charSequence) {
        int parseColor;
        int i = 0;
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPN.matcher(charSequence);
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Object group4 = matcher.group(3);
            CharSequence replace = charSequence2.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                charSequence2 = replace;
            } else {
                try {
                    parseColor = Color.parseColor(group2);
                } catch (Exception e) {
                    x.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group2);
                    parseColor = 0;
                }
                m mVar;
                if (bi.oW(group3)) {
                    mVar = new m(start, length);
                    mVar.linkColor = parseColor;
                    this.qQC.add(mVar);
                    this.qQD.add(new a(start, length));
                } else {
                    mVar = a.a(this.mContext, group3, start, length, parseColor, parseColor & -1711276033);
                    if (mVar != null) {
                        if (this.qQT != null) {
                            mVar.data = this.qQT;
                        }
                        this.qQC.add(mVar);
                        this.qQD.add(new a(start, length));
                    }
                }
                i = 1;
                charSequence2 = replace;
                matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPN.matcher(replace);
            }
        }
        if (i == 0) {
            Matcher matcher2 = com.tencent.mm.pluginsdk.ui.d.i.a.qPO.matcher(charSequence);
            while (matcher2.find()) {
                CharSequence group5 = matcher2.group(0);
                String group6 = matcher2.group(1);
                Object group7 = matcher2.group(2);
                if (group6.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group5, group7);
                    int start2 = matcher2.start(0);
                    parseColor = group7.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        ah(group6, start2, parseColor);
                        matcher2 = com.tencent.mm.pluginsdk.ui.d.i.a.qPN.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence B(CharSequence charSequence) {
        Matcher matcher;
        CharSequence charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPK.matcher(charSequence2);
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPJ.matcher(charSequence2);
        }
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            Object group3 = matcher.group(2);
            if (group2.length() >= 2) {
                charSequence2 = charSequence2.toString().replace(group, group3);
                int start = matcher.start(0);
                int length = group3.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    ah(group2, start, length);
                    if (charSequence2.length() < 1500) {
                        matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPK.matcher(charSequence2);
                    } else {
                        matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPJ.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence C(CharSequence charSequence) {
        Matcher matcher;
        CharSequence charSequence2;
        CharSequence charSequence3 = charSequence.toString();
        if (charSequence3.length() < 1500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPM.matcher(charSequence3);
            charSequence2 = charSequence3;
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPL.matcher(charSequence3);
            charSequence2 = charSequence3;
        }
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map z = bl.z(group.replace(group2, " ").replace(group3, " "), "a");
            if (z == null) {
                x.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                int i;
                String str = (String) z.get(".a.$data-miniprogram-appid");
                String str2 = (String) z.get(".a.$data-miniprogram-path");
                int i2 = !bi.oW(group2) ? 1 : 0;
                if (bi.oW(str)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i2 == 0 || i != 0) {
                    int length;
                    if (i == 0) {
                        x.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.qQN) {
                        charSequence3 = charSequence2.toString().replace(group, group3);
                        int start = matcher.start(0);
                        length = group3.length() + start;
                        m mVar = new m(group2, 45, null);
                        mVar.start = start;
                        mVar.end = length;
                        this.qQC.add(mVar);
                    } else {
                        Object obj = "    " + group3;
                        String replace = charSequence2.toString().replace(group, obj);
                        length = matcher.start(0);
                        i2 = obj.length() + length;
                        this.qQE.add(new r(length + 1, length + 3, g.spannable_app_brand_link_logo));
                        m mVar2 = new m(str, 45, str2);
                        mVar2.start = length + 4;
                        mVar2.end = i2;
                        this.qQC.add(mVar2);
                        Object obj2 = replace;
                    }
                } else if (group2.length() >= 2) {
                    str = charSequence2.toString().replace(group, group3);
                    int start2 = matcher.start(0);
                    int length2 = group3.length() + start2;
                    if (start2 < 0 || length2 > charSequence.length()) {
                        x.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start2), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                        charSequence2 = str;
                    } else {
                        ah(group2, start2, length2);
                        charSequence3 = str;
                    }
                }
                if (charSequence3.length() < 1500) {
                    matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPM.matcher(charSequence3);
                    charSequence2 = charSequence3;
                } else {
                    matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPL.matcher(charSequence3);
                    charSequence2 = charSequence3;
                }
            }
        }
        return charSequence2;
    }

    private ArrayList<a> D(CharSequence charSequence) {
        int i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        ArrayList<a> arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.d.i.a.qPT;
        if (charSequence.length() <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            m mVar = new m(matcher.group(), 24, null);
            mVar.start = start;
            mVar.end = end;
            if (!a(this.qQD, new a(start, end))) {
                this.qQC.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> E(CharSequence charSequence) {
        Matcher matcher;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPS.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPR.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.qQD, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                m mVar = new m(charSequence2.substring(start, end), 1, this.qQT);
                mVar.start = start;
                mVar.end = end;
                this.qQC.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> F(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= HardCoderJNI.sHCDBDELAY_WRITE) {
            Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPY.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.qQD, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    m mVar = new m(charSequence2.substring(start, end), 44, this.qQT);
                    mVar.start = start;
                    mVar.end = end;
                    this.qQC.add(mVar);
                    arrayList.add(new a(start, end));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<a> G(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPV.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.qQD, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                m mVar = new m(charSequence2.substring(start, end), 28, null);
                mVar.start = start;
                mVar.end = end;
                this.qQC.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> H(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPU.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Object group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains(group)) && i < 24 && !a(this.qQD, new a(start, end))) {
                m mVar = new m(group, 25, this.qQT);
                mVar.start = start;
                mVar.end = end;
                this.qQC.add(mVar);
                arrayList.add(new a(start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> I(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = a.bm(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            a aVar = new a(mVar.start, mVar.end);
            if (!a(this.qQD, aVar)) {
                this.qQC.add(mVar);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a> J(CharSequence charSequence) {
        int start;
        int end;
        a aVar;
        m mVar;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPX.matcher(charSequence2);
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            aVar = new a(start, end);
            if (!a(this.qQD, aVar) && start >= 0 && end <= charSequence2.length()) {
                mVar = new m(charSequence2.substring(start, end), 30, null);
                mVar.start = start;
                mVar.end = end;
                this.qQC.add(mVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.d.i.a.qPW.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(start, end);
                if (!a(this.qQD, aVar) && start >= 0 && end <= charSequence2.length()) {
                    mVar = new m(charSequence2.substring(start, end), 30, null);
                    mVar.start = start;
                    mVar.end = end;
                    this.qQC.add(mVar);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean ah(String str, int i, int i2) {
        m a = a.a(this.mContext, str, i, i2);
        if (a == null) {
            return false;
        }
        if (this.qQT != null) {
            a.data = this.qQT;
        }
        this.qQC.add(a);
        this.qQD.add(new a(i, i2));
        return true;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            a aVar2 = (a) it.next();
            if (aVar2.end <= aVar.start || aVar.end <= aVar2.start) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void f(Spannable spannable) {
        if (this.ih != null && !bi.oW(spannable.toString())) {
            if (af.exL) {
                this.ih.setText(spannable, BufferType.SPANNABLE);
            } else {
                this.ih.setText(spannable);
            }
        }
    }

    private void a(SpannableString spannableString) {
        int i = 0;
        if (this.ih != null) {
            OnTouchListener mVar = new m();
            mVar.fmS = this.fmS;
            this.ih.setOnTouchListener(mVar);
        } else if (spannableString != null) {
            n[] nVarArr = (n[]) spannableString.getSpans(0, spannableString.length(), n.class);
            if (nVarArr != null && nVarArr.length > 0 && this.fmS != null) {
                int length = nVarArr.length;
                while (i < length) {
                    nVarArr[i].setSessionId(this.fmS);
                    i++;
                }
            }
        }
    }

    public static void clearCache() {
        qQB.clear();
    }
}
