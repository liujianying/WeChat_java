package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements OnItemClickListener {
    final /* synthetic */ e hCy;

    e$1(e eVar) {
        this.hCy = eVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) this.hCy.htU.get(i);
        if (bVar != null && !TextUtils.isEmpty(bVar.url)) {
            Intent intent = new Intent();
            if (this.hCy.htQ instanceof CardInfo) {
                intent.putExtra("key_card_info_data", (CardInfo) this.hCy.htQ);
            } else if (this.hCy.htQ instanceof ShareCardInfo) {
                intent.putExtra("key_card_info_data", (ShareCardInfo) this.hCy.htQ);
            }
            h hVar;
            Object[] objArr;
            if (bVar.url.equals("card://jump_detail")) {
                int i2;
                if (this.hCy.htQ.awm().rnY == null || TextUtils.isEmpty(this.hCy.htQ.awm().rnY.url)) {
                    intent.setClass(this.hCy.hBT, CardDetailPreference.class);
                    this.hCy.hBT.startActivity(intent);
                } else {
                    com.tencent.mm.plugin.card.d.b.a(this.hCy.hBT, this.hCy.htQ.awm().rnY.url, 1);
                }
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
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[7] = Integer.valueOf(i2);
                objArr[8] = "";
                hVar.h(11324, objArr);
            } else if (bVar.url.equals("card://jump_shop_list") && this.hCy.htQ.awm().rnK > 0) {
                e.a(this.hCy);
            } else if (!bVar.url.equals("card://jump_shop") || this.hCy.htQ.awm().rnK <= 0) {
                e eVar;
                String str;
                if (bVar.url.equals("card://jump_service")) {
                    if (!TextUtils.isEmpty(this.hCy.htQ.awm().rnD)) {
                        com.tencent.mm.plugin.card.d.b.ac(this.hCy.hBT, this.hCy.htQ.awm().rnD);
                        am.axo().p(this.hCy.htQ.awq(), this.hCy.htQ.awr(), 1);
                    }
                    h.mEJ.h(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awr(), this.hCy.htQ.awq(), this.hCy.hCv.hBD});
                } else if (bVar.url.equals("card://jump_gift")) {
                    e.b(this.hCy);
                    eVar = this.hCy;
                    if (eVar.htQ.awn().rno == null) {
                        x.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                    } else if (eVar.htQ.awn().rno.rtT == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                    } else {
                        h.mEJ.h(13866, new Object[]{Integer.valueOf(6), eVar.htQ.awn().rno.rtT.qZU, o.getString(eVar.htQ.awn().rno.rtT.qZT)});
                    }
                } else if (bVar.url.equals("card://jump_card_gift")) {
                    if (this.hCy.htQ.awn().rno == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                    } else if (this.hCy.htQ.awn().rno.rtT == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                    } else {
                        e eVar2 = this.hCy;
                        x.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[]{this.hCy.htQ.awn().rno.rtT.qZU, Integer.valueOf(this.hCy.htQ.awn().rno.rtT.qZT)});
                        Intent intent2 = new Intent(eVar2.hBT, CardGiftReceiveUI.class);
                        intent2.putExtra("key_biz_uin", r2);
                        intent2.putExtra("key_order_id", str);
                        intent2.putExtra("key_gift_into", (CardGiftInfo) eVar2.hBT.getIntent().getParcelableExtra("key_card_git_info"));
                        eVar2.hBT.startActivity(intent2);
                        h.mEJ.h(13866, new Object[]{Integer.valueOf(5), this.hCy.htQ.awn().rno.rtT.qZU, o.getString(this.hCy.htQ.awn().rno.rtT.qZT)});
                    }
                } else if ((bVar.roL & 32) > 0) {
                    eVar = this.hCy;
                    com.tencent.mm.plugin.card.d.b.a(eVar.hBT, 4, eVar);
                    eVar.hBT.geJ = eVar;
                } else if (com.tencent.mm.plugin.card.d.b.e(this.hCy.htQ.awq(), bVar.rnv, bVar.rnw, this.hCy.hCv.hza, this.hCy.hCv.hCB)) {
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(21), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", bVar.title});
                } else {
                    String awq;
                    com.tencent.mm.plugin.card.d.b.a(this.hCy.hBT, l.x(bVar.url, bVar.roL), 1);
                    h.mEJ.h(11492, new Object[]{Integer.valueOf(this.hCy.hCv.hza), this.hCy.hCv.hBE, this.hCy.htQ.awq(), this.hCy.htQ.awr(), Integer.valueOf(this.hCy.htQ.awn().status), awq, Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awm().rnD});
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(6), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", bVar.title});
                    if (l.a(bVar, this.hCy.htQ.awq())) {
                        awq = this.hCy.htQ.awq();
                        str = bVar.title;
                        l.yb(awq);
                        com.tencent.mm.plugin.card.d.b.a(this.hCy.hBT, this.hCy.htQ.awm().hwh);
                    }
                }
            } else if (this.hCy.htW == null || this.hCy.htW.size() == 0) {
                x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
            } else {
                la laVar = (la) this.hCy.htW.get(0);
                if (!(laVar == null || TextUtils.isEmpty(laVar.hwI))) {
                    com.tencent.mm.plugin.card.d.b.a(this.hCy.hBT, laVar.hwI, 1);
                    h.mEJ.h(11941, new Object[]{Integer.valueOf(4), this.hCy.htQ.awq(), this.hCy.htQ.awr(), "", laVar.name});
                }
                hVar = h.mEJ;
                objArr = new Object[9];
                objArr[0] = "UsedStoresView";
                objArr[1] = Integer.valueOf(this.hCy.htQ.awm().huV);
                objArr[2] = this.hCy.htQ.awr();
                objArr[3] = this.hCy.htQ.awq();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.hCy.hCv.hza);
                objArr[6] = this.hCy.hCv.hBD;
                objArr[7] = Integer.valueOf(this.hCy.htQ.awk() ? 1 : 0);
                objArr[8] = "";
                hVar.h(11324, objArr);
            }
        }
    }
}
