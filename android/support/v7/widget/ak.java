package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.p;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class ak extends p implements OnClickListener {
    private final WeakHashMap<String, ConstantState> UA;
    private final SearchView UL;
    private final SearchableInfo Uu;
    private int VA = -1;
    private int VB = -1;
    private int VC = -1;
    private int VD = -1;
    private final SearchManager Vt = ((SearchManager) this.mContext.getSystemService("search"));
    private final Context Vu;
    private final int Vv;
    int Vw = 1;
    private ColorStateList Vx;
    private int Vy = -1;
    private int Vz = -1;
    private boolean mClosed = false;

    public ak(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.UL = searchView;
        this.Uu = searchableInfo;
        this.Vv = searchView.getSuggestionCommitIconResId();
        this.Vu = context;
        this.UA = weakHashMap;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.UL.getVisibility() != 0 || this.UL.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor;
            SearchableInfo searchableInfo = this.Uu;
            if (searchableInfo == null) {
                cursor = null;
            } else {
                String suggestAuthority = searchableInfo.getSuggestAuthority();
                if (suggestAuthority == null) {
                    cursor = null;
                } else {
                    String[] strArr;
                    Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                    String suggestPath = searchableInfo.getSuggestPath();
                    if (suggestPath != null) {
                        fragment.appendEncodedPath(suggestPath);
                    }
                    fragment.appendPath("search_suggest_query");
                    suggestPath = searchableInfo.getSuggestSelection();
                    if (suggestPath != null) {
                        strArr = new String[]{charSequence2};
                    } else {
                        fragment.appendPath(charSequence2);
                        strArr = null;
                    }
                    fragment.appendQueryParameter("limit", "50");
                    cursor = this.mContext.getContentResolver().query(fragment.build(), null, suggestPath, strArr, null);
                }
            }
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c(this.yV);
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        c(this.yV);
    }

    private static void c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public final void changeCursor(Cursor cursor) {
        if (!this.mClosed) {
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    this.Vy = cursor.getColumnIndex("suggest_text_1");
                    this.Vz = cursor.getColumnIndex("suggest_text_2");
                    this.VA = cursor.getColumnIndex("suggest_text_2_url");
                    this.VB = cursor.getColumnIndex("suggest_icon_1");
                    this.VC = cursor.getColumnIndex("suggest_icon_2");
                    this.VD = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception e) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(f.edit_query)).setImageResource(this.Vv);
        return newView;
    }

    public final void a(View view, Cursor cursor) {
        Drawable drawable = null;
        a aVar = (a) view.getTag();
        int i;
        if (this.VD != -1) {
            i = cursor.getInt(this.VD);
        } else {
            i = 0;
        }
        if (aVar.VE != null) {
            a(aVar.VE, a(cursor, this.Vy));
        }
        if (aVar.VF != null) {
            CharSequence charSequence;
            CharSequence a = a(cursor, this.VA);
            if (a != null) {
                if (this.Vx == null) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(a.textColorSearchUrl, typedValue, true);
                    this.Vx = this.mContext.getResources().getColorStateList(typedValue.resourceId);
                }
                CharSequence spannableString = new SpannableString(a);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.Vx, null), 0, a.length(), 33);
                charSequence = spannableString;
            } else {
                charSequence = a(cursor, this.Vz);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (aVar.VE != null) {
                    aVar.VE.setSingleLine(false);
                    aVar.VE.setMaxLines(2);
                }
            } else if (aVar.VE != null) {
                aVar.VE.setSingleLine(true);
                aVar.VE.setMaxLines(1);
            }
            a(aVar.VF, charSequence);
        }
        if (aVar.VG != null) {
            Drawable drawable2;
            ImageView imageView = aVar.VG;
            if (this.VB == -1) {
                drawable2 = null;
            } else {
                drawable2 = Q(cursor.getString(this.VB));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.Uu.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.UA.containsKey(flattenToShortString)) {
                        ConstantState constantState = (ConstantState) this.UA.get(flattenToShortString);
                        drawable2 = constantState == null ? null : constantState.newDrawable(this.Vu.getResources());
                    } else {
                        Drawable activityIcon = getActivityIcon(searchActivity);
                        this.UA.put(flattenToShortString, activityIcon == null ? null : activityIcon.getConstantState());
                        drawable2 = activityIcon;
                    }
                    if (drawable2 == null) {
                        drawable2 = this.mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            a(imageView, drawable2, 4);
        }
        if (aVar.VH != null) {
            ImageView imageView2 = aVar.VH;
            if (this.VC != -1) {
                drawable = Q(cursor.getString(this.VC));
            }
            a(imageView2, drawable, 8);
        }
        if (this.Vw == 2 || (this.Vw == 1 && (i & 1) != 0)) {
            aVar.VI.setVisibility(0);
            aVar.VI.setTag(aVar.VE.getText());
            aVar.VI.setOnClickListener(this);
            return;
        }
        aVar.VI.setVisibility(8);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.UL.setQuery((CharSequence) tag);
        }
    }

    private static void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private static void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.Uu.shouldRewriteQueryFromData()) {
            a = a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.Uu.shouldRewriteQueryFromText()) {
            return null;
        }
        a = a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            View newView = newView(this.mContext, this.yV, viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).VE.setText(e.toString());
            }
            return newView;
        }
    }

    private Drawable Q(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable R;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.Vu.getPackageName() + "/" + parseInt;
            R = R(str2);
            if (R != null) {
                return R;
            }
            R = android.support.v4.content.a.f(this.Vu, parseInt);
            a(str2, R);
            return R;
        } catch (NumberFormatException e) {
            R = R(str);
            if (R != null) {
                return R;
            }
            R = c(Uri.parse(str));
            a(str, R);
            return R;
        } catch (NotFoundException e2) {
            return null;
        }
    }

    private Drawable c(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return d(uri);
            }
            openInputStream = this.Vu.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e) {
                new StringBuilder("Error closing icon stream for ").append(uri);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            new StringBuilder("Icon not found: ").append(uri).append(", ").append(e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e4) {
                new StringBuilder("Error closing icon stream for ").append(uri);
            }
        }
    }

    private Drawable R(String str) {
        ConstantState constantState = (ConstantState) this.UA.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.UA.put(str, drawable.getConstantState());
        }
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            new StringBuilder("Invalid icon resource ").append(iconResource).append(" for ").append(componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            e.toString();
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        String str = null;
        if (i == -1) {
            return str;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            return str;
        }
    }

    private Drawable d(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }
}
