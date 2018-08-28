package com.tencent.mm.plugin.luckymoney.ui;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mm.plugin.luckymoney.b.f;

class LuckyMoneyDetailUI$6 implements OnLoadCompleteListener {
    final /* synthetic */ f kUy;
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$6(LuckyMoneyDetailUI luckyMoneyDetailUI, f fVar) {
        this.kVo = luckyMoneyDetailUI;
        this.kUy = fVar;
    }

    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        if (i2 != 0) {
            return;
        }
        if (i == LuckyMoneyDetailUI.s(this.kVo)[0]) {
            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (i == LuckyMoneyDetailUI.s(this.kVo)[1] && this.kUy.cfh >= 19000) {
            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}
