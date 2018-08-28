package com.tencent.sqlitelint;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.sqlitelint.d.d;

public class SQLiteLintIssue implements Parcelable {
    public static final Creator<SQLiteLintIssue> CREATOR = new Creator<SQLiteLintIssue>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SQLiteLintIssue(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SQLiteLintIssue[i];
        }
    };
    public static final int ERROR = 4;
    public static final int PASS = 0;
    public static final int SUGGESTION = 2;
    public static final int TIPS = 1;
    public static final int WARNING = 3;
    public String advice;
    public long createTime;
    public String dbPath;
    public String desc;
    public String detail;
    public String extInfo;
    public String id;
    public boolean isNew;
    public int level;
    public String sql;
    public String table;
    public int type;

    public static String getLevelText(int i, Context context) {
        switch (i) {
            case 1:
                return context.getString(d.diagnosis_level_tips);
            case 2:
                return context.getString(d.diagnosis_level_suggestion);
            case 3:
                return context.getString(d.diagnosis_level_warning);
            case 4:
                return context.getString(d.diagnosis_level_error);
            default:
                return context.getString(d.diagnosis_level_suggestion);
        }
    }

    public SQLiteLintIssue(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, long j, String str8) {
        this.id = str;
        this.dbPath = str2;
        this.level = i;
        this.type = i2;
        this.sql = str3;
        this.table = str4;
        this.desc = str5;
        this.detail = str6;
        this.advice = str7;
        this.createTime = j;
        this.extInfo = str8;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SQLiteLintIssue) {
            return ((SQLiteLintIssue) obj).id.equals(((SQLiteLintIssue) obj).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    protected SQLiteLintIssue(Parcel parcel) {
        this.id = parcel.readString();
        this.dbPath = parcel.readString();
        this.level = parcel.readInt();
        this.type = parcel.readInt();
        this.sql = parcel.readString();
        this.table = parcel.readString();
        this.desc = parcel.readString();
        this.detail = parcel.readString();
        this.advice = parcel.readString();
        this.createTime = parcel.readLong();
        this.extInfo = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.dbPath);
        parcel.writeInt(this.level);
        parcel.writeInt(this.type);
        parcel.writeString(this.sql);
        parcel.writeString(this.table);
        parcel.writeString(this.desc);
        parcel.writeString(this.detail);
        parcel.writeString(this.advice);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.extInfo);
    }
}
