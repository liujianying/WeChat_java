package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class e$4 implements OnClickListener {
    final /* synthetic */ e hCy;

    e$4(e eVar) {
        this.hCy = eVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        int i = 0;
        String str;
        h hVar;
        Object[] objArr;
        pr prVar;
        int i2;
        String awq;
        la laVar;
        if (view.getId() == d.card_accept_layout || view.getId() == d.card_accept_btn) {
            if (this.hCy.htQ.avR()) {
                if (this.hCy.hCu != null) {
                    this.hCy.hCu.ayq();
                }
            } else if (this.hCy.htQ.avS() && this.hCy.hCu != null) {
                this.hCy.hCu.ayo();
            }
        } else if (view.getId() == d.from_username_avatar || view.getId() == d.accept_header_from_username_avatar) {
            b.ab(this.hCy.hBT, this.hCy.hCv.hBD);
        } else if (view.getId() == d.code_qr_area || view.getId() == d.code_bar_area) {
            if (view.getId() == d.code_qr_area) {
                this.hCy.hCn = false;
            } else if (view.getId() == d.code_bar_area) {
                this.hCy.hCn = true;
            }
            if (this.hCy.hCa instanceof q) {
                this.hCy.hCm.hGn = ((q) this.hCy.hCa).e(c.hIz);
            }
            j jVar = this.hCy.hCm;
            boolean z2 = this.hCy.hCn;
            jVar.ayS();
            jVar.hCn = z2;
            if (jVar.eZB != null && !jVar.eZB.isShowing()) {
                jVar.eZB.showAtLocation(view.getRootView(), 17, 0, 0);
                jVar.eZB.setFocusable(true);
                jVar.eZB.setTouchable(true);
                jVar.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.eZB.setOutsideTouchable(true);
                if (jVar.hCn) {
                    jVar.hGj.setOnClickListener(jVar.eZF);
                    Bitmap bitmap = jVar.hGf;
                    if (jVar.hyO != null) {
                        jVar.hGf = l.w(jVar.hyO);
                    } else {
                        jVar.hGf = null;
                    }
                    jVar.hGj.setImageBitmap(jVar.hGf);
                    jVar.hGm.add(0, bitmap);
                    jVar.ayU();
                    jVar.eZD.setVisibility(8);
                    jVar.hGi.setVisibility(0);
                    str = jVar.htQ.awn().code;
                    if (jVar.htQ.awm().rol == null || !jVar.htQ.awm().rol.rwc) {
                        if (!bi.oW(jVar.htQ.awn().rnp)) {
                            str = jVar.htQ.awn().rnp;
                        } else if (jVar.htQ.awg()) {
                            if (!bi.oW(jVar.hGn)) {
                                str = jVar.hGn;
                            }
                        }
                        if (!TextUtils.isEmpty(str) || str.length() > 40) {
                            jVar.hGk.setVisibility(8);
                        } else {
                            jVar.hGk.setText(m.yd(str));
                            if (jVar.htQ.awb()) {
                                jVar.hGk.setVisibility(0);
                            } else {
                                jVar.hGk.setVisibility(8);
                            }
                        }
                        if (bi.oW(jVar.htQ.awm().hUy)) {
                            jVar.hGl.setText(jVar.htQ.awm().hUy);
                            jVar.hGl.setVisibility(0);
                        } else {
                            jVar.hGl.setVisibility(8);
                        }
                    }
                    str = "";
                    if (TextUtils.isEmpty(str)) {
                    }
                    jVar.hGk.setVisibility(8);
                    if (bi.oW(jVar.htQ.awm().hUy)) {
                        jVar.hGl.setVisibility(8);
                    } else {
                        jVar.hGl.setText(jVar.htQ.awm().hUy);
                        jVar.hGl.setVisibility(0);
                    }
                } else {
                    jVar.eZC.setOnClickListener(jVar.eZF);
                    jVar.eZC.setImageBitmap(jVar.eZA);
                    str = jVar.htQ.awn().code;
                    if (jVar.htQ.awm().rol == null || !jVar.htQ.awm().rol.rwc) {
                        if (!bi.oW(jVar.htQ.awn().rnp)) {
                            str = jVar.htQ.awn().rnp;
                        } else if (jVar.htQ.awg()) {
                            if (!bi.oW(jVar.hGn)) {
                                str = jVar.hGn;
                            }
                        }
                        if (!TextUtils.isEmpty(str) || str.length() > 40) {
                            jVar.hGg.setVisibility(8);
                        } else {
                            jVar.hGg.setText(m.yd(str));
                            if (jVar.htQ.awb()) {
                                jVar.hGg.setVisibility(0);
                            } else {
                                jVar.hGg.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(jVar.htQ.awm().hUy)) {
                            jVar.hGh.setText(jVar.htQ.awm().hUy);
                            jVar.hGh.setVisibility(0);
                        } else {
                            jVar.hGh.setVisibility(8);
                        }
                        jVar.eZD.setVisibility(0);
                        jVar.hGi.setVisibility(8);
                    }
                    str = "";
                    if (TextUtils.isEmpty(str)) {
                    }
                    jVar.hGg.setVisibility(8);
                    if (TextUtils.isEmpty(jVar.htQ.awm().hUy)) {
                        jVar.hGh.setVisibility(8);
                    } else {
                        jVar.hGh.setText(jVar.htQ.awm().hUy);
                        jVar.hGh.setVisibility(0);
                    }
                    jVar.eZD.setVisibility(0);
                    jVar.hGi.setVisibility(8);
                }
                jVar.eZB.update();
            }
        } else if (view.getId() == d.card_consume_btn || view.getId() == d.card_code_layout || view.getId() == d.card_code_img || view.getId() == d.code_text || view.getId() == d.card_code_click_view) {
            if (view.getId() == d.card_consume_btn) {
                if (this.hCy.htQ.avS()) {
                    int i3;
                    hVar = h.mEJ;
                    objArr = new Object[9];
                    objArr[0] = "CardConsumedCodeUI";
                    objArr[1] = Integer.valueOf(this.hCy.htQ.awm().huV);
                    objArr[2] = this.hCy.htQ.awr();
                    objArr[3] = this.hCy.htQ.awq();
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(this.hCy.hCv.hza);
                    objArr[6] = this.hCy.hCv.hBD;
                    if (this.hCy.htQ.awk()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    objArr[7] = Integer.valueOf(i3);
                    objArr[8] = "";
                    hVar.h(11324, objArr);
                    if (this.hCy.hCu != null) {
                        this.hCy.hCu.dT(true);
                        return;
                    }
                    return;
                }
                this.hCy.a(true, new j.b(), false);
            } else if (view.getId() != d.code_text || !this.hCy.htQ.awm().roo) {
                if (!this.hCy.htQ.avS()) {
                    this.hCy.a(false, new j.b(), false);
                } else if (this.hCy.hCu != null) {
                    this.hCy.hCu.dT(false);
                }
            }
        } else if (view.getId() == d.advertise_text) {
            if (!TextUtils.isEmpty(this.hCy.htQ.awm().rnS)) {
                b.a(this.hCy.hBT, this.hCy.htQ.awm().rnS, 3);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(13), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", this.hCy.htQ.awm().rnR});
            }
        } else if (view.getId() == d.card_private_setting_btn) {
            h.mEJ.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awr(), this.hCy.htQ.awq(), this.hCy.hCv.hBD});
            Intent intent = new Intent();
            intent.putExtra("KLabel_range_index", this.hCy.hzB);
            intent.putExtra("Klabel_name_list", this.hCy.hzC);
            intent.putExtra("Kother_user_name_list", this.hCy.hzD);
            intent.putExtra("k_sns_label_ui_title", this.hCy.hBT.getString(g.card_share_card_private_setting_title));
            intent.putExtra("k_sns_label_ui_style", 0);
            intent.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.bg.d.b(this.hCy.hBT, "sns", ".ui.SnsLabelUI", intent, 2);
            this.hCy.hBT.geJ = this.hCy;
        } else if (view.getId() == d.card_secondary_field_view) {
            if (this.hCy.htQ.awn().rnd != null) {
                LinkedList linkedList = this.hCy.htQ.awn().rnd;
                int intValue = ((Integer) view.getTag()).intValue();
                prVar = (pr) linkedList.get(intValue);
                if (b.a(this.hCy.htQ.awq(), prVar, this.hCy.hCv.hza, this.hCy.hCv.hCB)) {
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(19), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", prVar.title});
                } else if (prVar != null && !TextUtils.isEmpty(prVar.url)) {
                    b.a(this.hCy.hBT, prVar.url, 1);
                    h hVar2 = h.mEJ;
                    Object[] objArr2 = new Object[5];
                    switch (intValue) {
                        case 0:
                            i2 = 10;
                            break;
                        case 1:
                            i2 = 11;
                            break;
                        case 2:
                            i2 = 12;
                            break;
                        case 3:
                            i2 = 16;
                            break;
                        default:
                            i2 = 10;
                            break;
                    }
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = this.hCy.htQ.awq();
                    objArr2[2] = this.hCy.htQ.awr();
                    objArr2[3] = "";
                    objArr2[4] = prVar.title;
                    hVar2.h(11941, objArr2);
                    if (l.a(prVar, this.hCy.htQ.awq())) {
                        awq = this.hCy.htQ.awq();
                        str = prVar.title;
                        l.yb(awq);
                        b.a(this.hCy.hBT, this.hCy.htQ.awm().hwh);
                    }
                }
            }
        } else if (view.getId() == d.card_secondary_field_view_1) {
            if (this.hCy.htQ.awn().rnd != null) {
                prVar = (pr) this.hCy.htQ.awn().rnd.get(0);
                if (b.a(this.hCy.htQ.awq(), prVar, this.hCy.hCv.hza, this.hCy.hCv.hCB)) {
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(19), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", prVar.title});
                } else if (prVar != null && !TextUtils.isEmpty(prVar.url)) {
                    b.a(this.hCy.hBT, prVar.url, 1);
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(10), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", prVar.title});
                    if (l.a(prVar, this.hCy.htQ.awq())) {
                        awq = this.hCy.htQ.awq();
                        str = prVar.title;
                        l.yb(awq);
                        b.a(this.hCy.hBT, this.hCy.htQ.awm().hwh);
                    }
                }
            }
        } else if (view.getId() == d.card_widget_operate_field_layout || view.getId() == d.card_operate_field_title_tv) {
            if (this.hCy.htQ.awn().rnk == null) {
                return;
            }
            if (this.hCy.htQ.awe()) {
                if (!this.hCy.htQ.avS()) {
                    this.hCy.a(false, new j.b(), false);
                } else if (this.hCy.hCu != null) {
                    this.hCy.hCu.dT(false);
                }
            } else if (this.hCy.htQ.awf()) {
                j.b bVar = new j.b();
                b.a(this.hCy.hBT, bVar.huK, bVar.huL, false, this.hCy.htQ);
            } else {
                prVar = this.hCy.htQ.awn().rnk;
                if (b.a(this.hCy.htQ.awq(), prVar, this.hCy.hCv.hza, this.hCy.hCv.hCB)) {
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(20), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", prVar.title});
                } else if (prVar != null && !TextUtils.isEmpty(prVar.url)) {
                    b.a(this.hCy.hBT, l.x(prVar.url, prVar.roL), 1);
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(9), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", prVar.title});
                    if (l.a(prVar, this.hCy.htQ.awq())) {
                        awq = this.hCy.htQ.awq();
                        str = prVar.title;
                        l.yb(awq);
                        b.a(this.hCy.hBT, this.hCy.htQ.awm().hwh);
                    }
                }
            }
        } else if (view.getId() == d.card_detail_field_stub || view.getId() == d.card_ad_title_layout) {
            sd sdVar = this.hCy.htQ.awm().rnY;
            hVar = h.mEJ;
            objArr = new Object[9];
            objArr[0] = "CardLeftRightIntroduceView";
            objArr[1] = Integer.valueOf(this.hCy.htQ.awm().huV);
            objArr[2] = this.hCy.htQ.awr();
            objArr[3] = this.hCy.htQ.awq();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.hCy.hCv.hza);
            objArr[6] = this.hCy.hCv.hBD;
            if (this.hCy.htQ.awk()) {
                i = 1;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            hVar.h(11324, objArr);
            if (sdVar == null || TextUtils.isEmpty(sdVar.url)) {
                Intent intent2 = new Intent();
                if (this.hCy.htQ instanceof CardInfo) {
                    intent2.putExtra("key_card_info_data", (CardInfo) this.hCy.htQ);
                } else if (this.hCy.htQ instanceof ShareCardInfo) {
                    intent2.putExtra("key_card_info_data", (ShareCardInfo) this.hCy.htQ);
                }
                intent2.setClass(this.hCy.hBT, CardDetailPreference.class);
                this.hCy.hBT.startActivity(intent2);
                return;
            }
            b.a(this.hCy.hBT, sdVar.url, 1);
        } else if (view.getId() == d.share_users_top_layout) {
            if (com.tencent.mm.plugin.card.sharecard.a.b.xu(this.hCy.htQ.awr()) > 1) {
                e eVar = this.hCy;
                if (this.hCy.hBW) {
                    z = false;
                }
                eVar.hBW = z;
                this.hCy.axM();
            }
        } else if (view.getId() == d.card_annoucement_layout_stub) {
            if (this.hCy.htQ.awm().rnU != null && !TextUtils.isEmpty(this.hCy.htQ.awm().rnU.url)) {
                b.a(this.hCy.hBT, this.hCy.htQ.awm().rnU.url, 3);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(3), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", this.hCy.htQ.awm().rnU.text});
            }
        } else if (view.getId() == d.card_accept_guidance_tv) {
            if (this.hCy.htQ.awm().rob != null && !bi.oW(this.hCy.htQ.awm().rob.url)) {
                b.a(this.hCy.hBT, this.hCy.htQ.awm().rob.url, 1);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(14), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", this.hCy.htQ.awm().rob.text});
            }
        } else if (view.getId() == d.shop_poi || view.getId() == d.shop_poi_layout) {
            if (this.hCy.htQ.awm().rnK <= 0) {
                return;
            }
            if (this.hCy.htW == null || this.hCy.htW.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                return;
            }
            laVar = (la) this.hCy.htW.get(0);
            b.a(this.hCy.hBT, laVar.bSx, laVar.bUg, laVar.dRH);
            h hVar3 = h.mEJ;
            Object[] objArr3 = new Object[9];
            objArr3[0] = "UsedStoresView";
            objArr3[1] = Integer.valueOf(this.hCy.htQ.awm().huV);
            objArr3[2] = this.hCy.htQ.awr();
            objArr3[3] = this.hCy.htQ.awq();
            objArr3[4] = Integer.valueOf(0);
            objArr3[5] = Integer.valueOf(this.hCy.hCv.hza);
            objArr3[6] = this.hCy.hCv.hBD;
            if (this.hCy.htQ.awk()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr3[7] = Integer.valueOf(i2);
            objArr3[8] = "";
            hVar3.h(11324, objArr3);
            h.mEJ.h(11941, new Object[]{Integer.valueOf(5), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", laVar.name});
        } else if (view.getId() == d.ticket_shop_layout) {
            if (this.hCy.htW == null || this.hCy.htW.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                return;
            }
            laVar = (la) this.hCy.htW.get(0);
            awq = (String) view.getTag();
            if (!TextUtils.isEmpty(awq) && awq.equals(this.hCy.hBT.getString(g.card_check_all_adapted_stores))) {
                e.a(this.hCy);
            } else if (!TextUtils.isEmpty(laVar.hwI)) {
                b.a(this.hCy.hBT, laVar.hwI, 1);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(4), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", laVar.name});
            }
        } else if (view.getId() == d.ticket_check_more_adapted_stores) {
            e.a(this.hCy);
        }
    }
}
