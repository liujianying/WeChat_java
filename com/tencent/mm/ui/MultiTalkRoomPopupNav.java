package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ax.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    public LinearLayout toK;
    public View toL;
    private TextView toM;
    private TextView toN;
    private TextView toO;
    public String toP;
    public String toQ;
    private boolean toR;
    private int toS = b.tpc;
    public a toT;
    private final int toU = 6;
    public LinearLayout toV;
    public boolean toW = false;
    private f toX = new f();

    static /* synthetic */ void ZT(String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        a.qyi.HK(str);
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!a.qyi.HI(str)) {
            x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:" + str);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        h hVar;
        Object[] objArr;
        if (multiTalkRoomPopupNav.toP == null || multiTalkRoomPopupNav.toQ == null) {
            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.toP + ",currentSenderUserName:" + multiTalkRoomPopupNav.toQ);
        } else if (!multiTalkRoomPopupNav.toP.toLowerCase().endsWith("@chatroom") || multiTalkRoomPopupNav.toR) {
            String str = multiTalkRoomPopupNav.toP;
            if (a.qyi == null || !a.qyi.HC(str)) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                com.tencent.mm.ui.base.h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.multitalk_system_slave_finish_exit_msg), null, true);
                multiTalkRoomPopupNav.cqM();
                hVar = h.mEJ;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.toP;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar.h(13945, objArr);
                return;
            }
            List HE = a.qyi.HE(str);
            if (HE.size() == 0) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                com.tencent.mm.ui.base.h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.multitalk_system_slave_finish_exit_msg), null, true);
                multiTalkRoomPopupNav.cqM();
                hVar = h.mEJ;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.toP;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar.h(13945, objArr);
                return;
            }
            if (HE.size() == 1) {
                x.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            String string;
            List k;
            if (multiTalkRoomPopupNav.toS == b.tpb) {
                multiTalkRoomPopupNav.toW = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                hVar = h.mEJ;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = multiTalkRoomPopupNav.toP;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar.h(13945, objArr);
            } else if (multiTalkRoomPopupNav.toS == b.tpa) {
                if (a.qyi.dM(str, multiTalkRoomPopupNav.toQ) != null) {
                    string = ad.getContext().getString(R.l.enter_multitalk_tips, new Object[]{a.qyi.gT(a.qyi.dM(str, multiTalkRoomPopupNav.toQ))});
                    k = k(HE, multiTalkRoomPopupNav.toQ);
                    HE.size();
                    multiTalkRoomPopupNav.c(string, k, str);
                }
                hVar = h.mEJ;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = multiTalkRoomPopupNav.toP;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar.h(13945, objArr);
            } else if (a.qyi.bgA()) {
                com.tencent.mm.ui.base.h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.multitalk_is_talking_cannot_enter), null, true);
                hVar = h.mEJ;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.toP;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar.h(13945, objArr);
            } else if (HE.size() >= 9) {
                com.tencent.mm.ui.base.h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[]{Integer.valueOf(9)}), null, true);
                h hVar2 = h.mEJ;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(4);
                if (multiTalkRoomPopupNav.toS == b.tpa) {
                    i = 1;
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = Integer.valueOf(1);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = multiTalkRoomPopupNav.toP;
                objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
                objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
                hVar2.h(13945, objArr2);
            } else {
                string = ad.getContext().getString(R.l.multitalk_whether_enter);
                k = k(HE, "");
                HE.size();
                multiTalkRoomPopupNav.c(string, k, str);
                h.mEJ.h(13945, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.toP, Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId), Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey)});
            }
        } else {
            com.tencent.mm.ui.base.h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.multitalk_room_kicked_tip), null, true);
            multiTalkRoomPopupNav.cqM();
            a.qyi.jy(multiTalkRoomPopupNav.toP);
            hVar = h.mEJ;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = multiTalkRoomPopupNav.toP;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
            hVar.h(13945, objArr);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:" + str);
        h hVar;
        Object[] objArr;
        if (a.qyi.HJ(str)) {
            a.qyi.HH(str);
            hVar = h.mEJ;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.toP;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
            hVar.h(13945, objArr);
            return;
        }
        x.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!" + str);
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_error_300), 0).show();
        hVar = h.mEJ;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.toS == b.tpa ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.toP;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.toX.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.toX.field_roomKey);
        hVar.h(13945, objArr);
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void setGroupUserName(String str) {
        this.toP = str;
    }

    public void setCurrentSenderUserName(String str) {
        this.toQ = str;
    }

    public void setInChatRoom(boolean z) {
        this.toR = z;
    }

    public void setMultiTalkInfo(f fVar) {
        this.toX = fVar;
    }

    private void initView() {
        inflate(getContext(), R.i.multitalk_room_popup_nav, this);
        this.toK = (LinearLayout) findViewById(R.h.multitalk_nav_layout);
        this.toL = findViewById(R.h.multitalk_nav_bg);
        this.toM = (TextView) findViewById(R.h.multitalk_tv_nav_content);
        this.toN = (TextView) findViewById(R.h.multitalk_tv_nav_content2);
        this.toO = (TextView) findViewById(R.h.multitalk_tv_nav_inviting);
        this.toV = (LinearLayout) findViewById(R.h.multitalk_image_list_layout);
        this.toK.setOnClickListener(new 1(this));
    }

    public void setUserTalkingStatus$b292420(int i) {
        this.toS = i;
    }

    private void setTalkingBannerStyle(String str) {
        this.toL.setBackgroundResource(R.g.multitalk_talking_banner_shape);
        this.toM.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_green_text_color));
        this.toM.setText(str);
        this.toM.setVisibility(0);
        this.toO.setVisibility(8);
        this.toN.setVisibility(8);
    }

    public void setInvitingBannerStyle(String str) {
        this.toL.setBackgroundResource(R.g.multitalk_talking_banner_shape);
        this.toN.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
        this.toN.setText(str);
        this.toM.setVisibility(8);
        this.toO.setVisibility(0);
        this.toN.setVisibility(0);
        this.toV.setVisibility(8);
    }

    public void setDefaultBannerStyle(String str) {
        this.toL.setBackgroundResource(R.g.multitalk_default_banner_shape);
        this.toM.setTextColor(getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
        this.toM.setText(str);
        if (this.toV == null || this.toV.getVisibility() != 0) {
            this.toM.setVisibility(0);
            this.toO.setVisibility(8);
            this.toN.setVisibility(8);
            this.toV.setVisibility(8);
        }
    }

    public final void cqM() {
        this.toW = false;
        setVisibility(8);
        if (this.toT != null) {
            a.a(this.toT);
        }
    }

    private void c(String str, List<String> list, String str2) {
        boolean z;
        this.toL.setVisibility(8);
        this.toK.setVisibility(8);
        if (this.toS == b.tpa) {
            z = true;
        } else {
            z = false;
        }
        this.toT = new a(this, z, (byte) 0);
        if (a.qyi != null) {
            a aVar = this.toT;
            2 2 = new 2(this, str2);
            3 3 = new 3(this, str2);
            aVar.titleView.setText(str);
            aVar.toZ.setVisibility(0);
            aVar.toY.toV.setVisibility(0);
            aVar.toY.toV.removeAllViews();
            for (String str3 : list) {
                View imageView = new ImageView(aVar.toY.getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 26), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                aVar.toY.toV.addView(imageView);
                b.a(imageView, str3, 0.1f, false);
            }
            ((Button) aVar.toY.findViewById(R.h.multitalk_alert_enter_btn)).setOnClickListener(2);
            ((Button) aVar.toY.findViewById(R.h.multitalk_alert_cancel_btn)).setOnClickListener(3);
        }
    }

    public final void dw(List<String> list) {
        if (this.toV != null && this.toV.getVisibility() == 0) {
            this.toV.removeAllViews();
            for (String str : list) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 26), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.toV.addView(imageView);
                b.a(imageView, str, 0.1f, false);
            }
        }
    }

    public static List<String> k(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            List list2 = arrayList2;
        }
        for (String str22 : list2) {
            arrayList.add(str22);
        }
        return arrayList;
    }
}
