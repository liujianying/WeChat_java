package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    private int nUn = s$l.AppCompatTheme_checkedTextViewStyle;

    public final void c(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.ojb.setImageResource(e.lucky_friendactivity_comment_icon);
        cVar.oiH.setTextColor(-2730427);
        if (cVar.oiQ != null) {
            cVar.oiQ.setLayoutResource(i$g.sns_hb_reward_item);
            if (!cVar.oiR) {
                cVar.oji = (PhotosContent) cVar.oiQ.inflate();
                cVar.oiR = true;
            }
        } else {
            cVar.oji = (PhotosContent) cVar.jEz.findViewById(i$f.hb_content_rl);
            cVar.oiR = true;
        }
        x.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.hER);
        TagImageView tagImageView = (TagImageView) cVar.oji.findViewById(ar.nYB[0]);
        cVar.oji.a(tagImageView);
        tagImageView.setOnClickListener(this.nuc.ntw.nNR);
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        String str = ayVar.nMU;
        if (cVar.ojT != null) {
            if (!ayVar.oeM || cVar.nib.smZ == null || cVar.nib.smZ.snB <= 0) {
                cVar.ojT.setBackgroundResource(e.friendactivity_comment_detail_list_golden_arror);
            } else {
                cVar.ojT.setBackgroundResource(e.friendactivity_comment_detail_list_golden_myself);
            }
        }
        TagImageView xm = cVar.oji.xm(0);
        List arrayList = new ArrayList();
        arrayList.add(xm);
        ap apVar = new ap();
        apVar.bNH = str;
        apVar.index = 0;
        apVar.nWx = arrayList;
        apVar.nTx = this.nTx;
        if (xm != null) {
            xm.setTag(apVar);
        }
        atf atf = ayVar.ofn;
        cVar.nJn = atf;
        ar arVar;
        PhotosContent photosContent;
        String str2;
        int hashCode;
        boolean z;
        com.tencent.mm.storage.av clT;
        if (atf == null) {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + ayVar.nMU);
        } else if (q.GF().equals(bsu.hbL)) {
            cVar.oji.setVisibility(0);
            arVar = avVar.nUc;
            photosContent = cVar.oji;
            str2 = ayVar.nMU;
            hashCode = this.mActivity.hashCode();
            z = this.nTx;
            clT = com.tencent.mm.storage.av.clT();
            clT.time = bsu.lOH;
            arVar.a(photosContent, bsu, str2, hashCode, i2, i, z, clT, true);
        } else if (ayVar.oeP) {
            cVar.oji.setVisibility(0);
            arVar = avVar.nUc;
            photosContent = cVar.oji;
            str2 = ayVar.nMU;
            hashCode = this.mActivity.hashCode();
            z = this.nTx;
            clT = com.tencent.mm.storage.av.clT();
            clT.time = bsu.lOH;
            arVar.a(photosContent, bsu, str2, hashCode, i2, i, z, clT, false);
        } else if (atf.ceS == 0) {
            cVar.oji.setVisibility(0);
            arVar = avVar.nUc;
            photosContent = cVar.oji;
            str2 = ayVar.nMU;
            hashCode = this.mActivity.hashCode();
            z = this.nTx;
            clT = com.tencent.mm.storage.av.clT();
            clT.time = bsu.lOH;
            arVar.a(photosContent, bsu, str2, hashCode, i2, i, z, clT, true);
        } else {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + atf.ceS);
        }
    }
}
