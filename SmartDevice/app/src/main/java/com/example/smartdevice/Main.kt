package com.example.smartdevice

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")

    }

    fun decreaseVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun previousChannel(){
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }


}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    private fun checkDeviceStatus(device: SmartDevice): Boolean{
        return device.deviceStatus == "on"
    }

    fun turnOnTv() {
        if(!checkDeviceStatus(smartTvDevice)){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }

    }

    fun turnOffTv() {
        if(checkDeviceStatus(smartTvDevice)){
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseTvVolume() {
        if(checkDeviceStatus(smartTvDevice)){
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun changeTvChannelToNext() {
        if(checkDeviceStatus(smartTvDevice)){
            smartTvDevice.nextChannel()
        }
    }

    fun turnOnLight() {
        if(!checkDeviceStatus(smartLightDevice)){
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if(checkDeviceStatus(smartLightDevice)){
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if(checkDeviceStatus(smartLightDevice)){
            smartLightDevice.increaseBrightness()
        }
    }

    fun turnOffAllDevices() {
        if(checkDeviceStatus(smartTvDevice) && checkDeviceStatus(smartLightDevice)){
            turnOffTv()
            turnOffLight()
        }
    }
    //endees
    fun decreaseTvVolume(){
        if(checkDeviceStatus(smartTvDevice)){
            smartTvDevice.decreaseVolume()
        }
    }

    fun changeTvChannelToPrevious(){
        if(checkDeviceStatus(smartTvDevice)){
            smartTvDevice.previousChannel()
        }
    }

    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo(){
        smartLightDevice.printDeviceInfo()
    }

    fun decreaseLightBrightness(){
        smartLightDevice.decreaseBrightness()
    }
}



class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartDevice = SmartTvDevice("Android TV", "Entertainment")
    // smartDevice.turnOn()

    val smartLight = SmartLightDevice("Google Light", "Utility")
    // smartDevice.turnOn()

    val smartHome = SmartHome(smartDevice, smartLight)
    smartHome.turnOnTv()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()

    smartHome.turnOnLight()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.printSmartLightInfo()

    smartHome.turnOffAllDevices()
}