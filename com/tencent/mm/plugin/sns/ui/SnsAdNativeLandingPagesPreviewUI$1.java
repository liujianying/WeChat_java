package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesPreviewUI$1 implements a {
    final /* synthetic */ long nIW;
    final /* synthetic */ View nRK;
    final /* synthetic */ int nRL;
    final /* synthetic */ String nRM;
    final /* synthetic */ String nRN;
    final /* synthetic */ SnsAdNativeLandingPagesPreviewUI nRO;
    final /* synthetic */ Intent val$intent;

    SnsAdNativeLandingPagesPreviewUI$1(SnsAdNativeLandingPagesPreviewUI snsAdNativeLandingPagesPreviewUI, View view, int i, String str, String str2, long j, Intent intent) {
        this.nRO = snsAdNativeLandingPagesPreviewUI;
        this.nRK = view;
        this.nRL = i;
        this.nRM = str;
        this.nRN = str2;
        this.nIW = j;
        this.val$intent = intent;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        this.nRK.setVisibility(8);
        if (i == 0 && i2 == 0) {
            if (this.nRL == 1) {
                Object cfV = ((afm) bVar.dIE.dIL).rJu.cfV();
                x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[]{this.nRM, this.nRN, cfV});
                if (!TextUtils.isEmpty(cfV)) {
                    this.val$intent.putExtra("sns_landing_pages_xml", cfV);
                    if (SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, cfV)) {
                        SnsAdNativeLandingPagesPreviewUI.a(this.nRO, this.val$intent, cfV);
                        i bAE = i.bAE();
                        String str2 = this.nRM;
                        String str3 = this.nRN;
                        if (!(TextUtils.isEmpty(cfV) || TextUtils.isEmpty(str2))) {
                            Object obj;
                            if (bi.oW(str3)) {
                                String obj2 = str2;
                            } else {
                                obj2 = str2 + str3;
                            }
                            bAE.nIU.put(obj2, cfV);
                            com.tencent.mm.plugin.sns.storage.x xVar = new com.tencent.mm.plugin.sns.storage.x();
                            xVar.field_canvasId = str2;
                            xVar.field_canvasXml = cfV;
                            xVar.field_canvasExt = str3;
                            bAE.nIT.a(xVar);
                        }
                    } else {
                        this.nRO.finish();
                        return 0;
                    }
                }
            }
            yx yxVar = (yx) bVar.dIE.dIL;
            x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[]{Long.valueOf(this.nIW), yxVar.rFa});
            if (!TextUtils.isEmpty(yxVar.rFa)) {
                this.val$intent.putExtra("sns_landing_pages_xml", yxVar.rFa);
                if (SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, yxVar.rFa)) {
                    SnsAdNativeLandingPagesPreviewUI.a(this.nRO, this.val$intent, yxVar.rFa);
                    i.bAE().p(this.nIW, yxVar.rFa);
                } else {
                    this.nRO.finish();
                    return 0;
                }
            }
        } else if (this.nRL == 1) {
            x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[]{this.nRM, this.nRN, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[]{Long.valueOf(this.nIW), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.nRO.finish();
        return 0;
    }
}
