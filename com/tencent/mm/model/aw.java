package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;

public final class aw {
    public static SharedPreferences Ib() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            f.mDy.a(148, 12, 1, true);
            w wVar = new w(aa.duN + "autoauth.cfg");
            boolean commit;
            if (wVar.sOk || wVar.get(3) == null) {
                SharedPreferences sharedPreferences2 = ad.getContext().getSharedPreferences("auto_auth_key_prefs", 4);
                Editor edit = sharedPreferences.edit();
                if (bi.oW(sharedPreferences2.getString("_auth_key", ""))) {
                    x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", bi.cjd());
                } else {
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                    edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                    edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", ""));
                    edit.putString("server_id", ad.getContext().getSharedPreferences("server_id_prefs", 4).getString("server_id", ""));
                    commit = edit.commit();
                    x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                }
            } else {
                Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) wVar.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) wVar.get(2)).intValue());
                edit2.putString("_auth_key", (String) wVar.get(3));
                edit2.putString("server_id", (String) wVar.get(4));
                commit = edit2.commit();
                x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                f.mDy.a(148, 51, 1, true);
                return sharedPreferences;
            }
        }
        return sharedPreferences;
    }
}
