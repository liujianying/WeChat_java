package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    public final void c(c cVar) {
        int byw = af.byw();
        if (cVar.oiQ == null) {
            cVar.ojC = cVar.jEz.findViewById(i$f.content_collapse_rl);
            cVar.ojB = true;
        } else if (!cVar.ojB) {
            cVar.oiQ.setLayoutResource(i$g.sns_media_collapse_item);
            cVar.ojC = cVar.oiQ.inflate();
            cVar.ojB = true;
        }
        cVar.oiT = (TagImageView) cVar.ojC.findViewById(i$f.content_preview);
        cVar.nLz = (ImageView) cVar.ojC.findViewById(i$f.state);
        cVar.eBO = (TextView) cVar.ojC.findViewById(i$f.content_hint);
        View view = cVar.ojC;
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = byw;
        layoutParams.width = byw;
        view.setLayoutParams(layoutParams);
        i.b(cVar.oiT, this.mActivity);
    }

    public final void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar) {
        cVar.oiT.setPosition(i);
        String str = ayVar.nMU;
        if (bsu.sqc.ruA.size() > 0) {
            ate ate = (ate) bsu.sqc.ruA.get(0);
            g byl;
            switch (bsu.sqc.ruz) {
                case 1:
                    cVar.oiT.setOnClickListener(avVar.ntw.nNR);
                    ap apVar = new ap();
                    apVar.bNH = str;
                    apVar.index = 0;
                    List arrayList = new ArrayList();
                    arrayList.add(cVar.oiT);
                    apVar.nWx = arrayList;
                    apVar.nTx = this.nTx;
                    apVar.position = i;
                    cVar.oiT.setTag(apVar);
                    cVar.oiT.setVisibility(0);
                    byl = af.byl();
                    TagImageView tagImageView = cVar.oiT;
                    int hashCode = this.mActivity.hashCode();
                    com.tencent.mm.storage.av clT = com.tencent.mm.storage.av.clT();
                    clT.time = bsu.lOH;
                    byl.b(ate, tagImageView, hashCode, clT);
                    cVar.nLz.setVisibility(8);
                    cVar.eBO.setText(this.mActivity.getString(i$j.sns_photo_collapse_title, new Object[]{Integer.valueOf(r2)}));
                    cVar.eBO.setVisibility(0);
                    break;
                case 15:
                    cVar.oiT.setTag(new r(bsu, str));
                    cVar.oiT.setOnClickListener(avVar.ntw.okT);
                    cVar.nLz.setImageResource(i$i.sns_collapse_video_play);
                    cVar.nLz.setVisibility(0);
                    cVar.eBO.setVisibility(8);
                    byl = af.byl();
                    TagImageView tagImageView2 = cVar.oiT;
                    int hashCode2 = this.mActivity.hashCode();
                    com.tencent.mm.storage.av clT2 = com.tencent.mm.storage.av.clT();
                    clT2.time = bsu.lOH;
                    byl.b(ate, tagImageView2, hashCode2, clT2);
                    break;
            }
        }
        avVar.hql.c(cVar.oiT, avVar.ntw.okM, avVar.ntw.okv);
    }
}
