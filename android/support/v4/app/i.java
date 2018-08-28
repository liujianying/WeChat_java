package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class i extends Fragment implements OnCancelListener, OnDismissListener {
    int no = 0;
    int np = 0;
    boolean nq = true;
    public boolean nr = true;
    int ns = -1;
    Dialog nt;
    boolean nu;
    boolean nv;
    boolean nw;

    public void a(m mVar, String str) {
        this.nv = false;
        this.nw = true;
        q bk = mVar.bk();
        bk.a((Fragment) this, str);
        bk.commit();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.nw) {
            this.nv = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.nw && !this.nv) {
            this.nv = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nr = this.mContainerId == 0;
        if (bundle != null) {
            this.no = bundle.getInt("android:style", 0);
            this.np = bundle.getInt("android:theme", 0);
            this.nq = bundle.getBoolean("android:cancelable", true);
            this.nr = bundle.getBoolean("android:showsDialog", this.nr);
            this.ns = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.nr) {
            return super.getLayoutInflater(bundle);
        }
        this.nt = bg();
        if (this.nt == null) {
            return (LayoutInflater) this.mHost.mContext.getSystemService("layout_inflater");
        }
        Dialog dialog = this.nt;
        switch (this.no) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.nt.getContext().getSystemService("layout_inflater");
    }

    public Dialog bg() {
        return new Dialog(getActivity(), this.np);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.nu && !this.nv) {
            this.nv = true;
            this.nw = false;
            if (this.nt != null) {
                this.nt.dismiss();
                this.nt = null;
            }
            this.nu = true;
            if (this.ns >= 0) {
                getFragmentManager().S(this.ns);
                this.ns = -1;
                return;
            }
            q bk = getFragmentManager().bk();
            bk.a(this);
            bk.commitAllowingStateLoss();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.nr) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.nt.setContentView(view);
            }
            this.nt.setOwnerActivity(getActivity());
            this.nt.setCancelable(this.nq);
            this.nt.setOnCancelListener(this);
            this.nt.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.nt.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.nt != null) {
            this.nu = false;
            this.nt.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.nt != null) {
            Bundle onSaveInstanceState = this.nt.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.no != 0) {
            bundle.putInt("android:style", this.no);
        }
        if (this.np != 0) {
            bundle.putInt("android:theme", this.np);
        }
        if (!this.nq) {
            bundle.putBoolean("android:cancelable", this.nq);
        }
        if (!this.nr) {
            bundle.putBoolean("android:showsDialog", this.nr);
        }
        if (this.ns != -1) {
            bundle.putInt("android:backStackId", this.ns);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.nt != null) {
            this.nt.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.nt != null) {
            this.nu = true;
            this.nt.dismiss();
            this.nt = null;
        }
    }
}
