package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.support.design.a$i;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class p {
    boolean eLU = true;
    Runnable tlh;

    public final boolean c(Activity activity, Runnable runnable) {
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", ""))});
        if (a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
            x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", ""))});
            if (a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.tkm));
                g.er(LauncherUI.tkm);
                return true;
            }
            this.tlh = runnable;
            return false;
        }
        this.tlh = runnable;
        return false;
    }

    public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI.LauncherUICheckPermissionHelper";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            ah.i(new 1(this), 500);
            return true;
        }
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        int i2;
        switch (i) {
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
            case 64:
            case 96:
                i2 = R.l.permission_storage_request_again_msg;
                if (i == 96) {
                    i2 = R.l.permission_phone_request_again_msg;
                } else if (i == 64) {
                    i2 = R.l.permission_location_request_again_msg;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        f.mDy.a(462, 0, 1, true);
                    } else if (i == 96) {
                        f.mDy.a(462, 1, 1, true);
                        q.bc(true);
                    } else {
                        f.mDy.a(462, 2, 1, true);
                    }
                    if (this.tlh != null) {
                        this.tlh.run();
                    }
                } else {
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.l.permission_tips_title), activity.getString(R.l.jump_to_settings), activity.getString(R.l.cancel), false, new 2(this, i, activity), new 3(this, i, activity));
                }
                return true;
            case a$i.AppCompatTheme_actionModeCopyDrawable /*33*/:
            case 70:
            case 97:
                i2 = R.l.permission_storage_request_again_msg;
                if (i == 97) {
                    i2 = R.l.permission_phone_request_again_msg;
                } else if (i == 70) {
                    i2 = R.l.permission_location_request_again_msg;
                }
                if (iArr[0] != 0) {
                    this.eLU = false;
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.l.permission_tips_title), activity.getString(R.l.jump_to_settings), activity.getString(R.l.cancel), false, new 4(this, i, activity), new 5(this, i, activity));
                } else if (i == 33) {
                    f.mDy.a(462, 9, 1, true);
                } else if (i == 97) {
                    f.mDy.a(462, 10, 1, true);
                } else {
                    f.mDy.a(462, 11, 1, true);
                }
                return true;
            default:
                return false;
        }
    }
}
