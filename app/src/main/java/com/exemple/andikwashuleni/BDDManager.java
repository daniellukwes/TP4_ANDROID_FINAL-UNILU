//package com.exemple.andikwashuleni;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.Date;
//
//public class BDDManager extends SQLiteOpenHelper ({
//    private static final  String DATABASE_NAME = "Shule.db";
//    private static final int DATABASE_VERSION = 1;
//
//    public  BDDManager ( Context context){
//        super (context, DATABASE_NAME, null, DATABASE_VERSION );
//
//    }
//    @Override
//    public  void onCreate(SQLiteDatabase db){
//        String strSql = " create table T_Etudiant("
//        +"   idEtudiant integer primary key autoincriment,"
//                +" nom text not null,"
//                +" postnom text not null,"
//                +" prenom text not null,"
//               +" numerotel integer not null,"
//                +" sexe text not null,"
//                +" when_ integer not null,"
//                +" )";
//        db.execSQL(strSql);
//        Log.i ("DATABASE", "onCreate invoked");
//
//    }
//    @Override
//    public void onUpgrateDatabase (SQLiteDatabase db, int oldVersion, int newVersion){
////            String strSql = "alter table T_Etudiant add colonn ....";
//            String strSql = "drop table T_Etudiant";
//            db.execSQL(strSql);
//            this.onCreate(db);
//            Log.i("DATABASE", "onUpgrate invoked");
//    }
//    public void insertEtudiant( String nom, String postnom, String prenom, int numerotel ){
//        String strSql = "insert T_Etudiant (nom, postnom, prenom, numerotel, when_) values('"
//                + nom+ "', "+postnom+","+prenom+","+numerotel+"," + new Date().getTime()+")";
//        this.getWritableDatabase().execSQL(strSql);
//        Log.i("DATABASE", "insertEtudiant invoked");
//
//    }
//})
