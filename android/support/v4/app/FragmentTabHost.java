package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<a> hk = new ArrayList();
    private int mContainerId;
    private Context mContext;
    private OnTabChangeListener oB;
    private a oC;
    private boolean oD;
    private m ou;

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.oB = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        q qVar = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hk.size()) {
                break;
            }
            a aVar = (a) this.hk.get(i2);
            aVar.nd = this.ou.J(aVar.tag);
            if (!(aVar.nd == null || aVar.nd.isDetached())) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.oC = aVar;
                } else {
                    if (qVar == null) {
                        qVar = this.ou.bk();
                    }
                    qVar.c(aVar.nd);
                }
            }
            i = i2 + 1;
        }
        this.oD = true;
        q a = a(currentTabTag, qVar);
        if (a != null) {
            a.commit();
            this.ou.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.oD = false;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.oE = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.oE);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.oD) {
            q a = a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.oB != null) {
            this.oB.onTabChanged(str);
        }
    }

    private q a(String str, q qVar) {
        a aVar = null;
        int i = 0;
        while (i < this.hk.size()) {
            a aVar2 = (a) this.hk.get(i);
            if (!aVar2.tag.equals(str)) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.oC != aVar) {
            if (qVar == null) {
                qVar = this.ou.bk();
            }
            if (!(this.oC == null || this.oC.nd == null)) {
                qVar.c(this.oC.nd);
            }
            if (aVar != null) {
                if (aVar.nd == null) {
                    aVar.nd = Fragment.instantiate(this.mContext, aVar.oF.getName(), aVar.oG);
                    qVar.a(this.mContainerId, aVar.nd, aVar.tag);
                } else {
                    qVar.d(aVar.nd);
                }
            }
            this.oC = aVar;
        }
        return qVar;
    }
}
