package com.carechaincore.impl.shared.storage

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.carechain.R

class DataStorage {

    private var db: CareChainAppDatabase? = null

    companion object {
        private val TAG: String = DataStorage::class.java.simpleName
        @Volatile
        private var sharedInstance: DataStorage? = null

        fun getInstance(): DataStorage {
            if (sharedInstance == null) sharedInstance = DataStorage()

            return sharedInstance as DataStorage
        }
    }


    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            CareChainAppDatabase::class.java,
            context.getString(R.string.db_name)
        )
            .addMigrations()
            .fallbackToDestructiveMigration()
            .build()

        db!!.openHelper.writableDatabase
        if (!db!!.isOpen) {
            Log.e(TAG, "Database start error!")
            return
        }

        Log.d(TAG, "Database Started!")
    }

    fun getDatabase(): CareChainAppDatabase? {
        return db
    }
}