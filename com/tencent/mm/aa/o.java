package com.tencent.mm.aa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class o implements e {
    private Context context;
    private ProgressDialog dId;
    private Runnable dIe = null;
    private Runnable dIf = null;
    private String path;

    public o(Context context, String str) {
        this.context = context;
        this.path = str;
        this.dId = null;
        g.DF().a(157, this);
    }

    public final boolean b(int i, Runnable runnable) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.dIe = runnable;
        Context context = this.context;
        this.context.getString(h.app_tip);
        this.dId = com.tencent.mm.ui.base.h.a(context, this.context.getString(h.settings_uploading_hd_avatar), true, null);
        g.DF().a(new n(i, this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.dIe = runnable;
        this.dIf = runnable2;
        g.DF().a(new n(1, this.path), 0);
        x.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[]{Boolean.valueOf(false)});
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        g.DF().b(157, this);
        if (this.dId != null && this.dId.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.dId.dismiss();
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, h.settings_upload_hd_avatar_success, 0).show();
            if (this.dIe != null) {
                new ag(Looper.getMainLooper()).post(this.dIe);
                return;
            }
            return;
        }
        if (this.dIf != null) {
            new ag(Looper.getMainLooper()).post(this.dIf);
        }
        if (str != null && str.length() > 0) {
            a eV = a.eV(str);
            if (eV != null) {
                eV.a(this.context, null, null);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, h.contact_info_no_user, 0).show();
        } else {
            Toast.makeText(this.context, h.settings_upload_hd_avatar_fail, 0).show();
        }
    }
}
