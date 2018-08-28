package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$22 extends c {
    final /* synthetic */ b olf;

    b$22(b bVar) {
        this.olf = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getTag() instanceof ak) {
            int i;
            ak akVar = (ak) view.getTag();
            if (!akVar.nkG) {
                contextMenu.add(0, 19, 0, this.olf.activity.getString(i$j.chatting_long_click_menu_mute_play));
            }
            if (bi.WU(g.AT().getValue("SIGHTCannotTransmitForFav")) == 0) {
                if (akVar.nRA.sqc.ruA.size() > 0) {
                    ate ate = (ate) akVar.nRA.sqc.ruA.get(0);
                    String str = an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate);
                    String a = aq.a(akVar.bKW, ate);
                    x.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.cn(str)), Boolean.valueOf(FileOp.cn(a))});
                    if (FileOp.cn(str) && r1) {
                        i = 1;
                        if (d.QS("favorite")) {
                            contextMenu.add(0, 10, 0, this.olf.activity.getString(i$j.plugin_favorite_opt));
                        }
                        if (i != 0) {
                            dj djVar = new dj();
                            djVar.bLf.bKW = akVar.bKW;
                            a.sFg.m(djVar);
                            if (djVar.bLg.bKE) {
                                contextMenu.add(0, 18, 0, this.olf.activity.getString(i$j.app_open));
                            }
                        }
                    }
                }
                x.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
            }
            i = 0;
            if (d.QS("favorite")) {
                contextMenu.add(0, 10, 0, this.olf.activity.getString(i$j.plugin_favorite_opt));
            }
            if (i != 0) {
                dj djVar2 = new dj();
                djVar2.bLf.bKW = akVar.bKW;
                a.sFg.m(djVar2);
                if (djVar2.bLg.bKE) {
                    contextMenu.add(0, 18, 0, this.olf.activity.getString(i$j.app_open));
                }
            }
        }
    }

    public final boolean cO(View view) {
        if (!(view.getTag() instanceof ak)) {
            return false;
        }
        String str = ((ak) view.getTag()).bKW;
        this.olf.okv.a(view, str, af.byo().Nl(str).bAJ());
        return true;
    }
}
