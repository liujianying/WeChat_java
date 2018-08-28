package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class e$5 implements OnClickListener {
    final /* synthetic */ e hCy;

    e$5(e eVar) {
        this.hCy = eVar;
    }

    public final void onClick(View view) {
        if (this.hCy.htQ == null) {
            x.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
            return;
        }
        h.mEJ.h(11582, new Object[]{"CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awr(), this.hCy.htQ.awq(), this.hCy.hCv.hBD});
        com.tencent.mm.ui.base.h.a(this.hCy.hBT.mController.tml, null, (String[]) this.hCy.hCt.toArray(new String[this.hCy.hCt.size()]), null, false, new c() {
            public final void ju(int i) {
                String str = (String) e$5.this.hCy.hCr.get(Integer.valueOf(i));
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals("menu_func_share_friend")) {
                        int i2;
                        e eVar = e$5.this.hCy;
                        b.a(eVar.hBT, 1, eVar);
                        eVar.hBT.geJ = eVar;
                        h hVar = h.mEJ;
                        Object[] objArr = new Object[9];
                        objArr[0] = "BrandContactView";
                        objArr[1] = Integer.valueOf(e$5.this.hCy.htQ.awm().huV);
                        objArr[2] = e$5.this.hCy.htQ.awr();
                        objArr[3] = e$5.this.hCy.htQ.awq();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(e$5.this.hCy.hCv.hza);
                        objArr[6] = e$5.this.hCy.hCv.hBD;
                        if (e$5.this.hCy.htQ.awk()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr[7] = Integer.valueOf(i2);
                        objArr[8] = "";
                        hVar.h(11324, objArr);
                        h.mEJ.h(11582, new Object[]{"OperShareFriend", Integer.valueOf(1), Integer.valueOf(e$5.this.hCy.htQ.awm().huV), e$5.this.hCy.htQ.awr(), e$5.this.hCy.htQ.awq(), e$5.this.hCy.hCp});
                    } else if (str.equals("menu_func_gift")) {
                        e.b(e$5.this.hCy);
                    } else if (str.equals("menu_func_delete")) {
                        str = "";
                        if (e$5.this.hCy.htQ.avT()) {
                            str = e$5.this.hCy.hBT.getString(g.card_delete_membership_tips);
                        }
                        d.a(e$5.this.hCy.hBT, e$5.this.hCy.hCv.htC, str, new 1(this));
                        h.mEJ.h(11582, new Object[]{"OperDelete", Integer.valueOf(1), Integer.valueOf(e$5.this.hCy.htQ.awm().huV), e$5.this.hCy.htQ.awr(), e$5.this.hCy.htQ.awq(), ""});
                    } else if (str.equals("menu_func_service")) {
                        if (!TextUtils.isEmpty(e$5.this.hCy.htQ.awm().rnD)) {
                            b.ac(e$5.this.hCy.hBT, e$5.this.hCy.htQ.awm().rnD);
                            am.axo().p(e$5.this.hCy.htQ.awq(), e$5.this.hCy.htQ.awr(), 1);
                        }
                        h.mEJ.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(e$5.this.hCy.htQ.awm().huV), e$5.this.hCy.htQ.awr(), e$5.this.hCy.htQ.awq(), e$5.this.hCy.hCv.hBD});
                    } else if (str.equals("menu_func_report")) {
                        if (!TextUtils.isEmpty(e$5.this.hCy.htQ.awn().rng)) {
                            b.a(e$5.this.hCy.hBT, e$5.this.hCy.htQ.awn().rng, e$5.this.hCy.getString(g.card_report_title));
                        }
                        h.mEJ.h(11582, new Object[]{"OperReport", Integer.valueOf(1), Integer.valueOf(e$5.this.hCy.htQ.awm().huV), e$5.this.hCy.htQ.awr(), e$5.this.hCy.htQ.awq(), ""});
                    } else if (str.equals("menu_func_share_timeline")) {
                        y.a(new m(e$5.this.hCy.htQ.awm().huW));
                        CardDetailBaseUI cardDetailBaseUI = e$5.this.hCy.hBT;
                        com.tencent.mm.plugin.card.base.b bVar = e$5.this.hCy.htQ;
                        String str2 = e$5.this.hCy.hCv.htC;
                        Object obj = e$5.this.hCy.hCv.hBF;
                        Intent intent = new Intent();
                        intent.putExtra("Ksnsupload_link", bVar.awm().rnM);
                        intent.putExtra("KContentObjDesc", bVar.awm().hwh);
                        intent.putExtra("Ksnsupload_title", bVar.awm().title);
                        if (TextUtils.isEmpty(obj)) {
                            intent.putExtra("KUploadProduct_UserData", str2 + "#");
                        } else {
                            intent.putExtra("KUploadProduct_UserData", str2 + "#" + obj);
                        }
                        intent.putExtra("Ksnsupload_imgurl", bVar.awm().huW);
                        if (!TextUtils.isEmpty(bVar.awm().huW)) {
                            intent.putExtra("KsnsUpload_imgPath", new m(bVar.awm().huW).Vv());
                        }
                        x.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                        intent.putExtra("src_username", q.GF());
                        intent.putExtra("src_displayname", q.GH());
                        intent.putExtra("Ksnsupload_appid", bVar.awm().bPS);
                        intent.putExtra("Ksnsupload_appname", bVar.awm().rnD);
                        intent.putExtra("Ksnsupload_type", 7);
                        String ic = u.ic("card_package");
                        u.Hx().v(ic, true).p("prePublishId", "card_package");
                        intent.putExtra("reportSessionId", ic);
                        com.tencent.mm.bg.d.c(cardDetailBaseUI, "sns", ".ui.SnsUploadUI", intent);
                        h.mEJ.h(11582, new Object[]{"OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(e$5.this.hCy.htQ.awm().huV), e$5.this.hCy.htQ.awr(), e$5.this.hCy.htQ.awq(), e$5.this.hCy.hCv.hBD});
                    } else if (str.equals("menu_func_delete_share_card")) {
                        d.a(e$5.this.hCy.hBT, e$5.this.hCy.hCv.htC, "", new 2(this));
                    } else {
                        str = (String) e$5.this.hCy.hCs.get(str);
                        if (!bi.oW(str)) {
                            b.a(e$5.this.hCy.hBT, str, 0);
                        }
                    }
                }
            }
        });
    }
}
