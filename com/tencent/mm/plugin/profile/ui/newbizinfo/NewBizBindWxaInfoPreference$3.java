package com.tencent.mm.plugin.profile.ui.newbizinfo;

class NewBizBindWxaInfoPreference$3 implements Runnable {
    final /* synthetic */ boolean gBk;
    final /* synthetic */ NewBizBindWxaInfoPreference lYw;

    NewBizBindWxaInfoPreference$3(NewBizBindWxaInfoPreference newBizBindWxaInfoPreference, boolean z) {
        this.lYw = newBizBindWxaInfoPreference;
        this.gBk = z;
    }

    public final void run() {
        if (this.gBk && NewBizBindWxaInfoPreference.c(this.lYw) != null) {
            NewBizBindWxaInfoPreference.c(this.lYw).aoU();
        }
    }
}
