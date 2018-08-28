package com.tencent.mm.plugin.ipcall.b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.c;
import com.tencent.mm.g.a.as;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class a {
    public static String kAa = "+";
    public static String kAb = "00";
    public static String kAc = null;
    private static ap kAd = new ap();
    private static HashMap<String, b> kAe = new HashMap();
    private static HashMap<String, String> kAf = new HashMap();
    private static HashMap<String, String> kAg = new HashMap();
    private static HashMap<String, String> kAh = new HashMap();
    private static HashMap<String, String> kAi = new HashMap();
    public static int kzZ = 3;

    public static String av(Context context, String str) {
        String str2 = null;
        if (com.tencent.mm.pluginsdk.permission.a.bj(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.pK(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    x.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[]{e.getMessage()});
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } else {
            x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        }
        return str2;
    }

    public static String aw(Context context, String str) {
        String av = av(context, str);
        if (bi.oW(av)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.h(av, context);
    }

    public static String ax(Context context, String str) {
        if (bi.oW(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.h(str, context);
    }

    public static Bitmap ay(Context context, String str) {
        return f(context, str, false);
    }

    public static Bitmap f(Context context, String str, boolean z) {
        if (bi.oW(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.a(str, context, z);
    }

    public static Bitmap az(Context context, String str) {
        String av = av(context, str);
        Bitmap bitmap = null;
        if (!bi.oW(av)) {
            bitmap = f(context, av, true);
        }
        if (bitmap != null || !XF()) {
            return bitmap;
        }
        av = Fk(str);
        x.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[]{av});
        if (bi.oW(av)) {
            return bitmap;
        }
        return c.c(av, 320, 320, 4);
    }

    public static String Fk(String str) {
        if (bi.oW(str)) {
            return null;
        }
        com.tencent.mm.plugin.account.friend.a.a pq = b.getAddrUploadStg().pq(g.u(c.Fx(str).getBytes()));
        if (pq != null) {
            return pq.getUsername();
        }
        return null;
    }

    public static String Fl(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return b.getAddrUploadStg().pt(str);
    }

    public static String rK(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.phone_type_home);
            case 2:
                return context.getString(R.l.phone_type_mobile);
            case 4:
                return context.getString(R.l.phone_type_company_fax);
            case 5:
                return context.getString(R.l.phone_type_home_fax);
            case 10:
                return context.getString(R.l.phone_type_company);
            default:
                return context.getString(R.l.phone_type_other);
        }
    }

    private static void aYw() {
        String str;
        kAf.clear();
        kAg.clear();
        kAh.clear();
        kAi.clear();
        kAe.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = ad.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bi.i(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (Throwable e22) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bi.i(e22)});
                    str = str2;
                }
            } else {
                str = str2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bi.i(e3)});
                }
            }
        }
        String[] split = str.trim().split("\n");
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                x.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[]{split[r1]});
            } else {
                b bVar = new b();
                bVar.kAj = split2[0];
                bVar.kAk = split2[1];
                RegionCodeDecoder.cmS();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (bi.oW(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(ad.getResources().getConfiguration().locale);
                }
                bVar.kAl = str3;
                kAh.put(bVar.kAk, bVar.kAj);
                kAi.put(bVar.kAj, bVar.kAk);
                kAf.put(bVar.kAk, bVar.kAl);
                kAg.put(bVar.kAl, bVar.kAk);
                kAe.put(bVar.kAj, bVar);
            }
        }
    }

    public static HashMap<String, b> aYx() {
        if (kAe.size() == 0) {
            aYw();
        }
        return kAe;
    }

    public static String Fm(String str) {
        if (kAe.size() == 0) {
            aYw();
        }
        if (bi.oW(str)) {
            return null;
        }
        b bVar = (b) kAe.get(str);
        return bVar != null ? bVar.kAl : null;
    }

    public static String Fn(String str) {
        if (kAf.size() == 0) {
            aYw();
        }
        if (bi.oW(str)) {
            return null;
        }
        return (String) kAf.get(str);
    }

    public static String Fo(String str) {
        if (kAh.size() == 0) {
            aYw();
        }
        if (bi.oW(str)) {
            return null;
        }
        return (String) kAh.get(str);
    }

    public static int du(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return -1;
        }
        int dv = dv(str, str2);
        if (dv != -1 || !str2.startsWith("+")) {
            return dv;
        }
        String Fp = Fp(str2);
        if (!bi.oW(Fp)) {
            str2 = str2.substring(("+" + Fp).length());
        }
        return dv(str, str2);
    }

    private static int dv(String str, String str2) {
        if (com.tencent.mm.pluginsdk.permission.a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ad.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String Fx = c.Fx(str2);
            int i;
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("data2"));
                        if (c.Fx(query.getString(query.getColumnIndex("data1"))).equals(Fx)) {
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                Object[] objArr = new Object[1];
                i = e.getMessage();
                objArr[0] = i;
                x.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", objArr);
            } finally {
                query.close();
            }
            return -1;
        }
        x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return -1;
    }

    public static String Fp(String str) {
        if (kAf.size() == 0) {
            aYw();
        }
        if (Fr(str)) {
            String Fx = c.Fx(Fs(str));
            List<String> arrayList = new ArrayList(kAf.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a((byte) 0)));
            for (String str2 : arrayList) {
                if (Fx.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static boolean Fq(String str) {
        if (kAf.size() == 0) {
            aYw();
        }
        if (kAf.containsKey(str)) {
            return true;
        }
        return false;
    }

    public static boolean Fr(String str) {
        if (bi.oW(str) || (!str.startsWith(kAa) && !str.startsWith(kAb))) {
            return false;
        }
        return true;
    }

    public static String Fs(String str) {
        if (bi.oW(str)) {
            return str;
        }
        if (str.startsWith(kAa)) {
            return str.substring(kAa.length());
        }
        if (str.startsWith(kAb)) {
            return str.substring(kAb.length());
        }
        return str;
    }

    public static String Ft(String str) {
        String Fx = c.Fx(str);
        String Fx2 = c.Fx(Fx);
        String str2 = null;
        if (Fr(Fx2)) {
            str2 = Fp(Fx2);
        }
        if (bi.oW(str2)) {
            str2 = ap.Wv(Fx);
        } else {
            Fx = Fs(Fx2).substring(str2.length());
            Fx2 = ap.formatNumber(str2, Fx);
            if (!bi.oW(Fx2)) {
                Fx = Fx2;
            }
            str2 = !Fx.startsWith("+") ? "+" + str2 + " " + Fx : "+" + str2 + " " + Fx.replace("+", "");
        }
        if (str2.length() > 25) {
            return str2.substring(0, 25) + "...";
        }
        return str2;
    }

    public static String aYy() {
        if (kAg.size() == 0) {
            aYw();
        }
        String fS = bi.fS(ad.getContext());
        if (!bi.oW(fS)) {
            x.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[]{fS});
            fS = (String) kAi.get(fS.toUpperCase());
            if (!bi.oW(fS)) {
                x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{fS});
                if (!bi.oW(fS)) {
                    return fS;
                }
                fS = bl.IC().countryCode;
                x.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{fS});
                if (!bi.oW(fS)) {
                    fS = (String) kAi.get(fS);
                    if (!bi.oW(fS)) {
                        x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{fS});
                        return fS;
                    }
                }
                x.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ad.getContext().getString(R.l.country_normal_code)});
                return ad.getContext().getString(R.l.country_normal_code).replace("+", "");
            }
        }
        fS = "";
        if (!bi.oW(fS)) {
            return fS;
        }
        fS = bl.IC().countryCode;
        x.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{fS});
        if (!bi.oW(fS)) {
            fS = (String) kAi.get(fS);
            if (!bi.oW(fS)) {
                x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{fS});
                return fS;
            }
        }
        x.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ad.getContext().getString(R.l.country_normal_code)});
        return ad.getContext().getString(R.l.country_normal_code).replace("+", "");
    }

    public static void aYz() {
        aYw();
    }

    public static String Fu(String str) {
        if (kAf.size() == 0) {
            aYw();
        }
        if (!Fr(str)) {
            return str;
        }
        str = c.Fx(Fs(str));
        List<String> arrayList = new ArrayList(kAf.keySet());
        Collections.sort(arrayList, Collections.reverseOrder(new a((byte) 0)));
        for (String str2 : arrayList) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    public static boolean XF() {
        as asVar = new as();
        com.tencent.mm.sdk.b.a.sFg.m(asVar);
        x.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[]{Boolean.valueOf(asVar.bIh.bGZ)});
        return asVar.bIh.bGZ;
    }

    public static ArrayList<String> Fv(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.permission.a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ad.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return arrayList;
    }
}
