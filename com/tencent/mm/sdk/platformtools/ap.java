package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.aq.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ap {
    public static aq sHS = null;

    public static String fO(String str, String str2) {
        String replace = Ww(str).replace("+", "");
        if (sHS == null) {
            sHS = new aq();
        }
        int length;
        if (bi.oW(str2)) {
            for (a aVar : sHS.sHT) {
                if (replace.startsWith(aVar.sHV)) {
                    length = replace.length() - aVar.sHV.length();
                    if (length >= aVar.sHW && length <= aVar.sHX) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.sHV, aVar.sHU, Integer.valueOf(aVar.sHX), Integer.valueOf(aVar.sHX));
                        return aVar.sHV;
                    }
                }
            }
        } else {
            for (a aVar2 : sHS.sHT) {
                if (replace.startsWith(aVar2.sHV)) {
                    length = replace.length() - aVar2.sHV.length();
                    if (length >= aVar2.sHW && length <= aVar2.sHX && str2.equalsIgnoreCase(aVar2.sHU)) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.sHV, aVar2.sHU, Integer.valueOf(aVar2.sHX), Integer.valueOf(aVar2.sHX));
                        return aVar2.sHV;
                    }
                }
            }
        }
        return null;
    }

    public static String Fp(String str) {
        return fO(str, null);
    }

    public static String Wv(String str) {
        if (bi.oW(str) || !bi.Xd(str).booleanValue()) {
            return str;
        }
        ap apVar = new ap();
        String str2 = "86";
        if (str.startsWith("+")) {
            str = str.replace("+", "");
            str2 = fO(str, null);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return formatNumber(str2, str);
    }

    public static String Ww(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return str.replaceAll("[\\.\\-\\ ]", "").trim();
    }

    public static String Wx(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return str.replace("+", "");
    }

    public static String Wy(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return !str.startsWith("+") ? "+" + str : str;
    }

    public static String fP(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return "";
        }
        return str + "（+" + str2 + "）";
    }

    public static String formatNumber(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return str2;
        }
        if (sHS == null) {
            sHS = new aq();
        }
        for (a aVar : sHS.sHT) {
            if (!(aVar.sHV == null || !str.trim().toLowerCase().equals(aVar.sHV.trim().toLowerCase()) || aVar.sHY == null)) {
                String Ww = Ww(str2);
                if (Ww != null && Ww.length() > aVar.sHW) {
                    return Ww;
                }
                for (b bVar : aVar.sHY) {
                    int i;
                    int i2;
                    char charAt;
                    StringBuffer stringBuffer;
                    int length;
                    if (bi.oW(bVar.sHZ)) {
                        if (aVar.sHY.size() > 1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(Ww);
                            int length2 = Ww.length();
                            if (length2 <= cW(bVar.sIb, aVar.sHX)) {
                                while (stringBuffer2.toString().length() < aVar.sHX) {
                                    stringBuffer2.append("0");
                                }
                                Ww = ao(bVar.sIb, bVar.sIa, stringBuffer2.toString());
                                i = 0;
                                for (i2 = 0; i2 < Ww.length(); i2++) {
                                    charAt = Ww.charAt(i2);
                                    if (i >= length2) {
                                        Ww = Ww.substring(0, i2);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                        i++;
                                    }
                                }
                                return Ww;
                            }
                        } else {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(Ww);
                            length = Ww.length();
                            while (stringBuffer.toString().length() < aVar.sHX) {
                                stringBuffer.append("0");
                            }
                            String ao = ao(bVar.sIb, bVar.sIa, stringBuffer.toString());
                            i = 0;
                            for (int i3 = 0; i3 < ao.length(); i3++) {
                                charAt = ao.charAt(i3);
                                if (i >= length) {
                                    ao = ao.substring(0, i3);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                    i++;
                                }
                            }
                            return ao;
                        }
                    } else if (Pattern.compile(bVar.sHZ).matcher(Ww).lookingAt()) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(Ww);
                        length = Ww.length();
                        while (stringBuffer.toString().length() < aVar.sHX) {
                            stringBuffer.append(Ww.charAt(length - 1));
                        }
                        Ww = ao(bVar.sIb, bVar.sIa, stringBuffer.toString());
                        i = 0;
                        for (i2 = 0; i2 < Ww.length(); i2++) {
                            charAt = Ww.charAt(i2);
                            if (i >= length) {
                                Ww = Ww.substring(0, i2);
                            }
                            if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                i++;
                            }
                        }
                        return Ww;
                    }
                }
                continue;
            }
        }
        return str2;
    }

    private static int cW(String str, int i) {
        Pattern compile = Pattern.compile(str);
        Object obj = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(obj).find()) {
            obj = obj + "1";
            i2++;
        }
        return i2 + 1;
    }

    private static String ao(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            return matcher.replaceAll(str2);
        }
        return str3;
    }
}
