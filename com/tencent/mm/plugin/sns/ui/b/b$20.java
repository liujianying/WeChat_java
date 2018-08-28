package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.ate;

class b$20 implements OnClickListener {
    final /* synthetic */ b olf;

    b$20(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof r) {
            int width;
            int height;
            r rVar = (r) view.getTag();
            ate ate = (ate) rVar.nMH.sqc.ruA.get(0);
            af.byo().Nk(rVar.bKW);
            String str = "";
            String s = an.s(af.getAccSnsPath(), ate.ksA);
            String str2 = "";
            String j = i.j(ate);
            if (FileOp.cn(s + j)) {
                str = s + j;
                str2 = s + i.e(ate);
            }
            if (FileOp.cn(s + i.p(ate))) {
                str = s + i.p(ate);
                str2 = s + i.n(ate);
            }
            int[] iArr = new int[2];
            View findViewById = view.findViewById(f.content_preview);
            if (findViewById != null) {
                findViewById.getLocationInWindow(iArr);
                width = findViewById.getWidth();
                height = findViewById.getHeight();
            } else {
                view.getLocationInWindow(iArr);
                width = view.getWidth();
                height = view.getHeight();
            }
            Intent intent = new Intent();
            intent.setClass(this.olf.activity, SnsOnlineVideoActivity.class);
            intent.putExtra("intent_videopath", str);
            intent.putExtra("intent_thumbpath", str2);
            intent.putExtra("intent_localid", rVar.bKW);
            intent.putExtra("intent_isad", false);
            intent.putExtra("intent_from_scene", this.olf.scene);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            this.olf.activity.startActivity(intent);
            this.olf.activity.overridePendingTransition(0, 0);
            b.a(this.olf, rVar.nMH);
        }
    }
}
