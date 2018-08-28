package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.b.a;
import com.tencent.mm.ui.chatting.a.b.e;

public final class f extends b {
    int gBh = -1;
    private int jub = 0;
    int tYk = 0;

    public f(Context context) {
        super(context);
    }

    public final int getType() {
        return 3;
    }

    public final void cwG() {
        this.tXZ.cwK();
        g.Ek();
        g.Em().H(new 1(this));
    }

    public final String Wm() {
        return this.mContext.getString(R.l.all_history_music);
    }

    public final String cwJ() {
        return this.mContext.getString(R.l.all_history_music);
    }

    public final e cwH() {
        return new 2(this);
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.url_list_item, viewGroup, false));
    }

    public final void a(a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) EZ(i);
        bVar.hrs.setText(i.f(this.mContext, aVar2.timestamp));
        Bitmap a = o.Pf().a(aVar2.imagePath, com.tencent.mm.bp.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bp.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                bVar.gmn.setImageResource(R.k.app_attach_file_icon_webpage);
                bVar.jet.setText(bi.aG(aVar2.bhd, ""));
                b.e(bVar.jet, this.tYa.tNU);
            }
        }
        bVar.gmn.setImageBitmap(a);
        bVar.jet.setText(bi.aG(aVar2.bhd, ""));
        b.e(bVar.jet, this.tYa.tNU);
    }

    protected final void a(String str, String str2, String str3, int i, String str4, long j, long j2, bd bdVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            return;
        }
        if (ao.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.gBf);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String i2 = i(bdVar, s.fq(this.gBf));
        intent.putExtra("pre_username", i2);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (bdVar != null) {
            intent.putExtra("preUsername", i2);
        }
        intent.putExtra("preChatName", this.gBf);
        intent.putExtra("preChatTYPE", com.tencent.mm.model.t.N(i2, this.gBf));
        intent.putExtra("preMsgIndex", 0);
        d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
            if (bl == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bl.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
