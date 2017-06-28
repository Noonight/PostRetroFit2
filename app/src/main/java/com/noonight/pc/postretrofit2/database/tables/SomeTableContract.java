package com.noonight.pc.postretrofit2.database.tables;

import android.provider.BaseColumns;

/**
 * Created by ayur on 26.06.2017.
 */

public class SomeTableContract {
    public static abstract class SomeTable implements BaseColumns {
        public static final String TABLE_NAME = "sometable";
        public static final String COLUMN_NAME_NUMBER = "number";
        public static final String COLUMN_NAME_TEXT = "text";
    }
}
