package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.plugin.y.b;
import com.tencent.mm.plugin.y.c;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class SubCoreSandBox implements ar, c {
    public static boolean mFe = false;
    public static boolean mFf = false;

    public SubCoreSandBox() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    }

    public final HashMap<Integer, d> Ci() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        return null;
    }

    public final void gi(int i) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    }

    public final void bfz() {
        Updater.CU(16);
    }

    public final a a(Context context, OnCancelListener onCancelListener) {
        return Updater.c(context, onCancelListener);
    }

    public final a b(Context context, OnCancelListener onCancelListener) {
        return Updater.d(context, onCancelListener);
    }

    public final a dS(Context context) {
        return Updater.fo(context);
    }

    public final void dT(Context context) {
        Updater.dT(context);
    }

    public final void c(String str, int i, String str2, String str3) {
        Updater.c(str, i, str2, str3);
    }

    public final b bfA() {
        return new com.tencent.mm.sandbox.a.a(2);
    }

    public final String Hw(String str) {
        return com.tencent.mm.sandbox.monitor.c.Hw(str);
    }

    public final void t(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ExceptionMonitorService.class);
            ad.getContext().startService(intent);
        }
    }

    public final void u(Context context, Intent intent) {
        intent.setClass(context, AppUpdaterUI.class);
        context.startActivity(intent);
    }

    public final void gB(boolean z) {
        mFe = true;
        mFf = z;
    }
}
