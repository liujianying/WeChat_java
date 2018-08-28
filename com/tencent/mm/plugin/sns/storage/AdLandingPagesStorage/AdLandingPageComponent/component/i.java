package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    protected int backgroundColor;
    protected View contentView = null;
    public Context context;
    private long grJ = 0;
    protected int hmV;
    protected int hmW;
    protected s nDt;
    private int nDu = 0;
    private long nDv = 0;
    boolean nDw = false;
    protected ViewGroup nDx;

    public i(Context context, s sVar, ViewGroup viewGroup) {
        this.context = context;
        this.nDt = sVar;
        this.nDx = viewGroup;
        int[] ee = ad.ee(context);
        this.hmV = ee[0];
        this.hmW = ee[1];
    }

    public void a(s sVar) {
        s sVar2 = this.nDt;
        if (sVar2 != sVar) {
            if (sVar2 == null || !sVar2.equals(sVar)) {
                this.nDt = sVar;
                bzQ();
                bzK();
            }
        }
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        if (this.contentView != null) {
            return this.contentView;
        }
        if (this.contentView == null) {
            int layout = getLayout();
            if (layout != Integer.MAX_VALUE) {
                this.contentView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(layout, this.nDx, false);
            } else {
                this.contentView = bzR();
                if (this.contentView != null && this.contentView.getLayoutParams() == null) {
                    this.nDx.addView(this.contentView);
                    LayoutParams layoutParams = this.contentView.getLayoutParams();
                    this.nDx.removeView(this.contentView);
                    this.contentView.setLayoutParams(layoutParams);
                }
            }
            if (this.contentView == null) {
                throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
            }
        }
        bzM();
        bzE();
        bzQ();
        bzK();
        return this.contentView;
    }

    public final s bzT() {
        return this.nDt;
    }

    public void bzE() {
    }

    public View bzM() {
        return this.contentView;
    }

    protected void bzQ() {
        x.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    }

    protected int getLayout() {
        return Integer.MAX_VALUE;
    }

    protected View bzR() {
        return null;
    }

    public void bzA() {
        if (!this.nDw) {
            this.nDw = true;
            this.nDv = System.currentTimeMillis();
            this.nDu++;
        }
    }

    public void bzB() {
        if (this.nDw) {
            this.nDw = false;
            if (this.nDv > 0) {
                this.grJ += System.currentTimeMillis() - this.nDv;
            }
            this.nDv = 0;
        }
    }

    public void W(int i, int i2, int i3) {
    }

    public void bzz() {
        bzB();
    }

    public final String bzU() {
        return this.nDt.nAW;
    }

    public boolean r(JSONArray jSONArray) {
        return false;
    }

    public boolean aa(JSONObject jSONObject) {
        if (this.grJ == 0 || this.nDt.nBj) {
            return false;
        }
        try {
            jSONObject.put("cid", this.nDt.nAW);
            jSONObject.put("exposureCount", this.nDu);
            jSONObject.put("stayTime", this.grJ);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected void bzK() {
        ij(false);
    }

    protected final void ij(boolean z) {
        if (this.contentView == null) {
            throw new IllegalStateException("set field contentView first");
        } else if (this.nDt != null) {
            LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams != null) {
                if (this.nDt.nBc != 2.14748365E9f) {
                    layoutParams.width = (int) this.nDt.nBc;
                }
                if (this.nDt.nBd != 2.14748365E9f) {
                    layoutParams.height = (int) this.nDt.nBd;
                }
                if (z && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).setMargins((int) this.nDt.nBa, (int) this.nDt.nAY, (int) this.nDt.nBb, (int) this.nDt.nAZ);
                }
                int gravity;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    } else {
                        layoutParams2.gravity = -1;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams3.gravity = gravity;
                    } else {
                        layoutParams3.gravity = -1;
                    }
                }
                this.contentView.setLayoutParams(layoutParams);
                return;
            }
            x.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.nDx);
        }
    }

    private int getGravity() {
        int i = 0;
        switch (this.nDt.nBg) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 16;
                break;
            case 2:
                i = 80;
                break;
        }
        switch (this.nDt.nBh) {
            case 0:
                return i | 3;
            case 1:
                return i | 1;
            case 2:
                return i | 5;
            default:
                return i;
        }
    }

    public void N(Map<String, Object> map) {
    }

    public void bzV() {
    }
}
