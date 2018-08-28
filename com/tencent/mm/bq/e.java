package com.tencent.mm.bq;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class e {
    private static final List<String> sCL = Arrays.asList(new String[]{"zh_CN"});
    private static e sCM;
    private static f sCN;
    private static b sCO;
    private static d sCP;
    private static String sCQ = "";
    private static boolean sCR = false;
    private static boolean sCS = true;
    private static ArrayList<Integer> sCT = new ArrayList();

    public static e cgF() {
        e eVar;
        synchronized (e.class) {
            if (sCM == null) {
                sCM = new e();
            }
            eVar = sCM;
        }
        return eVar;
    }

    private e() {
    }

    private static void clean() {
        if (sCN != null) {
            f fVar = sCN;
            if (fVar.sCU != null) {
                fVar.sCU.clear();
            }
            if (fVar.sCV != null) {
                fVar.sCV = null;
            }
        }
        if (sCO != null) {
            b bVar = sCO;
            if (bVar.sCE != null) {
                bVar.sCE.clear();
            }
            if (bVar.hfA != null) {
                bVar.hfA = null;
            }
        }
        if (sCP != null) {
            d dVar = sCP;
            if (dVar.sCJ != null) {
                dVar.sCJ.clear();
            }
            if (dVar.hfA != null) {
                dVar.hfA = null;
            }
        }
    }

    public static e fm(Context context) {
        return bq(context, w.d(context.getSharedPreferences(ad.chY(), 0)));
    }

    public static e bq(Context context, String str) {
        Throwable th;
        DataInputStream dataInputStream;
        if (context.getResources() == null) {
            x.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            return null;
        }
        AssetManager assets = context.getAssets();
        if (assets != null) {
            cgF();
            x.i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
            if (sCT == null) {
                sCT = new ArrayList();
            }
            sCT.clear();
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream = null;
            DataInputStream dataInputStream2;
            try {
                inputStream = assets.open("estrings/encrypt.mmstrid");
                dataInputStream2 = new DataInputStream(inputStream);
                try {
                    x.d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream2.readInt()));
                    for (int i = 0; i < r6.intValue(); i++) {
                        sCT.add(Integer.valueOf(dataInputStream2.readInt()));
                        x.d("MicroMsg.language.StringResouces", "encrypt string id is %d", r7);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e) {
                            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e));
                        }
                    }
                    try {
                        dataInputStream2.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2));
                    }
                } catch (IOException e3) {
                    try {
                        x.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e4));
                            }
                        }
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                            } catch (Throwable e22) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22));
                            }
                        }
                        x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                        if (assets != null) {
                            cgF();
                            if (sCS) {
                                Locale locale;
                                if (bi.oW(str) || str.equalsIgnoreCase("language_default")) {
                                    locale = Locale.getDefault();
                                    w.a(context, locale);
                                } else {
                                    locale = w.Wl(str);
                                }
                                String locale2 = locale.toString();
                                cgF();
                                boolean z = !sCL.contains(locale2);
                                sCR = z;
                                if (z) {
                                    cgF();
                                    a(assets, locale2);
                                    return cgF();
                                }
                                clean();
                                sCQ = locale2;
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable e42) {
                        th = e42;
                        dataInputStream = dataInputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e222));
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2222));
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                dataInputStream2 = null;
                x.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e422) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e422));
                    }
                }
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22222));
                    }
                }
                x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                if (assets != null) {
                    cgF();
                    if (sCS) {
                        Locale locale3;
                        if (bi.oW(str) || str.equalsIgnoreCase("language_default")) {
                            locale3 = Locale.getDefault();
                            w.a(context, locale3);
                        } else {
                            locale3 = w.Wl(str);
                        }
                        String locale22 = locale3.toString();
                        cgF();
                        boolean z2 = !sCL.contains(locale22);
                        sCR = z2;
                        if (z2) {
                            cgF();
                            a(assets, locale22);
                            return cgF();
                        }
                        clean();
                        sCQ = locale22;
                        return null;
                    }
                }
                return null;
            } catch (Throwable e222222) {
                th = e222222;
                dataInputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2222222) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2222222));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e22222222) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22222222));
                    }
                }
                throw th;
            }
            x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (assets != null) {
            cgF();
            if (sCS) {
                Locale locale32;
                if (bi.oW(str) || str.equalsIgnoreCase("language_default")) {
                    locale32 = Locale.getDefault();
                    w.a(context, locale32);
                } else {
                    locale32 = w.Wl(str);
                }
                String locale222 = locale32.toString();
                cgF();
                boolean z22 = !sCL.contains(locale222);
                sCR = z22;
                if (z22) {
                    cgF();
                    a(assets, locale222);
                    return cgF();
                }
                clean();
                sCQ = locale222;
                return null;
            }
        }
        return null;
    }

    private static void a(AssetManager assetManager, String str) {
        Throwable e;
        if (bi.oW(str)) {
            x.w("MicroMsg.language.StringResouces", "local is null.");
        } else if (str.equals(sCQ)) {
            x.i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    x.d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            clean();
            sCQ = str;
            x.i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream = null;
            DataInputStream dataInputStream;
            try {
                inputStream = assetManager.open("strings/" + str + ".mmstr");
                dataInputStream = new DataInputStream(inputStream);
                try {
                    int i;
                    dataInputStream.readInt();
                    dataInputStream.readInt();
                    int readInt = dataInputStream.readInt();
                    x.i("MicroMsg.language.StringResouces", "string count" + readInt);
                    SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                    int readInt2 = dataInputStream.readInt();
                    indexOf = 0;
                    for (i = 0; i < readInt; i++) {
                        readInt2 += dataInputStream.readShort();
                        sparseIntArray.append(readInt2, indexOf);
                        indexOf += dataInputStream.readShort();
                    }
                    sCN = f.a(sparseIntArray, dataInputStream, indexOf);
                    readInt = dataInputStream.readInt();
                    x.i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                    if (readInt > 0) {
                        SparseArray sparseArray = new SparseArray(readInt);
                        readInt2 = dataInputStream.readInt();
                        i = 0;
                        for (indexOf = 0; indexOf < readInt; indexOf++) {
                            readInt2 += dataInputStream.readInt();
                            i += a(dataInputStream, sparseArray, readInt2, i);
                        }
                        sCO = b.a(sparseArray, dataInputStream, i);
                    }
                    int readInt3 = dataInputStream.readInt();
                    indexOf = dataInputStream.readInt();
                    x.i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
                    if (readInt3 > 0) {
                        SparseArray sparseArray2 = new SparseArray(readInt3);
                        i = 0;
                        readInt = 0;
                        while (readInt < readInt3) {
                            readInt2 = dataInputStream.readInt() + indexOf;
                            int readInt4 = dataInputStream.readInt();
                            int[] iArr = new int[readInt4];
                            for (indexOf = 0; indexOf < readInt4; indexOf++) {
                                iArr[indexOf] = i;
                                i += dataInputStream.readShort();
                            }
                            sparseArray2.append(readInt2, new a(readInt2, iArr));
                            readInt++;
                            indexOf = readInt2;
                        }
                        sCP = d.b(sparseArray2, dataInputStream, i);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2));
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22));
                    }
                } catch (IOException e3) {
                    e22 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.language.StringResouces", e22, "[cpan] local :%s file can not be find. use default.", str);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e222));
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2222));
                            }
                        }
                        x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th) {
                        e2222 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e4));
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e5) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e5));
                            }
                        }
                        throw e2222;
                    }
                }
            } catch (IOException e6) {
                e2222 = e6;
                dataInputStream = null;
                x.printErrStackTrace("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22222));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e222222) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e222222));
                    }
                }
                x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th2) {
                e222222 = th2;
                dataInputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e42) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e42));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable e52) {
                        x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e52));
                    }
                }
                throw e222222;
            }
            x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean cgG() {
        if (!(sCS && sCR)) {
            boolean z = (sCT == null || sCT.isEmpty()) ? false : true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static boolean cgE() {
        return sCS;
    }

    public static String getString(int i) {
        if (sCN == null) {
            return null;
        }
        return sCN.getString(i);
    }

    public static String getQuantityString(int i, int i2) {
        if (sCO == null) {
            return null;
        }
        return sCO.getQuantityString(i, i2, new Object[0]);
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        if (sCO == null) {
            return null;
        }
        return sCO.getQuantityString(i, i2, objArr);
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        if (sCP == null) {
            return null;
        }
        d dVar = sCP;
        int indexOfKey = dVar.sCJ.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        String[] strArr;
        int length = indexOfKey < dVar.sCJ.size() + -1 ? ((a) dVar.sCJ.valueAt(indexOfKey + 1)).sCK[0] : dVar.hfA.length;
        a aVar = (a) dVar.sCJ.valueAt(indexOfKey);
        indexOfKey = aVar.sCK.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(dVar.hfA, aVar.sCK[i2], aVar.sCK[i2 + 1] - aVar.sCK[i2]);
                } else {
                    strArr2[i2] = new String(dVar.hfA, aVar.sCK[i2], length - aVar.sCK[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<a> sparseArray, int i, int i2) {
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                iArr[b] = dataInputStream.readByte();
                iArr2[b] = i2;
                short readShort = dataInputStream.readShort();
                i3 += readShort;
                i2 += readShort;
            }
            sparseArray.append(i, new a(i, iArr, iArr2));
            return i3;
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e));
            return 0;
        }
    }

    public static CharSequence d(int i, CharSequence charSequence) {
        if (charSequence == null || sCT == null || sCT.isEmpty() || !sCT.contains(Integer.valueOf(i))) {
            return charSequence;
        }
        return a.x(charSequence.toString(), g.u("lucky".getBytes()).substring(0, 16));
    }
}
