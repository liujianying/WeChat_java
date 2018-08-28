package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.util.LinkedList;

class SnsCommentDetailUI$22 implements OnAttachStateChangeListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    boolean nUV = false;
    final /* synthetic */ bsu nUW;
    final /* synthetic */ LinkedList nUX;

    SnsCommentDetailUI$22(SnsCommentDetailUI snsCommentDetailUI, bsu bsu, n nVar, LinkedList linkedList) {
        this.nUO = snsCommentDetailUI;
        this.nUW = bsu;
        this.nMf = nVar;
        this.nUX = linkedList;
    }

    public final void onViewAttachedToWindow(View view) {
        x.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[]{Boolean.valueOf(this.nUV)});
        if (this.nUV) {
            this.nUV = false;
            if (this.nUW != null && this.nMf != null && this.nUO.nUK != null) {
                ar z = SnsCommentDetailUI.z(this.nUO);
                PhotosContent photosContent = this.nUO.nUK;
                bsu bsu = this.nUW;
                String bBe = this.nMf.bBe();
                SnsCommentDetailUI.x(this.nUO);
                int hashCode = this.nUO.hashCode();
                int y = SnsCommentDetailUI.y(this.nUO);
                this.nMf.xb(32);
                z.a(photosContent, bsu, bBe, hashCode, y, -1, false, av.tbt, this.nUX);
            }
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        x.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
        this.nUV = true;
    }
}
