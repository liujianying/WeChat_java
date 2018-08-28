package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.os.Parcelable;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI.10;
import com.tencent.mm.ui.base.n$d;

class BaseScanUI$10$2 implements n$d {
    final /* synthetic */ 10 mHX;

    BaseScanUI$10$2(10 10) {
        this.mHX = 10;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                BaseScanUI baseScanUI = this.mHX.mHS;
                Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                intent.putExtra("android.intent.extra.shortcut.NAME", baseScanUI.getString(R.l.find_friends_by_qrcode));
                intent.putExtra("duplicate", false);
                Parcelable intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                intent2.addFlags(67108864);
                intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(baseScanUI, R.g.scan_shortcut_icon));
                intent.putExtra("shortcut_icon_resource_id", R.g.scan_shortcut_icon);
                b.n(baseScanUI, intent);
                h.mEJ.h(11410, new Object[0]);
                return;
            case 1:
                if (this.mHX.mHW != null) {
                    this.mHX.mHW.onClick(null);
                    return;
                }
                return;
            case 2:
                Intent intent3 = new Intent();
                intent3.setClass(this.mHX.mHS, ScannerHistoryUI.class);
                this.mHX.mHS.startActivity(intent3);
                h.mEJ.h(12684, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                return;
            default:
                return;
        }
    }
}
