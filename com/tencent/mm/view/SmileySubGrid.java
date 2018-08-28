package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.n.a$c;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import java.io.InputStream;

public class SmileySubGrid extends SmileyGrid {
    private int OT;
    int QC;
    private int Qo;
    Rect Qx = new Rect();
    int VS;
    private int fW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    float inM;
    float inN;
    private WindowManager inU;
    private LayoutParams isj;
    private int isl;
    private int ism;
    private boolean isn;
    private PopEmojiView isq;
    private ag mHandler = new ag();
    private LayoutInflater mLayoutInflater;
    int ttn = 6;
    public volatile int uTA = -1;
    public volatile boolean uTB = false;
    public boolean uTC = true;
    private final Object uTD = new Object();
    int uTq = -1;
    boolean uTr;
    private c uTs;
    private int uTt;
    private a uTu;
    private b uTv;
    private View uTw;
    private int uTx;
    private String uTy;
    private boolean uTz = false;

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayoutInflater = LayoutInflater.from(context);
        this.inU = (WindowManager) context.getSystemService("window");
        this.isq = new PopEmojiView(getContext());
        this.isj = new LayoutParams(-1, -1, 2, 8, 1);
        this.uTx = context.getResources().getDimensionPixelSize(a$c.emoji_preview_image_size);
        this.isj.width = this.uTx;
        this.isj.height = this.uTx;
        this.isj.gravity = 17;
        this.Qo = getLongTouchTime();
        this.uTt = ViewConfiguration.getPressedStateDuration();
        this.OT = getResources().getConfiguration().orientation;
        if (this.OT == 2) {
            this.isl = this.inU.getDefaultDisplay().getHeight();
            this.ism = this.inU.getDefaultDisplay().getWidth();
            return;
        }
        this.isl = this.inU.getDefaultDisplay().getWidth();
        this.ism = this.inU.getDefaultDisplay().getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.uTC) {
            int action = motionEvent.getAction();
            View view = null;
            int i;
            switch (action) {
                case 0:
                    action = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.inM = (float) action;
                    this.inN = (float) y;
                    action = pointToPosition(action, y);
                    if (action >= 0 && getAdapter().isEnabled(action)) {
                        this.VS = 0;
                    }
                    if (action >= 0) {
                        this.uTq = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                    }
                    if (view != null) {
                        view.setPressed(true);
                        view.setSelected(true);
                        dW(view);
                    }
                    if (this.uTu == null) {
                        this.uTu = new a(this, (byte) 0);
                    }
                    this.uTu.czn();
                    this.QC = action;
                    if (getSmileyType() == 25 && this.gKM == 0 && action == 0) {
                        return true;
                    }
                    this.mHandler.postDelayed(this.uTu, (long) this.Qo);
                    return true;
                case 1:
                case 3:
                    i = this.QC;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.VS != -1) {
                        if (this.uTv == null) {
                            this.uTv = new b(this, (byte) 0);
                        }
                        b bVar = this.uTv;
                        bVar.uTF = childAt;
                        bVar.uux = i;
                        bVar.czn();
                        this.mHandler.post(bVar);
                    }
                    this.mHandler.removeCallbacks(this.uTu);
                    setScrollEnable(true);
                    cCd();
                    if (this.uTq >= 0) {
                        view = getChildAt(this.uTq - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            dW(view);
                        }
                    }
                    this.ttn = 6;
                    return true;
                case 2:
                    i = (int) motionEvent.getX();
                    action = (int) motionEvent.getY();
                    if (this.ttn == 5) {
                        i = pointToPosition(i, action);
                        this.QC = i;
                        if ((i < 0 || (getSmileyType() == 25 && i == 0 && this.gKM == 0)) && !this.uTz) {
                            cCd();
                            if (this.uTq >= 0) {
                                view = getChildAt(this.uTq - getFirstVisiblePosition());
                                if (view != null) {
                                    view.setPressed(false);
                                    view.setSelected(false);
                                    dW(view);
                                }
                            }
                        } else if (this.uTq != i) {
                            this.uTq = i;
                            view = getChildAt(i - getFirstVisiblePosition());
                            layoutChildren();
                            if (view != null) {
                                view.setPressed(true);
                                view.setSelected(true);
                                dW(view);
                                R(view, this.uTq);
                            }
                        }
                        this.mHandler.removeCallbacks(this.uTu);
                        return true;
                    }
                    if (Math.abs(this.inM - ((float) i)) > ((float) this.fW)) {
                        this.VS = -1;
                        this.mHandler.removeCallbacks(this.uTu);
                    }
                    cCd();
                    return true;
                default:
                    return true;
            }
        }
        cCd();
        return super.onTouchEvent(motionEvent);
    }

    private void R(View view, int i) {
        boolean z = i == this.uTA && this.isq.isShown();
        if (z) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[]{Integer.valueOf(i)});
        } else {
            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[]{Integer.valueOf(i)});
            EmojiInfo emojiInfo = (EmojiInfo) getAdapter().getItem(i);
            if (this.uTs == null) {
                this.uTs = new c(this, (byte) 0);
            }
            r(emojiInfo);
            this.isq.setBackgroundResource(d.emo_relatedword_bg);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (this.OT == 1) {
                this.isj.x = (iArr[0] - ((this.isl - view.getMeasuredWidth()) / 2)) + 0;
                this.isj.y = ((iArr[1] - (this.ism / 2)) - view.getMeasuredHeight()) + 0;
            } else {
                this.isj.x = (iArr[0] - ((this.ism - view.getMeasuredWidth()) / 2)) + 0;
                this.isj.y = ((iArr[1] - (this.isl / 2)) - view.getMeasuredHeight()) + 0;
            }
            if (this.isn) {
                this.inU.updateViewLayout(this.isq, this.isj);
            } else {
                this.uTB = true;
                this.mHandler.postDelayed(this.uTs, (long) this.uTt);
            }
        }
        this.uTA = i;
    }

    private void cCd() {
        if (this.uTs != null) {
            this.mHandler.removeCallbacks(this.uTs);
        }
        if (this.isn) {
            this.inU.removeView(this.isq);
            this.isn = false;
            this.uTB = false;
        }
        this.uTy = "";
    }

    public void setViewParent(View view) {
        this.uTw = view;
    }

    private void dW(View view) {
        Rect rect = this.Qx;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.Qx.set(rect.left - getPaddingLeft(), rect.top - getPaddingTop(), rect.right + getPaddingRight(), rect.bottom + getPaddingBottom());
        boolean z = this.uTr;
        if (view.isEnabled() != z) {
            this.uTr = !z;
            refreshDrawableState();
        }
    }

    public void setScrollEnable(boolean z) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[]{Boolean.valueOf(z)});
        if (this.uTw == null) {
            return;
        }
        if (this.uTw instanceof MMFlipper) {
            ((MMFlipper) this.uTw).setScrollEnable(z);
        } else if (this.uTw instanceof CustomViewPager) {
            ((CustomViewPager) this.uTw).setCanSlide(z);
        }
    }

    private static int getSkewingX$3c7ec8d0() {
        return 0;
    }

    public int getSkewingY$3c7ec8d0() {
        return 0;
    }

    public int getLongTouchTime() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public void setIsShowPopWin(boolean z) {
        this.uTC = z;
    }

    public final void r(EmojiInfo emojiInfo) {
        Object obj = 1;
        synchronized (this.uTD) {
            if (this.isq == null) {
                x.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
            } else if (emojiInfo == null) {
                this.isq.Cq(a.qOb);
                x.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji is null. set null");
            } else if (!emojiInfo.Xh().equals(this.uTy)) {
                this.isq.Cq(a.qOc);
                this.uTy = emojiInfo.Xh();
                if (!(emojiInfo.field_catalog == EmojiGroupInfo.tcz && (emojiInfo.field_content.equals(String.valueOf(EmojiInfo.tcG)) || emojiInfo.field_content.equals(String.valueOf(EmojiInfo.tcF))))) {
                    obj = null;
                }
                if (obj != null) {
                    x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji drawable name is %s", new Object[]{emojiInfo.getName().split("\\.")[0]});
                    this.isq.setImageResource(getResources().getIdentifier(r0, "drawable", ad.getPackageName()));
                } else {
                    PopEmojiView popEmojiView;
                    if (emojiInfo.cny()) {
                        popEmojiView = this.isq;
                        InputStream bt = EmojiInfo.bt(ad.getContext(), emojiInfo.getName());
                        String name = emojiInfo.getName();
                        if (popEmojiView.qNY != null) {
                            popEmojiView.qNY.a(bt, name);
                        }
                    } else {
                        this.isq.setEmojiInfo(emojiInfo);
                    }
                    popEmojiView = this.isq;
                    if (popEmojiView.qNY != null) {
                        popEmojiView.qNY.resume();
                    }
                }
            }
        }
    }

    public final void release() {
        super.release();
        cCd();
        if (this.isq != null) {
            this.isq = null;
        }
    }

    public void setFromDetail(boolean z) {
        this.uTz = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cCd();
    }
}
