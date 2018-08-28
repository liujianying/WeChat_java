package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.h.7;

class h$7$1 implements Runnable {
    final /* synthetic */ String igt;
    final /* synthetic */ Bitmap tiK;
    final /* synthetic */ 7 tiL;

    h$7$1(7 7, String str, Bitmap bitmap) {
        this.tiL = 7;
        this.igt = str;
        this.tiK = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.FindMoreFriendsUI", "download url " + this.igt + " , result " + (this.tiK == null));
        IconPreference iconPreference = (IconPreference) this.tiL.tiG.tig.ZZ("jd_market_entrance");
        if (iconPreference != null) {
            if (this.igt.equals(this.tiL.tiG.til)) {
                iconPreference.drawable = new BitmapDrawable(this.tiL.tiG.getContext().getResources(), this.tiK);
                this.tiL.tiG.til = null;
            } else if (this.igt.equals(this.tiL.tiG.tiq)) {
                iconPreference.V(this.tiK);
                this.tiL.tiG.tiq = null;
            }
            this.tiL.tiG.tig.notifyDataSetChanged();
        }
        if (this.igt.equals(this.tiL.tiG.tim)) {
            ((IconPreference) this.tiL.tiG.tig.ZZ("find_friends_by_look")).drawable = new BitmapDrawable(this.tiL.tiG.getContext().getResources(), this.tiK);
            this.tiL.tiG.tim = null;
            this.tiL.tiG.tig.notifyDataSetChanged();
        }
        if (this.igt.equals(this.tiL.tiG.tin)) {
            ((IconPreference) this.tiL.tiG.tig.ZZ("find_friends_by_search")).drawable = new BitmapDrawable(this.tiL.tiG.getContext().getResources(), this.tiK);
            this.tiL.tiG.tin = null;
            this.tiL.tiG.tig.notifyDataSetChanged();
        }
        if (this.igt.equals(this.tiL.tiG.tio)) {
            ((IconPreference) this.tiL.tiG.tig.ZZ("find_friends_by_look")).V(this.tiK);
            this.tiL.tiG.tio = null;
            this.tiL.tiG.tig.notifyDataSetChanged();
        }
    }
}
