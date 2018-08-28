package com.tencent.mm.plugin.welab.c.a;

import android.text.TextUtils;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends ci {
    public static com.tencent.mm.sdk.e.c.a dhO;
    private static final List<String> qmU = Arrays.asList(new String[]{"_cn", "_hk", "_tw", "_en"});
    private Map<String, Field> qmT = new HashMap();

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[45];
        aVar.columns = new String[46];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "LabsAppId";
        aVar.sKA.put("LabsAppId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" LabsAppId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "LabsAppId";
        aVar.columns[1] = "expId";
        aVar.sKA.put("expId", "TEXT default '' ");
        stringBuilder.append(" expId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "Type";
        aVar.sKA.put("Type", "INTEGER default '0' ");
        stringBuilder.append(" Type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "BizType";
        aVar.sKA.put("BizType", "INTEGER default '0' ");
        stringBuilder.append(" BizType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "Switch";
        aVar.sKA.put("Switch", "INTEGER default '0' ");
        stringBuilder.append(" Switch INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "AllVer";
        aVar.sKA.put("AllVer", "INTEGER default '0' ");
        stringBuilder.append(" AllVer INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "DetailURL";
        aVar.sKA.put("DetailURL", "TEXT");
        stringBuilder.append(" DetailURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "WeAppUser";
        aVar.sKA.put("WeAppUser", "TEXT");
        stringBuilder.append(" WeAppUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "WeAppPath";
        aVar.sKA.put("WeAppPath", "TEXT");
        stringBuilder.append(" WeAppPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "Pos";
        aVar.sKA.put("Pos", "INTEGER default '0' ");
        stringBuilder.append(" Pos INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "TitleKey_android";
        aVar.sKA.put("TitleKey_android", "TEXT");
        stringBuilder.append(" TitleKey_android TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "Title_cn";
        aVar.sKA.put("Title_cn", "TEXT");
        stringBuilder.append(" Title_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "Title_hk";
        aVar.sKA.put("Title_hk", "TEXT");
        stringBuilder.append(" Title_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "Title_tw";
        aVar.sKA.put("Title_tw", "TEXT");
        stringBuilder.append(" Title_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "Title_en";
        aVar.sKA.put("Title_en", "TEXT");
        stringBuilder.append(" Title_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "Desc_cn";
        aVar.sKA.put("Desc_cn", "TEXT");
        stringBuilder.append(" Desc_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "Desc_hk";
        aVar.sKA.put("Desc_hk", "TEXT");
        stringBuilder.append(" Desc_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "Desc_tw";
        aVar.sKA.put("Desc_tw", "TEXT");
        stringBuilder.append(" Desc_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "Desc_en";
        aVar.sKA.put("Desc_en", "TEXT");
        stringBuilder.append(" Desc_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "Introduce_cn";
        aVar.sKA.put("Introduce_cn", "TEXT");
        stringBuilder.append(" Introduce_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "Introduce_hk";
        aVar.sKA.put("Introduce_hk", "TEXT");
        stringBuilder.append(" Introduce_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "Introduce_tw";
        aVar.sKA.put("Introduce_tw", "TEXT");
        stringBuilder.append(" Introduce_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "Introduce_en";
        aVar.sKA.put("Introduce_en", "TEXT");
        stringBuilder.append(" Introduce_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "starttime";
        aVar.sKA.put("starttime", "LONG");
        stringBuilder.append(" starttime LONG");
        stringBuilder.append(", ");
        aVar.columns[24] = "endtime";
        aVar.sKA.put("endtime", "LONG");
        stringBuilder.append(" endtime LONG");
        stringBuilder.append(", ");
        aVar.columns[25] = "sequence";
        aVar.sKA.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[26] = "prioritylevel";
        aVar.sKA.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[27] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "ThumbUrl_cn";
        aVar.sKA.put("ThumbUrl_cn", "TEXT");
        stringBuilder.append(" ThumbUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "ThumbUrl_hk";
        aVar.sKA.put("ThumbUrl_hk", "TEXT");
        stringBuilder.append(" ThumbUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "ThumbUrl_tw";
        aVar.sKA.put("ThumbUrl_tw", "TEXT");
        stringBuilder.append(" ThumbUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "ThumbUrl_en";
        aVar.sKA.put("ThumbUrl_en", "TEXT");
        stringBuilder.append(" ThumbUrl_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "ImgUrl_android_cn";
        aVar.sKA.put("ImgUrl_android_cn", "TEXT");
        stringBuilder.append(" ImgUrl_android_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "ImgUrl_android_hk";
        aVar.sKA.put("ImgUrl_android_hk", "TEXT");
        stringBuilder.append(" ImgUrl_android_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "ImgUrl_android_tw";
        aVar.sKA.put("ImgUrl_android_tw", "TEXT");
        stringBuilder.append(" ImgUrl_android_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "ImgUrl_android_en";
        aVar.sKA.put("ImgUrl_android_en", "TEXT");
        stringBuilder.append(" ImgUrl_android_en TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "RedPoint";
        aVar.sKA.put("RedPoint", "INTEGER");
        stringBuilder.append(" RedPoint INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "WeAppDebugMode";
        aVar.sKA.put("WeAppDebugMode", "INTEGER");
        stringBuilder.append(" WeAppDebugMode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "idkey";
        aVar.sKA.put("idkey", "INTEGER");
        stringBuilder.append(" idkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[39] = "idkeyValue";
        aVar.sKA.put("idkeyValue", "INTEGER");
        stringBuilder.append(" idkeyValue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[40] = "Icon";
        aVar.sKA.put("Icon", "TEXT");
        stringBuilder.append(" Icon TEXT");
        stringBuilder.append(", ");
        aVar.columns[41] = "ImgUrl_cn";
        aVar.sKA.put("ImgUrl_cn", "TEXT");
        stringBuilder.append(" ImgUrl_cn TEXT");
        stringBuilder.append(", ");
        aVar.columns[42] = "ImgUrl_hk";
        aVar.sKA.put("ImgUrl_hk", "TEXT");
        stringBuilder.append(" ImgUrl_hk TEXT");
        stringBuilder.append(", ");
        aVar.columns[43] = "ImgUrl_tw";
        aVar.sKA.put("ImgUrl_tw", "TEXT");
        stringBuilder.append(" ImgUrl_tw TEXT");
        stringBuilder.append(", ");
        aVar.columns[44] = "ImgUrl_en";
        aVar.sKA.put("ImgUrl_en", "TEXT");
        stringBuilder.append(" ImgUrl_en TEXT");
        aVar.columns[45] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public int hashCode() {
        return this.field_LabsAppId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return ((a) obj).field_LabsAppId.equals(this.field_LabsAppId);
        }
        return false;
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.field_LabsAppId) || this.field_LabsAppId.equals("labs1de6f3")) ? false : true;
    }

    public final boolean isRunning() {
        return isValid() && System.currentTimeMillis() / 1000 > this.field_starttime && System.currentTimeMillis() / 1000 < this.field_endtime;
    }

    public final boolean bTJ() {
        return isValid() && System.currentTimeMillis() / 1000 >= this.field_endtime;
    }

    public String toString() {
        return "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + "]";
    }

    public final String Sa(String str) {
        Object wa = wa(str + "Key_android");
        if (!TextUtils.isEmpty(wa)) {
            wa = ad.getResources().getString(ad.getResources().getIdentifier(wa, "string", ad.getPackageName()));
            if (!TextUtils.isEmpty(wa)) {
                return wa;
            }
        }
        String fD = w.fD(ad.getContext());
        if (w.chM()) {
            return fv(str, "_cn");
        }
        if ("zh_HK".equals(fD)) {
            return fv(str, "_hk");
        }
        if ("zh_TW".equals(fD)) {
            return fv(str, "_tw");
        }
        return fv(str, "_en");
    }

    private String fv(String str, String str2) {
        Object wa = wa(str + str2);
        return !TextUtils.isEmpty(wa) ? wa : Sb(str);
    }

    private String Sb(String str) {
        for (String str2 : qmU) {
            String str22 = wa(str + str22);
            if (!TextUtils.isEmpty(str22)) {
                return str22;
            }
        }
        return "";
    }

    private String wa(String str) {
        Field field;
        Throwable e;
        Field field2 = (Field) this.qmT.get(str);
        if (field2 == null) {
            try {
                field = a.class.getField(str);
                try {
                    this.qmT.put(str, field);
                } catch (Throwable e2) {
                    e = e2;
                    x.w("LabAppInfo", bi.i(e));
                    if (field != null) {
                        try {
                            return (String) field.get(this);
                        } catch (Throwable e22) {
                            x.w("LabAppInfo", bi.i(e22));
                        }
                    }
                    return "";
                }
            } catch (NoSuchFieldException e3) {
                e = e3;
                field = field2;
            }
        } else {
            field = field2;
        }
        if (field != null) {
            try {
                return (String) field.get(this);
            } catch (Throwable e222) {
                x.w("LabAppInfo", bi.i(e222));
            }
        }
        return "";
    }

    public final boolean bYT() {
        return isRunning() && (this.field_Switch == 2 || this.field_Switch == 1);
    }
}
