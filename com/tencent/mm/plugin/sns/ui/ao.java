package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ao {
    private Activity bOb;
    private List<ate> list = new ArrayList();

    public ao(Activity activity) {
        this.bOb = activity;
    }

    public final void a(View view, int i, au auVar) {
        if (view == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[]{Integer.valueOf(i)});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof ap) {
            ap apVar = (ap) tag;
            String str = apVar.bNH;
            int i2 = apVar.index;
            int i3 = apVar.position;
            if (ck(str, i2)) {
                g.Ek();
                if (g.Ei().isSDCardAvailable()) {
                    n Nl = h.Nl(str);
                    if (ck(str, i2)) {
                        Intent intent = new Intent();
                        if (Nl != null) {
                            b io;
                            if (auVar != null) {
                                auVar.nrb.v(Nl);
                            }
                            bsu bAJ = Nl.bAJ();
                            ate ate = apVar.index < bAJ.sqc.ruA.size() ? (ate) bAJ.sqc.ruA.get(apVar.index) : new ate();
                            if (i == 1) {
                                io = b.io(716);
                            } else {
                                io = b.ip(716);
                            }
                            io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(ate.ksA).ir(apVar.index).ir(bAJ.sqc.ruA.size());
                            io.RD();
                            if (i == 1) {
                                io = b.io(744);
                            } else {
                                io = b.ip(744);
                            }
                            io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo());
                            io.b(intent, "intent_key_StatisticsOplog");
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + i.eF(Nl.field_snsId));
                            bundle.putString("stat_send_msg_user", Nl.field_userName);
                            intent.putExtra("_stat_obj", bundle);
                        } else {
                            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i2);
                        intent.putExtra("sns_position", i3);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("k_is_from_sns_main_timeline", apVar.nTx);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.bOb, SnsBrowseUI.class);
                        this.bOb.startActivity(intent);
                        this.bOb.overridePendingTransition(0, 0);
                        return;
                    }
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[]{str, Integer.valueOf(i2)});
                    return;
                }
                x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                return;
            }
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[]{str, Integer.valueOf(i2)});
        }
    }

    private boolean ck(String str, int i) {
        n Nl = h.Nl(str);
        if (Nl == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        bsu bAJ = Nl.bAJ();
        if (bAJ.sqc == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            return false;
        } else if (bAJ.sqc.ruA.size() == 0) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            return false;
        } else {
            this.list.clear();
            Iterator it = bAJ.sqc.ruA.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                ate ate = (ate) it.next();
                this.list.add(ate);
                if (i != i2 || af.byl().B(ate)) {
                    i2++;
                } else {
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    return false;
                }
            }
            return true;
        }
    }
}
