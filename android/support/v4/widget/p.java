package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class p extends e {
    private int Ba;
    private int Bb;
    private LayoutInflater Bc;

    public p(Context context, int i) {
        super(context);
        this.Bb = i;
        this.Ba = i;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Bc.inflate(this.Ba, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Bc.inflate(this.Bb, viewGroup, false);
    }
}
