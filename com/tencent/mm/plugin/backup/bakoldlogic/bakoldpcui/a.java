package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private View gYR = null;
    private int gZU = -1;
    private ag handler = new ag(Looper.getMainLooper());
    private int hay = 0;
    private c haz;

    static /* synthetic */ boolean a(a aVar) {
        aVar.hay = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().asY();
        x.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZU), Integer.valueOf(aVar.hay)});
        return aVar.dE(false);
    }

    static /* synthetic */ void d(a aVar) {
        Intent intent = new Intent((Context) aVar.qJS.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.D((Context) aVar.qJS.get(), intent);
    }

    static /* synthetic */ void e(a aVar) {
        Intent intent = new Intent((Context) aVar.qJS.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.D((Context) aVar.qJS.get(), intent);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.gYR = this.view.findViewById(R.h.bakchat_banner_view);
            this.gYR.setOnClickListener(new 2(this));
        }
        anR();
        this.haz = new 1(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.haz);
    }

    public final int getLayoutId() {
        return R.i.bakchat_banner_view;
    }

    private boolean dE(boolean z) {
        this.gZU = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZU;
        x.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", new Object[]{Integer.valueOf(this.gZU), Boolean.valueOf(z)});
        if (this.gZU < 2 || this.gZU > 6) {
            this.gYR.setVisibility(8);
            return false;
        }
        this.gYR.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().asV()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().a((d) this);
        }
        if (2 == this.gZU) {
            ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.bak_chat_banner_preparing, new Object[]{Integer.valueOf(this.hay)}));
        } else if (3 == this.gZU) {
            ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.bak_chat_banner_uploading, new Object[]{Integer.valueOf(this.hay)}));
        } else if (4 == this.gZU) {
            ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.bak_chat_banner_upload_success));
            ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_comfirm);
        } else if (5 == this.gZU) {
            ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
            ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.bak_chat_banner_downloading, new Object[]{Integer.valueOf(this.hay)}));
        } else if (6 == this.gZU) {
            ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.bak_chat_banner_recover_wait));
            ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_comfirm);
        }
        return true;
    }

    public final boolean anR() {
        this.hay = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().asY();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().a((d) this);
        return dE(true);
    }

    public final void release() {
        this.gZU = -1;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().asW();
    }

    public final void onError(int i) {
    }

    public final void mT(int i) {
        x.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZU), Integer.valueOf(i)});
        this.hay = i;
        this.handler.post(new 3(this));
    }

    public final void mU(int i) {
        x.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZU), Integer.valueOf(i)});
    }

    public final void atb() {
        x.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZU)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO();
        e.mP(17);
        this.handler.post(new 4(this));
    }

    public final void aqO() {
    }

    public final void atc() {
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.haz);
    }

    public final int getOrder() {
        return 3;
    }
}
