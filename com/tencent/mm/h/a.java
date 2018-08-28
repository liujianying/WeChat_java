package com.tencent.mm.h;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public String bHD;
    private c cZM;
    public String desc;
    public int showType;
    public String url;

    public static a eV(String str) {
        c eX = c.eX(str);
        if (eX == null) {
            return null;
        }
        a aVar = new a();
        aVar.cZM = eX;
        aVar.url = eX.url;
        aVar.desc = eX.desc;
        aVar.showType = eX.showType;
        aVar.bHD = eX.bHD;
        return aVar;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (this.showType == 3 || this.showType == 4) {
            String str = this.cZM.cZY;
            String str2 = this.cZM.cZZ;
            if (bi.oW(str) && bi.oW(str2)) {
                str = context.getString(this.showType == 3 ? h.app_yes : h.app_ok);
                str2 = context.getString(this.showType == 3 ? h.app_no : h.app_cancel);
            }
            if (bi.oW(str) || bi.oW(str2)) {
                String str3 = this.desc;
                String str4 = this.bHD;
                if (!bi.oW(str)) {
                    str2 = str;
                }
                if (!bi.oW(str)) {
                    onClickListener2 = onClickListener;
                }
                com.tencent.mm.ui.base.h.a(context, str3, str4, str2, onClickListener2);
            } else {
                com.tencent.mm.ui.base.h.a(context, this.desc, this.bHD, str, str2, onClickListener, onClickListener2);
            }
            return true;
        } else if (this.showType == 1) {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.bHD, true);
            return true;
        } else if (this.showType != 5) {
            return false;
        } else {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.bHD, true);
            return true;
        }
    }
}
