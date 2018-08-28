package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.x;

class b$a implements e {
    private String bHt;
    private long bHu;
    private boolean bHv;
    private Context context;
    private int fromScene;
    private ag hnH;
    private int offset;
    private String title;

    public b$a(Context context, String str, long j, int i, int i2, String str2, boolean z, ag agVar) {
        this.context = context;
        this.bHt = str;
        this.bHu = j;
        this.offset = i;
        this.fromScene = i2;
        this.title = str2;
        this.bHv = z;
        this.hnH = agVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            dM(false);
        } else if (lVar == null) {
            x.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
            dM(false);
        } else if (lVar.getType() != 1071) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
        } else {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
            ju auP = ((h) lVar).auP();
            if (auP == null || auP.jQF == null) {
                x.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                dM(false);
                return;
            }
            x.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[]{auP.rlo});
            Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
            intent.putExtra("addContactScene", 35);
            intent.putExtra("fromScene", this.fromScene);
            intent.putExtra("keyword", this.bHt);
            intent.putExtra("businessType", this.bHu);
            intent.putExtra("offset", this.offset);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.title);
            intent.putExtra("showEditText", this.bHv);
            try {
                intent.putExtra("result", auP.toByteArray());
                if (!(this.context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                dM(true);
            } catch (Throwable e) {
                dM(false);
                x.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
            }
        }
    }

    private void dM(boolean z) {
        g.DF().b(1071, this);
        if (this.hnH != null && this.hnH.bHr.bHw != null) {
            this.hnH.bHs.bHx = z;
            this.hnH.bHr.bHw.run();
        }
    }
}
