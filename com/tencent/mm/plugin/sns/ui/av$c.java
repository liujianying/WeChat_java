package com.tencent.mm.plugin.sns.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;

class av$c implements OnCreateContextMenuListener {
    private String bNH;
    private bsu nMH;
    private n nSE;
    private ate noc;
    private View targetView;
    private String url;

    av$c() {
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Object tag = view.getTag();
        if (tag instanceof r) {
            r rVar = (r) tag;
            bsu bsu = rVar.nMH;
            view.getContext();
            String str = bsu.sqc.jPK;
            String str2 = bsu.sqb.ksA;
            str = av.Ob(str);
            if (str != null && str.length() != 0) {
                this.url = str;
                this.bNH = rVar.bKW;
                this.targetView = view;
                this.noc = bsu.sqc.ruA.size() > 0 ? (ate) bsu.sqc.ruA.get(0) : null;
                this.nSE = af.byo().Nl(this.bNH);
                this.nMH = bsu;
                if (bsu.sqc.ruz != 10 && bsu.sqc.ruz != 13) {
                    if (d.QS("favorite")) {
                        switch (bsu.sqc.ruz) {
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                        }
                    }
                    if (this.nSE != null && !this.nSE.field_userName.equals(af.bxU())) {
                        contextMenu.add(0, 8, 0, view.getContext().getString(j.contact_info_op_sns_permission));
                    }
                }
            }
        }
    }
}
