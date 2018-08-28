package com.tencent.mm.k;

import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class a {
    public static final String dgL = null;
    private static SharedPreferences dgM = null;
    private static SharedPreferences dgN = null;
    private static String dgO = dgL;

    public static SharedPreferences Ah() {
        SharedPreferences US = aa.US();
        dgN = US;
        return US;
    }

    public static boolean Ai() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("command_notification_status", false);
    }

    public static boolean Aj() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_new_msg_notification", true);
    }

    public static boolean Ak() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_new_voip_msg_notification", true);
    }

    public static boolean Al() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_show_detail", true);
    }

    public static boolean Am() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_sound", true);
    }

    public static String An() {
        String string = com.tencent.mm.kernel.a.Dv().getString("settings.ringtone", dgL);
        if (!(string == dgL || string.equals(dgO))) {
            RingtoneManager ringtoneManager = new RingtoneManager(ad.getContext());
            ringtoneManager.setType(2);
            if (ringtoneManager.getRingtonePosition(Uri.parse(string)) < 0) {
                string = dgL;
                fj(string);
                x.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
            }
            dgO = string;
        }
        return string;
    }

    static void fj(String str) {
        ad.chZ().edit().putString("settings.ringtone", str).commit();
        com.tencent.mm.kernel.a.Dv().edit().putString("settings.ringtone", str).commit();
    }

    public static boolean Ao() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_shake", true);
    }

    public static boolean Ap() {
        return com.tencent.mm.kernel.a.Dv().getBoolean("settings_active_time_full", true);
    }

    public static int Aq() {
        return com.tencent.mm.kernel.a.Dv().getInt("settings_active_begin_time_hour", 8);
    }

    public static int Ar() {
        return com.tencent.mm.kernel.a.Dv().getInt("settings_active_end_time_hour", 23);
    }

    public static int As() {
        return com.tencent.mm.kernel.a.Dv().getInt("settings_active_begin_time_min", 0);
    }

    public static int At() {
        return com.tencent.mm.kernel.a.Dv().getInt("settings_active_end_time_min", 0);
    }

    public static boolean aQ(int i, int i2) {
        if (Ap()) {
            return true;
        }
        int Aq = Aq();
        int As = As();
        int Ar = Ar();
        int At = At();
        if (Aq == Ar && As == At) {
            return false;
        }
        if (Aq != Ar || As >= At) {
            if (Ar > Aq) {
                if (i > Aq && i < Ar) {
                    return true;
                }
                if (i == Aq && i2 > As) {
                    return true;
                }
                if (i != Ar || i2 >= At) {
                    return false;
                }
                return true;
            } else if (Ar >= Aq && (Aq != Ar || As <= At)) {
                return true;
            } else {
                if (i > Aq && i <= 23) {
                    return true;
                }
                if (i == Aq && i2 > As) {
                    return true;
                }
                if (i == Ar && i2 < At) {
                    return true;
                }
                if (i <= 0 || i >= Ar) {
                    return false;
                }
                return true;
            }
        } else if (i != Aq || i2 <= As || i2 >= At) {
            return false;
        } else {
            return true;
        }
    }
}
