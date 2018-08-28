package com.tencent.mm.br;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.api.c;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b extends c {
    public static final String sLp = (e.duM + "app_font");
    public static final String sLq = (sLp + File.separator + "color_emoji");
    private static final boolean sLr = (VERSION.SDK_INT < 19);
    private static b sLs;
    private LinkedList<c> gEl;
    private Context mContext = ad.getContext();
    public SparseArray<c> sLA = new SparseArray();
    private SparseArray<c> sLB = new SparseArray();
    private SparseArray<SparseArray<c>> sLC = new SparseArray();
    private SparseArray<String> sLD = null;
    private aa<Integer, Bitmap> sLE = new aa(200);
    private boolean sLF = false;
    private LinkedList<d> sLG;
    private final Factory sLH = new 1(this);
    private int sLt = 0;
    private int sLu;
    private int sLv;
    private int sLw;
    public long sLx = 0;
    private a sLy = new a();
    private SparseArray<c> sLz = new SparseArray();

    private b() {
        if (com.tencent.mm.a.e.cn(sLq)) {
            x.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            cjD();
            j.C(this.mContext, "color_emoji", sLq);
            x.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        init();
        if (a.fi(this.mContext)) {
            this.sLt = a.fromDPToPix(this.mContext, 4);
        } else {
            this.sLt = a.fromDPToPix(this.mContext, 2);
        }
    }

    public static b cjC() {
        if (sLs == null) {
            synchronized (b.class) {
                sLs = new b();
            }
        }
        return sLs;
    }

    public static void cjD() {
        File file = new File(sLp);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void init() {
        Throwable e;
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(new File(sLq));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    this.sLw = dataInputStream.readInt();
                    this.sLx = dataInputStream.readLong();
                    this.sLu = dataInputStream.readInt();
                    this.sLv = ((this.sLu + 4) + 8) + 4;
                    byte[] bArr = new byte[this.sLu];
                    dataInputStream.read(bArr);
                    this.sLy.aG(bArr);
                    cjE();
                    this.sLF = true;
                    x.i("MicroMsg.EmojiHelper", "init time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                                return;
                            }
                        }
                        if (fileInputStream == null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                                throw e22;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                dataInputStream = null;
                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e222, "", new Object[0]);
                        return;
                    }
                }
                if (fileInputStream == null) {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                e222 = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e42, "", new Object[0]);
                        throw e222;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e222;
            }
        } catch (Exception e6) {
            e222 = e6;
            dataInputStream = null;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e222, "", new Object[0]);
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e2222, "", new Object[0]);
                    return;
                }
            }
            if (fileInputStream == null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            e2222 = th3;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e422, "", new Object[0]);
                    throw e2222;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2222;
        }
    }

    public static long Xt(String str) {
        Throwable e;
        DataInputStream dataInputStream;
        InputStream fileInputStream;
        try {
            DataInputStream dataInputStream2;
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e42, "", new Object[0]);
                        throw e3;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    fileInputStream.close();
                    return readLong;
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                    return readLong;
                }
            } catch (IOException e6) {
                e3 = e6;
                dataInputStream = dataInputStream2;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e422) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e422, "", new Object[0]);
                        throw e3;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e7) {
            e3 = e7;
            dataInputStream = null;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e32, "", new Object[0]);
                    return 0;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e32 = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e4222) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e4222, "", new Object[0]);
                    throw e32;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e32;
        }
    }

    public static int Xu(String str) {
        Throwable e;
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    int readInt = dataInputStream.readInt();
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                        return readInt;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        return readInt;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                dataInputStream = null;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e5) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e5 = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                            throw e5;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e5;
                }
            } catch (Throwable th2) {
                e5 = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e222, "", new Object[0]);
                        throw e5;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e5;
            }
        } catch (IOException e6) {
            e5 = e6;
            dataInputStream = null;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e52) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e52, "", new Object[0]);
                    return 0;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return 0;
        } catch (Throwable th3) {
            e52 = th3;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e2222, "", new Object[0]);
                    throw e52;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e52;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        return (SpannableString) a(spannableString, i, pInt, this.sLH);
    }

    public final Spannable a(Spannable spannable, int i, PInt pInt, Factory factory) {
        if (spannable == null || spannable.length() == 0) {
            return spannable;
        }
        String obj = spannable.toString();
        List<a> linkedList = new LinkedList();
        int length = obj.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = obj.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = obj.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c Dg = cjC().Dg(codePointAt2);
            if (Dg != null) {
                linkedList.add(new a(this, Dg, i2, i2 + 1, true));
            } else {
                Dg = cjC().eH(codePointAt2, codePointAt);
                if (Dg != null) {
                    int charCount2;
                    if (Dg.sLM != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    linkedList.add(new a(this, Dg, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            return spannable;
        }
        Spannable newSpannable;
        if (sLr) {
            StringBuilder stringBuilder = new StringBuilder(obj);
            for (a aVar : linkedList) {
                if (!aVar.sLK) {
                    if (aVar.sLJ.sLN == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.sLJ.sLN));
                    }
                }
            }
            newSpannable = factory.newSpannable(stringBuilder.toString());
        } else {
            newSpannable = spannable;
        }
        for (a aVar2 : linkedList) {
            a(newSpannable, cjC().a(aVar2.sLJ, true), aVar2.start, aVar2.end, i);
        }
        pInt.value -= linkedList.size();
        return newSpannable;
    }

    public static boolean Xv(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (cjC().Dg(codePointAt) != null) {
                return true;
            }
            if (cjC().eH(codePointAt, i) != null) {
                return true;
            }
            i = charCount;
        }
        return false;
    }

    public final String Xw(String str) {
        if (bi.oW(str)) {
            return str;
        }
        String d;
        int i;
        if (this.sLD == null) {
            Context context = ad.getContext();
            d = w.d(context.getSharedPreferences(ad.chY(), 0));
            String[] stringArray = d.equals("zh_CN") ? context.getResources().getStringArray(com.tencent.mm.plugin.n.a.a.emoji_name_ch) : (d.equals("zh_TW") || d.equals("zh_HK")) ? context.getResources().getStringArray(com.tencent.mm.plugin.n.a.a.emoji_name_tw) : context.getResources().getStringArray(com.tencent.mm.plugin.n.a.a.emoji_name_en);
            String[] stringArray2 = context.getResources().getStringArray(com.tencent.mm.plugin.n.a.a.emoji_code);
            this.sLD = new SparseArray();
            i = 0;
            while (i < stringArray2.length && i < stringArray.length) {
                this.sLD.put(stringArray2[i].charAt(0), stringArray[i]);
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c Dg = cjC().Dg(codePointAt2);
            if (Dg != null) {
                d = (String) this.sLD.get(Dg.sLN);
                if (d != null) {
                    stringBuilder.append(d);
                } else {
                    stringBuilder.append(this.mContext.getString(h.app_emoji2));
                }
            } else {
                Dg = cjC().eH(codePointAt2, codePointAt);
                if (Dg != null) {
                    if (Dg.sLM != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    d = (String) this.sLD.get(Dg.sLN);
                    if (d != null) {
                        stringBuilder.append(d);
                    } else {
                        stringBuilder.append(this.mContext.getString(h.app_emoji2));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
            aVar.uFY = this.sLt;
            spannable.setSpan(aVar, i, i2, 33);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    public final c eH(int i, int i2) {
        if (this.sLG == null || this.sLG.isEmpty() || this.sLF) {
            this.sLG = new LinkedList(this.sLy.sLn);
            this.sLF = false;
        }
        if (this.sLG == null || this.sLG.isEmpty()) {
            return null;
        }
        Iterator it = this.sLG.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.min || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.sLC.get(i);
        if (sparseArray == null) {
            return null;
        }
        if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            return (c) sparseArray.get(i2);
        }
        return (c) sparseArray.get(0);
    }

    public final c Dg(int i) {
        if (i < 57345 || i > 58679) {
            return null;
        }
        return (c) this.sLz.get(i);
    }

    public final Drawable mg(int i) {
        return a((c) this.sLB.get(i), true);
    }

    public final Drawable a(c cVar, boolean z) {
        if (cVar == null) {
            x.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.sLE.get(Integer.valueOf(cVar.dHJ));
            if (bitmap != null && !bitmap.isRecycled()) {
                return new BitmapDrawable(ad.getContext().getResources(), bitmap);
            }
            byte[] e = com.tencent.mm.a.e.e(sLq, cVar.dHJ + this.sLv, cVar.size);
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length, options);
            if (decodeByteArray != null) {
                decodeByteArray.setDensity(d.CTRL_INDEX);
                this.sLE.put(Integer.valueOf(cVar.dHJ), decodeByteArray);
                return new BitmapDrawable(ad.getContext().getResources(), decodeByteArray);
            }
            String str = "MicroMsg.EmojiHelper";
            String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(cVar.size);
            objArr[1] = Integer.valueOf(e == null ? 0 : e.length);
            x.i(str, str2, objArr);
            if (z) {
                cjC();
                int Xu = Xu(sLq);
                cjC();
                x.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", new Object[]{Integer.valueOf(this.sLw), Long.valueOf(this.sLx), Integer.valueOf(Xu), Long.valueOf(Xt(sLq))});
                if (Xu == this.sLw && r4 > this.sLx) {
                    init();
                    return a(cVar, false);
                }
            }
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
        }
    }

    private void cjE() {
        this.gEl = new LinkedList(this.sLy.sLo);
        if (this.gEl == null || this.gEl.isEmpty()) {
            x.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            return;
        }
        Iterator it = this.gEl.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.sLL != 0) {
                SparseArray sparseArray = (SparseArray) this.sLC.get(cVar.sLL);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.sLC.append(cVar.sLL, sparseArray);
                }
                sparseArray.put(cVar.sLM, cVar);
                if (cVar.sLN != 0) {
                    this.sLz.append(cVar.sLN, cVar);
                }
                if (cVar.sLO != -1) {
                    this.sLA.append(cVar.sLO, cVar);
                }
            } else {
                this.sLB.append(cVar.sLP, cVar);
            }
        }
    }

    public static int cjF() {
        return 1;
    }
}
