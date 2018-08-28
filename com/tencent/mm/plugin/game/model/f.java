package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class f {
    private static String jLC = "";

    public static LinkedList<com.tencent.mm.pluginsdk.model.app.f> aTy() {
        x.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList<com.tencent.mm.pluginsdk.model.app.f> linkedList = new LinkedList();
        linkedList.addAll(((b) g.l(b.class)).aSf().jLa);
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            com.tencent.mm.pluginsdk.model.app.f fVar = (com.tencent.mm.pluginsdk.model.app.f) it.next();
            if (fVar != null) {
                x.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i == 0) {
                        x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                        linkedList2.add(fVar);
                    }
                }
            }
            i = 0;
            if (i == 0) {
                x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                linkedList2.add(fVar);
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        return linkedList;
    }

    public static LinkedList<String> aTz() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(((b) g.l(b.class)).aSf().jKZ);
        return linkedList;
    }

    public static void ah(Context context, String str) {
        a(context, str, null, "WX_GameCenter", new 1(str));
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        if (bi.oW(str)) {
            x.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (aVar != null) {
                aVar.cI(false);
            }
        }
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
        if (bl == null || bi.oW(bl.field_appId)) {
            x.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (aVar != null) {
                aVar.cI(false);
            }
        } else if (p.b(context, bl)) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = 620823808;
            wXMediaMessage.messageAction = str2;
            wXMediaMessage.messageExt = str3;
            x.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[]{bl.field_appId, bl.field_appName, bl.field_openId});
            if (bi.oW(bl.field_openId)) {
                x.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[]{bl.field_appName});
                com.tencent.mm.plugin.ac.a.bmh().pS(bl.field_appId);
            }
            com.tencent.mm.bu.a.post(new 2(context, bl, wXMediaMessage, aVar));
        } else {
            x.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[]{bl.field_appName});
            Toast.makeText(context, context.getString(i.game_launch_fail_alert, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(context, bl, null)}), 1).show();
            if (aVar != null) {
                aVar.cI(false);
            }
        }
    }

    public static String aTA() {
        String fS = bi.fS(ad.getContext());
        if (bi.oW(fS)) {
            fS = "CN";
        }
        return fS.toUpperCase();
    }

    public static GameRegionPreference.a dr(Context context) {
        Object dz = dz(context);
        if (bi.oW(dz)) {
            dz = aTA();
        }
        return (GameRegionPreference.a) com.tencent.mm.plugin.game.e.a.a.aVh().aVg().get(dz);
    }

    public static String a(GameRegionPreference.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String oV = bi.oV(w.chP());
            if ("zh_CN".equalsIgnoreCase(oV)) {
                stringBuffer.append(aVar.kby);
            } else if ("zh_TW".equalsIgnoreCase(oV) || "zh_HK".equalsIgnoreCase(oV)) {
                stringBuffer.append(aVar.kbz);
            } else {
                stringBuffer.append(aVar.kbA);
            }
        }
        return stringBuffer.toString();
    }

    public static String aTB() {
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.e.a.a.aVh().aVg().get(aTA());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.kby);
            stringBuffer.append(Dv("zh_CN"));
        }
        return stringBuffer.toString();
    }

    public static String aTC() {
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.e.a.a.aVh().aVg().get(aTA());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.kbz);
            stringBuffer.append(Dv("zh_TW"));
        }
        return stringBuffer.toString();
    }

    public static String aTD() {
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.e.a.a.aVh().aVg().get(aTA());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.kbA);
            stringBuffer.append(Dv("en"));
        }
        return stringBuffer.toString();
    }

    private static String Dv(String str) {
        String str2;
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = ad.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bi.i(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (Throwable e22) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bi.i(e22)});
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bi.i(e3)});
                }
            }
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            x.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[]{str2});
            return "";
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            return split[0];
        } else {
            if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
                return split[1];
            }
            return split[2];
        }
    }

    public static void dn(Context context) {
        context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
    }

    public static void aTE() {
        ad.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", w.chP()).commit();
    }

    public static String aTF() {
        return ad.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", w.chP());
    }

    public static boolean aTG() {
        return System.currentTimeMillis() - ((Long) g.Ei().DT().get(aa.a.sON, Long.valueOf(0))).longValue() > 86400000;
    }

    public static void aTH() {
        g.Ei().DT().a(aa.a.sON, Long.valueOf(System.currentTimeMillis()));
    }

    public static void ai(Context context, String str) {
        int i = 0;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bi.oW(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
        }
    }

    public static void aj(Context context, String str) {
        int i = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (!bi.oW(string) && string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                String str3 = split[i];
                if (!str3.contains(str)) {
                    if (i == split.length - 1) {
                        str2 = str2 + str3;
                    } else {
                        str2 = str2 + str3 + ",";
                    }
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        }
    }

    public static void ds(Context context) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (!bi.oW(string)) {
            String[] split = string.split(",");
            string = new String();
            for (String str : split) {
                String[] split2 = str.split("-");
                String str2 = split2[0];
                if (!(bi.oW(str2) || com.tencent.mm.pluginsdk.model.app.g.r(context, str2))) {
                    if (currentTimeMillis - bi.getLong(split2[1], 0) < 86400) {
                        string = string + str + ",";
                    } else {
                        FileDownloadTaskInfo yO = d.aCU().yO(str2);
                        x.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", new Object[]{Integer.valueOf(yO.status), Long.valueOf(yO.id)});
                        if (yO.status == 2) {
                            d.aCU().cl(yO.id);
                        } else if ((yO.status == 0 || yO.status == 4) && e.cn(yO.path)) {
                            e.deleteFile(yO.path);
                        }
                    }
                }
            }
            if (!bi.oW(string)) {
                if (string.charAt(string.length() - 1) == ',') {
                    string = string.substring(0, string.length() - 1);
                }
                sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
            }
        }
    }

    public static boolean dt(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
    }

    public static void du(Context context) {
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
    }

    public static Set<String> dv(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    }

    public static void a(Context context, Set<String> set) {
        context.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", set).commit();
    }

    public static ShapeDrawable cm(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static boolean dw(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
    }

    public static void dx(Context context) {
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
    }

    public static int dy(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
    }

    public static void F(Context context, int i) {
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i).apply();
    }

    public static String aTI() {
        ab aTM = h.aTL().aTM();
        return aTM != null ? aTM.jOU : "";
    }

    public static int aTJ() {
        ab aTM = h.aTL().aTM();
        return aTM != null ? aTM.jQq : 0;
    }

    public static String dz(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    }

    public static void ak(Context context, String str) {
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
    }

    public static boolean dA(Context context) {
        if (context.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1) {
            return false;
        }
        return true;
    }

    public static void dB(Context context) {
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
    }

    public static String aTK() {
        return jLC;
    }
}
