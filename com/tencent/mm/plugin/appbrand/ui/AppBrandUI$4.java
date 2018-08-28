package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;

class AppBrandUI$4 implements OnClickListener {
    final /* synthetic */ AppBrandUI gwE;
    final /* synthetic */ AppBrandRemoteTaskController gwF;

    AppBrandUI$4(AppBrandUI appBrandUI, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.gwE = appBrandUI;
        this.gwF = appBrandRemoteTaskController;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.gwE.mController.tml.finish();
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.gwF;
        appBrandRemoteTaskController.gts = a.gtD;
        appBrandRemoteTaskController.gtt = 0;
        AppBrandMainProcessService.a(appBrandRemoteTaskController);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        d.e(this.gwE.mController.tml, ".ui.LauncherUI", intent);
    }
}
