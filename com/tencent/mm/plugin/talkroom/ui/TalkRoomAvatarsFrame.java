package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMHorList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private final int kFB = a.fromDPToPix(null, 58);
    private String kFP;
    private ag mHandler;
    private MMHorList oxA;
    private a oxB;
    private al oxC;
    private final int oxy = 2000;
    private final int oxz = 5;

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.i.talk_room_avatar_frame, this);
        this.oxA = (MMHorList) findViewById(R.h.hor_list);
        this.oxA.setOverScrollEnabled(true);
        this.oxA.setCenterInParent(true);
        this.oxA.setItemWidth(this.kFB);
        this.oxB = new a(getContext());
        this.oxA.setAdapter(this.oxB);
        this.mHandler = new ag(Looper.getMainLooper());
        this.oxA.setHorListLitener(new 1(this));
        this.oxC = new al(new 2(this), false);
    }

    public void setMembersList(List<String> list) {
        if (this.oxB != null) {
            a aVar = this.oxB;
            if (list == null) {
                aVar.oxF.clear();
            } else {
                aVar.oxF = list;
            }
            aVar.notifyDataSetChanged();
        }
    }

    public void setCurMemeber(String str) {
        if (this.oxA != null) {
            if (!bi.oW(this.kFP) || !bi.oW(str)) {
                if (bi.oW(this.kFP) || !this.kFP.equals(str)) {
                    this.kFP = str;
                    aYT();
                }
            }
        }
    }

    private void aYT() {
        this.oxB.kFP = this.kFP;
        if (bi.oW(this.kFP)) {
            this.oxB.notifyDataSetChanged();
        } else if (!this.oxA.getIsTouching()) {
            a aVar = this.oxB;
            int indexOf = aVar.oxF.indexOf(this.kFP) * this.kFB;
            int currentPosition = this.oxA.getCurrentPosition();
            if (indexOf < currentPosition) {
                this.oxA.En(indexOf);
            } else if (indexOf > currentPosition + (this.kFB * 4)) {
                this.oxA.En(indexOf - (this.kFB * 4));
            } else {
                this.oxB.notifyDataSetChanged();
            }
        }
    }
}
