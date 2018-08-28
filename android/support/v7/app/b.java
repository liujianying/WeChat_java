package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class b {
    final j CR;
    final Window CS;
    public CharSequence CT;
    public ListView CU;
    public int CV;
    public int CW;
    public int CX;
    public int CY;
    public int CZ;
    public boolean Da = false;
    Button Db;
    CharSequence Dc;
    Message Dd;
    Button De;
    CharSequence Df;
    Message Dg;
    Button Dh;
    CharSequence Di;
    Message Dj;
    NestedScrollView Dk;
    public int Dl = 0;
    TextView Dm;
    public View Dn;
    public ListAdapter Do;
    public int Dp = -1;
    int Dq;
    int Dr;
    public int Ds;
    public int Dt;
    public int Du;
    public int Dv;
    int Dw = 0;
    final OnClickListener Dx = new OnClickListener() {
        public final void onClick(View view) {
            Message obtain;
            if (view == b.this.Db && b.this.Dd != null) {
                obtain = Message.obtain(b.this.Dd);
            } else if (view == b.this.De && b.this.Dg != null) {
                obtain = Message.obtain(b.this.Dg);
            } else if (view != b.this.Dh || b.this.Dj == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(b.this.Dj);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            b.this.mHandler.obtainMessage(1, b.this.CR).sendToTarget();
        }
    };
    public TextView gH;
    public Drawable hh;
    public ImageView ii;
    public final Context mContext;
    Handler mHandler;
    public View mView;
    CharSequence sn;

    /* renamed from: android.support.v7.app.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ View DA;
        final /* synthetic */ View Dz;

        AnonymousClass3(View view, View view2) {
            this.Dz = view;
            this.DA = view2;
        }

        public final void run() {
            b.a(b.this.Dk, this.Dz, this.DA);
        }
    }

    /* renamed from: android.support.v7.app.b$4 */
    class AnonymousClass4 implements OnScrollListener {
        final /* synthetic */ View DA;
        final /* synthetic */ View Dz;

        AnonymousClass4(View view, View view2) {
            this.Dz = view;
            this.DA = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            b.a(absListView, this.Dz, this.DA);
        }
    }

    /* renamed from: android.support.v7.app.b$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ View DA;
        final /* synthetic */ View Dz;

        AnonymousClass5(View view, View view2) {
            this.Dz = view;
            this.DA = view2;
        }

        public final void run() {
            b.a(b.this.CU, this.Dz, this.DA);
        }
    }

    public static class a {
        public final LayoutInflater Bc;
        public CharSequence CT;
        public int CV;
        public int CW;
        public int CX;
        public int CY;
        public int CZ;
        public int DB = 0;
        public CharSequence DC;
        public DialogInterface.OnClickListener DD;
        public CharSequence DE;
        public DialogInterface.OnClickListener DF;
        public CharSequence DG;
        public DialogInterface.OnClickListener DH;
        public OnCancelListener DI;
        public OnDismissListener DJ;
        public OnKeyListener DK;
        public CharSequence[] DL;
        public DialogInterface.OnClickListener DM;
        public boolean[] DN;
        public boolean DO;
        public boolean DP;
        public OnMultiChoiceClickListener DQ;
        public String DR;
        public String DS;
        public OnItemSelectedListener DT;
        public boolean DU = true;
        public boolean Da = false;
        public int Dl = 0;
        public View Dn;
        public ListAdapter Do;
        public int Dp = -1;
        public Drawable hh;
        public final Context mContext;
        public View mView;
        public boolean nq;
        public CharSequence sn;
        public Cursor yV;

        /* renamed from: android.support.v7.app.b$a$1 */
        class AnonymousClass1 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView DV;

            public AnonymousClass1(Context context, int i, CharSequence[] charSequenceArr, ListView listView) {
                this.DV = listView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (a.this.DN != null && a.this.DN[i]) {
                    this.DV.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.b$a$2 */
        class AnonymousClass2 extends CursorAdapter {
            final /* synthetic */ ListView DV;
            private final int DX;
            private final int DY;
            final /* synthetic */ b DZ;

            public AnonymousClass2(Context context, Cursor cursor, ListView listView, b bVar) {
                this.DV = listView;
                this.DZ = bVar;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.DX = cursor2.getColumnIndexOrThrow(a.this.DR);
                this.DY = cursor2.getColumnIndexOrThrow(a.this.DS);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.DX));
                this.DV.setItemChecked(cursor.getPosition(), cursor.getInt(this.DY) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return a.this.Bc.inflate(this.DZ.Dt, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.b$a$3 */
        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ b DZ;

            public AnonymousClass3(b bVar) {
                this.DZ = bVar;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.this.DM.onClick(this.DZ.CR, i);
                if (!a.this.DP) {
                    this.DZ.CR.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.app.b$a$4 */
        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ ListView DV;
            final /* synthetic */ b DZ;

            public AnonymousClass4(ListView listView, b bVar) {
                this.DV = listView;
                this.DZ = bVar;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.DN != null) {
                    a.this.DN[i] = this.DV.isItemChecked(i);
                }
                a.this.DQ.onClick(this.DZ.CR, i, this.DV.isItemChecked(i));
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.nq = true;
            this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> Ea;

        public b(DialogInterface dialogInterface) {
            this.Ea = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.Ea.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: android.support.v7.app.b$2 */
    class AnonymousClass2 implements android.support.v4.widget.NestedScrollView.b {
        final /* synthetic */ View DA;
        final /* synthetic */ View Dz;

        AnonymousClass2(View view, View view2) {
            this.Dz = view;
            this.DA = view2;
        }

        public final void b(NestedScrollView nestedScrollView) {
            b.a(nestedScrollView, this.Dz, this.DA);
        }
    }

    static /* synthetic */ void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(z.h(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!z.h(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    public b(Context context, j jVar, Window window) {
        this.mContext = context;
        this.CR = jVar;
        this.CS = window;
        this.mHandler = new b(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, k.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.Dq = obtainStyledAttributes.getResourceId(k.AlertDialog_android_layout, 0);
        this.Dr = obtainStyledAttributes.getResourceId(k.AlertDialog_buttonPanelSideLayout, 0);
        this.Ds = obtainStyledAttributes.getResourceId(k.AlertDialog_listLayout, 0);
        this.Dt = obtainStyledAttributes.getResourceId(k.AlertDialog_multiChoiceItemLayout, 0);
        this.Du = obtainStyledAttributes.getResourceId(k.AlertDialog_singleChoiceItemLayout, 0);
        this.Dv = obtainStyledAttributes.getResourceId(k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        jVar.dm();
    }

    static boolean aH(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (aH(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        if (this.Dm != null) {
            this.Dm.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.Di = charSequence;
                this.Dj = message;
                return;
            case -2:
                this.Df = charSequence;
                this.Dg = message;
                return;
            case -1:
                this.Dc = charSequence;
                this.Dd = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.hh = null;
        this.Dl = i;
        if (this.ii == null) {
            return;
        }
        if (i != 0) {
            this.ii.setVisibility(0);
            this.ii.setImageResource(this.Dl);
            return;
        }
        this.ii.setVisibility(8);
    }

    static ViewGroup b(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }
}
