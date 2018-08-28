package com.tencent.mm.k;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class f extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void bg(boolean z) {
        ad.chZ().edit().putBoolean("settings_new_msg_notification", z).commit();
        a.Dv().edit().putBoolean("settings_new_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bh(boolean z) {
        ad.chZ().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        a.Dv().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bi(boolean z) {
        ad.chZ().edit().putBoolean("settings_show_detail", z).commit();
        a.Dv().edit().putBoolean("settings_show_detail", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bj(boolean z) {
        a.Dv().edit().putBoolean("command_notification_status", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bk(boolean z) {
        ad.chZ().edit().putBoolean("settings_sound", z).commit();
        a.Dv().edit().putBoolean("settings_sound", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bl(boolean z) {
        ad.chZ().edit().putBoolean("settings_shake", z).commit();
        a.Dv().edit().putBoolean("settings_shake", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void fj(String str) {
        a.fj(str);
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[]{str});
    }

    public static void bm(boolean z) {
        ad.chZ().edit().putBoolean("settings_active_time_full", z).commit();
        a.Dv().edit().putBoolean("settings_active_time_full", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void aR(int i, int i2) {
        SharedPreferences chZ = ad.chZ();
        chZ.edit().putInt("settings_active_begin_time_hour", i).commit();
        chZ.edit().putInt("settings_active_begin_time_min", i2).commit();
        chZ = a.Dv();
        chZ.edit().putInt("settings_active_begin_time_hour", i).commit();
        chZ.edit().putInt("settings_active_begin_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void aS(int i, int i2) {
        SharedPreferences chZ = ad.chZ();
        chZ.edit().putInt("settings_active_end_time_hour", i).commit();
        chZ.edit().putInt("settings_active_end_time_min", i2).commit();
        chZ = a.Dv();
        chZ.edit().putInt("settings_active_end_time_hour", i).commit();
        chZ.edit().putInt("settings_active_end_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static boolean AL() {
        return a.gI(a.Du());
    }

    public static void fV(int i) {
        a.Dv().edit().putInt("notification.status.webonline.push.open", i).commit();
    }

    public static boolean AM() {
        return q.gT(a.Dv().getInt("notification.status.webonline.push.open", 0));
    }

    public static void AN() {
        SharedPreferences chZ = ad.chZ();
        Editor edit = a.Dv().edit();
        edit.putBoolean("settings_new_msg_notification", chZ.getBoolean("settings_new_msg_notification", true));
        edit.putBoolean("settings_new_voip_msg_notification", chZ.getBoolean("settings_new_voip_msg_notification", true));
        edit.putBoolean("settings_show_detail", chZ.getBoolean("settings_show_detail", true));
        edit.putBoolean("settings_sound", chZ.getBoolean("settings_sound", true));
        edit.putString("settings.ringtone", chZ.getString("settings.ringtone", dgL));
        edit.putBoolean("settings_shake", chZ.getBoolean("settings_shake", true));
        edit.putBoolean("settings_active_time_full", chZ.getBoolean("settings_active_time_full", true));
        edit.putInt("settings_active_begin_time_hour", chZ.getInt("settings_active_begin_time_hour", 8));
        edit.putInt("settings_active_begin_time_min", chZ.getInt("settings_active_begin_time_min", 0));
        edit.putInt("settings_active_end_time_hour", chZ.getInt("settings_active_end_time_hour", 23));
        edit.putInt("settings_active_end_time_min", chZ.getInt("settings_active_end_time_min", 0));
        edit.commit();
        x.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", new Object[]{Boolean.valueOf(r2), Boolean.valueOf(r3), Boolean.valueOf(r4), r5, Boolean.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0)});
    }

    public static boolean fW(int i) {
        return i == 50 || i == 53;
    }

    public static boolean fm(String str) {
        su suVar = new su();
        suVar.cdE.bOh = 1;
        suVar.cdE.content = str;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
        if (suVar.cdF.type == 2 || str.equals(bd.tby)) {
            return true;
        }
        return false;
    }

    public static boolean fn(String str) {
        su suVar = new su();
        suVar.cdE.bOh = 1;
        suVar.cdE.content = str;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
        if (suVar.cdF.type == 3 || str.equals(bd.tbx)) {
            return true;
        }
        return false;
    }

    public static int AO() {
        if (g.Eg().Dx()) {
            return t.hY(s.dAN);
        }
        x.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        return 0;
    }

    public static List<String> AP() {
        return t.hZ(s.dAN);
    }

    public static int AQ() {
        if (g.Eg().Dx()) {
            return t.hX(s.dAN);
        }
        x.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        return 0;
    }

    public static int fo(String str) {
        return t.M(str, null);
    }

    public static boolean fp(String str) {
        return ab.gY(str);
    }

    public static boolean fq(String str) {
        return str.toLowerCase().endsWith("@chatroom");
    }

    public static boolean fr(String str) {
        return s.hT(str) || (s.fq(str) && !s.hS(str));
    }

    public static int fs(String str) {
        return ((i) g.l(i.class)).FW().YF(str);
    }

    public static boolean e(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.YU(q.GF());
    }

    public static boolean AR() {
        return ((Boolean) g.Ei().DT().get(73217, Boolean.valueOf(true))).booleanValue();
    }

    public static boolean AS() {
        return ((Boolean) g.Ei().DT().get(73218, Boolean.valueOf(true))).booleanValue();
    }
}
