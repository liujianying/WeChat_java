package com.tencent.mm.plugin.sns.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsSightPlayerUI$5 implements OnCreateContextMenuListener {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$5(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i;
        if (bi.WU(g.AT().getValue("SIGHTCannotTransmitForFav")) == 0) {
            x.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.cn(SnsSightPlayerUI.c(this.obb))), Boolean.valueOf(FileOp.cn(SnsSightPlayerUI.t(this.obb)))});
            if (FileOp.cn(SnsSightPlayerUI.c(this.obb)) && r3) {
                contextMenu.add(0, 3, 0, this.obb.getString(j.sns_ad_video_right_menu_send_friend));
                i = 1;
                if (d.QS("favorite")) {
                    contextMenu.add(0, 2, 0, this.obb.getString(j.plugin_favorite_opt));
                }
                if (i != 0) {
                    dj djVar = new dj();
                    djVar.bLf.bKW = SnsSightPlayerUI.d(this.obb);
                    a.sFg.m(djVar);
                    if (djVar.bLg.bKE) {
                        contextMenu.add(0, 4, 0, this.obb.getString(j.app_open));
                    }
                }
                if (!SnsSightPlayerUI.i(this.obb)) {
                    contextMenu.add(0, 1, 0, this.obb.mController.tml.getString(j.sns_timeline_expose));
                }
            }
        }
        i = 0;
        if (d.QS("favorite")) {
            contextMenu.add(0, 2, 0, this.obb.getString(j.plugin_favorite_opt));
        }
        if (i != 0) {
            dj djVar2 = new dj();
            djVar2.bLf.bKW = SnsSightPlayerUI.d(this.obb);
            a.sFg.m(djVar2);
            if (djVar2.bLg.bKE) {
                contextMenu.add(0, 4, 0, this.obb.getString(j.app_open));
            }
        }
        if (!SnsSightPlayerUI.i(this.obb)) {
            contextMenu.add(0, 1, 0, this.obb.mController.tml.getString(j.sns_timeline_expose));
        }
    }
}
