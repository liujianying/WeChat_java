package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.y.g;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat hIH = null;
    private static SimpleDateFormat hII = null;
    private static SimpleDateFormat hIJ = null;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static int xV(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(b.CTRL_BYTE, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.CardUtil", e.toString());
            return rgb;
        }
    }

    public static int bc(String str, int i) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.CardUtil", e.toString());
            return rgb;
        }
    }

    public static ShapeDrawable A(Context context, int i) {
        return cm(i, context.getResources().getDimensionPixelOffset(a.b.card_btn_bg_corner));
    }

    public static ShapeDrawable cm(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static ShapeDrawable e(Context context, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.b.OneDPPadding);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        return shapeDrawable;
    }

    public static List<com.tencent.mm.plugin.card.model.b> az(List<lk> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<com.tencent.mm.plugin.card.model.b> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            lk lkVar = (lk) list.get(i);
            com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
            bVar.title = lkVar.title;
            bVar.huX = lkVar.huX;
            bVar.hyz = lkVar.hyz;
            bVar.url = lkVar.url;
            bVar.roL = lkVar.roL;
            bVar.hvi = false;
            bVar.roM = lkVar.roM;
            bVar.roN = lkVar.roN;
            bVar.lMY = lkVar.lMY;
            bVar.rnv = lkVar.rnv;
            bVar.rnw = lkVar.rnw;
            bVar.hvh = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String bx(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (hIH == null) {
            hIH = new SimpleDateFormat("yyyy.MM.dd");
        }
        return hIH.format(new Date(j2));
    }

    public static boolean xW(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Bitmap w(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    public static void x(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
    }

    public static boolean b(CardInfo cardInfo) {
        if (cardInfo == null) {
            x.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            return false;
        }
        CardInfo xm = am.axi().xm(cardInfo.field_card_id);
        if (xm == null) {
            boolean b = am.axi().b(cardInfo);
            x.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (!b) {
                x.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            return b;
        }
        cardInfo.field_stickyIndex = xm.field_stickyIndex;
        cardInfo.field_stickyEndTime = xm.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = xm.field_stickyAnnouncement;
        x.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[]{Boolean.valueOf(am.axi().c(cardInfo, new String[0]))});
        return am.axi().c(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] Q;
        g.a aVar = null;
        Bitmap a = y.a(new m(bVar.awm().huW));
        if (a != null) {
            Q = c.Q(a);
        } else {
            Q = null;
        }
        com.tencent.mm.plugin.card.compat.a.a aVar2 = (com.tencent.mm.plugin.card.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.card.compat.a.a.class);
        if (bVar != null) {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            g.a aVar3 = new g.a();
            if (bVar.awm() != null) {
                aVar3.title = bVar.awo().sli;
                aVar3.description = bVar.awm().title;
                aVar3.type = 16;
                aVar3.showType = 0;
                aVar3.dwr = 3;
                aVar3.appId = bVar.awm().bPS;
                aVar3.dwP = 0;
                aVar3.thumburl = bVar.awm().huW;
                aVar3.dxG = i;
                aVar3.dxF = bVar.awm().hwh;
                aVar3.url = bVar.awm().rnM;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.aws()).append("</from_username>");
            if (nZ(i)) {
                stringBuilder2.append("<card_id>").append(bVar.awr()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.awq()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.awm().huV).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.awm().dxh).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.awm().hwg).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.awm().hwh).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.awq()).append("</recommend_card_id>");
            aVar3.dxE = stringBuilder.append(stringBuilder2.toString()).toString();
            aVar3.bRw = g.a.a(aVar3, null, null);
            aVar = aVar3;
        }
        aVar2.b(aVar, bVar.awm().bPS, bVar.awm().hwh, str, Q);
    }

    public static void ck(String str, String str2) {
        if (!bi.oW(str)) {
            ow owVar = new ow();
            owVar.bZQ.bZR = str2;
            owVar.bZQ.content = str;
            owVar.bZQ.type = s.hQ(str2);
            owVar.bZQ.flags = 0;
            com.tencent.mm.sdk.b.a.sFg.m(owVar);
        }
    }

    public static boolean nZ(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean oa(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    public static boolean ob(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean nI(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                return true;
            default:
                return false;
        }
    }

    public static void azQ() {
        Integer num = (Integer) com.tencent.mm.kernel.g.Ei().DT().get(282883, null);
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open card entrance");
            com.tencent.mm.kernel.g.Ei().DT().set(282883, Integer.valueOf(1));
            com.tencent.mm.s.c.Cp().u(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "card entrance is open");
    }

    public static boolean azR() {
        Integer num = (Integer) com.tencent.mm.kernel.g.Ei().DT().get(282883, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void azS() {
        Integer num = (Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQc, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open share card entrance");
            com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQc, Integer.valueOf(1));
            com.tencent.mm.s.c.Cp().u(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "share card entrance is open");
    }

    public static boolean azT() {
        Integer num = (Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQc, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static String f(Context context, float f) {
        if (f <= 0.0f) {
            return "";
        }
        if (f > 0.0f && f < 1000.0f) {
            return context.getString(a.g.card_distance_m, new Object[]{((int) f)});
        } else if (f < 1000.0f) {
            return "";
        } else {
            int i = a.g.card_distance_km;
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            return context.getString(i, objArr);
        }
    }

    public static boolean OC() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean OD() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled("network");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        if (shareCardInfo == null) {
            x.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            return false;
        }
        ShareCardInfo xC = am.axq().xC(shareCardInfo.field_card_id);
        if (xC == null) {
            boolean b = am.axq().b(shareCardInfo);
            x.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.cc(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                x.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            return b;
        }
        shareCardInfo.field_categoryType = xC.field_categoryType;
        shareCardInfo.field_itemIndex = xC.field_itemIndex;
        x.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[]{Boolean.valueOf(am.axq().c(shareCardInfo, new String[0]))});
        return am.axq().c(shareCardInfo, new String[0]);
    }

    public static boolean j(com.tencent.mm.plugin.card.base.b bVar) {
        boolean c;
        if (bVar instanceof CardInfo) {
            c = am.axi().c((CardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.awq()});
            return c;
        } else if (!(bVar instanceof ShareCardInfo)) {
            return false;
        } else {
            c = am.axq().c((ShareCardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.awq()});
            return c;
        }
    }

    public static void xX(String str) {
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQa, str);
    }

    public static String azU() {
        return (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQa, "");
    }

    public static String xY(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CharSequence gU = r.gU(str);
        CharSequence gT = r.gT(str);
        if (!TextUtils.isEmpty(gU)) {
            return gU;
        }
        if (TextUtils.isEmpty(gT)) {
            return str;
        }
        return gT;
    }

    public static ArrayList<String> aA(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        for (String FA : list) {
            Collection FD = com.tencent.mm.plugin.label.a.a.aYK().FD(com.tencent.mm.plugin.label.a.a.aYK().FA(FA));
            if (FD == null || FD.size() == 0) {
                x.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(FD);
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public static ArrayList<String> aB(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String FA : list) {
            CharSequence FA2 = com.tencent.mm.plugin.label.a.a.aYK().FA(FA);
            if (!TextUtils.isEmpty(FA2)) {
                arrayList.add(FA2);
            }
        }
        return arrayList;
    }

    public static String xZ(String str) {
        List list;
        List<Object> asList = Arrays.asList(str.split(","));
        List linkedList = new LinkedList();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                return bi.c(list, ",");
            }
            for (Object obj : asList) {
                Object obj2;
                ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(obj2);
                if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                    obj2 = Yg.BL();
                }
                linkedList.add(obj2);
            }
        }
        list = linkedList;
        return bi.c(list, ",");
    }

    public static bnk f(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        int i2 = 0;
        x.i("MicroMsg.CardUtil", "getShareTag()");
        bnk bnk = new bnk();
        Collection arrayList3;
        int i3;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                bnk.slr.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && xW(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bnk.slt.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                bnk.sls.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && xW(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bnk.slu.addAll(arrayList3);
            }
        }
        return bnk;
    }

    public static boolean a(pr prVar, String str) {
        if (cd(prVar.roL)) {
            String str2 = prVar.title;
            if (ya(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    public static boolean a(com.tencent.mm.plugin.card.model.b bVar, String str) {
        if (cd(bVar.roL)) {
            String str2 = bVar.title;
            if (ya(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    private static boolean cd(long j) {
        if ((8 & j) <= 0) {
            return false;
        }
        x.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
        return true;
    }

    private static boolean ya(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "hasShowWarning()");
        String str2 = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQh, "");
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void yb(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            return;
        }
        Object str2;
        x.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        String str3 = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sQh, "");
        if (TextUtils.isEmpty(str3)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str3.split(",");
            if (split == null || split.length == 0) {
                x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str3 = str2;
            }
            Object obj = null;
            for (Object equals : split) {
                if (str2.equals(equals)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                str2 = str3 + "," + str2;
            } else {
                str2 = str3;
            }
        }
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sQh, str2);
    }

    public static String x(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f = am.axo().cXn;
        float f2 = am.axo().cXm;
        if (f == -1000.0f || f2 == -85.0f) {
            x.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            return str;
        } else if ((16 & j) <= 0) {
            return str;
        } else {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            x.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + str);
            x.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + replace);
            return replace;
        }
    }

    public static int yc(String str) {
        if (TextUtils.isEmpty(str) || str.equals(q.GF())) {
            return 0;
        }
        return 1;
    }

    public static Drawable g(Context context, String str, int i) {
        Drawable e = e(context, xV(str), i);
        Drawable cm = cm(xV(str), i);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cm);
        stateListDrawable.addState(new int[0], e);
        return stateListDrawable;
    }

    public static ColorStateList ad(Context context, String str) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, new int[]{context.getResources().getColor(a.a.white), xV(str)});
    }
}
