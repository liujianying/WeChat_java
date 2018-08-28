package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.c.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class Updater extends LinearLayout implements e, a {
    private boolean bIq;
    private int sDi;
    private p sEn = null;
    private boolean sEo = false;
    private boolean sEp = false;
    private boolean sEq = false;
    private e sEr;
    private e sEs;

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        au.DF().a(11, this);
        h.mEJ.a(405, 42, 1, true);
    }

    public final void onStop() {
        h.mEJ.a(405, 43, 1, true);
        cancel();
    }

    public static Updater c(Context context, OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            x.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            return null;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE()).commit();
        au.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "showWithProgress");
        Updater updater = (Updater) View.inflate(context, R.i.updater, null);
        updater.onStart();
        p a = p.a(context, context.getString(R.l.update_getting_updateinfo), true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new 1(updater, onCancelListener));
        try {
            updater.sEn = a;
            updater.sEn.show();
            updater.bIq = true;
            h.mEJ.a(405, 46, 1, true);
            return updater;
        } catch (Throwable e) {
            x.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
            return null;
        }
    }

    public static Updater d(Context context, final OnCancelListener onCancelListener) {
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE()).commit();
        au.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "show update dialog");
        Updater updater = (Updater) View.inflate(context, R.i.updater, null);
        updater.onStart();
        p a = p.a(context, "", true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener(updater) {
            final /* synthetic */ Updater sEt;

            public final void onCancel(DialogInterface dialogInterface) {
                au.getNotification().cancel(99);
                h.mEJ.a(405, 49, 1, true);
                Updater.CU(2);
                this.sEt.onStop();
                if (!this.sEt.sEo && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        h.mEJ.a(405, 48, 1, true);
        updater.sEn = a;
        updater.bIq = false;
        return updater;
    }

    public static Updater fo(Context context) {
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE()).commit();
        au.getNotification().cancel(34);
        h.mEJ.a(405, 50, 1, true);
        x.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.sEp = true;
        return updater;
    }

    public static void dT(Context context) {
        context.startActivity(new Intent(context, AppInstallerUI.class));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            h.mEJ.a(405, 51, 1, true);
            x.i("MicroMsg.Updater", "isShow " + this.bIq);
            if (!(this.bIq || this.sEn == null)) {
                this.sEn.show();
            }
            this.sEo = true;
            if (this.sEn != null) {
                this.sEn.cancel();
            }
            final com.tencent.mm.sandbox.a.a aVar = (com.tencent.mm.sandbox.a.a) lVar;
            au.DF().a(new bg(new bg.a() {
                public final void a(com.tencent.mm.network.e eVar) {
                    long j;
                    String cce;
                    if (eVar == null) {
                        h.mEJ.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    au.getNotification().cancel(34);
                    x.i("MicroMsg.Updater", "go to update");
                    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
                        x.e("MicroMsg.Updater", "no sdcard.");
                        h.mEJ.a(405, 53, 1, true);
                        Updater.this.sEp = false;
                    }
                    int cgH = aVar.cgH();
                    i cG = i.cG(aVar.cgJ());
                    String eU = com.tencent.mm.pluginsdk.f.i.eU(Updater.this.getContext());
                    i.a aVar = null;
                    if (cG != null) {
                        aVar = cG.cF(eU);
                    }
                    if (aVar == null) {
                        j = (long) cgH;
                    } else {
                        j = (long) (aVar.size + cgH);
                    }
                    if (!f.aM(j)) {
                        x.e("MicroMsg.Updater", "no enough space.");
                        h.mEJ.a(405, 54, 1, true);
                        Updater.this.sEp = false;
                    }
                    if ((com.tencent.mm.sdk.platformtools.e.bxm & 1) != 0) {
                        x.i("MicroMsg.Updater", "channel pack, not silence download.");
                        h.mEJ.a(405, 55, 1, true);
                        Updater.this.sEp = false;
                    }
                    if (Updater.this.sDi == 2 && !Updater.this.sEq) {
                        cce = i.cce();
                        if (!(c.Hw(aVar.cgI()) == null || bi.oW(cce) || !cce.equals(aVar.cgI()))) {
                            x.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[]{cce});
                            h.mEJ.a(405, 56, 1, true);
                            return;
                        }
                    }
                    aiv bfy = aVar.bfy();
                    if (bfy == null || bfy.rLD == 0 || bi.oW(bfy.rLE)) {
                        if (Updater.this.sEp) {
                            x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            h.mEJ.a(405, 58, 1, true);
                            au.DF().a(725, Updater.this.sEr = new 1(this, eVar));
                            au.DF().a(new o(), 0);
                        } else {
                            x.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.a(Updater.this, intent, eVar, aVar);
                            x.i("MicroMsg.Updater", "current updateType : %s", new Object[]{Integer.valueOf(Updater.this.sDi)});
                            if (Updater.this.sDi == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                h.mEJ.a(405, 60, 1, true);
                            } else {
                                h.mEJ.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            Updater.this.getContext().startActivity(intent);
                        }
                        com.tencent.mm.s.c.Cp().u(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.cbG();
                        return;
                    }
                    cce = bfy.rLE;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", cce);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    i.chb();
                    h.mEJ.a(405, 57, 1, true);
                }
            }), 0);
            onStop();
            return;
        }
        h.mEJ.a(405, 62, 1, true);
        if (this.sEn != null) {
            p pVar = this.sEn;
            if (pVar.gFh != null) {
                pVar.gFh.setVisibility(8);
            }
            TextView textView = (TextView) this.sEn.findViewById(R.h.mm_progress_dialog_msg);
            if (i == 4 && i2 == -18) {
                com.tencent.mm.sdk.b.a.sFg.m(new bf());
                com.tencent.mm.ab.o DF = au.DF();
                4 4 = new 4(this, textView);
                this.sEs = 4;
                DF.a(922, 4);
            } else if (textView != null) {
                h.mEJ.a(405, 64, 1, true);
                textView.setText(R.l.update_err_getinfo);
                j.g(textView, 1);
            }
        }
        i.chf();
        cancel();
    }

    public final void a(Intent intent, e eVar) {
        String str;
        intent.putExtra("intent_short_ips", getShortIps());
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.qVN);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        boolean z = (eVar.kne == null || eVar.kne.isEmpty() || !eVar.kne.containsKey(Integer.valueOf(4))) ? false : true;
        if (z) {
            HashMap hashMap = eVar.kne;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(4));
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i = 0;
                    while (i < size) {
                        String str3;
                        avn avn = (avn) linkedList.get(i);
                        if (avn.lang.equalsIgnoreCase("default")) {
                            str3 = new String(Base64.decode(avn.content, 0));
                        } else if (avn.lang.equalsIgnoreCase(w.chP())) {
                            str = new String(Base64.decode(avn.content, 0));
                            break;
                        } else {
                            str3 = str;
                        }
                        i++;
                        str = str3;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra(str2, str);
        intent.putExtra("intent_extra_md5", eVar.kni);
        intent.putExtra("intent_extra_size", eVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{eVar.knh});
        intent.putExtra("intent_extra_patchInfo", eVar.cgW());
        intent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.e.bxm);
        intent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.e.sFB);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
    }

    private void cancel() {
        au.DF().b(11, this);
    }

    private String[] getShortIps() {
        int i = 0;
        if (af.ewV == null || af.ewV.length() <= 0) {
            String string = ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List Uz = n.Uz(string);
            String[] strArr = new String[Uz.size()];
            while (i < Uz.size()) {
                strArr[i] = ((n) Uz.get(i)).kCs;
                i++;
            }
            return strArr;
        }
        return new String[]{af.ewV};
    }

    public final void update(int i) {
        ah(i, false);
    }

    public final void ah(int i, boolean z) {
        x.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + i);
        this.sDi = i;
        this.sEq = z;
        h.mEJ.a(405, 44, 1, true);
        au.DF().a(new com.tencent.mm.sandbox.a.a(i), 0);
    }

    public static void c(String str, int i, String str2, String str3) {
        Intent intent = new Intent(ad.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.qVN);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.e.bxm);
        intent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.e.sFB);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        h.mEJ.a(405, 45, 1, true);
        ad.getContext().startService(intent);
    }

    public static void CU(int i) {
        if (au.HX()) {
            x.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + i);
            au.HU();
            com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.o(i));
        }
    }
}
