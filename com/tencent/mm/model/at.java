package com.tencent.mm.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class at extends c {
    public static at dBv = new at(c.duQ);

    private at(c cVar) {
        super(cVar.duR);
    }

    public final void T(String str, String str2) {
        x.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.duR.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            ad.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", str2).commit();
        }
    }

    public final void c(String str, int i, String str2) {
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
            T("last_login_bind_qq", String.valueOf(i));
        }
        if (!bi.oW(str2)) {
            i2 |= 2;
            T("last_login_bind_email", String.valueOf(str2));
        }
        if (!bi.oW(str)) {
            i2 |= 4;
            T("last_login_bind_mobile", str);
        }
        T("last_bind_info", String.valueOf(i2));
    }

    public final String HL() {
        return I("last_avatar_path", "");
    }

    public final void iy(String str) {
        x.i("MicroMsg.LastLoginInfo", "Save last avatar: " + str);
        if (!bi.oW(str)) {
            String substring = str.substring(str.lastIndexOf(47) + 1);
            if (!bi.oW(substring)) {
                substring = e.duN + substring;
                boolean deleteFile = FileOp.deleteFile(substring);
                x.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", substring, Boolean.valueOf(deleteFile));
                FileOp.y(str, substring);
                T("last_avatar_path", substring);
            }
        }
    }
}
