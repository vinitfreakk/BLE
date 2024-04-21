package com.accidentaldeveloper.esp32_ble



import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.LeScanCallback
import android.bluetooth.BluetoothAdapter.getDefaultAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.accidentaldeveloper.esp32_ble.R
import java.util.UUID
import kotlin.math.log

@SuppressLint("MissingPermission")
class MainActivity : AppCompatActivity() {
    private lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //service
         val bluethootManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
         bluetoothAdapter = bluethootManager.adapter

        bluetoothAdapter.startLeScan(LeScanCallback{deviceName,rssi,scanRecord->
            if(deviceName.equals("vinit")){
                Log.d("","$deviceName")
                Log.d("","$rssi")
                Log.d("","$scanRecord")
            }


        })

    }
    
}

