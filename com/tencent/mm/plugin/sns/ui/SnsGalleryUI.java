package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import java.util.ArrayList;
import java.util.List;

public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int nTw = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        initView();
    }

    public void onDestroy() {
        int max;
        if (this.nTu != null) {
            this.nTu.bDr();
            this.nTu.onDestroy();
        }
        getWindow().clearFlags(128);
        am.a bye = af.bye();
        String str = this.userName;
        if (bye.nrr.containsKey(str)) {
            max = Math.max(((Integer) bye.nrr.get(str)).intValue() - 1, 0);
            bye.nrr.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            bye.nrq.remove(str);
        }
        af.byl().H(this);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        m.Bk(2);
    }

    public void onResume() {
        super.onResume();
        if (this.nTu != null) {
            this.nTu.aKx();
        }
        m.Bk(1);
    }

    protected final int getLayoutId() {
        return g.sns_gallery_img;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.nTr.nND);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        List arrayList;
        av clV;
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.nTw = getIntent().getIntExtra("sns_gallery_position", 0);
        x.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[]{v.ai("sns_table_", (long) intExtra), Integer.valueOf(this.nTw)});
        cj(r0, this.nTw);
        t(booleanExtra, 1);
        this.nTu = new SnsInfoFlip(this);
        this.nTu.setNeedScanImage(true);
        am.a bye = af.bye();
        String str = this.userName;
        if (bye.nrr.containsKey(str)) {
            bye.nrr.put(str, Integer.valueOf(((Integer) bye.nrr.get(str)).intValue() + 1));
        } else {
            bye.nrr.put(str, Integer.valueOf(0));
        }
        ArrayList arrayList2 = (ArrayList) bye.nrq.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            Object arrayList3 = arrayList2;
        }
        this.nTu.setDoubleClick(true);
        this.nTu.setShowTitle(true);
        this.nTu.setEnableHorLongBmpMode(false);
        this.nTu.a(arrayList3, this.userName, this.nTw, this.nTp, this);
        this.nTu.setOnDeleteAllAction(new 1(this));
        com.tencent.mm.kernel.g.Ek();
        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(this.userName);
        if (Yg == null || ((int) Yg.dhP) <= 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
            if (this.userName.equals(q.GF())) {
                clV = av.clV();
            } else {
                clV = av.clW();
            }
        } else {
            clV = av.clU();
        }
        this.nTu.setFromScene(clV);
        this.nTu.username = this.userName;
        addView(this.nTu);
        setBackBtn(new 2(this));
        addIconOptionMenu(0, e.mm_title_btn_menu, new 3(this, booleanExtra));
    }

    public final void ci(String str, int i) {
        if (this.nTu != null) {
            if (!(bi.oW(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.nTu;
                if (snsInfoFlip.dEw != null) {
                    int i2 = 0;
                    while (i2 >= 0) {
                        int i3;
                        while (true) {
                            i3 = i2;
                            if (i3 >= snsInfoFlip.dEw.size()) {
                                i3 = -1;
                                break;
                            }
                            b bVar = (b) snsInfoFlip.dEw.get(i3);
                            if (!bi.oW(bVar.nuP) && bVar.nuP.equals(str)) {
                                snsInfoFlip.dEw.remove(i3);
                                break;
                            }
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    }
                    snsInfoFlip.nWy.notifyDataSetChanged();
                }
            }
            this.nTu.aKx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String str;
            if (2 == i) {
                if (-1 == i2) {
                    ate ate;
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (this.nTu != null) {
                        b selectItem = this.nTu.getSelectItem();
                        if (selectItem.caK.hcE == 6) {
                            ate = selectItem.caK;
                        } else {
                            return;
                        }
                    }
                    ate = null;
                    if (ate != null) {
                        String s = an.s(af.getAccSnsPath(), ate.ksA);
                        str = "";
                        String str2 = "";
                        String j = com.tencent.mm.plugin.sns.data.i.j(ate);
                        if (FileOp.cn(s + j)) {
                            str2 = s + j;
                            str = s + com.tencent.mm.plugin.sns.data.i.e(ate);
                        }
                        if (FileOp.cn(s + com.tencent.mm.plugin.sns.data.i.p(ate))) {
                            j = s + com.tencent.mm.plugin.sns.data.i.p(ate);
                            s = s + com.tencent.mm.plugin.sns.data.i.n(ate);
                        } else {
                            j = str2;
                            s = str;
                        }
                        List<String> F = bi.F(stringExtra.split(","));
                        int LQ = com.tencent.mm.plugin.sns.data.i.LQ(j);
                        for (String str3 : F) {
                            x.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[]{str3, j, s, Integer.valueOf(LQ)});
                            com.tencent.mm.plugin.messenger.a.g.bcT().a(this, str3, j, s, 62, LQ, "");
                            com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str3);
                        }
                        com.tencent.mm.ui.widget.snackbar.b.h(this, getString(j.has_send));
                    }
                }
            } else if (1 == i) {
                int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
                str = v.ai("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
                this.nTr.xg(intExtra);
                ci(str, 1);
                if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_cmd_list", this.nTr.nND);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
    }
}
