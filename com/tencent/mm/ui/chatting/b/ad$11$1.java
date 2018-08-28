package com.tencent.mm.ui.chatting.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.ad.11;
import com.tencent.mm.ui.g.a;

class ad$11$1 implements Runnable {
    final /* synthetic */ 11 tRK;

    ad$11$1(11 11) {
        this.tRK = 11;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SearchComponent", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", new Object[]{Long.valueOf(this.tRK.val$position), Integer.valueOf(this.tRK.gIO)});
        this.tRK.tRG.bAG.EV(this.tRK.gIO);
        if (this.tRK.tRG.tRE && !this.tRK.tRG.tRt) {
            new ag().postDelayed(new Runnable(this.tRK.gIO, this.tRK.val$position) {
                public final void run() {
                    int firstVisiblePosition = r5 - ad.this.bAG.getFirstVisiblePosition();
                    View childAt = ad.this.bAG.getChildAt(firstVisiblePosition);
                    View childAt2 = ad.this.bAG.getChildAt(firstVisiblePosition + ad.this.bAG.getHeaderViewsCount());
                    au.HU();
                    bd dW = c.FT().dW(r6);
                    View view = null;
                    if (childAt != null) {
                        if (dW.ckA() || dW.cmj()) {
                            view = childAt.findViewById(R.h.chatting_content_iv);
                        } else if (dW.cmk()) {
                            view = childAt.findViewById(R.h.image);
                        } else if (dW.cmo()) {
                            view = childAt.findViewById(R.h.chatting_appmsg_thumb_iv);
                        }
                        if (view == null && childAt2 != null) {
                            if (dW.ckA() || dW.cmj()) {
                                view = childAt2.findViewById(R.h.chatting_content_iv);
                            } else if (dW.cmk()) {
                                view = childAt2.findViewById(R.h.image);
                            }
                        }
                        if (view != null) {
                            a.b(ad.this.bAG.tTq.getContext(), view);
                        }
                    }
                }
            }, 200);
            au.HU();
            c.DT().a(aa.a.sSm, Boolean.valueOf(false));
        }
    }
}
