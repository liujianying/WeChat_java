package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements a {
    private LayoutInflater Bc;
    private TextView Dm;
    private RadioButton HP;
    private CheckBox HQ;
    private TextView HR;
    private Drawable HS;
    private Context HT;
    private boolean HU;
    private int HV;
    private boolean HW;
    private h bl;
    private int bt;
    private ImageView ii;
    private Context mContext;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.MenuView, i, 0);
        this.HS = obtainStyledAttributes.getDrawable(k.MenuView_android_itemBackground);
        this.bt = obtainStyledAttributes.getResourceId(k.MenuView_android_itemTextAppearance, -1);
        this.HU = obtainStyledAttributes.getBoolean(k.MenuView_preserveIconSpacing, false);
        this.HT = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.HS);
        this.Dm = (TextView) findViewById(f.title);
        if (this.bt != -1) {
            this.Dm.setTextAppearance(this.HT, this.bt);
        }
        this.HR = (TextView) findViewById(f.shortcut);
    }

    public final void a(h hVar) {
        int i = 0;
        this.bl = hVar;
        this.HV = 0;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.a((a) this));
        setCheckable(hVar.isCheckable());
        boolean dT = hVar.dT();
        hVar.dS();
        if (!(dT && this.bl.dT())) {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.HR;
            char dS = this.bl.dS();
            if (dS == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(h.IL);
                switch (dS) {
                    case 8:
                        stringBuilder.append(h.IN);
                        break;
                    case 10:
                        stringBuilder.append(h.IM);
                        break;
                    case ' ':
                        stringBuilder.append(h.IO);
                        break;
                    default:
                        stringBuilder.append(dS);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.HR.getVisibility() != i) {
            this.HR.setVisibility(i);
        }
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.HW = z;
        this.HU = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Dm.setText(charSequence);
            if (this.Dm.getVisibility() != 0) {
                this.Dm.setVisibility(0);
            }
        } else if (this.Dm.getVisibility() != 8) {
            this.Dm.setVisibility(8);
        }
    }

    public h getItemData() {
        return this.bl;
    }

    public void setCheckable(boolean z) {
        if (z || this.HP != null || this.HQ != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.bl.dU()) {
                if (this.HP == null) {
                    dD();
                }
                compoundButton = this.HP;
                compoundButton2 = this.HQ;
            } else {
                if (this.HQ == null) {
                    dE();
                }
                compoundButton = this.HQ;
                compoundButton2 = this.HP;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.bl.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.HQ != null) {
                this.HQ.setVisibility(8);
            }
            if (this.HP != null) {
                this.HP.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.bl.dU()) {
            if (this.HP == null) {
                dD();
            }
            compoundButton = this.HP;
        } else {
            if (this.HQ == null) {
                dE();
            }
            compoundButton = this.HQ;
        }
        compoundButton.setChecked(z);
    }

    private void setShortcut$25d965e(boolean z) {
        int i = (z && this.bl.dT()) ? 0 : 8;
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.HR;
            char dS = this.bl.dS();
            if (dS == 0) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(h.IL);
                switch (dS) {
                    case 8:
                        stringBuilder.append(h.IN);
                        break;
                    case 10:
                        stringBuilder.append(h.IM);
                        break;
                    case ' ':
                        stringBuilder.append(h.IO);
                        break;
                    default:
                        stringBuilder.append(dS);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.HR.getVisibility() != i) {
            this.HR.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.bl.bq.It || this.HW;
        if (!z && !this.HU) {
            return;
        }
        if (this.ii != null || drawable != null || this.HU) {
            if (this.ii == null) {
                this.ii = (ImageView) getInflater().inflate(h.abc_list_menu_item_icon, this, false);
                addView(this.ii, 0);
            }
            if (drawable != null || this.HU) {
                ImageView imageView = this.ii;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.ii.getVisibility() != 0) {
                    this.ii.setVisibility(0);
                    return;
                }
                return;
            }
            this.ii.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.ii != null && this.HU) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ii.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void dD() {
        this.HP = (RadioButton) getInflater().inflate(h.abc_list_menu_item_radio, this, false);
        addView(this.HP);
    }

    private void dE() {
        this.HQ = (CheckBox) getInflater().inflate(h.abc_list_menu_item_checkbox, this, false);
        addView(this.HQ);
    }

    public final boolean M() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.Bc == null) {
            this.Bc = LayoutInflater.from(this.mContext);
        }
        return this.Bc;
    }
}
