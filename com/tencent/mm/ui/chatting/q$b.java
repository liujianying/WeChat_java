package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ai.b;
import com.tencent.mm.ui.chatting.q.a;
import com.tencent.mm.ui.chatting.viewitems.au;

public class q$b implements OnClickListener, OnTouchListener, b {
    private View FU;
    private al eOf;
    private int gwO;
    private int tJA;
    private int tJB;
    private boolean tJC;
    private a tJD = new a();
    private OnTouchListener tJE = new 1(this);
    private View tJF;
    private int tJG = 300;
    private al.a tJH = new 2(this);
    private o tJu;
    private View tJv;
    private View tJw;
    private int tJx;
    private int tJy;
    private int tJz;

    private void dismiss() {
        if (this.tJu != null) {
            this.tJu.dismiss();
        }
    }

    public final boolean e(View view, MotionEvent motionEvent) {
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof au)) {
            x.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
            return false;
        }
        boolean z;
        au auVar = (au) view.getTag();
        String str = auVar.userName;
        String GF = q.GF();
        if (ai.oW(GF) || GF.equals(str)) {
            x.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        Context context = view.getContext();
        if (this.tJu == null) {
            Resources resources = context.getResources();
            this.tJx = (int) ((resources.getDimension(R.f.BasicPaddingSize) * 2.0f) + resources.getDimension(R.f.MiniAvatarSize));
            this.FU = View.inflate(context, R.i.chatting_item_avatar_faster_entrance, null);
            this.tJv = this.FU.findViewById(R.h.video);
            this.tJw = this.FU.findViewById(R.h.audio);
            this.tJw.setOnClickListener(this);
            this.tJv.setOnClickListener(this);
            this.tJw.setOnTouchListener(this.tJE);
            this.tJv.setOnTouchListener(this.tJE);
            this.tJu = new o(this.FU, -2, this.tJx, false);
            this.tJu.setOutsideTouchable(true);
            Rect rect = new Rect();
            if (context instanceof Activity) {
                ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            }
            this.gwO = rect.top;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.tJy = context.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
            } else {
                this.tJy = context.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
            }
            this.tJu.setBackgroundDrawable(new ColorDrawable(16777215));
            this.tJB = 0;
            this.eOf = new al(Looper.getMainLooper(), this.tJH, false);
            x.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
        o oVar = this.tJu;
        switch (motionEvent.getAction()) {
            case 9:
                this.tJF = view;
                view.setOnTouchListener(this);
                if (oVar.isShowing()) {
                    oVar.dismiss();
                }
                if (!this.tJC) {
                    this.tJw.setTag(auVar);
                    this.tJv.setTag(auVar);
                    this.tJw.setVisibility(0);
                    this.tJv.setVisibility(8);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i = iArr[1];
                    view.getWidth();
                    int height = view.getHeight();
                    this.tJA = this.tJB;
                    if (i > (this.gwO + this.tJy) + this.tJx) {
                        this.tJA = ((-height) - this.tJx) - this.tJB;
                    }
                    this.tJz = 0;
                    if (this.tJA >= 0) {
                        this.FU.setBackgroundResource(R.g.chatting_fast_entrance_win_bottom);
                    } else {
                        this.FU.setBackgroundResource(R.g.chatting_fast_entrance_win_top);
                    }
                    long j = (long) this.tJG;
                    this.eOf.J(j, j);
                    break;
                }
                break;
            case 10:
                this.tJC = false;
                this.tJF = null;
                break;
        }
        return true;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.tJC = true;
                break;
            case 3:
                break;
        }
        dismiss();
        return false;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        if (view == this.tJw) {
            q.q(view.getContext(), auVar.userName, 3);
        } else {
            q.q(view.getContext(), auVar.userName, 2);
        }
        dismiss();
    }
}
