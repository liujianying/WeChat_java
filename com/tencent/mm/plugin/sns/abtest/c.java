package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static String nhW = "0";
    private static Set<Long> nhX = new HashSet();
    private static OnClickListener nhY;
    private static boolean nhl = false;
    private static com.tencent.mm.sdk.b.c nhu = new 1();

    static /* synthetic */ void Q(Context context, String str) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            String str2 = Nk.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", Nk.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void n(long j, boolean z) {
        if (nhl) {
            g.IW().iP("6").dDS = 3;
            g.IW().iP("6").result = (z ? 2 : 1) + "|" + j;
            f.a(g.IW().iP("6"));
            x.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0});
        }
    }

    public static void bwI() {
        if (g.IW().iP("6") != null) {
            nhW = g.IW().iP("6").value;
            x.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[]{nhW});
            nhl = true;
            a.sFg.b(nhu);
            nhY = new 2();
        }
    }

    public static void bwJ() {
        nhY = null;
        a.sFg.c(nhu);
        if (nhl) {
            g.IW().iP("6").dDS = 2;
            g.IW().iP("6").result = nhX.size();
            f.a(g.IW().iP("6"));
            x.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[]{Integer.valueOf(2), nhX.size()});
        }
        nhW = "0";
        nhl = false;
        nhX.clear();
    }

    public static void b(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (nhl) {
            cVar.ojp = false;
            cVar.ojn = (ViewStub) view.findViewById(i.f.sns_post_hate_stub);
            cVar.ojn.setVisibility(8);
        }
    }
}
