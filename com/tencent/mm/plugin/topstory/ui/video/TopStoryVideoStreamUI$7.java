package com.tencent.mm.plugin.topstory.ui.video;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class TopStoryVideoStreamUI$7 implements OnCheckedChangeListener {
    final /* synthetic */ TopStoryVideoStreamUI oBa;

    TopStoryVideoStreamUI$7(TopStoryVideoStreamUI topStoryVideoStreamUI) {
        this.oBa = topStoryVideoStreamUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int intValue = ((Integer) compoundButton.getTag()).intValue();
        if (TopStoryVideoStreamUI.f(this.oBa).contains(Integer.valueOf(intValue))) {
            TopStoryVideoStreamUI.f(this.oBa).remove(intValue);
        } else {
            TopStoryVideoStreamUI.f(this.oBa).add(Integer.valueOf(intValue));
        }
    }
}
