package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ab.h;
import com.tencent.mm.ac.d;
import com.tencent.mm.ar.k;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.a;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.d.q;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.ui.w;

final class r implements h, g, i, l {
    r() {
    }

    public final void vl() {
        o.PM().id(7);
    }

    public final void eu(int i) {
        x.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[]{Integer.valueOf(i)});
        o.PM().id(i);
    }

    public final com.tencent.mm.ab.g vm() {
        return new a(ad.getContext());
    }

    public final String s(String str, int i) {
        if (com.tencent.mm.pluginsdk.model.app.g.cP(str, i) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.cP(str, i).field_packageName;
        }
        return "";
    }

    public final String cS(String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.bl(str, false) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.bl(str, false).field_packageName;
        }
        return "";
    }

    public final String q(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.q(context, str);
    }

    public final boolean cT(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cT(str);
    }

    public final boolean r(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.r(context, str);
    }

    public final String h(Context context, String str, String str2) {
        return p.h(context, str, str2);
    }

    public final String B(String str, String str2) {
        return p.B(str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (aSm != null) {
            aSm.a(context, str, str2, str3, i, i2, i3, str4, str5);
        }
    }

    public final void a(String str, String str2, String str3, long j) {
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (aSm != null) {
            aSm.a(str, str2, 2, 4, str3, j);
        }
    }

    public final void vn() {
        ro roVar = new ro();
        roVar.ccs.ccu = true;
        com.tencent.mm.sdk.b.a.sFg.m(roVar);
    }

    public final com.tencent.mm.ab.l aG(boolean z) {
        if (z) {
            com.tencent.mm.ar.r.Qp().ij(4);
        }
        k kVar = new k(4);
        au.DF().a(kVar, 0);
        return kVar;
    }

    public final boolean cU(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cU(str);
    }

    public final boolean a(Context context, int i, int i2, String str) {
        return w.a.a(context, i, i2, str, 4);
    }

    public final boolean b(Context context, int i, int i2, String str) {
        return w.a.a(context, i, i2, str, 7);
    }

    public final void vo() {
        MMAppMgr.vo();
    }

    public final boolean f(Activity activity) {
        if (f.zZ()) {
            com.tencent.mm.pluginsdk.ui.tools.l.Q(activity);
            return true;
        }
        s.gH(activity);
        return false;
    }

    public final void bb(Context context) {
        MMAppMgr.go(context);
    }

    public final void g(Activity activity) {
        MMAppMgr.a(activity, null);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return null;
        }
        String d;
        switch (i) {
            case 2:
                if (intent == null) {
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.dgs + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.dgs, 4);
                return null;
            case 3:
                d = com.tencent.mm.pluginsdk.ui.tools.l.d(activity.getApplicationContext(), intent, e.dgs);
                if (d == null) {
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.dgs + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", d);
                activity.startActivityForResult(intent3, 4);
                return null;
            case 4:
                if (intent == null) {
                    return null;
                }
                d = intent.getStringExtra("CropImage_OutputPath");
                if (d == null) {
                    x.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    return null;
                }
                x.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[]{d});
                return c.Wb(d);
            default:
                return null;
        }
    }

    public final Intent vp() {
        Intent intent = new Intent(ad.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        return intent;
    }

    public final com.tencent.mm.ab.l a(com.tencent.mm.ab.f fVar) {
        if (com.tencent.mm.modelmulti.l.PJ()) {
            return new com.tencent.mm.modelmulti.f(fVar);
        }
        o.PM().id(4);
        return null;
    }

    public final boolean a(ab abVar) {
        return com.tencent.mm.modelmulti.a.a(abVar);
    }

    public final void a(d dVar, Activity activity, ab abVar, boolean z, Runnable runnable) {
        b.a(dVar, activity, abVar, z, runnable, 0);
    }

    public final void a(d dVar, Activity activity, ab abVar) {
        b.c(dVar, activity, abVar);
    }

    public final boolean vq() {
        return q.vq();
    }

    public final void a(Intent intent, bja bja, int i) {
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, bja, i);
    }

    public final void vr() {
        com.tencent.mm.booter.o.vr();
    }

    public final void a(Context context, bd.a aVar, Bundle bundle) {
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
    }

    public final void a(Context context, ab abVar, bd.a aVar, Bundle bundle, String str) {
        com.tencent.mm.ui.contact.e.a(context, abVar, aVar, true, true, bundle, str);
    }

    public final void a(Intent intent, String str) {
        com.tencent.mm.ui.contact.e.a(intent, str);
    }

    public final void cV(String str) {
        o.PN().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
    }

    public final void a(aue aue, String str) {
        ((com.tencent.mm.plugin.messenger.foundation.a.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(aue, str);
    }

    public final boolean vs() {
        return com.tencent.mm.modelmulti.l.PJ();
    }
}
