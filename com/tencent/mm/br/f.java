package com.tencent.mm.br;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class f {
    private static volatile f sLW = null;
    public static Pattern sMh;
    private static final Comparator<a> sMi = new 1();
    public String[] sLX = null;
    public String[] sLY = null;
    public String[] sLZ = null;
    public String[] sMa = null;
    public String[] sMb = null;
    public String[] sMc = null;
    public ArrayList<q> sMd;
    private a[] sMe = null;
    private HashMap<String, q> sMf = new HashMap();
    private SparseArray<String> sMg = new SparseArray();

    private f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.sLX = context.getResources().getStringArray(a.smiley_values);
        this.sLY = context.getResources().getStringArray(a.smiley_values_old);
        this.sLZ = context.getResources().getStringArray(a.smiley_values_ch);
        this.sMa = context.getResources().getStringArray(a.smiley_values_tw);
        this.sMb = context.getResources().getStringArray(a.smiley_values_en);
        this.sMc = context.getResources().getStringArray(a.smiley_values_th);
        cjJ();
        x.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public static f cjI() {
        if (sLW == null) {
            synchronized (f.class) {
                if (sLW == null) {
                    sLW = new f(ad.getContext());
                }
            }
        }
        return sLW;
    }

    private synchronized int cjJ() {
        int i = 0;
        synchronized (this) {
            if (this.sLX == null || this.sLZ == null || this.sLX.length != this.sLZ.length) {
                x.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
                if (this.sMd != null) {
                    this.sMe = new a[this.sMd.size()];
                }
            } else {
                int length = this.sLX.length;
                if (this.sMd != null) {
                    this.sMe = new a[((this.sMd.size() + length) * 6)];
                } else {
                    this.sMe = new a[(length * 6)];
                }
                int i2 = 0;
                while (i2 < length) {
                    String str = this.sLX[i2];
                    String str2 = this.sLZ[i2];
                    String str3 = (this.sLY == null || this.sLY.length <= i2) ? "" : this.sLY[i2];
                    String str4 = (this.sMa == null || this.sMa.length <= i2) ? "" : this.sMa[i2];
                    String str5 = (this.sMb == null || this.sMb.length <= i2) ? "" : this.sMb[i2];
                    String str6 = (this.sMc == null || this.sMc.length <= i2) ? "" : this.sMc[i2];
                    q qVar = new q(str, str3, str2, str4, str5, str6, i2);
                    this.sMe[(i2 * 6) + 0] = new a(i2, str, "");
                    this.sMe[(i2 * 6) + 1] = new a(i2, str2, "");
                    this.sMe[(i2 * 6) + 2] = new a(i2, str3, "");
                    this.sMe[(i2 * 6) + 3] = new a(i2, str4, "");
                    this.sMe[(i2 * 6) + 4] = new a(i2, str5, "");
                    this.sMe[(i2 * 6) + 5] = new a(i2, str6, "");
                    this.sMf.put(str, qVar);
                    this.sMg.put(qVar.field_eggIndex, qVar.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.sMd == null || this.sMd.isEmpty()) {
                Arrays.sort(this.sMe, sMi);
            }
        }
        return i;
    }

    public final int cjK() {
        long currentTimeMillis = System.currentTimeMillis();
        this.sMf.clear();
        this.sMg.clear();
        this.sMd = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().aDQ();
        int cjJ = cjJ();
        if (this.sMd == null || this.sMd.isEmpty()) {
            x.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
            cjJ = -1;
        } else {
            Iterator it = this.sMd.iterator();
            while (true) {
                int i = cjJ;
                if (!it.hasNext()) {
                    break;
                }
                q qVar = (q) it.next();
                this.sMf.put(qVar.field_key, qVar);
                this.sMg.put(qVar.field_eggIndex, qVar.field_key);
                this.sMe[(i * 6) + 0] = new a(-1, qVar.field_key, qVar.field_fileName);
                if (bi.oW(qVar.field_cnValue) || "null".equalsIgnoreCase(qVar.field_cnValue)) {
                    this.sMe[(i * 6) + 1] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.sMe[(i * 6) + 1] = new a(-1, qVar.field_cnValue, qVar.field_fileName);
                }
                if (bi.oW(qVar.field_qqValue) || "null".equalsIgnoreCase(qVar.field_qqValue)) {
                    this.sMe[(i * 6) + 2] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.sMe[(i * 6) + 2] = new a(-1, qVar.field_qqValue, qVar.field_fileName);
                }
                if (bi.oW(qVar.field_twValue) || "null".equalsIgnoreCase(qVar.field_twValue)) {
                    this.sMe[(i * 6) + 3] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.sMe[(i * 6) + 3] = new a(-1, qVar.field_twValue, qVar.field_fileName);
                }
                if (bi.oW(qVar.field_enValue) || "null".equalsIgnoreCase(qVar.field_enValue)) {
                    this.sMe[(i * 6) + 4] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.sMe[(i * 6) + 4] = new a(-1, qVar.field_enValue, qVar.field_fileName);
                }
                if (bi.oW(qVar.field_thValue) || "null".equalsIgnoreCase(qVar.field_thValue)) {
                    this.sMe[(i * 6) + 5] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.sMe[(i * 6) + 5] = new a(-1, qVar.field_thValue, qVar.field_fileName);
                }
                cjJ = i + 1;
            }
            cjJ = 0;
        }
        Arrays.sort(this.sMe, sMi);
        x.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return cjJ;
    }

    public final a Xx(String str) {
        a[] aVarArr = cjI().sMe;
        if (aVarArr != null) {
            int binarySearch = Arrays.binarySearch(this.sMe, new a(0, str, ""), sMi);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            if (binarySearch >= 0 && str.startsWith(this.sMe[binarySearch].text)) {
                return aVarArr[binarySearch];
            }
        }
        return null;
    }

    public final SpannableString b(SpannableString spannableString, int i, int i2) {
        if (spannableString != null && spannableString.length() != 0) {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        a Xx = Xx(spannableString.subSequence(i, spannableString.length()));
        if (Xx == null) {
            return false;
        }
        int i3 = Xx.pos;
        Drawable mg = i3 >= 0 ? b.cjC().mg(i3) : Xy(Xx.name);
        if (mg == null || i > spannableString.length() || Xx.text.length() + i > spannableString.length()) {
            x.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[]{Xx.toString()});
            return false;
        }
        b.cjC().a(spannableString, mg, i, i + Xx.text.length(), i2);
        return true;
    }

    static Drawable Xy(String str) {
        Throwable e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(com.tencent.mm.ag.a.Od() + "/" + str);
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                if (decodeStream == null) {
                    x.i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                Drawable bitmapDrawable = new BitmapDrawable(ad.getContext().getResources(), decodeStream);
                try {
                    fileInputStream.close();
                    return bitmapDrawable;
                } catch (Throwable e2) {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e2));
                    return bitmapDrawable;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            x.i("MicroMsg.QQSmileyManager", bi.i(e4));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            x.i("MicroMsg.QQSmileyManager", bi.i(e22));
                        }
                    }
                    throw e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e4 = e5;
            fileInputStream = null;
            x.i("MicroMsg.QQSmileyManager", bi.i(e4));
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e42) {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e42));
                }
            }
            return null;
        } catch (Throwable th2) {
            e42 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e222) {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e222));
                }
            }
            throw e42;
        }
    }

    public final q Xz(String str) {
        if (this.sMf != null && this.sMf.containsKey(str)) {
            return (q) this.sMf.get(str);
        }
        x.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[]{str});
        return null;
    }
}
