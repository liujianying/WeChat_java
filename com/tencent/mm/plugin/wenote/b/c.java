package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static HashMap<String, String> qtB = new HashMap();
    public static HashMap<String, q> qtC = new HashMap();
    public static c qtD = null;
    private static f<String, Integer> qtE = new f(30);

    public static String fw(String str, String str2) {
        String str3;
        int i = 1280;
        if (bi.oW(str2)) {
            str3 = an.aLU() + "/" + (g.u((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (e.cn(str3)) {
            return str3;
        }
        Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
        if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
            x.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
            return null;
        }
        int i2;
        int i3 = VZ.outHeight;
        int i4 = VZ.outWidth;
        if (i4 > 1280) {
            i4 = 1280;
        }
        if (i3 <= 1280) {
            i = i3;
        }
        if (VZ.outHeight < VZ.outWidth) {
            i3 = i4;
            i2 = i;
        } else {
            i3 = i;
            i2 = i4;
        }
        if (z.Wn(str) > 0) {
            i3 = VZ.outHeight;
            i4 = VZ.outWidth;
        } else {
            i4 = i2;
        }
        com.tencent.mm.sdk.platformtools.c.c(str, i3, i4, CompressFormat.JPEG, 95, str3);
        return str3;
    }

    public static String fx(String str, String str2) {
        String str3;
        int i = 800;
        if (bi.oW(str2)) {
            str3 = an.aLU() + "/" + (g.u((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (e.cn(str3)) {
            return str3;
        }
        Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
        if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
            x.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
            return null;
        }
        int i2;
        int i3 = VZ.outHeight;
        int i4 = VZ.outWidth;
        while (i4 * i3 > 2764800) {
            i4 >>= 1;
            i3 >>= 1;
        }
        if (i4 > 800) {
            i4 = 800;
        }
        if (i3 <= 800) {
            i = i3;
        }
        if (VZ.outHeight < VZ.outWidth) {
            i3 = i4;
            i2 = i;
        } else {
            i3 = i;
            i2 = i4;
        }
        com.tencent.mm.sdk.platformtools.c.c(str, i3, i2, CompressFormat.JPEG, 95, str3);
        return str3;
    }

    public static Bitmap Sq(String str) {
        Bitmap at = com.tencent.mm.plugin.fav.ui.c.at(str, false);
        if (at != null) {
            return at;
        }
        if (bi.oW(null)) {
            return null;
        }
        return com.tencent.mm.plugin.fav.ui.c.at(null, false);
    }

    public static b c(b bVar) {
        if (bVar == null) {
            return null;
        }
        b gVar;
        switch (bVar.getType()) {
            case -1:
                gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                break;
            case 1:
                gVar = new h();
                ((h) gVar).content = ((h) bVar).content;
                break;
            case 2:
                gVar = new com.tencent.mm.plugin.wenote.model.a.e();
                ((com.tencent.mm.plugin.wenote.model.a.e) gVar).qpe = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).qpe;
                break;
            case 3:
                gVar = new com.tencent.mm.plugin.wenote.model.a.f();
                com.tencent.mm.plugin.wenote.model.a.f fVar = (com.tencent.mm.plugin.wenote.model.a.f) gVar;
                com.tencent.mm.plugin.wenote.model.a.f fVar2 = (com.tencent.mm.plugin.wenote.model.a.f) bVar;
                fVar.lat = fVar2.lat;
                fVar.lng = fVar2.lng;
                fVar.qpq = fVar2.qpq;
                fVar.dRH = fVar2.dRH;
                fVar.kFa = fVar2.kFa;
                break;
            case 4:
                gVar = new k();
                k kVar = (k) gVar;
                k kVar2 = (k) bVar;
                kVar.qpt = kVar2.qpt;
                kVar.length = kVar2.length;
                kVar.qps = kVar2.qps;
                kVar.fTs = kVar2.fTs;
                kVar.bOT = kVar2.bOT;
                kVar.bOS = kVar2.bOS;
                kVar.qoT = kVar2.qoT;
                break;
            case 5:
                gVar = new com.tencent.mm.plugin.wenote.model.a.c();
                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) gVar;
                com.tencent.mm.plugin.wenote.model.a.c cVar2 = (com.tencent.mm.plugin.wenote.model.a.c) bVar;
                cVar.title = cVar2.title;
                cVar.content = cVar2.content;
                cVar.fTs = cVar2.fTs;
                cVar.qoT = cVar2.qoT;
                break;
            case 6:
                gVar = new j();
                j jVar = (j) gVar;
                j jVar2 = (j) bVar;
                jVar.bOX = jVar2.bOX;
                jVar.duration = jVar2.duration;
                jVar.qoT = jVar2.qoT;
                break;
            default:
                gVar = null;
                break;
        }
        if (gVar == null) {
            return null;
        }
        ((n) gVar).type = ((n) bVar).type;
        ((n) gVar).qpd = ((n) bVar).qpd;
        ((n) gVar).bVd = ((n) bVar).bVd;
        return gVar;
    }

    public static String d(b bVar) {
        if (bVar == null) {
            return "";
        }
        if (bVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.e) bVar).qpe;
        }
        return ((n) bVar).bVd;
    }

    public static String e(b bVar) {
        if (bVar == null) {
            return "";
        }
        if (bVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.e) bVar).bVd;
        }
        if (bVar.getType() == 6) {
            return ((j) bVar).bOX;
        }
        return "";
    }

    public static int Sr(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        return St(b.Sp(str));
    }

    public static int d(String str, int i, int i2, boolean z) {
        if (bi.oW(str)) {
            return 0;
        }
        Spanned Sk = a.Sk(str);
        if (Sk == null) {
            return 0;
        }
        if (z) {
            i2 = Sk.length();
        }
        if (i < 0 || i > Sk.length() || i2 < 0 || i2 > Sk.length() || i > i2) {
            return 0;
        }
        Sk = (Spanned) Sk.subSequence(i, i2);
        if (Sk == null) {
            return 0;
        }
        return St(Sk.toString());
    }

    public static int Ss(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        if (qtE.bb(str)) {
            return ((Integer) qtE.get(str)).intValue();
        }
        int St = St(str);
        qtE.put(str, Integer.valueOf(St));
        return St;
    }

    private static int St(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= str.length()) {
                return i3;
            }
            i = (str.charAt(i2) <= 127 ? 1 : 2) + i3;
            i2++;
        }
    }

    public static String a(Context context, b bVar) {
        if (bVar == null) {
            return "";
        }
        int type = bVar.getType();
        if (type == 1) {
            return ((h) bVar).content;
        }
        if (type == 3) {
            return context.getString(R.l.wenote_placeholder_location);
        }
        if (type == 2) {
            return context.getString(R.l.wenote_placeholder_image);
        }
        if (type == 6) {
            return context.getString(R.l.wenote_placeholder_video);
        }
        if (type == 4) {
            return context.getString(R.l.wenote_placeholder_voice);
        }
        if (type == 5) {
            return context.getString(R.l.wenote_placeholder_file);
        }
        return "";
    }

    public static String Su(String str) {
        return Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
    }

    public static String Sv(String str) {
        FileNotFoundException e;
        Throwable e2;
        IOException e3;
        Exception e4;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(bArr, "UTF-8");
                try {
                    fileInputStream.close();
                    return str2;
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e5, "", new Object[0]);
                    return str2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                try {
                    x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath FileNotFoundException error,%s", new Object[]{e.toString()});
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.WNNoteUtil", e22, "", new Object[0]);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e52) {
                            x.printErrStackTrace("MicroMsg.WNNoteUtil", e52, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e7) {
                e3 = e7;
                x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath IOException error,%s", new Object[]{e3.toString()});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.WNNoteUtil", e222, "", new Object[0]);
                    }
                }
                return "";
            } catch (Exception e8) {
                e4 = e8;
                x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath Exception error,%s", new Object[]{e4.toString()});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.WNNoteUtil", e2222, "", new Object[0]);
                    }
                }
                return "";
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath FileNotFoundException error,%s", new Object[]{e.toString()});
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e22222, "", new Object[0]);
                }
            }
            return "";
        } catch (IOException e10) {
            e3 = e10;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath IOException error,%s", new Object[]{e3.toString()});
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e222222) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e222222, "", new Object[0]);
                }
            }
            return "";
        } catch (Exception e11) {
            e4 = e11;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath Exception error,%s", new Object[]{e4.toString()});
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e2222222, "", new Object[0]);
                }
            }
            return "";
        } catch (Throwable th2) {
            e2222222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e522) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e522, "", new Object[0]);
                }
            }
            throw e2222222;
        }
    }
}
