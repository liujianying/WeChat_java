package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$10 implements OnClickListener {
    final /* synthetic */ AppUpdaterUI sDx;

    AppUpdaterUI$10(AppUpdaterUI appUpdaterUI) {
        this.sDx = appUpdaterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(this.sDx).nPm == 1) {
            i.ai(this.sDx, 6);
        }
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            AppUpdaterUI.b(this.sDx).dismiss();
            AppUpdaterUI.c(this.sDx);
        } else if ((AppUpdaterUI.e(this.sDx).bxm & 1) != 0) {
            x.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
            Uri parse = Uri.parse(AppUpdaterUI.e(this.sDx).bxo);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
            if (parse == null || addFlags == null || !bi.k(this.sDx, addFlags)) {
                x.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                this.sDx.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
            } else {
                x.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                this.sDx.startActivity(addFlags);
            }
            AppUpdaterUI.f(this.sDx);
        } else {
            String bq = c.bq(AppUpdaterUI.e(this.sDx).bKg, AppUpdaterUI.e(this.sDx).sEJ);
            if (bi.oW(bq) && AppUpdaterUI.e(this.sDx).sEE != null) {
                bq = c.VR(AppUpdaterUI.e(this.sDx).sEE.bxC);
            }
            x.d("MicroMsg.AppUpdaterUI", bq);
            if (bq != null) {
                x.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                AppUpdaterUI.a(this.sDx, 8);
                if (AppUpdaterUI.e(this.sDx).sEF) {
                    AppUpdaterUI.a(this.sDx, 0);
                } else {
                    AppUpdaterUI.a(this.sDx, 9);
                }
                AppUpdaterUI.e(this.sDx).ai(1, true);
                AppUpdaterUI.h(this.sDx).MX(bq);
                return;
            }
            x.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[]{Integer.valueOf(AppUpdaterUI.e(this.sDx).nPm)});
            x.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[]{Integer.valueOf(AppUpdaterUI.e(this.sDx).sDi)});
            if (AppUpdaterUI.e(this.sDx).nPm == 0) {
                AppUpdaterUI.e(this.sDx).chh();
            } else if (AppUpdaterUI.e(this.sDx).nPm == 1) {
                x.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                AppUpdaterUI.f(this.sDx);
                Intent intent = new Intent(this.sDx.getIntent());
                intent.setClass(this.sDx, UpdaterService.class);
                intent.putExtra("intent_extra_run_in_foreground", true);
                this.sDx.startService(intent);
                if (AppUpdaterUI.e(this.sDx).sEJ) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(614, 56, 1, false);
                    x.d("MicroMsg.AppUpdaterUI", "boots download start.");
                }
            } else {
                x.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
            }
        }
    }
}
