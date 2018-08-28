package com.tencent.mm.au;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public static Map<String, String> bn(int i, int i2) {
        switch (i) {
            case TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM /*201*/:
                return n.b(i, false, i2);
            default:
                return p.b(i, false, i2);
        }
    }

    public static String b(int i, Map<String, String> map) {
        switch (i) {
            case 21:
                return p.c(map, 1);
            case TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM /*201*/:
                return n.v(map);
            default:
                return p.v(map);
        }
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt != 0) {
            return optInt;
        }
        if (str.equals(context.getString(R.l.search_education_article))) {
            return 2;
        }
        if (str.equals(context.getString(R.l.search_education_timeline))) {
            return 8;
        }
        if (str.equals(context.getString(R.l.search_education_biz_contact))) {
            return 1;
        }
        x.i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
        return optInt;
    }

    public static Drawable b(int i, Context context) {
        int i2 = R.k.sos_search_icon;
        switch (i) {
            case 1:
                i2 = R.k.sos_offical_icon;
                break;
            case 2:
                i2 = R.k.sos_article_icon;
                break;
            case 8:
                i2 = R.k.sos_moments_icon;
                break;
            case 64:
                i2 = R.k.sos_mini_program_icon;
                break;
            case 256:
            case 384:
                i2 = R.k.sos_emoji_icon;
                break;
            case 512:
                i2 = R.k.sos_music_icon;
                break;
            case 1024:
                i2 = R.k.sos_novel_icon;
                break;
            case 12582912:
                i2 = R.k.sos_video_icon;
                break;
            case 16777248:
                i2 = R.k.sos_question_icon;
                break;
            case 16777728:
                i2 = R.k.sos_wiki_icon;
                break;
        }
        return context.getResources().getDrawable(i2);
    }

    public static boolean at(String str, String str2) {
        int i = 0;
        if (str == str2) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            while (i < str.length()) {
                stringBuilder.append(SpellMap.g(str.charAt(i)));
                i++;
            }
            str3 = stringBuilder.toString();
        }
        return str3.startsWith(str2);
    }
}
