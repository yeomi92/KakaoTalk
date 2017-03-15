package com.hanbit.kakaotalk.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by hb2008 on 2017-03-15.
 */

public abstract class ReadQuery extends QueryFactory{
    SQLiteOpenHelper helper;
    public ReadQuery(Context context) {
        super(context);
        helper=new DatabaseHelper(context);
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return helper.getReadableDatabase();
    }

    public abstract List<?> list(String sql);
}