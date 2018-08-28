package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.util.List;

class TopStoryVideoStreamUI$6 implements OnClickListener {
    final /* synthetic */ TopStoryVideoStreamUI oBa;

    TopStoryVideoStreamUI$6(TopStoryVideoStreamUI topStoryVideoStreamUI) {
        this.oBa = topStoryVideoStreamUI;
    }

    public final void onClick(View view) {
        bti bti = (bti) view.getTag();
        bth e = TopStoryVideoStreamUI.e(this.oBa);
        List<Integer> f = TopStoryVideoStreamUI.f(this.oBa);
        int size = TopStoryVideoStreamUI.b(this.oBa).oAr.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isfeedback=1");
        stringBuffer.append("&feedtype=0");
        stringBuffer.append("&businesstype=2");
        stringBuffer.append("&itemtype=");
        stringBuffer.append(bti.sqW);
        stringBuffer.append("&scene=");
        stringBuffer.append(e.scene);
        stringBuffer.append("&searchid=");
        stringBuffer.append(e.fuu);
        stringBuffer.append("&clicktime=");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&docid=");
        stringBuffer.append(bti.sqZ);
        stringBuffer.append("&docpos=");
        stringBuffer.append(1);
        stringBuffer.append("&reasonid=");
        for (Integer intValue : f) {
            stringBuffer.append(((xe) bti.sre.get(intValue.intValue())).id);
            stringBuffer.append("#");
        }
        stringBuffer.append("&reasonwording=");
        StringBuffer stringBuffer2 = new StringBuffer();
        for (Integer intValue2 : f) {
            stringBuffer2.append(((xe) bti.sre.get(intValue2.intValue())).bSc);
            stringBuffer2.append("#");
        }
        try {
            stringBuffer.append(p.encode(stringBuffer2.toString(), "utf8"));
        } catch (UnsupportedEncodingException e2) {
        }
        stringBuffer.append("&offset=");
        stringBuffer.append(size);
        stringBuffer.append("&sessionid=");
        stringBuffer.append(com.tencent.mm.plugin.websearch.api.p.zK(e.scene));
        stringBuffer.append("&reserveexpand=");
        stringBuffer.append(bti.sqX);
        x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[]{stringBuffer.toString()});
        bgx bgx = new bgx();
        bgx.shQ = stringBuffer.toString();
        g.DF().a(new n(bgx), 0);
        if (TopStoryVideoStreamUI.g(this.oBa) != null) {
            TopStoryVideoStreamUI.g(this.oBa).dismiss();
        }
    }
}
