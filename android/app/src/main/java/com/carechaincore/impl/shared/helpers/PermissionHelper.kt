package com.carechaincore.impl.shared.helpers

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object PermissionHelper {

    fun hasPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun hasLocationPermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) ||
                hasPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    fun hasBluetoothPermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.BLUETOOTH) &&
                hasPermission(context, Manifest.permission.BLUETOOTH_ADMIN)
    }
}